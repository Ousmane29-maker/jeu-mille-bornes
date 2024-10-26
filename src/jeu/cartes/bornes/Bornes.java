package jeu.cartes.bornes;

import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public abstract class Bornes extends Carte {

    private int kms ;

    public Bornes(int kms) {
        this.kms =kms ;
    }

    @Override
    public boolean peutEtrePoseeSurJeuAdversaire(Joueur j) {
        assert (j != null) : "le parametre j ne doit pas etre null" ;
        return false;
    }

    @Override
    public boolean match(String s) {
        return false;
    }

    public int getKms() {
        return kms;
    }
}
