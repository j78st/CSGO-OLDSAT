package Interface.ViewController;

import Interface.ScreenLoader.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class gameController implements Controller, Initializable {

    // ==========================================================
    // Déclaration des objets
    // ==========================================================

    @FXML
    private AnchorPane story_pane;
    @FXML
    private Button item_slot_1;
    @FXML
    private Button item_slot_2;
    @FXML
    private Button item_slot_3;
    @FXML
    private AnchorPane picture_pane;
    @FXML
    private Label timer_lbl;
    @FXML
    private Button left_move_btn;
    @FXML
    private Button up_move_btn;
    @FXML
    private Button down_move_btn;
    @FXML
    private Button right_move_btn;
    @FXML
    private ComboBox<?> action_list;

    // ==========================================================
    // Methodes FXML
    // ==========================================================

    /**
     * Déplace le joueur dans la salle au sud quand c'est possible
     * @param event
     */
    @FXML
    void go_down(ActionEvent event) {

    }

    /**
     * Déplace le joueur dans la salle à l'ouest quand c'est possible
     * @param event
     */
    @FXML
    void go_left(ActionEvent event) {

    }

    /**
     * Déplace le joueur dans la salle à l'est quand c'est possible
     * @param event
     */
    @FXML
    void go_right(ActionEvent event) {

    }

    /**
     * Déplace le joueur dans la salle au nord quand c'est possible
     * @param event
     */
    @FXML
    void go_up(ActionEvent event) {

    }

    /**
     * Met le jeu en suspend et affiche le menu de pause
     * @param event
     */
    @FXML
    void pause_game(ActionEvent event) {

    }

    // ==========================================================
    // Methodes autres
    // ==========================================================

    /**
     * Permet d'initialiser la scene "gameView" lorsqu'elle doit s'afficher
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
