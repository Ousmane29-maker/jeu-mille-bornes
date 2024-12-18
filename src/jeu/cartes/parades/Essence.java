package jeu.cartes.parades;

import jeu.cartes.Carte;
import jeu.cartes.parades.Parade;
import jeu.joueurs.Joueur;

public class Essence extends Parade {

    public Essence() {

    }

    @Override
    public boolean peutEtrePoseeSurMonJeu(Joueur j) {
        return j.estPossiblePoser(this) ;
    }

    @Override
    public Carte clone() {
        return new Essence();
    }

    @Override
    public boolean match(String s) {
        return s.equals("Essence");
    }

    @Override
    public String toString() {
        return "Essence";
    }
}
