package Partie;

import java.util.ArrayList;

public class Game {
    public static Player player; // informations liées au joueur
    public static ArrayList<Room> rooms; // liste de toutes les salles/lieux d'interaction
    public static ArrayList<Enigma> enigmas; // liste de toutes les énigmes
    public static ArrayList<Action> actions; // liste de toutes les actions
    public static ArrayList<Item> items; // liste de tous les objets
    public static ArrayList<Text_scenario> texts; // liste de tous les scénarios
    public static int difficulty; // difficulté choisie pour la partie
    public static int timer;


    public Game(Player player, int difficulty) {
        Game.player = player;
        rooms = new ArrayList<>();
        enigmas = new ArrayList<>();
        actions = new ArrayList<>();
        items = new ArrayList<>();
        texts = new ArrayList<>();
        Game.difficulty = difficulty;
        timer = 0;
    }


    public static Player getPlayer() {
        return player;
    }

    public static ArrayList<Room> getRooms() {
        return rooms;
    }

    public static ArrayList<Enigma> getEnigmas() {
        return enigmas;
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

    public int getDifficulty() {
        return difficulty;
    }

    public int getTimer() {
        return timer;
    }


    public static void setPlayer(Player player) {
        Game.player = player;
    }

    public static void setRooms(ArrayList<Room> rooms) {
        Game.rooms = rooms;
    }

    public static void setEnigmas(ArrayList<Enigma> enigmas) {
        Game.enigmas = enigmas;
    }

    public static void setActions(ArrayList<Action> actions) {
        Game.actions = actions;
    }

    public static void setItems(ArrayList<Item> items) {
        Game.items = items;
    }

    public static void setTexts(ArrayList<Text_scenario> texts) {
        Game.texts = texts;
    }

    public static void setDifficulty(int difficulty) {
        Game.difficulty = difficulty;
    }

    public static void setTimer(int timer) {
        Game.timer = timer;
    }


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

    public static int search_place_room(int id){
        int res = -1;
        if(!rooms.isEmpty()){
            for(int i = 0;i<rooms.size();i++){
                if (rooms.get(i).getId() == id){
                    res=i;
                }
            }
        }
        return res;
    }

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

}