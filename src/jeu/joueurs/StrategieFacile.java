package jeu.joueurs;

import jeu.Jeu;

public class StrategieFacile implements Strategie {

    public StrategieFacile() {}

    @Override
    public String choisirCoup(Jeu jeu) {
        Joueur joueurCourant = jeu.getJoueurCourant();
        String coup = null;

        // Essayer de poser une carte sur son propre jeu
        coup = choisirCoupPi(joueurCourant);

        // Si impossible, essayer de poser une carte sur le jeu des adversaires
        if (coup == null) {
            coup = choisirCoupPij(joueurCourant, jeu.getNbJoueurs());
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

        // Parcourir les cartes de la main
        while (i <= joueurCourant.getNbCartesMain() && coup == null) {
            String tentativeCoup = "P" + i;
            if (joueurCourant.coupPossible(tentativeCoup)) {
                coup = tentativeCoup;
            }
            i++;
        }

        return coup;
    }

    private String choisirCoupPij(Joueur joueurCourant, int nbJoueurs) {
        String coup = null;
        int i = 1;

        // Parcourir les cartes de la main
        while (i <= joueurCourant.getNbCartesMain() && coup == null) {
            int j = 1;

            // Parcourir les joueurs adverses
            while (j <= nbJoueurs && coup == null) {
                if (j != joueurCourant.getId()) { // S'assurer de ne pas jouer sur soi-même
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
