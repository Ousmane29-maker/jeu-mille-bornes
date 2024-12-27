package jeu.cartes.attaques;

import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public class LimitationDeVitesse extends Carte {


    public LimitationDeVitesse() {

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

    public boolean match(String s) {
        return s.equals("LimitationDeVitesse") ;
    }

    @Override
    public Carte clone() {
        return new LimitationDeVitesse();
    }

    @Override
    public String toString() {
        return "LimitationDeVitesse";
    }
}
