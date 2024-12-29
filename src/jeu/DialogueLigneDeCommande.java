package jeu;

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
        //Afficher l'etat du jeu : les cartes du joueurs courant, sa bataille, ...
        afficherEtatJeu() ;
        Joueur joueurCourant = jeu.getJoueurCourant();
        String coup = joueurCourant.estBot() ? " " : getCoupJoueurHumain() ;
        jeu.jouer(coup) ;

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
        System.out.println("=== État du joueur courant ===");
        System.out.println(jeu.getJoueurCourant());
        System.out.println("===================");
    }


    //Afficher l'etat du jeu : les cartes du joueurs courant, sa bataille, ...

    //Faire jouer le joueur courant
    //Determiner si un dialogue est necessaire
    //determiner l coup a passer a Joueur.jouer(coup)
    //Appeler jouer(coup)

    //game over

    // changer le joueur courant ici ?

}
