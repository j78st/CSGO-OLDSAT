package Music.Systems;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import Music.TinySound.Music;
import Music.TinySound.TinySound;
import Timer.Timer;

/**
 * Cette classe représente le système de musique.
 */
public class WorldBoxDisc extends Thread {
    /**
     * Correspond à la collection de disque de piste sonore
     */
    public static ArrayList<Disc> worldBoxMusic = new ArrayList<>();
    /**
     * Correspond à un dictionnaire effectuant le lien entre piste sonore et un identifiant unique
     */
    public static HashMap<String, Integer> idWorldBoxMusic = new HashMap<>();
    /**
     * Niveau sonore par défaut
     */
    public static double defaultSoundVolume = 2;
    /**
     * Nombre total de pistes chargées
     */
    public static int total = -1;
    /**
     * Booléen autorisant la lecture d'effets sonores
     */
    private static boolean soundFx;
    /**
     * Booléen autorisant la lecture de fonds sonores
     */
    private static boolean soundBackground;

    /**
     * Initialise les pistes sonores
     */
    public static void init(){
        soundFx = true; //Par défaut, les effets sonores sont activés
        soundBackground = true; //Par défaut, les fonds sonores sont activés
        //Rq : Tous formats autres que .wav ne marchent pas
        TinySound.init(); //initialise le systeme TinySound

        /*
        Le fichier wav doit absolument avoir comme paramètre :
         -encoder à une résolution de 16 bits
         -un échantillonage à 44100 Hz
         -2-chaine (stereo)
         -linear PCM
         */

        //musique de jeu
        File windF = new File("resources/sounds/ambiant/wind.wav");
        Music windM = TinySound.loadMusic(windF);
        Disc wind = new Disc(windM, "wind", true, MusicType.Background, 26);
        add(wind);

        //sons effets speciaux
        File opinel1F = new File("resources/sounds/opinel/opinel1.wav");
        Music opinel1M = TinySound.loadMusic(opinel1F);
        Disc opinel1 = new Disc(opinel1M, "opinel1", false, MusicType.SoundFx, 2);
        add(opinel1);

        File opinel2F = new File("resources/sounds/opinel/opinel2.wav");
        Music opinel2M = TinySound.loadMusic(opinel2F);
        Disc opinel2 = new Disc(opinel2M, "opinel2", false, MusicType.SoundFx, 2);
        add(opinel2);

        File humanHeartF = new File("resources/sounds/paranormal/human_heart_beat.wav");
        Music humanHeartM = TinySound.loadMusic(humanHeartF);
        Disc humanHeart = new Disc(humanHeartM, "coeur", true, MusicType.SoundFx, 64);
        add(humanHeart);

        File errorF = new File("resources/sounds/ui/error.wav");
        Music errorM = TinySound.loadMusic(errorF);
        Disc error = new Disc(errorM, "erreur", false, MusicType.SoundFx, 1);
        add(error);

        File validationF = new File("resources/sounds/ui/validation.wav");
        Music validationM = TinySound.loadMusic(validationF);
        Disc validation = new Disc(validationM, "valid", false, MusicType.SoundFx, 2);
        add(validation);

        File porteDebloque1F = new File("resources/sounds/rooms/doorOpeningSound.wav");
        Music porteDebloque1M = TinySound.loadMusic(porteDebloque1F);
        Disc porteDebloque1 = new Disc(porteDebloque1M, "porte1", false, MusicType.SoundFx, 2);
        add(porteDebloque1);

        File porteDebloque2F = new File("resources/sounds/rooms/doorOpened.wav");
        Music porteDebloque2M = TinySound.loadMusic(porteDebloque2F);
        Disc porteDebloque2 = new Disc(porteDebloque2M, "porte2", false, MusicType.SoundFx, 1);
        add(porteDebloque2);

        File screamF = new File("resources/sounds/paranormal/scream1.wav");
        Music screamM = TinySound.loadMusic(screamF);
        Disc scream = new Disc(screamM, "cris1", false, MusicType.SoundFx, 2);
        add(scream);

        File chatMsgF = new File("resources/sounds/ui/chatMsg.wav");
        Music chatMsgM = TinySound.loadMusic(chatMsgF);
        Disc chatMsg = new Disc(chatMsgM, "msgChat", false, MusicType.SoundFx, 2);
        add(chatMsg);

        File paraWords1F = new File("resources/sounds/paranormal/paranormalWords1.wav");
        Music paraWords1M = TinySound.loadMusic(paraWords1F);
        Disc paraWords1 = new Disc(paraWords1M, "paraMot1", false, MusicType.SoundFx, 4);
        add(paraWords1);

        File paraWords2F = new File("resources/sounds/paranormal/paranormalWords2.wav");
        Music paraWords2M = TinySound.loadMusic(paraWords2F);
        Disc paraWords2 = new Disc(paraWords2M, "paraMot2", false, MusicType.SoundFx, 3);
        add(paraWords2);

        File paraWords3F = new File("resources/sounds/paranormal/paranormalSound.wav");
        Music paraWords3M = TinySound.loadMusic(paraWords3F);
        Disc paraWords3 = new Disc(paraWords3M, "paraMot3", false, MusicType.SoundFx, 3);
        add(paraWords3);

        File disappearF = new File("resources/sounds/paranormal/disappearFx.wav");
        Music disappearM = TinySound.loadMusic(disappearF);
        Disc disappear = new Disc(disappearM, "disparaitre", false, MusicType.SoundFx, 1);
        add(disappear);

        File owlF = new File("resources/sounds/ambiant/owl.wav");
        Music owlM = TinySound.loadMusic(owlF);
        Disc owl = new Disc(owlM, "hibou", false, MusicType.SoundFx, 2);
        add(owl);

        File splashF = new File("resources/sounds/ambiant/Splash_0.wav");
        Music splashM = TinySound.loadMusic(splashF);
        Disc splash = new Disc(splashM, "splash", false, MusicType.SoundFx, 2);
        add(splash);

        File thunder0F = new File("resources/sounds/ambiant/Thunder_0.wav");
        Music thunder0M = TinySound.loadMusic(thunder0F);
        Disc thunder0 = new Disc(thunder0M, "eclair0", false, MusicType.Background, 3);
        add(thunder0);

        File thunder1F = new File("resources/sounds/ambiant/Thunder_1.wav");
        Music thunder1M = TinySound.loadMusic(thunder1F);
        Disc thunder1 = new Disc(thunder1M, "eclair1", false, MusicType.Background, 3);
        add(thunder1);

        File thunder2F = new File("resources/sounds/ambiant/Thunder_2.wav");
        Music thunder2M = TinySound.loadMusic(thunder2F);
        Disc thunder2 = new Disc(thunder2M, "eclair2", false, MusicType.Background, 2);
        add(thunder2);

        File thunder3F = new File("resources/sounds/ambiant/Thunder_3.wav");
        Music thunder3M = TinySound.loadMusic(thunder3F);
        Disc thunder3 = new Disc(thunder3M, "eclair3", false, MusicType.Background, 6);
        add(thunder3);

        File menuCLoseF = new File("resources/sounds/ui/menuClose.wav");
        Music menuCLoseM = TinySound.loadMusic(menuCLoseF);
        Disc menuClose = new Disc(menuCLoseM, "menuClose", false, MusicType.SoundFx, 1);
        add(menuClose);

        File menuOpenF = new File("resources/sounds/ui/menuOpen.wav");
        Music menuOpenM = TinySound.loadMusic(menuOpenF);
        Disc menuOpen = new Disc(menuOpenM, "menuOpen", false, MusicType.SoundFx, 1);
        add(menuOpen);

        File liquid0F = new File("resources/sounds/ambiant/Liquid_0.wav");
        Music liquid0M = TinySound.loadMusic(liquid0F);
        Disc liquid0 = new Disc(liquid0M, "liquid0", false, MusicType.Background, 46);
        add(liquid0);

        File liquid1F = new File("resources/sounds/ambiant/liquid_1.wav");
        Music liquid1M = TinySound.loadMusic(liquid1F);
        Disc liquid1 = new Disc(liquid1M, "liquid1", false, MusicType.Background, 49);
        add(liquid1);

        File metalSF = new File("resources/sounds/ambiant/metalSound.wav");
        Music metalSM = TinySound.loadMusic(metalSF);
        Disc metalS = new Disc(metalSM, "metalSound", false, MusicType.SoundFx, 1);
        add(metalS);

        File glassSF = new File("resources/sounds/ambiant/glassSound.wav");
        Music glassSM = TinySound.loadMusic(glassSF);
        Disc glassS = new Disc(glassSM, "glassSound", false, MusicType.SoundFx, 1);
        add(glassS);

        File darkAmbianceSoundF = new File("resources/sounds/ambiant/darkAmbianceStart.wav");
        Music darkAmbianceSoundM = TinySound.loadMusic(darkAmbianceSoundF);
        Disc darkAmbianceSound = new Disc(darkAmbianceSoundM, "darkSound", false, MusicType.Background, 7);
        add(darkAmbianceSound);

        File cracklingFireF = new File("resources/sounds/ambiant/cracklingFire.wav");
        Music cracklingFireM = TinySound.loadMusic(cracklingFireF);
        Disc cracklingFire = new Disc(cracklingFireM, "feu", true, MusicType.Background, 10);
        add(cracklingFire);

        File grabObjectF = new File("resources/sounds/objects/grabItem.wav");
        Music grabObjectM = TinySound.loadMusic(grabObjectF);
        Disc grabObject = new Disc(grabObjectM, "prendre", false, MusicType.Background, 1);
        add(grabObject);

        //Son sprint 2
        File tickF = new File("resources/sounds/ambiant/clock-ticking.wav");
        Music tickM = TinySound.loadMusic(tickF);
        Disc tick = new Disc(tickM, "tick", false, MusicType.SoundFx, 1);
        add(tick);

        File errorEnigmaF = new File("resources/sounds/rooms/errorEnigma.wav");
        Music errorEnigmaM = TinySound.loadMusic(errorEnigmaF);
        Disc errorEnigma = new Disc(errorEnigmaM, "errorEnigma", false, MusicType.SoundFx, 1);
        add(errorEnigma);

        File bonusTimeF = new File("resources/sounds/rooms/bonusTime.wav");
        Music bonusTimeM = TinySound.loadMusic(bonusTimeF);
        Disc bonusTime = new Disc(bonusTimeM, "bonusTime", false, MusicType.SoundFx, 1);
        add(bonusTime);

        File doorSlamF = new File("resources/sounds/interactions/slammingDoor.wav");
        Music doorSlamM = TinySound.loadMusic(doorSlamF);
        Disc doorSlam = new Disc(doorSlamM, "doorSlam", false, MusicType.SoundFx, 1);
        add(doorSlam);

        File steps1F = new File("resources/sounds/rooms/steps.wav");
        Music steps1M = TinySound.loadMusic(steps1F);
        Disc steps1 = new Disc(steps1M, "steps1", false, MusicType.SoundFx, 2);
        add(steps1);

        File creakingDoorF = new File("resources/sounds/rooms/creakingDoor.wav");
        Music creakingDoorM = TinySound.loadMusic(creakingDoorF);
        Disc creakingDoor = new Disc(creakingDoorM, "creakingDoor", false, MusicType.SoundFx, 1);
        add(creakingDoor);

        File creakingDoor2F = new File("resources/sounds/rooms/creakingDoor2.wav");
        Music creakingDoor2M = TinySound.loadMusic(creakingDoor2F);
        Disc creakingDoor2 = new Disc(creakingDoor2M, "creakingDoor2", false, MusicType.SoundFx, 3);
        add(creakingDoor2);

        File creakingDoor3F = new File("resources/sounds/rooms/creakingDoor3.wav");
        Music creakingDoor3M = TinySound.loadMusic(creakingDoor3F);
        Disc creakingDoor3 = new Disc(creakingDoor3M, "creakingDoor3", false, MusicType.SoundFx, 5);
        add(creakingDoor3);

        //Nouveau
        File breakingWoodF = new File("resources/sounds/interactions/breakingWood.wav");
        Music breakingWoodM = TinySound.loadMusic(breakingWoodF);
        Disc breakingWood = new Disc(breakingWoodM, "breakingWood", false, MusicType.SoundFx, 5);
        add(breakingWood);

        File closingBookF = new File("resources/sounds/interactions/closingBook.wav");
        Music closingBookM = TinySound.loadMusic(closingBookF);
        Disc closingBook = new Disc(closingBookM, "closingBook", false, MusicType.SoundFx, 1);
        add(closingBook);

        File doorKnocking1F = new File("resources/sounds/interactions/Door_Knocking1.wav");
        Music doorKnocking1M = TinySound.loadMusic(doorKnocking1F);
        Disc doorKnocking1 = new Disc(doorKnocking1M, "doorKnocking1", false, MusicType.SoundFx, 2);
        add(doorKnocking1);

        File doorKnocking2F = new File("resources/sounds/interactions/DoorKnowking2.wav");
        Music doorKnocking2M = TinySound.loadMusic(doorKnocking2F);
        Disc doorKnocking2 = new Disc(doorKnocking2M, "doorKnocking2", false, MusicType.SoundFx, 2);
        add(doorKnocking2);

        File drawerOpeningF = new File("resources/sounds/interactions/drawerOpening1.wav");
        Music drawerOpeningM = TinySound.loadMusic(drawerOpeningF);
        Disc drawerOpening = new Disc(drawerOpeningM, "drawerOpening", false, MusicType.SoundFx, 2);
        add(drawerOpening);

        File footsteps2F = new File("resources/sounds/interactions/footsteeps1.wav");
        Music footsteps2M = TinySound.loadMusic(footsteps2F);
        Disc footsteps2 = new Disc(footsteps2M, "steps2", false, MusicType.SoundFx, 3);
        add(footsteps2);

        File footsteps3F = new File("resources/sounds/interactions/footsteps2.wav");
        Music footsteps3M = TinySound.loadMusic(footsteps3F);
        Disc footsteps3 = new Disc(footsteps3M, "steps3", false, MusicType.SoundFx, 2);
        add(footsteps3);

        File keyTurning1F = new File("resources/sounds/interactions/keyTurning.wav");
        Music keyTurning1M = TinySound.loadMusic(keyTurning1F);
        Disc keyTurning1 = new Disc(keyTurning1M, "keyTurning1", false, MusicType.SoundFx, 3);
        add(keyTurning1);

        File keyTurning2F = new File("resources/sounds/interactions/keyTurning2.wav");
        Music keyTurning2M = TinySound.loadMusic(keyTurning2F);
        Disc keyTurning2 = new Disc(keyTurning2M, "keyTurning2", false, MusicType.SoundFx, 4);
        add(keyTurning2);

        File leverRatchetF = new File("resources/sounds/interactions/leverRatchet.wav");
        Music leverRatchetM = TinySound.loadMusic(leverRatchetF);
        Disc leverRatchet = new Disc(leverRatchetM, "leverRatchet", false, MusicType.SoundFx, 3);
        add(leverRatchet);

        File leverSoundF = new File("resources/sounds/interactions/leverSound.wav");
        Music leverSoundM = TinySound.loadMusic(leverSoundF);
        Disc leverSound = new Disc(leverSoundM, "leverSound", false, MusicType.SoundFx, 3);
        add(leverSound);

        File oneKnockF = new File("resources/sounds/interactions/oneKnock.wav");
        Music oneKnockM = TinySound.loadMusic(oneKnockF);
        Disc oneKnock = new Disc(oneKnockM, "oneKnock", false, MusicType.SoundFx, 1);
        add(oneKnock);

        File openingBookF = new File("resources/sounds/interactions/openingBook.wav");
        Music openingBookM = TinySound.loadMusic(openingBookF);
        Disc openingBook = new Disc(openingBookM, "openingBook", false, MusicType.SoundFx, 2);
        add(openingBook);

        File turningPageF = new File("resources/sounds/interactions/pageTurning.wav");
        Music turningPageM = TinySound.loadMusic(turningPageF);
        Disc turningPage = new Disc(turningPageM, "turningPage", false, MusicType.SoundFx, 1);
        add(turningPage);

        File ambiance1F = new File("resources/sounds/ambiant/ambiance1.wav");
        Music ambiance1M = TinySound.loadMusic(ambiance1F);
        Disc ambiance1 = new Disc(ambiance1M, "ambiance1", false, MusicType.SoundFx, 10);
        add(ambiance1);

        File menuThemeF = new File("resources/sounds/theme/main_theme.wav");
        Music menuThemeM = TinySound.loadMusic(menuThemeF);
        Disc menuTheme = new Disc(menuThemeM, "menuTheme", true, MusicType.Background, 52);
        add(menuTheme);

        File zipCloseF = new File("resources/sounds/interactions/zipClose.wav");
        Music zipCloseM = TinySound.loadMusic(zipCloseF);
        Disc zipClose = new Disc(zipCloseM, "zip", false, MusicType.SoundFx, 1);
        add(zipClose);
    }


    /**
     * Operation d'ajout special de disque de la classe WorldBoxDisc
     * @param aDisc
     */
    public static void add(Disc aDisc){
        if(aDisc.name != "tick") {
            aDisc.aMusic.setVolume(defaultSoundVolume); //MAJ du niveau sonore au moment du chargement des pistes
        } else {
            aDisc.aMusic.setVolume(0.5);
        }
        idWorldBoxMusic.put(aDisc.name,++total);
        worldBoxMusic.add(aDisc);
    }

    /**
     * Lecture d'une piste sonore
     * @param name
     */
    public static void play(String name){
        MusicType typeToEvaluate = worldBoxMusic.get(idWorldBoxMusic.get(name)).type;
        if((typeToEvaluate == MusicType.SoundFx && soundFx) || (typeToEvaluate == MusicType.Background && soundBackground) ){
            Disc discToPlay = worldBoxMusic.get(idWorldBoxMusic.get(name));
            discToPlay.aMusic.play(discToPlay.loop);
            discToPlay.aMusic.rewind(); //permet a une piste d'etre joue plusiseurs fois
        }
    }

    /**
     * Arret d'une piste sonore
     * @param name
     */
    public static void stop(String name){
        Disc discToPlay = worldBoxMusic.get(idWorldBoxMusic.get(name));
        discToPlay.aMusic.stop();
    }

    /**
     * Met en pause une piste sonore
     * @param name
     */
    public static void pause(String name){
        Disc discToPlay = worldBoxMusic.get(idWorldBoxMusic.get(name));
        discToPlay.aMusic.pause();
    }

    /**
     * Donne le niveau sonore d'une piste sur un terminal
     * @param name
     */
    public static void getVolumeTerminal(String name){
        Disc discToTest = worldBoxMusic.get(idWorldBoxMusic.get(name));
        System.out.println("Volume de "+name+":"+discToTest.aMusic.getVolume());
    }

    /**
     * Donne le niveau sonore d'une piste
     * @param name
     * @return Integer
     */
    public static double getVolume(String name){
        Disc discToTest = worldBoxMusic.get(idWorldBoxMusic.get(name));
        return  discToTest.aMusic.getVolume();
    }

    /**
     * Change le niveau du son d'une piste sonore
     * @param name
     * @param value
     */
    public static void setVolume(String name, double value){
        Disc discToTest = worldBoxMusic.get(idWorldBoxMusic.get(name));
        discToTest.aMusic.setVolume(value);
    }


    /**
     * Donne la liste des pistes sonores chargées
     */
    public static void showLoadedAudioFiles(){
        System.out.println("Total : " + total);
        System.out.println("Nom des pistes audios chargées :");
        for(int i = 0; i<worldBoxMusic.size(); i++){
            System.out.println(worldBoxMusic.get(i).name + " niveau sonore: "+worldBoxMusic.get(i).aMusic.getVolume());
        }
    }


    /**
    * Permet de jouer une meme piste sonore autant de fois que l'on veut et avec l'intervalle de temps désiré
    */
    public static void repeatSound(String nom, int n, int ms){
        for(int i = 0; i < n; i++){
            try {
                sleep(ms);
                System.out.println("Now playing " + nom +": "+i);
                WorldBoxDisc.play(nom);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Affiche les musiques d'un type donné
     * @param type [SoundFx/Background]
     */
    public static void allTypeSounds(MusicType type){
        if(MusicType.SoundFx == type){
            System.out.println("Effets sonores : ");
        } else {
            System.out.println("Fonds sonores : ");
        }

        for(int i = 0; i < worldBoxMusic.size(); i++){
            if(worldBoxMusic.get(i).type == type) {
                System.out.println(worldBoxMusic.get(i).name);
            }
        }
    }


    /**
    * Desactive/Active les effets sonores
    */
    public static void toogleSoundFx(){
        if(soundFx) {
            for (int i = 0; i < worldBoxMusic.size(); i++) {
                if (worldBoxMusic.get(i).type == MusicType.SoundFx) {
                    worldBoxMusic.get(i).aMusic.setVolume(0); //Les musiques seront joue avec un niveau de 0, ce qui permet de reprendre la où elles sont en train de jouer
                }
            }
            soundFx = false;
        } else {
            for (int i = 0; i < worldBoxMusic.size(); i++) {
                if (worldBoxMusic.get(i).type == MusicType.SoundFx) {
                    worldBoxMusic.get(i).aMusic.setVolume(defaultSoundVolume);
                }
            }
            soundFx = true;
        }
    }

    /**
    * Desactive/Active les fonds sonores
    */
    public static void toogleSoundBackground(){
        if(soundBackground) {
            for (int i = 0; i < worldBoxMusic.size(); i++) {
                if (worldBoxMusic.get(i).type == MusicType.Background) {
                    worldBoxMusic.get(i).aMusic.setVolume(0);
                }
            }
            soundBackground = false;
        } else {
            for (int i = 0; i < worldBoxMusic.size(); i++) {
                if (worldBoxMusic.get(i).type == MusicType.Background) {
                    worldBoxMusic.get(i).aMusic.setVolume(defaultSoundVolume);
                }
            }
            soundBackground = true;
        }
    }


    /**
     * Met tous les effets sonores aux volumes désirés
     * @param value
     */
    public static void setSoundFx(double value){
        for (int i = 0; i < worldBoxMusic.size(); i++) {
            if (worldBoxMusic.get(i).type == MusicType.SoundFx) {
                worldBoxMusic.get(i).aMusic.setVolume(value);
            }
        }
    }

    /**
     * Met tous les fonds sonores aux volumes désirés
     * @param value
     */
    public static void setSoundBackground(double value){
        for (int i = 0; i < worldBoxMusic.size(); i++) {
            if (worldBoxMusic.get(i).type == MusicType.Background) {
                worldBoxMusic.get(i).aMusic.setVolume(value); //Les musiques seront joue avec un niveau de 0, ce qui permet de reprendre la où elles sont en train de jouer
            }
        }
    }

    /**
     * Met tous les sons aux mêmes volumes
     * @param value
     */
    public static void setAllSound(double value){
        for (int i = 0; i < worldBoxMusic.size(); i++) {
            worldBoxMusic.get(i).aMusic.setVolume(value);
        }
    }


    /**
     * Affiche les pistes sonores en cours d'executions
     */
    public static void statusSounds(){
        for(int i = 0; i<worldBoxMusic.size(); i++){
            if(worldBoxMusic.get(i).aMusic.playing()){
                System.out.println(worldBoxMusic.get(i).name + " is playing : " + worldBoxMusic.get(i).aMusic.getVolume());
            }
        }
    }

    /**
     * Lit toutes les pistes sonores
     */
    public static void testAllSound(){
        for(int i = 0; i < worldBoxMusic.size(); i++){
            try {
                sleep(2000);
                System.out.println("Now playing :" + worldBoxMusic.get(i).name);
                worldBoxMusic.get(i).aMusic.play(false);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Test le reste des pistes sonores depuis le nom de la dernière piste
     * @param name
     */
    public static void testFromAllSound(String name){
        int value = idWorldBoxMusic.get(name);
        for(int i = value; i < worldBoxMusic.size(); i++){
            try {
                sleep(2000);
                System.out.println("Now playing :" + worldBoxMusic.get(i).name);
                worldBoxMusic.get(i).aMusic.play(false);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        init();
        testFromAllSound("doorSlam");
        Timer.sleep(8000);
    }
}