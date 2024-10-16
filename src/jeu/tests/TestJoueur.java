package jeu.tests;

import jeu.Jeu;
import jeu.cartes.Carte;
import jeu.cartes.Couleur;
import jeu.joueurs.Joueur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestJoueur {

    @BeforeEach
    void setUp() {
    }
    @Test
    void testConstrNull(){
      Jeu jeu = new Jeu() ;
      assertThrows(AssertionError.class, ()-> new Joueur(null, null)) ;
      assertThrows(AssertionError.class, ()-> new Joueur(null, "nom")) ;
      assertThrows(AssertionError.class, ()-> new Joueur(jeu, null)) ;
    }

    @Test
    void testConstr() {
        Jeu jeu = new Jeu() ;
        Joueur j = new Joueur(jeu, "JoueurA") ;
        int nbCartesMain = j.getNbCartesMain() ;
        assertEquals(nbCartesMain,0);
        String nom = j.getNom() ;
        assertEquals(nom,"JoueurA");

    }

    @Test
    void testConstrDeCopie() {
        Joueur jNull = null;
        assertThrows(AssertionError.class, () -> new Joueur(jNull)) ;

    }


    @Test
    void testAjouterNull() {
        Jeu jeu = new Jeu();
        Joueur j = new Joueur(jeu, "JoueurA");
        assertThrows(AssertionError.class, () -> j.ajouterMain(null));
    }

    @Test
    void testAjouter1() {
        Jeu jeu = new Jeu();
        Joueur j = new Joueur(jeu, "JoueurA");
        Carte carte = new Carte(Couleur.ROUGE) ;
        j.ajouterMain(carte) ;
        assertEquals(j.getNbCartesMain(),1);
        assertEquals(j.getNom(),"JoueurA");
    }
    @Test
    void testAjouterPlusieur() {
        Jeu jeu = new Jeu();
        Joueur j = new Joueur(jeu, "JoueurA");
        Carte carte1 = new Carte(Couleur.ROUGE) ;
        Carte carte2 = new Carte(Couleur.VERT) ;
        Carte carte3 = new Carte(Couleur.JAUNE) ;
        j.ajouterMain(carte1) ;
        j.ajouterMain(carte2) ;
        j.ajouterMain(carte3) ;
        assertEquals(j.getNbCartesMain(),3);
        assertEquals(j.getNom(),"JoueurA");
    }
    @Test
    void testRetirerNull(){
        Jeu jeu = new Jeu();
        Joueur j = new Joueur(jeu, "JoueurA");
        assertThrows(AssertionError.class, () -> j.retirerMain(null));

    }
    @Test
    void testRetirer(){
        Jeu jeu = new Jeu();
        Joueur j = new Joueur(jeu, "JoueurA");
        Carte carte1 = new Carte(Couleur.ROUGE) ;
        Carte carte2 = new Carte(Couleur.VERT) ;
        Carte carte3 = new Carte(Couleur.JAUNE) ;
        j.ajouterMain(carte1) ;
        j.ajouterMain(carte2) ;
        j.ajouterMain(carte3) ;
        j.retirerMain(carte1);
        assertEquals(j.getNom(),"JoueurA");
        assertEquals(j.getNbCartesMain(),2);
        j.retirerMain(carte2);
        assertEquals(j.getNbCartesMain(),1);
        j.retirerMain(carte3);
        assertEquals(j.getNbCartesMain(),0);

    }
    @Test
    void testRetirerPlusieur(){
        Jeu jeu = new Jeu();
        Joueur j = new Joueur(jeu, "JoueurA");
        Carte carte = new Carte(Couleur.ROUGE) ;
        j.ajouterMain(carte) ;
        j.retirerMain(carte);
        assertEquals(j.getNbCartesMain(),0);
        assertEquals(j.getNom(),"JoueurA");
    }
    @Test
    void setJeuNull(){
        Jeu jeu = new Jeu();
        Joueur j = new Joueur(jeu, "JoueurA");
        assertThrows(AssertionError.class, () -> j.setJeu(null));
    }

}