package Partie;

import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Engine;
import Music.Systems.PlayList;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class Enigma extends Room{
    String solution; // solution "encode" le résultat de l'énigme
    ArrayList<int[]> consequences; // liste de couples définissant les conséquences de la résolution de l'énigme, forme : (type de conséquence, argument nécessaire à la réalisation de cette conséquence)
    int nb_error; // le nombre d'erreur à avoir été commises
    //Attributs pour les énigmes avec images cliquables
    ArrayList<double[]> click_zones; //Liste des zones cliquables, forme [id_zone,X_min,X_max,Y_min,Y_max] avec les X et Y en pourcentage de l'écran (entre 0 et 1)
    ArrayList<Integer> clicks_memory; //Liste servant de mémoire des id des zones cliquées
    int gest; //Numéro du gestionnaire choisi. 0 si énigmee ne nécessitant pas de clics
    boolean resolved; //Booléen renseignant si l'énigme a été résolue ou non. false si non-résolu, true sinon

    /**
     * Constructeur d'énigme
     * @param id identifiant de l'énigme
     * @param origin_room identifiant de la salle qui comprote l'énigme
     * @param id_text texte décrivant l'énigme
     * @param path_image URL de l'image de l'énigme
     * @param solution entier encodant la solution de l'énigme
     * @param consequences tableau des couples de conséquences de l'énigme
     */
    public Enigma(int id, int origin_room, int id_text, String path_image, String solution, ArrayList<int[]> consequences){
        super(id,origin_room,id_text,path_image);
        this.solution=solution;
        this.consequences=consequences;
        this.nb_error = 0;
        this.click_zones = new ArrayList<>();
        this.clicks_memory =  new ArrayList<>();
        this.gest = 0;
        this.resolved = false;
        Game.enigmas.add(this); // ajoute l'énigme à la liste de toutes les énigmes du jeu
    }

    /**
     * Constructeur d'énigme
     *
     * @param id           identifiant de l'énigme
     * @param origin_room  identifiant de la salle qui comprote l'énigme
     * @param id_text      texte décrivant l'énigme
     * @param path_image   URL de l'image de l'énigme
     * @param solution     entier encodant la solution de l'énigme
     * @param consequences tableau des couples de conséquences de l'énigme
     * @param click_zones  liste des zones cliquables dans l'image de l'énigme
     * @param gest         numéro du gestionnaire choisi. Chaque gestionnaire correspond à un type d'énigme cliquable
     */
    public Enigma(int id, int origin_room, int id_text, String path_image, String solution, ArrayList<int[]> consequences,
                        ArrayList<double[]> click_zones, int gest) {
        super(id,origin_room,id_text,path_image);
        this.solution=solution;
        this.consequences=consequences;
        this.nb_error = 0;
        this.click_zones = click_zones;
        this.clicks_memory = new ArrayList<>();
        this.gest = gest;
        this.resolved = false;
        Game.enigmas.add(this); // ajoute l'énigme à la liste de toutes les énigmes du jeu
    }


    public String getSolution() {
        return solution;
    }

    public ArrayList<int[]> getConsequences() {
        return consequences;
    }


    public void setConsequences(ArrayList<int[]> consequences) {
        this.consequences = consequences;
    }

    /**
     * méthode appliquant les conséquences d'uné énigme après une proposition du joueur
     * @param suggestion proposition du joueur comme solution de l'énigme
     * @throws IOException
     */
    public void check_solution(String suggestion) throws IOException { // vérifie si la suggestion donnée correspond ou non au résultat attendu de l'énigme
        if (getSolution() .equals(suggestion.toLowerCase(Locale.ROOT))){
            Game.search_room(this.neighbours[2]).search_action_with_enigma(this.getId()).setAvailable(false); // rend l'accès à cette énigme impossible
            Game.player.move(this.neighbours[2]); // renvoie le joueur à l'écran précédent l'énigme
            Engine.engine.answer_box_visible(false);
            Engine.engine.answer_prompt.setText("");
            WorldBoxDisc.play(Son.bonusTime);
            this.do_consequences(); // met en place les conséquences de la résolution de l'énigme
        }else{
            /*nb_error++;
            if(nb_error == 1){
                this.text_evolve(Game.search_text(4004)); // fait évoluer le texte de l'énigme pour que le joueur sâche que sa solution n'est pas la bonne
            }else if(nb_error == 3){
                this.text_evolve(Game.search_text(4005)); // propose au joueur de prendre un indice
            }*/
            WorldBoxDisc.play(Son.errorEnigma);
        }
    }

    /**
     * méthode appliquant les conséquences d'une énigme
     * @throws IOException
     */
    public void do_consequences() throws IOException { // conséquences liées à la résolution de l'énigme
        for(int i = 0;i<getConsequences().size();i++) {
            switch (getConsequences().get(i)[0]) {
                case 1: // mouvement vers la salle de numéro d'identification consequence[1]
                    Game.player.move(getConsequences().get(i)[1]);
                    break;
                case 2: // dévérrouillage d'une action de numéro d'identification consequence[1]
                    Game.search_action(getConsequences().get(i)[1]).setAvailable(true);
                    Engine.engine.refreshRoom();
                    break;
                case 3: // vérrouillage d'une action de numéro d'identification consequence[1]
                    Game.search_action(getConsequences().get(i)[1]).setAvailable(false);
                    Engine.engine.refreshRoom();
                    break;
                case 4: // ajout de l'objet de numéro d'identification arg_consequence à l'inventaire
                    Game.player.add_to_inventory((getConsequences().get(i)[1]));
                    break;
                case 5: // suppression de l'objet de numéro d'identification consequence[1] de l'inventaire
                    Game.player.remove_from_inventory(Game.search_item(getConsequences().get(i)[1]).id);
                    break;
                case 6: // utilisation de l'objet de numéro d'identification consequence[1]
                    Game.search_item(getConsequences().get(i)[1]).use_item();
                    break;
                case 7: // affichage d'un nouveau texte consequence[i][1] dans la salle consequence[i][2]
                    Game.search_room(getConsequences().get(i)[2]).text_evolve(Game.search_text(getConsequences().get(i)[1]));
                    Engine.engine.refreshRoom();
                    break;
                case 8: // rend une salle inaccessible
                    Game.search_room(getConsequences().get(i)[1]).setAccess(false);
                    Engine.engine.refreshRoom();
                    break;
                case 9: // rend une salle accessible
                    Game.search_room(getConsequences().get(i)[1]).setAccess(true);
                    Engine.engine.refreshRoom();
                    break;
                case 10: // affiche écran fin de partie
                    LoadMap gl = new LoadMap();
                    gl.display_screen_from_id(LoadMap.END_GAME);
                    WorldBoxDisc.play(Son.finEnigme);
                    break;
                case 11: // faire évoluer texte affiché par une action, consequence[i][1] correspond à l'action à modifier, consequence[i][2] correspond à l'id du nouveau texte
                    for (int j = 0; j < Game.search_action(getConsequences().get(i)[1]).consequences.size(); j++) {
                        if (Game.search_action(getConsequences().get(i)[1]).consequences.get(j)[0] == 7) { //cherche la conséquence écrivant du texte, on part du principe qu'il ne peut y en avoir qu'une par action
                            Game.search_action(getConsequences().get(i)[1]).consequences.get(j)[1] = getConsequences().get(i)[2];
                        }
                    }
                    break;
                case 12: // changer image de la salle consequence[i][1] par l'image d'url "pictures/" + id_room + "/" + consequence[i][2], cela implique une normalisation du nom des images
                    Game.search_room(getConsequences().get(i)[1]).setPath_image("pictures/" + getConsequences().get(i)[1] + "/" + getConsequences().get(i)[2] +".png");
                    Engine.engine.refreshPicture();
                    break;
                case 13: //jouer plusieurs sons les uns après les autres
                    ArrayList<String> sounds_playlist = new ArrayList<>();
                    for (int j = 1; j < getConsequences().get(i).length; j++) {
                        sounds_playlist.add(Game.search_sounds(String.valueOf(getConsequences().get(i)[j])));
                    }
                    PlayList playlist = new PlayList(sounds_playlist);
                    playlist.start();
                    break;
                case 14: //jouer plusieurs sons les uns après les autres avec un délai entre chaque
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
            }
        }
    }

    //Méthodes spécifiques aux énigmes cliquables

    public void check_click(double x, double y) throws IOException {
        boolean found = false;
        int i = 0;
        if(resolved == false) { //Si l'énigme n'est pas résolue, sinon un clic ne doit pas avoir d'effet
            while (i < click_zones.size() && !found) { //parcourir liste des zones cliquable
                //vérifier si le clic est dans une zone cliquable
                if (click_zones.get(i)[1] < x && x < click_zones.get(i)[2] && click_zones.get(i)[3] < y && y < click_zones.get(i)[4]) { //On est dans une zone cliqualbe
                    found = true;
                    //envoyer vers le gestionnaire voulu
                    if (gest == 1) {
                        gest_1((int) click_zones.get(i)[0]);
                    } else if (gest == 2) {
                        gest_2((int) click_zones.get(i)[0]);
                    } else if (gest == 3) {
                        gest_3((int) click_zones.get(i)[0]);
                    }
                }
                i++;
            }
        }
    }

    /**
     * première méthode permettant de gérer le comportement des énigmes cliquables
     * elle permet de créer des énigmes où ils faut cliquer sur 2 éléments pour les faire changer de place
     * @param id_zone id de la zone cliquée
     */
    public void gest_1(int id_zone) throws IOException {
        String sol = "";
        String picture;
        String sol_prec = "";
        int pos_id1 = 0;
        int pos_id2 = 0;
        int id_temp;
        if(clicks_memory.size()==0){ //Si premier clic, on mémorise
            clicks_memory.add(id_zone);
        }else if(clicks_memory.size()==1){ //Si deuxième clic, on doit procéder à l'échange

            //Mémoriser l'ordre actuel des zones
            for(int i = 0; i<click_zones.size(); i++) {
                sol_prec = sol_prec + (int)click_zones.get(i)[0];
            }

            //Échanger les deux zones
            for(int j = 0; j<click_zones.size(); j++) {
                if(click_zones.get(j)[0]==id_zone){
                    pos_id1 = j;
                }
                if(click_zones.get(j)[0]==clicks_memory.get(0)){
                    pos_id2 = j;
                }
            }
            id_temp = (int)click_zones.get(pos_id1)[0];
            click_zones.get(pos_id1)[0] = click_zones.get(pos_id2)[0];
            click_zones.get(pos_id2)[0] = id_temp;

            //Nettoyer la mémoire des clics
            clicks_memory.clear();

            //Récupérer la solution proposée
            for(int k = 0; k<click_zones.size(); k++) {
                sol = sol + (int)click_zones.get(k)[0];
            }

            //Si nouvel ordre différent de l'ordre précédent (i.e : on n'a pas cliqué de fois sur la même case), mis à jour de l'image
            if(!(sol.equals(sol_prec))) {
                picture = "pictures/" + this.id + "/" + sol + ".png";
                Game.search_room(Game.player.getPosition()).setPath_image(picture);
                Engine.engine.refreshPicture();
            }else { //Sinon (on a cliqué deux fois sur la même zone)
                WorldBoxDisc.play(Son.errorEnigma);
            }

            //Vérifier si la solution au puzzle est la bonne
            check_solution_clickable(sol);

        }else{ //Normalement inutile, sert si clicks_memory n'a pas était vidé. Ainsi, pas bloquant
            clicks_memory.clear();
        }

    }


    /**
     * deuxième méthode permettant de gérer le comportement des énigmes cliquables
     * elle permet de créer des énigmes où ils faut cliquer sur des éléments de l'image dans l'ordre
     * @param id_zone id de la zone cliquée
     */
    public void gest_2(int id_zone) throws IOException {
        String sol = "";

        //Ajoute le click fait à la mémoire
        clicks_memory.add(id_zone);

        //Joue un son pour que le joueur comprenne que son clic est valid
        WorldBoxDisc.play(Son.oneKnock);

        //Récupère la solution composé par la suite de clic
        for(int i = 0; i<clicks_memory.size(); i++) {
            sol = sol + clicks_memory.get(i);
        }

        //Si assez de clics ont été faits, on vérifie si c'est la bonne solution
        if(sol.length() == getSolution().length()){
            check_solution_clickable(sol);
            clicks_memory.clear(); //Nettoie la mémoire pour permettre de retenter ensuite
        }

    }


    /**
     * troisième méthode permettant de gérer le comportement des énigmes cliquables
     * elle est réservée à la gestion du PC interactif présent dans la bibliothèque
     * @param id_zone id de la zone cliquée
     */
    public void gest_3(int id_zone) throws IOException {

        switch (id_zone){
            case 1: //Icône 1 du bureau
                Game.search_action(2063).getConsequences().clear();
                Game.search_action(2063).getConsequences().add(new int[]{1,2062});
                Game.search_action(2063).do_consequences();
                break;
            case 2:
                Game.search_action(2063).getConsequences().clear();
                Game.search_action(2063).getConsequences().add(new int[]{1,2063});
                Game.search_action(2063).do_consequences();
                break;
            case 3:
                Game.search_action(2063).getConsequences().clear();
                Game.search_action(2063).getConsequences().add(new int[]{1,2065});
                Game.search_action(2063).do_consequences();
                break;
            case 4:
                Game.search_action(2063).getConsequences().clear();
                Game.search_action(2063).getConsequences().add(new int[]{1,(Game.getPlayer().getPosition())-1});
                Game.search_action(2063).do_consequences();
                break;
            case 5:
                Game.search_action(2063).getConsequences().clear();
                Game.search_action(2063).getConsequences().add(new int[]{1,(Game.getPlayer().getPosition())+1});
                Game.search_action(2063).do_consequences();
                break;
            case 6:
                Game.search_action(2063).getConsequences().clear();
                Game.search_action(2063).getConsequences().add(new int[]{1,206});
                Game.search_action(2063).do_consequences();
                break;
        }
    }

    public void check_solution_clickable(String sol) throws IOException {
        if (getSolution().equals(sol)){
            this.do_consequences();
            WorldBoxDisc.play(Son.bonusTime);
            resolved = true;
        } else if(gest !=1){
            WorldBoxDisc.play(Son.errorEnigma);
        }
    }

}
