import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Engine;
import Interface.Settings.Settings;
import Interface.ViewController.home_screenController;
import Music.Systems.WorldBoxDisc;
import Partie.Game;
import Partie.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Deplacement de la partie initialisation pour le lancement du jar
        //Initialise le système de son
        WorldBoxDisc.init();
        Thread.sleep(1000);

        // Récupération des paramètres
        Settings.setSettingsFromFile();

        Engine oui = new Engine();
        Game non = new Game(new Player(""),0);

        // Déclaration de la fenêtre utilisée pour l'application
        LoadMap.stage = primaryStage;
        LoadMap.stage.setMaximized(true);
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
        primaryStage.setTitle("OLD'SAT");
        primaryStage.show();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        // lancement application
        launch(args);
    }

}
