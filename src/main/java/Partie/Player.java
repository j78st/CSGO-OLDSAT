package Partie;

import Interface.Settings.Engine;

import java.util.ArrayList;

public class Player {
    String pseudo; // le pseudo du joueur
    ArrayList<Item> inventory; // liste des objets possédés par le joueur
    public int position; // numéro de la salle/sous-salle/énigme affichée au joueur

    public Player(String pseudo){
        this.pseudo = pseudo;
        this.inventory = new ArrayList<>();
        this.position = 101;
    }

    public void move(int destination){ // bouge le joueur vers un nouvel écran (salle/sous-salle/énigme)
        this.position=destination;
        Engine.engine.refreshRoom();
    }

    public boolean add_inventory(Item gear){ // Ajoute un objet à l'inventaire du joueur
        if(this.inventory.size()< 3){
            this.inventory.add(gear);
            gear.set_actions_doable(true);
            Engine.engine.refreshInventory();
            return true;
        }else{
            // message "Inventaire plein revenez plus tard" : popup
            return false;
        }
    }

    public void remove_inventory(Item gear){ // Supprime un objet de l'inventaire du joueur
        this.inventory.remove(gear);
        gear.set_actions_doable(false);
        Engine.engine.refreshInventory();
    }

    public String getPseudo() {
        return pseudo;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getPosition() {
        return position;
    }
}
