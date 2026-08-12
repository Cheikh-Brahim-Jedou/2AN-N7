// Time-stamp: <28 oct 2022 09:24 queinnec@enseeiht.fr>

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import Synchro.Assert;

/** Lecteurs/rédacteurs
 * stratégie d'ordonnancement: priorité aux rédacteurs,
 * implantation: avec un moniteur. */
public class LectRed_PrioRedacteur implements LectRed
{
     /* --- état du moniteur --- */
    private final Lock lock;
    private final Condition lecteursOk;
    private final Condition redacteursOk;
    private int nbLecteurs;          // number of active readers
    private boolean ecriture;        // true if a writer is active
    private int attenteRedacteurs;   // number of waiting writers

    public LectRed_PrioRedacteur() {
        // initial state: no readers, no writers
        this.lock = new ReentrantLock();
        this.lecteursOk = lock.newCondition();
        this.redacteursOk = lock.newCondition();
        this.nbLecteurs = 0;
        this.ecriture = false;
        this.attenteRedacteurs = 0;
    }

    public void demanderLecture() throws InterruptedException {
        lock.lock();
        try {
            // readers wait if a writer is active or if writers are waiting (writer priority)
            while (ecriture || attenteRedacteurs > 0) {
                lecteursOk.await();
            }
            nbLecteurs++;
            // basic invariant
            Assert.check(nbLecteurs > 0);
        } finally {
            lock.unlock();
        }
    }

    public void terminerLecture() throws InterruptedException {
        lock.lock();
        try {
            Assert.check(nbLecteurs > 0);
            nbLecteurs--;
            if (nbLecteurs == 0) {
                // prefer writers: wake one waiting writer
                redacteursOk.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void demanderEcriture() throws InterruptedException {
        lock.lock();
        try {
            attenteRedacteurs++;
            try {
                while (ecriture || nbLecteurs > 0) {
                    redacteursOk.await();
                }
            } finally {
                // once awakened and about to write, decrement waiting count
                attenteRedacteurs--;
            }
            ecriture = true;
            // invariant: no readers and a writer active
            Assert.check(nbLecteurs == 0);
            Assert.check(ecriture);
        } finally {
            lock.unlock();
        }
    }

    public void terminerEcriture() throws InterruptedException {
        lock.lock();
        try {
            Assert.check(ecriture);
            ecriture = false;
            // writers priority: if writers are waiting, wake one; otherwise wake all readers
            if (attenteRedacteurs > 0) {
                redacteursOk.signal();
            } else {
                lecteursOk.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public String nomStrategie() {
        return "Stratégie: Priorité Rédacteurs.";
    }

 
}
