package Interface.ViewController;

import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Settings;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;

public class game_launcherController implements Controller {

    // ==========================================================
    // Objets FXML
    // ==========================================================

    @FXML
    private Button settings_btn;

    @FXML
    private Button return_btn;

    // ==========================================================
    // Methodes FXML
    // ==========================================================

    /**
     * Lors de l'appui sur le bouton RETOUR
     * Affiche le menu d'accueil de l'application
     * @param event
     * @throws IOException
     */
    @FXML
    void go_back_to_home_screen(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(LoadMap.HOME);
        WorldBoxDisc.play(Son.menuClose);
    }

    /**
     * Lors de l'appui sur le bouton NOUVELLE PARTIE
     * Affiche le formulaire de creation d'une partie
     * @param event
     */
    @FXML
    void display_new_game_form(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(LoadMap.NEW_GAME_FORM);
        WorldBoxDisc.play(Son.menuOpen);
    }

    /**
     * Lors de l'appui sur le bouton CHARGEMENT PARTIE
     * Affiche l'ecran de chargement des sauvegardes existantes
     * @param event
     */
    @FXML
    void display_save_loader(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(LoadMap.LOAD_SAVE);
        WorldBoxDisc.play(Son.menuOpen);
    }

    /**
     * Lors de l'appui sur le bouton PARAMETRES
     * Affiche le menu des paramètres
     * @param event
     */
    @FXML
    void display_settings_screen(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        gl.display_settings_menu(LoadMap.LAUNCHER);
        WorldBoxDisc.play(Son.menuOpen);
    }

    // ==========================================================
    // Methodes autres
    // ==========================================================

    /**
     * Initialise la scène lors de l'appel
     */
    @Override
    public void init () {
        settings_btn.setGraphic(new ImageView(new Image("icons/"+ Settings.icon_color +"/settings_icon.png")));
        return_btn.setGraphic(new ImageView(new Image("icons/"+ Settings.icon_color +"/return.png")));
    }


    /**
     * Définition et intégration des raccourcis possibles sur la scene
     */
    @Override
    public void setShortcut() {
        // reset des anciens shortcut
        LoadMap.scene.getAccelerators().clear();

        // Acces au paramètres via ESC
        KeyCombination kc = new KeyCodeCombination(KeyCode.ESCAPE, KeyCombination.SHIFT_ANY);
        Runnable rn = ()-> settings_btn.fire();
        LoadMap.scene.getAccelerators().put(kc, rn);
    }

    @Override
    public void apply_settings() {
        for (Node n: LoadMap.scene.getRoot().lookupAll(".Custom_label")) {
            n.setStyle("-fx-font-size: " + Settings.fontSize + "px;");
        }
    }
}
