package View_Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class settings_menuView {

    // ==========================================================
    // Declaration objets
    // ==========================================================

    FXMLLoader previous_loader;
    Scene previous_scene;
    Controller previous_controller;

    // ==========================================================
    // Methodes FXML
    // ==========================================================

    @FXML
    void go_back_to_previous_screen(ActionEvent event) throws IOException {

        Parent homeParent = previous_loader.load();
        Scene previous_scene = new Scene(homeParent);


        // /!\ maping de loader ? iddentifiant sur chaque controller ?

        Controller previous_controller = previous_loader.getController();
        //previous_controller.init();

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("OLD'SAT");
        stage.setScene(previous_scene);
        stage.show();
    }

    // ==========================================================
    // Methodes autres
    // ==========================================================

    public void init () {

    }
}
