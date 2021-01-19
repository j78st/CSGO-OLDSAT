package Interface.CellRenderer;

import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Settings;
import Partie.Action;
import Partie.Room;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.ArrayList;

public class RoomCell extends ListCell<Room> {

    HBox hbox = new HBox();
    Label nom_salle = new Label(); //nom salle
    Button del = new Button("tester"); // bouton de suppression de sauvegarde

    /**
     * Constructeur. Paramètre l'apparence de la cellule
     */
    public RoomCell() {

        super();

        // taille du conteneur
        hbox.setPrefSize(360, 40);

        // parametrage des tailles des labels
        nom_salle.setPrefSize(300, 10);

        // esthétique des éléments
        if (Settings.icon_color.equals("white")){
            nom_salle.setStyle("-fx-text-fill: white; -fx-font-size: " + Settings.fontSize + "px;");
        } else {
            nom_salle.setStyle("-fx-text-fill: black; -fx-font-size: " + Settings.fontSize + "px;");
        }

        // paramètrage du bouton de suppression
        del.setStyle("-fx-background-color: red; -fx-background-radius: 20; -fx-text-fill: white");
        del.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // téléportation dans la salle
                ArrayList<int[]> consequences_action4 = new ArrayList<>();
                consequences_action4.add(new int[]{12, getItem().getId()});

                Action action = new Action(9,false,"Demander son chemin", consequences_action4, 101);
                try {
                    action.do_consequences();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    (new LoadMap()).display_screen_from_id(LoadMap.GAME);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

        // parametrage du placement hortizontal
        hbox.setMargin(nom_salle, new Insets(0, 0, 0, 0));
        hbox.setMargin(del, new Insets(0, 0, 0, 10));

        // ajout de tous les éléments à afficher dans le classement des scores
        hbox.getChildren().addAll(nom_salle, del);
    }

    /**
     * Mets a jour les données de la cellule
     * @param room élément dispensé dans la cellule
     * @param empty booléen indiquant si la case est vide
     */
    @Override
    public void updateItem (Room room, boolean empty) {

        super.updateItem(room, empty);

        setText(null);
        setGraphic(null);

        if (room != null && !empty) {
            nom_salle.setText(room.getRoom_name());
            setGraphic(hbox);
        }

    }

}
