import Memoire.Memoire;
import Memoire.ObjetA;
import Memoire.ObjetB;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("liste_test.gson");
        Memoire m = new Memoire();

        ObjetA oa1 = new ObjetA("bob", "grolar");
        ObjetA oa2 = new ObjetA("antoine", "potigro");

        ObjetB ob1 = new ObjetB("bob", 45);
        ObjetB ob2 = new ObjetB("philipe", 34);

        m.write_data(ob2, file);

        ObjetB test = new ObjetB();
        test = (ObjetB) m.read_data(file);

        System.out.println(test.prenom+ " "+ test.age);

    }
}