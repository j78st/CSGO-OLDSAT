package Partie;

public class Scenario {

    //Texte Entrée de l'ENSSAT prologue - salle numéro 101

    public Text_scenario room_101_1 = new Text_scenario(1011,"Salutations "+Game.getPlayer().getPseudo()+".\n\n" +
            "Vous avez été admis à l’ENSSAT, l’École Nationale Supérieure des Sciences Appliquées et de Technologie, " +
            "c’est génial n’est-ce pas ?\n" +
            "C'est votre premier jour et vous arrivez dans le hall d'entrée de l'ENSSAT dans lequel vous trouvez un groupe de nouveaux élèves, " +
            "vous êtes un peu stressé.\n" +
            "Vous savez que vous devez rejoindre une salle libellée 137C mais vous n'avez aucune idée de comment vous y rendre.\n\n" +
            "[Tutoriel]\n" +
            "Remarquez la liste des actions disponibles sur votre écran, vous pouvez en sélectionner une en cliquant dessus " +
            "puis appuyer sur le bouton \"Valider action\" pour l'exécuter.\n\n");

    public Text_scenario room_101_2 = new Text_scenario(1012,"Vous demandez votre chemin à l'accueil qui est sur votre droite. " +
            "À travers la vitre une jeune femme vous répond gentillement : " + "\"Suivez simplement les panneaux, ils sont là pour vous guider.\"\n" +
            "Effectivement, il y avait un panneau au milieu du hall que vous n'aviez pas vu, il était caché par la foule.\n\n" +
            "[Tutoriel]\n" +
            "L'action que vous avez effectué a déverouillée une nouvelle action, celle de lire le panneau.\n\n");

    public Text_scenario room_101_3 = new Text_scenario(1013,"Vous lisez le panneau face à vous : \"Amphi 137C\" " +
            "suivi d'une fléche pointant un couloir sur votre gauche.\n\n" +
            "[Tutoriel]\n" +
            "Vous pouvez noter que cette action a débloqué la flèche de déplacement vers la gauche vous permettant d'accéder à la salle suivante.\n" +
            "Les actions peuvent avoir une multitude de conséquences diverses comme vous donner accès à de nouveaux lieux " +
            "ou encore débloquer d'autres actions. Ainsi, pensez à parfois revenir sur vos pas, " +
            "certaines choses auraient pu se débloquer depuis votre dernier passage.");

    //Texte amphi avant conférence

    public Text_scenario room_102_1 = new Text_scenario(1021,"Vous suivez les flèches qui vous mènent dans un couloir " +
            "duquel vous pouvez apercevoir sur votre gauche une cour intérieure à travers des baies vitrées, " +
            "puis vous tournez à droite avant d'emprunter un escalier. " +
            "Arrivé au premier étage vous prenez à gauche pour enfin découvrir l'amphithéâtre 137C.\n" +
            "Cette école à l'air d'être un vrai labyrinthe. Cela pourrait être intéressant de revenir plus tard pour l'explorer.\n\n" +
            "Vous vous installez dans les gradins, ni trop bas ni trop haut. Après votre arrivée la salle se remplie progressivement.\n" +
            "Au bout d'un moment, les intervenants demandent le silence avant de commencer leur présentation.");

    //Texte amphithéâtre après conférence
    public Text_scenario room_103_1 = new Text_scenario(1031,"La conférence touche à sa fin. " +
            "Rien d'extravagant, des consignes de sécurité, des présentations de locaux et " +
            "une introduction aux différentes formations proposées par l'école, exactement ce à quoi vous vous attendiez.\n" +
            "L'amphithéâtre commence à se vider, vous jetez un coup d'oeil rapide dans la salle et vous apercevez une trousse abandonnée sur une table, " +
            "c'est étrange car vous êtes convaincu que personne n'était assis à cette place pendant la conférence.\n" +
            "Pour satisfaire votre curiosité, vous vous approchez de cette trousse avant de partir.\n\n");

    //Texte trousse
    public Text_scenario room_201_1 = new Text_scenario(2011,"Vous regardez à l'intérieur de la trousse.\n" +
            "Vous y trouvez des objets habituels : quelques stylos, un surligneur, une gomme, un compas ... " +
            "Mais il y a aussi des choses plus étonnantes : une loupe et un opinel. Le propriétaire de cette trousse doit être bizarre. " +
            "Qui garde une loupe et un opinel dans sa trousse ?\n\n" +
            "[Tutoriel]\n" +
            "Vous pouvez prendre un objet dans cette trousse. Attention ce choix est définitif et aura un impact sur la suite de votre aventure.\n" +
            "Vous pouvez aussi revenir en arrière en appuyant sur la flèche de déplacement.");

    public Text_scenario room_103_2 = new Text_scenario(1032,"Après avoir récupéré ");

    public Text_scenario room_103_3 = new Text_scenario(1033,"un compas ");

    public Text_scenario room_103_4 = new Text_scenario(1034,"une loupe ");

    public Text_scenario room_103_5 = new Text_scenario(1035,"un petit opinel ");

    public Text_scenario room_103_6 = new Text_scenario(1036,"vous quittez la salle.\n" +
            "Votre journée de cours est finie, vous pouvez vous balader dans l'ENSSAT ou bien finir le prologue.");



    //Texte hall enssat de nuit
    public Text_scenario room_104_1 = new Text_scenario(1041,"Ici commence votre véritable aventure.\n" +
            "Vous vous rendez à l'ENSSAT pour visiter l'école. Il est 20 heures exactement, " +
            "vous le savez car vous entendez les bruits de cloche provenant de l'église voisine, " +
            "le son vous semble d'ailleurs anormalement proche.\n" +
            "Quoi qu'il en soit, vous reconnaissez les lieux, vous êtes dans le hall d'accueil de l'ENSSAT\n\n");

    public Text_scenario room_104_2 = new Text_scenario(1042,"Il n'y a pas grand chose à voir, " +
            "l'endroit est désert, toutefois vous retrouvez le panneau indiquant la salle 137C, celui qui vous a guidé le matin même. " +
            "Personne n'a pris le temps de le ranger, bizarre ...\n" +
            "Soudain, les bruits de cloche s'arrêtent et laissent place à un silence assez pensant. " +
            "Vous décidez de ne pas rester là, pourquoi ne pas suivre la direction indiquée par le panneau, après tout vous connaissez déjà ce chemin");

    public Text_scenario room_105_1 = new Text_scenario(1051, "Vous vous dirigez vers le couloir, vos bruits de pas sont anormalement forts.\n" +
            "Après quelques pas vous vous arrêtez net, vous êtes stupéfait, ce couloir n'est pas le même que celui que vous avez emprunté ce matin. " +
            "Celui-ci est bien plus grand, l'ambiance y est assez pesante.\n" +
            "Sur votre droite, vous remarquez une porte sur laquelle vous lisez \"Bibliothèque\".\n\n");

    public Text_scenario room_211_1 = new Text_scenario(2111, "La porte est ancienne, elle détonne complétement avec le reste du bâtiment.\n" +
            "Vous apercevez une légère lueur émanant par-dessous la porte.");

    public Text_scenario room_105_3 = new Text_scenario(1052, "La porte n'est pas fernée mais elle est très lourde.\n" +
            "En vous aidant de votre épaule, vous arrivez à l'ouvrir");

    public Text_scenario room_107_1 = new Text_scenario(1071,"Votre êtes dans la bibliothèque de l'ENSSAT.");

            // Scenario Test
    /*// Textes salle 101
    public static Text_scenario room_101_1 = new Text_scenario(10011,"Vous vous tenez au milieu d'une salle." +
            " L'atmosphère y est pesante. Il n'y a aucune fenêtre et vous n'êtes éclairé que par une lueur mystérieuse " +
            "dont vous ne parvenez pas à déterminer la provenance. \n" +
            "A votre droite se trouve une table sur laquelle vous pouvez distinguer un vase et un bout de papier. " +
            "Face à vous, il y a une porte. \n");
    public static Text_scenario room_101_2 = new Text_scenario(10012,"La porte est ouverte.");

    // Texte salle 201 (table salle 101)
    public static Text_scenario room_201_1 = new Text_scenario(20011,"Vous voyez une note sur la table. " +
            "Dessus, une main tremblotante a écrit : \"Sortez vite de là, ils arrivent et ils ne veulent pas de vous ici...\" \n" +
            "Au centre de la table, il y a un vase bleu clair semblant très ancien. \n");
    public static Text_scenario room_201_2 = new Text_scenario(20012,"Vous avez récupéré la clef dans le vase.");

    // Texte salle 203 (vase sur la table salle 101)
    public static Text_scenario room_203_1 = new Text_scenario(20031,"Vous regardez dans le vase, vous voyez une " +
            "clef au fond de celui-ci.");

    // Textes salle 202 (porte salle 101)
    public static Text_scenario room_202_1 = new Text_scenario(20021,"La porte est fermée à double tour. \n" +
            "Elle semble cependant ancienne, " +
            "peut-être ne résistera-t-elle pas à votre épaule \n");
    public static Text_scenario room_202_2 = new Text_scenario(20022, "Vous vous êtes fait mal en essayant" +
            " d'enfoncer cette porte... \n");

    // Texte salle 102
    public static Text_scenario room_102_1 = new Text_scenario(10021,"Éclairée par un puits de lumière, " +
            "cette salle est moins lugubre que la précédente " +
            "mais étonnamment vous vous y sentez plus mal, comme si quelqu'un ou quelque chose vous observait. \n" +
            "La pièce est presque vide. Il n'y a qu'un tableau ornant le mur face à vous et la porte dans votre dos");

    // Texte salle 301 (énigme tableau salle 102)
    public static Text_scenario room_301_1 = new Text_scenario(30011,"Sur le bas du tableau il y a un mécanisme" +
            " similaire à celui d'un cadenas à code. 4 chiffres semblent nécessaire. \n" +
            "Au centre du tableau vous pouvez lire : \"Si votre but est de sortir d'ici, une simple connaissance vous " +
            "est nécessaire : quelle promo de l'ENSSAT est nécessairement la meilleure?\"\n");
    public static Text_scenario room_301_2 = new Text_scenario(30012,"Indice : S'ils n'ont pas redoublé, " +
            "ils sont nés en 1999\n");

    //Texte mauvaise réponse
    public static Text_scenario erreur_404 = new Text_scenario(4004,"Il semblerait que votre solution précédemment" +
            " proposée ne soit pas la bonne\n");

    //Texte proposition indice
    public static Text_scenario erreur_405 = new Text_scenario(4005,"Il semblerait que vous rencontriez quelques" +
            " difficultés...peut être devriez-vous priez les dieux de l'ENSSAT pour obtenir un indice\n");*/
}
