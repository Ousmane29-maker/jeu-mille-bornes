package jeu.cartes.bottes;

import jeu.cartes.Bottes;
import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public class CiterneDEssence extends Botte{


    @Override
    public Carte clone() {
        return new CiterneDEssence();
    }

    @Override
    public void activerBotte(Bottes bottes) {
        bottes.setEstCiterneDEssence(); // Active Citerne d'Essence
    }

}
