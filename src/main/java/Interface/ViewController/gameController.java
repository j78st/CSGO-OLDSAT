package Interface.ViewController;

import Interface.CellRenderer.ActionListCell;
import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Settings;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import Partie.Action;
import Partie.Game;
import Partie.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

public class gameController implements Controller {

    // ==========================================================
    // Déclaration objets
    // ==========================================================

    public static Game game;
    private ObservableList<Action> actionObservableList;
    private boolean gamePaused = false;

    // zones de l'écran -----------------------------------------
    @FXML
    private AnchorPane story_pane;

    @FXML
    private AnchorPane picture_pane;

    @FXML
    private AnchorPane answerBox;

    @FXML
    private ImageView illustration;

    @FXML
    private Label narration;

    // inventaire -----------------------------------------------
    @FXML
    private Button item_slot_1;

    @FXML
    private Button item_slot_2;

    @FXML
    private Button item_slot_3;

    // affichage timer ------------------------------------------
    @FXML
    private Label timer_lbl;

    // déplacement ----------------------------------------------
    @FXML
    private Button left_move_btn;

    @FXML
    private Button up_move_btn;

    @FXML
    private Button down_move_btn;

    @FXML
    private Button right_move_btn;

    // affichage actions posibles -------------------------------
    @FXML
    private ListView<Action> action_list;

    @FXML
    private Button pause_btn;

    @FXML
    private TextField answer_prompt;

    // gestion menu pause ---------------------------------------
    @FXML
    private Button resume_btn;

    @FXML
    private AnchorPane background_menu;

    @FXML
    private BorderPane vbox_menu;

    @FXML
    private Text timer_pause;

    // ==========================================================
    // Methodes liées au déroulement du jeu
    // ==========================================================

    /**
     * Lors de l'appui sur le bouton ALLER EN BAS
     * @param event
     */
    @FXML
    void go_down(ActionEvent event) {
        game.player.move(Game.search_room(game.player.position).getNeighbours()[2]);
    }

    /**
     * Lors de l'appui sur le bouton ALLER A GAUCHE
     * @param event
     */
    @FXML
    void go_left(ActionEvent event) {
        game.player.move(Game.search_room(game.player.position).getNeighbours()[3]);
    }

    /**
     * Lors de l'appui sur le bouton ALLER A DROITE
     * @param event
     */
    @FXML
    void go_right(ActionEvent event) {
        game.player.move(Game.search_room(game.player.position).getNeighbours()[1]);;
    }

    /**
     * Lors de l'appui sur le bouton ALLER EN HAUT
     * @param event
     */
    @FXML
    void go_up(ActionEvent event) {
        game.player.move(Game.search_room(game.player.position).getNeighbours()[0]);
    }

    /**
     * Lors de l'appui sur le bouton VALIDER ACTION
     * Execute l'action selectionnée
     * @param event
     */
    @FXML
    void do_selected_action(ActionEvent event) {
        action_list.getSelectionModel().getSelectedItem().Consequence();
    }

    /**
     * Lors de l'appui sur le bouton VALIDER
     * Vérifie la réponse donnée par le joueur à une énigme
     * @param event
     */
    @FXML
    void check_answer(ActionEvent event) throws IOException {

        int ans = Integer.parseInt(answer_prompt.getText());
        Game.search_enigma(Game.player.position).check_solution(ans);

    }

    /**
     * Lors de l'appui sur le bouton ECHAPE/PAUSE
     * Mets en pause la partie en cours et affiche le menu de pause
     * @param event
     */
    @FXML
    void pause_game(ActionEvent event) {
        // démasquage du menu pause et activation des boutons
        background_menu.toFront();
        vbox_menu.toFront();

        // ---- vvv suspendre timer vvv -----

    }

    // ==========================================================
    // Methodes liées au menu pause
    // ==========================================================

    /**
     * Lors de l'appui sur le bouton REPRENDRE
     * enlève le menu pause et relance la partie
     * @param event
     */
    @FXML
    void resume_game(ActionEvent event) {

        // masquage du menu pause et desactivation des boutons
        background_menu.toBack();
        vbox_menu.toBack();

        // ---- vvv reprise timer vvv -----


    }

    /**
     * Lors de l'appui sur le bouton PARAMETRES
     * sauvegarde la partie en cours dans l'emplacement attribué
     * @param event
     */
    @FXML
    void display_settings_menu(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        gl.display_settings_menu(LoadMap.GAME);
        WorldBoxDisc.play(Son.menuOpen);
    }

    /**
     * Lors de l'appui sur le bouton REVENIR A L'ACCUEIL
     * quitte la partie et revient au menu d'accueil. Propose une sauvegarde de la partiie en cours
     * @param event
     */
    @FXML
    void go_to_home_screen(ActionEvent event) throws InterruptedException, IOException {
        // Message d'alerte sur la sauvegarde
        UnsaveAlert alert = new UnsaveAlert();
        alert.homeScreen();
    }

    /**
     * Lors de l'appui sur le bouton QUITTER L'APPLICATION
     * ferme l'application. Propose une sauvegarde de la partie en cours
     * @param event
     */
    @FXML
    void exit_app(ActionEvent event) throws InterruptedException, IOException {
        UnsaveAlert alert = new UnsaveAlert();
        alert.exitGame();
    }

    // ==========================================================
    // Methodes d'initialisation
    // ==========================================================

    /**
     * initialisation dela scene avant affichage lors du chargement
     */
    public void initialize () {
        // masquage du menu pause et desactivation des boutons
        background_menu.toBack();
        vbox_menu.toBack();

        // icone d'inventaire
        Image bag_icon = new Image("icons/"+ Settings.icon_color +"/bag.png");
        item_slot_1.setGraphic(new ImageView(bag_icon));
        item_slot_2.setGraphic(new ImageView(bag_icon));
        item_slot_3.setGraphic(new ImageView(bag_icon));

        //icone mouvement
        down_move_btn.setGraphic(new ImageView(new Image("/icons/"+ Settings.icon_color +"/arrow_down.png")));
        left_move_btn.setGraphic(new ImageView(new Image("/icons/"+ Settings.icon_color +"/arrow_left.png")));
        up_move_btn.setGraphic(new ImageView(new Image("/icons/"+ Settings.icon_color +"/arrow_up.png")));
        right_move_btn.setGraphic(new ImageView(new Image("/icons/"+ Settings.icon_color +"/arrow_right.png")));

        // Mise en place du texte narratif
        narration.setWrapText(true);
        if (Settings.icon_color.equals("white")){
            narration.setStyle("-fx-text-fill: white;");
        } else {
            narration.setStyle("-fx-text-fill: black;");
        }
    }

    /**
     * Création des raccourcis
     */
    @Override
    public void setShortcut() {
        refreshInventory();

        // Clear shortcut
        LoadMap.scene.getAccelerators().clear();

        // Ouverture/fermeture menu pause via ESC
        KeyCombination esc = new KeyCodeCombination(KeyCode.ESCAPE);
        Runnable rn = ()-> {
            if (!gamePaused) {
                pause_game(new ActionEvent());
                gamePaused = true;
            } else {
                resume_game(new ActionEvent());
                gamePaused = false;
            }
        };
        LoadMap.scene.getAccelerators().put(esc, rn);

        // déplacement via flèches directionnelles
        KeyCombination moveUp = new KeyCodeCombination(KeyCode.UP);
        Runnable mu = ()-> { go_up(new ActionEvent()); };

        KeyCombination moveRight = new KeyCodeCombination(KeyCode.RIGHT);
        Runnable mr = ()-> { go_right(new ActionEvent()); };

        KeyCombination moveDown = new KeyCodeCombination(KeyCode.DOWN);
        Runnable md = ()-> { go_down(new ActionEvent()); };

        KeyCombination moveLeft = new KeyCodeCombination(KeyCode.LEFT);
        Runnable ml = ()-> { go_left(new ActionEvent()); };

        LoadMap.scene.getAccelerators().put(moveUp, mu);
        LoadMap.scene.getAccelerators().put(moveRight, mr);
        LoadMap.scene.getAccelerators().put(moveDown, md);
        LoadMap.scene.getAccelerators().put(moveLeft, ml);

        // validation réponse
        KeyCombination valid_answer = new KeyCodeCombination(KeyCode.ENTER);
        Runnable vr = ()-> {
            try {
                check_answer(new ActionEvent());
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        LoadMap.scene.getAccelerators().put(valid_answer, vr);

        // validation exécution action
        KeyCombination valid_action = new KeyCodeCombination(KeyCode.SPACE);
        Runnable va = ()-> { do_selected_action(new ActionEvent()); };

        LoadMap.scene.getAccelerators().put(valid_action, va);
    }

    public void refreshRoom(){

        if(Game.search_room(Game.search_room(game.player.position).getNeighbours()[0]) == null
                || !Game.search_room(Game.search_room(game.player.position).getNeighbours()[0]).isAccess()){
            up_move_btn.setDisable(true);
        } else {
            up_move_btn.setDisable(false);
        }
        if(Game.search_room(Game.search_room(game.player.position).getNeighbours()[1]) == null
                || !Game.search_room(Game.search_room(game.player.position).getNeighbours()[1]).isAccess()){
            right_move_btn.setDisable(true);
        } else {
            right_move_btn.setDisable(false);
        }
        if(Game.search_room(Game.search_room(game.player.position).getNeighbours()[2]) == null
                || !Game.search_room(Game.search_room(game.player.position).getNeighbours()[2]).isAccess()){
            down_move_btn.setDisable(true);
        } else {
            down_move_btn.setDisable(false);
        }
        if(Game.search_room(Game.search_room(game.player.position).getNeighbours()[3]) == null
                || !Game.search_room(Game.search_room(game.player.position).getNeighbours()[3]).isAccess()){
            left_move_btn.setDisable(true);
        } else {
            left_move_btn.setDisable(false);
        }

        // refresh du texte
        refreshText();
        // refresh de l'image
        refreshPicture();
        // refresh des actions
        refreshAction();
        // efface la boite de dialogue
        answer_box_visible(false);
    }

    /**
     * Rafraichit la liste des actions disponibles
     */
    public void refreshAction(){
        // chargement des actions
        ArrayList<Action> list = Game.search_room(game.player.position).getActions();
        actionObservableList = FXCollections.observableArrayList();
        for (int i = 0; i<list.size(); i++) {
            if (list.get(i).getDoable()) {
                actionObservableList.add(list.get(i));
            }
        }
        action_list.setItems(actionObservableList);
        action_list.setCellFactory(param -> new ActionListCell());
    }

    /**
     * Rafraichit l'image associée à la salle
     */
    public void refreshPicture(){
        String URL = Game.search_room(game.player.position).getPath_image();
        illustration.setImage(new Image(URL));
    }

    /**
     * Rafraichit le texte à afficher
     */
    public void refreshText(){
        String room_text = Game.search_room(game.player.position).getTxt();
        narration.setText(room_text);
    }

    public void refreshInventory() {
        ArrayList<Item> objects = game.player.getInventory();
        if (objects.size()>0){
            item_slot_1.setGraphic(new ImageView(new Image(objects.get(0).getURL_image())));
        } else {
            item_slot_1.setGraphic(new ImageView(new Image("icons/"+Settings.icon_color+"/bag.png")));
        }
        if (objects.size()>1){
            item_slot_2.setGraphic(new ImageView(new Image(objects.get(1).getURL_image())));
        } else {
            item_slot_2.setGraphic(new ImageView(new Image("/icons/"+Settings.icon_color+"/bag.png")));
        }
        if (objects.size()>2){
            item_slot_3.setGraphic(new ImageView(new Image(objects.get(2).getURL_image())));
        } else {
            item_slot_3.setGraphic(new ImageView(new Image("/icons/"+Settings.icon_color+"/bag.png")));
        }
    }

    public void answer_box_visible(boolean visible) {
        if (visible) {
            answerBox.toFront();
        } else {
            answerBox.toBack();
        }
    }
}
