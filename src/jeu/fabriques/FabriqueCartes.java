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
        pdc.ajouter(new Carte(Couleur.VERT));
        return pdc ;
    }
    public static PaquetDeCartes getPaquet1Jaune(){
        PaquetDeCartes pdc = new PaquetDeCartes() ;
        pdc.ajouter(new Carte(Couleur.JAUNE));
        return pdc ;
    }
    public static PaquetDeCartes getPaquet1Vert1Jaune(){
        PaquetDeCartes pdc = new PaquetDeCartes() ;
        pdc.ajouter(new Carte(Couleur.VERT));
        pdc.ajouter(new Carte(Couleur.JAUNE));
        return pdc ;
    }

}
