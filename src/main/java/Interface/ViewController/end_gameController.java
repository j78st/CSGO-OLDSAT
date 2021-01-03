package Interface.ViewController;

import Interface.CellRenderer.EndGameRankCell;
import Interface.ScreenLoader.Controller;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Settings;
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
    private Text player_name_lbl;

    @FXML
    private ImageView diff_icon;

    @FXML
    private Text difficulty_lbl;

    @FXML
    private ImageView trophy_icon;

    @FXML
    private Text score_lbl;

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
    }

    // ========================================== //
    // Méthodes d'initialisation
    // ========================================== //

    @Override
    public void initialize() {
        // icones
        player_icon.setImage(new Image("icons/"+ Settings.icon_color +"/user.png"));
        diff_icon.setImage(new Image("icons/"+ Settings.icon_color +"/shield.png"));
        trophy_icon.setImage(new Image("icons/"+ Settings.icon_color+ "/trophy.png"));
        rank_icon.setImage(new Image("icons/"+ Settings.icon_color+ "/ranking.png"));

        // Affichage du classement du scérnario joué
        Memoire m = new Memoire();
        Ranking ranking = (Ranking) m.read_data(new File("resources/json/ranking.json"));

        // affichage du classement
        ObservableList<Score> recordObservableList = FXCollections.observableArrayList();
        for (int i = 0; i<10; i++) {
            recordObservableList.add(ranking.ranking[i]);
        }
        ranking_list.setItems(recordObservableList);
        ranking_list.setCellFactory(param -> new EndGameRankCell());

        // affichage des données de la partie
        // nom joueur
        player_name_lbl.setText(gameController.game.player.getPseudo());

        // difficulté partie
        switch (gameController.game.getDifficulty()) {
            case 0 : difficulty_lbl.setText("Facile"); break;
            case 1 : difficulty_lbl.setText("Normale"); break;
            case 2 : difficulty_lbl.setText("Difficile"); break;
        }

        // score de la partie
        score_lbl.setText("0");

        // classement joueur dans la catégorie concernée
        int rank = -1; // non classé
        int score = Integer.parseInt(score_lbl.getText());
        for (int i = Ranking.RANKING_SIZE-1; i >= 0 ; i--) {
            if (ranking.ranking[i].value < score) {
                rank = i;
            }
        }

        rank_lbl.setWrapText(true);
        // si classé
        if (rank != -1) {
            ranking.add_score(new Score(player_name_lbl.getText(),score/10));
            rank_lbl.setText("Vous êtes "+ (rank+1) +"e ! Bravo !");
        }
        // sinon
        else {
            rank_lbl.setText("Vous n'êtes pas dans le top \npeut-être la prochaine fois !");
        }
    }

    @Override
    public void setShortcut() {

    }

    @Override
    public void apply_settings() {
        for (Node n: LoadMap.scene.getRoot().lookupAll(".Custom_label")) {
            n.setStyle("-fx-font-size: " + Settings.fontSize + "px;");
        }
    }
}
