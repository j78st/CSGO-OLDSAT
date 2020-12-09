package Partie;

import java.util.ArrayList;

public class Player {
    String pseudo;
    ArrayList<Gear> inventory;
    int position;
    int feature;

    public Player(String pseudo, int feature){
        this.pseudo = pseudo;
        this.inventory =  new ArrayList<Gear>();
        this.position = 101;
        this.feature = feature;
    }

    public void move(int destination){
        this.position=destination;
    }

    public boolean add_inventory(Gear gear){
        if(this.inventory.size()< 3){
            this.inventory.add(gear);
            gear.set_actions_doable(true);
            return true;
        }else{
            // message "Inventaire plein"??
            return false;
        }
    }

    public void remove_inventory(Gear gear){
        this.inventory.remove(gear);
        gear.set_actions_doable(false);
    }
}
