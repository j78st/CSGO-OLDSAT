package View_Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class game_launcherController {

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
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("home_screenView.fxml"));


        Parent homeParent = loader.load();
        Scene home_screen = new Scene(homeParent);

        home_screenController controller = loader.getController();
        controller.init();

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("OLD'SAT");
        stage.setScene(home_screen);
        stage.show();
    }

    /**
     * Affiche le formulaire de creation d'une partie
     * @param event
     */
    @FXML
    void display_new_game_form(ActionEvent event) {

    }

    /**
     * Affiche l'ecran de chargement des sauvegardes existantes
     * @param event
     */
    @FXML
    void display_save_loader(ActionEvent event) {

    }

    /**
     * Affiche le menu des paramètres
     * @param event
     */
    @FXML
    void display_settings_screen(ActionEvent event) {

    }

    // ==========================================================
    // Methodes autres
    // ==========================================================

    /**
     * initialise la vue lors de l'appel
     */
    public void init () {
        Image settings_icon = new Image("pictures/settings_icon.png");
        ImageView settingsIconView = new ImageView(settings_icon);
        settings_btn.setGraphic(settingsIconView);
    }
}
