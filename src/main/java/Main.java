
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

        WorldBoxDisc.testAllSound(); //test de tout les sons chargé
        //WorldBoxDisc.repeatSound("erreur", 10, 500); //Un meme son peut desormais repete autant de fois que l'on veut, a l'intervalle que l'on veut
        /*
        WorldBoxDisc.play("eclair0");
        sleep(1000);
        WorldBoxDisc.play("eclair1");
        sleep(1000);
        WorldBoxDisc.play("eclair2");
        sleep(1000);
        WorldBoxDisc.play("eclair3");
        */

        //WorldBoxDisc.showLoadedAudioFiles();
        while(true);
    }
}