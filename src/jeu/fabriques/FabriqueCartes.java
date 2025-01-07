package jeu.fabriques;

import jeu.ErreurFichier;
import jeu.cartes.PaquetDeCartes;
import jeu.cartes.attaques.*;
import jeu.cartes.bornes.Bornes;
import jeu.cartes.bottes.AsDuVolant;
import jeu.cartes.bottes.CiterneDEssence;
import jeu.cartes.bottes.Increvable;
import jeu.cartes.bottes.Prioritaire;
import jeu.cartes.parades.*;

public class FabriqueCartes {

    public FabriqueCartes() {

    }

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
        try{
            pdc.lire("ressources/cartes_standard.txt");
        } catch (ErreurFichier e) {
            throw new RuntimeException(e);
        }

        return  pdc ;
    }

    public static PaquetDeCartes getPaquetStandardManuel() {
        PaquetDeCartes pdc = new PaquetDeCartes();

        // Cartes Prioritaires
        pdc.ajouter(new Prioritaire());

        // Cartes Citerne d'Essence
        pdc.ajouter(new CiterneDEssence());

        // Cartes Increvable
        pdc.ajouter(new Increvable());

        // Cartes As du Volant
        pdc.ajouter(new AsDuVolant());

        // Cartes Feu Rouge (5 cartes)
        for (int i = 0; i < 5; i++) {
            pdc.ajouter(new FeuRouge());
        }

        // Cartes Limitation de Vitesse (4 cartes)
        for (int i = 0; i < 4; i++) {
            pdc.ajouter(new LimitationDeVitesse());
        }

        // Cartes Panne d'Essence (3 cartes)
        for (int i = 0; i < 3; i++) {
            pdc.ajouter(new PanneDEssence());
        }

        // Cartes Crevaison (3 cartes)
        for (int i = 0; i < 3; i++) {
            pdc.ajouter(new Crevaison());
        }

        // Cartes Accident (3 cartes)
        for (int i = 0; i < 3; i++) {
            pdc.ajouter(new Accident());
        }

        // Cartes Feu Vert (14 cartes)
        for (int i = 0; i < 14; i++) {
            pdc.ajouter(new FeuVert());
        }

        // Cartes Fin Limitation de Vitesse (6 cartes)
        for (int i = 0; i < 6; i++) {
            pdc.ajouter(new FinLimitationDeVitesse());
        }

        // Cartes Essence (6 cartes)
        for (int i = 0; i < 6; i++) {
            pdc.ajouter(new Essence());
        }

        // Cartes Roue de Secours (6 cartes)
        for (int i = 0; i < 6; i++) {
            pdc.ajouter(new RoueDeSecours());
        }

        // Cartes Réparation (6 cartes)
        for (int i = 0; i < 6; i++) {
            pdc.ajouter(new Reparation());
        }

        // Cartes Bornes 25 (10 cartes)
        for (int i = 0; i < 10; i++) {
            pdc.ajouter(new Bornes(25));
        }

        // Cartes Bornes 50 (10 cartes)
        for (int i = 0; i < 10; i++) {
            pdc.ajouter(new Bornes(50));
        }

        // Cartes Bornes 75 (10 cartes)
        for (int i = 0; i < 10; i++) {
            pdc.ajouter(new Bornes(75));
        }

        // Cartes Bornes 100 (12 cartes)
        for (int i = 0; i < 12; i++) {
            pdc.ajouter(new Bornes(100));
        }

        // Cartes Bornes 200 (4 cartes)
        for (int i = 0; i < 4; i++) {
            pdc.ajouter(new Bornes(200));
        }

        // Retourner le paquet de cartes rempli
        return pdc;
    }
}
