package jeu.tests;

import jeu.Jeu;
import jeu.cartes.Bottes;
import jeu.cartes.attaques.FeuRouge;
import jeu.cartes.bornes.Bornes;
import jeu.joueurs.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestStrategieParDefaut {

    @Test
    void testChoisirAvecNbCartesJoueurNull() {
        Jeu jeu = new Jeu() ;
        Strategie strategieBot1 = new StrategieParDefaut() ;
        Strategie strategieBot2 = new StrategieParDefaut() ;
        Joueur bot1 = new Bot(jeu, "Bot1", strategieBot1) ;
        Joueur bot2 = new Bot(jeu, "Bot2", strategieBot2) ;
        jeu.add(bot1);
        jeu.add(bot2) ;
        assertThrows(AssertionError.class, () -> strategieBot1.choisirCoup(jeu)) ;
        assertThrows(AssertionError.class, () -> strategieBot2.choisirCoup(jeu)) ;

    }
    @Test
    void testChoisirposerSurMonJeu() {
        Jeu jeu = new Jeu() ;
        Strategie strategie = new StrategieParDefaut() ;
        Joueur bot1 = new Bot(jeu, "Bot1", strategie) ;
        bot1.ajouterMain(new Bornes(50));
        Joueur joueurHumain = new JoueurHumain(jeu, "JoueurHumain") ;
        jeu.add(bot1);
        jeu.add(joueurHumain) ;
        assertTrue(strategie.choisirCoup(jeu).equals("P1"));
    }

    @Test
    void testChoisirposerSurJeuAdverseEtJeter() {
        Jeu jeu = new Jeu() ;
        Strategie strategie = new StrategieParDefaut() ;
        Joueur bot1 = new Bot(jeu, "Bot1", strategie) ;
        Bottes bottes = new Bottes() ;
        bottes.setEstPrioritaire();
        Joueur joueurHumain = new JoueurHumain(jeu, "JoueurHumain", bottes, null) ; //le joueurHumain est immunisé contre FeuRouge
        Joueur bot2 = new Bot(jeu, "Bot1", strategie) ;
        bot1.ajouterMain(new FeuRouge());
        jeu.add(bot1);
        jeu.add(joueurHumain) ;
        jeu.add(bot2);
        // la carte est posee sur le 3em joueur puisque le deuxieme est immunise
        assertTrue(strategie.choisirCoup(jeu).equals("P13"));
        bot2.setBottes(bottes); // on immunise le bot2 aussi  contre FeuRouge
        // la carte est jetee puisqu'ils sont immunises tous les 2
        assertTrue(strategie.choisirCoup(jeu).equals("J1"));
    }



}