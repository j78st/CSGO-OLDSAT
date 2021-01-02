package Partie;

import Interface.Settings.Engine;
import java.util.ArrayList;

public class Player {
    String pseudo; // pseudo du joueur
    ArrayList<Integer> inventory; // liste des identifiants des objets possédés par le joueur
    int position; // numéro de la salle (ou du lieu d'interaction) dans laquelle se situe le joueur


    public Player(String pseudo){
        this.pseudo = pseudo;
        inventory = new ArrayList<>();
        position = 1001; // le joueur débute dans la salle 1001
    }


    public String getPseudo() {
        return pseudo;
    }

    public ArrayList<Integer> getInventory() {
        return inventory;
    }

    public int getPosition() {
        return position;
    }


    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setInventory(ArrayList<Integer> inventory) {
        this.inventory = inventory;
    }

    public void setPosition(int position) {
        this.position = position;
    }


    public void move(int destination){ // bouge le joueur vers un nouvel écran (salle/sous-salle/énigme)
        Game.player.setPosition(destination);
        Engine.engine.refreshRoom();
    }

    public boolean add_to_inventory(int id_item){ // Ajoute un objet à l'inventaire du joueur
        if(getInventory().size()< 3){
            this.inventory.add(id_item);
            Game.search_item(id_item).set_actions_available(true);
            Engine.engine.refreshInventory();
            return true;
        }else{
            // message "Inventaire plein revenez plus tard"
            return false;
        }
    }

    public void remove_from_inventory(int id_item){ // Supprime un objet de l'inventaire du joueur
        Game.search_item(id_item).set_actions_available(false);
        int i = 0;
        boolean found = false;
        while(i<Game.getItems().size() && !found){
            if(Game.getItems().get(i).getId()==id_item){
                Game.player.inventory.remove(i);
                found = true;
            }
            i++;
        }
        Engine.engine.refreshInventory();
    }

}