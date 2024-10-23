package jeu.joueurs;
import jeu.Jeu;
import jeu.cartes.*;

public class Joueur {

    private String nom ;
    private PaquetDeCartes main ;

    private Bottes bottes ;

    private Jeu jeu ;
    public Joueur(Jeu jeu, String nom){
        assert(jeu != null && nom != null) : "Les parametres jeu et nom ne doivent pas etre null" ;
        this.nom = nom ;
        this.jeu = jeu ;
        this.main = new PaquetDeCartes() ;
    }

    public Joueur(Joueur j){
        assert(j != null) :"Le parametre j ne doit pas etre null" ;
        //Pas De Partage ici
        this.nom = j.getNom() ; // copie du nom
        //copie profonde du paquet (en utilisant le constructeur de copie profonde dans PaquetDeCartes)
        this.main = new PaquetDeCartes(j.getMain()) ;
        this.jeu = j.jeu; // Copie uniquement la référence au jeu

    }

    public PaquetDeCartes getMain(){
        return this.main ;
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
        this.jeu = jeu ;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder() ;
        str.append("Joueur{ \n nom = ") ;
        str.append(this.nom) ;
        str.append("\nmain = ");
        str.append(this.main) ;
        str.append("jeu = ");
        str.append(this.jeu) ;
        str.append("} \n") ;

        return str.toString() ;
    }

    // PeutPoser Attaque
    public boolean estPossiblePoser(Crevaison crevaison) {
        return false ;
    }
    public boolean estPossiblePoser(FeuRouge feuRouge) {
        return false ;
    }
    public boolean estPossiblePoser(Accident accident) {
        return false ;
    }
    public boolean estPossiblePoser(PanneDEssence panneDEssence) {
        return false ;
    }

    //peutRecevoir Attaque
    //faut il tester si la bataille est null aussi ?? puisqu'on ne npeut pas avoir deux attaques simultanement ??
    public boolean peutRecevoir(Accident accident) {
        return !bottes.estAsDuVolant() ;
    }

    public boolean peutRecevoir(FeuRouge feuRouge) {
        return !bottes.estPrioritaire() ;
    }

    public boolean peutRecevoir(Crevaison crevaison) {
        return !bottes.estIncrevable();
    }

    public boolean peutRecevoir(PanneDEssence panneDEssence) {
        return !bottes.estCiterneDEssence();
    }
}
