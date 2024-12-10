package jeu.joueurs;

import jeu.Jeu;

public class JoueurHumain extends Joueur {
    public JoueurHumain(Jeu jeu, String nom) {
        super(jeu, nom);
    }

    public  boolean estHumain(){
        return true  ;
    }
}
