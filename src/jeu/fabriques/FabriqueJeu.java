package jeu.fabriques;

import jeu.CollectionJeux;
import jeu.Jeu;
import jeu.cartes.Bottes;
import jeu.cartes.Carte;
import jeu.joueurs.Joueur;

public class FabriqueJeu {
    public CollectionJeux creerJeuUnJoueur(String nom, Carte[] cT, Carte[] cM, Bottes[] b){
        //cT =  tableau contenant des cartes Batailles
        CollectionJeux collectionJeux = new CollectionJeux() ;
        for(Carte carteBataille : cT){
            for(Carte carteMain :cM){
                for(Bottes bottes : b){
                    Jeu jeu = new Jeu() ;
                    Joueur joueur = new Joueur(jeu, nom) ;
                    joueur.ajouterMain(carteMain);
                    joueur.setBataille(carteBataille) ;
                    joueur.setBottes(bottes);
                    jeu.add(joueur); // on ajoute le joueur dans le jeu apres avoir specifie ses parametres
                    collectionJeux.add(jeu); // on ajoute ce jeu creer lui meme dans la collection
                }
            }
        }
        return  collectionJeux ;
    }
}
