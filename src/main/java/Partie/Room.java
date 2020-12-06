package Partie;

import java.io.File;

public class Room {
    Neighbour neighbours;

    public Room(int neighbour_north, int neighbour_east, int neighbour_south, int neighbour_west){
        this.neighbours = new Neighbour(neighbour_north,neighbour_east,neighbour_south,neighbour_west);
    }
}
