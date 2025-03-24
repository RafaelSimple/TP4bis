package projet_tp4;

public interface ConstantesErreur {
    // Codes d'erreur
    final int RESERVATION_INVALIDE = 0;
    final int PLANNING_PLEIN = 1;
    final int RESERVATION_INCOMPATIBLE = 2;
    
    // Messages d'erreur correspondants
    final String[] MESSAGES_ERREUR = {
        "La réservation n'est pas valide",
        "Le planning est déjà plein",
        "La réservation est incompatible avec une réservation existante"
    };
}
