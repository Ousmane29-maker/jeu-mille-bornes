package jeu.tests;
import jeu.cartes.Carte ;
import jeu.cartes.Couleur;
import jeu.cartes.PaquetDeCartes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaquetDeCartesTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void testVide() {
        PaquetDeCartes pdc = new PaquetDeCartes() ;
        assertEquals(pdc.getNbCartes(), 0) ;

    }
    @org.junit.jupiter.api.Test
    void testNonVide() {
        PaquetDeCartes pdc = new PaquetDeCartes(new Carte(Couleur.VERT), new Carte(Couleur.JAUNE)) ;
        assertEquals(pdc.getNbCartes(), 2) ;

    }

    @Test
    void ajouter() {
        PaquetDeCartes pdc = new PaquetDeCartes() ;
        pdc.ajouter(new Carte(Couleur.VERT), new Carte(Couleur.JAUNE));
        assertEquals(pdc.getNbCartes(),2);
    }
}