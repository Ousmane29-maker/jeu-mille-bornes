package jeu.cartes.parades;

import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public class FinLimitationDeVitesse extends Carte {

    public FinLimitationDeVitesse() {

    }

    @Override
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
        return s.equals("FinLimitationDeVitesse") ;
    }

    @Override
    public Carte clone() {
        return new FinLimitationDeVitesse();
    }

    @Override
    public String toString() {
        return "FinLimitationDeVitesse";
    }
}
