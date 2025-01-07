package jeu.joueurs.strategie;

import jeu.Jeu;
import jeu.joueurs.Joueur;
import jeu.joueurs.strategie.Strategie;

public class StrategieFacile implements Strategie {

    public StrategieFacile() {}

    @Override
    public String choisirCoup(Jeu jeu) {
        Joueur joueurCourant = jeu.getJoueurCourant();
        assert (joueurCourant.getNbCartesMain() > 0) : "Le joueurCourant n'a aucune carte en main" ;
        String coup;
        // Essayer de poser une carte sur son propre jeu
        coup = choisirCoupPi(joueurCourant);
        // Si impossible, essayer de poser une carte sur le jeu des adversaires
        if (coup == null) {
            coup = choisirCoupPij(joueurCourant, jeu);
        }
        // Si aucun coup n'est trouvé, jeter une carte
        if (coup == null) {
            coup = "J1";
        }
        return coup;
    }

    private String choisirCoupPi(Joueur joueurCourant) {
        String coup = null;
        int i = 1;
        while (i <= joueurCourant.getNbCartesMain() && coup == null) {
            String tentativeCoup = "P" + i;
            if (joueurCourant.coupPossible(tentativeCoup)) {
                coup = tentativeCoup;
            }
            i++;
        }
        return coup;
    }

    private String choisirCoupPij(Joueur joueurCourant, Jeu jeu) {
        String coup = null;
        int i = 1;
        while (i <= joueurCourant.getNbCartesMain() && coup == null) {
            int j = 1;
            while (j <= jeu.getNbJoueurs() && coup == null) {
                // S'assurer de ne pas jouer sur soi-même
                if (j != jeu.getJoueurQuiJoue() + 1) {
                    String tentativeCoup = "P" + i + j;
                    if (joueurCourant.coupPossible(tentativeCoup)) {
                        coup = tentativeCoup;
                    }
                }
                j++;
            }
            i++;
        }
        return coup;
    }
    @Override
    public String toString() {
        return "StrategieFacile";
    }
}
