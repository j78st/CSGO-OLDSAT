
import Music.Systems.WorldBoxDisc;

public class Main {
    public static void sleep(int n){
        try{
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WorldBoxDisc.init(); //Initialise toutes les pistes
        sleep(3000); //Temps d'attente pour le chargement des musiques

        //Plusieurs sons peuvent être joué en même temps
        WorldBoxDisc.play("wind"); //Système qui appelle les musiques selon un nom unique au format String
        WorldBoxDisc.play("opinel");
        WorldBoxDisc.play("porteDebloque");
        WorldBoxDisc.getVolume("wind");
        sleep(1000);
        WorldBoxDisc.setVolume("wind", 10);
        sleep(1000);
        WorldBoxDisc.setVolume("porteDebloque", 15);
        WorldBoxDisc.showLoadedAudioFiles();
        while(true);
    }
}