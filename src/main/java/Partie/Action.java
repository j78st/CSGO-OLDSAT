package Partie;

import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Engine;
import Music.Systems.PlayList;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import Timer.Timer;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.io.IOException;
import java.lang.reflect.Array;
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
                    Game.search_room(Game.getPlayer().getPosition()).play_music(); //Lance sons d'ambiance et arrête ceux non voulus
                    Game.search_room(Game.getPlayer().getPosition()).access_map(); //Donne accès à la map si nécessaire
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
                    if (Game.player.add_to_inventory((getConsequences().get(i)[1]))) { // Si l'ajout à l'inventaire se passe bien (il reste de la place dans l'inventaire)
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
                    if (Game.getBas() == 0 || !Game.search_room(Game.getBas()).is_a_neighbour(getConsequences().get(i)[1])) { // si on n'est pas en mode bac à sable ou si la salle à débloquer n'est pas un voisin de la salle testée en mode bac à sable (car on veut bloquer le joueur dans la salle testée dans ce mode)
                        Game.search_room(getConsequences().get(i)[1]).setAccess(true);
                        Engine.engine.refreshRoom();
                    } else { // on est en mode bac à sable et on tente de débloquer l'accès à un voisin
                        Game.search_room(Game.getBas()).text_evolve("\n\n[Vous avez bien débloqué une salle voisine mais" +
                                ", étant en mode bac à sable, l'accès à celle-ci ne vous est pas autorisé.]\n");
                    }
                    break;
                case 10: // affiche la boite à réponses
                    Engine.engine.answer_box_visible(true);
                    break;
                case 11: // affiche écran fin de partie
                    (new LoadMap()).display_screen_from_id(LoadMap.END_GAME);
                    WorldBoxDisc.play(Son.finEnigme);
                    break;
                case 12: // mouvement particulier du joueur pour le mode bac à sable
                    Game.setBas(getConsequences().get(i)[1]); // on met le numéro de la salle traitée dans game.bas
                    Game.player.move(getConsequences().get(i)[1]); // bouge le joueur dans la salle à tester
                    Game.getPlayer().clear_inventory(); // vide l'inventaire du joueur
                    Game.player.add_to_inventory(42); // donne l'objet d'id 42 (id normalisée pour le couteau suisse admin)
                    Game.search_room(Game.getPlayer().position).close_neighbours(); // bloque l'accès à tous les voisins
                    Game.set_object_actions_available();
                    Game.search_room(getConsequences().get(i)[1]).setAccess(true);
                    Engine.engine.timer_lbl.setVisible(false);
                    Game.search_room(Game.getPlayer().getPosition()).play_music(); //Lance le bon son ambiant
                    Game.search_room(Game.getPlayer().getPosition()).access_map(); //Donne accès à la map si nécessaire
                    Engine.engine.refreshRoom();
                    break;
                case 13: // faire évoluer texte affiché par une action, consequence[i][1] correspond à l'action à modifier, consequence[i][2] correspond à l'id du nouveau texte (sert à faire évoluer le texte de l'indice)
                    for (int j = 0; j < Game.search_action(getConsequences().get(i)[1]).consequences.size(); j++) {
                        if (Game.search_action(getConsequences().get(i)[1]).consequences.get(j)[0] == 7) { //cherche la conséquence écrivant du texte, on part du principe qu'il ne peut y en avoir qu'une par action
                            Game.search_action(getConsequences().get(i)[1]).consequences.get(j)[1] = getConsequences().get(i)[2];
                        }
                    }
                    break;
                case 14: // retirer du temps (en seconde) au timer (sert pour demande d'indice)
                    Engine.chrono.penaltyTime(getConsequences().get(i)[1]);
                    break;
                case 15: // lance une cinématique
                    FadeTransition fadeOUT = new FadeTransition();
                    fadeOUT.setDuration(Duration.seconds(4));
                    fadeOUT.setNode(Engine.engine.root);
                    fadeOUT.setFromValue(1);
                    fadeOUT.setToValue(0);
                    if(getConsequences().get(i)[1] == 1) {
                        Engine.engine.fond_vue.setStyle("-fx-background-color: black");
                        fadeOUT.setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                try {
                                    (new LoadMap()).display_screen_from_id(LoadMap.CUTSCENE);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }else if(getConsequences().get(i)[1] == 2) {
                        Engine.engine.fond_vue.setStyle("-fx-background-color: white");
                        fadeOUT.setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                try {
                                    (new LoadMap()).display_screen_from_id(LoadMap.OUTRO);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                    fadeOUT.play();
                    break;
                case 16: // changer image de la salle consequence[i][1] par l'image d'url "pictures/" + id_room + "/" + consequence[i][2], cela implique une normalisation du nom des images
                    Game.search_room(getConsequences().get(i)[1]).setPath_image("pictures/" + getConsequences().get(i)[1] + "/" + getConsequences().get(i)[2] +".png");
                    Engine.engine.refreshPicture();
                    break;
                case 17: //jouer plusieurs sons les uns après les autres
                    ArrayList<String> sounds_playlist = new ArrayList<>();
                    for (int j = 1; j < getConsequences().get(i).length; j++) {
                        sounds_playlist.add(Game.search_sounds(String.valueOf(getConsequences().get(i)[j])));
                    }
                    PlayList playlist = new PlayList(sounds_playlist);
                    playlist.start();
                    break;
                case 18: //jouer plusieurs sons les uns après les autres avec un délai entre chaque. Forme de la conséquence : [18, id_son1, delay, id_son2, delay, id_son3,...]
                    ArrayList<String> sounds_playlist2 = new ArrayList<>();
                    for (int j = 1; j < getConsequences().get(i).length; j=j+2) {
                        sounds_playlist2.add(Game.search_sounds(String.valueOf(getConsequences().get(i)[j])));
                    }
                    ArrayList<Integer> sounds_playlist_delay = new ArrayList<>();
                    for (int k = 2; k < getConsequences().get(i).length; k=k+2) {
                        sounds_playlist_delay.add(getConsequences().get(i)[k]);
                    }
                    PlayList playlist2 = new PlayList(sounds_playlist2,sounds_playlist_delay);
                    playlist2.start();
                    break;
                case 19: //lancer un son d'ambiance
                    WorldBoxDisc.play(Game.search_sounds(String.valueOf(getConsequences().get(i)[1])));
                    break;
                case 20: //mettre en pause un son d'ambiance
                    WorldBoxDisc.pause(Game.search_sounds(String.valueOf(getConsequences().get(i)[1])));
                    break;
                case 21: //arrêter le timer et faire disparaitre l'encadré servant à l'afficher (sert quand on passe en mode exploration)
                    if(Game.getBas() == 0){
                        Engine.chrono.toogleTimer();
                        Engine.engine.timer_lbl.setVisible(false);
                    }
                    break;
                case 22:
                    Engine.engine.set_map_available(true);
                    Engine.engine.refresh_map("pictures/map/map.png");
                    Engine.engine.refreshRoom();
                    break;
                case 23:
                   Game.getPlayer().setPosition(getConsequences().get(i)[1]);
                   break;

            }
        }
    }
}
