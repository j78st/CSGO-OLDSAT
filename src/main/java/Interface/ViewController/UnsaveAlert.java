package Interface.ViewController;

import Interface.ScreenLoader.LoadMap;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Optional;

// =================================== //
// Pop up de gestion des sortie de jeu //
// =================================== //

public class UnsaveAlert {

    Alert alert = new Alert(Alert.AlertType.WARNING);
    ButtonType yes = new ButtonType("oui");
    ButtonType no = new ButtonType("non");
    ButtonType undo = new ButtonType("annuler");

    /**
     * Pop up demandant si le joueur veut sauvegarder sa partie avant de quitter l'application
     * @throws InterruptedException
     */
    public void exitGame() throws InterruptedException {
        alert.setTitle("OLD'SAT");
        alert.setHeaderText("Vous allez quittez l'application.\nSouhaitez vous sauvegarder ?");

        // Remove default ButtonTypes
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(yes, no, undo);

        // traitement de la réponse
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() != undo) {
            if (option.get() == yes) {

                // VVV sauvegarde VVV

                System.out.println("sauvegarde...");
                Thread.sleep(3000);
            }

            // fermeture de l'application
            LoadMap.stage.close();
        }
    }

    /**
     * Pop up demandant si le joueur veut sauvegarder sa partie avant de revenir à l'accueil
     * @throws InterruptedException
     */
    public void homeScreen(Stage stage) throws InterruptedException, IOException {

        alert.setTitle("OLD'SAT");
        alert.setHeaderText("Vous allez revenir à l'accueil.\nSouhaitez vous sauvegarder ?");

        // Remove default ButtonTypes
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(yes, no, undo);

        // traitement de la réponse
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() != undo) {
            if (option.get() == yes) {

                // VVV sauvegarde VVV

                System.out.println("sauvegarde...");
                Thread.sleep(3000);
            }

            // retour écran accueil
            LoadMap gl = new LoadMap();
            gl.display_screen_from_id(LoadMap.HOME);
        }
    }
}
