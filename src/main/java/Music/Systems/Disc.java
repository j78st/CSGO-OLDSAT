package Music.Systems;

import Music.TinySound.Music;

/**
 * Cette classe représente l'objet élémentaire de manipulation de piste sonore : le disque
 */
public class Disc {
    /**
     * Représente le fichier de la piste sonore
     */
    public Music aMusic;

    /**
     * Représente le nom de la piste sonore
     */
    public String name;

    /**
     * Boolèen indiquant la répétition de la piste sonore
     */
    public boolean loop = false;

    /**
     * Ennumération représentant le type de la piste sonore
     */
    public MusicType type;

    /**
     * Durée en secondes de la piste sonore
     */
    public int duration;

    public Disc(Music inMusic, String inName, boolean inLoop, MusicType inType, int inDuration){
        this.aMusic = inMusic;
        this.name = inName;
        this.loop = inLoop;
        this.type = inType;
        this.duration = inDuration;
    }
}