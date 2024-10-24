//package jeu.cartes;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.LinkedList;
//
//public class PaquetDeCartes {
//    LinkedList<Carte> pdc ;
//
//    /**
//     * Création d'un paquet de cartes vide
//     */
//    public PaquetDeCartes() {
//        this.pdc = new LinkedList<>() ;
//    }
//    /**
//     * Création d'un paquet à partir d'un tableau de cartes (paquet vide, si cartes == null)
//     */
//    public PaquetDeCartes(Carte ... cartes){
//        this.pdc = new LinkedList<>() ;
//        if(cartes != null){
//            Collections.addAll(this.pdc, cartes) ;
//        }
//
//    }
//
//    /**
//     * Création d'un paquet à partir d'un autre paquet . PAS DE PARTAGE
//     * @exception AssertionError - si pdc == null
//     * @param pdc un paquet de cartes
//     */
//    public PaquetDeCartes(PaquetDeCartes pdc) {
//        assert (pdc != null) : "le parametre pdc ne doit pas etre egale null" ;
//        this.pdc = new LinkedList<>() ;
//        for(Carte carte : pdc.pdc){
//            //this.pdc.add(new Carte(carte.getCouleur())) ;
//        }
//    }
//
//    /**
//     * @return le nombre de cartes
//     */
//    public int getNbCartes(){
//        return pdc.size() ;
//    }
//
//    /**
//     * @param no le numero de carte
//     * @return la carte choisie
//     * @exception AssertionError - si le numéro est négatif ou supérieur ou égal au nombre de cartes
//     */
//    public Carte getCarte(int no){
//        assert(no >= 0 && no < this.getNbCartes()) : "le numéro doit etre positif et strictement inferieur au nombre de cartes" ;
//        return this.pdc.get(no) ;
//    }
//
//    /**
//     * Ajouter une ou plusieurs cartes
//     * @param cartes les cartes a ajouter
//     * @exception  AssertionError - si cartes == null
//     */
//    public void ajouter(Carte ... cartes){
//        assert (cartes != null) : "cartes ne doit pas etre null" ;
//        for(Carte carte: cartes){
//            this.pdc.add(carte) ;
//        }
//    }
//
//    /**
//     * Ajouter toutes les cartes du paquet
//     * @param pdc le paquet a ajouter
//     * @exception  AssertionError - si pdc == null
//     */
//    public void ajouter(PaquetDeCartes pdc){
//        assert (pdc != null) : "pdc ne doit pas etre null" ;
//        this.pdc.addAll(pdc.pdc) ;
//    }
//
//    /**
//     * @return vrai si le paquet de carte est vide
//     */
//    public boolean estVide(){
//        return this.pdc.isEmpty() ;
//    }
//
//    /**
//     * Mélanger le paquet
//     */
//    public void melanger(){
//        Collections.shuffle(this.pdc);
//    }
//
//    /**
//     * Renverser l'ordre des cartes
//     */
//    public void retourner(){
//        Collections.reverse(this.pdc);
//    }
//
//    /**
//     * @return la première carte du paquet ou null si le paquet est vide
//     */
//    public Carte getSommet(){
//        Carte sommetPdc = this.pdc.getFirst() ;
//        if(sommetPdc != null){
//            return sommetPdc ;
//        }
//        return null ;
//    }
//
//    /**
//     * Retirer la carte du paquet (elle s'y trouve obligatoirement)
//     * @param  carte la carte a retirer
//     * @exception  AssertionError - si carte == null ou si elle n'est pas présente ans le paquet
//     */
//    public void enlever(Carte carte){
//        assert(carte != null && pdc.contains(carte)) : "la carte ne doit pas etre null et doit obligatoirement etre dans le paquet" ;
//        pdc.remove(carte) ;
//    }
//
//    /**
//     * Piocher une carte au sommet ; la pioche est modifiée
//     * @return la carte piochée au sommet de la pioche
//     * @exception AssertionError - si la pioche est vide
//     */
//    public Carte piocher(){
//        assert (this.pdc != null) : "la pioche ne doit pas etre null" ;
//        Carte sommetPdc = this.getSommet() ;
//        this.enlever(sommetPdc);
//        return sommetPdc ;
//    }
//
//    /**
//     * @return la chaine de caracteres d'ecrivant le paquet de cartes
//     */
//    @Override
//    public String toString(){
//        StringBuilder str = new StringBuilder() ;
//        str.append("Paquet de Carte \n { \n") ;
//        for(Carte carte : this.pdc){
//            str.append(carte.toString()).append("\n") ;
//        }
//        str.append("} \n") ;
//        return str.toString() ;
//    }
//
//
//    /**
//     * @param o l'objet a comparer
//     * @return vrai s'ils sont egal (ici en profondeur : on compare chaque carte, chaque couleur)
//     */
//    @Override
//    public boolean equals(Object o){
//        if (this == o){ // Vérifie si c'est le même objet
//            return true ;
//        }
//        if (o == null || getClass() != o.getClass()) { // Vérifie si o est du même type ou o == null
//            return false;
//        }
//        PaquetDeCartes pdc2 = (PaquetDeCartes) o ;
//        if(this.getNbCartes() != pdc2.getNbCartes()){
//            return false ; // on retourne faux s'ils n'ont pas le meme nombre de cartes
//        }
//        boolean equals = true;
//        for(int i = 0; i < this.getNbCartes(); i++){
//            if(!this.getCarte(i).getCouleur().equals(pdc2.getCarte(i).getCouleur())){
//                equals = false ;
//            }
//        }
//        return equals ;
//    }
//
//}
