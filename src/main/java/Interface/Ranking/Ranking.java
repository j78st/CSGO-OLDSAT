package Interface.Ranking;

import java.util.ArrayList;
public class Ranking {

    ArrayList<Record> ranking;

    public Ranking () {
        ranking = new ArrayList<Record>();
    }

    /**
     * Cette fonction permet de verifier si un nouveau record doit etre intégré au classement.
     * Modifie le classement en conséquence si il y a un ajout.
     * @param record
     */
    public void check_and_add (Record record) {
        Record tmp = new Record();
        // parcours du classement
        for (int i = 0; i<ranking.size(); i++) {
            // si emplacement pour insertion
            if (ranking.get(i).score< record.score) {
                ranking.add(i, record); // insertion du nouveau record
                record.rank = i;
                ranking.remove(ranking.size()-1); // suppression du plus mauvais record
            }
        }
    }

}
