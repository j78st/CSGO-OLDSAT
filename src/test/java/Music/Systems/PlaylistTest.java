package Music.Systems;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class PlaylistTest {
    /**
     * Vérifie l'ajout d'une piste à une playlist en mode régulier
     */
    @Test
    public void addTrackRegularMode(){
        ArrayList<String> arrayOracle = new ArrayList<>();
        arrayOracle.add(Son.steps3);
        arrayOracle.add(Son.hibou);
        PlayList oracle = new PlayList(arrayOracle);


        PlayList playList = new PlayList();
        playList.addSound(Son.steps3); //Ajout sur la playlist
        playList.addSound(Son.hibou);
        assertEquals("Cette méthode vérifie que l'ajout d'une piste dans une playlist en mode régulier s'est bien déroulé.", oracle, playList);
    }

    /**
     * Vérifie l'ajout d'une piste à une playlist en mode irrégulier
     */
    @Test
    public void addTrackIrregularMode(){
        ArrayList<String> arrayOracle = new ArrayList<>();
        ArrayList<Integer> arrayTimeOracle = new ArrayList<>();
        arrayTimeOracle.add(1);
        arrayOracle.add(Son.steps3);
        arrayOracle.add(Son.hibou);
        PlayList oracle = new PlayList(arrayOracle, arrayTimeOracle);

        ArrayList<String> array = new ArrayList<>();
        ArrayList<Integer> arrayTime = new ArrayList<>();
        array.add(Son.steps3);
        PlayList playList = new PlayList(array, arrayTime);
        playList.addSound(Son.hibou);
        playList.addTime(1);
        assertEquals("Cette méthode vérifie que l'ajout d'une piste dans une playlist en mode irrégulier s'est bien déroulé.", oracle, playList);
    }

    /**
     * Vérifie la modification du temps entre pistes d'une playlist en mode régulier s'est bien déroulé
     */
    @Test
    public void modifyTimeInBetweenRegularMode(){
        PlayList playList = new PlayList();
        int oracle = playList.getTimeInBetween();

        playList.setTimeInBetween(oracle + 5);
        int res = playList.getTimeInBetween();
        assertEquals("Cette méthode vérifie la modification du temps entre pistes d'une playlist.", oracle + 5, res);
    }

    /**
     * Vérifie l'ajout d'entre-temps en mode irrégulier de la playlist
     */
    @Test
    public void addTimeInBetweenIrregularMode(){
        ArrayList<String> arrayOracle = new ArrayList<>();
        ArrayList<String> array = new ArrayList<>();
        ArrayList<Integer> timeOracle = new ArrayList<>();
        ArrayList<Integer> time = new ArrayList<>();

        arrayOracle.add(Son.hibou);
        arrayOracle.add(Son.steps3);
        timeOracle.add(0);

        PlayList oracle = new PlayList(arrayOracle, timeOracle);

        array.add(Son.hibou);
        PlayList playlist = new PlayList(array, time);

        playlist.addSound(Son.steps3);
        playlist.addTime(0);
        assertEquals("Cette méthode vérifie l'ajout d'entre-temps en mode irrégulier de la playlist s'est bien déroulé.", oracle, playlist);
    }

    /**
     * Vérifie la génération d'erreur en cas d'ajout d'un entre-temps en trop dans le cadre d'une playlist en mode irrégulier
     */
    @Test
    public void addTooMuchTimeInBetweenIrregularMode(){
        ArrayList<String> array = new ArrayList<>();
        ArrayList<Integer> time = new ArrayList<>();

        array.add(Son.hibou);
        PlayList playList = new PlayList(array, time);

        Exception myException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> playList.addTime(0), //Temps ajoutés en trop
                "Une erreur d'ajout de temps en trop doit être lancé.");

        assertTrue(myException.getMessage().contains(""));
    }

    /**
     * Vérifie la génération d'erreur en cas d'ajout de temps dans le mauvais mode
     */
    @Test
    public void addTimeInWrongMode(){
        ArrayList<String> array = new ArrayList<>();

        array.add(Son.hibou);
        PlayList playList = new PlayList(array);

        Exception myException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> playList.addTime(0), //Temps ajoutés en trop
                "Une erreur d'ajout de temps dans le mauvais mode doit être lancé.");

        assertTrue(myException.getMessage().contains(""));
    }
}
