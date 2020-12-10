
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Settings;
import Interface.ViewController.home_screenController;
import Music.Systems.WorldBoxDisc;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{

        // Déclaration de la fenêtre utilisée pour l'application
        LoadMap.stage = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/home_screenView.fxml"));

        Parent root = loader.load();

        // Déclaration de la scène utlisée pour l'application
        LoadMap.scene = new Scene(root);

        home_screenController controller = loader.getController();
        controller.initialize();
        controller.setShortcut();

        LoadMap.scene.getStylesheets().add("/CSS/"+ Settings.theme +".css");

        primaryStage.setScene(LoadMap.scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws InterruptedException {

        // Récupération des paramètres
        Settings.setSettingsFromFile();

        //Initialise le systeme de son
        WorldBoxDisc.init();
        Thread.sleep(3000);

        //WorldBoxDisc.setSoundFx(Settings.fx_volume);
        //WorldBoxDisc.setSoundBackground(Settings.bg_volume);

        launch(args);

    }

}
