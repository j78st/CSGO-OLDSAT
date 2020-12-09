package Partie;

import java.util.ArrayList;

public class Game {
    public static Player player;
    public static ArrayList<Room> map;
    public static ArrayList<Enigma> enigmas;
    public static ArrayList<Action> actions;
    public static ArrayList<Gear> gears;
    int difficulty;
    int timer;

    public Game(Player player, int difficulty) {
        player = player;
        map = new ArrayList<Room>();
        actions = new ArrayList<Action>();
        gears = new ArrayList<Gear>();
        enigmas = new ArrayList<Enigma>();
        this.difficulty = difficulty;
        this.timer = 0;
    }

    public static Action search_action(int id){
        int i=0;
        while(actions.get(i).id!=id){
            i++;
        }
        return actions.get(i);
    }

    public static Gear search_gear(int id){
        int i=0;
        while(gears.get(i).id!=id){
            i++;
        }
        return gears.get(i);
    }

    public static Room search_room(int nb){
        int i=0;
        while(map.get(i).nb!=nb){
            i++;
        }
        return map.get(i);
    }

    public static Enigma search_enigma(int nb){
        int i=0;
        while(enigmas.get(i).nb!=nb){
            i++;
        }
        return enigmas.get(i);
    }
}
