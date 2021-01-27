package Interface.CellRenderer;

import Interface.Save.SaveSlot;
import Interface.Save.Saves;
import Interface.Settings.Settings;
import Partie.Game;
import Partie.Player;
import Serialization.Memoire;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class AdminSaveCell extends ListCell<SaveSlot> {

    HBox hbox = new HBox();
    Label ln = new Label(); // label avec le numero de l'emplacement de sauvegarde
    Label lp = new Label(); // label avec le pseudo du joueur
    Button del = new Button("Supprimer"); // bouton de suppression de sauvegarde

    /**
     * Constructeur. Paramètre l'apparence de la cellule
     */
    public AdminSaveCell() {

        super();

        // taille du conteneur
        hbox.setPrefSize(400, 40);

        // parametrage des tailles des labels
        ln.setPrefSize(160, 10);
        lp.setPrefSize(150, 10);

        // esthétique des éléments
        if (Settings.icon_color.equals("white")){
            ln.setStyle("-fx-text-fill: white; -fx-font-size: " + Settings.fontSize + "px;");
            lp.setStyle("-fx-text-fill: white; -fx-font-size: " + Settings.fontSize + "px;");
        } else {
            ln.setStyle("-fx-text-fill: black; -fx-font-size: " + Settings.fontSize + "px;");
            lp.setStyle("-fx-text-fill: black; -fx-font-size: " + Settings.fontSize + "px;");
        }

        // paramètrage du bouton de suppression
        del.setStyle("-fx-background-color: red; -fx-background-radius: 20; -fx-text-fill: white");
        del.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // confirmation
                Alert alert = new Alert(Alert.AlertType.WARNING, "Confirmez la suppression", ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> option = alert.showAndWait();

                if(option.get() == ButtonType.YES) {

                    // lecture
                    Memoire m = new Memoire();
                    Saves saves = (Saves) m.read_data(new File("resources/json/saves.json"));

                    // modification
                    int no_save = getIndex();
                    getListView().getItems().set(getIndex(), new SaveSlot(no_save, null));
                    saves.setSave(no_save, new SaveSlot(no_save, null));

                    // ecriture
                    try {
                        m.write_data(saves, new File("resources/json/saves.json"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // parametrage du placement hortizontal
        hbox.setMargin(ln, new Insets(0, 0, 0, 0));
        hbox.setMargin(lp, new Insets(0, 0, 0, 10));
        hbox.setMargin(del, new Insets(0, 0, 0, 10));

        // ajout de tous les éléments à afficher dans le classement des scores
        hbox.getChildren().addAll(ln, lp, del);

    }

    @Override
    public void updateItem (SaveSlot save, boolean empty) {

        super.updateItem(save, empty);

        setText(null);
        setGraphic(null);

        if (save != null && !empty) {
            ln.setText("Emplacement " + save.no + " : ");
            if (save.srgame!=null) {
                lp.setText(save.srgame.player.getPseudo());
            } else {
                lp.setText("Vide");
            }

            setGraphic(hbox);
        }

    }
}
