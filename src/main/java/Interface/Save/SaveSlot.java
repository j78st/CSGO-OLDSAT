package Interface.Save;

import java.io.File;

public class SaveSlot {

    public int number;
    public String pseudo;
    File file;

    public SaveSlot() {

    }

    public SaveSlot(int n, String pseudo) {
        this.number = n;
        this.pseudo = pseudo;
    }


}
