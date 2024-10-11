package jeu.joueurs;

import jeu.Jeu;
import jeu.cartes.Carte;
import jeu.cartes.PaquetDeCartes;

public class Joueur {

    private String nom ;
    private PaquetDeCartes main ;

    public Joueur(Jeu jeu, String nom){
        assert(jeu != null && nom != null) : "Les parametres jeu et nom ne doivent pas etre null" ;
        this.nom = nom ;
        this.main = new PaquetDeCartes() ;
    }

    public int getNbCartesMain(){
        return this.main.getNbCartes() ;
    }
    public String getNom() {
        return nom;
    }

    public void ajouterMain(Carte carte){
        assert(carte != null) : " La carte ne doit pas etre null" ;
        this.main.ajouter(carte);
    }

    public void retirerMain(Carte carte){
        assert(carte != null) : " La carte ne doit pas etre null" ;
        this.main.enlever(carte);
    }

    public void setJeu(Jeu jeu) {
        assert (jeu != null) : "Le parametre jeu ne doit pas etre null " ;
    }
}
