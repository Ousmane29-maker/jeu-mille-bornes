package jeu.cartes;

import jeu.joueurs.Joueur;

public abstract class Carte {
    public abstract boolean peutEtrePoseeSurMonJeu(Joueur j);
    public abstract boolean peutEtrePoseeSurJeuAdversaire(Joueur j) ;

    public abstract boolean match(String s) ;

    boolean estUneAttaque(){
        return false ;
    }

    boolean estUneParade(){
        return false ;
    }


}
