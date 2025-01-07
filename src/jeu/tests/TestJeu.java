package jeu.tests;

import jeu.Jeu;
import jeu.cartes.Carte;
import jeu.joueurs.Joueur;
import jeu.joueurs.JoueurHumain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestJeu {

    @BeforeEach
    void setUp() {
    }
    @Test
    public void testConstrDeCopieAvecParamNull(){
        assertThrows(AssertionError.class, () -> new Jeu(null)) ;
    }

    @Test
    public void testConstrDeCopie(){
        Jeu jeu = new Jeu() ;
        Joueur joueurA = new JoueurHumain(jeu, "joueurA") ;
        Joueur joueurB = new JoueurHumain(jeu, "joueurB") ;
        Joueur joueurC = new JoueurHumain(jeu, "joueurC") ;
        jeu.add(joueurA);
        jeu.add(joueurB);
        jeu.add(joueurC);
        Jeu copieDeJeu = new Jeu(jeu) ;
        assertTrue(jeu.getNbJoueurs() == copieDeJeu.getNbJoueurs());
        //attendre d'avoir des fonctions qui nous permettra de tester la profondeur de la copie
    }

    @Test
    public void testAdd(){
        Jeu jeu = new Jeu() ;
        assertThrows(AssertionError.class, () -> jeu.add(null)) ;
        Joueur j = new JoueurHumain(jeu, "joueur_1") ;
        jeu.add(j) ;
        assertEquals(jeu.getNbJoueurs(), 1);
    }

    @Test
    public void testJeter(){
        Jeu jeu = new Jeu() ;
        Joueur j = new JoueurHumain(jeu, "joueur_1") ;
        jeu.add(j) ;
        assertThrows(AssertionError.class, () -> jeu.jeter(null)) ;
        // Attendons de voir la suite, si on a un getPaquet ou toute autre implementation
    }

//    @Test
//    void testCreerJoueurs(){
//        Jeu jeu = new Jeu() ;
//        jeu.creerJoueurs(4);
//        assertTrue(jeu.getNbJoueurs() == 4) ;
//        assertTrue(jeu.getNbBots() == 3) ;
//    }

}