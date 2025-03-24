package projet_tp4;

@SuppressWarnings("FieldMayBeFinal")


public class Date {
    protected int chJour;
    protected int chMois;
    protected int chAnnee;

    @Override
    public String toString() {
        return "[" + chJour + "/" + chMois + "/" + chAnnee + "]";

    }

    public Date(int jour, int mois, int annee) {
        chJour = jour;
        chMois = mois;
        chAnnee = annee;
    }

    public Date(int annee) {
        chAnnee = annee;
        chJour = 1;
        chMois = 1;
    }

    public static boolean estBissextile(int annee) {
        return ((annee % 4 == 0 && annee % 100 != 100) || (annee % 400 == 0));
    }

    public static int dernierJourDuMois(int mois, int annee) {
        if ((estBissextile(annee) == true) && mois == 02) {
            return 29;
        }

        if ((estBissextile(annee) == false) && (mois == 1 || mois == 3 || mois == 5 || mois == 7 || mois == 8 || mois == 10 || mois == 12)) {
            return 31;
        }
        
        if ((estBissextile(annee) == false) && (mois == 4 || mois == 6 || mois == 9 || mois == 11)){
            return 30;
        } 
        
        else {
            return 28;   
        }
    }

    
    public static boolean estValide(int jour, int mois, int annee) {
        return annee > 1852 && mois >= 1 && mois <= 12 && jour >= 1 && jour <= dernierJourDuMois(mois, annee);
    
    }

    public int compareTo(Date comparaisonDate) {
        if (chAnnee == comparaisonDate.chAnnee && chMois == comparaisonDate.chMois && chJour == comparaisonDate.chJour) {
            return 0;
        }
        if (chAnnee > comparaisonDate.chAnnee) {
            return 1;
        }
        if (chMois > comparaisonDate.chMois) {
            return 1;
        }
        if (chJour > comparaisonDate.chJour) {
            return 1;
        }
        return -1;
    }

    public Date dateDeLeVeille() {
        int jour = chJour;
        int mois = chMois;
        int annee = chAnnee;
        
        jour--;
        if (jour < 1) {
            mois--;
            if (mois < 1) {
                mois = 12;
                annee--;
            }
            jour = dernierJourDuMois(mois, annee);
        }
        return new Date(jour, mois, annee);
    }

    public Date dateDuLendemain() {
        int jour = chJour;
        int mois = chMois;
        int annee = chAnnee;
        
        jour++;
        if (jour > dernierJourDuMois(mois, annee)) {
            jour = 1;
            mois++;
            if (mois > 12) {
                mois = 1;
                annee++;
            }
        }
        return new Date(jour, mois, annee);
    }

}
