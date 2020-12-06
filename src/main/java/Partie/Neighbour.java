package Partie;

public class Neighbour {
    int[] neighbours = new int[4];

    public Neighbour(int neighbour_north, int neighbour_east, int neighbour_south, int neighbour_west){
        this.neighbours[0]=neighbour_north;
        this.neighbours[1]=neighbour_east;
        this.neighbours[2]=neighbour_south;
        this.neighbours[3]=neighbour_west;
    }
}
