package jeu.fabriques;

import jeu.cartes.Carte;
import jeu.cartes.Couleur;
import jeu.cartes.PaquetDeCartes;

public class FabriqueCartes {

    public static PaquetDeCartes getPaquetVide(){
        return  new PaquetDeCartes() ;
    }

    public static PaquetDeCartes getPaquet1Vert(){
        PaquetDeCartes pdc = new PaquetDeCartes() ;
        for(int i = 0 ; i < 32; i++){
            pdc.ajouter(new Carte(Couleur.VERT)); ;
        }
        return pdc ;
    }
}
