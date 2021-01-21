package Interface.ViewController;

import Interface.CellRenderer.SaveListCell;
import Interface.Save.SaveSlot;
import Interface.Save.Saves;
import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Engine;
import Interface.Settings.Settings;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import Serialization.Memoire;
import Serialization.Serial_game;
import Timer.TimerController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import Partie.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class new_game_formController implements Controller {

    private ObservableList<SaveSlot> saveObservableList;
    private ObservableList<String> difficulty;

    @FXML
    private TextField name_selector;

    @FXML
    private ComboBox difficulty_selector;

    @FXML
    private ListView<SaveSlot> save_list;

    @FXML
    private Button settings_btn;

    @FXML
    private Button return_btn;

    @FXML
    private ImageView difficulty_icon;

    @FXML
    private ImageView profile_icon;

    /**
     * Lors de l'appui sur le bouton RETOUR
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
     * @param event
     * @throws IOException
     */
    @FXML
    void go_to_settings_menu(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        gl.display_settings_menu(LoadMap.NEW_GAME_FORM);
        WorldBoxDisc.play(Son.menuOpen);
    }

    /**
     * Lors de l'appui sur le bouton CREER PARTIE
     * Crée une nouvelle partie sur l'emplacement de sauvegarde sélectionné
     * avec le pseudo et difficulté sélectionnés.
     * @param event
     * @throws IOException
     */
    @FXML
    void create_game(ActionEvent event) throws IOException {
        boolean saveSlotSelected = false;
        boolean nameWritten = false;

        String pseudo = "";
        int difficulty;
        SaveSlot save = new SaveSlot();

        // récupère le pseudo s'il est renseigné et teste sa validité
        pseudo = name_selector.getText();
        if (pseudo.equals("")) {
            nameWritten = false;
            Alert nameAlert = new Alert(Alert.AlertType.WARNING, "Inscrivez votre nom !", ButtonType.OK);
            nameAlert.showAndWait();
        } else {
            nameWritten = true;
        }

        // récupère la difficulté de la nouvelle partie
        switch ((String)difficulty_selector.getValue()) {
            case "Facile": difficulty = 0; break;
            case "Normale" : difficulty = 1; break;
            case "Difficile" : difficulty = 2; break;
            default:
                throw new IllegalStateException("Unexpected value: " + difficulty_selector.getPromptText());
        }

        // Récupère l'emplacement de sauvegarde pour stocker la partie
        if (save_list.getSelectionModel().getSelectedItem()!=null) {
            save = save_list.getSelectionModel().getSelectedItem();
            saveSlotSelected = true;
        } else {
            saveSlotSelected = false;
            Alert alert = new Alert(Alert.AlertType.WARNING, "Selectionnez un emplacement de sauvegarde !", ButtonType.OK);
            alert.showAndWait();
        }

        // SI le formulaire est correcte on crée la partie, SINON rien tant que pas correct
        if ( nameWritten && saveSlotSelected) {
            // === Création de la partie === //
            creer_partie(pseudo, difficulty);
            Engine.engine.refreshRoom();

            // === Sauvegarde de la partie === //
            Memoire m = new Memoire();
            Saves saves = (Saves) m.read_data(new File("resources/json/saves.json"));
            save.srgame = new Serial_game();
            saves.setSave(save.no,save);
            m.write_data(saves, new File("resources/json/saves.json"));

            // === Lancement de la partie === //
            // affichage jeu
            LoadMap gl = new LoadMap();
            gl.display_screen_from_id(LoadMap.GAME);

            // son validation
            WorldBoxDisc.play(Son.valid);

            Engine.engine.timer_lbl.setVisible(false);
        }
    }

    @Override
    public void initialize() {

        // mise en place des icones
        settings_btn.setGraphic(new ImageView(new Image("icons/"+ Settings.icon_color +"/settings_icon.png")));
        return_btn.setGraphic(new ImageView(new Image("icons/"+ Settings.icon_color +"/return.png")));
        profile_icon.setImage(new Image("icons/"+ Settings.icon_color+ "/profile.png"));
        difficulty_icon.setImage(new Image("icons/"+ Settings.icon_color+ "/shield.png"));

        // mise en place selection difficulté
        difficulty = FXCollections.observableArrayList("Facile", "Normale", "Difficile");
        difficulty_selector.setItems(difficulty);
        difficulty_selector.setValue("Normale");

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
        LoadMap.scene.getAccelerators().put(kc, rn);
    }

    @Override
    public void apply_settings() {
        for (Node n: LoadMap.scene.getRoot().lookupAll(".Custom_label")) {
            n.setStyle("-fx-font-size: " + Settings.fontSize + "px;");
        }
    }

    public void creer_partie(String pseudo, int difficulty){

        // Pseudo et difficulté choisis à la création
        Game.player = new Player(pseudo);
        Game.difficulty = difficulty;
        Game.setBas(0);
        Scenario_structure scenar_struct = new Scenario_structure();

        // Son ambiance
        WorldBoxDisc.pause(Son.menuTheme);
    }


}
