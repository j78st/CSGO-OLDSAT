package Interface.Settings;

import Music.Systems.WorldBoxDisc;
import Serialization.Memoire;
import Serialization.Serial_settings;

import java.io.File;
import java.io.Serializable;

public class Settings {

    // variables globales
    // Volume
    public static Double fx_volume; // volume des effets sonores
    public static Double bg_volume; // volume musique de fond

    // Apparence
    public static String icon_color; // couleur des icones -> "black" ou "white"
    public static String theme; // thème sélectionné
    public static int fontSize; // taille de la police des textes a afficher


    /** Cette méthode va récupérer les paramètre de l'application
     *  tels qu'ils étaient lors de sa dernière utilisation
     */
    public static void setSettingsFromFile() {
        Memoire m = new Memoire();

        // Récupération via mémoire.read
        Serial_settings settings = (Serial_settings) m.read_data(new File("resources/json/settings.json"));

        // Restauration
        fx_volume = settings.getFx_volume();
        bg_volume = settings.getBg_volume();
        icon_color = settings.getIcon_color();
        theme = settings.getTheme();
        fontSize = settings.getS();

        // application correctif son
        WorldBoxDisc.setSoundBackground(bg_volume);
        WorldBoxDisc.setSoundFx(fx_volume);
    }
}
