package Partie;

import Interface.Settings.Engine;
import java.util.ArrayList;

public class Room {
    int id; // l'identifiant de la salle ou du lieu d'interaction
    // le chiffre des milliers vaut 1 si c'est une salle, 2 si c'est un lieu d'interaction, 3 si c'est une énigme
    // le chiffre des centaines indique l'étage où se situe la salle, 0 pour le rez-de-chaussée
    int[] neighbours = new int [4]; // les identifiants des salles voisines
    // pour un lieu d'interaction, tous les identifiants valent -1 sauf le voisin sud (case n°2) qui est la salle contenant le lieu d'interaction
    boolean access; // indique si la salle ou le lieu d'interaction est accessible
    int id_text; // identifiant du texte lié à la salle
    String path_image; // url de l'image liée à la salle
    // ArrayList<String> sounds;
    ArrayList<Integer> id_actions; // identifiants des actions réalisables dans cette salle

    /**
     * Constructeur d'une salle
     * @param id identifiant de la salle
     * @param neighbour_north identifiant de son voisin nord, -1 s'il n'existe pas
     * @param neighbour_east identifiant de son voisin est, -1 s'il n'existe pas
     * @param neighbour_south identifiant de son voisin sud, -1 s'il n'existe pas
     * @param neighbour_west identifiant de son voisin ouest, -1 s'il n'existe pas
     * @param access indique si la salle est accessible
     * @param id_text identifiant du texte de la salle
     * @param path_image URL de l'image de la salle
     */
    public Room(int id, int neighbour_north, int neighbour_east, int neighbour_south, int neighbour_west,
                boolean access, int id_text, String path_image/*, ArrayList<String> sounds*/){
        this.id = id;
        this.neighbours[0] = neighbour_north;
        this.neighbours[1] = neighbour_east;
        this.neighbours[2] = neighbour_south;
        this.neighbours[3] = neighbour_west;
        this.access = access;
        this.id_text = id_text;
        this.path_image = path_image;
        this.id_actions = new ArrayList<>();
        // this.sounds = sounds;
        Game.rooms.add(this); // ajoute la salle à la liste des salles/lieux d'interaction disponibles dans le jeu
    }

    /**
     * Constructeur d'un lieu d'interaction
     * @param id identifiant du lieu d'intarcation
     * @param origin_room identifiant de la salle dans laquelle il se situe
     * @param id_text identifiant du lieu d'intarcation
     * @param path_image URL de l'image du lieu d'intarcation
     */
    public Room(int id, int origin_room,
                int id_text, String path_image/*, ArrayList<String> sounds*/){
        this.id = id;
        this.neighbours[0] = -1;
        this.neighbours[1] = -1;
        this.neighbours[2] = origin_room;
        this.neighbours[3] = -1;
        this.access = true;
        this.id_text = id_text;
        this.path_image = path_image;
        this.id_actions = new ArrayList<>();
        // this.sounds = sounds;
        Game.rooms.add(this); // ajoute la salle à la liste des salles/lieux d'interaction disponibles dans le jeu
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getNeighbours() {
        return neighbours;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public int getId_text() {
        return id_text;
    }

    public String getPath_image() {
        return path_image;
    }

    public ArrayList<Integer> getId_actions() {
        return id_actions;
    }


    public void add_action(int id_action){ // ajoute une action à la liste des actions possibles de la salle
        this.id_actions.add(id_action);
    }

    /**
     * méthode recherchant une action menant à une énigme
     * @param id_enigma identifiant de l'énigme à laquelle l'action conduit
     * @return l'action recherchée
     */
    public Action search_action_with_enigma(int id_enigma){ // recherche l'action qui donne accès à une énigme
        Action res = null;
        for(int i = 0; i< getId_actions().size();i++){
            for(int j = 0; j< Game.search_action(getId_actions().get(i)).getConsequences().size();j++){
              if(Game.search_action(getId_actions().get(i)).getConsequences().get(j)[0] == 1 && Game.search_action(getId_actions().get(i)).getConsequences().get(j)[1] ==  id_enigma){
                  res = Game.search_action(getId_actions().get(i));
              }
            }
        }
        return res;
    }

    /**
     * méthode ajoutant du texte à une salle
     * @param more_text le texte à rajouter
     */
    public void text_evolve(String more_text){ // rajoute du texte au texte à afficher avec la salle
        int i = 0;
        boolean found = false;
        while(i<Game.getTexts().size() && !found) {
            if (Game.getTexts().get(i).getId() == getId_text()) {
                Game.texts.get(i).text = Game.texts.get(i).text + more_text;
                found = true;
            }
            i++;
        }
        Engine.engine.refreshText();
    }

    /**
     * méthode permettant de bloquer l'accès à tous les voisins (sert pour le mode bac à sable)
     */
    public void close_neighboors(){
        for(int i = 0; i<4; i++) {
            if (neighbours[i] != -1) {
                Game.search_room(neighbours[i]).setAccess(false);
            }
        }
    }

    /**
     * méthode permettant de savoir, à partir de son id, si une salle est une salle voisine ou pas
     */
    public boolean is_a_neighboor(int id_room){
        boolean res = false;
        for(int i=0; i<4; i++){
            if(id_room == neighbours[i]){
                res = true;
            }
        }
        return res;
    }

}
