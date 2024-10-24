package jeu.tests;

import jeu.Jeu;
import jeu.cartes.*;
import jeu.joueurs.Joueur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCarte {
    @BeforeEach
        void setUp() {
    }
    @Test
    public void estUneAttaqueVrai(){
        Carte carteFeuRouge = new FeuRouge() ;
        assertTrue(carteFeuRouge.estUneAttaque()) ;
        Carte carteAccident = new Accident() ;
        assertTrue(carteAccident.estUneAttaque()) ;
    }


    @Test
    public void estUneAttaqueFaux(){
        Carte carteFeuVert = new FeuVert() ;
        assertFalse(carteFeuVert.estUneAttaque()) ;
        Carte carteReparation = new Reparation() ;
        assertFalse(carteReparation.estUneAttaque()) ;
        Carte carteEssence = new Essence() ;
        assertFalse(carteEssence.estUneAttaque()) ;
        Carte carteRoueDeSecours = new RoueDeSecours() ;
        assertFalse(carteRoueDeSecours.estUneAttaque()) ;
    }

    @Test
    public void estUneParadeFaux(){
        Carte carteFeuRouge = new FeuRouge() ;
        assertFalse(carteFeuRouge.estUneParade()) ;
        Carte carteAccident = new Accident() ;
        assertFalse(carteAccident.estUneParade()) ;
    }

    @Test
    public void estUneParadeVrai(){
        Carte carteFeuVert = new FeuVert() ;
        assertTrue(carteFeuVert.estUneParade()); ;
        Carte carteReparation = new Reparation() ;
        assertTrue(carteReparation.estUneParade()) ;
        Carte carteEssence = new Essence() ;
        assertTrue(carteEssence.estUneParade()) ;
        Carte carteRoueDeSecours = new RoueDeSecours() ;
        assertTrue(carteRoueDeSecours.estUneParade()) ;
    }
    @Test
    public void TestAttaquePeutEtrePoseeSurMonJeu(){
        Joueur j = new Joueur(new Jeu(), "joueur_A") ;
        Carte carteFeuRouge = new FeuRouge() ;
        Carte carteAccident = new Accident() ;
        Carte carteCrevaison = new Crevaison() ;
        Carte cartePanneDEssence = new PanneDEssence() ;
        assertThrows(AssertionError.class, () -> carteFeuRouge.peutEtrePoseeSurMonJeu(null)) ;
        assertThrows(AssertionError.class, () -> carteAccident.peutEtrePoseeSurMonJeu(null)) ;
        assertThrows(AssertionError.class, () -> carteCrevaison.peutEtrePoseeSurMonJeu(null)) ;
        assertThrows(AssertionError.class, () -> cartePanneDEssence.peutEtrePoseeSurMonJeu(null)) ;
        assertFalse(carteAccident.peutEtrePoseeSurMonJeu(j));
        assertFalse(carteFeuRouge.peutEtrePoseeSurMonJeu(j));
        assertFalse(carteCrevaison.peutEtrePoseeSurMonJeu(j));
        assertFalse(cartePanneDEssence.peutEtrePoseeSurMonJeu(j));
    }


    @Test
    public void TestAccidentPeutEtrePoseeSurJeuAdversaireVrai() {
        Joueur j = new Joueur(new Jeu(), "joueur_A") ;
        Carte carteAccident = new Accident() ;
        assertThrows(AssertionError.class, () -> carteAccident.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertTrue(carteAccident.peutEtrePoseeSurJeuAdversaire(j)) ;
    }

    @Test
    public void TestAccidentPeutEtrePoseeSurJeuAdversaireFaux() {
        Joueur j = new Joueur(new Jeu(), "joueur_A") ;
        Carte carteAccident = new Accident() ;
        assertThrows(AssertionError.class, () -> carteAccident.peutEtrePoseeSurJeuAdversaire(null)) ;

        //cas ou le joueur est immunise contre Accident
        j.setBottes("estAsDuVolant") ;
        assertFalse(carteAccident.peutEtrePoseeSurJeuAdversaire(j));
    }

    @Test
    public void TestFeuRougePeutEtrePoseeSurJeuAdversaireVrai() {
        Joueur j = new Joueur(new Jeu(), "joueur_A") ;
        Carte carteFeuRouge = new FeuRouge() ;
        assertThrows(AssertionError.class, () -> carteFeuRouge.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertTrue(carteFeuRouge.peutEtrePoseeSurJeuAdversaire(j)) ;
    }

    @Test
    public void TestFeuRougePeutEtrePoseeSurJeuAdversaireFaux() {
        Joueur j = new Joueur(new Jeu(), "joueur_A") ;
        Carte carteFeuRouge = new FeuRouge() ;
        assertThrows(AssertionError.class, () -> carteFeuRouge.peutEtrePoseeSurJeuAdversaire(null)) ;

        //cas ou le joueur est immunise contre FeuRouge
        j.setBottes("estPrioritaire") ;
        assertFalse(carteFeuRouge.peutEtrePoseeSurJeuAdversaire(j));
    }


}
