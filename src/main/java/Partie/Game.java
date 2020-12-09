package Partie;

import java.util.ArrayList;

public class Game {
    public static Player player; // informations liées au joueur
    public static ArrayList<Room> map; // liste de toutes les salles/sous-salles/énigmes du jeu
    public static ArrayList<Enigma> enigmas; //liste de toutes les énigmes du jeu
    public static ArrayList<Action> actions; // liste de toutes les actions du jeu
    public static ArrayList<Gear> gears; // liste de tous les objets du jeu
    int difficulty; // difficulté choisie pour la partie => action sur le temps?
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

    public static Action search_action(int id){ // recherche une action à partir de son numéro d'identification
        int i=0;
        while(actions.get(i).id!=id){
            i++;
        }
        return actions.get(i);
    }

    public static Gear search_gear(int id){ // recherche un objet à partir de son numéro d'identification
        int i=0;
        while(gears.get(i).id!=id){
            i++;
        }
        return gears.get(i);
    }

    public static Room search_room(int nb){ // recherche une salle à partir de son numéro d'identification
        int i=0;
        while(map.get(i).nb!=nb){
            i++;
        }
        return map.get(i);
    }

    public static Enigma search_enigma(int nb){ // recherche une énigme à partir de son numéro d'identification
        int i=0;
        while(enigmas.get(i).nb!=nb){
            i++;
        }
        return enigmas.get(i);
    }
}
