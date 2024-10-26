package jeu.cartes.bornes;

import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public class Borne100 extends  Bornes{
    public Borne100(){
        super(100);
    }
    @Override
    public boolean peutEtrePoseeSurMonJeu(Joueur j) {
        assert (j != null) : "le parametre j ne doit pas etre null" ;
        return j.estPossiblePoser(this);
    }

    @Override
    public Carte copie() {
        return new Borne100();
    }
}