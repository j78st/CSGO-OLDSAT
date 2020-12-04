
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
        sleep(5000); //Temps d'attente pour le chargement des musiques

        //Plusieurs sons peuvent être joué en même temps
        WorldBoxDisc.play("valid");
        WorldBoxDisc.showLoadedAudioFiles();
        while(true);
    }
}