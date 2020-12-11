package Interface.ViewController;

import Interface.CellRenderer.RecordListCell;
import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Settings;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import Score.Score;
import Serialization.Memoire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import Score.Ranking;

import java.io.File;
import java.io.IOException;

public class score_screenController implements Controller {

    // ==========================================================
    // Classement et autres objets
    // ==========================================================

    private ObservableList<Score> recordObservableList;

    // ==========================================================
    // Objets FXML
    // ==========================================================

    @FXML
    private Button settings_btn;

    @FXML
    private Button return_btn;

    @FXML
    private ListView<Score> score_list;

    @FXML
    private ImageView rank_icon;

    // ==========================================================
    // Methodes FXML
    // ==========================================================

    /**
     * Lors de l'appui sur le bouton RETOUR
     * affiche l'ecran d'accueil de l'application
     * @param event
     */
    @FXML
    void go_back_to_home_screen(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(LoadMap.HOME);
        WorldBoxDisc.play(Son.menuClose);
    }

    /**
     * Lors de l'appui sur le bouton PARAMETRES
     * Affiche le menu des paramètre depuis la fenetre courante
     * @param event
     * @throws IOException
     */
    @FXML
    void display_settings_screen(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        gl.display_settings_menu(LoadMap.SCORES);
        WorldBoxDisc.play(Son.menuOpen);
    }

    // ==========================================================
    // Methodes autres
    // ==========================================================

    /**
     * initialise de la scene + memoristaion ancien écran
     */
    public void initialize () {
        // icones
        settings_btn.setGraphic(new ImageView(new Image("icons/"+ Settings.icon_color +"/settings_icon.png")));
        return_btn.setGraphic(new ImageView(new Image("icons/"+ Settings.icon_color +"/return.png")));
        rank_icon.setImage(new Image("icons/"+ Settings.icon_color+ "/ranking.png"));


        // Récupération du classement depuis les fichiers
        Ranking ranking = new Ranking();
        Memoire m = new Memoire();
        ranking = (Ranking) m.read_data(new File("resources/json/ranking.json"));

        // affichage du classement
        recordObservableList = FXCollections.observableArrayList();
        for (int i = 0; i<10; i++) {
            recordObservableList.add(ranking.ranking[i]);
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
