package Partie;

import Interface.Settings.Engine;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;

public class Player {
    String pseudo; // pseudo du joueur
    ArrayList<Integer> inventory; // liste des identifiants des objets possédés par le joueur
    int position; // numéro de la salle (ou du lieu d'interaction) dans laquelle se situe le joueur

    /**
     * Constructeur du joueur
     * @param pseudo le pseudo du joueur
     */
    public Player(String pseudo){
        this.pseudo = pseudo;
        inventory = new ArrayList<>();
        position = 101; // le joueur débute dans la salle 1001
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


    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * méthode effectuant le déplacement du joueur
     * @param destination l'idendifiant de la salle vers laquelle se déplace le joueur
     */
    public void move(int destination){ // bouge le joueur vers un nouvel écran (salle/sous-salle/énigme)
        Game.player.setPosition(destination);
        Engine.engine.refreshRoom();
    }

    /**
     * méthode ajoutant un objet à l'inventaire du joueur
     * @param id_item identifiant de l'objet à ajouter
     * @return un booléen indiquant si l'opération a réussi (échec en cas d'inventaire déjà plein)
     */
    public boolean add_to_inventory(int id_item){ // Ajoute un objet à l'inventaire du joueur
        if(getInventory().size()< 3){
            this.inventory.add(id_item);
            Game.search_item(id_item).set_actions_available(true);
            Engine.engine.refreshInventory();
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING, "Votre inventaire est plein, revenez plus tard", ButtonType.OK);
            alert.showAndWait();
            return false;
        }
    }

    /**
     * méthode supprimant un objet de l'inventaire
     * @param id_item identifiant de l'objet à supprimer
     */
    public void remove_from_inventory(int id_item){ // Supprime un objet de l'inventaire du joueur
        Game.search_item(id_item).set_actions_available(false);
        int i = 0;
        boolean found = false;
        while(i<inventory.size() && !found){
            if(inventory.get(i)==id_item){
                Game.player.inventory.remove(i);
                found = true;
            }
            i++;
        }
        Engine.engine.refreshInventory();
    }

    /**
     * méthode permettant de vider complètement l'inventaire du joueur
     */
    public void clear_inventory(){
        inventory.clear();
        Engine.engine.refreshInventory();
    }

}