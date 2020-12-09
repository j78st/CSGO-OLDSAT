package Partie;

import java.util.ArrayList;

public class Enigma extends Room{
    int solution; // solution "encode" le résultat de l'énigme
    ArrayList<int[]> consequence; // liste de couples définissant les conséquence de la rsolution de l'énigme, forme (type de conséquence, argument nécessaire à la réalisation de cette conséquence)


    public Enigma(String path_txt, String path_image, int nb, int origin_room, int solution, ArrayList<int[]> consequence, ArrayList<String> sounds){
        super(path_txt,path_image,nb,origin_room,sounds);
        this.solution=solution;
        this.consequence=consequence;
        Game.enigmas.add(this); // ajoute l'énigme à la liste de toutes les énigmes du jeu
    }

    public boolean check_solution(int suggestion){ // vérifie si la suggestion donnée correspond ou non au résultat attend ude l'énigme
        if (this.solution==suggestion){
            return true;
        }
        else{ return false;}
    }

    public void consequence(){ // conséquences liées à la résolution de l'énigme
        for(int i =0;i<consequence.size();i++) {
            switch (this.consequence.get(i)[0]) {
                case 1: // mouvement vers la salle de numéro d'identification arg_conséquence
                    Game.player.move(this.consequence.get(i)[1]);
                    break;
                case 2: // dévérouillage d'une action de numéro d'identification arg_conséquence
                    Game.search_action(this.consequence.get(i)[1]).setDoable(true);
                    break;
                case 3: // vérouillage d'une action de numéro d'identification arg_conséquence
                    Game.search_action(this.consequence.get(i)[1]).setDoable(false);
                    break;
            }
        }
    }


}
