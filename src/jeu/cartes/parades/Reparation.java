package jeu.cartes.parades;

import jeu.cartes.Carte;
import jeu.cartes.parades.Parade;
import jeu.joueurs.Joueur;

public class Reparation extends Parade {
    @Override
    public boolean peutEtrePoseeSurMonJeu(Joueur j) {
        return j.estPossiblePoser(this) ;
    }

    @Override
    public Carte clone() {
        return new Reparation();
    }

    @Override
    public boolean match(String s) {
        return s.equals("Reparation");
    }

}
