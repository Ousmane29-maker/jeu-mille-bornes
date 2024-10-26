package jeu.tests;
import jeu.cartes.Carte ;
import jeu.cartes.Couleur;
import jeu.cartes.PaquetDeCartes;
import jeu.cartes.attaques.Accident;
import jeu.cartes.attaques.Crevaison;
import jeu.cartes.attaques.FeuRouge;
import jeu.cartes.attaques.PanneDEssence;
import jeu.cartes.parades.FeuVert;
import jeu.fabriques.FabriqueCartes;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TestPaquetDeCartes {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testConstructeurVide() {
        PaquetDeCartes pdc = new PaquetDeCartes() ;
        assertEquals(pdc.getNbCartes(), 0) ;
        assertThrows(AssertionError.class, () -> pdc.getCarte(2)) ;
        assertThrows(AssertionError.class, () -> pdc.getCarte(-1)) ;

    }
    @Test
    void testConstructeurAvecCartesEnParam() {
        Carte carte1 = new FeuRouge();
        Carte carte2 = new FeuVert();
        PaquetDeCartes pdc = new PaquetDeCartes(carte1, carte2) ;
        assertEquals(pdc.getNbCartes(), 2) ;
        assertEquals(pdc.getCarte((0)), carte1);
        assertEquals(pdc.getCarte((1)), carte2);

    }
    @Test
    void testConstructeurAvecPdcEnParam(){
        PaquetDeCartes pdcNull = null ;
        assertThrows(AssertionError.class, () -> new  PaquetDeCartes(pdcNull));
        PaquetDeCartes pdc1 = FabriqueCartes.getPaquet1FeuRouge1FeuVert() ;
        PaquetDeCartes pdc2 = new PaquetDeCartes(pdc1) ;
        //Pas de partage donc l'adresse des objets sont diff
        assertFalse (pdc1.getCarte(0) == pdc2.getCarte(0));
        assertFalse (pdc1.getCarte(1) == pdc2.getCarte(1));
    }

    @Test
    void testAjouter() {
        PaquetDeCartes pdc = new PaquetDeCartes() ;
        Carte carte1 = new Accident();
        pdc.ajouter(carte1);
        assertEquals(pdc.getNbCartes(),1);
        assertEquals(pdc.getCarte(0), carte1);
    }
    @Test
    void testAjouterAvecPdc() {
        PaquetDeCartes pdc1 = new PaquetDeCartes() ;
        PaquetDeCartes pdc2 = FabriqueCartes.getPaquet1FeuRouge1FeuVert();
        assertThrows(AssertionError.class, () -> pdc1.ajouter((PaquetDeCartes) null));
        pdc1.ajouter(pdc2);
        assertEquals(pdc1.getNbCartes(),2);
        assertEquals(pdc1.getCarte(0).getClass(), FeuRouge.class);
        assertEquals(pdc1.getCarte(1).getClass(), FeuVert.class);
    }

    @Test
    void testEstVideFaux(){
        PaquetDeCartes pdc = FabriqueCartes.getPaquet1Accident() ;
        assertFalse(pdc.estVide());
    }
    @Test
    void testEstVideVrai(){
        PaquetDeCartes pdc = FabriqueCartes.getPaquetVide() ;
        assertTrue(pdc.estVide());
    }

    @Test
    void testMelanger(){
        PaquetDeCartes pdc = FabriqueCartes.getPaquet1FeuRouge1FeuVert();
        pdc.ajouter(new Accident());
        PaquetDeCartes pdcCopied = new PaquetDeCartes(pdc) ;
        pdcCopied.melanger();
        assertEquals(pdc.getNbCartes(), pdcCopied.getNbCartes());

    }
@Test
void testRetourner(){
    Carte carte1 = new Accident() ;
    Carte carte2 = new Crevaison();
    Carte carte3 = new PanneDEssence();
    PaquetDeCartes pdc = FabriqueCartes.getPaquetVide() ;
    pdc.ajouter(carte1, carte2, carte3);
    pdc.retourner();
    // Vérifier que le paquet contient toujours 3 cartes
    assertEquals(pdc.getNbCartes(), 3);

    // Vérifier que l'ordre est inversé
    assertTrue(pdc.getCarte(0).getClass().equals(carte3.getClass())); // La carte PanneDEssence doit être en première position
    assertTrue(pdc.getCarte(1).getClass().equals(carte2.getClass())); // La carte Crevaison reste au milieu
    assertTrue(pdc.getCarte(2).getClass().equals(carte1.getClass())); // La carte Accident doit être en dernière position
    }
@Test
    void testgetSommet(){
        Carte carte1 = new Accident() ;
        Carte carte2 = new Crevaison();
        Carte carte3 = new PanneDEssence();
        PaquetDeCartes pdc = FabriqueCartes.getPaquetVide() ;
        pdc.ajouter(carte1, carte2, carte3);
        assertEquals(pdc.getNbCartes(), 3);
        assertTrue(pdc.getSommet().getClass().equals(carte1.getClass()));
    }
    @Test
    void testEnlever(){
        Carte carte1 = new FeuRouge() ;
        Carte carte2 = new FeuVert();
        PaquetDeCartes pdc = new PaquetDeCartes(carte1, carte2) ;
        assertThrows(AssertionError.class, () -> pdc.enlever((Carte) null));
        assertEquals(pdc.getNbCartes(), 2);
        pdc.enlever(carte1);
        assertTrue(pdc.getSommet().getClass().equals(carte2.getClass()));
        assertEquals(pdc.getNbCartes(), 1);

    }

    @Test
    void testPiocher(){
        Carte carte1 = new FeuRouge() ;
        Carte carte2 = new FeuVert();
        PaquetDeCartes pdc = new PaquetDeCartes(carte1, carte2) ;
        assertEquals(pdc.getNbCartes(), 2);
        Carte CartePiochee = pdc.piocher();
        assertTrue(pdc.getSommet().getClass().equals(carte2.getClass()));
        assertEquals(pdc.getNbCartes(), 1);
        assertTrue(CartePiochee.getClass().equals(carte1.getClass()));
    }
    @Test
    void testEqualsFaux(){
        PaquetDeCartes pdc  = FabriqueCartes.getPaquet1FeuRouge1FeuVert() ;
        PaquetDeCartes pdc2 = FabriqueCartes.getPaquet1Accident() ;
        assertFalse(pdc.equals(pdc2));
    }

    @Test
    void testEqualsVrai(){
        PaquetDeCartes pdc  = FabriqueCartes.getPaquet1FeuRouge1FeuVert() ;
        PaquetDeCartes pdc2 = FabriqueCartes.getPaquetVide() ;
        pdc2.ajouter(new FeuRouge(), new FeuVert());
        assertTrue(pdc.equals(pdc2));
    }


}