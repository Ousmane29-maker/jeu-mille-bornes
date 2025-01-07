package jeu.cartes.attaques;

import jeu.cartes.Carte;
import jeu.cartes.attaques.Attaque;
import jeu.joueurs.Joueur;

public class Crevaison extends Attaque {
    public Crevaison() {

    }

    @Override
    public boolean peutEtrePoseeSurJeuAdversaire(Joueur j) {
        assert (j != null) : "le parametre j ne doit pas etre null" ;
        return j.peutRecevoir(this) ;
    }

    @Override
    public boolean match(String s) {
        return s.equals("Crevaison");
    }

    @Override
    public Carte clone() {
        return new Crevaison();
    }

    @Override
    public String toString() {
        return "Crevaison";
    }


}
