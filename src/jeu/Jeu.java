package jeu;

import jeu.cartes.Carte;
//import jeu.cartes.PaquetDeCartes;
import jeu.cartes.PaquetDeCartes;
import jeu.joueurs.CollectionJoueurs;
import jeu.joueurs.Joueur;

public class Jeu {

    private CollectionJoueurs collection ;

    private int joueurQuiJoue ;

    private int joueurQuiDistribue ;

    private PaquetDeCartes talon ;

    private PaquetDeCartes pioche ;
    public Jeu() {
        this.collection = new CollectionJoueurs(2) ; //nombre de joueur par defaut : 2
        this.pioche = new PaquetDeCartes() ; // A definir apres
        this.talon = new PaquetDeCartes() ;
    }
    public Jeu(Jeu jeu) {
        assert (jeu != null) : "Le parametre jeu ne doit pas etre egale a null" ;

        this.joueurQuiJoue = jeu.joueurQuiJoue ;
        this.joueurQuiDistribue = jeu.joueurQuiDistribue ;

        //copie profonde
        this.talon = new PaquetDeCartes(jeu.talon) ;
        this.pioche = new PaquetDeCartes(jeu.pioche) ;

        this.collection = new CollectionJoueurs(jeu.getNbJoueurs()) ;

        for(int i = 0; i < jeu.getNbJoueurs(); i++){
            Joueur j = jeu.collection.get(i) ;
            Joueur newJ = new Joueur(j) ; // copie d'un joueur
            newJ.setJeu(this); // on modifie son jeu en le remplacant par this(la copie de jeu qu'on est entrain d'effectue)
            this.add(newJ); // on ajoute newJ dans la collection de copie
        }
    }

    public void add(Joueur j) {
        assert(j != null) : "Le parametre j ne doit pas etre egale a null" ;
        this.collection.ajouter(j);
    }

    public int getJoueurQuiJoue() {
        return joueurQuiJoue;
    }


    public int getJoueurQuiDistribue() {
        return joueurQuiDistribue;
    }

    public void setJoueurQuiJoue() {
        this.joueurQuiJoue = (this.joueurQuiJoue + 1) % this.getNbJoueurs();
    }

    public int getNbJoueurs() {
        return this.collection.size();
    }
    public void jeter(Carte c){
        assert (c !=null) : "le parametre c ne doit pas etre egale a null" ; //l'assert est deja fait dans enlever
        this.talon.ajouter(c); // la carte est jetee dans le talon
    }

    public void jouer(String coup){
        assert coupPossible(coup) : "le coup doit etre valide";
        Joueur joueurCourant = getJoueur(joueurQuiJoue) ;
        joueurCourant.jouer(coup) ;

        // c'est ici que l'on doit changer le joueur courant ???
    }

    public boolean coupPossible(String coup){
        Joueur joueurCourant = getJoueur(joueurQuiJoue) ;
        return joueurCourant.coupPossible(coup) ;
    }

    public Joueur getJoueur(int indiceJoueur) {
        return collection.get(indiceJoueur) ;
    }

}
