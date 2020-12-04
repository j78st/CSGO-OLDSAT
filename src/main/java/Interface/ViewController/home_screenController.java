package Interface.ViewController;

import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    // ==========================================================
    // Methodes FXML
    // ==========================================================

    /**
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
     * affiche l'ecran de lancement de partie
     * @param event
     */
    @FXML
    void display_game_launcher(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        gl.display_screen_from_id(LoadMap.LAUNCHER,stage);
    }

    /**
     * affiche l'ecran du mode multijouer
     * @param event
     */
    @FXML
    void display_multiplayer_mode(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        gl.display_screen_from_id(LoadMap.GAME,stage);
    }

    /**
     * affiche l'ecran d'affichage des meilleurs scores
     * @param event
     */
    @FXML
    void display_score_screen(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        gl.display_screen_from_id(LoadMap.SCORES,stage);
    }

    /**
     * affiche l'ecran des paramètres du jeu
     * @param event
     */
    @FXML
    void display_settings_screen(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        gl.display_settings_menu(LoadMap.HOME,stage);
    }

    // ==========================================================
    // Methodes autres
    // ==========================================================

    /**
     * initialise la scene
     */
    public void initialize () {
        Image settings_icon = new Image("pictures/settings_icon.png");
        ImageView settingsIconView = new ImageView(settings_icon);
        settings_btn.setGraphic(settingsIconView);
    }

    /**
     * Définition et intégration des raccourcis possibles sur la scene
     */
    @Override
    public void setShortcut() {
        // Acces au paramètres via ESC
        KeyCombination kc = new KeyCodeCombination(KeyCode.ESCAPE, KeyCombination.SHIFT_ANY);
        Runnable rn = ()-> settings_btn.fire();
        settings_btn.getScene().getAccelerators().put(kc, rn);;
    }

}

