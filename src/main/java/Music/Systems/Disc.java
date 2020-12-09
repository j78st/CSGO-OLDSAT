package Music.Systems;

import Music.TinySound.Music;

//Carnet de l'objet Music
public class Disc {
    public Music aMusic;
    public String name;
    public boolean loop = false;
    public MusicType type;

    public Disc(Music inMusic, String inName, boolean inLoop, MusicType inType){
        this.aMusic = inMusic;
        this.name = inName;
        this.loop = inLoop;
        this.type = inType;
    }
}