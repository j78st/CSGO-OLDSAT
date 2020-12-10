package Interface.ViewController;

import Interface.Ranking.SaveListCell;
import Interface.Save.SaveSlot;
import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Settings;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import Partie.*;

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
        String pseudo = "";
        String difficulty;
        SaveSlot save = new SaveSlot();

        // récupère le pseudo si il est renseigné et teste sa validité
        try {
            pseudo = name_selector.getText();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Inscrivez votre nom !", ButtonType.OK);
            alert.showAndWait();
        }

        // récupère la difficulté de la nouvelle partie
        difficulty = difficulty_selector.getPromptText();

        // récupère l'emplacement de sauvegarde pour stocker la partie
        try {
            save = save_list.getSelectionModel().getSelectedItem();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Selectionnez un emplacement de sauvegarde !", ButtonType.OK);
            alert.showAndWait();
        }

        // vvv REMPLACEMENT DU FICHIER DE SAUVEGARDE ICI   vvv

        // Création de la partie

        creer_partie();

        // vvv LANCEMENT DE LA PARTIE ICI vvv
        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(LoadMap.GAME);
        WorldBoxDisc.play(Son.valid);

    }

    @Override
    public void initialize() {

        // mise en place des icones
        settings_btn.setGraphic(new ImageView(new Image("icons/"+ Settings.icon_color +"/settings_icon.png")));
        return_btn.setGraphic(new ImageView(new Image("icons/"+ Settings.icon_color +"/return.png")));
        profile_icon.setImage(new Image("icons/"+ Settings.icon_color+ "/profile.png"));
        difficulty_icon.setImage(new Image("icons/"+ Settings.icon_color+ "/shield.png"));

        // mise en place selection difficulté
        difficulty = FXCollections.observableArrayList("Facile", "Normal", "Difficile");
        difficulty_selector.setItems(difficulty);
        difficulty_selector.setValue("Normal");

        // mise en place de la liste des sauvegarde
        saveObservableList = FXCollections.observableArrayList();

            // ======= vvv /!\ LISTE DE SAUVEGARDE TEST vvv =======
            for (int i = 0; i<10; i++) {
                saveObservableList.add(new SaveSlot(i,"pseudo "+i));
            }
            // ====================================================

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

    public void creer_partie(){

        Player player1 = new Player("joueur_test");
        Game game_test = new Game(player1,0);

        Scenario scenar = new Scenario();

        ArrayList<String> sounds_test = new ArrayList<>();

        Room room1 = new Room(1011,"url1",101,102,-1,-1,-1,sounds_test, true); //première salle
        Room room2 = new Room(1021,"url2",102,-1,-1,101,-1,sounds_test, false); //deuxième salle
        Room room1_1 = new Room(2011,"url11",201,101,sounds_test); //table dans salle 1
        Room room1_2 = new Room(2021,"url12",202,101,sounds_test); //porte dans salle 1
        Room room1_1_1 = new Room(2031,"url13",203,201,sounds_test); //vase sur table dans salle 1


//Enigme de la salle 102

        ArrayList<int[]> consequences_enigme1 = new ArrayList<>();
        consequences_enigme1.add(new int[]{7,0}); //où 7 code l'affichage de l'écran de endgame
        Enigma enigme1 = new Enigma(3011,"url13",301,102,2022,consequences_enigme1,sounds_test);


//Création des objets

        Gear objet1 = new Gear(1,"clef","Clef ancienne, sert probablement pour déverouiller une serrure",1, "objects/key.png");


//Actions de la salle 101

        ArrayList<int[]> consequences_action1012 = new ArrayList<>();
        consequences_action1012.add(new int[]{1,201});
        Action action1012 = new Action(1012,"Examiner la table", consequences_action1012, 101, true); //déplacement vers table, 101 à 201

        ArrayList<int[]> consequences_action1013 = new ArrayList<>();
        consequences_action1013.add(new int[]{1,202});
        Action action1013 = new Action(1013,"Examiner la porte", consequences_action1013, 101, true); //déplacement vers la porte, 101 à 202


//Actions de la salle 201 (table)

        ArrayList<int[]> consequences_action2012 = new ArrayList<>();
        consequences_action2012.add(new int[]{1,203});
        Action action2012 = new Action(2012,"Examiner le vase", consequences_action2012, 201, true); //déplacement vers le vase, 201 à 203


//Actions de la salle 203 (vase)

        ArrayList<int[]> consequences_action2031 = new ArrayList<>();
        consequences_action2031.add(new int[]{4,1});
        consequences_action2031.add(new int[]{3,2012});
        consequences_action2031.add(new int[]{1,201});
        consequences_action2031.add(new int[]{7,2012});
        Action action2031 = new Action(2031,"Récupérer la clef", consequences_action2031, 203, true); // ajout de la clef à l'inventaire, déplacement vers salle précédente (201) puis mise à jour du texte de cette salle  et verrouillage de l'action permettant d'examiner le vase


//Actions de la salle 202 (porte)

        ArrayList<int[]> consequences_action2022 = new ArrayList<>();
        consequences_action2022.add(new int[]{7,2022});
        consequences_action2022.add(new int[]{3,2022});
        Action action2022 = new Action(2022,"Essayer d'enfoncer la porte", consequences_action2022, 202, true); //mise à jour du texte

        ArrayList<int[]> consequences_action2023 = new ArrayList<>();
        consequences_action2023.add(new int[]{6,1});
        consequences_action2023.add(new int[]{9,102});
        consequences_action2023.add(new int[]{3,1013});
        consequences_action2023.add(new int[]{7,1012});
        consequences_action2023.add(new int[]{1,101});
        Action action2023 = new Action(2023,"Utiliser la clef", consequences_action2023, 202, 1); //ajoute une utilisation à la clef, dévérouille l'action permetant d'accéder à 102 depuis 101, bloque action d'examiner la porte depuis 101, ajoute texte à salle 101, retour dans 101


//Actions de la salle 102

        ArrayList<int[]> consequences_action1022 = new ArrayList<>();
        consequences_action1022.add(new int[]{1,301});
        Action action1022 = new Action(1022,"Examiner le tableau", consequences_action1022, 102, true); //déplacement vers table, 102 à 301

//Actions de l'énigme 301

        ArrayList<int[]> consequences_action3011 = new ArrayList<>();
        consequences_action3011.add(new int[]{7,3012});
        consequences_action3011.add(new int[]{3,3011});
        Action action3011 = new Action(3011,"Demander un indice", consequences_action3011, 301, true); //mise à jour du texte

        gameController.game = game_test;
    }

}
