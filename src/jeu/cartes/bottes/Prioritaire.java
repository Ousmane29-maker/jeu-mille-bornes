package jeu.cartes.bottes;

import jeu.cartes.Carte;
import jeu.cartes.parades.Essence;
import jeu.joueurs.Joueur;

public class Prioritaire extends Botte{

    @Override
    public Carte clone() {
        return new Prioritaire();
    }

}
