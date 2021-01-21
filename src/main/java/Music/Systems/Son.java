package Music.Systems;

import Timer.Timer;

/**
 * Cette classe centralise le nom de toutes les pistes sonores
 */
public class Son {
    public static final String wind = "wind";
    public static final String opinel1 = "opinel1";
    public static final String opinel2 = "opinel2";
    public static final String coeur = "coeur";
    public static final String erreur = "erreur";
    public static final String valid = "valid";
    public static final String porte1 = "porte1";
    public static final String porte2 = "porte2";
    public static final String cris1 = "cris1";
    public static final String msgChat = "msgChat";
    public static final String paraMot1 = "paraMot1";
    public static final String paraMot2 = "paraMot2";
    public static final String paraMot3 = "paraMot3";
    public static final String disparaitre = "disparaitre";
    public static final String hibou = "hibou";
    public static final String splash = "splash";
    public static final String eclair0 = "eclair0";
    public static final String eclair1 = "eclair1";
    public static final String eclair2 = "eclair2";
    public static final String eclair3 = "eclair3";
    public static final String menuClose = "menuClose";
    public static final String menuOpen = "menuOpen";
    public static final String liquid0 = "liquid0";
    public static final String liquid1 = "liquid1";
    public static final String metalSound = "metalSound";
    public static final String glassSound = "glassSound";
    public static final String feu = "feu";
    public static final String prendre = "prendre";
    public static final String tick = "tick";
    public static final String errorEnigma = "errorEnigma";
    public static final String bonusTime = "bonusTime";
    public static final String doorSlam = "doorSlam";
    //Nouveau sons ajoutés
    public static final String steps1 = "steps1";
    public static final String creakingDoor = "creakingDoor";
    public static final String creakingDoor2 = "creakingDoor2";
    public static final String creakingDoor3 = "creakingDoor3";
    public static final String breakingWood = "breakingWood";
    public static final String closingBook = "closingBook";
    public static final String doorKnocking1 = "doorKnocking1";
    public static final String doorKnocking2 = "doorKnocking2";
    public static final String drawerOpening = "drawerOpening";
    public static final String steps2 = "steps2";
    public static final String steps3 = "steps3";
    public static final String keyTurning1 = "keyTurning1";
    public static final String keyTurning2 = "keyTurning2";
    public static final String leverRatchet = "leverRatchet";
    public static final String leverSound = "leverSound";
    public static final String oneKnock = "oneKnock";
    public static final String openingBook = "openingBook";
    public static final String turningPage = "turningPage";
    public static final String ambiance1 = "ambiance1";
    public static final String menuTheme = "menuTheme";
    public static final String zip = "zip";
    public static final String switch1 = "switch";
    public static final String classRoom = "classRoom";

    public static void main(String[] args) {
        WorldBoxDisc.init();
        Timer.sleep(3000);
        WorldBoxDisc.testFromAllSound(turningPage);
        Timer.sleep(51000);
    }
}
