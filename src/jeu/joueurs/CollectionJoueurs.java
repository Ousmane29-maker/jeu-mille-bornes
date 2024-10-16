package jeu.joueurs;

import java.util.ArrayList ;

public class CollectionJoueurs {
    ArrayList<Joueur> cj;
    public CollectionJoueurs(int nbJoueurs){
        this.cj = new ArrayList<>(nbJoueurs) ;
        assert (nbJoueurs > 1) : "le nombre de joueur doit etre strictement superieur a 1" ;
    }
    public CollectionJoueurs(CollectionJoueurs cj){
        assert (cj != null) : "Le parametre cj ne doit pas etre null" ;
        //copie profonde
        this.cj = new ArrayList<>(cj.size()) ;
        for(Joueur joueur : cj.cj){
            this.cj.add(new Joueur(joueur));
        }
    }


    public int size() {
        return cj.size() ;
    }

    public void ajouter(Joueur joueur) {
        assert(joueur != null) : "Le joueur passe en parametre ne doit pas etre null" ;
        cj.add(joueur);
    }

    public Joueur get(int no) {
        assert(no >= 0 && no < this.size()) : "Le parametre no doit etre compris entre 0 et size()" ;
        return this.cj.get(no) ;
    }
}
