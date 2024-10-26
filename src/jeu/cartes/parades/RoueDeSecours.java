package jeu.cartes.parades;

import jeu.cartes.Carte;
import jeu.cartes.bornes.Borne200;
import jeu.cartes.parades.Parade;
import jeu.joueurs.Joueur;

public class RoueDeSecours extends Parade {
    @Override
    public boolean peutEtrePoseeSurMonJeu(Joueur j) {
        return j.estPossiblePoser(this) ;
    }

    @Override
    public Carte copie() {
        return new RoueDeSecours();
    }

}
