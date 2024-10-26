package jeu.tests;

import jeu.Jeu;
import jeu.cartes.Carte;
import jeu.cartes.Couleur;
import jeu.cartes.attaques.Accident;
import jeu.cartes.attaques.Crevaison;
import jeu.cartes.attaques.FeuRouge;
import jeu.cartes.attaques.PanneDEssence;
import jeu.cartes.parades.FeuVert;
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
    void testConstrDeCopieAvecParamNull() {
        Joueur jNull = null;
        assertThrows(AssertionError.class, () -> new Joueur(jNull)) ;

    }
    @Test
    void testConstrDeCopie() {
        Jeu jeu = new Jeu() ;
        Joueur j1 = new Joueur(jeu, "Joueur1") ;
        j1.ajouterMain(new FeuRouge());
        j1.ajouterMain(new FeuVert());
        Joueur j2 = new Joueur(j1) ;
        assertEquals(j2.getNbCartesMain(), j1.getNbCartesMain());
        assertEquals(j2.getMain().getCarte(0).getClass(), FeuRouge.class);
        assertEquals(j2.getMain().getCarte(1).getClass(), FeuVert.class);
        assertEquals(j2.getNom(), j1.getNom());

        //Pas de Partage
        assertFalse(j2.getMain() == j1.getMain());

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
        Carte carte = new FeuRouge() ;
        j.ajouterMain(carte) ;
        assertEquals(j.getNbCartesMain(),1);
        assertEquals(j.getNom(),"JoueurA");

    }
    @Test
    void testAjouterPlusieur() {
        Jeu jeu = new Jeu();
        Joueur j = new Joueur(jeu, "JoueurA");
        Carte carte1 = new Accident() ;
        Carte carte2 = new Crevaison();
        Carte carte3 = new PanneDEssence();
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
    void testRetirerPlusieyr(){
        Jeu jeu = new Jeu();
        Joueur j = new Joueur(jeu, "JoueurA");
        Carte carte1 = new Accident() ;
        Carte carte2 = new Crevaison();
        Carte carte3 = new PanneDEssence();
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
    void testRetirer1Carte(){
        Jeu jeu = new Jeu();
        Joueur j = new Joueur(jeu, "JoueurA");
        Carte carte = new FeuRouge();
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