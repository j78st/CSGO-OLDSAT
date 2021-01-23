package Partie;

import Interface.Settings.Engine;

import java.io.IOException;
import java.util.ArrayList;

public class Game {
    public static Player player; // informations liées au joueur
    public static ArrayList<Room> rooms; // liste de toutes les salles/lieux d'interaction
    public static ArrayList<Enigma> enigmas; // liste de toutes les énigmes
    public static ArrayList<Action> actions; // liste de toutes les actions
    public static ArrayList<Item> items; // liste de tous les objets
    public static ArrayList<Text_scenario> texts; // liste de tous les textes du scénario
    public static ArrayList<String[]> sounds; //liste de tous les sons
    public static int difficulty; // difficulté choisie pour la partie
    public static int timer;
    public static int bas;

    /**
     * Constructeur de la partie
     * @param player information liées au joueur
     * @param difficulty la difficulté de la partie, 0 pour facile, 1 pour normale, 2 pour difficile
     //* @param bas entier renseignant l'id de la salle traitée en mode bac à sable, 0 si mode de jeu normal
     */
    public Game(Player player, int difficulty) {
        Game.player = player;
        rooms = new ArrayList<>();
        enigmas = new ArrayList<>();
        actions = new ArrayList<>();
        items = new ArrayList<>();
        texts = new ArrayList<>();
        sounds = new ArrayList<>();
        Game.difficulty = difficulty;
        timer = 0;
        bas = 0;
    }

    public static Player getPlayer() {
        return player;
    }

    public static ArrayList<Action> getActions() {
        return actions;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public static ArrayList<Text_scenario> getTexts() {
        return texts;
    }

    public static ArrayList<Enigma> getEnigmas() { return enigmas; }

    public static int getDifficulty() {
        return difficulty;
    }

    public int getTimer() {
        return timer;
    }

    public static int getBas() { return bas; }

    public static void setPlayer(Player player) {
        Game.player = player;
    }

    public static void setActions(ArrayList<Action> actions) {
        Game.actions = actions;
    }

    public static void setTimer(int timer) {
        Game.timer = timer;
    }

    public static void setSounds(ArrayList<String[]> sounds) {
        Game.sounds = sounds;
    }

    public static void setBas(int bas) { Game.bas = bas; }

    /**
     * méthode recherchant une salle
     * @param id l'idendifiant de la salle recherchée
     * @return retourne la salle recherchée si elle existe, null sinon
     */
    public static Room search_room(int id){ // recherche une salle à partir de son numéro d'identification
        Room res = null;
        if (!rooms.isEmpty() && id != -1){
            for(int i=0;i<rooms.size();i++){
                if(rooms.get(i).id == id) {
                    res = rooms.get(i);
                }
            }
        }
        return res;
    }
    /**
     * méthode recherchant une énigme
     * @param id l'idendifiant de l'énigme recherchée
     * @return retourne l'énigme recherchée si elle existe, null sinon
     */
    public static Enigma search_enigma(int id){ // recherche une énigme à partir de son numéro d'identification
        Enigma res = null;
        if (!enigmas.isEmpty()){
            for(int i=0;i<enigmas.size();i++){
                if(enigmas.get(i).id == id) {
                    res = enigmas.get(i);
                }
            }
        }
        return res;
    }
    /**
     * méthode recherchant une action
     * @param id l'idendifiant de l'action recherchée
     * @return retourne l'action recherchée si elle existe, null sinon
     */
    public static Action search_action(int id){ // recherche une action à partir de son numéro d'identification
        Action res = null;
        if (!actions.isEmpty()) {
            for(int i=0;i<actions.size();i++){
                if(actions.get(i).id == id) {
                    res = actions.get(i);
                }
            }
        }
        return res;
    }
    /**
     * méthode recherchant un objet
     * @param id l'idendifiant de l'objet recherché
     * @return retourne l'objet recherché s'il existe, null sinon
     */
    public static Item search_item(int id){ // recherche un objet à partir de son numéro d'identification
        Item res = null;
        if (!items.isEmpty()){
            for(int i=0;i<items.size();i++){
                if(items.get(i).id == id) {
                    res = items.get(i);
                }
            }
        }
        return res;
    }
    /**
     * méthode recherchant un texte
     * @param id l'idendifiant du texte recherchée
     * @return retourne le texte recherché s'il existe, null sinon
     */
    public static String search_text(int id){ // recherche une texte à partir de son numéro d'identification
        String res = null;
        if (!texts.isEmpty()){
            for(int i=0;i<texts.size();i++){
                if(texts.get(i).id == id) {
                    res = texts.get(i).getText();
                }
            }
        }
        return res;
    }

    public static String search_sounds(String id){ // recherche un son à partir de son numéro d'identification
        String res = null;
        if (!sounds.isEmpty()){
            for(int i=0;i<sounds.size();i++){
                if(sounds.get(i)[0].equals(id)) {
                    res = sounds.get(i)[1];
                }
            }
        }
        return res;
    }

    /**
     * méthode permettant de nettoyer la game
     */
    public static void reset_game(){
        rooms = new ArrayList<>();
        enigmas = new ArrayList<>();
        actions = new ArrayList<>();
        items = new ArrayList<>();
        texts = new ArrayList<>();
    }

    /**
     * méthode permettant de débloquer toutes les actions liées à un objet (sert pour le mode bac à sable)
     */
    public static void set_object_actions_available(){
        for(int i = 0; i<items.size(); i++){
            items.get(i).set_actions_available(true);
        }
    }

    /**
     * méthode retournant une liste de toutes les salles accessibles depuis le mode bac à sable
     */
    public static ArrayList<Room> room_bas_access_available(){
        ArrayList<Room> res = new ArrayList<>();
        for(int i = 0; i<rooms.size(); i++){
           if(rooms.get(i).isBas()){
               res.add(rooms.get(i));
           }
        }
        return res;
    }

    public static void mouse_clicked(double x, double y) throws IOException {
        if(Game.getEnigmas().contains(Game.search_enigma(Game.getPlayer().getPosition()))
                && Game.search_enigma(Game.getPlayer().getPosition()).gest != 0){ //gest!=0 signifie que c'est une énigme cliquable
            Game.search_enigma(Game.getPlayer().getPosition()).check_click(x,y);
        }
        if((x>0.16 && x<0.214 && y>0.74 && y<0.84 && Game.player.inventory.get(0) == 5)
                || (x>0.224 && x<0.277 && y>0.74 && y<0.84 && Game.player.inventory.get(1) == 5)
                || (x>0.286 && x<0.339 && y>0.74 && y<0.84 && Game.player.inventory.get(2) == 5)){
            Engine.engine.refresh_map("pictures/map/carnet.png");
            Engine.engine.show_map();
        }

    }
}