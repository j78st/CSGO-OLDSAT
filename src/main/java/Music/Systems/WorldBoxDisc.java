package Music.Systems;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import Music.TinySound.Music;
import Music.TinySound.TinySound;

public class WorldBoxDisc extends Thread {
    public static ArrayList<Disc> worldBoxMusic = new ArrayList<>();
    public static HashMap<String, Integer> idWorldBoxMusic = new HashMap<>();
    public static double defaultSoundVolume = 5;
    public static int total = -1; //Nb total de piste à charger
    private static boolean soundFx; //Autorise la lecture de son fx
    private static boolean soundBackground; //autorise la lecture de son de background

    /**
     * Initialise les musique du jeu
     */

    public static void init(){
        soundFx = true;
        soundBackground = true;
        //Le format mp3 ne marche pas
        TinySound.init(); //initialise le systeme TinySound

        /*
        Le fichier wav doit absolument avoir comme paramètre :
         -encoder à une résolution de 16 bits
         -un échantillonage à 44100 kHz
         -2-chaine (stereo)
         -linear PCM
         */

        //musique de jeu
        File windF = new File("resourses/fxmusics/ambiant/wind.wav");
        Music windM = TinySound.loadMusic(windF);
        Disc wind = new Disc(windM, "wind", true, MusicType.Background);
        add(wind);

        //sons effets speciaux
        File opinel1F = new File("resourses/fxmusics/opinel/opinel1.wav");
        Music opinel1M = TinySound.loadMusic(opinel1F);
        Disc opinel1 = new Disc(opinel1M, "opinel1", false, MusicType.SoundFx);
        add(opinel1);

        File opinel2F = new File("resourses/fxmusics/opinel/opinel2.wav");
        Music opinel2M = TinySound.loadMusic(opinel2F);
        Disc opinel2 = new Disc(opinel2M, "opinel2", false, MusicType.SoundFx);
        add(opinel2);

        File humanHeartF = new File("resourses/fxmusics/paranormal/human_heart_beat.wav");
        Music humanHeartM = TinySound.loadMusic(humanHeartF);
        Disc humanHeart = new Disc(humanHeartM, "coeur", true, MusicType.SoundFx);
        add(humanHeart);

        File errorF = new File("resourses/fxmusics/ui/error.wav");
        Music errorM = TinySound.loadMusic(errorF);
        Disc error = new Disc(errorM, "erreur", false, MusicType.SoundFx);
        add(error);

        File validationF = new File("resourses/fxmusics/ui/validation.wav");
        Music validationM = TinySound.loadMusic(validationF);
        Disc validation = new Disc(validationM, "valid", false, MusicType.SoundFx);
        add(validation);

        File porteDebloque1F = new File("resourses/fxmusics/rooms/doorOpeningSound.wav");
        Music porteDebloque1M = TinySound.loadMusic(porteDebloque1F);
        Disc porteDebloque1 = new Disc(porteDebloque1M, "porte1", false, MusicType.SoundFx);
        add(porteDebloque1);

        File porteDebloque2F = new File("resourses/fxmusics/rooms/doorOpened.wav");
        Music porteDebloque2M = TinySound.loadMusic(porteDebloque2F);
        Disc porteDebloque2 = new Disc(porteDebloque2M, "porte2", false, MusicType.SoundFx);
        add(porteDebloque2);

        File screamF = new File("resourses/fxmusics/paranormal/scream1.wav");
        Music screamM = TinySound.loadMusic(screamF);
        Disc scream = new Disc(screamM, "cris1", false, MusicType.SoundFx);
        add(scream);

        File chatMsgF = new File("resourses/fxmusics/ui/chatMsg.wav");
        Music chatMsgM = TinySound.loadMusic(chatMsgF);
        Disc chatMsg = new Disc(chatMsgM, "msgChat", false, MusicType.SoundFx);
        add(chatMsg);

        File paraWords1F = new File("resourses/fxmusics/paranormal/paranormalWords1.wav");
        Music paraWords1M = TinySound.loadMusic(paraWords1F);
        Disc paraWords1 = new Disc(paraWords1M, "paraMot1", false, MusicType.SoundFx);
        add(paraWords1);

        File paraWords2F = new File("resourses/fxmusics/paranormal/paranormalWords2.wav");
        Music paraWords2M = TinySound.loadMusic(paraWords2F);
        Disc paraWords2 = new Disc(paraWords2M, "paraMot2", false, MusicType.SoundFx);
        add(paraWords2);

        File paraWords3F = new File("resourses/fxmusics/paranormal/paranormalSound.wav");
        Music paraWords3M = TinySound.loadMusic(paraWords3F);
        Disc paraWords3 = new Disc(paraWords3M, "paraMot3", false, MusicType.SoundFx);
        add(paraWords3);

        File disappearF = new File("resourses/fxmusics/paranormal/disappearFx.wav");
        Music disappearM = TinySound.loadMusic(disappearF);
        Disc disappear = new Disc(disappearM, "disparaitre", false, MusicType.SoundFx);
        add(disappear);

        File owlF = new File("resourses/fxmusics/ambiant/owl.wav");
        Music owlM = TinySound.loadMusic(owlF);
        Disc owl = new Disc(owlM, "hibou", false, MusicType.Background);
        add(owl);

        File splashF = new File("resourses/fxmusics/ambiant/Splash_0.wav");
        Music splashM = TinySound.loadMusic(splashF);
        Disc splash = new Disc(splashM, "splash", false, MusicType.SoundFx);
        add(splash);

        File thunder0F = new File("resourses/fxmusics/ambiant/Thunder_0.wav");
        Music thunder0M = TinySound.loadMusic(thunder0F);
        Disc thunder0 = new Disc(thunder0M, "eclair0", false, MusicType.Background);
        add(thunder0);

        File thunder1F = new File("resourses/fxmusics/ambiant/Thunder_1.wav");
        Music thunder1M = TinySound.loadMusic(thunder1F);
        Disc thunder1 = new Disc(thunder1M, "eclair1", false, MusicType.Background);
        add(thunder1);

        File thunder2F = new File("resourses/fxmusics/ambiant/Thunder_2.wav");
        Music thunder2M = TinySound.loadMusic(thunder2F);
        Disc thunder2 = new Disc(thunder2M, "eclair2", false, MusicType.Background);
        add(thunder2);

        File thunder3F = new File("resourses/fxmusics/ambiant/Thunder_3.wav");
        Music thunder3M = TinySound.loadMusic(thunder3F);
        Disc thunder3 = new Disc(thunder3M, "eclair3", false, MusicType.Background);
        add(thunder3);

        File menuCLoseF = new File("resourses/fxmusics/ui/menuClose.wav");
        Music menuCLoseM = TinySound.loadMusic(menuCLoseF);
        Disc menuClose = new Disc(menuCLoseM, "menuClose", false, MusicType.SoundFx);
        add(menuClose);

        File menuOpenF = new File("resourses/fxmusics/ui/menuOpen.wav");
        Music menuOpenM = TinySound.loadMusic(menuOpenF);
        Disc menuOpen = new Disc(menuOpenM, "menuOpen", false, MusicType.SoundFx);
        add(menuOpen);

        File liquid0F = new File("resourses/fxmusics/ui/menuOpen.wav");
        Music liquid0M = TinySound.loadMusic(liquid0F);
        Disc liquid0 = new Disc(liquid0M, "liquid0", false, MusicType.Background);
        add(liquid0);

        File liquid1F = new File("resourses/fxmusics/ambiant/liquid_1.wav");
        Music liquid1M = TinySound.loadMusic(liquid1F);
        Disc liquid1 = new Disc(liquid1M, "liquid1", false, MusicType.Background);
        add(liquid1);

        File metalSF = new File("resourses/fxmusics/ambiant/metalSound.wav");
        Music metalSM = TinySound.loadMusic(metalSF);
        Disc metalS = new Disc(metalSM, "metalSound", false, MusicType.SoundFx);
        add(metalS);

        File glassSF = new File("resourses/fxmusics/ambiant/glassSound.wav");
        Music glassSM = TinySound.loadMusic(glassSF);
        Disc glassS = new Disc(glassSM, "glassSound", false, MusicType.SoundFx);
        add(glassS);

        File darkAmbianceSoundF = new File("resourses/fxmusics/ambiant/darkAmbianceStart.wav");
        Music darkAmbianceSoundM = TinySound.loadMusic(darkAmbianceSoundF);
        Disc darkAmbianceSound = new Disc(darkAmbianceSoundM, "darkSound", false, MusicType.Background);
        add(darkAmbianceSound);

        File cracklingFireF = new File("resourses/fxmusics/ambiant/darkAmbianceStart.wav");
        Music cracklingFireM = TinySound.loadMusic(cracklingFireF);
        Disc cracklingFire = new Disc(cracklingFireM, "feu", true, MusicType.Background);
        add(cracklingFire);

        File grabObjectF = new File("resourses/fxmusics/objects/grabItem.wav");
        Music grabObjectM = TinySound.loadMusic(grabObjectF);
        Disc grabObject = new Disc(grabObjectM, "prendre", false, MusicType.Background);
        add(grabObject);

    }


    //Operation d'ajout special de la classe WorldBoxDisc
    public static void add(Disc aDisc){
        aDisc.aMusic.setVolume(defaultSoundVolume); //maj du niveau sonore
        idWorldBoxMusic.put(aDisc.name,++total);
        worldBoxMusic.add(aDisc);
    }

    //Demarre une piste
    public static void play(String name){
        MusicType typeToEvaluate = worldBoxMusic.get(idWorldBoxMusic.get(name)).type;
        if((typeToEvaluate == MusicType.SoundFx && soundFx) || (typeToEvaluate == MusicType.Background && soundBackground) ){
            Disc discToPlay = worldBoxMusic.get(idWorldBoxMusic.get(name));
            discToPlay.aMusic.play(discToPlay.loop);
            discToPlay.aMusic.rewind(); //permet a une piste d'etre joue plusiseurs fois
        }
    }

    //Arrete une piste
    public static void stop(String name){
        Disc discToPlay = worldBoxMusic.get(idWorldBoxMusic.get(name));
        discToPlay.aMusic.stop();
    }

    //Met en pause une piste
    public static void pause(String name){
        Disc discToPlay = worldBoxMusic.get(idWorldBoxMusic.get(name));
        discToPlay.aMusic.pause();
    }

    //Donne le niveau sonore d'une piste sur un terminal
    public static void getVolumeTerminal(String name){
        Disc discToTest = worldBoxMusic.get(idWorldBoxMusic.get(name));
        System.out.println("Volume de "+name+":"+discToTest.aMusic.getVolume());
    }

    //Donne le niveau sonore d'une piste
    public static double getVolume(String name){
        Disc discToTest = worldBoxMusic.get(idWorldBoxMusic.get(name));
        return  discToTest.aMusic.getVolume();
    }

    //Change le son d'une piste
    public static void setVolume(String name, double value){
        Disc discToTest = worldBoxMusic.get(idWorldBoxMusic.get(name));
        discToTest.aMusic.setVolume(value);
    }

    //Donne la liste des pistes sonores chargées
    public static void showLoadedAudioFiles(){
        System.out.println("Nom des pistes audios chargées :");
        for(int i = 0; i<worldBoxMusic.size(); i++){
            System.out.println(worldBoxMusic.get(i).name + " niveau sonore: "+worldBoxMusic.get(i).aMusic.getVolume());
        }
    }

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

    /*
    * Permet de jouer une meme piste autant de fois que l'on veut et avec l'intervalle que l'on veut
    * */
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
     * Affiche les musiques d'un type donne
     * @param type
     */
    public static void allFxSounds(MusicType type){
        for(int i = 0; i < worldBoxMusic.size(); i++){
            if(worldBoxMusic.get(i).type == type) {
                System.out.println(worldBoxMusic.get(i).name);
            }
        }
    }

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
     * Affiche les pistes en cours d'executions
     */
    public static void statusSounds(){
        for(int i = 0; i<worldBoxMusic.size(); i++){
            if(worldBoxMusic.get(i).aMusic.playing()){
                System.out.println(worldBoxMusic.get(i).name + " is playing : " + worldBoxMusic.get(i).aMusic.getVolume());
            }
        }
    }

    //TODO ajouter methode qui repere les musiques en cours d'excution pour changer en même temps leurs volumes
    //TODO peut etre creer divers label de son pour gerer le changement des niveaux de sons separements
}