package jeu.cartes.bottes;

import jeu.cartes.Bottes;
import jeu.cartes.Carte;
import jeu.cartes.bornes.Bornes;
import jeu.joueurs.Joueur;

public class AsDuVolant extends Botte{
    public AsDuVolant() {

    }

    @Override
    public Carte clone() {
        return new AsDuVolant();
    }

    @Override
    public boolean match(String s) {
        return s.equals("AsDuVolant");
    }

    @Override
    public String toString() {
        return "AsDuVolant";
    }

}
