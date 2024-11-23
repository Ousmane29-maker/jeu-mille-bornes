package jeu.cartes;

import jeu.joueurs.Joueur;

public class FinLimitationDeVitesse extends Carte {

    @Override
    public boolean estUneFinLimitationDeVitesse() {
        return true ;
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
        return false;  // Cette carte n'a pas de correspondance particulière avec une chaîne
    }

    @Override
    public Carte clone() {
        return new FinLimitationDeVitesse();
    }
}
