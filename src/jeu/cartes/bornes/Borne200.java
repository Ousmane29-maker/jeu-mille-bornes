package jeu.cartes.bornes;

import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public class Borne200 extends  Bornes{
    public Borne200(){
        super(200);
    }
    @Override
    public boolean peutEtrePoseeSurMonJeu(Joueur j) {
        assert (j != null) : "le parametre j ne doit pas etre null" ;
        return j.estPossiblePoser(this);
    }

    @Override
    public Carte copie() {
        return new Borne200();
    }

}