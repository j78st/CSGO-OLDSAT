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

import java.io.FileNotFoundException;
import java.io.IOException;

public class home_screenController {

    // ==========================================================
    // Methodes FXML
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
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("game_launcherView.fxml"));

        Parent launchParent = loader.load();
        Scene launch_screen = new Scene(launchParent);

        game_launcherController controller = loader.getController();
        controller.init();

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("OLD'SAT");
        stage.setScene(launch_screen);
        stage.show();
    }

    /**
     * affiche l'ecran du mode multijouer
     * @param event
     */
    @FXML
    void display_multiplayer_mode(ActionEvent event) {

    }

    /**
     * affiche l'ecran d'affichage des meilleurs scores
     * @param event
     */
    @FXML
    void display_score_screen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("score_screenView.fxml"));

        Parent scoreParent = loader.load();
        Scene score_screen = new Scene(scoreParent);

        score_screenController controller = loader.getController();
        controller.init();

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("OLD'SAT");
        stage.setScene(score_screen);
        stage.show();
    }

    /**
     * affiche l'ecran des paramètres du jeu
     * @param event
     */
    @FXML
    void display_settings_screen(ActionEvent event) {

    }

    // ==========================================================
    // Methodes autres
    // ==========================================================

    /**
     * initialise la scene
     */
    public void init () throws FileNotFoundException {
        Image settings_icon = new Image("pictures/settings_icon.png");
        ImageView settingsIconView = new ImageView(settings_icon);
        settings_btn.setGraphic(settingsIconView);
    }

}

