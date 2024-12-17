package jeu.joueurs;

import jeu.Jeu;
import jeu.cartes.Bottes;
import jeu.cartes.Carte;

public class JoueurHumain extends Joueur {
    public JoueurHumain(Jeu jeu, String nom) {
        super(jeu, nom);
    }

    // constructeurs pour les tests
    public JoueurHumain(Jeu jeu, String nom, Bottes bottes, Carte bataille){
        super(jeu, nom, bottes, bataille);
    }

    public boolean estHumain(){
        return true  ;
    }

    public JoueurHumain(JoueurHumain j){
        super(j) ;
        // loqgique propre au joueurs humains
    }
    public JoueurHumain clone() {
        return  new JoueurHumain((this)) ;
    }

}
