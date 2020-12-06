package Partie;

public class Map {
    int nb_room;
    Neighbour[] map;

    public Map(int config){
        this.map[0]= new Neighbour(1,-1,-1,-1);
        this.map[1]= new Neighbour(2,-1,0,-1);
        this.map[2]= new Neighbour(-1,-1,1,-1);
    }
}
