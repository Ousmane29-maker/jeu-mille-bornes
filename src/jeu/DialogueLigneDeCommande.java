package jeu;

import jeu.cartes.Carte;
import jeu.joueurs.Bot;
import jeu.joueurs.Joueur;

import java.util.Scanner;

public class DialogueLigneDeCommande {
    private Jeu jeu ;
    Scanner scanner = new Scanner(System.in) ;



    public DialogueLigneDeCommande(Jeu jeu) {
        this.jeu = jeu;
    }

    public void reagir(){
        if(jeu.estTermine()){
            afficherFinDuJeu() ;
        }else{
            // afficherEtatJoueurCourant() ;
            Joueur joueurCourant = jeu.getJoueurCourant();
            if(joueurCourant.estHumain()){
                afficherEtatJeu();
            }
            String coup = joueurCourant.estBot() ? " " : getCoupJoueurHumain() ;
            jeu.jouer(coup) ;
        }
    }

    private void afficherFinDuJeu() {
        Joueur joueurGagnant = jeu.getJoueurGagnant();
        System.out.println("C'est la fin du jeu !\n");
        System.out.println(joueurGagnant.getNom() + " a gagné avec " + joueurGagnant.getBornes() + " km.\n");
    }


    private String getCoupJoueurHumain(){
        String coup;
        do {
            System.out.println("Veuillez saisir un coup possible :");
            coup = scanner.next();
        } while (!jeu.coupPossible(coup));

        // Le coup est valide à ce stade
        return coup;
    }

    private void afficherEtatJeu() {
        System.out.println("\n=== 🌟 État du Jeu 🌟 ===");
        for (Joueur joueur : jeu) {
            System.out.println(joueur);
            System.out.println("🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟🌟"); // Séparation magnifique entre les joueurs
        }
        System.out.println("=== ===================== ===");
    }


}
