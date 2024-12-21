package jeu.joueurs;

import jeu.Jeu;

import java.text.StringCharacterIterator;

public interface Strategie  {

    public String choisirCoup(Jeu jeu) ;
    public String toString() ;

    /*
     * Strategie trivial : J1
     * Basique : P1 > P1j> J1
     * Facile : Pi > Pij > J1
     * Difficile(s) : 1) Filtrer tous les coups possibles.
                    * 2) Valuer les coups possibles (ca depends des etats passe et present.
                        * privilegier les bornes OU
                        * privilegier les attaques
                        * quoi jeter ??? aussi important
                    * 3)Jouer le meuilleur coup
     */
}
