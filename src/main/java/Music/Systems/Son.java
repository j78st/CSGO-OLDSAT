package Music.Systems;

import Timer.Timer;

/**
 * Cette classe centralise le nom de toutes les pistes sonores
 */
public class Son {
    public static final String opinel2 = "opinel2";
    public static final String coeur = "coeur";
    public static final String valid = "valid";
    public static final String porte1 = "porte1";
    public static final String paraMot1 = "paraMot1";
    public static final String paraMot2 = "paraMot2";
    public static final String paraMot3 = "paraMot3";
    public static final String hibou = "hibou";
    public static final String menuClose = "menuClose";
    public static final String menuOpen = "menuOpen";
    public static final String prendre = "prendre";
    public static final String tick = "tick";
    public static final String errorEnigma = "errorEnigma";
    public static final String bonusTime = "bonusTime";
    public static final String doorSlam = "doorSlam";
    //Nouveau sons ajoutés
    public static final String creakingDoor2 = "creakingDoor2";
    public static final String breakingWood = "breakingWood";
    public static final String drawerOpening = "drawerOpening";
    public static final String steps3 = "steps3";
    public static final String keyTurning2 = "keyTurning2";
    public static final String leverSound = "leverSound";
    public static final String oneKnock = "oneKnock";
    public static final String turningPage = "turningPage";
    public static final String ambiance1 = "ambiance1";
    public static final String menuTheme = "menuTheme";
    public static final String zip = "zip";
    public static final String switch1 = "switch1";
    public static final String classRoom = "classRoom";
    public static final String outside = "outside";
    public static final String finEnigme = "finEnigme";
    public static final String doorShoulder = "doorShoulder";
    public static final String gameTheme = "gameTheme";


    public static void main(String[] args) {
        WorldBoxDisc.init();
        Timer.sleep(3000);
        WorldBoxDisc.play(Son.gameTheme);
        Timer.sleep(51000);
    }
}
