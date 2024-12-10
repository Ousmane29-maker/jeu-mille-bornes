package jeu.fabriques;

import jeu.cartes.PaquetDeCartes;
import jeu.cartes.attaques.Accident;
import jeu.cartes.attaques.Crevaison;
import jeu.cartes.attaques.FeuRouge;
import jeu.cartes.bornes.Bornes;
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

    public static PaquetDeCartes getPaquetAvecDifferentsCartes() {
        PaquetDeCartes pdc = new PaquetDeCartes();

        // Ajout de plusieurs cartes du même type
        for (int i = 0; i < 3; i++) {
            pdc.ajouter(new FeuRouge());    // 3 FeuRouge
        }
        for (int i = 0; i < 2; i++) {
            pdc.ajouter(new FeuVert());     // 2 FeuVert
        }
        for (int i = 0; i < 4; i++) {
            pdc.ajouter(new Accident());    // 4 Accident
        }
        for (int i = 0; i < 2; i++) {
            pdc.ajouter(new Crevaison());   // 2 Crevaison
        }


        // Ajout de plusieurs cartes Bornes avec différentes valeurs
        for (int i = 0; i < 2; i++) {
            pdc.ajouter(new Bornes(100));   // 2 Bornes(100)
        }
        for (int i = 0; i < 3; i++) {
            pdc.ajouter(new Bornes(50));    // 3 Bornes(50)
        }
        pdc.ajouter(new Bornes(25));        // 1 Bornes(25) supplémentaire
        pdc.ajouter(new Bornes(75));        // 1 Bornes(75) supplémentaire


        // Ajout de plusieurs cartes Increvable et As Du Volant si nécessaire
        for (int i = 0; i < 2; i++) {
            pdc.ajouter(new Increvable()); // 2 Increvable
        }
        for (int i = 0; i < 3; i++) {
            pdc.ajouter(new AsDuVolant()); // 3 As Du Volant
        }

        return pdc;
    }

    public static PaquetDeCartes getPaquetStandard() {
        PaquetDeCartes pdc = new PaquetDeCartes() ;
        // A completer ..
        return  pdc ;
    }
}
