package Partie;

public class Game {
    public static Player player;
    public static Map map;
    int difficulty;
    int timer;

    public Game(Player player, Map map, int difficulty) {
        this.player = player;
        this.map = map;
        this.difficulty = difficulty;
        this.timer = 0;
    }
}
