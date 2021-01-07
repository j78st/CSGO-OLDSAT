package Interface.ViewController;

import Interface.CellRenderer.SaveListCell;
import Interface.Save.SaveSlot;
import Interface.Save.Saves;
import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Engine;
import Interface.Settings.Settings;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import Serialization.Memoire;
import Serialization.Serial_game;
import Timer.TimerController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import Partie.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class new_game_formController implements Controller {

    private ObservableList<SaveSlot> saveObservableList;
    private ObservableList<String> difficulty;

    @FXML
    private TextField name_selector;

    @FXML
    private ComboBox difficulty_selector;

    @FXML
    private ListView<SaveSlot> save_list;

    @FXML
    private Button settings_btn;

    @FXML
    private Button return_btn;

    @FXML
    private ImageView difficulty_icon;

    @FXML
    private ImageView profile_icon;

    /**
     * Lors de l'appui sur le bouton RETOUR
     * @param event
     * @throws IOException
     */
    @FXML
    void go_back_to_launch_screen(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(LoadMap.LAUNCHER);
        WorldBoxDisc.play(Son.menuClose);
    }

    /**
     * Lors de l'appui sur le bouton PARAMETRES
     * @param event
     * @throws IOException
     */
    @FXML
    void go_to_settings_menu(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        gl.display_settings_menu(LoadMap.NEW_GAME_FORM);
        WorldBoxDisc.play(Son.menuOpen);
    }

    /**
     * Lors de l'appui sur le bouton CREER PARTIE
     * Crée une nouvelle partie sur l'emplacement de sauvegarde sélectionné
     * avec le pseudo et difficulté sélectionnés.
     * @param event
     * @throws IOException
     */
    @FXML
    void create_game(ActionEvent event) throws IOException {
        boolean saveSlotSelected = false;
        boolean nameWritten = false;

        String pseudo = "";
        int difficulty;
        SaveSlot save = new SaveSlot();

        // récupère le pseudo si il est renseigné et teste sa validité
        pseudo = name_selector.getText();
        if (pseudo.equals("")) {
            nameWritten = false;
            Alert nameAlert = new Alert(Alert.AlertType.WARNING, "Inscrivez votre nom !", ButtonType.OK);
            nameAlert.showAndWait();
        } else {
            nameWritten = true;
        }

        // récupère la difficulté de la nouvelle partie
        switch ((String)difficulty_selector.getValue()) {
            case "Facile": difficulty = 0; break;
            case "Normale" : difficulty = 1; break;
            case "Difficile" : difficulty = 2; break;
            default:
                throw new IllegalStateException("Unexpected value: " + difficulty_selector.getPromptText());
        }

        // Récupère l'emplacement de sauvegarde pour stocker la partie
        if (save_list.getSelectionModel().getSelectedItem()!=null) {
            save = save_list.getSelectionModel().getSelectedItem();
            saveSlotSelected = true;
        } else {
            saveSlotSelected = false;
            Alert alert = new Alert(Alert.AlertType.WARNING, "Selectionnez un emplacement de sauvegarde !", ButtonType.OK);
            alert.showAndWait();
        }

        // SI le formulaire est correcte on crée la partie, SINON rien tant que pas correct
        if ( nameWritten && saveSlotSelected) {
            // === Création de la partie === //
            Game game = creer_partie(pseudo, difficulty);
            gameController.game = game;
            Engine.engine.refreshRoom();

            // === Sauvegarde de la partie === //
            Memoire m = new Memoire();
            Saves saves = (Saves) m.read_data(new File("resources/json/saves.json"));
            save.srgame = new Serial_game();
            saves.setSave(save.no,save);
            m.write_data(saves, new File("resources/json/saves.json"));

            // === Lancement de la partie === //
            // affichage jeu
            LoadMap gl = new LoadMap();
            gl.display_screen_from_id(LoadMap.GAME);

            // son validation
            WorldBoxDisc.play(Son.valid);

            // lancement timer
            Engine.chrono = new TimerController(70);
            Engine.chrono.start();
        }
    }

    @Override
    public void initialize() {

        // mise en place des icones
        settings_btn.setGraphic(new ImageView(new Image("icons/"+ Settings.icon_color +"/settings_icon.png")));
        return_btn.setGraphic(new ImageView(new Image("icons/"+ Settings.icon_color +"/return.png")));
        profile_icon.setImage(new Image("icons/"+ Settings.icon_color+ "/profile.png"));
        difficulty_icon.setImage(new Image("icons/"+ Settings.icon_color+ "/shield.png"));

        // mise en place selection difficulté
        difficulty = FXCollections.observableArrayList("Facile", "Normale", "Difficile");
        difficulty_selector.setItems(difficulty);
        difficulty_selector.setValue("Normale");

        // mise en place de la liste des sauvegarde
        saveObservableList = FXCollections.observableArrayList();
        Memoire m = new Memoire();
        Saves saves = (Saves) m.read_data(new File("resources/json/saves.json"));

        for (int i = 0; i<10; i++) {
            saveObservableList.add(saves.getSave(i));
        }

        save_list.setItems(saveObservableList);
        save_list.setCellFactory(param -> new SaveListCell());
    }

    /**
     * Définition et intégration des raccourcis possibles sur la scene
     */
    @Override
    public void setShortcut() {
        // Acces au paramètres via ESC
        KeyCombination kc = new KeyCodeCombination(KeyCode.ESCAPE, KeyCombination.SHIFT_ANY);
        Runnable rn = ()-> settings_btn.fire();
        LoadMap.scene.getAccelerators().put(kc, rn);
    }

    @Override
    public void apply_settings() {
        for (Node n: LoadMap.scene.getRoot().lookupAll(".Custom_label")) {
            n.setStyle("-fx-font-size: " + Settings.fontSize + "px;");
        }
    }

    public Game creer_partie(String pseudo, int difficulty){

        Player player1 = new Player(pseudo);
        Game game_test = new Game(player1,difficulty);
        Scenario scenar = new Scenario();

        Room room1 = new Room(1001,1002,-1,-1,-1,true,0,"path");
        Room room2 = new Room(1002,-1,1003,1001,-1,true,0,"path");
        Room room3 = new Room(1003,-1,-1,-1,1002,true,0,"path");

        /* Room room1 = new Room(1001,1002,-1,-1,-1,true,10011,"pictures/Salle1.png"); //première salle
        Room room2 = new Room(1002,-1,-1,1001,-1, false,10021,"pictures/Salle2.png"); //deuxième salle
        Room room1_1 = new Room(2001,1001,20011,"pictures/Table.png"); //table dans salle 1
        Room room1_2 = new Room(2002,1001,20021,"pictures/Porte.png"); //porte dans salle 1
        Room room1_1_1 = new Room(2003,2001,20031,"pictures/Vase.png"); //vase sur table dans salle 1


        //Enigme de la salle 102
        ArrayList<int[]> consequences_enigme1 = new ArrayList<>();
        consequences_enigme1.add(new int[]{10}); // fin de partie
        Enigma enigme1 = new Enigma(3001,1002,30011,"pictures/Tableau.png",2022,consequences_enigme1);


        //Création des objets
        Item objet1 = new Item(1,"clef","Clef ancienne, sert probablement pour déverouiller une serrure",1, "objects/key.png");


        //Actions de la salle 1001
        ArrayList<int[]> consequences_action1001_1 = new ArrayList<>();
        consequences_action1001_1.add(new int[]{1,2001});
        Action action1001_1 = new Action(10011,true,"Examiner la table", consequences_action1001_1, 1001); //déplacement vers table, 1001 à 2001

        ArrayList<int[]> consequences_action1001_2 = new ArrayList<>();
        consequences_action1001_2.add(new int[]{1,2002});
        Action action1001_2 = new Action(10012,true,"Examiner la porte", consequences_action1001_2, 1001); //déplacement vers la porte, 1001 à 2002


        //Actions de la salle 2001 (table)
        ArrayList<int[]> consequences_action2001_1 = new ArrayList<>();
        consequences_action2001_1.add(new int[]{1,2003});
        Action action2001_1 = new Action(20011,true,"Examiner le vase", consequences_action2001_1, 2001); //déplacement vers le vase, 2001 à 2003


        //Actions de la salle 2003 (vase)
        ArrayList<int[]> consequences_action2003_1 = new ArrayList<>();
        consequences_action2003_1.add(new int[]{4,1});
        consequences_action2003_1.add(new int[]{3,20011});
        consequences_action2003_1.add(new int[]{1,2001});
        consequences_action2003_1.add(new int[]{7,20012});
        Action action2003_1 = new Action(20031,true,"Récupérer la clef", consequences_action2003_1, 2003); // ajout de la clef à l'inventaire, déplacement vers salle précédente (201) puis mise à jour du texte de cette salle  et verrouillage de l'action permettant d'examiner le vase


        //Actions de la salle 2002 (porte)
        ArrayList<int[]> consequences_action2002_1 = new ArrayList<>();
        consequences_action2002_1.add(new int[]{7,20022});
        consequences_action2002_1.add(new int[]{3,20021});
        Action action2002_1 = new Action(20021,true,"Essayer d'enfoncer la porte", consequences_action2002_1, 2002); //mise à jour du texte

        ArrayList<int[]> consequences_action2002_2 = new ArrayList<>();
        consequences_action2002_2.add(new int[]{6,1});
        consequences_action2002_2.add(new int[]{9,1002});
        consequences_action2002_2.add(new int[]{3,10012});
        consequences_action2002_2.add(new int[]{1,1001});
        consequences_action2002_2.add(new int[]{7,10012});
        Action action2002_2 = new Action(20022,"Utiliser la clef", consequences_action2002_2, 2002, 1); //ajoute une utilisation à la clef, dévérouille l'action permetant d'accéder à 102 depuis 101, bloque action d'examiner la porte depuis 101, ajoute texte à salle 101, retour dans 101


        //Actions de la salle 1002
        ArrayList<int[]> consequences_action1002_1 = new ArrayList<>();
        consequences_action1002_1.add(new int[]{1,3001});
        consequences_action1002_1.add(new int[]{10});
        Action action1002_1 = new Action(10021,true,"Examiner le tableau", consequences_action1002_1, 1002); //déplacement vers table, 102 à 301

        //Actions de l'énigme 3001
        ArrayList<int[]> consequences_action3001_1 = new ArrayList<>();
        consequences_action3001_1.add(new int[]{7,30012});
        consequences_action3001_1.add(new int[]{3,30011});
        Action action3001_1 = new Action(30011,true,"Demander un indice", consequences_action3001_1, 3001); //mise à jour du texte

         */

        // Son ambiance
        WorldBoxDisc.pause(Son.feu);
        WorldBoxDisc.play(Son.wind);

        return game_test;
    }


}
