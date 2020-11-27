package Interface.ViewController;

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
import Interface.Ranking.Record;
import Interface.Ranking.RecordListCell;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class score_screenController implements Controller, Initializable {

    // ==========================================================
    // Classement et autres objets
    // ==========================================================

    private ObservableList<Record> recordObservableList;

    // ==========================================================
    // Objets FXML
    // ==========================================================

    @FXML
    private Button settings_btn;

    @FXML
    private ListView<Record> score_list;

    // ==========================================================
    // Methodes FXML
    // ==========================================================

    /**
     * affiche l'ecran d'accueil de l'application
     * @param event
     */
    @FXML
    void go_back_to_home_screen(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        gl.display_screen_from_id(1,stage);
    }

    /**
     * Affiche le menu des paramètre depuis la fenetre courante
     * @param event
     * @throws IOException
     */
    @FXML
    void display_settings_screen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("settings_menuView.fxml"));

        Parent homeParent = loader.load();
        Scene home_screen = new Scene(homeParent);

        settings_menuController controller = loader.getController();
        controller.init(2);

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("OLD'SAT");
        stage.setScene(home_screen);
        stage.show();
    }

    // ==========================================================
    // Methodes autres
    // ==========================================================

    /**
     * initialise la vue lors de l'appel de la methode @display_screen_from_id
     */
    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {
        // icone paramètre
        Image settings_icon = new Image("pictures/settings_icon.png");
        ImageView settingsIconView = new ImageView(settings_icon);
        settings_btn.setGraphic(settingsIconView);

        // chargement du classement
        recordObservableList = FXCollections.observableArrayList();

        // vvv /!\ classement de test ici vvv
        for (int i = 0; i<20; i++) {
            recordObservableList.add(new Record(i+1, "pseudo "+i, 100+i));
        }

        score_list.setItems(recordObservableList);
        score_list.setCellFactory(param -> new RecordListCell());
    }

}
