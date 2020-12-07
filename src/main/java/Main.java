import Score.*;
import Partie.*;



public class Main {

    public static void main(String[] args) {
        Ranking r = new Ranking();
        for(int i=0;i<10;i++){
            r.ranking[i]=new Score("---",0);
        }

        Map mamap = new Map();
        Room r1 = new Room(1,true,mamap,2,-1,-1,3);
        Room r2 = new Room(2,false,mamap,-1,-1,1,-1);
        Room r3 = new Room(3,false,mamap,-1,1,-1,-1);

        Score s1 = new Score ("pseudo1",10);
        Score s2 = new Score ("pseudo2",100);
        Score s3 = new Score ("pseudo3",15);
        Score s4 = new Score ("pseudo4",50);
        Score s5 = new Score ("pseudo5",30);
        Score s6 = new Score ("pseudo6",20);
        Score s7 = new Score ("pseudo7",30);
        Score s8 = new Score ("pseudo8",75);



        r.add_score(s1);
        r.add_score(s2);
        r.add_score(s3);
        r.add_score(s4);
        r.add_score(s5);
        r.add_score(s6);
        r.add_score(s7);
        r.add_score(s8);

        for(int i = 0;i<10;i++){
            System.out.println(i+1+"e = " + r.ranking[i].pseudo + " avec un score de " + r.ranking[i].value + " à la date " + r.ranking[i].dateformat.format(r.ranking[i].date));
        }
    }
}