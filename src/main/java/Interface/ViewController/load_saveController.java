package Interface.ViewController;

import Interface.Save.SaveListCell;
import Interface.Save.SaveSlot;
import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;

public class load_saveController implements Controller {
    // ==========================================================
    // Déclaration des objets
    // ==========================================================

    private ObservableList<SaveSlot> saveObservableList;

    @FXML
    private ListView<SaveSlot> save_list;

    @FXML
    private Button settings_btn;

    // ==========================================================
    // Méthodes FXML
    // ==========================================================

    /**
     *  affiche l'ecran de lancement de partir
     * @param event
     * @throws IOException
     */
    @FXML
    void go_back_to_launch_screen(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        gl.display_screen_from_id(LoadMap.LAUNCHER,stage);
    }

    /**
     * affiche le menu des paramètres
     * @param event
     */
    @FXML
    void go_to_settings_menu(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        gl.display_settings_menu(LoadMap.LOAD_SAVE,stage);
    }

    /**
     *  relance la partie sélectionnée
     * @param event
     */
    @FXML
    void launch_game(ActionEvent event) {

    }

    // ==========================================================
    // Autre méthodes
    // ==========================================================

    @Override
    public void initialize() {
        // image du bouton paramètre
        Image settings_icon = new Image("pictures/settings_icon.png");
        ImageView settingsIconView = new ImageView(settings_icon);
        settings_btn.setGraphic(settingsIconView);

        // mise en place de la liste des sauvegarde
        saveObservableList = FXCollections.observableArrayList();

        // ======= vvv /!\ LISTE DE SAUVEGARDE TEST vvv =======
        for (int i = 0; i<10; i++) {
            saveObservableList.add(new SaveSlot(i,"pseudo "+i));
        }
        // ====================================================

        save_list.setItems(saveObservableList);
        save_list.setCellFactory(param -> new SaveListCell());
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