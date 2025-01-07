package jeu.joueurs.strategie;

import jeu.Jeu;
import jeu.joueurs.Joueur;
import jeu.joueurs.strategie.Strategie;

public class StrategieBasique implements Strategie {


    public StrategieBasique() {

    }

    @Override
    public String choisirCoup(Jeu jeu) {
        //  Basique : P1 > P1j> J1
        Joueur joueurCourant =  jeu.getJoueurCourant() ;
        assert (joueurCourant.getNbCartesMain() > 0) : "Le joueurCourant n'a aucune carte en main" ;
        String coup ;
        coup = joueurCourant.coupPossible("P1") ? "P1" : null ; // On essaye de poser la premiere carte sur notre jeu
        // On essaye de la poser sur les joueurs adverse en commencant par le premier joueurs, si on a pas reussi en haut
        int i = 1 ;
        while(i <= jeu.getNbJoueurs() && coup == null) {
            if(i != jeu.getJoueurQuiJoue()){ // eviter le cas ou le joueur adverse est le joueur qui joue
                String coupAtester = "P1"+i ;
                coup = joueurCourant.coupPossible(coupAtester) ? coupAtester : null ;
            }
            i++ ;
        }
        if(coup == null){ // si par manque de chanche on ne peut la jouer, on la jette
            coup = "J1" ;
        }
        return  coup ;
    }

    @Override
    public String toString() {
        return "StrategieBasique";
    }
}
