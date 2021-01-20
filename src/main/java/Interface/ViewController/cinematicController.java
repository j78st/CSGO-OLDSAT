package Interface.ViewController;

import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Engine;
import Interface.Settings.Settings;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import Partie.Game;
import Timer.TimerController;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
            "Toutefois vous retrouvez le panneau indiquant la salle 137C, celui qui vous a guidé le matin même.\n" +
            "Personne n'a pris le temps de le ranger, bizarre ...\n\n" +
            "Un silence assez pesant vous pousse à ne pas rester là.\n" +
            "Pourquoi ne pas suivre la direction indiquée par le panneau,\n" +
            "après tout vous connaissez déjà ce chemin.";

    private String text3 = "Vous vous dirigez vers le couloir.\n\n" +
            "Après quelques pas vous vous arrêtez net...\n" +
            "Vous êtes interpellé par une faible lueur.\n" +
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
        text_transition();

        if(no_text == 2){
            end_pane.toFront();
            end_pane.setVisible(true);
            arrow_pane.setVisible(false);
        } else if (no_text == 3) {
            Game.search_action(1043).do_consequences();
            screen_transition();
        }
    }

    private void text_transition () {
        FadeTransition fadeOUT = new FadeTransition();
        fadeOUT.setDuration(Duration.seconds(2));
        fadeOUT.setNode(narration);
        fadeOUT.setFromValue(1);
        fadeOUT.setToValue(0);
        fadeOUT.play();

        fadeOUT.setOnFinished(event -> {
            if (no_text == 1) { // affichage texte 2

                WorldBoxDisc.play(Son.wind);
                narration.setText(text2);

            } else if (no_text == 2) { // affichage texte 3

                WorldBoxDisc.play(Son.tick); // bruit de pas
                WorldBoxDisc.play(Son.tick); // grincement
                WorldBoxDisc.play(Son.porte1); // claquement de porte
                narration.setText(text3);

            }
            // réaffichage texte
            FadeTransition fadeIN = new FadeTransition();
            fadeIN.setDuration(Duration.seconds(2));
            fadeIN.setNode(narration);
            fadeIN.setFromValue(0);
            fadeIN.setToValue(1);
            fadeIN.play();
        });

        fadeOUT.play();
    }

    private void screen_transition(){
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
                Engine.chrono = new TimerController(60*25);
                Engine.chrono.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

            FadeTransition ft = new FadeTransition();
            ft.setDuration(Duration.seconds(2));
            ft.setNode(Engine.engine.root);
            ft.setFromValue(0);
            ft.setToValue(1);
            ft.play();
        });

        fadeOUT.play();
    }

    // ==========================================================
    // Méthodes d'initialisation
    // ==========================================================
    @Override
    public void initialize() {
        next.setGraphic(new ImageView(new Image("/icons/black/arrow_right.png")));
        end_pane.toBack();
        end_pane.setVisible(false);

        narration.setWrapText(true);
        narration.setText(text1);

        no_text = 0;
        WorldBoxDisc.play(Son.hibou);
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
/*FadeTransition fadeOUT = new FadeTransition();
        fadeOUT.setDuration(Duration.seconds(1));
        fadeOUT.setNode(narration);

        no_text += 1;
        if(no_text == 2){
            text_transition();
            end_pane.toFront();
            end_pane.setVisible(true);
            arrow_pane.setVisible(false);
        }

        if (no_text == 3) {
            FadeTransition ft = new FadeTransition();
            ft.setDuration(Duration.seconds(2));
            ft.setNode(Engine.engine.root);
            ft.setFromValue(1.0);
            ft.setToValue(0.0);
            ft.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                    try {
                        go_to_game(); // pour terminer la cinématique
                        Engine.engine.timer_lbl.setVisible(true);
                        Engine.chrono = new TimerController(60*25);
                        Engine.chrono.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        // disparition du texte
        fadeOUT.setFromValue(1);
        fadeOUT.setToValue(0);

        fadeOUT.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //modification du texte
                switch (no_text) {
                    case 1 :
                        WorldBoxDisc.play(Son.wind);
                        narration.setText(text2); break;
                    case 2 :
                        WorldBoxDisc.play(Son.tick); // bruit de pas
                        WorldBoxDisc.play(Son.tick); // grincement
                        WorldBoxDisc.play(Son.porte1); // claquement de porte
                        narration.setText(text3); break;
                }
                // reapparition du texte
                FadeTransition fadeIN = new FadeTransition();
                fadeIN.setDuration(Duration.seconds(1));
                fadeIN.setNode(narration);
                fadeIN.setFromValue(0);
                fadeIN.setToValue(1);
                fadeIN.play();
            }
        });
        fadeOUT.play();*/