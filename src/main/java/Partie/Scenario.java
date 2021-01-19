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
            "suivi d'une fléche pointant un couloir en face de vous.\n\n" +
            "[Tutoriel]\n" +
            "Vous pouvez noter que cette action a débloqué la flèche de déplacement vers le haut vous permettant d'accéder à la salle suivante.\n" +
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

    public Text_scenario room_103_6 = new Text_scenario(1036,"vous vous rendez à la sortie de l'amphithéâtre.\n");

    //Texte extérieur
    public Text_scenario room_104_1 = new Text_scenario(1041,"Vous sortez du bâtiment.\n" +
            "À l'extérieur, les étudiants se regroupent en petit comité pour débriefer cette conférence.\n" +
            "Votre journée de cours est finie.\n" +
            "Vous pouvez vous joindre à l'un des groupes pour discuter ou bien rentrer chez vous directement.\n\n");

    public Text_scenario room_104_2 = new Text_scenario(1042,"Vous rejoignez un groupe d'étudiant et " +
            "parler de tout et de rien pendant une dizaine de minutes.\n\n" +
            "[Tutoriel]\n" +
            "Certaines actions comme celle-ci ne dévérouillent rien et n'ont aucune incidence sur le déroulement de l'histoire.");




    public Text_scenario room_107_1 = new Text_scenario(1071,"Vous êtes dans la bibliothèque de l'ENSSAT.\n" +
            "La porte s'est refermée derrière vous. C'est surement dû à un courant d'air.\n\n");

    public Text_scenario room_107_2 = new Text_scenario(1072,"La porte est vérrouillée : impossible de l'ouvrir.\n" +
            "Il va vous falloir trouver un autre moyen de sortir d'ici, mais vous ne voyez aucune autre porte...");

}
