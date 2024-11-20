package jeu.cartes.parades;

import jeu.cartes.Carte;
import jeu.cartes.parades.Parade;
import jeu.joueurs.Joueur;

public class Essence extends Parade {
    @Override
    public boolean peutEtrePoseeSurMonJeu(Joueur j) {
        return j.estPossiblePoser(this) ;
    }

    @Override
    public Carte clone() {
        return new Essence();
    }

}
