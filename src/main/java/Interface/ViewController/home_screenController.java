package Interface.ViewController;

import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Settings;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;


public class home_screenController implements Controller {

    // ==========================================================
    // Objets FXML
    // ==========================================================

    @FXML
    private Button settings_btn;

    @FXML
    private ImageView game_icon;

    // ==========================================================
    // Methodes FXML
    // ==========================================================

    /**
     * Lors de l'appui sur le bouton QUITTER L'APPLICATION
     * L'appel à cette fonction ferme la fenetre contenant le bouton
     * @param event
     */
    @FXML
    void close_app(ActionEvent event) {

        // close app
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();

    }

    /**
     * Lors de l'appui sur le bouton JOUER
     * affiche l'ecran de lancement de partie
     * @param event
     */
    @FXML
    void display_game_launcher(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(LoadMap.LAUNCHER);
        WorldBoxDisc.play(Son.menuOpen);
    }

    /**
     * Lors de l'appui sur le bouton MULTIJOUEUR
     * affiche l'ecran du mode multijouer
     * @param event
     */
    @FXML
    void display_admin_mode(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(LoadMap.AUTHENTIFICATION);
        WorldBoxDisc.play(Son.menuOpen);
    }

    /**
     * Lors de l'appui sur le bouton SCORES
     * affiche l'ecran d'affichage des meilleurs scores
     * @param event
     */
    @FXML
    void display_score_screen(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(LoadMap.SCORES);
        WorldBoxDisc.play(Son.menuOpen);
    }

    /**
     * Lors de l'appui sur le bouton PARAMETRES
     * affiche l'ecran des paramètres du jeu
     * @param event
     */
    @FXML
    void display_settings_screen(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        gl.display_settings_menu(LoadMap.HOME);
        WorldBoxDisc.play(Son.menuOpen);
    }

    // ==========================================================
    // Methodes d'initialisation
    // ==========================================================

    /**
     * initialise la scene
     */
    public void init () {
        settings_btn.setGraphic(new ImageView(new Image("icons/"+ Settings.icon_color +"/settings_icon.png")));
        game_icon.setImage(new Image("icons/"+ Settings.icon_color +"/arcade.png"));
        //WorldBoxDisc.pauseAllBackgroundSound();
        //WorldBoxDisc.play(Son.menuTheme);
    }

    /**
     * Définition et intégration des raccourcis possibles sur la scene
     */
    @Override
    public void setShortcut() {
        // reset des anciens shortcut
        LoadMap.scene.getAccelerators().clear();

        // Acces au paramètres via ESC
        KeyCombination kc = new KeyCodeCombination(KeyCode.ESCAPE, KeyCombination.SHIFT_ANY);
        Runnable rn = ()-> settings_btn.fire();
        LoadMap.scene.getAccelerators().put(kc, rn);
    }

    // Applique les valeurs enregistrées dans les paramètres aux éléments de la page
    @Override
    public void apply_settings() {
        for (Node n: LoadMap.scene.getRoot().lookupAll(".Custom_label")) {
            n.setStyle("-fx-font-size: " + Settings.fontSize + "px;");
        }
    }

}

