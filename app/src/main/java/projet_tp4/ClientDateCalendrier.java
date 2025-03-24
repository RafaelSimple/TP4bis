package projet_tp4;

public class ClientDateCalendrier {
    public static void main(String[] args) {

        System.out.println("Test de la date d'aujourd'hui :");
        DateCalendrier aujourdhui = new DateCalendrier(1, 1, 2010);
        System.out.println(aujourdhui);
        

        System.out.println("\nTest d'une date spécifique :");
        DateCalendrier date1 = new DateCalendrier(15, 3, 2024);
        System.out.println(date1);
        

        System.out.println("\nTest de dateDuLendemain :");
        System.out.println("Date actuelle : " + date1);
        DateCalendrier demain = date1.dateDuLendemain();
        System.out.println("Lendemain : " + demain);

        System.out.println("\nTest de dateDeLeVeille :");
        System.out.println("Date actuelle : " + date1);
        DateCalendrier hier = date1.dateDeLeVeille();
        System.out.println("Veille : " + hier);
        
        System.out.println("\nTest de changement de mois :");
        DateCalendrier finMois = new DateCalendrier(31, 3, 2024);
        System.out.println("Date actuelle : " + finMois);
        System.out.println("Lendemain : " + finMois.dateDuLendemain());
    }
}