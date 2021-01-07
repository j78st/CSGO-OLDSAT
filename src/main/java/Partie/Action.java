package Partie;

import Interface.Settings.Engine;

import java.util.ArrayList;

public class Action {
    int id; // numéro d'identification de l'action
    boolean available; // action accessible pour le joueur ou non
    String text; // description textuelle de l'action
    ArrayList<int[]> consequences; // liste de couples définissant les conséquence de l'action, forme : (type de conséquence, argument nécessaire à la réalisation de cette conséquence)

    /**
     * Constructeur pour une action classique, non liée à un objet
     * @param id l'identifiant de l'action
     * @param available indique si l'action est faisable
     * @param text texte décrivant l'action
     * @param consequences tableau des couples de conséquences
     * @param room identifiant de la salle dans laquelle se trouve l'action
     */
    public Action(int id, boolean available, String text, ArrayList<int[]> consequences, int room) { //Action "générale", doable à false pour les déplacement vers salle vérouillées au départ par exemple
        this.id=id;
        this.available = available;
        this.text = text;
        this.consequences=consequences;
        Game.search_room(room).add_action(getId()); // ajoute l'action à la liste des actions réalisables dans la salle à laquelle elle est liée
        Game.actions.add(this); // ajoute l'action à la liste des actions du jeu
    }

    /**
     * Constructeur pour une action liée à un objet
     * @param id l'identifiant de l'action
     * @param text texte décrivant l'action
     * @param consequences tableau des couples de conséquences
     * @param room identifiant de la salle dans laquelle se trouve l'action
     * @param id_item identifiant de l'objet auquel l'action est liée
     */
    public Action(int id,String text, ArrayList<int[]> consequences, int room, int id_item) { //Action liée à un objet
        this.id=id;
        this.available = false;
        this.text = text;
        this.consequences = consequences;
        Game.search_room(room).add_action(getId()); // ajoute l'action à la liste des actions réalisables dans la salle à laquelle elle est liée
        Game.actions.add(this); // ajoute l'action à la liste des actions du jeu
        Game.search_item(id_item).id_actions.add(getId()); // ajoute l'action à la liste des actions nécessitant l'objet renseigné
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<int[]> getConsequences() {
        return consequences;
    }

    public void setConsequences(ArrayList<int[]> consequences) {
        this.consequences = consequences;
    }

    /**
     * Méthode appliquant les conséquences de l'action
     */
    public void do_consequences(){
        for(int i =0;i<getConsequences().size();i++){
            switch (getConsequences().get(i)[0]) {
                case 1: // mouvement vers la salle de numéro d'identification arg_conséquence
                    Game.player.move(getConsequences().get(i)[1]);
                    break;
                case 2: // dévérouillage d'une action de numéro d'identification arg_conséquence
                    Game.search_action(getConsequences().get(i)[1]).setAvailable(true);
                    Engine.engine.refreshAction();
                    break;
                case 3: // vérouillage d'une action de numéro d'identification arg_conséquence
                    Game.search_action(getConsequences().get(i)[1]).setAvailable(false);
                    Engine.engine.refreshAction();
                    break;
                case 4: // ajout de l'objet de numéro d'identification arg_consequence à l'inventaire
                    if(Game.player.add_to_inventory((getConsequences().get(i)[1]))){ // Si l'ajout à l'inventaire se passe bien (il reste de la place dans l'inventaire)
                        Game.search_action(getId()).setAvailable(false); // rend l'obtention de cette objet impossible
                     }
                     break;
                case 5: // suppression de l'objet de numéro d'identification arg_consequence de l'inventaire
                     Game.player.remove_from_inventory(Game.search_item(getConsequences().get(i)[1]).id);
                     break;
                case 6: // utilisation de l'objet de numéro d'identification arg_consequence
                    Game.search_item(getConsequences().get(i)[1]).use_item();
                    break;
                case 7: // affichage d'un nouveau texte (fonctionne aussi pour la demande d'indice)
                    Game.search_room(Game.player.position).text_evolve(Game.search_text(getConsequences().get(i)[1])); // fait évoluer le texte de la salle dans laquelle le joueur se trouve en lui ajoutant le texte ayant pour id le code renseigné
                    break;
                case 8: // rend une salle inaccessible
                    Game.search_room(getConsequences().get(i)[1]).setAccess(false);
                    break;
                case 9: // rend une salle accessible
                    Game.search_room(getConsequences().get(i)[1]).setAccess(true);
                    break;
                case 10: // affiche la boite à réponses
                    Engine.engine.answer_box_visible(true);
                    break;
             }
        }
    }
}
