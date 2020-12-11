package Interface.Save;

import java.io.Serializable;
import java.util.ArrayList;

public class Saves implements Serializable {

    ArrayList<SaveSlot> saves;

    public Saves() {
        saves = new ArrayList<>();
    }

    public ArrayList<SaveSlot> getSaves() { return saves; }

    public SaveSlot getSave(int index) {
        return saves.get(index);
    }

    public void setSave(int index, SaveSlot save){
        saves.set(index, save);
    }


}
