package jeu.cartes;

import java.util.Arrays;
import java.util.LinkedList;

public class PaquetDeCartes {

    LinkedList<Carte> pdc ;
    public PaquetDeCartes(LinkedList<Carte> pdc) {
        this.pdc = new LinkedList<>() ;
        this.pdc = pdc ;
    }
    public PaquetDeCartes() {
        this.pdc = new LinkedList<>() ;
    }
    public PaquetDeCartes(Carte ... cartes){
        this.pdc = new LinkedList<>() ;
        for(Carte carte: cartes){
            this.pdc.add(carte) ;
        }
    }
    public int getNbCartes(){
        return pdc.size() ;
    }

    public void ajouter(Carte ... cartes){
        for(Carte carte: cartes){
            this.pdc.add(carte) ;
        }
    }
}
