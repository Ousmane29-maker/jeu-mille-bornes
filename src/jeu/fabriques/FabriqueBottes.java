package jeu.fabriques;

import jeu.cartes.Bottes;

public class FabriqueBottes {
    public FabriqueBottes() {

    }

    public static Bottes[] getToutesLesBottesPossibles() {
        // 2*2*2*2 = 16
        Bottes[] lesBottesPossibles = new Bottes[16];

        // Crée les différentes combinaisons de bottes
        lesBottesPossibles[0] = creerBottes(false, false, false, false);
        lesBottesPossibles[1] = creerBottes(false, true, false, false);
        lesBottesPossibles[2] = creerBottes(false, true, true, false);
        lesBottesPossibles[3] = creerBottes(false, false, true, false);
        lesBottesPossibles[4] = creerBottes(false, true, true, true);
        lesBottesPossibles[5] = creerBottes(false, true, false, true);
        lesBottesPossibles[6] = creerBottes(false, false, true, true);
        lesBottesPossibles[7] = creerBottes(false, false, false, true);
        lesBottesPossibles[8] = creerBottes(true, false, false, false);
        lesBottesPossibles[9] = creerBottes(true, true, false, false);
        lesBottesPossibles[10] = creerBottes(true, true, true, false);
        lesBottesPossibles[11] = creerBottes(true, false, true, false);
        lesBottesPossibles[12] = creerBottes(true, true, true, true);
        lesBottesPossibles[13] = creerBottes(true, true, false, true);
        lesBottesPossibles[14] = creerBottes(true, false, true, true);
        lesBottesPossibles[15] = creerBottes(true, false, false, true);

        return lesBottesPossibles;
    }

    public static Bottes[] getToutesLesBottesPossiblesSaufAsDuVolant() {
        // 2*2*2*1 = 16
        Bottes[] lesBottesPossibles = new Bottes[8];

        // Crée les différentes combinaisons de bottes
        lesBottesPossibles[0] = creerBottes(false, false, false, false);
        lesBottesPossibles[1] = creerBottes(false, true, false, false);
        lesBottesPossibles[2] = creerBottes(false, true, true, false);
        lesBottesPossibles[3] = creerBottes(false, false, true, false);
        lesBottesPossibles[4] = creerBottes(false, true, true, true);
        lesBottesPossibles[5] = creerBottes(false, true, false, true);
        lesBottesPossibles[6] = creerBottes(false, false, true, true);
        lesBottesPossibles[7] = creerBottes(false, false, false, true);

        return lesBottesPossibles;
    }

    /**
     * Méthode utilitaire pour créer une combinaison spécifique de bottes.
     */
    private static Bottes creerBottes(boolean estAsDuVolant, boolean estPrioritaire, boolean estCiterneDEssence, boolean estIncrevable) {
        Bottes bottes = new Bottes();
        if (estAsDuVolant) {
            bottes.setEstAsDuVolant();
        }
        if (estPrioritaire) {
            bottes.setEstPrioritaire();
        }
        if (estCiterneDEssence) {
            bottes.setEstCiterneDEssence();
        }
        if (estIncrevable) {
            bottes.setEstIncrevable();
        }
        return bottes;
    }
}
