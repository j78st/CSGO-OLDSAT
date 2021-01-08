package Score;

import java.io.Serializable;

public class Score implements Serializable {
    public int rank;
    public String pseudo;
    public int time_left; // en secondes
    public int value;

    // Constructeurs

    public Score() {
    }

    public Score(String pseudo, int time_left) {
        this.rank = -1;
        this.pseudo = pseudo;
        this.time_left = time_left;
        this.value = 10 * time_left;
    }


    public Score(String pseudo, int time_left, int rank) {
        this.rank = rank;
        this.pseudo = pseudo;
        this.time_left = time_left;
        this.value = 10 * time_left;
    }
}