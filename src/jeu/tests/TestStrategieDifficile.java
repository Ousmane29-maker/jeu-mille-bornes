package jeu.tests;

import jeu.Jeu;
import jeu.cartes.Bottes;
import jeu.cartes.attaques.Accident;
import jeu.cartes.attaques.FeuRouge;
import jeu.cartes.bornes.Bornes;
import jeu.cartes.bottes.AsDuVolant;
import jeu.cartes.parades.Essence;
import jeu.joueurs.*;
import jeu.joueurs.strategie.Strategie;
import jeu.joueurs.strategie.StrategieDifficile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestStrategieDifficile {

    @Test
    void testChoisirAvecNbCartesJoueurNull() {
        Jeu jeu = new Jeu();
        Strategie strategieBot1 = new StrategieDifficile();
        Strategie strategieBot2 = new StrategieDifficile();
        Joueur bot1 = new Bot(jeu, "Bot1", strategieBot1);
        Joueur bot2 = new Bot(jeu, "Bot2", strategieBot2);
        jeu.add(bot1);
        jeu.add(bot2);
        assertThrows(AssertionError.class, () -> strategieBot1.choisirCoup(jeu));
        assertThrows(AssertionError.class, () -> strategieBot2.choisirCoup(jeu));
    }

    @Test
    void testChoisirPoserBorneAvecKmsRestants() {
        Jeu jeu = new Jeu();
        Strategie strategie = new StrategieDifficile();
        Joueur bot1 = new Bot(jeu, "Bot1", strategie);

        // Ajouter des cartes à la main du bot
        bot1.ajouterMain(new Bornes(50)); // Carte jouable, 50kms
        bot1.ajouterMain(new Bornes(75)); // Carte jouable, 75kms
        bot1.ajouterMain(new Bornes(100)); // Carte jouable, 100kms
        bot1.ajouterMain(new Bornes(200)); // Carte jouable, 200kms

        // Ajouter un joueur humain
        Joueur joueurHumain = new JoueurHumain(jeu, "JoueurHumain");
        jeu.add(bot1);
        jeu.add(joueurHumain);

        // La stratégie va choisir la carte de borne qui permet de s'approcher des 1000kms sans dépasser
        assertTrue(strategie.choisirCoup(jeu).equals("P4")); // Carte avec 200kms

    }

    @Test
    void testChoisirBotteAsDuVolant() {
        Jeu jeu = new Jeu();
        Strategie strategie = new StrategieDifficile();
        Joueur bot1 = new Bot(jeu, "Bot1", strategie);
        bot1.ajouterMain(new FeuRouge());
        bot1.ajouterMain(new Bornes(100)) ;
        bot1.ajouterMain(new AsDuVolant()) ;

        // Ajouter le joueur
        jeu.add(bot1);
        // La stratégie difficile doit choisir la Botte AsDuvolant, donc "P3"
        assertTrue(strategie.choisirCoup(jeu).equals("P3"));
    }

    @Test
    void testChoisirPoserAttaqueSurJeuAdversaire() {
        Jeu jeu = new Jeu();
        Strategie strategie = new StrategieDifficile();
        Joueur bot1 = new Bot(jeu, "Bot1", strategie);

        // Ajouter des cartes au Bot
        bot1.ajouterMain(new FeuRouge());
        bot1.ajouterMain(new Accident());
        bot1.ajouterMain(new Bornes(100)) ;
        bot1.ajouterMain(new Essence()) ;

        // Definir un joueur humain immunise contre le FeuRouge
        Joueur joueurHumain = new JoueurHumain(jeu, "JoueurHumain");
        Bottes bottes = new Bottes();
        bottes.setEstPrioritaire();
        joueurHumain.setBottes(bottes);

        //Ajouter les joueurs
        jeu.add(bot1);
        jeu.add(joueurHumain);

        // La stratégie difficile devrait choisir l'attaque sur l'adversaire
        // Ici l'accident
        assertTrue(strategie.choisirCoup(jeu).equals("P22"));
    }

    @Test
    void testChoisirJeterCarteRedondante() {
        Jeu jeu = new Jeu();
        Strategie strategie = new StrategieDifficile();
        Joueur bot1 = new Bot(jeu, "Bot1", strategie);

        // Ajouter des cartes au Bot
        bot1.ajouterMain(new FeuRouge());
        bot1.ajouterMain(new Essence()) ;
        bot1.ajouterMain(new Essence()) ;

        // Definir un joueur humain immunise contre le FeuRouge
        Joueur joueurHumain = new JoueurHumain(jeu, "JoueurHumain");
        Bottes bottes = new Bottes();
        bottes.setEstPrioritaire();
        joueurHumain.setBottes(bottes);

        // Ajouter les joueurs
        jeu.add(bot1);
        jeu.add(joueurHumain);

        // La stratégie difficile devrait jeter la carte redondante, donc "J2"
        assertTrue(strategie.choisirCoup(jeu).equals("J2"));
    }
}
