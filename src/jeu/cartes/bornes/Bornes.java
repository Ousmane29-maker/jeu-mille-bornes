package jeu.cartes.bornes;

import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public class Bornes extends Carte {

    private int kms ;

    public Bornes(int kms) {
        this.kms =kms ;
    }

    public boolean peutEtrePoseeSurMonJeu(Joueur j) {
        assert (j != null) : "le parametre j ne doit pas etre null" ;
        return j.estPossiblePoser(this);
    }

    @Override
    public boolean peutEtrePoseeSurJeuAdversaire(Joueur j) {
        assert (j != null) : "le parametre j ne doit pas etre null" ;
        return false;
    }

    @Override
    public boolean match(String s) {
        return s.equals("Bornes");
    }

    @Override
    public Carte clone() {
        return new Bornes(this.getKms());
    }

    public int getKms() {
        return kms;
    }
}
