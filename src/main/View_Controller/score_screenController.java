package View_Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class score_screenController {

    // ==========================================================
    // Objets FXML
    // ==========================================================

    @FXML
    private ListView<?> score_list;

    // ==========================================================
    // Methodes FXML
    // ==========================================================

    /**
     * affiche l'ecran d'accueil de l'application
     * @param event
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

    // ==========================================================
    // Methodes autres
    // ==========================================================

    /**
     * initialise la vue lors de l'appel
     */
    public void init () {

    }

}
