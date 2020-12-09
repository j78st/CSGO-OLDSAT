package Partie;

public class Text_scenario {
    int id_text; // id de la forme numéro de salle + numéro du texte dans la salle (ex 1er texte de la salle 101 : 1011)
    String text;

    public Text_scenario(int id_text, String text) {
        this.id_text = id_text;
        this.text = text;
        Game.scenario.add(this);
    }

    public int getId_text() {
        return id_text;
    }

    public String getText() {
        return text;
    }
}
