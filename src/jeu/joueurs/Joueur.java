package jeu.joueurs;
import jeu.Jeu;
import jeu.cartes.*;
import jeu.cartes.attaques.Accident;
import jeu.cartes.attaques.Crevaison;
import jeu.cartes.attaques.FeuRouge;
import jeu.cartes.attaques.PanneDEssence;
import jeu.cartes.bornes.Bornes;
import jeu.cartes.bottes.AsDuVolant;
import jeu.cartes.bottes.CiterneDEssence;
import jeu.cartes.bottes.Increvable;
import jeu.cartes.bottes.Prioritaire;
import jeu.cartes.parades.Essence;
import jeu.cartes.parades.FeuVert;
import jeu.cartes.parades.Reparation;
import jeu.cartes.parades.RoueDeSecours;

public class Joueur {

    private String nom ;
    private PaquetDeCartes main ;

    private Bottes bottes ;

    private Carte bataille ;

    private Jeu jeu ;
    private boolean limitationVitesse;

    public Joueur(Jeu jeu, String nom){
        assert(jeu != null && nom != null) : "Les parametres jeu et nom ne doivent pas etre null" ;
        this.nom = nom ;
        this.jeu = jeu ;
        this.bottes = new Bottes() ;
        this.bataille = null ;
        this.limitationVitesse = false ;
        this.main = new PaquetDeCartes() ;
    }

    public Joueur(Jeu jeu, String nom, Bottes bottes, Carte bataille){
        assert(jeu != null && nom != null) : "Les parametres jeu et nom ne doivent pas etre null" ;
        this.nom = nom ;
        this.jeu = jeu ;
        this.bottes = bottes;
        this.bataille =  bataille;
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

//    @Override
//    public String toString() {
//        StringBuilder str = new StringBuilder() ;
//        str.append("Joueur{ \n nom = ") ;
//        str.append(this.nom) ;
//        str.append("\nmain = ");
////        str.append(this.main) ;
//        str.append("jeu = ");
//        str.append(this.jeu) ;
//        str.append("} \n") ;
//
//        return str.toString() ;
//    }


    //peutRecevoir Attaque
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

    //estPossiblePoser Parade
    public boolean estPossiblePoser(FeuVert feuVert) {
        return bataille != null && this.bataille.match("FeuRouge") ;
    }

    public boolean estPossiblePoser(Reparation reparation) {
        return bataille != null && this.bataille.match("Accident") ;
    }

    public boolean estPossiblePoser(Essence essence) {
        return bataille != null && this.bataille.match("PanneDEssence") ;
    }
    public boolean estPossiblePoser(RoueDeSecours roueDeSecours) {
        return bataille != null && this.bataille.match("Crevaison") ;
    }

    // estPossiblePoser Botte
    public boolean estPossiblePoser(Increvable increvable) {
        // A completer
        return false ;
    }

    public boolean estPossiblePoser(AsDuVolant asDuVolant) {
        // A completer
        return false ;
    }

    public boolean estPossiblePoser(Prioritaire prioritaire) {
        // A completer
        return false ;
    }
    public boolean estPossiblePoser(CiterneDEssence citerneDEssence) {
        // A completer
        return false ;
    }

//
//    // estPossiblePoser Bornes
//    public boolean estPossiblePoser(Borne200 borne200) {
//        //Important : au cours d’une partie, vous ne pouvez
//        //poser que 2 cartes « 200 » sur votre Zone de Jeu.
//        //A gerer apres gestion de paquets de cartesn, voir y'a combien de cartes de 200 (ca doit etre < 2)
//        return !this.limitationVitesse ;
//    }


    public void setLimitationVitesse() {
        this.limitationVitesse = !this.limitationVitesse ;
    }

    public boolean estPossiblePoser(Bornes bornes) {
        return !this.limitationVitesse || bornes.getKms() <= 50; // a verifier
    }
}
