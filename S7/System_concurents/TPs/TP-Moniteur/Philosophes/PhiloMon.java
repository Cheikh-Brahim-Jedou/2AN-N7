import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

/* Squelette d'une solution avec un moniteur.
 * Il manque le moniteur (verrou + variables conditions).
 */
public class PhiloMon implements StrategiePhilo {

    // État d'un philosophe : pense, mange, demande ?
    private EtatPhilosophe[] etat;
    private Lock moniteur;
    private Condition[] peutManger;
    private int nbPhilosophes;

    /****************************************************************/

    public PhiloMon (int nbPhilosophes) {
         this.nbPhilosophes = nbPhilosophes;
        this.etat = new EtatPhilosophe[nbPhilosophes];
        this.moniteur = new ReentrantLock();
        this.peutManger = new Condition[nbPhilosophes];
        for (int i = 0; i < nbPhilosophes; i++) {
            etat[i] = EtatPhilosophe.Pense;
            peutManger[i] = moniteur.newCondition();

        }
        /* XXXX */
    }
public void demanderFourchettes(int no) throws InterruptedException {
        moniteur.lock();
        try {
            etat[no] = EtatPhilosophe.Demande;
            
            // Attendre tant qu'on ne peut pas manger (voisins mangent)
            while (!peutManger(no)) {
                peutManger[no].await();
            }
            
            // On peut maintenant manger
            etat[no] = EtatPhilosophe.Mange;
            
            // Mettre à jour l'affichage des fourchettes
            IHMPhilo.poser(Main.FourchetteGauche(no), EtatFourchette.AssietteDroite);
            IHMPhilo.poser(Main.FourchetteDroite(no), EtatFourchette.AssietteGauche);
        } finally {
            moniteur.unlock();
        }
    }

    public void libererFourchettes(int no) {
        moniteur.lock();
        try {
            // Libérer les fourchettes visuellement
            IHMPhilo.poser(Main.FourchetteGauche(no), EtatFourchette.Table);
            IHMPhilo.poser(Main.FourchetteDroite(no), EtatFourchette.Table);
            
            // Changer l'état du philosophe
            etat[no] = EtatPhilosophe.Pense;
            
            // Vérifier si les voisins peuvent maintenant manger
            int gauche = Main.PhiloGauche(no);
            int droite = Main.PhiloDroite(no);
            
            if (etat[gauche] == EtatPhilosophe.Demande && peutManger(gauche)) {
                peutManger[gauche].signal();
            }
            if (etat[droite] == EtatPhilosophe.Demande && peutManger(droite)) {
                peutManger[droite].signal();
            }
        } finally {
            moniteur.unlock();
        }
    }

    // Méthode utilitaire pour vérifier si un philosophe peut manger
    private boolean peutManger(int no) {
        int gauche = Main.PhiloGauche(no);
        int droite = Main.PhiloDroite(no);
        
        // Un philosophe peut manger si aucun de ses deux voisins ne mange
        return etat[gauche] != EtatPhilosophe.Mange && etat[droite] != EtatPhilosophe.Mange;
    }
    public String nom() {
        return "Moniteur";
    }

}

