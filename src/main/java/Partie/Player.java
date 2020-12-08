package Partie;

public class Player {
    String pseudo;
    Object[] inventory;
    int position;
    int feature;

    public Player(String pseudo, int feature){
        this.pseudo = pseudo;
        this.inventory =  new Object[3];
        this.position = 101;
        this.feature = feature;
    }

    public void move(int destination){
        this.position=destination;
    }
}
