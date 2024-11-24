package jeu.cartes.parades;

import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public class RoueDeSecours extends Parade {
    @Override
    public boolean peutEtrePoseeSurMonJeu(Joueur j) {
        return j.estPossiblePoser(this) ;
    }

    @Override
    public Carte clone() {
        return new RoueDeSecours();
    }

    @Override
    public boolean match(String s) {
        return s.equals("RoueDeSecours");
    }
}
