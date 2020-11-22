package Music.Systems;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import Music.TinySound.Music;
import Music.TinySound.TinySound;

public class WorldBoxDisc {
    public static ArrayList<Disc> worldBoxMusic = new ArrayList<>();
    public static HashMap<String, Integer> idWorldBoxMusic = new HashMap<>();
    public static double defaultSoundVolume = 10;
    public static int total = -1; //Nb total de piste à charger

    /**
     * Initialise les musique du jeu
     */
    public static void init(){
        //Le format mp3 ne marche pas
        TinySound.init(); //initialise le systeme TinySound
        
        //musique de jeu
        File windF = new File("resourses/musics/windSoundEffect.wav");
        Music windM = TinySound.loadMusic(windF);
        Disc wind = new Disc(windM, "wind", true);
        add(wind);

        //sons effets speciaux
        File opinelF = new File("resourses/fxmusics/bladeSound.wav");
        Music opinelM = TinySound.loadMusic(opinelF);
        Disc opinel = new Disc(opinelM, "opinel", true);
        add(opinel);

        File porteDebloqueF = new File("resourses/fxmusics/doorOpeningSound.wav");
        Music porteDebloqueM = TinySound.loadMusic(porteDebloqueF);
        Disc porteDebloque = new Disc(porteDebloqueM, "porteDebloque", true);
        add(porteDebloque);



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


    //TODO ajouter methode qui repere les musiques en cours d'excution pour changer en même temps leurs volumes
    //TODO peut etre creer divers label de son pour gerer le changement des niveaux de sons separements
}