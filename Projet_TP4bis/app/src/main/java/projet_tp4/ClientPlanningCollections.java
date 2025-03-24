package projet_tp4;

public class ClientPlanningCollections implements ConstantesErreur {
    public static void main(String[] args) {
        // Créer un objet PlanningCollections
        PlanningCollections planningCollections = new PlanningCollections();
        
        // Créer quelques dates et plages horaires pour les tests
        DateCalendrier date1 = new DateCalendrier(15, 3, 2024);
        DateCalendrier date2 = new DateCalendrier(16, 3, 2024);
        
        PlageHoraire plage1 = new PlageHoraire(new Horaire(10, 0), new Horaire(12, 0));
        PlageHoraire plage2 = new PlageHoraire(new Horaire(14, 0), new Horaire(16, 0));
        PlageHoraire plage3 = new PlageHoraire(new Horaire(11, 0), new Horaire(13, 0)); // Chevauchement avec plage1

        // Test 1: Ajout d'une réservation valide
        System.out.println("Test 1: Ajout d'une réservation valide");
        try {
            Reservation resa1 = new Reservation(date1, plage1, "Concert");
            planningCollections.ajouterReservation(resa1);
            System.out.println("Réservation 1 ajoutée avec succès");
            System.out.println(planningCollections);
        } catch (ExceptionPlanning e) {
            System.out.println("Erreur: " + MESSAGES_ERREUR[e.getChCodeErreur()]);
        }
        
        // Test 2: Ajout d'une deuxième réservation valide
        System.out.println("\nTest 2: Ajout d'une deuxième réservation valide");
        try {
            Reservation resa2 = new Reservation(date1, plage2, "Théâtre");
            planningCollections.ajouterReservation(resa2);
            System.out.println("Réservation 2 ajoutée avec succès");
            System.out.println(planningCollections);
        } catch (ExceptionPlanning e) {
            System.out.println("Erreur: " + MESSAGES_ERREUR[e.getChCodeErreur()]);
        }
        
        // Test 3: Ajout d'une réservation incompatible (même date, plages qui se chevauchent)
        System.out.println("\nTest 3: Réservation incompatible");
        try {
            Reservation resaIncompatible = new Reservation(date1, plage3, "Exposition");
            planningCollections.ajouterReservation(resaIncompatible);
            System.out.println("Réservation incompatible ajoutée avec succès");
        } catch (ExceptionPlanning e) {
            System.out.println("Erreur: " + MESSAGES_ERREUR[e.getChCodeErreur()]);
        }
        
        // Test 4: Ajout d'une réservation à une autre date
        System.out.println("\nTest 4: Réservation à une autre date");
        try {
            Reservation resa3 = new Reservation(date2, plage1, "Conférence");
            planningCollections.ajouterReservation(resa3);
            System.out.println("Réservation 3 ajoutée avec succès");
            System.out.println(planningCollections);
        } catch (ExceptionPlanning e) {
            System.out.println("Erreur: " + MESSAGES_ERREUR[e.getChCodeErreur()]);
        }
        
        // Test 5: Tentative d'ajout d'une réservation identique (doublon)
        System.out.println("\nTest 5: Tentative d'ajout d'un doublon");
        try {
            Reservation resaDoublon = new Reservation(date1, plage1, "Doublon");
            planningCollections.ajouterReservation(resaDoublon);
            System.out.println("Réservation doublon ajoutée avec succès");
        } catch (ExceptionPlanning e) {
            System.out.println("Erreur: " + MESSAGES_ERREUR[e.getChCodeErreur()]);
        }


        // Test 6: affichage du planning
        System.out.println("\nTest 6: affichage du planning");
        System.out.println(planningCollections);
    }
}