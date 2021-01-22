package Timer;

import Music.Systems.WorldBoxDisc;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.util.Random;


import static org.junit.Assert.*;

/**
 * Classe de test de la classe Timer
 */

public class TimerTest {

    /**
     * Initialise les données nécessaires aux tests. Ici, les pistes sonores avant le début de tous les tests.
     */
    @BeforeClass
    public static void init() {
        WorldBoxDisc.init();
    }

    /**
     * Teste l'ajout de temps à un timer
     */
    @Test
    public void testAddTime(){
        TimerController timer1 = new TimerController(60);
        TimerController oracle = new TimerController(120);
        timer1.bonusTime(60);

        assertEquals("Cette méthode devrait ajouter du temps à un timer.", timer1, oracle); //Il faut redefinir la méthode equals pour que cela marche
    }

    /**
     * Teste la diminution de temps à un timer dans un cas quelconque (i.e. seconde > tempsTimer)
     */
    @Test
    public void testSubTime(){
        TimerController timer1 = new TimerController(60);
        TimerController oracle = new TimerController(30);
        timer1.penaltyTime(30);
        assertEquals("Cette méthode devrait soustraire du temps à un timer.", timer1, oracle);
    }

    /**
     * Tester plusieurs opérations d'additions successives sur le timer
     */
    @Test
    public void testCombinationAddTime(){
        Random generator = new Random();
        int value = generator.nextInt(15);
        TimerController timer1 = new TimerController(60);

        TimerController oracle = new TimerController(60+value*30);
        for(int i = 0; i < value; i++) {
            timer1.bonusTime(30);
        }
        assertEquals("Cette méthode devrait ajouter du temps à un timer.", timer1, oracle);
    }

    /**
     * Teste le cas où le nombre de seconde de pénalité soustraite au temps est inférieur au temps restant
     */
    @Test
    public void testSubTimeGreaterThanCurrentTime(){
        TimerController timer1 = new TimerController(15);
        TimerController oracle = new TimerController(0);
        timer1.penaltyTime(180); //15<180

        assertEquals("Cette méthode devrait devrait vérifier qu'il ne reste plus de temps au timer.", timer1, oracle);
    }

    /**
     * Teste qu'au bout d'un certain temps aléatoire, le timer est terminé
     */
    @Test
    public void testTimeRemaining(){
        Random generator = new Random();
        int clockTime = generator.nextInt(3)+3; //Temps de l'horloge varie entre 5 et 3s
        TimerController timer1 = new TimerController(clockTime+10);
        TimerController oracle = new TimerController(10);

        timer1.junit();
        timer1.start();

        Timer.sleep(clockTime*1000 + 1000);
        assertEquals("Cette méthode devrait montrer qu'il reste 10s au temps du timer.", oracle.getTimeFullSeconds(),timer1.getTimeFullSeconds());
    }

}
