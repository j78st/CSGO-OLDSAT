package Partie;

public class Action {
    int id;
    String text;
    int consequence;
    int arg_consequence;
    boolean doable;


    public Action(int id,String text, int consequence, int arg_consequence, Room room, boolean doable) { //Action "générale", doable à false pour les déplacement vers salle vérouillées au départ par exemple
        this.id=id;
        this.text = text;
        this.consequence = consequence;
        this.arg_consequence = arg_consequence;
        this.doable = doable;
        room.add_action(this);
        Game.actions.add(this);
    }

    public Action(int id,String text, int consequence, int arg_consequence, Room room, Gear gear) { //Action liée à un objet
        this.id=id;
        this.text = text;
        this.consequence = consequence;
        this.arg_consequence = arg_consequence;
        this.doable = false;
        room.add_action(this);
        Game.actions.add(this);
        gear.actions.add(this);
    }

    public void setDoable(boolean doable) {
        this.doable = doable;
    }

    public void Consequence(){
        switch (this.consequence) {
            case 1: // mouvement vers la salle arg_conséquence
                Game.player.move(this.arg_consequence);
                break;
            case 2: // dévérouillage d'une action
                Game.search_action(this.arg_consequence).setDoable(true);
                break;
            case 3: // vérouillage d'une action
                Game.search_action(this.arg_consequence).setDoable(false);
                break;
            case 4: // ajout de l'objet arg_consequence à l'inventaire
                Game.player.add_inventory(Game.search_gear(arg_consequence));
                break;
            case 5: // suppression de l'objet arg_consequence de l'inventaire
                Game.player.remove_inventory(Game.search_gear(arg_consequence));
                break;
            case 6: // utilisation de l'objet arg_consequence
                Game.search_gear(arg_consequence).use_gear();
                break;
            case 7: // résultat d'une énigme
                break;
        }
    }




    /* texte = table + porte = 2 actions
    1 -> action : voir table -> sous salle table
    2 -> voir porte -> sous-salle porte -> fermé atm
    3 -> table -> action : voir vase -> ss ss salle vase
    4 -> clé : pick up objet
    5 -> retour -> retour
    6 -> porte -> action -> énigme serrure -> solution : use clé
    7 -> message clignotement de la salle?/minimap? + conséquence (accès salle 2)
    8 -> tableau(ss salle) -> énigme -> résultat à écrire

     */
}
