package Interface.Settings;

public class Settings {

    // Volume
    public static Double fx_volume; // volume des effets sonores
    public static Double bg_volume; // volume musique de fond

    // Apparence
    public static String icon_color; // couleur des icones -> "black" ou "white"
    public static String theme; // thème sélectionné

    /** Cette méthode va récupérer les paramètre de l'application
     *  tels qu'ils étaient lors de sa dernière utilisation
     */
    public static void setSettingsFromFile() {

        // Récupération via mémoire.read

        // simulation :
        fx_volume = (double)10;
        bg_volume = (double)10;

        icon_color = "white";
        theme = "blue";

    }
}
