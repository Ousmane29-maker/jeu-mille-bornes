package jeu.cartes;

import jeu.joueurs.Joueur;

public abstract class Carte {
    public abstract boolean peutEtrePoseeSurMonJeu(Joueur j);
    public abstract boolean peutEtrePoseeSurJeuAdversaire(Joueur j) ;

    public abstract boolean match(String s) ;

    public boolean estUneAttaque(){
        return false ;
    }

    public boolean estUneParade(){
        return false ;
    }


    public abstract Carte copie();
}
