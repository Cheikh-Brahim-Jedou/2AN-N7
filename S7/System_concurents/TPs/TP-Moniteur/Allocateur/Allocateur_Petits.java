// Time-stamp: <28 oct 2022 10:31 queinnec@enseeiht.fr>

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

/** Allocateur de ressources,
 * stratégie d'ordonnancement: priorité aux petits demandeurs,
 *
 * Implantation: moniteur (java 5), une var condition par taille de demande.
 */
public class Allocateur_Petits implements Allocateur {

    // Nombre total de ressources.
    private final int nbRessources;

    // Nombre de ressources actuellement disponibles
    // invariant 0 <= nbLibres <= nbRessources
    private int nbLibres;

    // Protection des variables partagées
    private Lock moniteur;

    // Une condition de blocage par taille de demande
    // tableau [nbRessources+1] dont on n'utilise pas la case 0
    private Condition[] classe; 

    // Le nombre de processus en attente à chaque étage
    // tableau [nbRessources+1] dont on n'utilise pas la case 0
    private int[] tailleClasse;

    /** Initilialise un nouveau gestionnaire de ressources pour nbRessources. */
    public Allocateur_Petits(int nbRessources) {
        this.nbRessources = nbRessources;
        this.nbLibres = nbRessources;
        this.moniteur = new ReentrantLock();
        this.classe = new Condition[nbRessources + 1];
        this.tailleClasse = new int[nbRessources + 1];
        for (int i = 1; i <= nbRessources; i++) {
            classe[i] = moniteur.newCondition();
            tailleClasse[i] = 0;
    }
    }
    /** Demande à obtenir `demande' ressources. */
     public void allouer(int demande) throws InterruptedException {
        moniteur.lock();
        try {
        // L'étudiant se met dans la file correspondante
          tailleClasse[demande]++;  // 🧍 +1 dans la file
        
        // Il attend tant qu'il n'y a pas assez de repas pour lui
          while (demande > nbLibres) {
            classe[demande].await();  // 😴 Il dort dans sa file
             }
        
        // Quand il est réveillé ET il y a assez de repas :
        nbLibres -= demande;          // 🍽️ Il prend ses repas
        tailleClasse[demande]--;      // 🧍 -1 dans la file
        
        } finally {
        moniteur.unlock();
        }
    }

    /** Libère `rendu' ressources. */
    public void liberer(int rendu) throws InterruptedException {
        moniteur.lock();
        try {
            // Libérer les ressources
            nbLibres += rendu;
            // Réveiller les processus en attente, en commençant par les plus petits
            for (int i = 1; i <= nbRessources; i++) {
                while (tailleClasse[i] > 0 && i <= nbLibres) {
                    classe[i].signal();
                    classe[i].await();
                }
            }
        } finally {
            moniteur.unlock();
        }
    }

    /** Chaîne décrivant la stratégie d'allocation. */
    public String nomStrategie()
    {
        return "Priorité aux petits demandeurs";
    }

}
