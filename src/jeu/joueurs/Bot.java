package jeu.joueurs;

import jeu.Jeu;

public class Bot extends  Joueur{
    public Bot(Jeu jeu, String nom) {
        super(jeu, nom);
    }
    public boolean estBot(){
        return true ;
    }
}
