package jeu.tests;

import jeu.Jeu;
import jeu.joueurs.CollectionJoueurs;
import jeu.joueurs.Joueur;
import jeu.joueurs.JoueurHumain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestCollectionJoueurs {
    @BeforeEach
    void setUp() {
    }
    @Test
    void testConstrNbjoueurplusPetitQue2(){
        assertThrows(AssertionError.class, ()-> new CollectionJoueurs(1)) ;
        assertThrows(AssertionError.class, ()-> new CollectionJoueurs(0)) ;
    }
    @Test
    void  testAjouterJoueurNull(){
        CollectionJoueurs collectionJoueurs = new CollectionJoueurs(3) ;
        Joueur joueurNull = null ;
        assertThrows(AssertionError.class, ()-> collectionJoueurs.ajouter(joueurNull)) ;
    }

    @Test
    void testAConstrDeCopieAvecParamNull(){
        CollectionJoueurs collectionJoueurs1 = null ; ;
        assertThrows(AssertionError.class, () -> new CollectionJoueurs(collectionJoueurs1)) ;
    }

   @Test
    void testAConstrDeCopie(){
        CollectionJoueurs cj1 = new CollectionJoueurs(2) ;
        Jeu jeu = new Jeu() ;
        Joueur joueur1 = new JoueurHumain(jeu, "joueur1") ;
        Joueur joueur2 = new JoueurHumain(jeu, "joueur2") ;
        cj1.ajouter(joueur1) ;
        cj1.ajouter(joueur2);
        CollectionJoueurs cj2 = new CollectionJoueurs(cj1) ;
        assertEquals(cj2.size(), 2);
        assertEquals(cj2.get(0).getNom(),"joueur1");
        assertEquals(cj2.get(1).getNom(),"joueur2");
        // Pas de partage
       assertFalse(cj2.get(0).getMain() == cj1.get(0).getMain());
       assertFalse(cj2.get(1).getMain() == cj1.get(1).getMain());
    }
    @Test
    void testAjouter1joueurs(){
        CollectionJoueurs col = new CollectionJoueurs(2) ;
        Jeu jeu = new Jeu() ;
        Joueur joueur1 = new JoueurHumain(jeu,"joueur1" ) ;
        col.ajouter(joueur1) ;
        assertEquals(col.size(), 1);
        assertEquals(col.get(0), joueur1);
    }
    @Test
    void  testAjouterPlusieursJoueur(){
        CollectionJoueurs col = new CollectionJoueurs(3) ;
        Jeu jeu = new Jeu() ;
        Joueur joueur1 = new JoueurHumain(jeu,"joueur1" ) ;
        Joueur joueur2 = new JoueurHumain(jeu,"joueur2" ) ;
        Joueur joueur3 = new JoueurHumain(jeu,"joueur3" ) ;
        col.ajouter(joueur1) ;
        col.ajouter(joueur2) ;
        col.ajouter(joueur3) ;
        assertEquals(col.size(), 3);
        assertEquals(col.get(0), joueur1);
        assertEquals(col.get(1), joueur2);
        assertEquals(col.get(2), joueur3);

    }
    @Test
    void testGetJoueursNoInvalide(){
        CollectionJoueurs col = new CollectionJoueurs(2) ;
        assertThrows(AssertionError.class, () -> col.get(-1)) ;
        assertThrows(AssertionError.class, () -> col.get(2)) ;
        assertThrows(AssertionError.class, () -> col.get(3)) ;
        assertThrows(AssertionError.class, () -> col.get(10)) ;
    }

}
