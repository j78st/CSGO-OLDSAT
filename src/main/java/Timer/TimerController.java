package Timer;

import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;

import java.util.Objects;

/**
 * Cette classe représente le controller du timer.
 */

public class TimerController extends Thread {
    /**
     * Représente l'objet timer qui sera controllé
     */
    private volatile Timer timer;

    /**
     * Objet bloquant commun au timer et son controller
     */
    private volatile Lock lock;

    /**
     * Temps initial total du timer
     */
    private int timeSeconds;

    public TimerController(int secondes){
        this.lock = new Lock();
        this.timeSeconds = secondes;
        timer = new Timer(this.timeSeconds, this.lock);
        this.setDaemon(true); // termine le thread quand l'application est quittée
    }

    @Override
    public void run() {
        timer.toogleTimer();
        timer.run();
    }

    /**
     * Active/Desactive le timer
     */
    public synchronized void toogleTimer(){
        timer.toogleTimer();
    }

    /**
     * Retire du temps du timer
     * @param secondsTaken
     */
    public synchronized void penaltyTime(int secondsTaken){
        timer.substractTime(secondsTaken);
    }

    /**
     * Ajoute du temps au timer
     * @param secondsAdded
     */
    public synchronized void bonusTime(int secondsAdded){
        WorldBoxDisc.play(Son.bonusTime);
        timer.addTime(secondsAdded);
    }

    /**
     * Retourne le nombre de minutes restantes du timer
     * @return Integer
     */
    public synchronized int getRemainingMin(){
        return timer.getRemainingMin();
    }

    /**
     * Retourne le nombre de secondes restantes modulo 60 du timer
     * @return Integer
     */
    public synchronized int getRemainingSec(){
        return timer.getRemainingSec();
    }

    /**
     * Renvoit le temps restant sous le format string mm:ss
     * @return String
     */
    public synchronized String getRemainingTime(){
        return timer.getRemainingTime();
    }

    /**
     * Retourne le nombre total de secondes du timer
     * @return Integer
     */
    public synchronized int getTimeFullSeconds(){
        return timer.getTimeFullSeconds();
    }

    /**
     * Modifie le seuil de tick limite, i.e. la limite de secondes à partir duquelle on entend les ticks de l'horloge
     * @param inTickTime
     */
    public void setTickLimit(int inTickTime){
        timer.setTickTime(inTickTime);
    }

    /**
     * Modifie le seuil de tick limite, i.e. la limite de secondes à partir duquelle on entend les battements de coeur
     * @param inHeartBeatTickLimit
     */
    public void setHeartBeatTickLimit(int inHeartBeatTickLimit){
        timer.setHeartbeatTickTime(inHeartBeatTickLimit);
    }

    /**
     * Redefinition de la methode equals pour les tests junits
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimerController that = (TimerController) o;
        return timer.equals(that.timer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timer, timeSeconds);
    }

    /**
     * Tue le chronometre et renvoit le temps restant en secondes
     */
    public int killTimer(){
            timer.finish();
            return timer.getTimeFullSeconds();
    }

    /**
     * Permet de désactiver une composante JavaFX pour les tests JUnit
     */
    public void junit(){
        this.timer.junit();
    }

}
