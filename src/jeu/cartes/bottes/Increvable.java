package jeu.cartes.bottes;

import jeu.cartes.Bottes;
import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public class Increvable extends Botte{

    @Override
    public Carte clone() {
        return new Increvable();
    }

    public Increvable() {

    }

    @Override
    public boolean match(String s) {
        return s.equals("Increvable");
    }


    @Override
    public String toString() {
        return "Increvable";
    }


}
