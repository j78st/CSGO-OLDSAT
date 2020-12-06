package Score;

import java.io.Serializable;
import java.util.Date;
import java.text.DateFormat;


public class Score implements Serializable {
    public String pseudo;
    int time_left; // en secondes
    public int value;
    public Date date;
    public DateFormat dateformat;

    // Constructeurs

    public Score() {
    }

    public Score(String pseudo, int time_left) {
        this.pseudo = pseudo;
        this.time_left = time_left;
        this.value = 10 * time_left;
        this.date = new Date();
        this.dateformat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
    }
}