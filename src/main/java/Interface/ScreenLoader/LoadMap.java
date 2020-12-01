package Interface.ScreenLoader;

import Interface.ViewController.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoadMap {

    // Mapping des vue via constantes globales
    public static final int HOME = 1;
    public static final int SETTINGS = 2;
    public static final int SCORES = 3;
    public static final int LAUNCHER = 4;
    public static final int LOAD_SAVE = 5;
    public static final int NEW_GAME_FORM = 6;
    public static final int GAME = 7;

    /**
     * L'appel a cette fonction permet d'avoir une structure "LoaderKit" qui correspond a l'ecran que l'on souhaite afficher.
     * Elle prend en paramètre l'identifiant de l'ecran a afficher.
     * @param loaderId
     * @return
     * @throws IOException
     */
    public LoadKit loaderMap(int loaderId) throws IOException {

        FXMLLoader loader;
        Parent parent;
        Scene scene;
        Controller controller;
        LoadKit kit = new LoadKit();

        switch(loaderId) {
            
            // écran d'accueil ======================================
            case HOME:
                // Creation des objets necessaires au chargement d'un ecran
                loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/view/home_screenView.fxml"));
                parent = loader.load();
                scene = new Scene(parent);
                controller = (home_screenController) loader.getController();

                // chargement du kit
                kit.setNext_scene(scene);
                kit.setNext_controller(controller);

                break;

            // écran des scores =====================================
            case SCORES:
                loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/view/score_screenView.fxml"));
                parent = loader.load();
                scene = new Scene(parent);
                controller = (score_screenController) loader.getController();
                kit.setNext_scene(scene);
                kit.setNext_controller(controller);
                break;

            // écran de lancement de partie =========================
            case LAUNCHER:
                loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/view/game_launcherView.fxml"));
                parent = loader.load();
                scene = new Scene(parent);
                controller = (game_launcherController) loader.getController();
                kit.setNext_scene(scene);
                kit.setNext_controller(controller);
                break;

            // écran de creation d'une nouvelle partie ==============
            case NEW_GAME_FORM:
                loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/view/new_game_formView.fxml"));
                parent = loader.load();
                scene = new Scene(parent);
                controller = (new_game_formController) loader.getController();
                kit.setNext_scene(scene);
                kit.setNext_controller(controller);
                break;

            // écran de creation d'une nouvelle partie ==============
            case GAME:
                loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/view/gameView.fxml"));
                parent = loader.load();
                scene = new Scene(parent);
                controller = (gameController) loader.getController();
                kit.setNext_scene(scene);
                kit.setNext_controller(controller);
                break;

            // écran de chargement d'une sauvegarde ==============
            case LOAD_SAVE:
                loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/view/load_saveView.fxml"));
                parent = loader.load();
                scene = new Scene(parent);
                controller = (load_saveController) loader.getController();
                kit.setNext_scene(scene);
                kit.setNext_controller(controller);
                break;

        }
        return kit;
    }

    /**
     * L'appel a cette fonction affiche l'ecran d'identifiant "ID" sur le stage souhaité.
     * @param nextID
     * @param stage
     * @throws IOException
     */
    public void display_screen_from_id (int nextID,Stage stage) throws IOException {
        LoadMap gl = new LoadMap();
        LoadKit kit = gl.loaderMap(nextID);
        Scene scene = kit.getNext_scene();

        Controller controller = kit.getNext_controller();
        controller.initialize();
        controller.setShortcut();

        stage.setTitle("OLD'SAT");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * méthode à utiliser pour afficher le menu des paramètres
     * @param previous_id l'id de l'écran d'où on affiche les paramètres
     * @param stage fenêtre d'affichage du menu
     * @throws IOException
     */
    public void display_settings_menu(int previous_id,Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/settings_menuView.fxml"));

        Parent homeParent = loader.load();
        Scene home_screen = new Scene(homeParent);

        settings_menuController controller = loader.getController();
        controller.provide_current_screen_id(previous_id); // ID de l'écran ou on appelle les paramètres

        stage.setTitle("OLD'SAT");
        stage.setScene(home_screen);
        stage.show();
    }

}
