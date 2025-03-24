package projet_tp4;

public class Reservation implements Comparable<Reservation> {
    @SuppressWarnings("FieldMayBeFinal")
    private DateCalendrier dateSpectacle;
    @SuppressWarnings("FieldMayBeFinal")
    private PlageHoraire plageHoraireSpectacle;
    @SuppressWarnings("FieldMayBeFinal")
    private String titreSpectacle;

    public Reservation(DateCalendrier parDateSpectacle, PlageHoraire parPlageHoraireSpectacle, String parTitreSpectacle) {
        dateSpectacle = parDateSpectacle;
        plageHoraireSpectacle = parPlageHoraireSpectacle;
        titreSpectacle = parTitreSpectacle;
    }

    public DateCalendrier getDate() {
        return dateSpectacle;
    }

    public PlageHoraire getPlageHoraire() {
        return plageHoraireSpectacle;
    }

    public String getTitre() {
        return titreSpectacle;
    }

    @Override
    public String toString() {
        return titreSpectacle + ": " + "le " + dateSpectacle + " de " + plageHoraireSpectacle;
    }

    public int compareTo(Reservation other) {
        return dateSpectacle.compareTo(other.dateSpectacle);
    }
}


