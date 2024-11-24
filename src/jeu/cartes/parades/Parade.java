package jeu.cartes.parades;

import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public abstract class Parade extends Carte {

    public boolean estUneParade(){
        return true ;
    }

    @Override
    public boolean peutEtrePoseeSurJeuAdversaire(Joueur j) {
        assert (j != null) : "le parametre j ne doit pas etre null" ;
        return false;
    }



}
