package jeu;

import jeu.cartes.Carte;
import jeu.joueurs.Bot;
import jeu.joueurs.Joueur;
import jeu.joueurs.strategie.Strategie ;
import jeu.joueurs.strategie.StrategieDifficile ;
import jeu.joueurs.strategie.StrategieFacile ;

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


    public int definirNbBots() {
        System.out.println("=== Bienvenue dans le Jeu Mille Bornes ===");
        System.out.println("=========================================\n");
        int nbBots;
        do {
            System.out.print("Entrez le nombre de bots (entre 1 et 3) : ");
            nbBots = scanner.nextInt();
        } while (nbBots < 1 || nbBots > 3);  // On fixe ici entre 1 et 3 bots
        return nbBots;
    }


    // Demander la stratégie pour chaque bot (facile ou difficile)
    public Strategie demanderStrategieBot(int indexBot, int nbBots) {
        System.out.println("Choisissez la stratégie pour Bot" + (indexBot) + " :");
        System.out.println("1. Facile");
        System.out.println("2. Difficile");

        int choixStratégie = 0;
        // Boucle jusqu'à ce que l'utilisateur entre un choix valide (1 ou 2)
        do {
            if (scanner.hasNextInt()) {
                choixStratégie = scanner.nextInt();
                if (choixStratégie < 1 || choixStratégie > 2) {
                    System.out.println("Erreur : Veuillez entrer 1 pour Facile ou 2 pour Difficile.");
                }
            } else {
                System.out.println("Erreur : Veuillez entrer un nombre valide.");
                scanner.next(); // Consommer l'entrée non valide
            }
        } while (choixStratégie < 1 || choixStratégie > 2);

        if(indexBot == nbBots){
            System.out.println("\nPréparez-vous à démarrer la partie !");
        }
        // Retourner la stratégie en fonction du choix
        if (choixStratégie == 1) {
            return new StrategieFacile();
        } else {
            return new StrategieDifficile();
        }
    }



}
