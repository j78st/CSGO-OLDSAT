package Partie;

import java.util.ArrayList;

public class Map {
    ArrayList<Room> map;
    //image?

    public Map(){
        this.map= new ArrayList<Room>();
    }
    public void add_room(Room room){
        this.map.add(room);
    }

    public Room search_room(int nb){
        int i=0;
        while(this.map.get(i).nb!=nb){
            i++;
        }
        return this.map.get(i);
    }
}
