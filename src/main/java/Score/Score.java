package Score;

import java.io.Serializable;

public class Score implements Serializable {
    public int rank;
    public String pseudo;
    public int value;

    // Constructeurs

    public Score() {
    }

    public Score(String pseudo, int value) {
        this.rank = -1;
        this.pseudo = pseudo;
        this.value = value;
    }
}