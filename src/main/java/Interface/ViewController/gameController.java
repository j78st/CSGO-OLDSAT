package Interface.ViewController;

import Interface.ScreenLoader.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

public class gameController implements Controller, Initializable {

    // ==========================================================
    // Objets FXML
    // ==========================================================
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

    // gestion menu pause ---------------------------------------
    @FXML
    private Button pause_btn;

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
    void keep_playing(ActionEvent event) {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // masquage du menu pause et desactivation des boutons
        background_menu.toBack();
        vbox_menu.toBack();
    }
}
