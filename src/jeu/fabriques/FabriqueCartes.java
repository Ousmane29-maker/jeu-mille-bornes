package jeu.fabriques;

import jeu.cartes.PaquetDeCartes;
import jeu.cartes.attaques.Accident;
import jeu.cartes.attaques.FeuRouge;
import jeu.cartes.bottes.AsDuVolant;
import jeu.cartes.bottes.CiterneDEssence;
import jeu.cartes.bottes.Increvable;
import jeu.cartes.bottes.Prioritaire;
import jeu.cartes.parades.FeuVert;

public class FabriqueCartes {

    public static PaquetDeCartes getPaquetVide(){
        return  new PaquetDeCartes() ;
    }

    public static PaquetDeCartes getPaquetBottes(){
        PaquetDeCartes pdc = new PaquetDeCartes() ;
        pdc.ajouter(new Prioritaire());
        pdc.ajouter(new Increvable());
        pdc.ajouter(new CiterneDEssence());
        pdc.ajouter(new AsDuVolant());
        return pdc ;
    }

    public static PaquetDeCartes getPaquet1Accident(){
        PaquetDeCartes pdc = new PaquetDeCartes() ;
        pdc.ajouter(new Accident());
        return pdc ;
    }

    public static PaquetDeCartes getPaquet1FeuRouge1FeuVert(){
        PaquetDeCartes pdc = new PaquetDeCartes() ;
        pdc.ajouter(new FeuRouge());
        pdc.ajouter(new FeuVert());
        return pdc ;
    }

}
