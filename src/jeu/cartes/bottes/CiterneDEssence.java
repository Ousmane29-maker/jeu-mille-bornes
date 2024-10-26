package jeu.cartes.bottes;

import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public class CiterneDEssence extends Botte{


    @Override
    public Carte copie() {
        return new CiterneDEssence();
    }

}
