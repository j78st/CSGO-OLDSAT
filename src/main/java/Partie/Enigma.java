package Partie;

import java.util.ArrayList;

public class Enigma extends Room{
    int solution; // solution "encode" le résultat de l'énigme
    ArrayList<int[]> consequence; // liste de couples définissant les conséquence de la rsolution de l'énigme, forme (type de conséquence, argument nécessaire à la réalisation de cette conséquence)
    int error_done; //entier pour savoir le nombre d'erreur à avoir été commises, permet de ne pas re-afficher le message d'erreur et de proposer un indice

    public Enigma(int id_txt, String path_image, int nb, int origin_room, int solution, ArrayList<int[]> consequence, ArrayList<String> sounds){
        super(id_txt,path_image,nb,origin_room,sounds);
        this.solution=solution;
        this.consequence=consequence;
        this.error_done = 0;
        Game.enigmas.add(this); // ajoute l'énigme à la liste de toutes les énigmes du jeu
    }

    public void check_solution(int suggestion){ // vérifie si la suggestion donnée correspond ou non au résultat attend ude l'énigme
        if (this.solution==suggestion){
            Game.search_room(this.neighbours[2]).search_access_enigma(this.nb).setDoable(false); // rend l'accès à cette énigme impossible
            Game.player.move(this.neighbours[2]); // renvoie le joueur à l'écran précédent l'énigme
            this.consequence(); //met en place les conséquences de la résolution de l'énigme
        }
        else{
            error_done++;
            if(error_done == 1){
                this.txt_evolve(Game.search_txt(404)); // fait évoluer le texte de l'énigme pour que le joueur sâche que sa solution n'est pas la bonne
            }else if(error_done >= 3){
                this.txt_evolve(Game.search_txt(405)); // propose au joueur de prendre un indice
            }
        }
    }

    public void consequence(){ // conséquences liées à la résolution de l'énigme
        for(int i =0;i<consequence.size();i++) {
            switch (this.consequence.get(i)[0]) {
                case 1: // mouvement vers la salle de numéro d'identification consequence[1]
                    Game.player.move(this.consequence.get(i)[1]);
                    break;
                case 2: // dévérouillage d'une action de numéro d'identification consequence[1]
                    Game.search_action(this.consequence.get(i)[1]).setDoable(true);
                    break;
                case 3: // vérouillage d'une action de numéro d'identification consequence[1]
                    Game.search_action(this.consequence.get(i)[1]).setDoable(false);
                    break;
                case 4: // suppression de l'objet de numéro d'identification consequence[1] de l'inventaire
                    Game.player.remove_inventory(Game.search_gear(this.consequence.get(i)[1]));
                    break;
                case 5: // utilisation de l'objet de numéro d'identification consequence[1]
                    Game.search_gear(this.consequence.get(i)[1]).use_gear();
                    break;
                case 6: // affichage d'un nouveau texte consequence[i][1] dans la salle consequence[i][2]
                    Game.search_room(this.consequence.get(i)[2]).txt_evolve(Game.search_txt(this.consequence.get(i)[1]));
                    break;
            }
        }
    }


}
