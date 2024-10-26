package jeu.cartes.bornes;

import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public class Borne50 extends  Bornes{
    public Borne50(){
        super(50);
    }
    @Override
    public boolean peutEtrePoseeSurMonJeu(Joueur j) {
        assert (j != null) : "le parametre j ne doit pas etre null" ;
        return true;
    }

    @Override
    public Carte copie() {
        return new Borne50();
    }
}
