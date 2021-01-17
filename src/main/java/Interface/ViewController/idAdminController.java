package Interface.ViewController;

import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Settings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

import java.io.IOException;

public class idAdminController implements Controller {

    // ==========================================================
    // Déclaration des objets
    // ==========================================================
    private final String MDP = "GL2021";

    @FXML
    private ImageView lock_icon;

    @FXML
    private TextField password;

    @FXML
    private Label error_msg;

    @FXML
    private Button return_btn;

    // ==========================================================
    // Méthodes FXML
    // ==========================================================
    @FXML
    void test_password(ActionEvent event) throws IOException {
        error_msg.setVisible(false);

        if (MDP.equals(password.getText())) {
            LoadMap gl = new LoadMap();
            gl.display_screen_from_id(LoadMap.ADMIN);
        } else {
            error_msg.setVisible(true);
        }
    }

    @FXML
    void go_back(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(LoadMap.HOME);
    }

    // ==========================================================
    // Méthodes d'initialisation
    // ==========================================================
    @Override
    public void initialize() {
        return_btn.setGraphic(new ImageView(new Image("icons/"+ Settings.icon_color +"/return.png")));
        lock_icon.setImage(new Image("icons/"+ Settings.icon_color +"/lock.png"));
        error_msg.setVisible(false);
        error_msg.setStyle("-fx-text-fill: red; -fx-font-size:"+ Settings.fontSize +"px; -fx-font-style: italic;");
    }

    @Override
    public void setShortcut() {
        KeyCombination kc = new KeyCodeCombination(KeyCode.ENTER, KeyCombination.SHIFT_ANY);
        Runnable rn = ()-> {
            try {
                test_password(new ActionEvent());
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        LoadMap.scene.getAccelerators().put(kc, rn);
    }

    @Override
    public void apply_settings() {
        for (Node n: LoadMap.scene.getRoot().lookupAll(".Custom_label")) {
            n.setStyle("-fx-font-size: " + Settings.fontSize + "px;");
        }
    }
}
