package jeu.tests;

import jeu.Jeu;
import jeu.cartes.Bottes;
import jeu.cartes.Carte;
import jeu.cartes.attaques.Accident;
import jeu.cartes.attaques.Crevaison;
import jeu.cartes.attaques.FeuRouge;
import jeu.cartes.attaques.PanneDEssence;
import jeu.cartes.bornes.Bornes;
import jeu.cartes.parades.Essence;
import jeu.cartes.parades.FeuVert;
import jeu.joueurs.Bot;
import jeu.joueurs.Joueur;
import jeu.joueurs.JoueurHumain;
import jeu.joueurs.StrategieBasique;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class TestJoueur {

    @BeforeEach
    void setUp() {
    }
    @Test
    void testConstrNull(){
      Jeu jeu = new Jeu() ;
      assertThrows(AssertionError.class, ()-> new JoueurHumain(null, "Joueur1")) ;
      assertThrows(AssertionError.class, ()-> new Bot(null, "nom", new StrategieBasique())) ;
      assertThrows(AssertionError.class, ()-> new Bot(jeu, null, new StrategieBasique())) ;
    }

    @Test
    void testConstr() {
        Jeu jeu = new Jeu() ;
        Joueur j = new JoueurHumain(jeu, "JoueurA") ;
        int nbCartesMain = j.getNbCartesMain() ;
        assertEquals(nbCartesMain,0);
        String nom = j.getNom() ;
        assertEquals(nom,"JoueurA");

    }

//    @Test
//    void testConstrDeCopieAvecParamNull() {
//        Joueur jNull = null;
//        assertThrows(AssertionError.class, () -> new JoueurHumain(jNull)) ;
//
//    }
    @Test
    void testConstrDeCopie() {
        Jeu jeu = new Jeu() ;
        Joueur j1 = new JoueurHumain(jeu, "Joueur1") ;
        j1.ajouterMain(new FeuRouge());
        j1.ajouterMain(new FeuVert());
        Joueur j2 = j1.clone() ;
        assertEquals(j2.getNbCartesMain(), j1.getNbCartesMain());
        assertEquals(j2.getMain().getCarte(0).getClass(), FeuRouge.class);
        assertEquals(j2.getMain().getCarte(1).getClass(), FeuVert.class);
        assertEquals(j2.getNom(), j1.getNom());

        //Pas de Partage
       // assertFalse(j2.getMain() == j1.getMain());

    }


    @Test
    void testAjouterNull() {
        Jeu jeu = new Jeu();
        Joueur j = new JoueurHumain(jeu, "JoueurA");
        assertThrows(AssertionError.class, () -> j.ajouterMain(null));
    }

    @Test
    void testAjouter1() {
        Jeu jeu = new Jeu();
        Joueur j = new JoueurHumain(jeu, "JoueurA");
        Carte carte = new FeuRouge() ;
        j.ajouterMain(carte) ;
        assertEquals(j.getNbCartesMain(),1);
        assertEquals(j.getNom(),"JoueurA");

    }
    @Test
    void testAjouterPlusieur() {
        Jeu jeu = new Jeu();
        Joueur j = new JoueurHumain(jeu, "JoueurA");
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
        Joueur j = new JoueurHumain(jeu, "JoueurA");
        assertThrows(AssertionError.class, () -> j.retirerMain(null));

    }
    @Test
    void testRetirerPlusieyr(){
        Jeu jeu = new Jeu();
        Joueur j = new JoueurHumain(jeu, "JoueurA");
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
        Joueur j = new JoueurHumain(jeu, "JoueurA");
        Carte carte = new FeuRouge();
        j.ajouterMain(carte) ;
        j.retirerMain(carte);
        assertEquals(j.getNbCartesMain(),0);
        assertEquals(j.getNom(),"JoueurA");
    }
    @Test
    void setJeuNull(){
        Jeu jeu = new Jeu();
        Joueur j = new JoueurHumain(jeu, "JoueurA");
        assertThrows(AssertionError.class, () -> j.setJeu(null));
    }

    @Test
    void testCoupPossibleJx(){
        Jeu jeu = new Jeu();
        Joueur j = new JoueurHumain(jeu, "JoueurA");
        j.ajouterMain(new Bornes(200));
        j.ajouterMain(new FeuRouge());
        j.ajouterMain(new Essence());
        j.ajouterMain(new PanneDEssence());
        jeu.add(j);
        assertTrue(j.coupPossible("J1"));
        assertTrue(j.coupPossible("J2"));
        assertTrue(j.coupPossible("J3"));
        assertTrue(j.coupPossible("J4"));
        assertFalse(j.coupPossible("P0"));
        assertFalse(j.coupPossible("P5"));
        assertFalse(j.coupPossible(""));
    }
    @Test
    void testCoupPossiblePx(){
        Jeu jeu = new Jeu();
        Joueur j = new JoueurHumain(jeu, "JoueurA");
        j.ajouterMain(new Bornes(200));
        j.ajouterMain(new FeuRouge());
        j.ajouterMain(new Essence());
        jeu.add(j);
        assertTrue(j.coupPossible("P1"));
        assertFalse(j.coupPossible("P2"));
        assertFalse(j.coupPossible("P3"));
        assertFalse(j.coupPossible("P"));
        assertFalse(j.coupPossible("Pksi84"));
        j.setLimitationVitesse(); // Rendre le coup "P1" invalide
        assertFalse(j.coupPossible("P1"));

    }

    @Test
    void testCoupPossiblePxy() {
        Jeu jeu = new Jeu();
        Joueur j = new Bot(jeu, "JoueurA", new StrategieBasique());
        Joueur j2 = new JoueurHumain(jeu, "JoueurB");
        j.ajouterMain(new Bornes(200));
        j.ajouterMain(new FeuRouge());
        j.ajouterMain(new Accident());
        j.ajouterMain(new PanneDEssence());
        j.ajouterMain(new Crevaison());

        j2.ajouterMain(new Bornes(100));
        j2.ajouterMain(new Essence());
        Bottes bottes = new Bottes() ;
        bottes.setEstIncrevable();
        bottes.setEstPrioritaire();
        j2.setBottes(bottes);

        jeu.add(j);
        jeu.add(j2); // j2 deuxieme position
        assertTrue(j.coupPossible("P32"));
        assertTrue(j.coupPossible("P42"));
        assertFalse(j.coupPossible("P12"));
        assertFalse(j.coupPossible("P22"));
        assertFalse(j.coupPossible("P52"));
        assertFalse(j.coupPossible("Px2"));
        assertFalse(j.coupPossible("p42"));

    }

    @ParameterizedTest
    @MethodSource("jeu.fabriques.FabriqueJeux#getMB1JReparationCorrect")
    void testPoserReparationCorrect(Jeu jeu) {
        Joueur joueur = jeu.getJoueur(0);
        jeu.jouer("P1");
        assertTrue(joueur.getBataille().match("Reparation"));
        assertEquals(0,joueur.getMain().getNbCartes()) ;
    }

    @ParameterizedTest
    @MethodSource ("jeu.fabriques.FabriqueJeux#getMB2JAccidentCorrect")
    void testPoserAutruiAccidentCorrect(Jeu jeu) {
        Joueur j1 = jeu.getJoueur(0);
        Joueur j2 = jeu.getJoueur(1);
        j1.jouer("P12");
        assertTrue(j2.getBataille().match("Accident"));
        assertEquals(0, j1.getMain().getNbCartes()) ;
        assertEquals(1, j2.getMain().getNbCartes()) ;
    }


}