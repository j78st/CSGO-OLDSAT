package Memoire;

import java.io.Serializable;

public class ObjetA extends Data {
    public String prenom;
    public String nom;

    public ObjetA(){

    }

    public ObjetA(String p, String n){
        this.prenom = p;
        this.nom = n;
    }
}