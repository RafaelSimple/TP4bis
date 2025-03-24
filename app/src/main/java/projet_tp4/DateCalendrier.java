package projet_tp4;

import java.util.Calendar;

public class DateCalendrier extends Date implements ConstantesCalendrier {
    private int chJourSemaine;
    
    public DateCalendrier(int jour, int mois, int annee) {
        super(jour, mois, annee);
        Calendar calendar = Calendar.getInstance();
        calendar.set(annee, mois, jour);
        
        int jourSmn = calendar.get(Calendar.DAY_OF_WEEK);
        chJourSemaine = (jourSmn == 1) ? 7 : jourSmn - 1;
    }

    public DateCalendrier() {
        super(1, 1, 1); // Valeurs temporaires qui seront écrasées
        Calendar today = Calendar.getInstance();
        
        chAnnee = today.get(Calendar.YEAR);
        chMois = today.get(Calendar.MONTH) + 1;
        chJour = today.get(Calendar.DAY_OF_MONTH);
        
        int jourSmn = today.get(Calendar.DAY_OF_WEEK);
        chJourSemaine = (jourSmn == 1) ? 7 : jourSmn - 1;
    }

    @Override
    public String toString() {
        return JOURS_SEMAINE[chJourSemaine - 1] + " " + chJour + " " + MOIS[chMois-1] + " " + chAnnee;
    }

    @Override
    public DateCalendrier dateDuLendemain() {
        Date dateSuivante = super.dateDuLendemain();
        return new DateCalendrier(dateSuivante.chJour, dateSuivante.chMois, dateSuivante.chAnnee);
    }

    @Override
    public DateCalendrier dateDeLeVeille() {
        Date datePrecedente = super.dateDeLeVeille();
        return new DateCalendrier(datePrecedente.chJour, datePrecedente.chMois, datePrecedente.chAnnee);
    }

    public int getNumeroSemaine() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(chAnnee, chMois - 1, chJour);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }
}



