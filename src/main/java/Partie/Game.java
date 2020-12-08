package Partie;

import java.util.ArrayList;

public class Game {
    public static Player player;
    public static Map map;
    public static ArrayList<Action> actions;
    int difficulty;
    int timer;

    public Game(Player player, Map map, int difficulty) {
        Game.player = player;
        Game.map = map;
        actions = new ArrayList<Action>();
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
}
