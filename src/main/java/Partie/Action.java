package Partie;

import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Engine;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;

import java.io.IOException;
import java.util.ArrayList;

public class Action {
    int id; // numéro d'identification de l'action
    boolean available; // action accessible pour le joueur ou non
    String text; // description textuelle de l'action
    ArrayList<int[]> consequences; // liste de couples définissant les conséquence de l'action, forme : (type de conséquence, argument nécessaire à la réalisation de cette conséquence)


    public Action(int id, boolean available, String text, ArrayList<int[]> consequences, int room) { //Action "générale", doable à false pour les déplacement vers salle vérouillées au départ par exemple
        this.id=id;
        this.available = available;
        this.text = text;
        this.consequences=consequences;
        Game.search_room(room).add_action(getId()); // ajoute l'action à la liste des actions réalisables dans la salle à laquelle elle est liée
        Game.actions.add(this); // ajoute l'action à la liste des actions du jeu
    }

    public Action(int id,String text, ArrayList<int[]> consequences, int room, int id_item) { //Action liée à un objet
        this.id=id;
        this.available = false;
        this.text = text;
        this.consequences = consequences;
        Game.search_room(room).add_action(getId()); // ajoute l'action à la liste des actions réalisables dans la salle à laquelle elle est liée
        Game.actions.add(this); // ajoute l'action à la liste des actions du jeu
        Game.search_item(id_item).id_actions.add(getId()); // ajoute l'action à la liste des actions nécessitant l'objet renseigné
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<int[]> getConsequences() {
        return consequences;
    }

    public void setConsequences(ArrayList<int[]> consequences) {
        this.consequences = consequences;
    }


    public void do_consequences() throws IOException {
        for(int i =0;i<getConsequences().size();i++){
            switch (getConsequences().get(i)[0]) {
                case 1: // mouvement vers la salle de numéro d'identification arg_conséquence
                    Game.player.move(getConsequences().get(i)[1]);
                    break;
                case 2: // dévérouillage d'une action de numéro d'identification arg_conséquence
                    Game.search_action(getConsequences().get(i)[1]).setAvailable(true);
                    Engine.engine.refreshAction();
                    break;
                case 3: // vérouillage d'une action de numéro d'identification arg_conséquence
                    Game.search_action(getConsequences().get(i)[1]).setAvailable(false);
                    Engine.engine.refreshAction();
                    break;
                case 4: // ajout de l'objet de numéro d'identification arg_consequence à l'inventaire
                    if(Game.player.add_to_inventory((getConsequences().get(i)[1]))){ // Si l'ajout à l'inventaire se passe bien (il reste de la place dans l'inventaire)
                        Game.search_action(getId()).setAvailable(false); // rend l'obtention de cette objet impossible
                     }
                     break;
                case 5: // suppression de l'objet de numéro d'identification arg_consequence de l'inventaire
                     Game.player.remove_from_inventory(Game.search_item(getConsequences().get(i)[1]).id);
                     break;
                case 6: // utilisation de l'objet de numéro d'identification arg_consequence
                    Game.search_item(getConsequences().get(i)[1]).use_item();
                    break;
                case 7: // affichage d'un nouveau texte (fonctionne aussi pour la demande d'indice)
                    Game.search_room(Game.player.position).text_evolve(Game.search_text(getConsequences().get(i)[1])); // fait évoluer le texte de la salle dans laquelle le joueur se trouve en lui ajoutant le texte ayant pour id le code renseigné
                    break;
                case 8: // rend une salle inaccessible
                    Game.search_room(getConsequences().get(i)[1]).setAccess(false);
                    Engine.engine.refreshRoom();
                    break;
                case 9: // rend une salle accessible
                    if(Game.getBas() == 0 || !Game.search_room(Game.getBas()).is_a_neighboor(getConsequences().get(i)[1])) { // si on n'est pas en mode bac à sable ou si la salle à débloquer n'est pas un voisin de la salle testée en mode bac à sable (car on veut bloquer le joueur dans la salle testée dans ce mode)
                        Game.search_room(getConsequences().get(i)[1]).setAccess(true);
                        Engine.engine.refreshRoom();
                    }else{ // on est en mode bac à sable et on tente de débloquer l'accès à un voisin
                        Game.search_room(Game.getBas()).text_evolve("[Vous avez bien débloqué une salle voisine mais" +
                                ", étant en mode bac à sable, l'accès à celle-ci ne vous est pas autorisé.]\n");
                    }
                    break;
                case 10: // affiche la boite à réponses
                    Engine.engine.answer_box_visible(true);
                    break;
                case 11: // affiche écran fin de partie
                    LoadMap gl = new LoadMap();
                    gl.display_screen_from_id(LoadMap.END_GAME);
                    WorldBoxDisc.play(Son.hibou);
                    WorldBoxDisc.play(Son.valid);
                    break;
                case 12: // mouvement particulier du joueur pour le mode bac à sable
                    Game.setBas(getConsequences().get(i)[1]); // on met le numéro de la salle traitée dans game.bas
                    Game.player.move(getConsequences().get(i)[1]); // bouge le joueur dans la salle à tester
                    Game.getPlayer().clear_inventory(); // vide l'inventaire du joueur
                    Game.player.add_to_inventory(42); // donne l'objet d'id 42 (id normalisée pour le couteau suisse admin)
                    Game.search_room(Game.getPlayer().position).close_neighboors(); // bloque l'accès à tous les voisins
                    Game.set_object_actions_available();
                    Engine.engine.refreshRoom();
                    break;
                case 13: // faire évoluer texte affiché par une action, consequence[i][1] correspond à l'action à modifier, consequence[i][2] correspond à l'id du nouveau texte
                   for(int j = 0; j<Game.search_action(getConsequences().get(i)[1]).consequences.size(); j++){
                       if(Game.search_action(getConsequences().get(i)[1]).consequences.get(j)[0] == 7){ //cherche la conséquence écrivant du texte, on part du principe qu'il ne peut y en avoir qu'une par action
                           Game.search_action(getConsequences().get(i)[1]).consequences.get(j)[1] = getConsequences().get(i)[2];
                       }
                   }
                   break;
             }
        }
    }
}
