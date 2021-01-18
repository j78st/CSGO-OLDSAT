package Interface.ViewController;

import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Settings;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;

public class cinematicController implements Controller {

    // ==========================================================
    // Déclaration des objets
    // ==========================================================
    private int no_text;
    private String text1 = "Ceci est le texte 1";
    private String text2 = "Et voici venir le texte 2";
    private String text3 = "Pour finalement avoir le texte 3";

    @FXML
    private Label narration;


    @FXML
    private Button next;

    // ==========================================================
    // Méthodes de changement de texte
    // ==========================================================
    @FXML
    void set_text(ActionEvent event) throws IOException {

        no_text += 1;
        if (no_text == 3) {
            fadeOutTransition(narration);
            go_to_game(); // pour terminer la cinématique
        }

        fadeOutTransition(narration);

        switch (no_text) {
            case 0 : narration.setText(text1); break;
            case 1 : narration.setText(text2); break;
            case 2 : narration.setText(text3); break;
        }

        fadeInTransition(narration);

    }

    private void fadeInTransition (Node node) {
        FadeTransition fadeIN = new FadeTransition();
        fadeIN.setDuration(Duration.seconds(2));
        fadeIN.setNode(node);
        fadeIN.setFromValue(0);
        fadeIN.setToValue(1);
        fadeIN.play();
    }

    private void fadeOutTransition (Node node) {
        FadeTransition fadeOUT = new FadeTransition();
        fadeOUT.setDuration(Duration.seconds(2));
        fadeOUT.setNode(node);
        fadeOUT.setFromValue(1);
        fadeOUT.setToValue(0);
        fadeOUT.play();
    }

    public void go_to_game() throws IOException {
        //LoadMap gl = new LoadMap();
        //gl.display_screen_from_id(LoadMap.GAME);
    }

    // ==========================================================
    // Méthodes d'initialisation
    // ==========================================================
    @Override
    public void initialize() {
        next.setGraphic(new ImageView(new Image("/icons/black/arrow_right.png")));

        no_text = 0;
        narration.setWrapText(true);
        narration.setText(text1);
    }

    @Override
    public void setShortcut() {
        // pas de shortcut
    }

    @Override
    public void apply_settings() {
        for (Node n: LoadMap.scene.getRoot().lookupAll(".Custom_label")) {
            n.setStyle("-fx-font-size: " + (Settings.fontSize+5)+ "px;");
        }
    }
}