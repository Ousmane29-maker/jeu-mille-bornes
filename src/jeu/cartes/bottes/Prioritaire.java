package jeu.cartes.bottes;

import jeu.cartes.Bottes;
import jeu.cartes.Carte;
import jeu.cartes.parades.Essence;
import jeu.joueurs.Joueur;

public class Prioritaire extends Botte{

    public Prioritaire() {

    }

    @Override
    public Carte clone() {
        return new Prioritaire();
    }


    @Override
    public boolean match(String s) {
        return s.equals("Prioritaire");
    }

    @Override
    public String toString() {
        return "Prioritaire";
    }
}
