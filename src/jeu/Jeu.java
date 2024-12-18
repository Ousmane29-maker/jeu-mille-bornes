package jeu;

import jeu.cartes.Carte;
//import jeu.cartes.PaquetDeCartes;
import jeu.cartes.PaquetDeCartes;
import jeu.fabriques.FabriqueCartes;
import jeu.joueurs.*;

import java.util.Random;

public class Jeu {

    private CollectionJoueurs joueurs;

    private int joueurQuiJoue ;

    private int joueurQuiDistribue ;

    private PaquetDeCartes talon ;

    private PaquetDeCartes pioche ;

    private DialogueLigneDeCommande dialogue ;
    public Jeu() {
        this.joueurs = new CollectionJoueurs(2) ; //nombre de joueur par defaut : 2
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

        this.joueurs = new CollectionJoueurs(jeu.getNbJoueurs()) ;

        for(int i = 0; i < jeu.getNbJoueurs(); i++){
            Joueur j = jeu.joueurs.get(i) ;
            Joueur newJ = j.clone() ; // copie d'un joueur
            newJ.setJeu(this); // on modifie son jeu en le remplacant par this(la copie de jeu qu'on est entrain d'effectue)
            this.add(newJ); // on ajoute newJ dans la collection de copie
        }
    }

    public int getNbBots() {
        int count = 0 ;
        for(Joueur joueur : joueurs){
            if(joueur.estBot()){
                count++ ;
            }
        }
        return count ;
    }

    public void add(Joueur j) {
        assert(j != null) : "Le parametre j ne doit pas etre egale a null" ;
        this.joueurs.ajouter(j);
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

    public void setDialogue(DialogueLigneDeCommande dialogue) {
        this.dialogue = dialogue;
    }


    public int getNbJoueurs() {
        return this.joueurs.size();
    }
    public void jeter(Carte c){
        assert (c !=null) : "le parametre c ne doit pas etre egale a null" ; //l'assert est deja fait dans enlever
        this.talon.ajouter(c); // la carte est jetee dans le talon
    }

    public void jouer(String coup){
        assert coupPossible(coup) : "le coup doit etre valide";
        Joueur joueurCourant = getJoueurCourant() ;
        joueurCourant.jouer(coup) ;

        // c'est ici que l'on doit changer le joueur courant ???
    }

    public boolean coupPossible(String coup){
        Joueur joueurCourant = getJoueurCourant();
        return joueurCourant.coupPossible(coup) ;
    }

    public Joueur getJoueur(int indiceJoueur) {
        return joueurs.get(indiceJoueur) ;
    }

    public Joueur getJoueurCourant() {
        return getJoueur(joueurQuiJoue) ;
    }
    public void initialiser(int nbBots){
        creerJoueurs(nbBots + 1);
        distribuer();
        choisirQuiDistribue(nbBots + 1) ;
        choisirQuiJoue() ;
        dialogue.reagir() ;
    }

    private void choisirQuiJoue() {
        joueurQuiJoue = (joueurQuiDistribue + 1) % getNbJoueurs() ;
    }

    private void choisirQuiDistribue(int nbJoueurs) {
        Random random = new Random() ;
        joueurQuiDistribue = random.nextInt(nbJoueurs); // le joueur qui joue est choisi de maniere aleatoire
    }

    public void distribuer(){
        pioche.ajouter(FabriqueCartes.getPaquetStandard()); // initialisation de la pioche
        pioche.melanger();
        for(int i = 0;  i < 7; i++){
            for (Joueur joueur : joueurs) {
                donnerCarte(joueur);
            }
        }
    }

    public void donnerCarte(Joueur joueur){
        Carte carte = pioche.piocher() ;
        joueur.ajouterMain(carte);
    }
    public void creerJoueurs(int nbJoueurs){
        assert(nbJoueurs >=2 && nbJoueurs <= 5) : "Le nombre de joueurs doit etre dans l'intervalle [2,5]" ;
        Strategie strategie = new StrategieParDefaut() ; //apres on poura avoir plusieur Strategie
        for(int i = 1; i < nbJoueurs; i++){
            add(new Bot(this, "Bot"+1, strategie)) ;
        }
        add(new JoueurHumain(this, "JoueurHumain")) ;
    }



    // A verifier choisirQuiJoue() et ChoisirQuiDistribue()



}
