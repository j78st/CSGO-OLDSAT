package Score;

public class Ranking {
    public Score[] ranking = new Score[10];

    public Ranking(){}

    /**
     *
     * @param score
     */
    public void add_score(Score score){
        boolean added = false;
        for(int i = 0;i<10;i++){
            if (score.value > this.ranking[i].value && added == false){
                for(int j = 9;j>i;j--) {
                    this.ranking[j] = this.ranking[j-1];
                }
                this.ranking[i] = score;
                added = true;
            }

        }
     }
}
