package Interface.ViewController;

import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class game_launcherController implements Controller, Initializable {

    // ==========================================================
    // Objets FXML
    // ==========================================================

    @FXML
    private Button settings_btn;

    // ==========================================================
    // Methodes FXML
    // ==========================================================

    /**
     * Affiche le menu d'accueil de l'application
     * @param event
     * @throws IOException
     */
    @FXML
    void go_back_to_home_screen(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        gl.display_screen_from_id(1,stage);
    }

    /**
     * Affiche le formulaire de creation d'une partie
     * @param event
     */
    @FXML
    void display_new_game_form(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        gl.display_screen_from_id(4,stage);
    }

    /**
     * Affiche l'ecran de chargement des sauvegardes existantes
     * @param event
     */
    @FXML
    void display_save_loader(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        gl.display_screen_from_id(6,stage);
    }

    /**
     * Affiche le menu des paramètres
     * @param event
     */
    @FXML
    void display_settings_screen(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        gl.display_screen_from_id(4,stage);
    }

    // ==========================================================
    // Methodes autres
    // ==========================================================

    /**
     * initialise la vue lors de l'appel
     */
    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        Image settings_icon = new Image("pictures/settings_icon.png");
        ImageView settingsIconView = new ImageView(settings_icon);
        settings_btn.setGraphic(settingsIconView);
    }
}
