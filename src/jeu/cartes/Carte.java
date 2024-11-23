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

    public boolean estUneBorne() {
        return false ;
    }

    public boolean estUneLimitationDeVitesse() {
        return false;
    }
    public boolean estUneFinLimitationDeVitesse() {
        return  false ;
    }

    public boolean estUneBotte() {
        return false ;
    }
    public abstract Carte clone();

    public void activerBotte(Bottes bottes) {
        // Ne fait rien par défaut, sera surchargée par les Bottes et ... oui
    }



}
