package Partie;

import java.util.ArrayList;

public class Item {
    int id; // numéro d'identification de l'objet
    String name; // nom de l'objet
    String description; // url de la description liée à la salle
    int max_usage; // nombre max d'usage de l'objet (-1 si infini)
    int current_usage; // nombre d'usage déjà fait de l'objet
    ArrayList<Action> actions; // liste des actions nécessitant l'objet pour être effectuées
    String URL_image;

    public Item(int id, String name, String description, int max_usage, String url_image){
        this.URL_image = url_image;
        this.id = id;
        this.name = name;
        this.description = description;
        this.max_usage = max_usage;
        this.current_usage = 0;
        this.actions = new ArrayList<>();
        Game.items.add(this); // ajoute l'objet à la liste des objets disponibles dans le jeu
    }

    public void use_gear(){ // ajoute un usage à l'objet et vérifie s'il doit être détruit
        this.current_usage++;
        if(current_usage == max_usage){
            Game.player.remove_inventory(this);
        }
    }

    public void set_actions_doable(boolean bool){ // met à jour la faisabilité des actions liées à l'objet
        for(int i =0;i<this.actions.size();i++){
            this.actions.get(i).setDoable(bool);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getMax_usage() {
        return max_usage;
    }

    public int getCurrent_usage() {
        return current_usage;
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public String getURL_image() {
        return URL_image;
    }

}
