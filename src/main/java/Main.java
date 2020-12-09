
import Music.Systems.MusicType;
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

        //WorldBoxDisc.toogleSoundFx();
        //WorldBoxDisc.allTypeSounds(MusicType.SoundFx);
        //sleep(1000);
        //WorldBoxDisc.testAllSound();



        /*
        WorldBoxDisc.play("wind");
        sleep(6000);
        WorldBoxDisc.setSoundBackground(15);
        sleep(6000);
        WorldBoxDisc.setSoundBackground(5);
        WorldBoxDisc.statusSounds();
        WorldBoxDisc.allTypeSounds(MusicType.SoundFx);
        WorldBoxDisc.allTypeSounds(MusicType.Background);
        */
        WorldBoxDisc.testAllSound();
        while(true);
    }
}