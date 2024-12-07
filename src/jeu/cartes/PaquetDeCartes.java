package jeu.cartes;

import jeu.ErreurFichier;
import jeu.cartes.attaques.FeuRouge;
import jeu.cartes.bornes.Bornes;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PaquetDeCartes {
    LinkedList<Carte> pdc;

    /**
     * Création d'un paquet de cartes vide
     */
    public PaquetDeCartes() {
        this.pdc = new LinkedList<>();
    }

    /**
     * Création d'un paquet à partir d'un tableau de cartes (paquet vide, si cartes == null)
     */
    public PaquetDeCartes(Carte... cartes) {
        this.pdc = new LinkedList<>();
        if (cartes != null) {
            Collections.addAll(this.pdc, cartes);
        }

    }

    /**
     * Création d'un paquet à partir d'un autre paquet . PAS DE PARTAGE
     *
     * @param pdc un paquet de cartes
     * @throws AssertionError - si pdc == null
     */
    public PaquetDeCartes(PaquetDeCartes pdc) {
        assert (pdc != null) : "le parametre pdc ne doit pas etre egale null";
        this.pdc = new LinkedList<>();
        for (Carte carte : pdc.pdc) {
            this.pdc.add(carte.clone()); // on utilise une methode copie pour copier profondement les cartes
        }
    }

    /**
     * @return le nombre de cartes
     */
    public int getNbCartes() {
        return pdc.size();
    }

    /**
     * @param no le numero de carte
     * @return la carte choisie
     * @throws AssertionError - si le numéro est négatif ou supérieur ou égal au nombre de cartes
     */
    public Carte getCarte(int no) {
        assert (no >= 0 && no < this.getNbCartes()) : "le numéro doit etre positif et strictement inferieur au nombre de cartes";
        return this.pdc.get(no);
    }

    /**
     * Ajouter une ou plusieurs cartes
     *
     * @param cartes les cartes a ajouter
     * @throws AssertionError - si cartes == null
     */
    public void ajouter(Carte... cartes) {
        assert (cartes != null) : "cartes ne doit pas etre null";
        for (Carte carte : cartes) {
            this.pdc.add(carte);
        }
    }

    /**
     * Ajouter toutes les cartes du paquet
     *
     * @param pdc le paquet a ajouter
     * @throws AssertionError - si pdc == null
     */
    public void ajouter(PaquetDeCartes pdc) {
        assert (pdc != null) : "pdc ne doit pas etre null";
        this.pdc.addAll(pdc.pdc);
    }

    /**
     * @return vrai si le paquet de carte est vide
     */
    public boolean estVide() {
        return this.pdc.isEmpty();
    }

    /**
     * Mélanger le paquet
     */
    public void melanger() {
        Collections.shuffle(this.pdc);
    }

    /**
     * Renverser l'ordre des cartes
     */
    public void retourner() {
        Collections.reverse(this.pdc);
    }

    /**
     * @return la première carte du paquet ou null si le paquet est vide
     */
    public Carte getSommet() {
        return this.estVide() ? null : this.pdc.getFirst(); // si vide -> null sinon -> la carte
    }

    /**
     * Retirer la carte du paquet (elle s'y trouve obligatoirement)
     *
     * @param carte la carte a retirer
     * @throws AssertionError - si carte == null ou si elle n'est pas présente ans le paquet
     */
    public void enlever(Carte carte) {
        assert (carte != null && pdc.contains(carte)) : "la carte ne doit pas etre null et doit obligatoirement etre dans le paquet";
        pdc.remove(carte);
    }

    /**
     * Piocher une carte au sommet ; la pioche est modifiée
     *
     * @return la carte piochée au sommet de la pioche
     * @throws AssertionError - si la pioche est vide
     */
    public Carte piocher() {
        assert (this.pdc != null) : "la pioche ne doit pas etre null";
        Carte sommetPdc = this.getSommet();
        this.enlever(sommetPdc);
        return sommetPdc;
    }

    /**
     * @return la chaine de caracteres d'ecrivant le paquet de cartes
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Paquet de Carte \n { \n");
        for (Carte carte : this.pdc) {
            str.append(carte.toString()).append("\n");
        }
        str.append("} \n");
        return str.toString();
    }


//    /**
//     * @param o l'objet a comparer
//     * @return vrai s'ils sont egal (ici en profondeur : on compare chaque carte, chaque couleur)
//     */
//
//    // Avant que carte ne soit une classe abstraite
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
//            // Comparer les classes des cartes puisque chaque carte correspond a une classe specifique
//            if(!this.getCarte(i).getClass().equals(pdc2.getCarte(i).getClass())){
//                equals = false ;
//            }
//        }
//        return equals ;
//    }

    public void ecrire(String nomDeFichier) throws ErreurFichier {
        try (FileWriter flot = new FileWriter(nomDeFichier);
             PrintWriter flotFiltre = new PrintWriter(flot)) {

            // Récupération des comptages de cartes
            Map<String, Integer> carteCounts = nbCarteDeChaqueType();

            // Écriture des données dans le fichier
            for (Map.Entry<String, Integer> entry : carteCounts.entrySet()) {
                String name = entry.getKey();
                Integer value = entry.getValue();
                if (value == -1) {
                    flotFiltre.printf("%s%n", name);
                } else {
                    flotFiltre.printf("%s %d%n", name, value);
                }
            }

        } catch (IOException e) {
            throw new ErreurFichier("Erreur lie a l'ouverture du fichier");
        }
    }


    private Map<String, Integer> nbCarteDeChaqueType() {
        Map<String, Integer> carteCounts = new HashMap<>();

        for (Carte carte : pdc) {
            String key;
            int value = 0;

            if (carte.estUneBotte()) {
                key = carte.getClass().getSimpleName();
                ;
                value = -1;  // On attribue une occurrence de -1 pour les cartes Botte, on pas besoin de l'occurence
            } else if (carte.match("Bornes")) {
                Bornes bornes = (Bornes) carte;
                key = "Bornes " + bornes.getKms();  // Bornes + km ety espace entre les 2
                value = carteCounts.getOrDefault(key, 0) + 1;  // 1 si la cle n'est pas presente sinon incremente sa valeur de 1
            } else {
                key = carte.getClass().getSimpleName();  // Pour toutes les autres cartes (Attaque, Parade, etc.)
                value = carteCounts.getOrDefault(key, 0) + 1;
            }

            carteCounts.put(key, value);
        }

        return carteCounts;
    }

    public void lire(String nomDeFichier) throws ErreurFichier {
        try (BufferedReader flot = new BufferedReader(new FileReader(nomDeFichier))) {
            StreamTokenizer flotFiltre = new StreamTokenizer(flot);
            flotFiltre.eolIsSignificant(true); // Fin de ligne significative

            String name = null;
            int count = 1; // Valeur par défaut de count
            int kms = -1; // Pour les cartes Bornes
            int lu = flotFiltre.nextToken(); // Lire le premier jeton

            while (lu != StreamTokenizer.TT_EOF) {
                if (lu == StreamTokenizer.TT_WORD) {
                    name = flotFiltre.sval; // Stocke le mot lu
                } else if (lu == StreamTokenizer.TT_NUMBER) {
                    if ("Bornes".equals(name) && kms == -1) {
                        kms = (int) flotFiltre.nval; // Stocke les kilomètres pour Bornes
                    } else {
                        count = (int) flotFiltre.nval; // Stocke le nombre d'occurrences pour les autres cartes
                    }
                } else if (lu == StreamTokenizer.TT_EOL) {
                    // Traite la ligne complète
                    traiterLigne(name, kms, count);

                    // Réinitialise les valeurs pour la prochaine ligne
                    name = null;
                    count = 1; // Réinitialise count à 1 par défaut pour chaque nouvelle ligne
                    kms = -1;
                }
                lu = flotFiltre.nextToken(); // Lire le token suivant
            }
        } catch (IOException e) {
            throw new ErreurFichier("Erreur liée à l'ouverture ou à la lecture du fichier.");
        }
    }

    private void traiterLigne(String name, int kms, int count) throws ErreurFichier {
        if (name == null) {
            throw new ErreurFichier("fichier contenant une ligne vide");
        }
        if ("Bornes".equals(name)) {
            ajouterBornes(kms, count);
        } else {
            ajouterAutresCartes(name, count);
        }
    }

    private void ajouterBornes(int kms, int count) throws ErreurFichier {
        for (int i = 0; i < count; i++) {
            this.ajouter(new Bornes(kms)); // Ajoute plusieurs instances de Bornes kms
        }
    }

    private void ajouterAutresCartes(String name, int count) throws ErreurFichier {
        String packageName = getPackageForCarte(name);
        try {
            Class<?> clazz = Class.forName(packageName + name);
            Carte carte = (Carte) clazz.getDeclaredConstructor().newInstance();
            ajouterCartes(carte, count);
        } catch (ClassNotFoundException e) {
            throw new ErreurFichier("Lecture d'une Classe de carte inconnue : " + name);
        } catch (ReflectiveOperationException e) {
            throw new ErreurFichier("Erreur lors de l'instanciation de la carte : " + name);
        }
    }
    private void ajouterCartes(Carte carte, int count) {
        for (int i = 0; i < count; i++) {
            this.ajouter(carte); // Ajoute la carte (ou les cartes) pour count
        }
    }

    private String getPackageForCarte(String name) {
        if (estUneAttaque(name)) {
            return "jeu.cartes.attaques."; // Cartes de type Attaque
        } else if (estUneBotte(name)) {
            return "jeu.cartes.bottes."; // Cartes de type Botte
        } else {
            return "jeu.cartes.parades."; // Cartes de type Parade
        }
    }

    private boolean estUneAttaque(String name) {
        return name.equals("FeuRouge") ||
                name.equals("Accident") ||
                name.equals("PanneDEssence") ||
                name.equals("Crevaison");
    }

    private boolean estUneBotte(String name) {
        return name.equals("Increvable") ||
                name.equals("AsDuVolant") ||
                name.equals("Prioritaire") ||
                name.equals("CiterneDEssence");
    }

}
