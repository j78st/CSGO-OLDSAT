package Interface.ViewController;

import Interface.Ranking.SaveListCell;
import Interface.Save.SaveSlot;
import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Settings;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

import java.io.IOException;

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
        String pseudo = "";
        String difficulty;
        SaveSlot save = new SaveSlot();

        // récupère le pseudo si il est renseigné et teste sa validité
        try {
            pseudo = name_selector.getText();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Inscrivez votre nom !", ButtonType.OK);
            alert.showAndWait();
        }

        // récupère la difficulté de la nouvelle partie
        difficulty = difficulty_selector.getPromptText();

        // récupère l'emplacement de sauvegarde pour stocker la partie
        try {
            save = save_list.getSelectionModel().getSelectedItem();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Selectionnez un emplacement de sauvegarde !", ButtonType.OK);
            alert.showAndWait();
        }

        // vvv REMPLACEMENT DU FICHIER DE SAUVEGARDE ICI   vvv

        // vvv LANCEMENT DE LA PARTIE ICI vvv
        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(LoadMap.GAME);
        WorldBoxDisc.play(Son.valid);

    }

    @Override
    public void initialize() {

        // mise en place des icones
        settings_btn.setGraphic(new ImageView(new Image("icons/"+ Settings.icon_color +"/settings_icon.png")));
        return_btn.setGraphic(new ImageView(new Image("icons/"+ Settings.icon_color +"/return.png")));
        profile_icon.setImage(new Image("icons/"+ Settings.icon_color+ "/profile.png"));
        difficulty_icon.setImage(new Image("icons/"+ Settings.icon_color+ "/shield.png"));

        // mise en place selection difficulté
        difficulty = FXCollections.observableArrayList("Facile", "Normal", "Difficile");
        difficulty_selector.setItems(difficulty);
        difficulty_selector.setValue("Normal");

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
