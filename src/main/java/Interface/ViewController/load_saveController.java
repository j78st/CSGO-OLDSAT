package Interface.ViewController;

import Interface.CellRenderer.SaveListCell;
import Interface.Save.SaveSlot;
import Interface.Save.Saves;
import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Settings;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import Serialization.Memoire;
import Serialization.Serial_game;
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

import java.io.File;
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

    @FXML
    private Button return_btn;

    // ==========================================================
    // Méthodes FXML
    // ==========================================================

    /**
     * Lors de l'appui sur le bouton RETOUR
     *  affiche l'ecran de lancement de partir
     * @param event
     * @throws IOException
     */
    @FXML
    void go_back_to_launch_screen(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(LoadMap.LAUNCHER);
        WorldBoxDisc.play(Son.menuClose);
    }

    /**
     * Lors de l'appui sur le bouton PARAMETRES
     * affiche le menu des paramètres
     * @param event
     */
    @FXML
    void go_to_settings_menu(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        gl.display_settings_menu(LoadMap.LOAD_SAVE);
        WorldBoxDisc.play(Son.menuOpen);
    }

    /**
     *  relance la partie sélectionnée
     * @param event
     */
    @FXML
    void launch_game(ActionEvent event) throws IOException {
        SaveSlot save_to_load = save_list.getSelectionModel().getSelectedItem();
        Serial_game srg = save_to_load.srgame;
        srg.setGameFromMemory();

        // lancement
        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(LoadMap.GAME);
        WorldBoxDisc.play(Son.valid);
    }

    // ==========================================================
    // Autre méthodes
    // ==========================================================

    @Override
    public void initialize() {
        // image du bouton paramètre
        settings_btn.setGraphic(new ImageView(new Image("icons/"+ Settings.icon_color +"/settings_icon.png")));
        return_btn.setGraphic(new ImageView(new Image("icons/"+ Settings.icon_color +"/return.png")));

        // mise en place de la liste des sauvegarde
        saveObservableList = FXCollections.observableArrayList();
        Memoire m = new Memoire();
        Saves saves = (Saves) m.read_data(new File("resources/json/saves.json"));

        for (int i = 0; i<10; i++) {
            saveObservableList.add(saves.getSave(i));
        }

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
        LoadMap.scene.getAccelerators().put(kc, rn);;
    }
}