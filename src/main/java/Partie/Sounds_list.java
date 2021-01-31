package Partie;

import java.util.ArrayList;

public class Sounds_list extends ArrayList {

    public Sounds_list() { //Les "id" ne se suivent pas car suppression de sons inutile à la fin du projet et manque de temps pour tout aller changer dans Scenario_structure
        Game.sounds.add(new String[]{"3","opinel2"});
        Game.sounds.add(new String[]{"6","valid"});
        Game.sounds.add(new String[]{"7","porte1"});
        Game.sounds.add(new String[]{"15","hibou"});
        Game.sounds.add(new String[]{"28","prendre"});
        Game.sounds.add(new String[]{"35","creakingDoor2"});
        Game.sounds.add(new String[]{"37","breakingWood"});
        Game.sounds.add(new String[]{"41","drawerOpening"});
        Game.sounds.add(new String[]{"43","steps3"});
        Game.sounds.add(new String[]{"45","keyTurning2"});
        Game.sounds.add(new String[]{"47","leverSound"});
        Game.sounds.add(new String[]{"50","turningPage"});
        Game.sounds.add(new String[]{"52","menuTheme"});
        Game.sounds.add(new String[]{"53","zip"});
        Game.sounds.add(new String[]{"54","switch1"});
        Game.sounds.add(new String[]{"55","classRoom"});
        Game.sounds.add(new String[]{"56","outside"});
        Game.sounds.add(new String[]{"58","doorShoulder"});
        Game.sounds.add(new String[]{"59","gameTheme"});
    }



}


