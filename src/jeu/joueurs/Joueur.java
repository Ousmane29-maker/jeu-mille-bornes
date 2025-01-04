package jeu.joueurs;
import jeu.Jeu;
import jeu.cartes.*;
import jeu.cartes.attaques.*;
import jeu.cartes.bornes.Bornes;
import jeu.cartes.bottes.AsDuVolant;
import jeu.cartes.bottes.CiterneDEssence;
import jeu.cartes.bottes.Increvable;
import jeu.cartes.bottes.Prioritaire;
import jeu.cartes.parades.*;

public abstract class Joueur {

    protected String nom;
    protected PaquetDeCartes main;

    protected int bornes;
    protected int cartes200Jouees; // Compteur pour les cartes "200 km"


    protected Bottes bottes;

    protected Carte bataille;

    protected Jeu jeu;
    protected boolean limitationVitesse;

    public Joueur(Jeu jeu, String nom) {
        assert (jeu != null && nom != null) : "Les parametres jeu et nom ne doivent pas etre null";
        this.nom = nom;
        this.jeu = jeu;
        this.bornes = 0;
        this.cartes200Jouees = 0;
        this.bottes = new Bottes(); // a chequer ..
        this.bataille = null;
        this.limitationVitesse = false;
        this.main = new PaquetDeCartes();
    }

    public Joueur(Jeu jeu, String nom, Bottes bottes, Carte bataille) {
        assert (jeu != null && nom != null) : "Les parametres jeu et nom ne doivent pas etre null";
        this.nom = nom;
        this.jeu = jeu;
        this.bottes = bottes;
        this.bataille = bataille;
    }

    public abstract Joueur clone() ;

    public Joueur(Joueur j){
        assert (j != null) : "Le parametre j ne doit pas etre null";
        //logique commune pour les deux types de joueurs
        this.nom = j.getNom(); // copie du nom
        //copie profonde du paquet (en utilisant le constructeur de copie profonde dans PaquetDeCartes)
        this.main = new PaquetDeCartes(j.getMain());
        this.jeu = j.jeu ;
        this.setBataille(j.bataille);
        this.setBottes(j.bottes);
        this.bornes = j.bornes ;
        this.cartes200Jouees = j.cartes200Jouees ;
        this.limitationVitesse = j.limitationVitesse ;
    }
    public PaquetDeCartes getMain() {
        return this.main;
    }

    public int getNbCartesMain() {
        return this.main.getNbCartes();
    }

    public String getNom() {
        return nom;
    }

    public void ajouterMain(Carte carte) {
        assert (carte != null) : " La carte ne doit pas etre null";
        this.main.ajouter(carte);
    }

    public void retirerMain(Carte carte) {
        assert (carte != null) : " La carte ne doit pas etre null";
        this.main.enlever(carte);
    }

    public void setJeu(Jeu jeu) {
        assert (jeu != null) : "Le parametre jeu ne doit pas etre null ";
        this.jeu = jeu;
    }

    @Override
    public String toString() {
        final String RESET = "\u001B[0m";
        final String LIGHT_GREEN = "\u001B[92m"; // Vert clair pour les bottes et états neutres
        final String RED = "\u001B[31m";         // Rouge pour les attaques
        final String ORANGE = "\u001B[38;5;214m"; // Orange pour les limitations actives
        final String BLUE = "\u001B[34m";        // Bleu pour les bornes

        StringBuilder sb = new StringBuilder();
        sb.append("{\n")
                .append("  nom = ").append(nom).append("\n")
                .append("  main = ").append(main).append("\n")
                // Bornes : bleu
                .append("  bornes = ").append(BLUE).append(bornes).append(RESET).append("\n")
                // cartes200Jouees : affichées normalement
                .append("  cartes200Jouees = ").append(cartes200Jouees).append("\n");

        // Condition pour bataille : rouge si c'est une attaque, texte clair pour null
        sb.append("  bataille = ");
        if (bataille == null) {
            sb.append("Pas de bataille").append("\n");
        } else if (bataille.estUneAttaque()) {
            sb.append(RED).append(bataille).append(RESET).append("\n");
        } else {
            sb.append(bataille).append("\n");
        }

        // Condition pour limitation de vitesse : orange si active, vert clair sinon
        sb.append("  limitationVitesse = ");
        if (limitationVitesse) {
            sb.append(ORANGE).append("Limitation de vitesse active (limite à 50 km/h)").append(RESET).append("\n");
        } else {
            sb.append("Pas de limitation de vitesse").append("\n");
        }

        sb.append("  bottes = ") ;
        if(!bottes.estAsDuVolant() && !bottes.estPrioritaire() && !bottes.estIncrevable() && !bottes.estCiterneDEssence()){
            sb.append(bottes).append("\n") ;
        }else{
            sb.append(LIGHT_GREEN).append(bottes).append(RESET).append("\n") ;
        }
        sb.append("}");
        return sb.toString();
    }


    //peutRecevoir Attaque
    public boolean peutRecevoir(Accident accident) {
        return !bottes.estAsDuVolant();
    }

    public boolean peutRecevoir(FeuRouge feuRouge) {
        return !bottes.estPrioritaire();
    }

    public boolean peutRecevoir(Crevaison crevaison) {
        return !bottes.estIncrevable();
    }

    public boolean peutRecevoir(PanneDEssence panneDEssence) {
        return !bottes.estCiterneDEssence();
    }

    //estPossiblePoser Parade
    public boolean estPossiblePoser(FeuVert feuVert) {
        return bataille != null && this.bataille.match("FeuRouge");
    }

    public boolean estPossiblePoser(Reparation reparation) {
        return bataille != null && this.bataille.match("Accident");
    }

    public boolean estPossiblePoser(Essence essence) {
        return bataille != null && this.bataille.match("PanneDEssence");
    }

    public boolean estPossiblePoser(RoueDeSecours roueDeSecours) {
        return bataille != null && this.bataille.match("Crevaison");
    }

    public boolean estPossiblePoser(FinLimitationDeVitesse finLimitationDeVitesse) {
        return limitationVitesse ;
    }
    public boolean peuRecevoir(LimitationDeVitesse limitationDeVitesse) {
        return !limitationVitesse ;
    }


//        //Important : au cours d’une partie, vous ne pouvez
//        //poser que 2 cartes « 200 » sur votre Zone de Jeu.
//        //A gerer apres gestion de paquets de cartesn, voir y'a combien de cartes de 200 (ca doit etre < 2)




    public boolean estPossiblePoser(Bornes bornes) {
        //s'il ya une carte attaque sur sa bataille
        if(bataille != null && bataille.estUneAttaque()){
            return false ;
        }
        // Vérifier la limitation de vitesse
        if (this.limitationVitesse && bornes.getKms() > 50) {
            return false;
        }
        // Vérifier si c'est une carte "200 km" et si elle a déjà été jouée 2 fois
        if (bornes.getKms() == 200 && this.cartes200Jouees >= 2) {
            return false;
        }
        // Si aucune condition n'empêche de jouer, la carte peut être posée
        return true;
    }


    public void setBataille(Carte newBataille) {
        this.bataille = newBataille;
    }

    public void setBottes(Bottes newBottes) {
        this.bottes = newBottes;
    }

    public void setLimitationVitesse() {
        this.limitationVitesse = !this.limitationVitesse;
    }

    public abstract void jouer(String coup) ;
    public void jouerCoup(String coup) {
        assert coupPossible(coup) : "le coup doit etre valide";
        int indiceCarte = coup.charAt(1) - '1' ;
        Carte carte = getMain().getCarte(indiceCarte) ;
        if(coup.charAt(0) == 'J'){
            jouerJeter(carte);
        } else if (coup.length() == 2) {
            jouerPoserSurMonJeu(carte) ;
        }else {
            int indiceJoueurAdverse = coup.charAt(2) - '1' ;
            Joueur joueurAdverse = jeu.getJoueur(indiceJoueurAdverse);
            jouerJeuAdverse(carte, joueurAdverse) ;
        }
    }

    private void jouerJeuAdverse(Carte carte, Joueur joueurAdverse) {

        if(carte.estUneAttaque()){
            joueurAdverse.setBataille(carte);

        } else if (carte.match("LimitationDeVitesse")) {
            joueurAdverse.setLimitationVitesse() ;
        }
        // Retire la carte de la main
        getMain().enlever(carte);
    }

    private void jouerPoserSurMonJeu(Carte carte) {
        if (carte.estUneParade()) {
            // Pose une parade
            setBataille(carte);
        } else if (carte.match("Bornes")) {
            // Gérer les Bornes
            Bornes bornes = (Bornes) carte;
            if (bornes.getKms() == 200) {
                this.cartes200Jouees++;
            }
            this.bornes += bornes.getKms(); // la distance parcourue
        } else if (carte.estUneBotte()) {
            // Active une botte
            this.activerBotte(carte);
        } else if (carte.match("FinLimitationDeVitesse")) {
            setLimitationVitesse();
        }

        // Retire la carte de la main
        getMain().enlever(carte);
    }

    private void activerBotte(Carte carte) {
        switch (carte) {
            case AsDuVolant ignored -> this.bottes.setEstAsDuVolant();
            case CiterneDEssence ignored -> this.bottes.setEstCiterneDEssence();
            case Prioritaire ignored -> this.bottes.setEstPrioritaire();
            case Increvable ignored -> this.bottes.setEstIncrevable();
            default -> {
                // Ne rien faire
            }
        }
    }


    private void jouerJeter(Carte carte) {
        getMain().enlever(carte); // l'enlever de la main du joueur
        jeu.jeter(carte); // le jeter dans le talon
    }


    public boolean coupPossible(String coup) {
        // Vérifie que le coup a au moins 2 caractere et que le deuxieme correspond bien a un entier
        if (coup == null || coup.length() < 2 || !Character.isDigit(coup.charAt(1))) {
            return false;
        }
        // Vérifie les trois  de coups possibles
        return coupJxPossible(coup) || coupPxPossible(coup) || coupPxyPossible(coup);
    }


    private boolean coupJxPossible(String coup) {
        // le joueur souhaite jeter la carte a l'indice x
        if (coup.length() == 2 && coup.charAt((0)) == 'J') {
            int indiceCarte = coup.charAt(1) - '1';
            if (indiceCarte >= 0 && indiceCarte < getNbCartesMain()) {
                return true;
            }
        }
        return false;
    }

    private boolean coupPxPossible(String coup) {
        // le joueur souhaite poser la carte a l'indice x sur son jeu
        if (coup.length() == 2 && coup.charAt((0)) == 'P') {
                int indiceCarte = coup.charAt(1) - '1';
                if (indiceCarte >= 0 && indiceCarte < getNbCartesMain()) {
                    Carte carte = getMain().getCarte(indiceCarte);
                    return carte.peutEtrePoseeSurMonJeu(this);
                }
        }
        return false;
    }

    private boolean coupPxyPossible(String coup){
        // le joueur souhaite poser la carte x sur son adversaire y
        if (coup.length() == 3 && coup.charAt((0)) == 'P') {
            int indiceCarte = coup.charAt(1) - '1';
            if (indiceCarte >= 0 && indiceCarte < getNbCartesMain()) {
                // ici x est valide
                if(Character.isDigit(coup.charAt(2))) {
                    //ici y corresopond bien a un entier
                    int indiceJoueur = coup.charAt(2) - '1';
                    // indice joueur doit etre valide et different de l'indice du joueur actuel
                    if (indiceJoueur >= 0 && indiceJoueur < jeu.getNbJoueurs() && indiceJoueur != jeu.getJoueurQuiJoue()) {
                        Carte carte = getMain().getCarte(indiceCarte);
                        Joueur joueurAdverse = jeu.getJoueur(indiceJoueur);
                        return carte.peutEtrePoseeSurJeuAdversaire(joueurAdverse);
                    }
                }
            }
        }
        return false;
    }

    public Carte getBataille() {
        return bataille ;
    }

    public boolean estBot(){
        return false ;
    }

    public boolean estHumain(){
        return false ;
    }


    public int getBornes() {
        return bornes;
    }
}
