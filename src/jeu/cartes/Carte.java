package jeu.cartes;

public class Carte {
    private Couleur couleur ;

    public Carte(Couleur couleur) {
        this.couleur = couleur ;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "couleur=" + couleur +
                '}';
    }
}
