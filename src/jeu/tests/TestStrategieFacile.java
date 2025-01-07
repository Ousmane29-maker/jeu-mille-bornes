package jeu.tests;

import jeu.Jeu;
import jeu.cartes.Bottes;
import jeu.cartes.attaques.FeuRouge;
import jeu.cartes.bornes.Bornes;
import jeu.joueurs.*;
import jeu.joueurs.strategie.Strategie;
import jeu.joueurs.strategie.StrategieFacile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestStrategieFacile {
    @Test
    void testChoisirAvecNbCartesJoueurNull() {
        Jeu jeu = new Jeu();
        Strategie strategieBot1 = new StrategieFacile();
        Strategie strategieBot2 = new StrategieFacile();
        Joueur bot1 = new Bot(jeu, "Bot1", strategieBot1);
        Joueur bot2 = new Bot(jeu, "Bot2", strategieBot2);
        jeu.add(bot1);
        jeu.add(bot2);
        assertThrows(AssertionError.class, () -> strategieBot1.choisirCoup(jeu));
        assertThrows(AssertionError.class, () -> strategieBot2.choisirCoup(jeu));
    }

    @Test
    void testChoisirposerSurMonJeuAvecPlusieursCartes() {
        Jeu jeu = new Jeu();
        Strategie strategie = new StrategieFacile();
        Joueur bot1 = new Bot(jeu, "Bot1", strategie);

        // Ajouter des cartes à la main du bot, la première carte n'est pas jouable
        bot1.ajouterMain(new FeuRouge()); // Première carte non jouable sur son propre jeu
        bot1.ajouterMain(new Bornes(50)); // Deuxième carte jouable sur son propre jeu
        bot1.ajouterMain(new Bornes(75)); // Troisième carte également jouable

        Joueur joueurHumain = new JoueurHumain(jeu, "JoueurHumain");
        jeu.add(bot1);
        jeu.add(joueurHumain);

        // La stratégie devrait choisir la première carte jouable, ici "P2"
        assertTrue(strategie.choisirCoup(jeu).equals("P2"));
    }

    @Test
    void testChoisirposerSurJeuAdverseEtJeter() {
        Jeu jeu = new Jeu();
        Strategie strategie = new StrategieFacile();
        Joueur bot1 = new Bot(jeu, "Bot1", strategie);
        Bottes bottes = new Bottes();
        bottes.setEstPrioritaire();
        Joueur joueurHumain = new JoueurHumain(jeu, "JoueurHumain", bottes, null); // joueurHumain immunisé contre FeuRouge
        Joueur bot2 = new Bot(jeu, "Bot2", strategie);
        bot1.ajouterMain(new FeuRouge());
        jeu.add(bot1);
        jeu.add(joueurHumain);
        jeu.add(bot2);

        // La carte est posée sur le 3ème joueur puisque le 2ème est immunisé
        assertTrue(strategie.choisirCoup(jeu).equals("P13"));

        bot2.setBottes(bottes); // Immuniser bot2 contre FeuRouge
        // La carte est jetée puisqu'ils sont immunisés tous les deux
        assertTrue(strategie.choisirCoup(jeu).equals("J1"));
    }



}