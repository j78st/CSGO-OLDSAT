package Score;

import java.io.Serializable;
import java.util.Date;
import java.text.DateFormat;


public class Score implements Serializable {
    public String pseudo;
    public int time_left; // en secondes
    public int value;

    // Constructeurs

    public Score() {
    }

    public Score(String pseudo, int time_left) {
        this.pseudo = pseudo;
        this.time_left = time_left;
        this.value = 10 * time_left;
    }
}