package jeu.cartes.bottes;

import jeu.cartes.Bottes;
import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public class CiterneDEssence extends Botte{
    public CiterneDEssence() {

    }

    @Override
    public Carte clone() {
        return new CiterneDEssence();
    }


    @Override
    public boolean match(String s) {
        return s.equals("CiterneDEssence");
    }

    @Override
    public String toString() {
        return "CiterneDEssence";
    }


}
