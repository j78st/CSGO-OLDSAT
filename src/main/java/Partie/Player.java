package Partie;

import java.util.ArrayList;

public class Player {
    String pseudo;
    ArrayList<Gear> inventory; // liste des objets possédés par le joueur
    int position; // numéro de la salle/sous-salle/énigme affichée au joueur

    public Player(String pseudo){
        this.pseudo = pseudo;
        this.inventory =  new ArrayList<Gear>();
        this.position = 101;
    }

    public void move(int destination){ // bouge le joueur vers un nouvel écran (salle/sous-salle/énigme)
        this.position=destination;
        //changer affichage
    }

    public boolean add_inventory(Gear gear){ // Ajoute un objet à l'inventaire du joueur
        if(this.inventory.size()< 3){
            this.inventory.add(gear);
            gear.set_actions_doable(true);
            return true;
        }else{
            // message "Inventaire plein"??
            return false;
        }
    }

    public void remove_inventory(Gear gear){ // Supprime un objet de l'inventaire du joueur
        this.inventory.remove(gear);
        gear.set_actions_doable(false);
    }
}
