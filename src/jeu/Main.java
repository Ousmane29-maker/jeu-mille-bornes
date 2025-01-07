package jeu;

public class Main {
    public static void main(String[] args){
        Jeu jeu = new Jeu() ;
        DialogueLigneDeCommande dialogueLigneDeCommande = new DialogueLigneDeCommande(jeu) ;
        int nbBots = dialogueLigneDeCommande.definirNbBots() ;
        jeu.setDialogue(dialogueLigneDeCommande);
        jeu.initialiser(nbBots);
    }
}
