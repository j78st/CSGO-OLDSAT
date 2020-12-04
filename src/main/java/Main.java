import Interface.ScreenLoader.LoadMap;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(LoadMap.HOME,primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
