package jeu.joueurs;

import jeu.Jeu;

public class Bot extends  Joueur{

    private Strategie strategie ;
    public Bot(Jeu jeu, String nom, Strategie strategie) {
        super(jeu, nom);
        this.strategie = strategie ;
    }

    public Bot(Bot j){
        super(j) ;
        // logique propre au Bot
        this.strategie = j.strategie ;
    }
    public Bot clone() {
        return  new Bot((this)) ;
    }

    public boolean estBot(){
        return true ;
    }
    public Strategie getStrategie() {
        return strategie;
    }

    public  void jouer(String coup) {
        coup = strategie.choisirCoup(jeu) ;
        jouerCoup(coup);
    }
}
