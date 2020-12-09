package Partie;

import java.util.ArrayList;

public class Enigma extends Room{
    int solution; // solution "encode" le résultat de l'énigme
    ArrayList<int[]> consequence;


    public Enigma(int nb, int origin_room, int solution, ArrayList<int[]> consequence){
        super(nb,origin_room);
        this.solution=solution;
        this.consequence=consequence;
        Game.enigmas.add(this);
    }

    public boolean check_solution(int suggestion){
        if (this.solution==suggestion){
            return true;
        }
        else{ return false;}
    }

    public void consequence(){
        for(int i =0;i<consequence.size();i++) {
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
            }
        }
    }


}
