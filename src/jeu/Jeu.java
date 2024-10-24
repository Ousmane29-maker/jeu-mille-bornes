package jeu;

import jeu.cartes.Carte;
//import jeu.cartes.PaquetDeCartes;
import jeu.joueurs.CollectionJoueurs;
import jeu.joueurs.Joueur;

public class Jeu {

    private CollectionJoueurs collection ;

    private Joueur joueurCourant ;

//    private PaquetDeCartes talon ;
    public Jeu() {
        this.collection = new CollectionJoueurs(2) ; //nombre de joueur par defaut : 2
//        this.talon = new PaquetDeCartes() ; //A definir apres
    }
    public Jeu(Jeu jeu) {
        assert (jeu != null) : "Le parametre jeu ne doit pas etre egale a null" ;
        //copie profonde
//        this.talon = new PaquetDeCartes(jeu.talon) ;
        this.collection = new CollectionJoueurs(jeu.getNbJoueurs()) ;

        for(int i = 0; i < jeu.getNbJoueurs(); i++){
            Joueur j = jeu.collection.get(i) ;
            Joueur newJ = new Joueur(j) ; // copie d'un joueur
            newJ.setJeu(this); // on modifie son jeu en le remplacant par this(la copie de jeu qu'on est entrain d'effectue)
            this.add(newJ); // on ajoute newJ dans la collection de copie
//            if(j.estJoueurActuel(){
//                this.joueurCourant = newJ ; //definir newJ comme joueur courant
//            }
        }
    }

    public void add(Joueur j) {
        assert(j != null) : "Le parametre j ne doit pas etre egale a null" ;
        this.collection.ajouter(j);
    }

    public int getNbJoueurs() {
        return this.collection.size();
    }
    public void jeter(Carte c){
        assert (c !=null) : "le parametre c ne doit pas etre egale a null" ; //l'assert est deja fait dans enlever
//        this.talon.enlever(c);
    }
}
