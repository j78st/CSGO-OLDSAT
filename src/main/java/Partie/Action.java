package Partie;

import java.util.ArrayList;

public class Action {
    int id;
    String text;
    boolean doable;
    ArrayList<int[]> consequence;


    public Action(int id,String text, ArrayList<int[]> consequence, Room room, boolean doable) { //Action "générale", doable à false pour les déplacement vers salle vérouillées au départ par exemple
        this.id=id;
        this.text = text;
        this.consequence=consequence;
        this.doable = doable;
        room.add_action(this);
        Game.actions.add(this);
    }

    public Action(int id,String text, ArrayList<int[]> consequence, Room room, Gear gear) { //Action liée à un objet
        this.id=id;
        this.text = text;
        this.consequence = consequence;
        this.doable = false;
        room.add_action(this);
        Game.actions.add(this);
        gear.actions.add(this);
    }

    public void setDoable(boolean doable) {
        this.doable = doable;
    }

    public void Consequence(){
        for(int i =0;i<consequence.size();i++){
            switch (this.consequence.get(i)[0]) {
                case 1: // mouvement vers la salle arg_conséquence
                    Game.player.move(this.consequence.get(i)[1]);
                    break;
                case 2: // dévérouillage d'une action
                    Game.search_action(this.consequence.get(i)[1]).setDoable(true);
                    break;
                case 3: // vérouillage d'une action
                    Game.search_action(this.consequence.get(i)[1]).setDoable(false);
                    break;
                case 4: // ajout de l'objet arg_consequence à l'inventaire
                    if(Game.player.add_inventory(Game.search_gear(this.consequence.get(i)[1]))){
                        Game.search_action(this.id).setDoable(false);
                     }
                     break;
                case 5: // suppression de l'objet arg_consequence de l'inventaire
                     Game.player.remove_inventory(Game.search_gear(this.consequence.get(i)[1]));
                     break;
                case 6: // utilisation de l'objet arg_consequence
                    Game.search_gear(this.consequence.get(i)[1]).use_gear();
                    break;
                case 7: // résultat d'une énigme
                    if(Game.search_enigma(Game.player.position).check_solution(this.consequence.get(i)[1])) {
                       Game.search_enigma(Game.player.position).consequence();
                       Game.search_room(Game.search_enigma(Game.player.position).neighbours[2]).search_access_enigma(Game.player.position).setDoable(false);
                       Game.player.move(Game.search_enigma(Game.player.position).neighbours[2]);
                    }
                    else { // mauvaise solution -> effet visuel / msg}
                        break;
                    }
             }
        }
    }
}
