package Partie;

import java.util.ArrayList;

public class Game {
    public static Player player; // informations liées au joueur
    public static ArrayList<Room> map; // liste de toutes les salles
    public static ArrayList<Interactive_place> interactive_places; // Liste de tous les lieux d'interaction
    public static ArrayList<Action> actions; // liste de toutes les actions
    public static ArrayList<Enigma> enigmas; //liste de toutes les énigmes
    public static ArrayList<Item> items; // liste de tous les objets
    public static ArrayList<Text_scenario> scenario; // liste de tous les textes
    public static int difficulty; // difficulté choisie pour la partie
    public static int timer;


    public Game(Player player, int difficulty) {
        Game.player = player;
        map = new ArrayList<>();
        interactive_places = new ArrayList<>();
        actions = new ArrayList<>();
        enigmas = new ArrayList<>();
        items = new ArrayList<>();
        scenario = new ArrayList<>();
        Game.difficulty = difficulty;
        timer = 0;
    }


    public static Player getPlayer() {
        return player;
    }

    public static ArrayList<Room> getMap() {
        return map;
    }

    public static ArrayList<Interactive_place> getInteractive_places() {
        return interactive_places;
    }

    public static ArrayList<Action> getActions() {
        return actions;
    }

    public static ArrayList<Enigma> getEnigmas() {
        return enigmas;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public static ArrayList<Text_scenario> getScenario() {
        return scenario;
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

    public static void setMap(ArrayList<Room> map) {
        Game.map = map;
    }

    public static void setInteractive_places(ArrayList<Interactive_place> interactive_places) {
        Game.interactive_places = interactive_places;
    }

    public static void setActions(ArrayList<Action> actions) {
        Game.actions = actions;
    }

    public static void setEnigmas(ArrayList<Enigma> enigmas) {
        Game.enigmas = enigmas;
    }

    public static void setItems(ArrayList<Item> items) {
        Game.items = items;
    }

    public static void setScenario(ArrayList<Text_scenario> scenario) {
        Game.scenario = scenario;
    }

    public static void setDifficulty(int difficulty) {
        Game.difficulty = difficulty;
    }

    public static void setTimer(int timer) {
        Game.timer = timer;
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

    public static Item search_gear(int id){ // recherche un objet à partir de son numéro d'identification
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

    public static Room search_room(int nb){ // recherche une salle à partir de son numéro d'identification
        Room res = null;
        if (!map.isEmpty() && nb != -1){
            for(int i=0;i<map.size();i++){
                if(map.get(i).nb == nb) {
                    res = map.get(i);
                }
            }
        }
        return res;
    }

    public static Enigma search_enigma(int nb){ // recherche une énigme à partir de son numéro d'identification
        Enigma res = null;
        if (!enigmas.isEmpty()){
            for(int i=0;i<enigmas.size();i++){
                if(enigmas.get(i).nb == nb) {
                    res = enigmas.get(i);
                }
            }
        }
        return res;
    }

    public static String search_txt(int id){ // recherche une salle à partir de son numéro d'identification
        String res = null;
        if (!scenario.isEmpty()){
            for(int i=0;i<scenario.size();i++){
                if(scenario.get(i).id_text == id) {
                    res = scenario.get(i).getText();
                }
            }
        }
        return res;


    }
}

