package Interface.Ranking;

import java.io.Serializable;

public class Record implements Serializable {

    int rank;
    String pseudo;
    int score;

    // Constructeurs

    public Record () {

    }

    public Record (String pseudo, int score) {
        this.rank = -1; // -1 quand non classé
        this.pseudo = pseudo;
        this.score = score;
    }

    public Record (int rank, String pseudo, int score) {
        this.rank = rank;
        this.pseudo = pseudo;
        this.score = score;
    }

}
