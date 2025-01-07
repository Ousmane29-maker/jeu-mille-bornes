package jeu.cartes;

import jeu.joueurs.Joueur;

public abstract class Carte {
    public abstract boolean peutEtrePoseeSurMonJeu(Joueur j);
    public abstract boolean peutEtrePoseeSurJeuAdversaire(Joueur j) ;

    public abstract boolean match(String s) ;

    public abstract Carte clone();

    public boolean estUneAttaque(){
        return false ;
    }

    public boolean estUneParade(){
        return false ;
    }

    public boolean estUneBotte() {
        return false ;
    }

    public abstract String toString() ;

    @Override
    public boolean equals(Object obj) {
        return obj != null && this.getClass() == obj.getClass() ;
    }


    public boolean estUneBorne() {
        return false ;
    }
}
