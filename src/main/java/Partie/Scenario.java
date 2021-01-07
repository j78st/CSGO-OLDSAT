package Partie;

public class Scenario {

    //Texte Entrée de l'ENSSAT prologue - salle numéro 101
    public static Text_scenario room_101_1 = new Text_scenario(1011, "  Enfin, vous venez d’être admis à l’ENSSAT." +
            " L’Ecole Nationale Supérieur des Sciences Appliquées et de Technologie. C’est génial n’est-ce pas ? " +
            "Peu importe, commençons. \n" +
            "   Vous vous tenez dans le hall d'entrée de l'ENSSAT entouré par un groupe de nouveaux élèves tels que vous. " +
            "Vous êtes stressé, c'est votre premier jour mais vous êtes forts, vous avez survécu à la prépa, qu'est ce " +
            "qui pourrait vous arrivez de pire, n'est-ce pas? Quelle naïveté... \n" +
            "   Par contre vous êtes perdu, vous devez rejoindre une salle libellée 137C mais vous n'avez aucune idée du " +
            "chemin à suivre. \n    ");
    public static Text_scenario room_101_2 = new Text_scenario(1012, "Vous regardez autour de vous. " +
            "Vous identifiez les mêmes stéréotypes d'élèves présents dans toutes les classes." +
            "Il y a un petit de groupe de geeks sur votre droite, les gars sûrs d'eux, du moins en façade, devant vous " +
            "et un groupe de filles sur votre gauche. Vous vous faites plusieurs réflections. D'abord il n'y a pas beaucoup " +
            "de filles, pire qu'en prépa...quelle idée de choisir une école de geek aussi. Ensuite, altruiste que vous " +
            "êtes, vous espérez que chacun pourra évoluer au cours de ses années ici...Cependant, cela nous vous aide en" +
            " rien à trouver votre chemin. \n   ");
    public static Text_scenario room_101_3 = new Text_scenario(1013,"Vous demandez votre chemin à l'accueil qui" +
            " est sur votre droite. Derrière une vitre une jeune femme vous répond gentillement, même si vous pouvez " +
            "sentir son agacement face à cette question qu'elle a déjà dû beaucoup trop entendre aujourd'hui : \"Suivez " +
            "simplement les panneaux, ils sont là pour vous.\". Effectivement, il y avait un panneau que vous n'aviez" +
            " pas vu, caché par la foule. \n    ");
    public static Text_scenario room_101_4 = new Text_scenario(1014, "Vous lisez le panneau face à vous : " +
            "\"1A, Amphi 137C\" suivi d'une fléche pointant un couloir face à vous, un peu sur votre gauche." +
            "Vous vous dites que 1A ça doit être pour 1ère année...ils ne font quand même pas d'effort avec leur jargon...\n    " +
            "[Notez que cette action vous a débloqué la flèche de déplacement du haut vous permettant de passer à la " +
            "salle suivante. Les actions peuvent avoir une multitudes de conséquences comme vous donner accès à de nouveaux " +
            "lieux ou encore débloquer d'autres actions. Ainsi, pensez à parfois revenir sur vos pas, certaines choses " +
            "auraient pu se débloquer depuis votre dernier passage.] \n  ");

    //Texte amphithéâtre avant conférence
    public static Text_scenario room_102_1 = new Text_scenario(1021,"   Vous avez suivi les panneaux, pris un couloir " +
            "éclairé par des parties vitrées sur votre gauche puis vous avez tourné à droite, puis monté un escalier, " +
            "puis tourné à gauche pour enfin arriver à cette amphithéâtre...Cette école à l'air d'être un vrai labyrinthe," +
            " ça pourrait être intéressant de l'explorer plus tard. \n  " +
            "Vous vous installez dans les gradins, ni trop bas pour ne pas avoir l'air trop studieux ni trop haut pour ne " +
            "pas donner l'impression de ne pas être intéressé et donc être repéré par les intervenants. \n  " +
            "Après votre arrivée la salle se rempli rapidement. Certains ont l'air de déjà se connaître et d'autres " +
            "sociabilise déjà avec leurs voisins. Vous devriez réussir à vous faire des amis assez rapidement. \n   " +
            "Les intervenants, déjà présents dans la salle à votre arrivée demande le silence et commence leur présentation.");

    //Texte amphithéâtre après conférence
    public static Text_scenario room_103_1 = new Text_scenario(1031, "  Vous voilà arrivé à la fin de la conférence." +
            " Rien d'extravagant, des consignes de sécurités, des présentations de locaux, des présentations des " +
            "différentes formations. C'est exactement ce à quoi vous vous attendiez. \n     " +
            "Cependant, pendant la conférence vous avez sympathisé avec Maxime, votre voisin. Lui vient de l'IUT de " +
            "Lannion et connais déjà donc bien la région. C'est exactement ce qu'il vous fallait! \n    " +
            "Au moment de partir, Maxime s'exclame : \"Hey, c'est à toi la trousse là-bas?\". Vous répondez que non car" +
            " effectivement ce n'est pas la vôtre. Vous voyez Maxime se servir dedans. \"Fais donc pareil, on ramènera le" +
            " reste à l'accueil l'air de rien.\" \n     ");

    public static Text_scenario room_103_2 = new Text_scenario(1032, "Après vous être servi, Maxime récupère la " +
            "trousse. Il compte sûrement la ramener à l'accueil. Commencer l'année en volant à un autre élève que vous" +
            " ne connaissait même pas...Vous vous sentez un peu mal mais bon c'est pas grand chose et puis les fin de " +
            "mois sont compliquées en ce moment. Peu importe, vous n'avez plus rien aujourd'hui, qu'allez-vous faire? \n    ");


    //Texte trousse
    public static Text_scenario room_201_1 = new Text_scenario(2011, "  Vous regardez à l'intérieur de la trousse. " +
            "Il y a le contenu habituel : quelques stylos, un blanco, une gomme, un compas etc...Mais il y a aussi des" +
            " choses plus inhabituelles : un petit opinel et une petite loupe. Le propriétaire de cette trousse à l'air" +
            " bizarre, vous préféreriez ne pas faire sa connaissance.");


    //Texte Cafétaria
    public static Text_scenario room_104_1 = new Text_scenario(1041, "  Vous sortez de la salle, bifurquez à gauche," +
            " prenez l’escalier et descendez de un étage. Vous arrivez à sortir du bâtiment sans difficulté. " +
            "Vous vous dirigez vers la cafétéria de substitution. Dû à une fuite qui s’est transformée en important " +
            "dégât (le toit s’est écroulé, c’est pour dire !), vous rejoignez la salle de sport transformée en cafétéria.\n" +
            "   Vous avez réussi à rejoindre une partie de votre classe et sympathisez avec eux jusqu'à une heure " +
            "avancée de l'après-midi avant de rentrer chez vous.\n" +
            "   FIN DU PROLOGUE \n     Bon, j’imagine que tu as compris. tu donnes ton choix d’actions dans l’interface de " +
                    "commande, tu lis l'histoire juste au dessus et tu regardes l’image à droite. Utilises les flèches " +
                    "pour te déplacer entre les différentes salles. Et n'oublies que tes actions peuvent avoir des " +
                    "conséquences sur les lieux que tu as déjà visité. Facile non ? Bon " +
                    "alors, ouvre bien tes mireittes et tes écoutilles, parce que voir et écouter c’est le plus important!" +
                    " Fais attention au moindre détail"
            );


    //Texte Extérieur
    public static Text_scenario room_105_1 = new Text_scenario(1051, "  Vous sortez de la salle, bifurquez à gauche, " +
            "prenez l’escalier et descendez de un étage. Vous arrivez à sortir du bâtiment sans difficulté. " +
            "Vous êtes dehors et vous vous y sentez bien. Il ne fait pas trop froid, il y a du soleil. Vous rentrez chez" +
            " vous.\n" +
            "   FIN DU PROLOGUE \n     Bon, j’imagine que tu as compris. tu donnes ton choix d’actions dans l’interface de " +
            "commande, tu lis l'histoire juste au dessus et tu regardes l’image à droite. Utilises les flèches " +
            "pour te déplacer entre les différentes salles. Et n'oublies que tes actions peuvent avoir des " +
            "conséquences sur les lieux que tu as déjà visité. Facile non ? Bon " +
            "alors, ouvre bien tes mireittes et tes écoutilles, parce que voir et écouter c’est le plus important!" +
            " Fais attention au moindre détail");


    //Texte PC
    public static Text_scenario room_106_1 = new Text_scenario(1061, "Un vrai geek celui-là. Je laisse tomber, " +
            "faites votre vie mais méfiez vous quand même. Il paraîtrait qu’il ne vaut mieux pas rester seul dans l’ENSSAT!\n" +
            "   FIN DU PROLOGUE \n     Bon, j’imagine que tu as compris. tu donnes ton choix d’actions dans l’interface de " +
            "commande, tu lis l'histoire juste au dessus et tu regardes l’image à droite. Utilises les flèches " +
            "pour te déplacer entre les différentes salles. Et n'oublies que tes actions peuvent avoir des " +
            "conséquences sur les lieux que tu as déjà visité. Facile non ? Bon " +
            "alors, ouvre bien tes mireittes et tes écoutilles, parce que voir et écouter c’est le plus important!" +
            " Fais attention au moindre détail");


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
