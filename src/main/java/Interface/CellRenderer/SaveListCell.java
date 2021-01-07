package Interface.CellRenderer;

import Interface.Save.SaveSlot;
import Interface.Settings.Settings;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

public class SaveListCell extends ListCell<SaveSlot> {

    HBox hbox = new HBox();
    Label ln = new Label(); // label avec le numero de l'emplacement de sauvegarde
    Label lp = new Label(); // label avec le pseudo du joueur

    /**
     * Constructeur. Paramètre le contenu de la cellule
     */
    public SaveListCell() {

        super();

        // taille du conteneur
        hbox.setPrefSize(360, 20);

        // parametrage des tailles des labels
        ln.setPrefSize(120, 10);
        lp.setPrefSize(150, 10);

        // couleur du texte
        if (Settings.icon_color.equals("white")){
            ln.setStyle("-fx-text-fill: white; -fx-font-size: " + Settings.fontSize + "px;");
            lp.setStyle("-fx-text-fill: white; -fx-font-size: " + Settings.fontSize + "px;");
        } else {
            ln.setStyle("-fx-text-fill: black; -fx-font-size: " + Settings.fontSize + "px;");
            lp.setStyle("-fx-text-fill: black; -fx-font-size: " + Settings.fontSize + "px;");
        }

        // parametrage du placement hortizontal
        hbox.setMargin(ln, new Insets(0, 0, 0, 0));
        hbox.setMargin(lp, new Insets(0, 0, 0, 10));

        // ajout de tous les éléments à afficher dans le classement des scores
        hbox.getChildren().addAll(ln, lp);

    }

    /**
     * Mets a jour les données de la cellule
     * @param save élément dispensé dans la cellule
     * @param empty booléen indiquant si la case est vide
     */
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
