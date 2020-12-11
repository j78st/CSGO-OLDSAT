package Partie;

public class Scenario {
    // Textes salle 101
    public static Text_scenario room_101_1 = new Text_scenario(1011,"Vous vous tenez au milieu d'une salle." +
            " L'atmosphère y est pesante. Il n'y a aucune fenêtre et vous n'êtes éclairé que par une lueur mystérieuse " +
            "dont vous ne parvenez pas à déterminer la provenance. \n" +
            "A votre droite se trouve une table sur laquelle vous pouvez distinguer un vase et un bout de papier. " +
            "Face à vous, il y a une porte. \n");
    public static Text_scenario room_101_2 = new Text_scenario(1012,"La porte est ouverte.");

    // Texte salle 201 (table salle 101)
    public static Text_scenario room_201_1 = new Text_scenario(2011,"Vous voyez une note sur la table. " +
            "Dessus, une main tremblotante a écrit : \"Sortez vite de là, ils arrivent et ils ne veulent pas de vous ici...\" \n" +
            "Au centre de la table, il y a un vase bleu clair semblant très ancien. \n");
    public static Text_scenario room_201_2 = new Text_scenario(2012,"Vous avez récupéré la clef dans le vase.");

    // Texte salle 203 (vase sur la table salle 101)
    public static Text_scenario room_203_1 = new Text_scenario(2031,"Vous regardez dans le vase, vous voyez une " +
            "clef au fond de celui-ci.");

    // Textes salle 202 (porte salle 101)
    public static Text_scenario room_202_1 = new Text_scenario(2021,"La porte est fermée à double tour. \n" +
            "Elle semble cependant ancienne, " +
            "peut-être ne résistera-t-elle pas à votre épaule \n");
    public static Text_scenario room_202_2 = new Text_scenario(2022, "Vous vous êtes fait mal en essayant" +
            " d'enfoncer cette porte... \n");

    // Texte salle 102
    public static Text_scenario room_102_1 = new Text_scenario(1021,"Éclairée par un puits de lumière, " +
            "cette salle est moins lugubre que la précédente " +
            "mais étonnamment vous vous y sentez plus mal, comme si quelqu'un ou quelque chose vous observait. \n" +
            "La pièce est presque vide. Il n'y a qu'un tableau ornant le mur face à vous et la porte dans votre dos");

    // Texte salle 301 (énigme tableau salle 102)
    public static Text_scenario room_301_1 = new Text_scenario(3011,"Sur le bas du tableau il y a un mécanisme" +
            " similaire à celui d'un cadenas à code. 4 chiffres semblent nécessaire. \n" +
            "Au centre du tableau vous pouvez lire : \"Si votre but est de sortir d'ici, une simple connaissance vous " +
            "est nécessaire : quelle promo de l'ENSSAT est nécessairement la meilleure?\"\n");
    public static Text_scenario room_301_2 = new Text_scenario(3012,"Indice : S'ils n'ont pas redoublé, " +
            "ils sont nés en 1999\n");

    //Texte mauvaise réponse
    public static Text_scenario erreur_404 = new Text_scenario(404,"Il semblerait que votre solution précédemment" +
            " proposée ne soit pas la bonne\n");

    //Texte proposition indice
    public static Text_scenario erreur_405 = new Text_scenario(405,"Il semblerait que vous rencontriez quelques" +
            " difficultés...peut être devriez-vous priez les dieux de l'ENSSAT pour obtenir un indice\n");
}
