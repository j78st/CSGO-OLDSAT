package Interface.CellRenderer;

import Interface.Settings.Settings;
import Score.Score;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

public class RecordListCell extends ListCell<Score> {

    HBox hbox = new HBox();
    Label lr = new Label(); // label avec le rang du joueur au classement
    Label lp = new Label(); // label avec le pseudo du joueur
    Label ls = new Label(); // label avec le score du joueur

    /**
     * Constructeur. Paramètre le contenu de la cellule
     */
    public RecordListCell() {

        super();

        // instanciation de la Hbox
        hbox.setPrefSize(460, 20);

        if (Settings.icon_color.equals("white")){
            lr.setStyle("-fx-text-fill: white; -fx-font-size: " + Settings.fontSize + "px;");
            lp.setStyle("-fx-text-fill: white; -fx-font-size: " + Settings.fontSize + "px;");
            ls.setStyle("-fx-text-fill: white; -fx-font-size: " + Settings.fontSize + "px;");
        } else {
            lr.setStyle("-fx-text-fill: black; -fx-font-size: " + Settings.fontSize + "px;");
            lp.setStyle("-fx-text-fill: black; -fx-font-size: " + Settings.fontSize + "px;");
            ls.setStyle("-fx-text-fill: black; -fx-font-size: " + Settings.fontSize + "px;");
        }

        // parametrage des tailles des labels
        lr.setPrefSize(50, 10);
        lp.setPrefSize(100, 10);
        ls.setPrefSize(70, 10);

        // parametrage du placement hortizontal
        hbox.setMargin(lr, new Insets(0, 0, 0, 0));
        hbox.setMargin(lp, new Insets(0, 270, 0, 0));
        hbox.setMargin(ls, new Insets(0, 0, 0, 0));

        // ajout de tous les éléments à afficher dans le classement des scores
        hbox.getChildren().addAll(lr, lp, ls);

    }

    /**
     * Mets a jour les données de la cellule
     * @param record élément dispensé dans la cellule
     * @param empty booléen indiquant si la case est vide
     */
    public void updateItem (Score record, boolean empty) {

        super.updateItem(record, empty);

        setText(null);
        setGraphic(null);

        if (record != null && !empty) {
            lr.setText(record.rank + " - ");
            lp.setText(record.pseudo);
            ls.setText(String.valueOf(record.value));
            setGraphic(hbox);
        }

    }

}
