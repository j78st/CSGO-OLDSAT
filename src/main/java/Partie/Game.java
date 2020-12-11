package Partie;

import java.util.ArrayList;

public class Game {
    public static Player player; // informations liées au joueur
    public static ArrayList<Room> map; // liste de toutes les salles/sous-salles/énigmes du jeu
    public static ArrayList<Enigma> enigmas; //liste de toutes les énigmes du jeu
    public static ArrayList<Action> actions; // liste de toutes les actions du jeu
    public static ArrayList<Gear> gears; // liste de tous les objets du jeu
    public static ArrayList<Text_scenario> scenario; // liste de tous les textes utilisés dans le jeu
    public static int difficulty; // difficulté choisie pour la partie => action sur le temps?
    public static int timer;

    public Game(){

    }

    public Game(Player player, int difficulty) {
        Game.player = player;
        map = new ArrayList<>();
        actions = new ArrayList<>();
        gears = new ArrayList<>();
        enigmas = new ArrayList<>();
        scenario = new ArrayList<>();
        this.difficulty = difficulty;
        this.timer = 0;
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

    public static Gear search_gear(int id){ // recherche un objet à partir de son numéro d'identification
        Gear res = null;
        if (!gears.isEmpty()){
            for(int i=0;i<gears.size();i++){
                if(gears.get(i).id == id) {
                    res = gears.get(i);
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

    public static Player getPlayer() {
        return player;
    }

    public static ArrayList<Room> getMap() {
        return map;
    }

    public static ArrayList<Enigma> getEnigmas() {
        return enigmas;
    }

    public static ArrayList<Action> getActions() {
        return actions;
    }

    public static ArrayList<Gear> getGears() {
        return gears;
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
}
