package Partie;

import java.util.ArrayList;

public class Room {
    int nb; // le chiffre des centaines vaut 1 si c'est une salle, 2 si c'est un lieu d'interaction
    boolean access;
    int[] neighbours = new int [4];
    ArrayList<Action> actions;

    public Room(int nb,boolean access, int neighbour_north, int neighbour_east, int neighbour_south, int neighbour_west){
        this.nb=nb;
        this.access=access;
        this.neighbours[0]=neighbour_north;
        this.neighbours[1]=neighbour_east;
        this.neighbours[2]=neighbour_south;
        this.neighbours[3]=neighbour_west;
        Game.map.add_room(this);
    }

    public Room(int nb, int origin_room){
        this.nb=nb;
        this.access=true;
        this.neighbours[0]=-1;
        this.neighbours[1]=-1;
        this.neighbours[2]=origin_room;
        this.neighbours[3]=-1;
    }
}
