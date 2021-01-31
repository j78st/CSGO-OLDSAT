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
     * Niveau sonore par défaut des effets sonore
     */
    public static double defaultSoundFx = defaultSoundVolume;
    /**
     * Niveau sonore par défaut des fonds sonores
     */
    public static double defaultSoundBg = defaultSoundVolume;
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

        File opinel2F = new File("resources/sounds/opinel/opinel2.wav");
        Music opinel2M = TinySound.loadMusic(opinel2F);
        Disc opinel2 = new Disc(opinel2M, "opinel2", false, MusicType.SoundFx, 2);
        add(opinel2);

        File humanHeartF = new File("resources/sounds/paranormal/human_heart_beat.wav");
        Music humanHeartM = TinySound.loadMusic(humanHeartF);
        Disc humanHeart = new Disc(humanHeartM, "coeur", true, MusicType.SoundFx, 64);
        add(humanHeart);

        File validationF = new File("resources/sounds/ui/validation.wav");
        Music validationM = TinySound.loadMusic(validationF);
        Disc validation = new Disc(validationM, "valid", false, MusicType.SoundFx, 2);
        add(validation);

        File porteDebloque1F = new File("resources/sounds/rooms/doorOpeningSound.wav");
        Music porteDebloque1M = TinySound.loadMusic(porteDebloque1F);
        Disc porteDebloque1 = new Disc(porteDebloque1M, "porte1", false, MusicType.SoundFx, 2);
        add(porteDebloque1);

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

        File owlF = new File("resources/sounds/ambiant/owl.wav");
        Music owlM = TinySound.loadMusic(owlF);
        Disc owl = new Disc(owlM, "hibou", false, MusicType.SoundFx, 2);
        add(owl);

        File menuCLoseF = new File("resources/sounds/ui/menuClose.wav");
        Music menuCLoseM = TinySound.loadMusic(menuCLoseF);
        Disc menuClose = new Disc(menuCLoseM, "menuClose", false, MusicType.SoundFx, 1);
        add(menuClose);

        File menuOpenF = new File("resources/sounds/ui/menuOpen.wav");
        Music menuOpenM = TinySound.loadMusic(menuOpenF);
        Disc menuOpen = new Disc(menuOpenM, "menuOpen", false, MusicType.SoundFx, 1);
        add(menuOpen);

        File darkAmbianceSoundF = new File("resources/sounds/ambiant/darkAmbianceStart.wav");
        Music darkAmbianceSoundM = TinySound.loadMusic(darkAmbianceSoundF);
        Disc darkAmbianceSound = new Disc(darkAmbianceSoundM, "darkSound", false, MusicType.Background, 7);
        add(darkAmbianceSound);

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

        File creakingDoor2F = new File("resources/sounds/rooms/creakingDoor2.wav");
        Music creakingDoor2M = TinySound.loadMusic(creakingDoor2F);
        Disc creakingDoor2 = new Disc(creakingDoor2M, "creakingDoor2", false, MusicType.SoundFx, 3);
        add(creakingDoor2);

        //Nouveau
        File breakingWoodF = new File("resources/sounds/interactions/breakingWood.wav");
        Music breakingWoodM = TinySound.loadMusic(breakingWoodF);
        Disc breakingWood = new Disc(breakingWoodM, "breakingWood", false, MusicType.SoundFx, 5);
        add(breakingWood);

        File drawerOpeningF = new File("resources/sounds/interactions/drawerOpening1.wav");
        Music drawerOpeningM = TinySound.loadMusic(drawerOpeningF);
        Disc drawerOpening = new Disc(drawerOpeningM, "drawerOpening", false, MusicType.SoundFx, 2);
        add(drawerOpening);

        File footsteps3F = new File("resources/sounds/interactions/footsteps2.wav");
        Music footsteps3M = TinySound.loadMusic(footsteps3F);
        Disc footsteps3 = new Disc(footsteps3M, "steps3", false, MusicType.SoundFx, 2);
        add(footsteps3);

        File keyTurning2F = new File("resources/sounds/interactions/keyTurning2.wav");
        Music keyTurning2M = TinySound.loadMusic(keyTurning2F);
        Disc keyTurning2 = new Disc(keyTurning2M, "keyTurning2", false, MusicType.SoundFx, 4);
        add(keyTurning2);

        File leverSoundF = new File("resources/sounds/interactions/leverSound.wav");
        Music leverSoundM = TinySound.loadMusic(leverSoundF);
        Disc leverSound = new Disc(leverSoundM, "leverSound", false, MusicType.SoundFx, 3);
        add(leverSound);

        File oneKnockF = new File("resources/sounds/interactions/oneKnock.wav");
        Music oneKnockM = TinySound.loadMusic(oneKnockF);
        Disc oneKnock = new Disc(oneKnockM, "oneKnock", false, MusicType.SoundFx, 1);
        add(oneKnock);

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

        File switch1F = new File("resources/sounds/interactions/switch4.wav");
        Music switch1M = TinySound.loadMusic(switch1F);
        Disc switch1 = new Disc(switch1M, "switch1", false, MusicType.SoundFx, 1);
        add(switch1);

        File classRoomF = new File("resources/sounds/ambiant/classroomNoises.wav");
        Music classRoomM = TinySound.loadMusic(classRoomF);
        Disc classRoom = new Disc(classRoomM, "classRoom", true, MusicType.Background, 60);
        add(classRoom);

        File outsideF = new File("resources/sounds/ambiant/outside.wav");
        Music outsideM = TinySound.loadMusic(outsideF);
        Disc outside = new Disc(outsideM, "outside", true, MusicType.Background, 39+2*60);
        add(outside);

        File finEnigmeF = new File("resources/sounds/interactions/fin_enigme.wav");
        Music finEnigmeM = TinySound.loadMusic(finEnigmeF);
        Disc finEnigme = new Disc(finEnigmeM, "finEnigme", false, MusicType.SoundFx, 3);
        add(finEnigme);

        File doorShoulderF = new File("resources/sounds/interactions/bangDoor.wav");
        Music doorShoulderM = TinySound.loadMusic(doorShoulderF);
        Disc doorShoulder = new Disc(doorShoulderM, "doorShoulder", false, MusicType.SoundFx, 1);
        add(doorShoulder);

        File gameThemeF = new File("resources/sounds/theme/theme_jeu_2_w.wav");
        Music gameThemeM = TinySound.loadMusic(gameThemeF);
        Disc gameTheme = new Disc(gameThemeM, "gameTheme", true, MusicType.Background, 60 + 7);
        add(gameTheme);
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
            discToPlay.aMusic.rewind(); //permet a une piste d'etre joue plusieurs fois
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
     * Permet de savoir si un son est un son de type loop
     * @param sound le nom de la musique recherchée
     */
    public static boolean isALoop(String sound){
        boolean res = false;
        for(int i = 0; i<worldBoxMusic.size(); i++){ //Parcours de la liste des son
            if(worldBoxMusic.get(i).name.equals(sound)){ //Si c'est nom qu'on cherche
                if(worldBoxMusic.get(i).loop){ //Si c'est un son de type loop
                    res = true; //Alors le résultat est true
                }
            }
        }
        return res;
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
        defaultSoundFx = value;
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
        defaultSoundBg = value;
    }

    /**
     * Met tous les sons aux mêmes volumes
     * @param value
     */
    public static void setAllSound(double value){
        for (int i = 0; i < worldBoxMusic.size(); i++) {
            worldBoxMusic.get(i).aMusic.setVolume(value);
        }
        defaultSoundVolume = value;
    }

    /**
     * Met en pause toutes musiques de fonds sonores
     */
    public static void pauseAllBackgroundSound(){
        for(int i = 0; i< worldBoxMusic.size(); i++){
            if(worldBoxMusic.get(i).type == MusicType.Background){
                WorldBoxDisc.pause(worldBoxMusic.get(i).name);
            }
        }
    }

    /**
     * Met en pause toutes musiques qui bouclent
     */
    public static void pauseAllLoopingSound(){
        for(int i = 0; i < worldBoxMusic.size(); i++){
            if(worldBoxMusic.get(i).loop){
                WorldBoxDisc.pause(worldBoxMusic.get(i).name);
            }
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
     * Indique si une piste est en cours de lecture
     * @param name
     * @return
     */
    public static boolean isPlaying(String name){
        if(worldBoxMusic.get(idWorldBoxMusic.get(name)).aMusic.playing()){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Indique si une piste est terminée
     * @param name
     * @return
     */
    public static boolean isDone(String name){
        if(worldBoxMusic.get(idWorldBoxMusic.get(name)).aMusic.done()){
            return true;
        } else {
            return false;
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
        WorldBoxDisc.play(Son.doorShoulder);
        Timer.sleep(8000);
        System.out.println("pause");
        Timer.sleep(8000);
    }
}