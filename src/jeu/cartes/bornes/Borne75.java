package jeu.cartes.bornes;

import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public class Borne75 extends  Bornes{
    public Borne75(){
        super(75);
    }
    @Override
    public boolean peutEtrePoseeSurMonJeu(Joueur j) {
        assert (j != null) : "le parametre j ne doit pas etre null" ;
        return j.estPossiblePoser(this);
    }

    @Override
    public Carte copie() {
        return new Borne75();
    }
}