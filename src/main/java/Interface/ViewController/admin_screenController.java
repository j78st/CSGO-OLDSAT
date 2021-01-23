package Interface.ViewController;

import Interface.CellRenderer.AdminSaveCell;
import Interface.CellRenderer.RoomCell;
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
    private ObservableList<SaveSlot> saveObservableList1;
    private ObservableList<Room> saveObservableList2;

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
        saveObservableList1 = FXCollections.observableArrayList();
        Memoire m = new Memoire();
        Saves saves = (Saves) m.read_data(new File("resources/json/saves.json"));

        for (int i = 0; i<10; i++) {
            saveObservableList1.add(saves.getSave(i));
        }

        save_list.setItems(saveObservableList1);
        save_list.setCellFactory(param -> new AdminSaveCell());

        // affichage
        save_view.toFront();
    }

    @FXML
    void display_test_mode(ActionEvent event) {
        // mise en place de la liste des sauvegarde
        saveObservableList2 = FXCollections.observableArrayList();

        // création partie
        Game.player = new Player("Admin");
        Game.difficulty = 1;
        Scenario_structure scenar_struct = new Scenario_structure();

        ArrayList<Room> rooms = Game.room_bas_access_available();

        for (int i = 0; i<rooms.size(); i++) {
            saveObservableList2.add(rooms.get(i));
        }

        room_list.setItems(saveObservableList2);
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
    public void initialize() {
        return_btn.setGraphic(new ImageView(new Image("/icons/"+ Settings.icon_color +"/return.png")));

        // affichage des sauvegardes par defaut
        display_save_list(new ActionEvent());
    }

    @Override
    public void setShortcut() {
        // non
    }

    @Override
    public void apply_settings() {
        for (Node n: LoadMap.scene.getRoot().lookupAll(".Custom_label")) {
            n.setStyle("-fx-font-size: " + Settings.fontSize + "px;");
        }
    }
}
