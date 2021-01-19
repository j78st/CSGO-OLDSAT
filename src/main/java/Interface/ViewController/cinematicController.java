package Interface.ViewController;

import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Engine;
import Interface.Settings.Settings;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import Timer.TimerController;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.io.IOException;

public class cinematicController implements Controller {

    // ==========================================================
    // Déclaration des objets
    // ==========================================================
    private int no_text;

    private String text1 = "Dans la soirée, vous vous rendez à l'ENSSAT pour visiter l'école.\n\n" +
            "C'est ici que commence votre véritable aventure.\n\n"+
            "Vous arrivez dans le hall d'accueil de l'ENSSAT.";

    private String text2 = "Vous regardez autour de vous, l'endroit est désert,\n" +
            "toutefois vous retrouvez le panneau indiquant la salle 137C, celui qui vous a guidé le matin même.\n" +
            "Personne n'a pris le temps de le ranger, bizarre ...\n\n" +
            "Un silence assez oppressant vous pousse à ne pas rester là.\n" +
            "Pourquoi ne pas suivre la direction indiquée par le panneau,\n" +
            "après tout vous connaissez déjà ce chemin.";

    private String text3 = "Vous vous dirigez vers le couloir.\n\n " +
            "Après quelques pas vous vous arrêtez net,\n" +
            "vous êtes interpellé par une faible lueur.\n" +
            "Elle vient de votre droite.\n" +
            "Vous remarquez une porte entrouverte sur laquelle vous lisez \"Bibliothèque\".";

    @FXML
    private Label narration;

    @FXML
    private Button next;

    @FXML
    private Button end;

    @FXML
    private BorderPane end_pane;

    @FXML
    private BorderPane arrow_pane;

    // ==========================================================
    // Méthodes de changement de texte
    // ==========================================================
    @FXML
    void set_text(ActionEvent event) throws IOException {

        no_text += 1;
        if(no_text == 2){
            end.setPrefSize(200, 50);
            end.setText("Entrer dans la bibliothèque");
            end.setStyle("-fx-text-fill: black; " +
                    "-fx-border-color: transparent; " +
                    "-fx-background-color: white; " +
                    "-fx-background-radius: 100");
            end_pane.toFront();
            end_pane.setVisible(true);
            arrow_pane.setVisible(false);
        }
        if (no_text == 3) {
            fadeOutTransition(narration);
            go_to_game(); // pour terminer la cinématique
            Engine.engine.timer_lbl.setVisible(true);
            Engine.chrono = new TimerController(60*25);
            Engine.chrono.start();
        }

        fadeOutTransition(narration);

        switch (no_text) {
            case 0 :
                WorldBoxDisc.play(Son.hibou);
                narration.setText(text1); break;
            case 1 :
                WorldBoxDisc.play(Son.wind);
                narration.setText(text2); break;
            case 2 :
                WorldBoxDisc.play(Son.tick); // bruit de pas
                WorldBoxDisc.play(Son.tick); // grincement
                WorldBoxDisc.play(Son.porte1); // claquement de porte
                narration.setText(text3); break;
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
        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(LoadMap.GAME);
        fadeInTransition(Engine.engine.root);
    }

    // ==========================================================
    // Méthodes d'initialisation
    // ==========================================================
    @Override
    public void initialize() {
        next.setGraphic(new ImageView(new Image("/icons/black/arrow_right.png")));
        end_pane.toBack();
        end_pane.setVisible(false);
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
            n.setStyle("-fx-font-size: " + (Settings.fontSize+10)+ "px; -fx-font-style: italic");
        }
    }
}