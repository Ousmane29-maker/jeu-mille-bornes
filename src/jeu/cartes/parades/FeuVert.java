package jeu.cartes.parades;

import jeu.cartes.Carte;
import jeu.cartes.parades.Parade;
import jeu.joueurs.Joueur;

public class FeuVert extends Parade {
    public FeuVert() {

    }

    @Override
    public boolean peutEtrePoseeSurMonJeu(Joueur j) {
        return j.estPossiblePoser(this) ;
    }


    @Override
    public Carte clone() {
        return new FeuVert();
    }

    @Override
    public boolean match(String s) {
        return s.equals("FeuVert");
    }

    @Override
    public String toString() {
        return "FeuVert";
    }

}
