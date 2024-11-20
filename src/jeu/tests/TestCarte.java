package jeu.tests;

import jeu.Jeu;
import jeu.cartes.*;
import jeu.cartes.attaques.Accident;
import jeu.cartes.attaques.Crevaison;
import jeu.cartes.attaques.FeuRouge;
import jeu.cartes.attaques.PanneDEssence;
import jeu.cartes.bornes.*;
import jeu.cartes.bottes.AsDuVolant;
import jeu.cartes.bottes.CiterneDEssence;
import jeu.cartes.bottes.Increvable;
import jeu.cartes.bottes.Prioritaire;
import jeu.cartes.parades.Essence;
import jeu.cartes.parades.FeuVert;
import jeu.cartes.parades.Reparation;
import jeu.cartes.parades.RoueDeSecours;
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
        //cas ou le joueur est immunise contre Accident
        Bottes bottes = new Bottes() ;
        bottes.setEstAsDuVolant();
        Joueur j = new Joueur(new Jeu(), "joueur_A", bottes, null) ;
        Carte carteAccident = new Accident() ;
        assertThrows(AssertionError.class, () -> carteAccident.peutEtrePoseeSurJeuAdversaire(null)) ;
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
        //cas ou le joueur est immunise contre FeuRouge
        Bottes bottes = new Bottes() ;
        bottes.setEstPrioritaire();
        Joueur j = new Joueur(new Jeu(), "joueur_A", bottes, null) ;
        Carte carteFeuRouge = new FeuRouge() ;
        assertThrows(AssertionError.class, () -> carteFeuRouge.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertFalse(carteFeuRouge.peutEtrePoseeSurJeuAdversaire(j));
    }
    @Test
    public void TestParadePeutEtrePoseeSurJeuAdversaire(){
        Jeu jeu = new Jeu() ;
        Joueur j = new Joueur(jeu, "joueur_A") ;
        Carte carteFeuVert = new FeuVert() ;
        Carte carteReparation = new Reparation() ;
        Carte carteEssence = new Essence() ;
        Carte carteRoueDeSecours = new RoueDeSecours() ;
        assertThrows(AssertionError.class, () -> carteFeuVert.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertThrows(AssertionError.class, () -> carteReparation.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertThrows(AssertionError.class, () -> carteEssence.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertThrows(AssertionError.class, () -> carteRoueDeSecours.peutEtrePoseeSurJeuAdversaire(null)) ;

        assertFalse(carteFeuVert.peutEtrePoseeSurJeuAdversaire(j));
        assertFalse(carteReparation.peutEtrePoseeSurJeuAdversaire(j));
        assertFalse(carteEssence.peutEtrePoseeSurJeuAdversaire(j));
        assertFalse(carteRoueDeSecours.peutEtrePoseeSurJeuAdversaire(j));
    }

    @Test
    public void TestReparationPeutEtrePoseeSurMonJeuVrai(){
        Jeu jeu = new Jeu() ;
        Joueur j = new Joueur(jeu, "joueur_A", null, new Accident()) ;
        Carte carteReparation = new Reparation() ;
        assertThrows(AssertionError.class, () -> carteReparation.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertTrue(carteReparation.peutEtrePoseeSurMonJeu(j)) ;

    }

    @Test
    public void TestReparationPeutEtrePoseeSurMonJeuFaux(){
        Jeu jeu = new Jeu() ;
        Joueur j = new Joueur(jeu, "joueur_A", null, null) ;
        Carte carteReparation = new Reparation() ;
        assertThrows(AssertionError.class, () -> carteReparation.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertFalse(carteReparation.peutEtrePoseeSurMonJeu(j));

        Joueur j2 = new Joueur(jeu, "joueur_A", null, new FeuVert()) ;
        assertFalse(carteReparation.peutEtrePoseeSurMonJeu(j2));

    }

    @Test
    public void TestFeuVertPeutEtrePoseeSurMonJeuVrai(){
        Jeu jeu = new Jeu() ;
        Joueur j = new Joueur(jeu, "joueur_A", null, new FeuRouge()) ;
        Carte feuVert = new FeuVert() ;
        assertThrows(AssertionError.class, () -> feuVert.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertTrue(feuVert.peutEtrePoseeSurMonJeu(j)) ;
    }

    @Test
    public void TestFeuVertPeutEtrePoseeSurMonJeuFaux(){
        Jeu jeu = new Jeu() ;
        Joueur j = new Joueur(jeu, "joueur_A", null, null) ;
        Carte feuVert = new FeuVert() ;
        assertThrows(AssertionError.class, () -> feuVert.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertFalse(feuVert.peutEtrePoseeSurMonJeu(j)) ;

        Joueur j2 = new Joueur(jeu, "joueur_A", null, new Accident()) ;
        assertFalse(feuVert.peutEtrePoseeSurMonJeu(j2));

    }

    @Test
    public void TestEssencePeutEtrePoseeSurMonJeuVrai(){
        Jeu jeu = new Jeu() ;
        Joueur j = new Joueur(jeu, "joueur_A", null, new PanneDEssence()) ;
        Carte essence = new Essence() ;
        assertThrows(AssertionError.class, () -> essence.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertTrue(essence.peutEtrePoseeSurMonJeu(j)) ;
    }

    @Test
    public void TestEssencePeutEtrePoseeSurMonJeuFaux(){
        Jeu jeu = new Jeu() ;
        Joueur j = new Joueur(jeu, "joueur_A", null, null) ;
        Carte essence = new Essence() ;
        assertThrows(AssertionError.class, () -> essence.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertFalse(essence.peutEtrePoseeSurMonJeu(j)) ;

        Joueur j2 = new Joueur(jeu, "joueur_A", null, new Accident()) ;
        assertFalse(essence.peutEtrePoseeSurMonJeu(j2));

    }

    @Test
    public void TestRoueDeSecoursPeutEtrePoseeSurMonJeuVrai(){
        Jeu jeu = new Jeu() ;
        Joueur j = new Joueur(jeu, "joueur_A", null, new Crevaison()) ;
        Carte roueDeSecours = new RoueDeSecours() ;
        assertThrows(AssertionError.class, () -> roueDeSecours.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertTrue(roueDeSecours.peutEtrePoseeSurMonJeu(j)) ;
    }

    @Test
    public void TestRoueDeSecoursPeutEtrePoseeSurMonJeuFaux(){
        Jeu jeu = new Jeu() ;
        Joueur j = new Joueur(jeu, "joueur_A", null, null) ;
        Carte roueDeSecours = new RoueDeSecours() ;
        assertThrows(AssertionError.class, () -> roueDeSecours.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertFalse(roueDeSecours.peutEtrePoseeSurMonJeu(j)) ;

        Joueur j2 = new Joueur(jeu, "joueur_A", null, new Accident()) ;
        assertFalse(roueDeSecours.peutEtrePoseeSurMonJeu(j2));

    }

    @Test
    public void TestBottePeutEtrePoseeSurJeuAdversaire(){
        Jeu jeu = new Jeu() ;
        Joueur j = new Joueur(jeu, "joueur_A") ;
        Carte prioritaire = new Prioritaire() ;
        Carte increvable = new Increvable() ;
        Carte citerneDEssence = new CiterneDEssence() ;
        Carte asDuVolant = new AsDuVolant() ;
        assertThrows(AssertionError.class, () -> prioritaire.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertThrows(AssertionError.class, () -> increvable.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertThrows(AssertionError.class, () -> citerneDEssence.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertThrows(AssertionError.class, () -> asDuVolant.peutEtrePoseeSurJeuAdversaire(null)) ;

        assertFalse(prioritaire.peutEtrePoseeSurJeuAdversaire(j));
        assertFalse(increvable.peutEtrePoseeSurJeuAdversaire(j));
        assertFalse(citerneDEssence.peutEtrePoseeSurJeuAdversaire(j));
        assertFalse(asDuVolant.peutEtrePoseeSurJeuAdversaire(j));
    }

    @Test
    public void TestBottePeutEtrePoseeSurMonJeu(){
        Jeu jeu = new Jeu() ;
        Joueur j = new Joueur(jeu, "joueur_A") ;
        Carte prioritaire = new Prioritaire() ;
        Carte increvable = new Increvable() ;
        Carte citerneDEssence = new CiterneDEssence() ;
        Carte asDuVolant = new AsDuVolant() ;
        assertThrows(AssertionError.class, () -> prioritaire.peutEtrePoseeSurMonJeu(null)) ;
        assertThrows(AssertionError.class, () -> increvable.peutEtrePoseeSurMonJeu(null)) ;
        assertThrows(AssertionError.class, () -> citerneDEssence.peutEtrePoseeSurMonJeu(null)) ;
        assertThrows(AssertionError.class, () -> asDuVolant.peutEtrePoseeSurMonJeu(null)) ;

        assertTrue(prioritaire.peutEtrePoseeSurMonJeu(j));
        assertTrue(increvable.peutEtrePoseeSurMonJeu(j));
        assertTrue(citerneDEssence.peutEtrePoseeSurMonJeu(j));
        assertTrue(asDuVolant.peutEtrePoseeSurMonJeu(j));
    }

    @Test
    public void TestBornesPeutEtrePoseeSurJeuAdversaire(){
        Jeu jeu = new Jeu() ;
        Joueur j = new Joueur(jeu, "joueur_A") ;
        Bornes borne25 = new Bornes(25) ;
        Bornes borne50 = new Bornes(50) ;
        Bornes borne75 = new Bornes(75) ;
        Bornes borne100 = new Bornes(100) ;
        Bornes borne200 = new Bornes(200) ;

        assertThrows(AssertionError.class, () -> borne25.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertThrows(AssertionError.class, () -> borne50.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertThrows(AssertionError.class, () -> borne75.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertThrows(AssertionError.class, () -> borne100.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertThrows(AssertionError.class, () -> borne200.peutEtrePoseeSurJeuAdversaire(null)) ;

        assertFalse(borne25.peutEtrePoseeSurJeuAdversaire(j));
        assertFalse(borne50.peutEtrePoseeSurJeuAdversaire(j));
        assertFalse(borne75.peutEtrePoseeSurJeuAdversaire(j));
        assertFalse(borne100.peutEtrePoseeSurJeuAdversaire(j));
        assertFalse(borne200.peutEtrePoseeSurJeuAdversaire(j));

    }

    @Test
    public void TestBornesPeutEtrePoseeSurMonJeu(){
        Jeu jeu = new Jeu() ;
        Joueur j = new Joueur(jeu, "joueur_A") ;
        Bornes borne25 = new Bornes(25) ;
        Bornes borne50 = new Bornes(50) ;
        Bornes borne75 = new Bornes(75) ;
        Bornes borne100 = new Bornes(100) ;
        Bornes borne200 = new Bornes(200) ;

        assertThrows(AssertionError.class, () -> borne25.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertThrows(AssertionError.class, () -> borne50.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertThrows(AssertionError.class, () -> borne75.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertThrows(AssertionError.class, () -> borne100.peutEtrePoseeSurJeuAdversaire(null)) ;
        assertThrows(AssertionError.class, () -> borne200.peutEtrePoseeSurJeuAdversaire(null)) ;

        assertTrue(borne25.peutEtrePoseeSurMonJeu(j));
        assertTrue(borne50.peutEtrePoseeSurMonJeu(j));
        assertTrue(borne75.peutEtrePoseeSurMonJeu(j));
        assertTrue(borne100.peutEtrePoseeSurMonJeu(j));
        assertTrue(borne200.peutEtrePoseeSurMonJeu(j));

        j.setLimitationVitesse();
        assertTrue(borne25.peutEtrePoseeSurMonJeu(j));
        assertTrue(borne50.peutEtrePoseeSurMonJeu(j));
        assertFalse(borne75.peutEtrePoseeSurMonJeu(j));
        assertFalse(borne100.peutEtrePoseeSurMonJeu(j));
        assertFalse(borne200.peutEtrePoseeSurMonJeu(j));

    }



}
