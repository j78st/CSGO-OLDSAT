package Timer;

import Interface.Save.SaveSlot;
import Interface.Save.Saves;
import Interface.ScreenLoader.LoadMap;
import Interface.Settings.Engine;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import Partie.Game;
import Serialization.Memoire;
import Serialization.Serial_game;
import javafx.application.Platform;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;


/**
 * Cette classe représente le timer.
 */
public class Timer extends Thread {
    /** Représente le temps total en seconde du timer
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
     * Représente le seuil de déclenchement des ticks de l'horloge
     */
    private volatile int tickTime;
    /**
     * Représente le seuil de déclenchement des battements du coeur
     */
    private volatile int heartbeatTickTime;
    /**
     * Représente l'activation du son de battement du coeur
     */
    private volatile boolean heartBeat;

    /**
     * Booleen representant l'état du thread du timer
     */
    private volatile boolean done = false;

    /**
     * Booléen qui permet le testJUnit
     * Par défaut, il est mis à faux.
     */
    private boolean testMode = false;

    public Timer(int tempsSecondes, Lock inLock){
        this.tempsSecondes = tempsSecondes;
        this.stateTimer = false; //par défaut, le timer est à l'arret
        this.lock = inLock;
        this.tickTime = 60; //par defaut, le son de tick se déclenche sur les trois dernières minutes
        this.heartbeatTickTime = 30; //par defaut le battement du coeur se déclenche sur la dernière minute
        this.heartBeat = false;
    }

    /**
     * Indique si le timer est actif
     * @return
     */
    public boolean isDone() {
        return done;
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
        if(this.tempsSecondes - secondes < 0) {
            this.tempsSecondes = 0;
        } else {
            this.tempsSecondes -= secondes;
        }
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
            WorldBoxDisc.pause(Son.coeur);
        } else {
            stateTimer = true;
            heartBeat = false; //Pour redemarrer le son
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

    /**
     * Termine le thread du timer
     */
    public void finish(){
        done = true;
    }

    /**
     * Permet le test JUnit
     */
    public void junit(){
        this.testMode = true;
    }

    @Override
    public void run() {
        while (this.tempsSecondes > 0 && !done){
            if(stateTimer) {
                // Update affichage GUI
                if(!this.testMode) { //Si on est pas en mode test, maj des éléments graphiques
                    Platform.runLater(() -> Engine.engine.timer_lbl.setText(getRemainingTime()));
                }

                // Déclenchement tick horloge (3 min restantes)
                if(this.tempsSecondes < tickTime && stateTimer) {
                    WorldBoxDisc.play(Son.tick);
                }

                // Déclenchement battement coeur (1 min restantes)
                if(this.tempsSecondes < this.heartbeatTickTime && !heartBeat && stateTimer){
                    WorldBoxDisc.play(Son.coeur);
                    heartBeat = true;
                }

                sleep(1000); //Deplacement de la soustraction pour régler des problèmes de synchronisation entre écrans paramètres et de jeu
                substractTime(1);
                if(this.tempsSecondes % 60 == 0){
                    // VVV sauvegarde VVV
                    File file = new File("resources/json/saves.json");
                    Memoire m = new Memoire();
                    Saves saves = (Saves) m.read_data(file); // récupération des saves

                    // recherche du bon slot par pseudo /!\ -> ca peut generer des problemes
                    boolean saved = false;
                    for (int i = 0; i < 10; i++) {
                        if ((saves.getSave(i).srgame != null) || (!saved && Game.player.getPseudo().equals(saves.getSave(i).srgame.player.getPseudo()))) {
                            saves.setSave(i, new SaveSlot(i, new Serial_game()));
                            saved = true;
                        }
                    }

                    try {
                        m.write_data(saves, file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                waitTimer(); //bloque le tread pour économiser le cpu
            }
        }
        WorldBoxDisc.pause(Son.coeur);

        if(!done) { //Sortit lie à la terminaison du timer
            // affichage écran de fin
            Platform.runLater(() -> {
                try {
                    LoadMap gl = new LoadMap();
                    gl.display_screen_from_id(LoadMap.END_GAME);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


            //Randomisation du bruit de fin
            Random generator = new Random();
            int value = generator.nextInt(3);
            //La "mort" a pris le joueur
            switch (value) {
                case 0:
                    WorldBoxDisc.play(Son.paraMot1);
                    break;

                case 1:
                    WorldBoxDisc.play(Son.paraMot2);
                    break;

                case 2:
                    WorldBoxDisc.play(Son.paraMot3);
                    break;
            }
        }
    }
}
