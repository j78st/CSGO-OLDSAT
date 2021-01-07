package Interface.ViewController;

import Interface.CellRenderer.ActionListCell;
import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Engine;
import Interface.Settings.Settings;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import Partie.Action;
import Partie.Game;
import Partie.Item;
import Timer.TimerController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
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
    private BorderPane picture_pane;

    @FXML
    private AnchorPane answerBox;

    private Text narration = new Text();

    @FXML
    private ScrollPane scroller;

    @FXML
    private Region reference;

    // inventaire -----------------------------------------------
    @FXML
    private Button item_slot_1;

    @FXML
    private Button item_slot_2;

    @FXML
    private Button item_slot_3;

    @FXML
    private AnchorPane item_description;

    @FXML
    private Label description_label;

    // affichage timer ------------------------------------------
    @FXML
    public Label timer_lbl;

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

    @FXML
    private GridPane map;

    // ==========================================================
    // Methodes liées au déroulement du jeu
    // ==========================================================

    /**
     * Lors de l'appui sur le bouton ALLER EN BAS
     * @param event ev
     */
    @FXML
    void go_down(ActionEvent event) {
        Game.player.move(Game.search_room(Game.player.getPosition()).getNeighbours()[2]);
    }

    /**
     * Lors de l'appui sur le bouton ALLER A GAUCHE
     * @param event ev
     */
    @FXML
    void go_left(ActionEvent event) {
        Game.player.move(Game.search_room(Game.player.getPosition()).getNeighbours()[3]);
    }

    /**
     * Lors de l'appui sur le bouton ALLER A DROITE
     * @param event ev
     */
    @FXML
    void go_right(ActionEvent event) {
        Game.player.move(Game.search_room(Game.player.getPosition()).getNeighbours()[1]);;
    }

    /**
     * Lors de l'appui sur le bouton ALLER EN HAUT
     * @param event ev
     */
    @FXML
    void go_up(ActionEvent event) {
        Game.player.move(Game.search_room(Game.player.getPosition()).getNeighbours()[0]);
    }

    /**
     * Lors de l'appui sur le bouton VALIDER ACTION
     * Execute l'action selectionnée
     * @param event ev
     */
    @FXML
    void do_selected_action(ActionEvent event) throws IOException {
        action_list.getSelectionModel().getSelectedItem().do_consequences();
    }

    /**
     * Lors de l'appui sur le bouton VALIDER
     * Vérifie la réponse donnée par le joueur à une énigme
     * @param event ev
     */
    @FXML
    void check_answer(ActionEvent event) throws IOException {
        int ans = Integer.parseInt(answer_prompt.getText());
        Game.search_enigma(Game.player.getPosition()).check_solution(ans);
    }

    /**
     * Lors de l'appui sur le bouton ECHAPE/PAUSE
     * Mets en pause la partie en cours et affiche le menu de pause
     * @param event ev
     */
    @FXML
    void pause_game(ActionEvent event) {
        // démasquage du menu pause et activation des boutons
        background_menu.toFront();
        vbox_menu.toFront();

        // suspension du timer et récuération du temps restant
        Engine.chrono.toogleTimer();
        timer_pause.setText(Engine.chrono.getRemainingTime());

    }

    /**
     * Affiche la description de l'objet survolé avec la souris
     * @param event ev
     */
    @FXML
    void show_description(MouseEvent event) throws InterruptedException {
        ArrayList<Integer> id_objects = Game.player.getInventory();
        ArrayList<Item> objects = new ArrayList<>();
        for(int i =0;i<id_objects.size();i++){
            objects.add(Game.search_item(id_objects.get(i)));
        }

        if (item_slot_1.equals(event.getSource())) {
            if (objects.size()>0){
                description_label.setText(Game.search_item(objects.get(0).getId()).getDescription());
                item_description.setVisible(true);
                description_label.setVisible(true);
            }
        } else if (item_slot_2.equals(event.getSource())) {
            if (objects.size()>1){
                description_label.setText(Game.search_item(objects.get(1).getId()).getDescription());
                item_description.setVisible(true);
                description_label.setVisible(true);
            }
        } else if (item_slot_3.equals(event.getSource())) {
            if (objects.size()>2){
                description_label.setText(Game.search_item(objects.get(2).getId()).getDescription());
                item_description.setVisible(true);
                description_label.setVisible(true);
            }
        }

    }

    /**
     * Cache la description de lorsque l'objet n'est plus survolé
     * @param event ev
     */
    @FXML
    void hide_description(MouseEvent event) {
        item_description.setVisible(false);
        description_label.setVisible(false);
    }

    // ==========================================================
    // Methodes liées au menu pause
    // ==========================================================

    /**
     * Lors de l'appui sur le bouton REPRENDRE
     * enlève le menu pause et relance la partie
     * @param event ev
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
     * @param event ev
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
     * @param event ev
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
     * @param event ev
     */
    @FXML
    void exit_app(ActionEvent event) throws InterruptedException, IOException {
        UnsaveAlert alert = new UnsaveAlert();
        alert.exitGame();
    }

    // ==========================================================
    // Methodes de rafraichissement des éléments visuels
    // ==========================================================

    /**
     * Rafraichit l'ensemble de la salle
     */
    public void refreshRoom(){
        // refresh des mouvements
        refreshMoveButton();
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
        ArrayList<Integer> id_list = Game.search_room(Game.player.getPosition()).getId_actions();
        ArrayList<Action> list = new ArrayList<>();
        for(int i = 0; i< id_list.size(); i++){
            list.add(Game.search_action(id_list.get(i)));
        }
        actionObservableList = FXCollections.observableArrayList();
        for (int i = 0; i<list.size(); i++) {
            if (list.get(i).isAvailable()) {
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
        String URL = Game.search_room(Game.player.getPosition()).getPath_image();
        Background bg = new Background(new BackgroundImage(
                new Image(URL,true),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false)));
        picture_pane.setBackground(bg);
    }

    /**
     * Rafraichit le texte à afficher
     */
    public void refreshText(){
        String room_text = Game.search_text(Game.search_room(Game.player.getPosition()).getId_text());
        narration.setText(room_text);
        scroller.setContent(narration);
    }

    /**
     * Rafraiciht l'affichage de l'inventaire de l'inventaire
     */
    public void refreshInventory() {
        ArrayList<Integer> id_objects = Game.player.getInventory();
        ArrayList<Item> objects = new ArrayList<>();
        for(int i = 0; i< id_objects.size(); i++){
            objects.add(Game.search_item(id_objects.get(i)));
        }
        if (objects.size()>0){
            item_slot_1.setGraphic(new ImageView(new Image(objects.get(0).getPath_image())));
        } else {
            item_slot_1.setGraphic(new ImageView(new Image("icons/"+Settings.icon_color+"/bag.png")));
        }
        if (objects.size()>1){
            item_slot_2.setGraphic(new ImageView(new Image(objects.get(1).getPath_image())));
        } else {
            item_slot_2.setGraphic(new ImageView(new Image("/icons/"+Settings.icon_color+"/bag.png")));
        }
        if (objects.size()>2){
            item_slot_3.setGraphic(new ImageView(new Image(objects.get(2).getPath_image())));
        } else {
            item_slot_3.setGraphic(new ImageView(new Image("/icons/"+Settings.icon_color+"/bag.png")));
        }
    }

    /**
     * Actualise la disponibilité des boutons de mouvement
     */
    public void refreshMoveButton () {
        if(Game.search_room(Game.search_room(Game.player.getPosition()).getNeighbours()[0]) == null
                || !Game.search_room(Game.search_room(Game.player.getPosition()).getNeighbours()[0]).isAccess()){
            up_move_btn.setDisable(true);
        } else {
            up_move_btn.setDisable(false);
        }
        if(Game.search_room(Game.search_room(Game.player.getPosition()).getNeighbours()[1]) == null
                || !Game.search_room(Game.search_room(Game.player.getPosition()).getNeighbours()[1]).isAccess()){
            right_move_btn.setDisable(true);
        } else {
            right_move_btn.setDisable(false);
        }
        if(Game.search_room(Game.search_room(Game.player.getPosition()).getNeighbours()[2]) == null
                || !Game.search_room(Game.search_room(Game.player.getPosition()).getNeighbours()[2]).isAccess()){
            down_move_btn.setDisable(true);
        } else {
            down_move_btn.setDisable(false);
        }
        if(Game.search_room(Game.search_room(Game.player.getPosition()).getNeighbours()[3]) == null
                || !Game.search_room(Game.search_room(Game.player.getPosition()).getNeighbours()[3]).isAccess()){
            left_move_btn.setDisable(true);
        } else {
            left_move_btn.setDisable(false);
        }
    }

    /**
     * Affiche une boite de réponse pour répondre à une enigme
     * @param visible Boite de dialogue visible ou non
     */
    public void answer_box_visible(boolean visible) {
        if (visible) {
            answerBox.toFront();
        } else {
            answerBox.toBack();
        }
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

        // masquage par defaut de la description des objets
        item_description.setVisible(false);
        description_label.setVisible(false);

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
        narration.wrappingWidthProperty().bind(reference.widthProperty());
        narration.getStyleClass().add("Custom_label");
        if (Settings.icon_color.equals("white")){
            narration.setStyle("-fx-fill: white; -fx-font-size: " + Settings.fontSize + "px;");
        } else {
            narration.setStyle("-fx-fill: black; -fx-font-size: " + Settings.fontSize + "px;");
        }

        // Mise en place des textes de description d'item
        description_label.setWrapText(true);

        // Mise en place scroller
        scroller.setFitToWidth(true);
        scroller.setContent(narration);

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
        Runnable va = ()-> {
            try {
                do_selected_action(new ActionEvent());
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        LoadMap.scene.getAccelerators().put(valid_action, va);
    }

    /**
     * Application des paramètres enregistrés de l'application sur l'écran
     */
    @Override
    public void apply_settings() {
        for (Node n: LoadMap.scene.getRoot().lookupAll(".Custom_label")) {
            if (Settings.icon_color.equals("white")){
                narration.setStyle("-fx-fill: white; -fx-font-size: " + Settings.fontSize + "px;");
            } else {
                narration.setStyle("-fx-fill: black; -fx-font-size: " + Settings.fontSize + "px;");
            }
        }
    }

}
