package Interface.ViewController;


import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;

public class settings_menuController implements Controller {

    // ==========================================================
    // Declaration objets
    // ==========================================================

    int previous_screen_ID;

    @FXML
    private Button save_btn;

    @FXML
    private Button resume_btn;

    // ==========================================================
    // Methodes gestion logiciel
    // ==========================================================

    /**
     * Permet de revenir à l'écran d'où a été affiché le menu.
     * @param event
     * @throws IOException
     */
    @FXML
    void go_back_to_previous_screen(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        gl.display_screen_from_id(previous_screen_ID,stage);
    }

    /**
     * Sauvegarde les paramètres enregistrés lors de l'appui sur le bouton
     * @param event
     */
    @FXML
    void save_settings(ActionEvent event) {

    }

    // ==========================================================
    // Methodes d'initialisation
    // ==========================================================

    /**
     * Méthode appllée lors du chargement du menu paramètre
     * Elle permet de récuperer le numéro de la scnène précédente pour y revenir lors de la fermeture du menu.
     * @param previous_ID
     */
    public void provide_current_screen_id(int previous_ID) {
        previous_screen_ID = previous_ID;
    }

    /**
     * Initalise la scène lors de son chargement
     */
    @Override
    public void initialize() {
        // rien a init
    }

    /**
     * Définition et intégration des raccourcis possibles sur la scene
     */
    @Override
    public void setShortcut() {
        // Fermeture paramètre via ESC
        KeyCombination kc = new KeyCodeCombination(KeyCode.ESCAPE, KeyCombination.SHIFT_ANY);
        Runnable rn = ()-> {resume_btn.fire();};
        save_btn.getScene().getAccelerators().put(kc, rn);
    }
}
