package projet_tp4;

public class ClientPlanning implements ConstantesErreur {
    public static void main(String[] args) {
        // Créer un planning avec une capacité de 3 réservations
        Planning planning = new Planning(3);
        
        // Créer quelques dates et plages horaires pour les tests
        DateCalendrier date1 = new DateCalendrier(15, 3, 2024);
        DateCalendrier date2 = new DateCalendrier(16, 3, 2024);
        
        PlageHoraire plage1 = new PlageHoraire(new Horaire(10, 0), new Horaire(12, 0));
        PlageHoraire plage2 = new PlageHoraire(new Horaire(14, 0), new Horaire(16, 0));
        PlageHoraire plage3 = new PlageHoraire(new Horaire(11, 0), new Horaire(13, 0)); // Chevauchement avec plage1
        PlageHoraire plageInvalide = new PlageHoraire(new Horaire(10, 0), new Horaire(10, 2)); // Trop courte
        
        // Test 1: Ajout d'une réservation avec une plage horaire invalide
        System.out.println("Test 1: Réservation avec plage horaire invalide");
        try {
            Reservation resaInvalide = new Reservation(date1, plageInvalide, "Spectacle invalide");
            planning.ajout(resaInvalide);
        } catch (ExceptionPlanning e) {
            System.out.println("Erreur: " + MESSAGES_ERREUR[e.getChCodeErreur()]);
        }
        
        // Test 2: Ajout de réservations jusqu'à ce que le planning soit plein
        System.out.println("\nTest 2: Remplir le planning");
        try {
            // Ajouter 3 réservations valides
            planning.ajout(new Reservation(date1, plage1, "Spectacle 1"));
            System.out.println("Réservation 1 ajoutée avec succès");
            
            planning.ajout(new Reservation(date1, plage2, "Spectacle 2"));
            System.out.println("Réservation 2 ajoutée avec succès");
            
            planning.ajout(new Reservation(date2, plage1, "Spectacle 3"));
            System.out.println("Réservation 3 ajoutée avec succès");
            
            // Tenter d'ajouter une 4ème réservation (planning plein)
            planning.ajout(new Reservation(date2, plage2, "Spectacle 4"));
            
        } catch (ExceptionPlanning e) {
            System.out.println("Erreur: " + MESSAGES_ERREUR[e.getChCodeErreur()]);
        }
        
        // Test 3: Ajout d'une réservation incompatible avec une existante
        System.out.println("\nTest 3: Réservation incompatible");
        try {
            // Créer un nouveau planning pour ce test
            Planning planning2 = new Planning(5);
            
            // Ajouter une première réservation
            planning2.ajout(new Reservation(date1, plage1, "Spectacle 1"));
            System.out.println("Réservation 1 ajoutée avec succès");
            
            // Tenter d'ajouter une réservation incompatible (même date, plages qui se chevauchent)
            planning2.ajout(new Reservation(date1, plage3, "Spectacle conflit"));
            
        } catch (ExceptionPlanning e) {
            System.out.println("Erreur: " + MESSAGES_ERREUR[e.getChCodeErreur()]);
        }
    }
}
