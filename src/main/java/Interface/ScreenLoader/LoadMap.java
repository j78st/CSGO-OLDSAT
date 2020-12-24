package Interface.ScreenLoader;

import Interface.Settings.Engine;
import Interface.ViewController.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoadMap {

    // Déclaration fenêtre/scène utlisées (uniques)
    public static Stage stage;
    public static Scene scene;

    // Mapping des vue via constantes globales
    public static final int HOME = 1;
    public static final int SETTINGS = 2;
    public static final int SCORES = 3;
    public static final int LAUNCHER = 4;
    public static final int LOAD_SAVE = 5;
    public static final int NEW_GAME_FORM = 6;
    public static final int GAME = 7;
    public static final int END_GAME = 8;

    /**
     * L'appel a cette fonction permet d'avoir une structure "LoaderKit" qui correspond a l'ecran que l'on souhaite afficher.
     * Elle prend en paramètre l'identifiant de l'ecran a afficher.
     * @param loaderId Id de l'écran vers lequel on va
     * @return retourne le kit nécéssaire au chargement de l'écran
     * @throws IOException
     */
    public LoadKit loaderMap(int loaderId) throws IOException {

        FXMLLoader loader;
        Parent root;
        Controller controller;
        LoadKit kit = new LoadKit();

        switch(loaderId) {
            
            // écran d'accueil ======================================
            case HOME:
                // Creation des objets necessaires au chargement d'un ecran
                loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/home_screenView.fxml"));

                root = loader.load(); // récupération de la racine
                controller = (home_screenController) loader.getController(); // récupération du controlleur associé

                // chargement du kit
                kit.setNext_root(root);
                kit.setNext_controller(controller);

                break;

            // écran des scores =====================================
            case SCORES:
                loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/score_screenView.fxml"));
                root = loader.load();
                controller = (score_screenController) loader.getController();
                kit.setNext_root(root);
                kit.setNext_controller(controller);
                break;

            // écran de lancement de partie =========================
            case LAUNCHER:
                loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/game_launcherView.fxml"));
                root = loader.load();
                controller = (game_launcherController) loader.getController();
                kit.setNext_root(root);
                kit.setNext_controller(controller);
                break;

            // écran de creation d'une nouvelle partie ==============
            case NEW_GAME_FORM:
                loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/new_game_formView.fxml"));
                root = loader.load();
                controller = (new_game_formController) loader.getController();
                kit.setNext_root(root);
                kit.setNext_controller(controller);
                break;

            // écran de la partie ==============
            case GAME:
                loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/gameView.fxml"));
                root = Engine.game_root;
                controller = Engine.engine;
                kit.setNext_root(root);
                kit.setNext_controller(controller);
                break;

            // écran de chargement d'une sauvegarde ==============
            case LOAD_SAVE:
                loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/load_saveView.fxml"));
                root = loader.load();
                controller = (load_saveController) loader.getController();
                kit.setNext_root(root);
                kit.setNext_controller(controller);
                break;

            // écran de chargement d'une sauvegarde ==============
            case END_GAME:
                loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/end_gameView.fxml"));
                root = loader.load();
                controller = (end_gameController) loader.getController();
                kit.setNext_root(root);
                kit.setNext_controller(controller);
                break;

        }
        return kit;
    }

    /**
     * L'appel a cette fonction affiche l'ecran d'identifiant "ID" sur le stage.
     * @param nextID
     * @throws IOException
     */
    public void display_screen_from_id (int nextID) throws IOException {
        // récupération du kit de chargement
        LoadMap gl = new LoadMap();
        LoadKit kit = gl.loaderMap(nextID);

        // initialisation de la nouvelle vue
        Controller controller = kit.getNext_controller();
        controller.initialize();
        controller.setShortcut();


        // affichage
        stage.setTitle("OLD'SAT");
        stage.getScene().setRoot(kit.getNext_root());

        controller.apply_settings();

        stage.show();
    }

    /**
     * méthode à utiliser pour afficher le menu des paramètres
     * @param previous_id l'id de l'écran d'où on affiche les paramètres
     * @throws IOException
     */
    public void display_settings_menu(int previous_id) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/settings_menuView.fxml"));

        Parent parent = loader.load();

        settings_menuController controller = loader.getController();
        controller.provide_current_screen_id(previous_id); // ID de l'écran ou on appelle les paramètres
        controller.setShortcut();

        if (gameController.game != null){
            Engine.engine.refreshText();
            Engine.engine.refreshAction();
        }

        stage.setTitle("OLD'SAT");
        stage.getScene().setRoot(parent);

        controller.apply_settings();

        stage.show();
    }

}
