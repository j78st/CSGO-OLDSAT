package Interface.ViewController;

import Interface.Save.SaveListCell;
import Interface.Save.SaveSlot;
import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class load_saveController implements Controller, Initializable {

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
        gl.display_screen_from_id(3,stage);
    }

    /**
     * affiche le menu des paramètres
     * @param event
     */
    @FXML
    void go_to_settings_menu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("settings_menuView.fxml"));

        Parent homeParent = loader.load();
        Scene home_screen = new Scene(homeParent);

        settings_menuController controller = (settings_menuController)loader.getController();
        controller.init(4); // ID de l'écran d'où on appelle les paramètres

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("OLD'SAT");
        stage.setScene(home_screen);
        stage.show();
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
    public void initialize(URL url, ResourceBundle resourceBundle) {
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

}