package Memoire;

import java.io.Serializable;

public class ObjetB extends Data{
    public String prenom;
    public int age;

    public ObjetB(){

    }

    public ObjetB(String p, int n){
        this.prenom = p;
        this.age = n;
    }
}
