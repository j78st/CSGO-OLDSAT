package Interface.ViewController;

import Interface.ScreenLoader.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
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

    }

    @FXML
    void go_left(ActionEvent event) {

    }

    @FXML
    void go_right(ActionEvent event) {

    }

    @FXML
    void go_up(ActionEvent event) {

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
        UnsaveAlert alert = new UnsaveAlert();
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        alert.homeScreen(stage);
    }

    /**
     * ferme l'application. Propose une sauvegarde de la partie en cours
     * @param event
     */
    @FXML
    void exit_app(ActionEvent event) throws InterruptedException {
        UnsaveAlert alert = new UnsaveAlert();
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        alert.exitGame(stage);
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
    }

    @Override
    public void setShortcut() {
        // Ouverture/fermeture menu pause via ESC
        KeyCombination kc = new KeyCodeCombination(KeyCode.ESCAPE, KeyCombination.SHIFT_ANY);
        Runnable rn = ()-> {
            if (!gamePaused) {
                pause_game(new ActionEvent());
                gamePaused = true;
            } else {
                resume_game(new ActionEvent());
                gamePaused = false;
            }
        };
        pause_btn.getScene().getAccelerators().put(kc, rn);;
    }
}
