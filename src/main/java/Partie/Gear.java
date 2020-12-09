package Partie;

import java.util.ArrayList;

public class Gear {
    int id; // numéro d'identification de l'objet
    String name; // nom de l'objet
    String path_description; // url de la description liée à la salle
    int max_usage; // nombre max d'usage de l'objet (-1 si infini)
    int current_usage; // nombre d'usage déjà fait de l'objet
    ArrayList<Action> actions; // liste des actions nécessitant l'objet pour être effectuées

    public Gear(int id,String name,String path_description,int max_usage){
        this.id = id;
        this.name = name;
        this.path_description = path_description;
        this.max_usage = max_usage;
        this.current_usage = 0;
        this.actions = new ArrayList<Action>();
        Game.gears.add(this); // ajoute l'objet à la liste des objets disponibles dans le jeu
    }

    public void use_gear(){ // ajoute un usage à l'objet et vérifie s'il doit être détruit
        this.current_usage++;
        if(current_usage == max_usage){
            Game.player.remove_inventory(this);
            //message "vous avez perdu l'objet ..." ??
        }
    }

    public void set_actions_doable(boolean bool){ // met à jour la faisabilité des actions liées à l'objet
        for(int i =0;i<this.actions.size();i++){
            this.actions.get(i).setDoable(bool);
        }
    }

}
