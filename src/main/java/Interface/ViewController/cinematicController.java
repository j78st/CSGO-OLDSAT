package Interface.ViewController;

import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Engine;
import Interface.Settings.Settings;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
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

    private String text1 = "Dans la soirée, vous vous rendez à l'ENSSAT pour " +
            "visiter l'école.\n" +
            "C'est ici que commence votre véritable aventure.\n"+
            "vous arrivez dans le hall d'accueil de l'ENSSAT.";

    private String text2 = "Vous regardez autour de vous l'endroit est désert, " +
            "toutefois vous retrouvez le panneau indiquant la salle" +
            "137C, celui qui vous a guidé le matin même. Personne " +
            "n'a pris le temps de le ranger, bizarre ...\n" +
            "Un silence assez oppressant vous pousse à ne pas rester là, pourquoi ne pas suivre " +
            "la direction indiquée par le panneau, après tout vous " +
            "connaissez déjà ce chemin.";

    private String text3 = "Vous vous dirigez vers le couloir. " +
            "Après quelques pas vous vous arrêtez net, vous êtes interpellé par une faible lueur. " +
            "Elle vient de votre droite. Vous remarquez une porte entrouverte sur laquelle\n" +
            "vous lisez \"Bibliothèque\".\n";

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