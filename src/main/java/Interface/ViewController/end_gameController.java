package Interface.ViewController;

import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Settings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import java.io.IOException;

public class end_gameController implements Controller {

    // ========================================== //
    // Déclaration des objets
    // ========================================== //

    @FXML
    private Text player_name_lbl;

    @FXML
    private Text difficulty_lbl;

    @FXML
    private Text score_lbl;

    @FXML
    private Button OK;

    @FXML
    private ImageView star_icon;


    // ========================================== //
    // Déclaration des objets
    // ========================================== //

    @FXML
    void go_to_home_screen(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(LoadMap.HOME);
    }

    // ========================================== //
    // Méthodes d'initialisation
    // ========================================== //

    @Override
    public void initialize() {
        // icones
        star_icon.setImage(new Image("icons/"+ Settings.icon_color+ "/star.png"));

        // affichage donnée partie
        player_name_lbl.setText(gameController.game.player.getPseudo());
        score_lbl.setText("1900");
        switch (gameController.game.getDifficulty()) {
            case 0 : difficulty_lbl.setText("Facile"); break;
            case 1 : difficulty_lbl.setText("Normal"); break;
            case 2 : difficulty_lbl.setText("Difficile"); break;
        }
    }

    @Override
    public void setShortcut() {

    }
}
