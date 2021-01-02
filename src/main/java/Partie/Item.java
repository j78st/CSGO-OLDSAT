package Partie;

import java.util.ArrayList;

public class Item {
    int id; // numéro d'identification de l'objet
    String name; // nom de l'objet
    String description; // texte décrivant l'objet
    String path_image; // url de l'image de l'item
    int max_usage; // nombre max d'usage de l'objet (-1 si infini)
    int current_usage; // nombre d'usage déjà fait de l'objet
    ArrayList<Integer> id_actions; // liste des actions nécessitant l'objet pour être effectuées


    public Item(int id, String name, String description, int max_usage, String url_image){
        this.id = id;
        this.name = name;
        this.description = description;
        this.path_image = url_image;
        this.max_usage = max_usage;
        this.current_usage = 0;
        this.id_actions = new ArrayList<>();
        Game.items.add(this); // ajoute l'objet à la liste des objets disponibles dans le jeu
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath_image() {
        return path_image;
    }

    public void setPath_image(String path_image) {
        this.path_image = path_image;
    }

    public int getMax_usage() {
        return max_usage;
    }

    public void setMax_usage(int max_usage) {
        this.max_usage = max_usage;
    }

    public int getCurrent_usage() {
        return current_usage;
    }

    public void setCurrent_usage(int current_usage) {
        this.current_usage = current_usage;
    }

    public ArrayList<Integer> getId_actions() {
        return id_actions;
    }

    public void setId_actions(ArrayList<Integer> id_actions) {
        this.id_actions = id_actions;
    }


    public void use_item(){ // ajoute un usage à l'objet et vérifie s'il doit être détruit
        setCurrent_usage(getCurrent_usage()+1);
        if(current_usage == max_usage){
            Game.player.remove_from_inventory(this.id);
        }
    }

    public void set_actions_available(boolean bool){ // met à jour la faisabilité des actions liées à l'objet
        for(int i =0;i<this.id_actions.size();i++){
            Game.search_action(id_actions.get(i)).setAvailable(bool);
        }
    }


}
