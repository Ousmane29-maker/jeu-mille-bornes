package jeu.tests;
import jeu.cartes.Carte ;
import jeu.cartes.Couleur;
import jeu.cartes.PaquetDeCartes;
import jeu.fabriques.FabriqueCartes;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class TestPaquetDeCartes {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testConstructeurVide() {
        PaquetDeCartes pdc = new PaquetDeCartes() ;
        assertEquals(pdc.getNbCartes(), 0) ;

    }
    @Test
    void testConstructeurAvecCartesEnParam() {
        Carte carte1 = new Carte(Couleur.VERT) ;
        Carte carte2 = new Carte(Couleur.JAUNE) ;
        PaquetDeCartes pdc = new PaquetDeCartes(carte1, carte2) ;
        assertEquals(pdc.getNbCartes(), 2) ;
        assertEquals(pdc.getCarte((0)), carte1);
        assertEquals(pdc.getCarte((1)), carte2);

    }
    @Test
    void testConstructeurAvecPdcEnParam(){
        PaquetDeCartes pdc1 = FabriqueCartes.getPaquet1Vert1Jaune() ;
        PaquetDeCartes pdc2 = new PaquetDeCartes(pdc1) ;
        //Pas de partage donc l'adresse des objets sont diff
        assertFalse (pdc1.getCarte(0) ==pdc2.getCarte(0));
        assertFalse (pdc1.getCarte(1) == pdc2.getCarte(1));
    }

    @Test
    void Testajouter() {
        PaquetDeCartes pdc = new PaquetDeCartes() ;
        Carte carte1 = new Carte(Couleur.VERT) ;
        pdc.ajouter(carte1);
        assertEquals(pdc.getNbCartes(),1);
        assertEquals(pdc.getCarte(0), carte1);
    }
    @Test
    void TestajouterAvecPdc() {
        PaquetDeCartes pdc1 = new PaquetDeCartes() ;
        PaquetDeCartes pdc2 = FabriqueCartes.getPaquet1Vert1Jaune();
        pdc1.ajouter(pdc2);
        assertEquals(pdc1.getNbCartes(),2);
        assertEquals(pdc1.getCarte(0).getCouleur(), Couleur.VERT);
        assertEquals(pdc1.getCarte(1).getCouleur(), Couleur.JAUNE);
    }

}