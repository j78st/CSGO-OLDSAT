package Interface.ViewController;


import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class settings_menuController implements Controller {

    // ==========================================================
    // Declaration objets
    // ==========================================================

    int previous_screen_ID;

    // ==========================================================
    // Methodes FXML
    // ==========================================================

    @FXML
    void go_back_to_previous_screen(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        gl.display_screen_from_id(previous_screen_ID,stage);
    }

    // ==========================================================
    // Methodes autres
    // ==========================================================

    public void init (int previous_ID) {
        previous_screen_ID = previous_ID;
    }
}
