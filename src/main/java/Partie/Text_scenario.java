package Partie;

public class Text_scenario {
    int id; // id de la forme : numéro de salle + numéro du texte dans la salle (ex 1er texte de la salle 1001 : 10011)
    String text;

    public Text_scenario(int id, String text) {
        this.id = id;
        this.text = text;
        Game.texts.add(this);
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }
}
