package jeu.cartes.attaques;

import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public abstract class Attaque extends Carte {
    public boolean estUneAttaque(){
        return true ;
    }
    public boolean peutEtrePoseeSurMonJeu(Joueur j) {
        assert (j != null) : "le parametre j ne doit pas etre null" ;
        return false ;
    }

    @Override
    public boolean match(String s) {
        return false;
    }
}
