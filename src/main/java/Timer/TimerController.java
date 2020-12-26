package Timer;

import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;

public class TimerController extends Thread {
    private volatile Timer timer;
    private volatile boolean stateTimer;
    private volatile Lock lock;

    public TimerController(int secondes){
        this.lock = new Lock();
        timer = new Timer(secondes, this.lock);
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
        WorldBoxDisc.play(Son.errorEnigma);
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
     * Modifie le seuil de tick limite, i.e. la limite de secondes à partir duquelle on entends les ticks de l'horloge
     * @param inTickTime
     */
    public void setTickLimit(int inTickTime){
        timer.setTickTime(inTickTime);
    }
}
