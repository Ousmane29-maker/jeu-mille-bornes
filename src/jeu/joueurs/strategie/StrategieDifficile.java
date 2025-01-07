package jeu.joueurs.strategie;

import jeu.Jeu;
import jeu.cartes.Carte;
import jeu.cartes.bornes.Bornes;
import jeu.joueurs.Joueur;

import java.util.ArrayList;

public class StrategieDifficile implements Strategie{
    @Override
    public String choisirCoup(Jeu jeu) {
        Joueur joueurCourant = jeu.getJoueurCourant();
        assert (joueurCourant.getNbCartesMain() > 0) : "Le joueurCourant n'a aucune carte en main" ;
        ArrayList<String> coupsPossibles = genererCoupsPossibles(jeu);

        String meilleurCoup = null;
        int meilleureValeur = Integer.MIN_VALUE;

        for (String coup : coupsPossibles) {
            int valeurCoup = evaluerCoup(coup, joueurCourant);
            if (valeurCoup > meilleureValeur) {
                meilleureValeur = valeurCoup;
                meilleurCoup = coup;
            }
        }
        return meilleurCoup;
    }


    private ArrayList<String> genererCoupsPossibles(Jeu jeu) {
        ArrayList<String> coupsPossibles = new ArrayList<>();
        Joueur joueurCourant = jeu.getJoueurCourant(); ;
        for (int i = 1; i <= joueurCourant.getNbCartesMain(); i++) {
            String coupPi = "P" + i;
            if (joueurCourant.coupPossible(coupPi)) {
                coupsPossibles.add(coupPi);
            }
            // Attaquer le joueur en priorité, en commençant par le joueur humain
            int j = jeu.getNbJoueurs() + 1 ;
            while (j >= 1) {
                if ((j-1) != jeu.getJoueurQuiJoue()) {  // Ignorer le joueur courant
                    String coupPij = "P" + i + j;  // Attaque un joueur
                    if (joueurCourant.coupPossible(coupPij)) {
                        coupsPossibles.add(coupPij);
                    }
                }
                j--; // Décrémenter l'index pour attaquer les autres joueurs
            }
            String coupJx = "J" + i;
            if (joueurCourant.coupPossible(coupJx)) {
                coupsPossibles.add(coupJx);
            }
        }
        return coupsPossibles;
    }

    private int evaluerCoup(String coup, Joueur joueurCourant) {
        char action = coup.charAt(0);
        int carteIndex = coup.charAt(1) - '1';
        Carte carte = joueurCourant.getMain().getCarte(carteIndex);
        int valeurCoup = 0;
        switch (action) {
            case 'P':  // Poser
                if (coup.length() == 2) {  // Poser sur son propre jeu
                    if (carte.estUneBorne()) {
                        Bornes bornes = (Bornes) carte;
                        int kmRestants = 1000 - joueurCourant.getBornes();
                        if (bornes.getKms() <= kmRestants) {
                            valeurCoup = bornes.getKms();  // Grandes bornes priorisées
                        }
                    }
                    if (carte.estUneBotte()) valeurCoup = 400;  // Priorité maximale pour les bottes
                    if (carte.estUneParade()) valeurCoup = 300;  // Priorité élevée pour les parades
                } else {  // Poser sur le jeu d'un adversaire
                    valeurCoup = 250;  // Moyenne priorité pour les attaques
                }
                break;

            case 'J':  // Jeter
                int nbOccurence = joueurCourant.getMain().nombreOccurrences(carte) ;
                valeurCoup = nbOccurence >= 2 ? 15 : carte.estUneAttaque() ? 10 : 0 ;
                break ;
        }
        return valeurCoup;  // Coup sans valeur
    }

    @Override
    public String toString() {
        return "StrategieDifficile";
    }



}
