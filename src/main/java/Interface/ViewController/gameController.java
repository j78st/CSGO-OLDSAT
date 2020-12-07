package Interface.ViewController;

import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class gameController implements Controller {

    // ==========================================================
    // Déclaration objets
    // ==========================================================

    boolean gamePaused = false;

    // zones de l'écran -----------------------------------------
    @FXML
    private AnchorPane story_pane;

    @FXML
    private AnchorPane picture_pane;

    @FXML
    private ImageView illustration;

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
    private ComboBox<?> action_list;

    @FXML
    private Button pause_btn;

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

    @FXML
    void go_down(ActionEvent event) {
        System.out.println("bas");
    }

    @FXML
    void go_left(ActionEvent event) {
        System.out.println("gauche");
    }

    @FXML
    void go_right(ActionEvent event) {
        System.out.println("droite");
    }

    @FXML
    void go_up(ActionEvent event) {
        System.out.println("haut");
    }

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
     * sauvegarde la partie en cours dans l'emplacement attribué
     * @param event
     */
    @FXML
    void save_game(ActionEvent event) {

    }

    /**
     * quitte la partie et revient au menu d'accueil. Propose une sauvegarde de la partiie en cours
     * @param event
     */
    @FXML
    void go_to_home_screen(ActionEvent event) throws InterruptedException, IOException {
        // Message d'alerte sur la sauvegarde
        UnsaveAlert alert = new UnsaveAlert();
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        alert.homeScreen(stage);

        // Redirection vers écran principal
        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(LoadMap.HOME);
    }

    /**
     * ferme l'application. Propose une sauvegarde de la partie en cours
     * @param event
     */
    @FXML
    void exit_app(ActionEvent event) throws InterruptedException {
        UnsaveAlert alert = new UnsaveAlert();
        alert.exitGame();
    }

    // ==========================================================
    // Methodes autres
    // ==========================================================

    /**
     * initialisation dela scene avant affichage lors du chargement
     */
    public void initialize () {
        // masquage du menu pause et desactivation des boutons
        background_menu.toBack();
        vbox_menu.toBack();

        // icone d'inventaire
        Image bag_icon = new Image("pictures/bag.png");
        item_slot_1.setGraphic(new ImageView(bag_icon));
        item_slot_2.setGraphic(new ImageView(bag_icon));
        item_slot_3.setGraphic(new ImageView(bag_icon));

        //icone mouvement
        down_move_btn.setGraphic(new ImageView(new Image("/pictures/arrow_down.png")));
        left_move_btn.setGraphic(new ImageView(new Image("/pictures/arrow_left.png")));
        up_move_btn.setGraphic(new ImageView(new Image("/pictures/arrow_up.png")));
        right_move_btn.setGraphic(new ImageView(new Image("/pictures/arrow_right.png")));

        //image d'illustration
        
    }

    @Override
    public void setShortcut() {
        // Ouverture/fermeture menu pause via ESC
        KeyCombination esc = new KeyCodeCombination(KeyCode.ESCAPE, KeyCombination.SHIFT_ANY);
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

    }
}
