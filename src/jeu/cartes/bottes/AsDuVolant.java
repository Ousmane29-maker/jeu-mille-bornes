package jeu.cartes.bottes;

import jeu.cartes.Bottes;
import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public class AsDuVolant extends Botte{

    @Override
    public Carte clone() {
        return new AsDuVolant();
    }

    @Override
    public void activerBotte(Bottes bottes) {
        bottes.setEstAsDuVolant(); // Active As du Volant
    }


}
