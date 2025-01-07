package jeu.cartes.attaques;

import jeu.cartes.Carte;
import jeu.cartes.attaques.Attaque;
import jeu.cartes.bottes.AsDuVolant;
import jeu.joueurs.Joueur;

public class PanneDEssence extends Attaque {
    public PanneDEssence() {

    }

    @Override
    public boolean peutEtrePoseeSurJeuAdversaire(Joueur j) {
        assert (j != null) : "le parametre j ne doit pas etre null" ;
        return j.peutRecevoir(this) ;
    }

    @Override
    public boolean match(String s) {
        return s.equals("PanneDEssence");
    }

    @Override
    public Carte clone() {
        return new PanneDEssence();
    }

    @Override
    public String toString() {
        return "PanneDEssence";
    }

}