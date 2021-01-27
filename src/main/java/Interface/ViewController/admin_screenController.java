package Interface.ViewController;

import Interface.CellRenderer.AdminSaveCell;
import Interface.CellRenderer.RoomCell;
import Interface.Save.SaveSlot;
import Interface.Save.Saves;
import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Settings;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import Partie.Game;
import Partie.Player;
import Partie.Room;
import Partie.Scenario_structure;
import Serialization.Memoire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class admin_screenController implements Controller {

    // ==========================================================
    // Déclaration des objets
    // ==========================================================
    @FXML
    private BorderPane save_view;

    @FXML
    private ListView<SaveSlot> save_list;

    @FXML
    private BorderPane test_mode_view;

    @FXML
    private Button return_btn;

    @FXML
    private ListView<Room> room_list;

    // ==========================================================
    // Méthodes d'initialisation
    // ==========================================================
    @FXML
    void display_save_list(ActionEvent event) {
        // mise en place de la liste des sauvegarde
        ObservableList<SaveSlot> saveObservableList = FXCollections.observableArrayList();
        Memoire m = new Memoire();
        Saves saves = (Saves) m.read_data(new File("resources/json/saves.json"));

        for (int i = 0; i<10; i++) {
            saveObservableList.add(saves.getSave(i));
        }

        save_list.setItems(saveObservableList);
        save_list.setCellFactory(param -> new AdminSaveCell());

        // affichage
        save_view.toFront();
    }

    @FXML
    void display_test_mode(ActionEvent event) {
        // mise en place de la liste des sauvegarde
        ObservableList<Room> roomObservableList = FXCollections.observableArrayList();

        ArrayList<Room> rooms = Game.room_bas_access_available();
        room_list.getItems().clear();
        roomObservableList.clear();

        for (int i = 0; i<rooms.size(); i++) {
            roomObservableList.add(rooms.get(i));
        }

        room_list.setItems(roomObservableList);
        room_list.setCellFactory(param -> new RoomCell());

        // affichage
        test_mode_view.toFront();
    }

    @FXML
    void go_back(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(LoadMap.HOME);
        WorldBoxDisc.play(Son.menuClose);
    }

    // ==========================================================
    // Méthodes d'initialisation
    // ==========================================================
    @Override
    public void init() {
        return_btn.setGraphic(new ImageView(new Image("/icons/"+ Settings.icon_color +"/return.png")));

        // affichage des sauvegardes par defaut
        display_save_list(new ActionEvent());

        // création partie
        Game.player = new Player("Admin");
        Game.difficulty = 1;
        Scenario_structure scenar_struct = new Scenario_structure();
    }

    @Override
    public void setShortcut() {
        // reset des anciens shortcut
        //LoadMap.scene.getAccelerators().clear();
    }

    @Override
    public void apply_settings() {
        for (Node n: LoadMap.scene.getRoot().lookupAll(".Custom_label")) {
            n.setStyle("-fx-font-size: " + Settings.fontSize + "px;");
        }
    }
}
