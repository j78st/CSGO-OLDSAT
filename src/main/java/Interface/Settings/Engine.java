package Interface.Settings;

import Interface.ViewController.gameController;
import Timer.TimerController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class Engine {

    public static Parent game_root;
    public static gameController engine;
    public static TimerController chrono;

    public Engine() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/gameView.fxml"));

        game_root = loader.load();
        engine = loader.getController();
    }

}
