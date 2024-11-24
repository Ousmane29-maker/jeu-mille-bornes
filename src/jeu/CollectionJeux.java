package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionJeux implements Iterable<Jeu> {

    private ArrayList<Jeu> jeux;

    // Constructeur
    public CollectionJeux() {
        this.jeux = new ArrayList<>();
    }

    // Ajoute un jeu à la collection
    public void add(Jeu jeu) {
        assert jeu != null : "Le jeu ne peut pas être null";
        if (!jeux.contains(jeu)) {
            jeux.add(jeu);
        }
    }

    // Ajoute une collection entière de jeux
    public void add(CollectionJeux cJeux) {
        assert cJeux != null : "La collection ne peut pas être null";
        for (Jeu jeu : cJeux.jeux) {
            add(jeu);
        }
    }

    // Supprime un jeu de la collection
    public void remove(Jeu jeu) {
        assert jeu != null : "Le jeu à supprimer ne peut pas être null";
        jeux.remove(jeu);
    }

    // Supprime tous les jeux d'une autre collection
    public void remove(CollectionJeux cj) {
        assert cj != null : "La collection à supprimer ne peut pas être null";
        jeux.removeAll(cj.jeux);
    }

    // Retourne la taille de la collection
    public int size() {
        return jeux.size();
    }


    @Override
    public Iterator<Jeu> iterator() {
        return jeux.iterator();
    }
}
