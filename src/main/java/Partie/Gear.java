package Partie;

import java.util.ArrayList;

public class Gear {
    int id;
    String name;
    String description;
    int max_usage;
    int current_usage;
    ArrayList<Action> actions;

    public Gear(int id,String name,int max_usage){
        this.id = id;
        this.name = name;
        this.description = "file";
        this.max_usage = max_usage;
        this.current_usage = 0;
        this.actions = new ArrayList<Action>();
        Game.gears.add(this);
    }

    public void use_gear(){
        this.current_usage++;
        if(current_usage == max_usage){
            Game.player.remove_inventory(this);
            //message "vous avez perdu l'objet ..." ??
        }
    }

}
