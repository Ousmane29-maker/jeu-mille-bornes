package jeu.cartes.bottes;

import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public class Increvable extends Botte{

    @Override
    public Carte clone() {
        return new Increvable();
    }

}
