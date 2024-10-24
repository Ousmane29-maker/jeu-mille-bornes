package jeu.cartes;

import jeu.joueurs.Joueur;

public class PanneDEssence extends Attaque{
    @Override
    public boolean peutEtrePoseeSurMonJeu(Joueur j) {
        assert (j != null) : "le parametre j ne doit pas etre null" ;
        return j.estPossiblePoser(this) ;
    }

    @Override
    public boolean peutEtrePoseeSurJeuAdversaire(Joueur j) {
        assert (j != null) : "le parametre j ne doit pas etre null" ;
        return j.peutRecevoir(this) ;
    }

    @Override
    public boolean match(String s) {
        //A completer
        return false;
    }
}