package Interface.Save;


import Partie.Game;
import Serialization.Serial_game;

public class SaveSlot {

    public int no;
    public Serial_game srgame;

    public SaveSlot() {

    }

    public SaveSlot(int no, Serial_game game) {
       this.srgame = game;
       this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Serial_game getSrgame() {
        return srgame;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setSrgame(Serial_game srgame) {
        this.srgame = srgame;
    }
}
