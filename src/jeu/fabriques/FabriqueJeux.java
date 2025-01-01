package jeu.fabriques;

import jeu.CollectionJeux;
import jeu.Jeu;
import jeu.cartes.Bottes;
import jeu.cartes.Carte;
import jeu.cartes.attaques.Accident;
import jeu.cartes.attaques.FeuRouge;
import jeu.cartes.parades.Essence;
import jeu.cartes.parades.FeuVert;
import jeu.cartes.parades.Reparation;
import jeu.joueurs.Joueur;
import jeu.joueurs.JoueurHumain;

public class FabriqueJeux {
    public FabriqueJeux() {

    }

    public static Jeu creerJeu(String nom, Carte carteBataille, Carte carteMain, Bottes bottes, Boolean limitationVitesse){
                    Jeu jeu = new Jeu() ;
                    Joueur joueur = new JoueurHumain(jeu, nom) ;
                    joueur.ajouterMain(carteMain);
                    joueur.setBataille(carteBataille) ;
                    joueur.setBottes(bottes);
                    if(limitationVitesse){
                        joueur.setLimitationVitesse();
                    }
                    jeu.add(joueur); // on ajoute le joueur dans le jeu apres avoir specifier ses parametres
                    return jeu ;

    }
    public static CollectionJeux creerJeuUnJoueur(String nom, Carte[] cT, Carte[] cM, Bottes[] b){
        //cT =  tableau contenant des cartes Batailles
        CollectionJeux collectionJeux = new CollectionJeux() ;
        for(Carte carteBataille : cT){
            for(Carte carteMain :cM){
                for(Bottes bottes : b){
                    Jeu jeu1 = FabriqueJeux.creerJeu(nom, carteBataille, carteMain, bottes,  false) ;
                    Jeu jeu2 = FabriqueJeux.creerJeu(nom, carteBataille, carteMain,bottes, true) ;
                    collectionJeux.add(jeu1); 
                    collectionJeux.add(jeu2);
                }
            }
        }
        return  collectionJeux ;
    }

    public static CollectionJeux getMB1JReparationCorrect(){
        Carte[] cM = {new Reparation()};
        Carte[] cT = {new Accident()};
        Bottes[] b = FabriqueBottes.getToutesLesBottesPossiblesSaufAsDuVolant();
        return creerJeuUnJoueur("Joueur1",cT, cM,b) ;
    }

    public static CollectionJeux getMB1JAccidentCorrect(){
        Carte[] cM = {new Accident()}; //l'accident que le joueur1 va utiliser pour attaquer
        Carte[] cT = {new FeuRouge()}; // aleatoire
        Bottes[] b = FabriqueBottes.getToutesLesBottesPossiblesSaufAsDuVolant();
        return creerJeuUnJoueur("Joueur1",cT, cM,b) ;
    }

    public static CollectionJeux getMB1JFeuVertCorrectSansAsDuVolant(){
        Carte[] cM = {new Essence()}; // aleatoire
        Carte[] cT = {new FeuVert()}; // aleatoire
        Bottes[] b = FabriqueBottes.getToutesLesBottesPossiblesSaufAsDuVolant();
        return creerJeuUnJoueur("Joueur2",cT, cM,b) ;
    }

    public static CollectionJeux getMB2JAccidentCorrect(){
        CollectionJeux collectionJeux1 = getMB1JAccidentCorrect() ;
        CollectionJeux collectionJeux2 = getMB1JFeuVertCorrectSansAsDuVolant() ;
        CollectionJeux result = new CollectionJeux() ;
        for(Jeu jeu1 : collectionJeux1){
            for (Jeu jeu2 : collectionJeux2){
                result.add(FabriqueJeux.combiner(jeu1,jeu2)) ;
            }
        }
        return result ;
    }

    private static Jeu combiner(Jeu jeu1, Jeu jeu2) {
        Joueur joueur2 = jeu2.getJoueur(0) ;
        joueur2.setJeu(jeu1);
        jeu1.add(joueur2);
        return jeu1 ;
    }
}
