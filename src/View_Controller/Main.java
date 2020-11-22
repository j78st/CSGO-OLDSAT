package View_Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("home_screenView.fxml"));

        Parent homeParent = loader.load();
        Scene home_screen = new Scene(homeParent);

        home_screenController controller = loader.getController();
        controller.init();

        primaryStage.setTitle("OLD'SAT");
        primaryStage.setScene(home_screen);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
