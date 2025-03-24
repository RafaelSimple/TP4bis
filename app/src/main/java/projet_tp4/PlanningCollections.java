package projet_tp4;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.Set;
import java.util.TreeMap;

@SuppressWarnings("unused")
public class PlanningCollections {
    private List<Reservation>  chListReservations;
    private Set<Reservation> chSetReservations;
    private TreeMap<Integer, Set<Reservation>> chTreeMapReservations;


    public PlanningCollections() {
        chListReservations = new ArrayList<Reservation>();
        chSetReservations = new TreeSet<Reservation>();
        chTreeMapReservations = new TreeMap<Integer, Set<Reservation>>();
        
    }

    @Override
    public String toString() {
        return "TreeSet : " + chSetReservations + "\nArrayList : " + chListReservations;
    }


    /**
     * Ajoute une réservation à la liste et au set
     * @param parReservation
     * @throws ExceptionPlanning : quand parReservation n'est pas compatible avec un autre reservation de du planning
     */
    public void ajouterReservation(Reservation parReservation) throws ExceptionPlanning {
        //ajout de la liste
        //parcour par itération
        Iterator<Reservation> iterateur = chListReservations.iterator();
        while (iterateur.hasNext()) {
            Reservation reserve = iterateur.next();
            if (parReservation.compareTo(reserve) == 0) {
                throw new ExceptionPlanning(2);
            }
        }
        chListReservations.add(parReservation);
        //ajout au set
        int sizeInitale = chSetReservations.size();
        chSetReservations.add(parReservation);
        if (chSetReservations.size() == sizeInitale) {
            throw new ExceptionPlanning(2);
        }

        int numSemaine = ((DateCalendrier) parReservation.getDate()).getNumeroSemaine();
        Set <Reservation> set = chTreeMapReservations.get(numSemaine);
        if (set == null) {
            set = new TreeSet<Reservation>();
            chTreeMapReservations.put(numSemaine, set);
        }

        else {
            int taillesetavant = set.size();
            set.add(parReservation);
            if (set.size() == taillesetavant) {
                throw new ExceptionPlanning(2);
            }
        }
        
    }
}
