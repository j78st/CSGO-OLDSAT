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
import Partie.Game;
import Partie.Sounds_list;
import Serialization.Memoire;
import Serialization.Serial_game;
import Timer.TimerController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
        boolean saveSlotSelected = false;
        SaveSlot save_to_load = null;
        
        // Récupère l'emplacement de sauvegarde pour stocker la partie
        if (save_list.getSelectionModel().getSelectedItem()!=null) {
            save_to_load = save_list.getSelectionModel().getSelectedItem();
            if (save_list.getSelectionModel().getSelectedItem().srgame == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Selectionnez une partie à charger !", ButtonType.OK);
                alert.showAndWait();
            } else {
                saveSlotSelected = true;
            }
        }
        if (saveSlotSelected) {
            Serial_game srg = save_to_load.srgame;
            srg.createGameFromMemory();
            Engine.engine.refreshRoom();
            Game.setBas(0);

            // lancement
            LoadMap gl = new LoadMap();
            gl.display_screen_from_id(LoadMap.GAME);
            WorldBoxDisc.play(Son.valid);

            // init chrono
            Engine.engine.timer_lbl.setVisible(false);
            if (Game.timer != 0 && Engine.chrono == null) {
                Engine.engine.timer_lbl.setVisible(true);
                Engine.chrono = new TimerController(Game.timer);
                Engine.chrono.start();
            }

            //Gestion du son

            WorldBoxDisc.pause(Son.menuTheme); //Arrêt du thème du menu
            Sounds_list sounds_list = new Sounds_list();  //Rajout de la sound_list à game (sert à pouvoir lancer des sons en conséquences d'actions)
            //Son ambiant à charger ( pas de solution n'impliquant pas de gros changements trouvées donc on le code "en dur") et possibilité d'ouvrir ou non la carte
            if(Game.getPlayer().getPosition() == 102
                    ||Game.getPlayer().getPosition() == 103
                    ||Game.getPlayer().getPosition() == 201){
                WorldBoxDisc.play(Son.classRoom);
                Engine.engine.set_map_available(false);
                Engine.engine.hide_map();
            }else if(Game.getPlayer().getPosition() == 104){
                WorldBoxDisc.play(Son.outside);
                Engine.engine.set_map_available(false);
                Engine.engine.hide_map();
            }else if((Game.getPlayer().getPosition() >= 107 && Game.getPlayer().getPosition() <= 110)
                    ||(Game.getPlayer().getPosition() >= 202 && Game.getPlayer().getPosition() <= 220)
                    ||(Game.getPlayer().getPosition() >= 301 && Game.getPlayer().getPosition() <= 305)
                    ||(Game.getPlayer().getPosition() >= 2062 && Game.getPlayer().getPosition() <= 2067)){
                WorldBoxDisc.play(Son.gameTheme);
                Engine.engine.set_map_available(false);
                Engine.engine.hide_map();
            }else if((Game.getPlayer().getPosition() >= 111 && Game.getPlayer().getPosition() <= 118)){
                WorldBoxDisc.play(Son.outside);
                Engine.engine.set_map_available(true);
                Engine.engine.hide_map();
            }


        }
        
    }

    // ==========================================================
    // Autre méthodes
    // ==========================================================

    @Override
    public void init() {
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
        // reset des anciens shortcut
        LoadMap.scene.getAccelerators().clear();

        // Acces au paramètres via ESC
        KeyCombination kc = new KeyCodeCombination(KeyCode.ESCAPE, KeyCombination.SHIFT_ANY);
        Runnable rn = ()-> settings_btn.fire();
        LoadMap.scene.getAccelerators().put(kc, rn);;
    }

    @Override
    public void apply_settings() {
        for (Node n: LoadMap.scene.getRoot().lookupAll(".Custom_label")) {
            n.setStyle("-fx-font-size: " + Settings.fontSize + "px;");
        }
    }
}