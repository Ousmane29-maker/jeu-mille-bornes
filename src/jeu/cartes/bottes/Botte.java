package jeu.cartes.bottes;

import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public abstract class Botte extends Carte {
    public boolean peutEtrePoseeSurJeuAdversaire(Joueur j) {
        assert (j != null) : "le parametre j ne doit pas etre null" ;
        return false ;
    }

    public boolean peutEtrePoseeSurMonJeu(Joueur j) {
        assert (j != null) : "le parametre j ne doit pas etre null" ;
        return true ;
    }
    @Override
    public boolean match(String s) {
        return false;
    }

    @Override
    public boolean estUneBotte() {
        return true ;
    }
}
