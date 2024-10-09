package jeu.cartes;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class PaquetDeCartes {
    LinkedList<Carte> pdc ;

    /**
     * Création d'un paquet de cartes vide
     */
    public PaquetDeCartes() {
        this.pdc = new LinkedList<>() ;
    }
    /**
     * Création d'un paquet à partir d'un tableau de cartes (paquet vide, si cartes == null)
     */
    public PaquetDeCartes(Carte ... cartes){
        this.pdc = new LinkedList<>() ;
        if(cartes != null){
            Collections.addAll(this.pdc, cartes) ;
        }

    }

    /**
     * Création d'un paquet à partir d'un autre paquet . PAS DE PARTAGE
     * @exception AssertionError - si pdc == null
     * @param pdc un paquet de cartes
     */
    public PaquetDeCartes(PaquetDeCartes pdc) {
        assert (pdc != null) : "le parametre pdc ne doit pas etre egale null" ;
        this.pdc = new LinkedList<>() ;
        for(Carte carte : pdc.pdc){
            this.pdc.add(new Carte(carte.getCouleur())) ;
        }
    }

    /**
     * @return le nombre de cartes
     */
    public int getNbCartes(){
        return pdc.size() ;
    }

    /**
     * @param no le numero de carte
     * @return la carte choisie
     * @exception AssertionError - si le numéro est négatif ou supérieur ou égal au nombre de cartes
     */
    public Carte getCarte(int no){
        assert(no >= 0 && no < this.getNbCartes()) : "le numéro doit etre positif et strictement inferieur au nombre de cartes" ;
        return this.pdc.get(no) ;
    }

    /**
     * Ajouter une ou plusieurs cartes
     * @param cartes les cartes a ajouter
     * @exception  AssertionError - si cartes == null
     */
    public void ajouter(Carte ... cartes){
        assert (cartes != null) : "cartes ne doit pas etre null" ;
        for(Carte carte: cartes){
            this.pdc.add(carte) ;
        }
    }

    /**
     * Ajouter toutes les cartes du paquet
     * @param pdc le paquet a ajouter
     * @exception  AssertionError - si pdc == null
     */
    public void ajouter(PaquetDeCartes pdc){
        assert (pdc != null) : "pdc ne doit pas etre null" ;
        this.pdc.addAll(pdc.pdc) ;
    }


}
