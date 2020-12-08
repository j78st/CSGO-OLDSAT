package Partie;

public class Action {
    String text;
    int consequence;


    public Action(String text, int consequence) {
        this.text = text;
        this.consequence = consequence;
    }

    public void move(int destination){
        Game.player.move(destination);
    }

    public void Consequence(){
        switch (this.consequence) {
            case 1:
                move(Game.map.get_room(Game.player.position).neighbours[0]);
                break;
            case 2:
                move(Game.map.get_room(Game.player.position).neighbours[1]);
                break;
            case 3:
                move(Game.map.get_room(Game.player.position).neighbours[2]);
                break;
            case 4:
                move(Game.map.get_room(Game.player.position).neighbours[3]);
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
