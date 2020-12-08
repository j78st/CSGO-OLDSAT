package Partie;

import java.util.ArrayList;

public class Gear {
    String name;
    String description;
    int max_usage;
    int current_usage;
    ArrayList<Action> actions;

    public Gear(String name,int max_usage){
        this.name=name;
        this.description="file";
        this.max_usage=max_usage;
        this.current_usage=0;
        this.actions=new ArrayList<Action>();
    }

}
