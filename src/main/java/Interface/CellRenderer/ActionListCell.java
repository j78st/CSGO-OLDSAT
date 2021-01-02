package Interface.CellRenderer;

import Interface.Settings.Settings;
import Partie.Action;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

public class ActionListCell extends ListCell<Action> {

    Label action_title = new Label(); // label avec la description de l'action

    public ActionListCell() {
        super();
        // couleur du texte
        if (Settings.icon_color.equals("white")){
            action_title.setStyle("-fx-text-fill: white; -fx-font-size: " + Settings.fontSize + "px;");
        } else {
            action_title.setStyle("-fx-text-fill: black; -fx-font-size: " + Settings.fontSize + "px;");
        }
    }

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
