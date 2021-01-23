package Score;

import java.io.Serializable;

public class Ranking implements Serializable {

    public static final int RANKING_SIZE = 10;

    public Score[] ranking = new Score[RANKING_SIZE];

    public Ranking(){

    }

    /**
     * Ajoute un score dans le classement et actualise la position de l'ensemble du classement.
     * @param score
     */
    public void add_score(Score score){
        Score tmp = new Score();
        Score tmp2 = new Score();
        boolean added = false;
        for (int i = 0; i < RANKING_SIZE; i++) {
            if (score.value > ranking[i].value && !added) {
                tmp = ranking[i];
                tmp.rank += 1;
                score.rank = i+1;
                ranking[i] = score;
                added = true;
            } else if (added){
                tmp2 = ranking[i];
                ranking[i] = tmp;
                tmp = tmp2;
                tmp.rank = i+2;
            }
        }
    }

}
