package jeu.cartes.bottes;

import jeu.cartes.Bottes;
import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public class Increvable extends Botte{

    @Override
    public Carte clone() {
        return new Increvable();
    }

    @Override
    public void activerBotte(Bottes bottes) {
        bottes.setEstIncrevable(); // Active Increvable
    }

}
