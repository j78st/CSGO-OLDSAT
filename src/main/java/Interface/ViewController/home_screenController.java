package Interface.ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import Interface.ScreenLoader.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class home_screenController implements Controller, Initializable {

    int ID = 1;

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
        gl.display_screen_from_id(5,stage);
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
    void display_settings_screen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("settings_menuView.fxml"));

        Parent homeParent = loader.load();
        Scene home_screen = new Scene(homeParent);

        settings_menuController controller = loader.getController();
        controller.init(1); // ID de l'écran ou on appelle les paramètres

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("OLD'SAT");
        stage.setScene(home_screen);
        stage.show();
    }

    // ==========================================================
    // Methodes autres
    // ==========================================================

    /**
     * initialise la scene
     */
    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        Image settings_icon = new Image("pictures/settings_icon.png");
        ImageView settingsIconView = new ImageView(settings_icon);
        settings_btn.setGraphic(settingsIconView);
    }

}

