package jeu.cartes.parades;

import jeu.cartes.parades.Parade;
import jeu.joueurs.Joueur;

public class RoueDeSecours extends Parade {
    @Override
    public boolean peutEtrePoseeSurMonJeu(Joueur j) {
        return j.estPossiblePoser(this) ;
    }

}
