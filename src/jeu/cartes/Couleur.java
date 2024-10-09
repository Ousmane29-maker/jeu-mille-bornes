package jeu.cartes;

public enum Couleur {
    JAUNE("jaune"),
    VERT("vert"),
    BLEU("bleu"),
    ROUGE("vert") ;

    private String nom ;

    private Couleur(String nom) {
        this.nom = nom ;
    }

    public String getNom(){
        return this.nom ;
    }

    @Override
    public String toString() {
        return "Couleur{" +
                "nom = '" + nom + '\'' +
                '}';
    }
}
