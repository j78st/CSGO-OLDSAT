package Interface.Settings;

import Serialization.Memoire;

import java.io.File;
import java.io.Serializable;

public class Settings implements Serializable {

    // variables globales
    // Volume
    public static Double fx_volume; // volume des effets sonores
    public static Double bg_volume; // volume musique de fond

    // Apparence
    public static String icon_color; // couleur des icones -> "black" ou "white"
    public static String theme; // thème sélectionné

    private String t;
    private String i;
    private Double f;
    private Double b;

    /** Cette méthode va récupérer les paramètre de l'application
     *  tels qu'ils étaient lors de sa dernière utilisation
     */
    public static void setSettingsFromFile() {

        Memoire m = new Memoire();
        File file = new File ("resources/json/settings.json");

        // Récupération via mémoire.read
        //GlobalSettings settings = (GlobalSettings) m.read_data(file);
        Settings settings = (Settings) m.read_data(file);

        // Restauration
        fx_volume = settings.getFx_volume();
        bg_volume = settings.getBg_volume();
        icon_color = settings.getIcon_color();
        theme = settings.getTheme();

    }
    public Double getBg_volume() {
        return b;
    }

    public Double getFx_volume() {
        return f;
    }

    public String getIcon_color() {
        return i;
    }

    public String getTheme() {
        return t;
    }


}
