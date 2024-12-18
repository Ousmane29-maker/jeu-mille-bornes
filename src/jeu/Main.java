package jeu;

public class Main {
    public static void main(String[] args){
        Jeu jeu = new Jeu() ;
        DialogueLigneDeCommande dialogueLigneDeCommande = new DialogueLigneDeCommande(jeu) ;
        jeu.setDialogue(dialogueLigneDeCommande);
        jeu.initialiser(3);
    }
}
