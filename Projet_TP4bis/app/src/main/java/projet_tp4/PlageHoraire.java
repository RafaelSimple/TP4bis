package projet_tp4;

public class PlageHoraire {
    private final static int DUREEMINIMIN = 60;
    
    @SuppressWarnings("FieldMayBeFinal")
    private Horaire chHeureDebut;
    @SuppressWarnings("FieldMayBeFinal")
    private Horaire chHeureFin;


    public PlageHoraire (Horaire horaireDebut, Horaire horaireFin) {
        chHeureDebut = horaireDebut;
        chHeureFin = horaireFin;

    }


    /**
     * la méthode va renvoyer true ou false pour savoir si la plage horaire (this : l'objet appelant) donnée est valide. 
     * @return 
     */
    public boolean estValide() {
        if (duree() < 0) {
            return false;

        }

        return duree() >= DUREEMINIMIN;
    }


    public int duree() {
        return getHeureFin().toMinutes() - getHeureDebut().toMinutes();

    }

    public int compareTo(PlageHoraire parPlageCompareTo) {
        if (getHeureFin().toMinutes() < getHeureDebut().toMinutes()) {
            return -1;
        }

        if (getHeureFin().toMinutes() < getHeureDebut().toMinutes()) {
            return 1;
        }

        else {
            return 0;
        }

    }


    public Horaire getHeureDebut() {
        return chHeureDebut;
    }


    public Horaire getHeureFin() {
        return chHeureFin;
    }


    @Override
    public String toString () {
        if (duree() == 60) {
            return chHeureDebut + " à " + chHeureFin + ", durée: " + (duree()/60) + " heure";
        }

        if (duree() >= 60 && duree()< 120) {
            return chHeureDebut + " à " + chHeureFin + ", durée: " + (duree()/60) + " heure et " + (duree()%60) + " minutes";
        }

        if (duree() % 60 == 0) {
            return chHeureDebut + " à " + chHeureFin + ", durée: " + (duree()/60) + " heures";
        }

        if (estValide() == false) {
            return "La plage horaire n'est pas valide";
        }

        else {
            return chHeureDebut + " à " + chHeureFin + ", durée: " + (duree()/60) + " heures et " + (duree()%60) + " minutes";
        }
    
    }
}
