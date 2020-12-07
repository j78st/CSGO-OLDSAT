package Partie;

import java.io.File;

public class Room {
    int nb;
    boolean access;
    int[] neighbours = new int [4];

    public Room(int nb,boolean access, Map map, int neighbour_north, int neighbour_east, int neighbour_south, int neighbour_west){
        this.nb=nb;
        this.access=access;
        this.neighbours[0]=neighbour_north;
        this.neighbours[1]=neighbour_east;
        this.neighbours[2]=neighbour_south;
        this.neighbours[3]=neighbour_west;
        map.add_room(this);
    }
}
