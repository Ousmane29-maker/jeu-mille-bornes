package jeu.cartes;

public class Bottes {
    private boolean estAsDuVolant ;
    private boolean estPrioritaire ;
    private boolean estCiterneDEssence ;
    private boolean estIncrevable ;

    public Bottes(){
        this.estAsDuVolant = false ;
        this.estPrioritaire = false ;
        this.estCiterneDEssence = false ;
        this.estIncrevable = false ;

    }

    public void setEstAsDuVolant() {
        if (!estAsDuVolant) {
            this.estAsDuVolant = true;  // Active AsDuVolant seulement si ce n'est pas déjà fait
        }
    }


    public void setEstPrioritaire() {
        if (!estPrioritaire) {
            this.estPrioritaire = true;
        }
    }

    public void setEstCiterneDEssence() {
        if (!estCiterneDEssence) {
            this.estCiterneDEssence = true;
        }
    }

    public void setEstIncrevable() {
        if (!estIncrevable) {
            this.estIncrevable = true;  // Active AsDuVolant seulement si ce n'est pas déjà fait
        }
    }

    public boolean estAsDuVolant() {
        return estAsDuVolant;
    }

    public boolean estPrioritaire() {
        return estPrioritaire;
    }

    public boolean estCiterneDEssence() {
        return estCiterneDEssence;
    }

    public boolean estIncrevable() {
        return estIncrevable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (estAsDuVolant) {
            sb.append("AsDuVolant, ");
        }
        if (estPrioritaire) {
            sb.append("Prioritaire, ");
        }
        if (estCiterneDEssence) {
            sb.append("CiterneDEssence, ");
        }
        if (estIncrevable) {
            sb.append("Increvable, ");
        }
        if (sb.isEmpty()) {
            sb.append("Aucune botte activée");
        } else {
            // Supprimer la dernière virgule et espace si des bottes sont activées
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }
}
