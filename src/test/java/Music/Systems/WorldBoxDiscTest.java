package Music.Systems;

import Timer.Timer;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class WorldBoxDiscTest {
    @BeforeClass
    public static void init() {
        WorldBoxDisc.init();
    }

    /**
     * Vérifie que l'augmentation du son fonctionne
     */
    @Test
    public void increaseVolume(){
        double currentVolume = WorldBoxDisc.getVolume(Son.hibou);
        double oracle = currentVolume + 4;
        WorldBoxDisc.setVolume(Son.hibou, currentVolume + 4);
        assertEquals("Cette méthode vérifie l'augmentation du volume.", oracle, WorldBoxDisc.getVolume(Son.hibou), 0.1);
    }

    /**
     * Vérifie que la diminution du son fonctionne
     */
    @Test
    public void lowerVolume(){
        double currentVolume = WorldBoxDisc.getVolume(Son.hibou);
        double oracle = currentVolume - 4;
        WorldBoxDisc.setVolume(Son.hibou, currentVolume - 4);
        assertEquals("Cette méthode vérifie l'augmentation du volume.", oracle, WorldBoxDisc.getVolume(Son.hibou), 0.1);
    }

    /**
     * Vérifie qu'une piste sonore est en cours de lecture
     */
    @Test
    public void musicIsPlaying(){
        boolean oracle = true;
        WorldBoxDisc.play(Son.outside);
        assertEquals("Cette méthode vérifie qu'une piste sonore est en cours de lecture.", WorldBoxDisc.isPlaying(Son.outside), oracle);
    }

    /**
     * Vérifie qu'une piste sonore s'est arrétée
     */
    @Test
    public void musicIsDone(){
        boolean oracle = true;
        WorldBoxDisc.play(Son.zip);
        Timer.sleep(2000);
        assertEquals("Cette méthode vérifie qu'une piste sonore s'est bien terminé.", WorldBoxDisc.isDone(Son.zip), oracle);
    }

    /**
     * Vérifie que la mise à jour du niveau sonore de tous les sons s'est correctement effectuée
     */
    @Test
    public void testSetAllSound(){
        double currentvolume = WorldBoxDisc.defaultSoundVolume;
        double oracle = currentvolume + 2;
        WorldBoxDisc.setAllSound(currentvolume + 2);
        assertEquals("Cette méthode vérifie que tous les sons sont mis au bon niveau sonore.", oracle, WorldBoxDisc.getVolume(Son.hibou), 0.1);
    }

    /**
     * Vérifie que la mise à jour du niveau sonore des effets sonores s'est correctement effectuée
     */
    @Test
    public void testSetAllFxSound(){
        double currentvolume = WorldBoxDisc.defaultSoundFx;
        double oracle = currentvolume + 2;
        WorldBoxDisc.setSoundFx(currentvolume + 2);
        assertEquals("Cette méthode vérifie que tous les effets sonores sont mis au bon niveau sonore.", oracle, WorldBoxDisc.getVolume(Son.hibou), 0.1);
    }

    /**
     * Vérifie que la mise à jour du niveau sonore des fonds sonores s'est correctement effectuée
     */
    @Test
    public void testSetAllBackgroundSound(){
        double currentvolume = WorldBoxDisc.defaultSoundBg;
        double oracle = currentvolume + 2;
        WorldBoxDisc.setSoundBackground(currentvolume + 2);
        assertEquals("Cette méthode vérifie que tous les effets sonores sont mis au bon niveau sonore.", oracle, WorldBoxDisc.getVolume(Son.hibou), 0.1);
    }
}
