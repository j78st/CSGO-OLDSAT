import Score.Ranking;
import Score.Score;
import Serialization.Memoire;
import Serialization.ObjetB;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {

        Memoire m = new Memoire();
        File rank_file = new File("test.json");
        Random r = new Random();

        ObjetB ob = new ObjetB("bob", 45);
        ObjetB new_ob = new ObjetB();

        Ranking classement = new Ranking();
        Ranking ranking_from_file = new Ranking();

        for (int i = 0; i < 10; i++) {
            classement.ranking[i] = new Score("pseudo "+i, r.nextInt(100));
        }

        // ecriture
        m.write_data(classement, rank_file);
        System.out.println("ecriture ok");

        //lecture
        ranking_from_file = (Ranking) m.read_data(rank_file);

        for (int i = 0; i < 10; i++) {
            System.out.println(classement.ranking[i].pseudo + " " + classement.ranking[i].value );
            System.out.println(ranking_from_file.ranking[i].pseudo + " " + ranking_from_file.ranking[i].value );
            System.out.println("\n");
        }


        //===========================================//
        /*
        Ranking r = new Ranking();
        for(int i=0;i<10;i++){
            r.ranking[i]=new Score("---",0);
        }

        Room r1 = new Room(101,true,102,-1,-1,103);
        Room r2 = new Room(102,false,-1,-1,101,-1);
        Room r3 = new Room(103,false,-1,101,-1,-1);

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
        }*/
    }
}