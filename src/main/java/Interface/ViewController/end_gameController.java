package Interface.ViewController;

import Interface.CellRenderer.EndGameRankCell;
import Interface.Save.SaveSlot;
import Interface.Save.Saves;
import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Engine;
import Interface.Settings.Settings;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import Partie.Game;
import Score.Ranking;
import Score.Score;
import Serialization.Memoire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;

public class end_gameController implements Controller {

    // ========================================== //
    // Déclaration des objets
    // ========================================== //
    @FXML
    private ImageView player_icon;

    @FXML
    private Label player_name_lbl;

    @FXML
    private ImageView diff_icon;

    @FXML
    private Label difficulty_lbl;

    @FXML
    private ImageView trophy_icon;

    @FXML
    private Label score_lbl;

    @FXML
    private ImageView rank_icon;

    @FXML
    private Label rank_lbl;

    @FXML
    private Button OK;

    @FXML
    private ListView<Score> ranking_list;

    // ========================================== //
    // Déclaration des objets
    // ========================================== //

    @FXML
    void go_to_home_screen(ActionEvent event) throws IOException {
        LoadMap gl = new LoadMap();
        gl.display_screen_from_id(LoadMap.HOME);
        WorldBoxDisc.pauseAllBackgroundSound();
        WorldBoxDisc.play(Son.menuTheme);
    }

    // ========================================== //
    // Méthodes d'initialisation
    // ========================================== //

    @Override
    public void init() {
        // icones
        player_icon.setImage(new Image("icons/"+ Settings.icon_color +"/user.png"));
        diff_icon.setImage(new Image("icons/"+ Settings.icon_color +"/shield.png"));
        trophy_icon.setImage(new Image("icons/"+ Settings.icon_color+ "/trophy.png"));
        rank_icon.setImage(new Image("icons/"+ Settings.icon_color+ "/ranking.png"));

        // Affichage du classement du scénario joué
        Memoire m = new Memoire();
        Ranking ranking = (Ranking) m.read_data(new File("resources/json/ranking.json"));

        // affichage des données de la partie
        // nom joueur
        player_name_lbl.setText(Game.player.getPseudo());

        // difficulté partie
        switch (Game.getDifficulty()) {
            case 0 : difficulty_lbl.setText("Facile"); break;
            case 1 : difficulty_lbl.setText("Normale"); break;
            case 2 : difficulty_lbl.setText("Difficile"); break;
        }

        // score de la partie
        if(Game.getDifficulty() == 0) {
            score_lbl.setText(String.valueOf(Engine.chrono.getTimeFullSeconds()));
        }
        if(Game.getDifficulty() == 1) {
            score_lbl.setText(String.valueOf(Engine.chrono.getTimeFullSeconds()*5));
        }
        if(Game.getDifficulty() == 2) {
            score_lbl.setText(String.valueOf(Engine.chrono.getTimeFullSeconds()*10));
        }

        // classement joueur
        int rank = -1; // non classé
        int score = Integer.parseInt(score_lbl.getText());
        for (int i = Ranking.RANKING_SIZE-1; i >= 0 ; i--) {
            if (ranking.ranking[i].value < score) {
                rank = i+1;
            }
        }

        rank_lbl.setWrapText(true);
        // si classé
        if (rank != -1) {
            ranking.add_score(new Score(player_name_lbl.getText(),score));
            rank_lbl.setText("Vous êtes "+ rank +"e ! Bravo !");
            try {
                m.write_data(ranking,new File("resources/json/ranking.json"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // sinon
        else {
            rank_lbl.setText("Vous ferez mieux la prochaine fois !");
        }

        // affichage du classement
        ObservableList<Score> recordObservableList = FXCollections.observableArrayList();
        for (int i = 0; i<10; i++) {
            recordObservableList.add(ranking.ranking[i]);
        }
        ranking_list.setItems(recordObservableList);
        ranking_list.setCellFactory(param -> new EndGameRankCell());

        // suppression de l'emplacement de sauvegarde
        Saves saves = (Saves) m.read_data(new File("resources/json/saves.json"));
        for (int i = 0; i < saves.getSaves().size(); i++) {
            if (saves.getSave(i).getSrgame() != null && saves.getSave(i).getSrgame().player.getPseudo().equals(Game.player.getPseudo())) {
                saves.setSave(i, new SaveSlot(i, null));
            }
        }

        try {
            m.write_data(saves, new File("resources/json/saves.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Game.reset_game();
    }

    @Override
    public void setShortcut() {
        // reset des anciens shortcut
        LoadMap.scene.getAccelerators().clear();
    }

    @Override
    public void apply_settings() {
        for (Node n: LoadMap.scene.getRoot().lookupAll(".Custom_label")) {
            n.setStyle("-fx-font-size: " + Settings.fontSize + "px;");
        }
    }
}
