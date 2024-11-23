package jeu.cartes;

import jeu.joueurs.Joueur;

public class LimitationDeVitesse extends Carte {
    @Override
    public boolean estUneLimitationDeVitesse() {
        return true;
    }

    @Override
    public boolean peutEtrePoseeSurMonJeu(Joueur j) {
        assert (j != null) : "le parametre j ne doit pas etre null" ;
        return false;
    }

    @Override
    public boolean peutEtrePoseeSurJeuAdversaire(Joueur j) {
        assert (j != null) : "le parametre j ne doit pas etre null" ;
        return j.peuRecevoir(this) ;
    }

    @Override
    public boolean match(String s) {
        return false;
    }

    @Override
    public Carte clone() {
        return new LimitationDeVitesse();
    }

}
