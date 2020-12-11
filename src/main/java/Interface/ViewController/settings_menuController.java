package Interface.ViewController;

import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Engine;
import Interface.Settings.Settings;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import Serialization.Memoire;
import Serialization.Serial_settings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

import java.io.File;
import java.io.IOException;

public class settings_menuController implements Controller {

    // ==========================================================
    // Déclaration objets
    // ==========================================================

    int previous_screen_ID;
    ToggleGroup themeGroup = new ToggleGroup();

    @FXML
    private Button save_btn;

    @FXML
    private Button resume_btn;

    @FXML
    private RadioButton theme1_btn;

    @FXML
    private RadioButton theme2_btn;

    @FXML
    private RadioButton theme3_btn;

    @FXML
    private Slider fx_slider;

    @FXML
    private Slider bg_slider;

    // ==========================================================
    // Méthodes gestion logiciel
    // ==========================================================

    /**
     * Lors de l'appui sur le bouton RETOUR :
     * Permet de revenir à l'écran d'où a été affiché le menu.
     * @param event
     * @throws IOException
     */
    @FXML
    void go_back_to_previous_screen(ActionEvent event) throws IOException {
        Memoire m = new Memoire();
        m.write_data(new Serial_settings(), new File("resources/json/settings.json"));

        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(previous_screen_ID);
        WorldBoxDisc.play(Son.menuClose);
    }

    // ==========================================================
    // Méthodes d'initialisation
    // ==========================================================

    /**
     * Méthode appllée lors du chargement du menu paramètre
     * Elle permet de récuperer le numéro de la scène précédente pour y revenir lors de la fermeture du menu.
     * @param previous_ID id du précédent écran
     */
    public void provide_current_screen_id(int previous_ID) {
        previous_screen_ID = previous_ID;
    }

    /**
     * Initalise la scène
     */
    @Override
    public void initialize() {
        // icone de retour
        resume_btn.setGraphic(new ImageView(new Image("/icons/"+ Settings.icon_color +"/return.png")));

        // paramètre du thème utilisé
        theme1_btn.setToggleGroup(themeGroup);
        theme2_btn.setToggleGroup(themeGroup);
        theme3_btn.setToggleGroup(themeGroup);

        //listener
        themeGroup.selectedToggleProperty().addListener(
            new ChangeListener<Toggle>() {
                public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n){
                    RadioButton rb = (RadioButton)themeGroup.getSelectedToggle();
                    if (rb != null) {

                        // changement du theme appliqué
                        Settings.theme = rb.getText();
                        LoadMap.scene.getStylesheets().clear();
                        LoadMap.scene.getStylesheets().add("/CSS/"+ Settings.theme +".css");

                        // liste des themes qui necessitent des icones blanches
                        if (Settings.theme.equals("blue")
                                ||Settings.theme.equals("green")) {
                            Settings.icon_color = "white";
                        } else {
                            Settings.icon_color = "black";
                        }
                    }
                }
            }
        );

        // Création des listener pour les volumes sonores
        fx_slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {

                Settings.fx_volume = new_val.doubleValue()/20;
                WorldBoxDisc.setSoundFx(Settings.fx_volume);

            }
        });
        bg_slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {

                Settings.bg_volume = new_val.doubleValue()/20;
                WorldBoxDisc.setSoundBackground(Settings.bg_volume);

            }
        });

        // restauration des paramètres courants
        // volumes
        fx_slider.setValue(Settings.fx_volume);
        bg_slider.setValue(Settings.bg_volume);
        // theme
        if (theme1_btn.getText().equals(Settings.theme)){
            theme1_btn.setSelected(true);
        } else if (theme2_btn.getText().equals(Settings.theme)){
            theme2_btn.setSelected(true);
        } else {
            theme3_btn.setSelected(true);
        }
    }

    /**
     * Définition et intégration des raccourcis possibles sur la scène
     */
    @Override
    public void setShortcut() {
        // Fermeture paramètre via ESC
        KeyCombination kc = new KeyCodeCombination(KeyCode.ESCAPE, KeyCombination.SHIFT_ANY);
        Runnable rn = ()-> {resume_btn.fire();};
        LoadMap.scene.getAccelerators().put(kc, rn);
    }
}
