package projet_tp4;

public class Horaire {
    private int chHeure;
    private int chQuartHeure;
    
    public Horaire (int parHeure, int parQuartHeure) {
    chHeure = parHeure;
    chQuartHeure = parQuartHeure;
    }
    
    public int toMinutes () {
    return chHeure*60 + chQuartHeure*15;
    }

    public int getHeure () {
    return chHeure;
    }

    public int getQuartHeure () {
    return chQuartHeure*15;
    }

    public void setHeure (int parHeure) {
    chHeure = parHeure;
    }

    public void setQuartHeure (int parQuartHeure) {
    chQuartHeure = parQuartHeure;
    }
    
    @Override
    public String toString () {
        return String.format("%02dh%02d", chHeure, getQuartHeure());
    }
}