package jeu.joueurs;

import jeu.Jeu;

public class StrategieTrivial implements Strategie{

    public StrategieTrivial() {

    }

    @Override
    public String choisirCoup(Jeu jeu) {
       // Strategie trivial : J1
        Joueur joueurCourant = jeu.getJoueurCourant();
        assert (joueurCourant.getNbCartesMain() > 0) : "Le joueurCourant n'a aucune carte en main" ;
        return "J1" ;
    }

    @Override
    public String toString() {
        return "StrategieTrivial";
    }
}
