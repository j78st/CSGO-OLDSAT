package Timer;

import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;

import java.util.Objects;
import java.util.Random;


/**
 * Cette classe représente le timer.
 */
public class Timer extends Thread {
    /** Représente le temps totale en seconde du timer
     */
    private int tempsSecondes;
    /**
     * Représente l'état du timer : arrêt/marche
     */
    private volatile boolean stateTimer;
    /**
     * Objet permettant de bloquer le thread
     */
    private volatile Lock lock;
    /**
     * Répresente le seuil de déclenchement des ticks de l'horloge
     */
    private int tickTime;
    /**
     * Répresente le seuil de déclenchement des battements du coeur
     */
    private int heartbeatTickTime;
    /**
     * Réprésente l'activation du son de battement du coeur
     */
    private boolean heartBeat;

    public Timer(int tempsSecondes, Lock inLock){
        this.tempsSecondes = tempsSecondes;
        this.stateTimer = false; //par défaut, le timer est a l'arret
        this.lock = inLock;
        this.tickTime = 60; //par defaut, le son de tick se déclenche sur les trois dernères minutes
        this.heartbeatTickTime = 30; //par defaut le battement du coeur se déclenche sur la dernière minute
        this.heartBeat = false;
    }

    /**
     * Endort le thread du timer pour x ms
     * @param ms
     */
    public static void sleep(int ms){
        try{
            Thread.sleep(ms);
        } catch ( InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * Retire du temps du timer
     * @param secondes
     */
    public synchronized void substractTime(int secondes){ //Exclusion mutuelle requise : le thread peut tourner & la méthode substractTime peut être appelé depuis le main
        this.tempsSecondes -= secondes;
    }

    /**
     * Ajoute du temps au timer
     * @param secondes
     */
    public synchronized  void addTime(int secondes){
        this.tempsSecondes += secondes;
        if(tempsSecondes > heartbeatTickTime){ //En cas d'ajout de temps, le coeur peut n'être plus entendu
           heartBeat = false;
        }
    }

    /**
     * Retourne le nombre total de secondes du timer
     * @return Integer
     */
    public synchronized int getTimeFullSeconds(){
        return tempsSecondes;
    }

    /**
     * Retourne le nombre de minutes restantes du timer
     * @return Integer
     */
    public synchronized int getRemainingMin(){
        return  (int) tempsSecondes/60;
    }

    /**
     * Retourne le nombre de secondes restantes modulo 60 du timer
     * @return Integer
     */
    public synchronized int getRemainingSec(){
        return tempsSecondes%60;
    }

    /**
     * Renvoit le temps restant sous le format string mm:ss
     * @return String
     */
    public synchronized String getRemainingTime(){
        if(getRemainingSec() > 9) {
            return (String) (getRemainingMin() + ":" + getRemainingSec());
        } else {
            return (String) (getRemainingMin() + ":0" + getRemainingSec());
        }
    }

    /**
     * Active/Desactive le timer
     */
    public synchronized void toogleTimer(){
        if(stateTimer){
            stateTimer = false;
        } else {
            stateTimer = true;
            goTimer();
        }
    }

    /**
     * Endort le thread du timer
     */
    public void waitTimer(){
        try {
            synchronized (lock) { //obtention du lock/objet lock
                lock.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Redemarre le thread du timer
     */
    public void goTimer(){
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    /**
     * Modifie le seuil de tick limite, i.e. la limite de secondes à partir de laquelle on entend les ticks de l'horloge
     * @param inTickTime
     */
    public void setTickTime(int inTickTime){
        if(inTickTime >= 10){
            this.tickTime = inTickTime;
        } else {
            System.out.println("Niveau de tick trop bas.");
        }
    }

    /**
     * Modifie le seuil de tick limite pour le coeur du joueur, i.e. la limite de secondes à partir de laquelle on entend les battements du coeurs
     * @param inHeartbeatTickTime
     */
    public void setHeartbeatTickTime(int inHeartbeatTickTime) {
        if(inHeartbeatTickTime >= 10) {
            this.heartbeatTickTime = heartbeatTickTime;
        } else {
            System.out.println("Niveau de tick trop bas.");
        }
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
        Timer timer = (Timer) o;
        return tempsSecondes == timer.tempsSecondes && stateTimer == timer.stateTimer && tickTime == timer.tickTime && heartbeatTickTime == timer.heartbeatTickTime && heartBeat == timer.heartBeat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tempsSecondes, stateTimer, tickTime, heartbeatTickTime, heartBeat);
    }

    @Override
    public void run() {
        while (this.tempsSecondes > 0){
            if(stateTimer) {
                sleep(1000);
                substractTime(1);
                if(this.tempsSecondes < tickTime) { //Passer un certain, on entend un tick signalant que c'est bientot la fin
                    WorldBoxDisc.play(Son.tick);
                }

                if(this.tempsSecondes < this.heartbeatTickTime && !heartBeat){
                    WorldBoxDisc.play(Son.coeur);
                    heartBeat = true;
                }

                //System.out.println(getRemainingTime());
            } else {
                waitTimer(); //bloque le tread pour économiser le cpu
            }
        }
        WorldBoxDisc.pause(Son.coeur);

        //Randomisation du bruit de fin
        Random generator = new Random();
        int value = generator.nextInt(3);
        //La "mort" a pris le joueur
        switch (value){
            case 0: WorldBoxDisc.play(Son.paraMot1);
            break;

            case 1: WorldBoxDisc.play(Son.paraMot2);
            break;

            case 2: WorldBoxDisc.play(Son.paraMot3);
            break;
        }
    }
}
