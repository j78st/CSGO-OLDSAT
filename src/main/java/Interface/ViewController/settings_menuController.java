package Interface.ViewController;

import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Engine;
import Interface.Settings.Settings;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import Partie.Game;
import Serialization.Memoire;
import Serialization.Serial_settings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private RadioButton theme3_btn;

    @FXML
    private Slider fx_slider;

    @FXML
    private Slider bg_slider;

    @FXML
    private ComboBox<String> text_size_prompt;


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

        // Ecriture memoire des nouveaux paramètres
        Memoire m = new Memoire();
        m.write_data(new Serial_settings(), new File("resources/json/settings.json"));

        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(previous_screen_ID);

        if(previous_screen_ID == LoadMap.GAME) { //Si on retourne sur l'écran de jeu
            Game.search_room(Game.getPlayer().getPosition()).access_map(); //Redonne l'accès à la map si nécessaire
        }

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
    public void init() {
        // icone de retour
        resume_btn.setGraphic(new ImageView(new Image("/icons/"+ Settings.icon_color +"/return.png")));

        // paramètre du thème utilisé
        theme1_btn.setToggleGroup(themeGroup);
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
                        if (Settings.theme.equals("Sombre")) {
                            Settings.icon_color = "white";
                            resume_btn.setGraphic(new ImageView(new Image("/icons/white/return.png")));
                            theme1_btn.setStyle("-fx-text-fill: white");
                            theme3_btn.setStyle("-fx-text-fill: white");
                            Engine.engine.light_action_container.toBack();
                            Engine.engine.dark_action_container.toFront();
                        } else {
                            Settings.icon_color = "black";
                            resume_btn.setGraphic(new ImageView(new Image("/icons/black/return.png")));
                            theme1_btn.setStyle("-fx-text-fill: black");
                            theme3_btn.setStyle("-fx-text-fill: black");
                            Engine.engine.light_action_container.toFront();
                            Engine.engine.dark_action_container.toBack();
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

        // Choix de la taille des caractères
        ObservableList<String> sizes = FXCollections.observableArrayList("Petit", "Normal", "Gros");
        text_size_prompt.setItems(sizes);
        text_size_prompt.setStyle("-fx-font-size: 15 px;");
        text_size_prompt.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String old_value, String new_value) {

                // Inscrit la nouvelle taille de texte dans les paramètres
                String value = text_size_prompt.getValue();
                if ("Petit".equals(value)) {
                    Settings.fontSize = Settings.SMALL;
                } else if ("Normal".equals(value)) {
                    Settings.fontSize = Settings.MEDIUM;
                } else if ("Gros".equals(value)) {
                    Settings.fontSize = Settings.BIG;
                } else {
                    throw new IllegalStateException("Unexpected value: " + text_size_prompt.getValue());
                }

                // applique le changement de style sur les textes modifiables
                for (Node n: LoadMap.scene.getRoot().lookupAll(".Custom_label")) {
                    n.setStyle("-fx-font-size: " + Settings.fontSize + "px;");
                }

            }
        });

        // restauration des paramètres courants
        Settings.setSettingsFromFile();
        // volumes
        fx_slider.setValue(Settings.fx_volume*20);
        bg_slider.setValue(Settings.bg_volume*20);
        // theme
        if (theme1_btn.getText().equals(Settings.theme)){
            theme1_btn.setSelected(true);
        } else {
            theme3_btn.setSelected(true);
        }
        // taille texte
        switch (Settings.fontSize) {
            case Settings.SMALL :
                text_size_prompt.setValue("Petit"); break;
            case Settings.MEDIUM :
                text_size_prompt.setValue("Normal"); break;
            case Settings.BIG :
                text_size_prompt.setValue("Gros"); break;
        }
    }

    /**
     * Définition et intégration des raccourcis possibles sur la scène
     */
    @Override
    public void setShortcut() {
        LoadMap.scene.getAccelerators().remove(KeyCode.ESCAPE);

        // Fermeture paramètre via ESC
        KeyCombination kc = new KeyCodeCombination(KeyCode.ESCAPE);
        Runnable rn = ()-> resume_btn.fire();
        LoadMap.scene.getAccelerators().put(kc, rn);
    }

    /**
     *  Applique les valeurs enregistrées dans les paramètres aux éléments de la page
     */
    @Override
    public void apply_settings() {
        for (Node n: LoadMap.scene.getRoot().lookupAll(".Custom_label")) {
            n.setStyle("-fx-font-size: " + Settings.fontSize + "px;");
        }
    }

}
