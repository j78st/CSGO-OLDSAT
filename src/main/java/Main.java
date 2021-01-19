import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Engine;
import Interface.Settings.Settings;
import Interface.ViewController.home_screenController;
import Music.Systems.WorldBoxDisc;
import Partie.Game;
import Partie.Player;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
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

        LoadMap.stage.getIcons().add(new Image("/icons/icon_csgo.png"));
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


        // EventHandler pour récupérer la zone de clic (sert aux énigmes point and click)

        EventHandler<javafx.scene.input.MouseEvent> eventHandler = new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                try {
                    Game.mouse_clicked((mouseEvent.getX()/LoadMap.scene.getWidth()), (mouseEvent.getY()/LoadMap.scene.getHeight()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        LoadMap.scene.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_CLICKED, eventHandler);
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        // lancement application
        launch(args);
    }

}
