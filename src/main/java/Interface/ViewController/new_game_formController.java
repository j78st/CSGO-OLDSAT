package Interface.ViewController;


import Interface.Save.SaveListCell;
import Interface.Save.SaveSlot;
import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.GenericLoader;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class new_game_formController implements Controller, Initializable {

    private ObservableList<SaveSlot> saveObservableList;

    @FXML
    private TextField name_selector;

    @FXML
    private ComboBox<?> difficulty_selector;

    @FXML
    private ListView<SaveSlot> save_list;

    @FXML
    private Button settings_btn;

    @FXML
    void go_back_to_launch_screen(ActionEvent event) throws IOException {
        GenericLoader gl = new GenericLoader();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        gl.display_screen_from_id(3,stage);
    }
    /*
    @FXML
    void go_to_settings_menu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("settings_menuView.fxml"));

        Parent homeParent = loader.load();
        Scene home_screen = new Scene(homeParent);

        settings_menuController controller = loader.getController();
        controller.init(4); // ID de l'écran d'où on appelle les paramètres

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("OLD'SAT");
        stage.setScene(home_screen);
        stage.show();
    }
    */

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
