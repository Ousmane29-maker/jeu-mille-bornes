package jeu.cartes.bornes;

import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public class Borne25 extends Bornes{
    public Borne25(){
        super(25);
    }
    @Override
    public boolean peutEtrePoseeSurMonJeu(Joueur j) {
        assert (j != null) : "le parametre j ne doit pas etre null" ;
        return true;
    }

    @Override
    public Carte copie() {
        return new Borne25();
    }

}
