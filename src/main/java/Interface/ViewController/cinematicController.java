package Interface.ViewController;

import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Engine;
import Interface.Settings.Settings;
import Music.Systems.PlayList;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import Partie.Game;
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

    private String text2 = "Vous regardez autour de vous, l'endroit est désert.\n" +
            "Toutefois, vous retrouvez le panneau indiquant la salle 137C, celui qui vous a guidé le matin même.\n" +
            "Personne n'a pris le temps de le ranger, bizarre...\n\n" +
            "Un silence assez pesant vous pousse à ne pas rester là.\n" +
            "Pourquoi ne pas suivre la direction indiquée par le panneau ?\n" +
            "Après tout vous connaissez déjà ce chemin.";

    private String text3 = "Vous vous dirigez vers le couloir.\n\n" +
            "Après quelques pas vous vous arrêtez net.\n" +
            "Vous êtes interpellé par une faible lueur. Elle vient de votre droite.\n" +
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
        PlayList playlist = new PlayList();
        no_text += 1;
        text_transition();

        if (no_text == 3) {
            Game.search_action(1043).do_consequences();
            screen_transition();
            WorldBoxDisc.play(Son.gameTheme);

            playlist.addSound(Son.porte1);
            playlist.addSound(Son.creakingDoor2);
            playlist.addSound(Son.steps3);
            playlist.addSound(Son.doorSlam);
            playlist.addSound(Son.ambiance1);
            playlist.start();

        }
    }

    private void text_transition () {
        PlayList playlist = new PlayList();
        next.setDisable(true);

        FadeTransition fadeOUT = new FadeTransition();
        fadeOUT.setDuration(Duration.seconds(2));
        fadeOUT.setNode(narration);
        fadeOUT.setFromValue(1);
        fadeOUT.setToValue(0);
        fadeOUT.play();

        fadeOUT.setOnFinished(event -> {
            if (no_text == 1) { // affichage texte 2

                narration.setText(text2);

            } else if (no_text == 2) { // affichage texte 3
                WorldBoxDisc.play(Son.steps3);
                narration.setText(text3);

                //changement bouton
                end_pane.toFront();
                end_pane.setVisible(true);
                arrow_pane.setVisible(false);

            }
            // réaffichage texte
            FadeTransition fadeIN = new FadeTransition();
            fadeIN.setDuration(Duration.seconds(2));
            fadeIN.setNode(narration);
            fadeIN.setFromValue(0);
            fadeIN.setToValue(1);
            fadeIN.setOnFinished(event1 -> {
                next.setDisable(false);
            });

            fadeIN.play();
        });

        fadeOUT.play();
    }

    private void screen_transition(){
        next.setDisable(true);

        FadeTransition fadeOUT = new FadeTransition();
        fadeOUT.setDuration(Duration.seconds(2));
        fadeOUT.setNode(narration);
        fadeOUT.setFromValue(1);
        fadeOUT.setToValue(0);

        fadeOUT.setOnFinished(event -> {
            LoadMap gl = new LoadMap();
            try {
                gl.display_screen_from_id(LoadMap.GAME);
                Engine.engine.timer_lbl.setVisible(true);
                if (Game.getDifficulty() == 0){
                    Engine.chrono = new TimerController(60 * 35);
                }else if(Game.getDifficulty() == 1){
                    Engine.chrono = new TimerController(60 * 25);
                }else if(Game.getDifficulty() == 2){
                    Engine.chrono = new TimerController(60 * 20);
                }
                Engine.chrono.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

            FadeTransition ft = new FadeTransition();
            ft.setDuration(Duration.seconds(2));
            ft.setNode(Engine.engine.root);
            ft.setFromValue(0);
            ft.setToValue(1);
            ft.setOnFinished(event1 -> {
                next.setDisable(false);
            });
            ft.play();
        });

        fadeOUT.play();
    }

    // ==========================================================
    // Méthodes d'initialisation
    // ==========================================================
    @Override
    public void init() {
        next.setGraphic(new ImageView(new Image("/icons/black/arrow_right.png")));
        end_pane.toBack();
        end_pane.setVisible(false);

        narration.setWrapText(true);
        narration.setText(text1);

        narration.setOpacity(0);
        next.setOpacity(0);

        FadeTransition f1 = new FadeTransition();
        f1.setDuration(Duration.seconds(2));
        f1.setNode(narration);
        f1.setFromValue(0);
        f1.setToValue(1);

        FadeTransition f2 = new FadeTransition();
        f2.setDuration(Duration.seconds(2));
        f2.setNode(next);
        f2.setFromValue(0);
        f2.setToValue(1);

        f1.play();
        f2.play();
    }

    @Override
    public void setShortcut() {
        // reset des anciens shortcut
        LoadMap.scene.getAccelerators().clear();
    }

    @Override
    public void apply_settings() {
        for (Node n: LoadMap.scene.getRoot().lookupAll(".Custom_label")) {
            n.setStyle("-fx-font-size: " + (Settings.fontSize+10)+ "px; -fx-font-style: italic");
        }
    }
}