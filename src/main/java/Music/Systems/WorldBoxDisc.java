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

    /**
     * Initialise les musique du jeu
     */

    public static void init(){
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
        File windF = new File("resourses/musics/windSoundEffect.wav");
        Music windM = TinySound.loadMusic(windF);
        Disc wind = new Disc(windM, "wind", true);
        add(wind);

        //sons effets speciaux
        File opinel1F = new File("resourses/fxmusics/opinel/opinel1.wav");
        Music opinel1M = TinySound.loadMusic(opinel1F);
        Disc opinel1 = new Disc(opinel1M, "opinel1", false);
        add(opinel1);

        File opinel2F = new File("resourses/fxmusics/opinel/opinel2.wav");
        Music opinel2M = TinySound.loadMusic(opinel2F);
        Disc opinel2 = new Disc(opinel2M, "opinel2", false);
        add(opinel2);

        File humanHeartF = new File("resourses/fxmusics/paranormal/human_heart_beat.wav");
        Music humanHeartM = TinySound.loadMusic(humanHeartF);
        Disc humanHeart = new Disc(humanHeartM, "coeur", true);
        add(humanHeart);

        File errorF = new File("resourses/fxmusics/ui/error.wav");
        Music errorM = TinySound.loadMusic(errorF);
        Disc error = new Disc(errorM, "erreur", false);
        add(error);

        File validationF = new File("resourses/fxmusics/ui/validation.wav");
        Music validationM = TinySound.loadMusic(validationF);
        Disc validation = new Disc(validationM, "valid", false);
        add(validation);

        File porteDebloqueF = new File("resourses/fxmusics/doorOpeningSound.wav");
        Music porteDebloqueM = TinySound.loadMusic(porteDebloqueF);
        Disc porteDebloque = new Disc(porteDebloqueM, "porteDebloque", false);
        add(porteDebloque);

        File screamF = new File("resourses/fxmusics/paranormal/scream1.wav");
        Music screamM = TinySound.loadMusic(screamF);
        Disc scream = new Disc(screamM, "cris1", false);
        add(scream);



    }


    //Operation d'ajout special de la classe WorldBoxDisc
    public static void add(Disc aDisc){
        aDisc.aMusic.setVolume(defaultSoundVolume); //maj du niveau sonore
        idWorldBoxMusic.put(aDisc.name,++total);
        worldBoxMusic.add(aDisc);
    }

    //Demarre une piste
    public static void play(String name){
        Disc discToPlay = worldBoxMusic.get(idWorldBoxMusic.get(name));
        discToPlay.aMusic.play(discToPlay.loop);
        discToPlay.aMusic.rewind();
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

    //TODO ajouter methode qui repere les musiques en cours d'excution pour changer en même temps leurs volumes
    //TODO peut etre creer divers label de son pour gerer le changement des niveaux de sons separements
}