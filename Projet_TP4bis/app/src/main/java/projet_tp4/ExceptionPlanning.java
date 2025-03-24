package projet_tp4;

public class ExceptionPlanning extends Exception {
    private int chCodeErreur;
    
    /**
     * Constructeur qui reçoit en paramètre un entier correspondant au code de l'erreur
     * 0 : réservation invalide
     * 1 : planning plein
     * 2 : réservation incompatible
     */
    public ExceptionPlanning(int parCodeErreur) {
        super();
        chCodeErreur = parCodeErreur;
    }
    
    /**
     * Accesseur pour le code d'erreur
     * @return le code d'erreur
     */
    public int getChCodeErreur() {
        return chCodeErreur;
    }
}
