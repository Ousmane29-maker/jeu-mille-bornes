package jeu.joueurs;

import jeu.Jeu;

public class StrategieParDefaut implements Strategie{
    @Override
    public String choisirCoup(Jeu jeu) {
        Joueur joueurcourant =  jeu.getJoueur(jeu.getJoueurQuiJoue()) ;
        assert (joueurcourant.getNbCartesMain() > 0) : "le nombre de carte joueur courant est null" ;
        /*
        * Ca consiste à essayer de poser la premiere carte sur le joueur Humain
        * puis sur notre jeu
        * et enfin ca ne marche pas  on la jette
         */
        String coup ;
        coup = jeu.coupPossible("P1") ? "P1" : null ; // On essaye de poser la premiere carte sur notre jeu

        // On essaye de la poser sur les joueurs adverse en commencant par le premier joueurs, si on a pas reussi en haut
        int i = 1 ;
        while(i <= jeu.getNbJoueurs() && coup == null) {
            if(i != jeu.getJoueurQuiJoue()){ // eviter le cas ou le joueur adverse est le joueur qui joue
                String coupAtester = "P1"+i ;
                coup = jeu.coupPossible(coupAtester) ? coupAtester : null ;
            }
            i++ ;
        }
        if(coup == null){ // si par manque de chanche on ne peut la jouer, on la jette
            coup = "J1" ;
        }
        return  coup ;
    }
}
