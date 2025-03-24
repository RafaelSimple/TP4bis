package projet_tp4;

import java.util.ArrayList;
import java.util.List;

public class Planning implements ConstantesErreur {

    private Reservation[] reservations;
    private int nbReservations;

    public Planning(int capacite) {
        this.reservations = new Reservation[capacite];
        this.nbReservations = 0;
    }

    /**
     * Ajoute une réservation au planning
     * @param reservation La réservation à ajouter
     * @throws ExceptionPlanning si la réservation est invalide, si le planning est plein,
     *         ou si la réservation est incompatible avec une existante
     */
    public void ajout(Reservation reservation) throws ExceptionPlanning {
        // Vérifie si la réservation est valide
        if (!reservation.getPlageHoraire().estValide()) {
            throw new ExceptionPlanning(RESERVATION_INVALIDE);
        }
        
        // Vérifie si le planning est plein
        if (nbReservations >= reservations.length) {
            throw new ExceptionPlanning(PLANNING_PLEIN);
        }
        
        // Vérifie si la réservation est compatible avec les existantes
        DateCalendrier dateReservation = reservation.getDate();
        PlageHoraire plageReservation = reservation.getPlageHoraire();
        
        for (int i = 0; i < nbReservations; i++) {
            if (reservations[i].getDate().compareTo(dateReservation) == 0) {
                // Même date, vérifions si les plages horaires se chevauchent
                PlageHoraire plageExistante = reservations[i].getPlageHoraire();
                
                // Vérification simplifiée du chevauchement
                if ((plageReservation.getHeureDebut().toMinutes() < plageExistante.getHeureFin().toMinutes() &&
                    plageReservation.getHeureFin().toMinutes() > plageExistante.getHeureDebut().toMinutes())) {
                    throw new ExceptionPlanning(RESERVATION_INCOMPATIBLE);
                }
            }
        }
        
        // Ajouter la réservation et incrémenter le compteur
        reservations[nbReservations] = reservation;
        nbReservations++;
    }

    public Reservation getReservation(DateCalendrier date) {
        for (int i = 0; i < nbReservations; i++) {
            if (reservations[i] != null && reservations[i].getDate().compareTo(date) == 0) {
                return reservations[i];
            }
        }
        return null;
    }

    public Reservation[] getReservations(DateCalendrier date) {
        List<Reservation> foundResas = new ArrayList<>();
        for (int i = 0; i < nbReservations; i++) {
            if (reservations[i] != null && reservations[i].getDate().compareTo(date) == 0) {
                foundResas.add(reservations[i]);
            }
        }
        return foundResas.toArray(new Reservation[0]);
    }

    public int plusAncienneReservation(int debut, int fin) {
        int index = -1;
        for (int i = 0; i < nbReservations; i++) {
            if (reservations[i] != null && 
                reservations[i].getPlageHoraire().getHeureDebut().toMinutes() >= debut &&
                reservations[i].getPlageHoraire().getHeureFin().toMinutes() <= fin) {
                
                if (index == -1 || reservations[i].getDate().compareTo(reservations[index].getDate()) < 0) {
                    index = i;
                }
            }
        }
        return index;
    }

    public void trierParInsertion() {
        for (int i = 1; i < nbReservations; i++) {
            Reservation current = reservations[i];
            int j = i - 1;
            while (j >= 0 && reservations[j].getDate().compareTo(current.getDate()) > 0) {
                reservations[j + 1] = reservations[j];
                j--;
            }
            reservations[j + 1] = current;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nbReservations; i++) {
            if (reservations[i] != null) {
                builder.append(reservations[i]).append("\n");
            }
        }
        return builder.toString();
    }
}
