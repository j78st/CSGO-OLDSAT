package Partie;

public class Player {
    String pseudo;
    Gear[] inventory;
    int nb_objet;
    int position;
    int feature;

    public Player(String pseudo, int feature){
        this.pseudo = pseudo;
        this.inventory =  new Gear[3];
        this.nb_objet = 0;
        this.position = 101;
        this.feature = feature;
    }

    public void move(int destination){
        this.position=destination;
    }

    public void add_inventory(Gear gear){
        if(this.nb_objet < 3){
            this.inventory[nb_objet] = gear;
            this.nb_objet++;
        }else{
            // message "Inventaire plein"??
        }
    }

    public void remove_inventory(Gear gear){
        if(this.inventory[0]==gear){
            this.inventory[0]=this.inventory[1];
            this.inventory[1]=this.inventory[2];
            this.nb_objet--;
        }else if(this.inventory[1]==gear){
            this.inventory[1]=this.inventory[2];
            this.nb_objet--;
        }else if(this.inventory[2]==gear){
            this.nb_objet--;
        }
    }
}
