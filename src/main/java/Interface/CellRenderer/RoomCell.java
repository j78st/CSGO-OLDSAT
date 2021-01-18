package Interface.CellRenderer;

import Interface.Settings.Settings;
import Partie.Game;
import Partie.Player;
import Partie.Scenario_structure;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import java.util.ArrayList;

public class RoomCell extends ListCell<String> {

    HBox hbox = new HBox();
    Label ln = new Label(); //nom salle
    Button del = new Button("tester"); // bouton de suppression de sauvegarde

    /**
     * Constructeur. Paramètre l'apparence de la cellule
     */
    public RoomCell() {

        super();

        // taille du conteneur
        hbox.setPrefSize(360, 40);

        // parametrage des tailles des labels
        ln.setPrefSize(120, 10);

        // esthétique des éléments
        if (Settings.icon_color.equals("white")){
            ln.setStyle("-fx-text-fill: white; -fx-font-size: " + Settings.fontSize + "px;");
        } else {
            ln.setStyle("-fx-text-fill: black; -fx-font-size: " + Settings.fontSize + "px;");
        }

        // paramètrage du bouton de suppression
        del.setStyle("-fx-background-color: red; -fx-background-radius: 20; -fx-text-fill: white");
        del.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // création partie de test
                Game.player = new Player("admin");
                Game.difficulty = 1;
                Scenario_structure scenar_struct = new Scenario_structure();

                // téléportation dans la salle
                ArrayList<int[]> consequences_action4 = new ArrayList<>();
                //consequences_action4.add(new int[]{12id_salle_testée});

            }

        });

        // parametrage du placement hortizontal
        hbox.setMargin(ln, new Insets(0, 0, 0, 0));
        hbox.setMargin(del, new Insets(0, 0, 0, 10));

        // ajout de tous les éléments à afficher dans le classement des scores
        hbox.getChildren().addAll(ln, del);
    }

    /**
     * Mets a jour les données de la cellule
     * @param room élément dispensé dans la cellule
     * @param empty booléen indiquant si la case est vide
     */
    @Override
    public void updateItem (String room, boolean empty) {

        super.updateItem(room, empty);

        setText(null);
        setGraphic(null);

        if (room != null && !empty) {
            //action_title.setText(room.getText());
            //setGraphic(action_title);
        }

    }

}
