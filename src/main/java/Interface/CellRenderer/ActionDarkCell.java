package Interface.CellRenderer;

import Partie.Action;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

public class ActionDarkCell extends ListCell<Action> {

    Label action_title = new Label(); // label avec la description de l'action

    /**
     * Constructeur. Paramètre le contenu de la cellule
     */
    public ActionDarkCell() {
        action_title.setPrefSize(700, 20);
        action_title.setStyle("-fx-text-fill: white; -fx-font-size: 20 px;");
    }

    /**
     * Mets a jour les données de la cellule
     * @param action élément dispensé dans la cellule
     * @param empty booléen indiquant si la case est vide
     */
    @Override
    public void updateItem (Action action, boolean empty) {

        super.updateItem(action, empty);

        setText(null);
        setGraphic(null);

        if (action != null && !empty) {
            action_title.setText(action.getText());
            setGraphic(action_title);
        }

    }

}


