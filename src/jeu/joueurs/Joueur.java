package jeu.joueurs;
import jeu.Jeu;
import jeu.cartes.Carte;
import jeu.cartes.PaquetDeCartes;

public class Joueur {

    private String nom ;
    private PaquetDeCartes main ;

    private Jeu jeu ;
    public Joueur(Jeu jeu, String nom){
        assert(jeu != null && nom != null) : "Les parametres jeu et nom ne doivent pas etre null" ;
        this.nom = nom ;
        this.main = new PaquetDeCartes() ;
    }

    public Joueur(Joueur j){
        assert(j != null) :"Le parametre j ne doit pas etre null" ;
        //Pas De Partage ici
        this.nom = j.getNom() ; // copie du nom
        //copie profonde du paquet (en utilisant le constructeur de copie profonde dans PaquetDeCartes)
        this.main = new PaquetDeCartes(j.getMain()) ;
        // copie profonde du jeu
        this.jeu = new Jeu(j.jeu) ;

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
}
