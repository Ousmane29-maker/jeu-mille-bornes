package jeu.cartes;

import jeu.joueurs.Joueur;

public class Reparation extends Parade{
    @Override
    public boolean peutEtrePoseeSurMonJeu(Joueur j) {
        return j.estPossiblePoser(this) ;
    }

    @Override
    public boolean peutEtrePoseeSurJeuAdversaire(Joueur j) {
        return j.peutRecevoir(this) ;
    }

    @Override
    public boolean match(String s) {
        //A completer
        return false;
    }
}
