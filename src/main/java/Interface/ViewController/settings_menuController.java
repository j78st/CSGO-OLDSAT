package Interface.ViewController;

import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Settings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

import java.io.IOException;

public class settings_menuController implements Controller {

    // ==========================================================
    // Paramètres tampon
    // ==========================================================

    private Double fx_volume;
    private Double bg_volume;
    private String theme;
    private String icon_color;

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

    // ==========================================================
    // Méthodes gestion logiciel
    // ==========================================================

    /**
     * Permet de revenir à l'écran d'où a été affiché le menu.
     * @param event
     * @throws IOException
     */
    @FXML
    void go_back_to_previous_screen(ActionEvent event) throws IOException {
        // restauration des derniers paramètres sauvegardés
        Settings.theme = theme;
        Settings.icon_color = icon_color;
        Settings.fx_volume = fx_volume;
        Settings.bg_volume = bg_volume;

        LoadMap.scene.getStylesheets().clear();
        LoadMap.scene.getStylesheets().add("/CSS/"+ theme +".css");

        // retour sur l'écran précédent
        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(previous_screen_ID);
    }

    /**
     * Sauvegarde les paramètres enregistrés lors de l'appui sur le bouton "valider"
     * @param event
     */
    @FXML
    void save_settings(ActionEvent event) {
        icon_color = Settings.icon_color;
        theme = Settings.theme;
        fx_volume = Settings.fx_volume;
        bg_volume = Settings.bg_volume;
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
     * Initalise la scène lors de son chargement
     */
    @Override
    public void initialize() {
        // icone de retour
        resume_btn.setGraphic(new ImageView(new Image("/icons/"+ Settings.icon_color +"/return.png")));

        // sauvegarde des paramètres avant changement
        fx_volume = Settings.fx_volume;
        bg_volume = Settings.bg_volume;
        theme = Settings.theme;
        icon_color = Settings.icon_color;

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
                        String t = rb.getText();
                        LoadMap.scene.getStylesheets().clear();
                        LoadMap.scene.getStylesheets().add("/CSS/"+ t +".css");

                        // liste des themes qui necessitent des icones blanches
                        if (t.equals("blue")
                                ||t.equals("green")
                                ||t.equals("red")) {
                            Settings.icon_color = "white";
                        } else {
                            Settings.icon_color = "black";
                        }
                    }
                }
            }
        );
    }

    /**
     * Définition et intégration des raccourcis possibles sur la scene
     */
    @Override
    public void setShortcut() {
        // Fermeture paramètre via ESC
        KeyCombination kc = new KeyCodeCombination(KeyCode.ESCAPE, KeyCombination.SHIFT_ANY);
        Runnable rn = ()-> {resume_btn.fire();};
        LoadMap.scene.getAccelerators().put(kc, rn);
    }
}
