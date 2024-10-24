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
        this.estAsDuVolant = !this.estAsDuVolant;
    }

    public void setEstPrioritaire() {
        this.estPrioritaire = !this.estPrioritaire;
    }

    public void setEstCiterneDEssence() {
        this.estCiterneDEssence = !this.estCiterneDEssence;
    }

    public void setEstIncrevable() {
        this.estIncrevable = !this.estIncrevable;
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
}
