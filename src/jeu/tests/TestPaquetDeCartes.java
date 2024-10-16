package jeu.tests;
import jeu.cartes.Carte ;
import jeu.cartes.Couleur;
import jeu.cartes.PaquetDeCartes;
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
        Carte carte1 = new Carte(Couleur.VERT) ;
        Carte carte2 = new Carte(Couleur.JAUNE) ;
        PaquetDeCartes pdc = new PaquetDeCartes(carte1, carte2) ;
        assertEquals(pdc.getNbCartes(), 2) ;
        assertEquals(pdc.getCarte((0)), carte1);
        assertEquals(pdc.getCarte((1)), carte2);

    }
    @Test
    void testConstructeurAvecPdcEnParam(){
        PaquetDeCartes pdcNull = null ;
        assertThrows(AssertionError.class, () -> new  PaquetDeCartes(pdcNull));
        PaquetDeCartes pdc1 = FabriqueCartes.getPaquet1Vert1Jaune() ;
        PaquetDeCartes pdc2 = new PaquetDeCartes(pdc1) ;
        //Pas de partage donc l'adresse des objets sont diff
        assertFalse (pdc1.getCarte(0) ==pdc2.getCarte(0));
        assertFalse (pdc1.getCarte(1) == pdc2.getCarte(1));
    }

    @Test
    void testAjouter() {
        PaquetDeCartes pdc = new PaquetDeCartes() ;
        Carte carte1 = new Carte(Couleur.VERT) ;
        pdc.ajouter(carte1);
        assertEquals(pdc.getNbCartes(),1);
        assertEquals(pdc.getCarte(0), carte1);
    }
    @Test
    void testAjouterAvecPdc() {
        PaquetDeCartes pdc1 = new PaquetDeCartes() ;
        PaquetDeCartes pdc2 = FabriqueCartes.getPaquet1Vert1Jaune();
        assertThrows(AssertionError.class, () -> pdc1.ajouter((PaquetDeCartes) null));
        pdc1.ajouter(pdc2);
        assertEquals(pdc1.getNbCartes(),2);
        assertEquals(pdc1.getCarte(0).getCouleur(), Couleur.VERT);
        assertEquals(pdc1.getCarte(1).getCouleur(), Couleur.JAUNE);
    }

    @Test
    void testEstVideFaux(){
        PaquetDeCartes pdc = FabriqueCartes.getPaquet1Vert() ;
        assertFalse(pdc.estVide());
    }
    @Test
    void testEstVideVrai(){
        PaquetDeCartes pdc = FabriqueCartes.getPaquetVide() ;
        assertTrue(pdc.estVide());
    }

    @Test
    void testMelanger(){
        PaquetDeCartes pdc = FabriqueCartes.getPaquet1Vert1Jaune();
        pdc.ajouter(new Carte(Couleur.ROUGE));
        PaquetDeCartes pdcCopied = new PaquetDeCartes(pdc) ;
        pdcCopied.melanger();
        assertEquals(pdc.getNbCartes(), pdcCopied.getNbCartes());

    }
@Test
void testRetourner(){
    Carte carte1 = new Carte(Couleur.VERT) ;
    Carte carte2 = new Carte(Couleur.JAUNE) ;
    Carte carte3 = new Carte(Couleur.ROUGE) ;
    PaquetDeCartes pdc = FabriqueCartes.getPaquetVide() ;
    pdc.ajouter(carte1, carte2, carte3);
    pdc.retourner();
    // Vérifier que le paquet contient toujours 3 cartes
    assertEquals(pdc.getNbCartes(), 3);

    // Vérifier que l'ordre est inversé
    assertTrue(pdc.getCarte(0).equals(carte3)); // La carte rouge doit être en première position
    assertTrue(pdc.getCarte(1).equals(carte2)); // La carte jaune reste au milieu
    assertTrue(pdc.getCarte(2).equals(carte1)); // La carte verte doit être en dernière position
    }
@Test
    void testgetSommet(){
    Carte carte1 = new Carte(Couleur.VERT) ;
    Carte carte2 = new Carte(Couleur.JAUNE) ;
    Carte carte3 = new Carte(Couleur.ROUGE) ;
    PaquetDeCartes pdc = FabriqueCartes.getPaquetVide() ;
    pdc.ajouter(carte1, carte2, carte3);
    assertEquals(pdc.getNbCartes(), 3);
    assertTrue(pdc.getSommet().equals(carte1));
    }
    @Test
    void testEnlever(){
        Carte carte1 = new Carte(Couleur.VERT) ;
        Carte carte2 = new Carte(Couleur.BLEU) ;
        PaquetDeCartes pdc = new PaquetDeCartes(carte1, carte2) ;
        assertThrows(AssertionError.class, () -> pdc.enlever((Carte) null));
        assertEquals(pdc.getNbCartes(), 2);
        pdc.enlever(carte1);
        assertTrue(pdc.getSommet().equals(carte2));
        assertEquals(pdc.getNbCartes(), 1);

    }

    @Test
    void testPiocher(){
        Carte carte1 = new Carte(Couleur.ROUGE) ;
        Carte carte2 = new Carte(Couleur.JAUNE) ;
        PaquetDeCartes pdc = new PaquetDeCartes(carte1, carte2) ;
        assertEquals(pdc.getNbCartes(), 2);
        Carte CartePiochee = pdc.piocher();
        assertTrue(pdc.getSommet().equals(carte2));
        assertEquals(pdc.getNbCartes(), 1);
        assertTrue(CartePiochee.equals(carte1));
    }
    @Test
    void testEqualsFaux(){
        PaquetDeCartes pdc  = FabriqueCartes.getPaquet1Vert1Jaune() ;
        PaquetDeCartes pdc2 = FabriqueCartes.getPaquet1Jaune() ;
        assertFalse(pdc.equals(pdc2));
    }

    @Test
    void testEqualsVrai(){
        PaquetDeCartes pdc  = FabriqueCartes.getPaquet1Vert1Jaune() ;
        PaquetDeCartes pdc2 = FabriqueCartes.getPaquet1Vert() ;
        pdc2.ajouter(new Carte(Couleur.JAUNE));
        assertTrue(pdc.equals(pdc2));
    }

}