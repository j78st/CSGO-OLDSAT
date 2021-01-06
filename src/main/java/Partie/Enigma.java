package Partie;

import Interface.ScreenLoader.LoadMap;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;

import java.io.IOException;
import java.util.ArrayList;

public class Enigma extends Room{
    int solution; // solution "encode" le résultat de l'énigme
    ArrayList<int[]> consequences; // liste de couples définissant les conséquences de la résolution de l'énigme, forme : (type de conséquence, argument nécessaire à la réalisation de cette conséquence)
    int nb_error; // le nombre d'erreur à avoir été commises

    public Enigma(int id, int origin_room, int id_text, String path_image, int solution, ArrayList<int[]> consequences){
        super(id,origin_room,id_text,path_image);
        this.solution=solution;
        this.consequences=consequences;
        this.nb_error = 0;
        Game.enigmas.add(this); // ajoute l'énigme à la liste de toutes les énigmes du jeu
    }


    public int getSolution() {
        return solution;
    }

    public void setSolution(int solution) {
        this.solution = solution;
    }

    public ArrayList<int[]> getConsequences() {
        return consequences;
    }


    public void setConsequences(ArrayList<int[]> consequences) {
        this.consequences = consequences;
    }

    public int getNb_error() {
        return nb_error;
    }

    public void setNb_error(int nb_error) {
        this.nb_error = nb_error;
    }


    public void check_solution(int suggestion) throws IOException { // vérifie si la suggestion donnée correspond ou non au résultat attendu de l'énigme
        if (getSolution()==suggestion){
            Game.search_room(this.neighbours[2]).search_action_with_enigma(this.getId()).setAvailable(false); // rend l'accès à cette énigme impossible
            Game.player.move(this.neighbours[2]); // renvoie le joueur à l'écran précédent l'énigme
            this.do_consequences(); // met en place les conséquences de la résolution de l'énigme
        }
        else{
            nb_error++;
            if(nb_error == 1){
                this.text_evolve(Game.search_text(4004)); // fait évoluer le texte de l'énigme pour que le joueur sâche que sa solution n'est pas la bonne
            }else if(nb_error == 3){
                this.text_evolve(Game.search_text(4005)); // propose au joueur de prendre un indice
            }
        }
    }

    public void do_consequences() throws IOException { // conséquences liées à la résolution de l'énigme
        for(int i = 0;i<getConsequences().size();i++) {
            switch (getConsequences().get(i)[0]) {
                case 1: // mouvement vers la salle de numéro d'identification consequence[1]
                    Game.player.move(getConsequences().get(i)[1]);
                    break;
                case 2: // dévérrouillage d'une action de numéro d'identification consequence[1]
                    Game.search_action(getConsequences().get(i)[1]).setAvailable(true);
                    break;
                case 3: // vérrouillage d'une action de numéro d'identification consequence[1]
                    Game.search_action(getConsequences().get(i)[1]).setAvailable(false);
                    break;
                case 5: // suppression de l'objet de numéro d'identification consequence[1] de l'inventaire
                    Game.player.remove_from_inventory(Game.search_item(getConsequences().get(i)[1]).id);
                    break;
                case 6: // utilisation de l'objet de numéro d'identification consequence[1]
                    Game.search_item(getConsequences().get(i)[1]).use_item();
                    break;
                case 7: // affichage d'un nouveau texte consequence[i][1] dans la salle consequence[i][2]
                    Game.search_room(getConsequences().get(i)[2]).text_evolve(Game.search_text(getConsequences().get(i)[1]));
                    break;
                case 8: // rend une salle inaccessible
                    Game.search_room(getConsequences().get(i)[1]).setAccess(false);
                    break;
                case 9: // rend une salle accessible
                    Game.search_room(getConsequences().get(i)[1]).setAccess(true);
                    break;
                case 10: // affiche écran fin de partie
                    LoadMap gl = new LoadMap();
                    gl.display_screen_from_id(LoadMap.END_GAME);
                    WorldBoxDisc.play(Son.hibou);
                    WorldBoxDisc.play(Son.valid);
                    break;
            }
        }
    }


}
