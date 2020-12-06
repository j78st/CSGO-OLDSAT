import Score.*;

public class Main {
    public static void main(String[] args) {
        Ranking r = new Ranking();
        for(int i=0;i<10;i++){
            r.ranking[i]=new Score("test",0);
        }
        Score s1 = new Score ("pseudo1",10);
        Score s2 = new Score ("pseudo2",100);
        Score s3 = new Score ("pseudo3",15);
        Score s4 = new Score ("pseudo4",50);
        Score s5 = new Score ("pseudo5",30);
        Score s6 = new Score ("pseudo6",20);
        Score s7 = new Score ("pseudo7",30);
        Score s8 = new Score ("pseudo8",75);
        Score s9 = new Score ("pseudo9",80);
        Score s10 = new Score ("pseudo10",15);
        Score s11 = new Score ("pseudo11",18);
        r.add_score(s1);
        r.add_score(s2);
        r.add_score(s3);
        r.add_score(s4);
        r.add_score(s5);
        r.add_score(s6);
        r.add_score(s11);
        r.add_score(s7);
        r.add_score(s8);
        r.add_score(s9);
        r.add_score(s10);
        for(int i = 0;i<10;i++){
            System.out.println(i+1+"e = " + r.ranking[i].pseudo + " avec un score de " + r.ranking[i].value + " à la date " + r.ranking[i].dateformat.format(r.ranking[i].date));
        }
    }
}