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

public class outroController implements Controller {

    // ==========================================================
    // Déclaration des objets
    // ==========================================================
    private int no_text;

    private String text1 = "Une sensation étrange vous parcourt tout le corps.\n" +
            "Une lumière vive vous éblouie. Vos yeux mettent quelques secondes à s'habituer\n\n"+
            "Quand vous arrivez enfin à distinguer les choses, vous vous rendez compte que \n" +
            "vous êtes maintenant à l'extérieur et que le soleil est au zénith.";

    private String text2 = "Après quelques longues secondes, vous reprenez vos esprits et regardez autour de vous.\n" +
            "Vous reconnaissez les lieux, vous êtes devant l'ENSSAT. Cependant, beaucoup de choses sont différentes.\n" +
            "L'ENSSAT n'a pas encore ses extensions modernes et il n'y a aucune voiture dans la rue.\n\n" +
            "C'est comme si vous aviez fait un bond dans le temps mais cela est impossible...\n\n" +
            "Il y a une carte à vos pieds. Vous la ramassez.";

    private String text3 = "[Fin de l'escape game]\n\n" +
            "Vous allez maintenant accéder à un mode exploration. Prenez votre temps,\n" +
            "le chrono s'est arrêté et votre score a été sauvegardé.\n" +
            "Ce mode est pour nous un prétexte de démonstration de la carte des salle\n" +
            "qui n'avait pas de sens précédemment étant donné que l'escape game se passait dans une seule grande salle. \n\n" +
            "Vous pouvez quitter ce mode à tout moment et accéder à l'écran des scores\n" +
            "grâce à l'action \"Quitter le mode exploration\" disponible partout.";

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

        if (no_text == 3) {
            Game.search_action(1104).do_consequences();
            screen_transition();
            WorldBoxDisc.play(Son.outside);
        }
    }

    private void text_transition () {
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
            } catch (IOException e) {
                e.printStackTrace();
            }

            Engine.engine.set_map_available(true);
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
    public void initialize() {
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
        // pas de shortcut
    }

    @Override
    public void apply_settings() {
        for (Node n: LoadMap.scene.getRoot().lookupAll(".Custom_label")) {
            n.setStyle("-fx-font-size: " + (Settings.fontSize+10)+ "px; -fx-font-style: italic");
        }
    }
}
