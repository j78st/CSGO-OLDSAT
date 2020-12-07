package Interface.ViewController;

import Interface.Ranking.Record;
import Interface.Ranking.RecordListCell;
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

public class score_screenController implements Controller {

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
    private Button return_btn;

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
        gl.display_screen_from_id(LoadMap.HOME);
    }

    /**
     * Affiche le menu des paramètre depuis la fenetre courante
     * @param event
     * @throws IOException
     */
    @FXML
    void display_settings_screen(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        gl.display_settings_menu(LoadMap.SCORES);
    }

    // ==========================================================
    // Methodes autres
    // ==========================================================

    /**
     * initialise la vue lors de l'appel de la methode @display_screen_from_id
     */
    public void initialize () {
        // icones
        settings_btn.setGraphic(new ImageView(new Image("pictures/settings_icon.png")));
        return_btn.setGraphic(new ImageView(new Image("pictures/return.png")));

        // chargement du classement
        recordObservableList = FXCollections.observableArrayList();

        // vvv /!\ classement de test ici vvv
        for (int i = 0; i<20; i++) {
            recordObservableList.add(new Record(i+1, "pseudo "+i, 100+i));
        }

        score_list.setItems(recordObservableList);
        score_list.setCellFactory(param -> new RecordListCell());
    }

    /**
     * Définition et intégration des raccourcis possibles sur la scene
     */
    @Override
    public void setShortcut() {
        // Acces au paramètres via ESC
        KeyCombination kc = new KeyCodeCombination(KeyCode.ESCAPE, KeyCombination.SHIFT_ANY);
        Runnable rn = ()-> settings_btn.fire();
        LoadMap.scene.getAccelerators().put(kc, rn);
    }
}
