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

    public Text_scenario room_108_1 = new Text_scenario(1081,"La bibliothèque est plus grande que vous ne l'imaginiez.\n" +
            "Malgrè l'espace, vous vous sentez opréssé. L'atmosphère est assez lourde.\n" +
            "Vous resentez clairement que l'endroit est imprégné d'un fort passé, à cause des vieux murs décorés de vitraux " +
            "et une odeur désagréble de bouquins usés.\n\n" +
            "Cependant l'endroit est assez bien éclairé, ce qui vous permez d'inspecter la salle.\n\n" +
            "Au centre du rez-de-chaussée, il y 3 étagères pleines à craquer d'ouvrages en tout genre. " +
            "À côté de ces étagères se trouve un bureau et une chaise, appartenant surement au gestionnaire de la bibliothèque. " +
            "Pas loin de la porte par laquelle vous êtes entrez, vous remarquez un escalier en colimaçon menant à un étage.\n\n");

    public Text_scenario room_211_1 = new Text_scenario(2111,"La porte est fermée mais elle ne semble pas très robuste, " +
            "peut-être ne résistera t-elle pas à votre épaule ?\n\n");

    public Text_scenario room_211_2 = new Text_scenario(2112,"La porte n'a pas bougé et vous vous êtes fait mal, " +
            "ça ne semble pas être une bonne idée.\n\n");

    public Text_scenario room_202_1 = new Text_scenario(2021,"Le bureau semble normal.\n" +
            "Un ordinateur est posé dessus. Il y a un tiroir sur la gauche du meuble.\n" +
            "Vous voyez aussi un morceau de papier déchiré mis en évidence sous une lampe.\n\n");

    public Text_scenario room_303_1 = new Text_scenario(3031,"Vous allumez l'ordinateur, peut-être y trouverez vous quelque chose d'utile.\n" +
            "Il faut un mot de passe pour pouvoir se connecter à la session du gestionnaire, vous vous y attendiez mais vous êtes quand même décu.\n" +
            "Il y a un post-it accroché sur l'écran. Vous pouvez y lire \"RTYIJVFXXJ César +5\". Qu-est ce que cela peut bien signifier?\n\n");

    public Text_scenario room_206_1 = new Text_scenario(2061,"Le mot de passe est correct, vous avez maintenant accès à la session du gestionnaire." +
            "Un dossier en particulier attire votre attention, il est intitulé \"Informations Bibliothèque\"." +
            "Vous l'ouvrez et vous trouvez à l'intérieur 3 documents :\n" +
            "- le premier s'appelle \"Historique des emprunts\".\n" +
            "- le second s'appelle \"Commandes pour la bibliothèque\".\n" +
            "- le troisième s'appelle \"Catalogue de la bibliothèque\".\n\n");

    public Text_scenario room_206_2 = new Text_scenario(2062,"Vous lisez le document :\n\n" +
            "Historique des emprunts\n\n" +
            "Les Fleurs du mal - Charles Baudelaire - emprunté jusqu'au 05/03/21\n" +
            "L'Étranger - Albert Camus - emprunté jusqu'au 05/03/21\n" +
            "Les Misérables - Victor Hugo - emprunté jusqu'au 05/03/21\n" +
            "Les Liaisons dangereuses - Choderlos de Laclos - emprunté jusqu'au 05/03/21\n" +
            "Le Petit Prince - Antoine de Saint-Exupéry - emprunté jusqu'au 05/03/21\n\n");

    public Text_scenario room_206_3 = new Text_scenario(2063,"Vous lisez le document :\n\n" +
            "Commandes pour la bibliothèque\n\n" +
            "Madame Bovary - Gustave Flaubert - livraison prévue pour le 05/03/21\n" +
            "Cyrano de Bergerac - Edmond Rostand - livraison prévue pour le 05/03/21\n" +
            "Voyage au bout de la nuit - Louis-Ferdinand Céline - livraison prévue pour le 05/03/21\n" +
            "Candide ou l'optimisme - Voltaire - livraison prévue pour le 05/03/21\n" +
            "Bel-Ami - Guy de Maupassant - livraison prévue pour le 05/03/21\n\n");

    public Text_scenario room_206_4 = new Text_scenario(2064,"Vous lisez le document :\n\n" +
            "Catalogue de la bibliothèque\n\n" +
            "12345 - Le Rouge et le Noir - Stendhal" +
            "12345 - Les Trois Mousquetaires - Alexandre Dumas" +
            "12345 - Antigone - Jean Anouilh" +
            "12345 - Le Comte de Monte-Cristo - Alexandre Dumas" +
            "12345 - Le Cid - Pierre Corneille\n\n");

    public Text_scenario room_302_1 = new Text_scenario(3021,"Un cadena protège le tiroir. " +
            "Il faut un code à 3 chiffres pour pouvoir l'ouvrir. Quel code les gestionnaire a t-il pu utiliser ?");

    public Text_scenario room_203_1 = new Text_scenario(2031,"Le cadena est ouvert. Vous ouvrez le tiroir.\n" +
            "Vous trouvez une clef, elle vous servira bien à quelque chose.\n\n");

    public Text_scenario room_204_1 = new Text_scenario(2041,"Le cadena est ouvert. Vous ouvrez le tiroir.\n" +
            "Vous trouvez une clef, elle vous servira bien à quelque chose.\n\n" +
            "Vous revenez enfin d'inspectez plus en profondeur le tiroir. \n\n");

    public Text_scenario room_204_2 = new Text_scenario(2042,"Cela a payé, il y avait un double fond! " +
            "En utilisant votre compas, vous parvenez à l'enlevez.\n" +
            "Il cachait un morceau de papier brulé, vous pouvez y lire l'insciption suivante :\n" +
            "\"À vaincre sans péril on triomphe sans gloire.\" Qu'est-ce cela peut bien signifier ?\n\n");

    public Text_scenario room_204_3 = new Text_scenario(2043,"Cela a payé, il y avait un double fond! " +
            "En utilisant votre petit opinel, vous parvenez à l'enlevez.\n" +
            "Il cachait un morceau de papier brulé, vous pouvez y lire l'insciption suivante :\n" +
            "\"À vaincre sans péril on triomphe sans gloire.\" Qu'est-ce cela peut bien signifier ?\n\n");

    public Text_scenario room_205_1 = new Text_scenario(2051,"Le morceau de papier est en fait une ordonnance médicale arrachée.\n" +
            "Vous lisez l'ordonnance :\n\n" +
            "Professionnel de la santé : HARSCOET Geraldine\n" +
            "Patient : Mme POINSU\n" +
            "Profession : Libraire\n" +
            "Pathologie : Violentes pertes de mémoires\n" +
            "Résumé de la consultation :\n" +
            "Au vu de votre profession, je vous conseille d'utiliser au maximum des éléments visuels pour retenir les éléments importants. " +
            "Cela soulagera votre mémoire.\n" +
            "Médicaments prescrits : Galantamine (500 mg)\n\n");

    public Text_scenario room_205_2 = new Text_scenario(2052,"Gràce à votre loupe, vous parvenez à déchifrer l'inscription, " +
            "elle dit : \"À vaincre sans péril on triomphe sans gloire.\" Qu'est-ce cela peut bien signifier ?\n\n");

    public Text_scenario room_207_1 = new Text_scenario(2071,"Une étagère de bibliothèque, tout ce qu'il y a de plus classique.\n" +
            "Celle-ci contient surtout des livres sur les mathématiques et les sciences.\n\n");

    public Text_scenario room_208_1 = new Text_scenario(2081,"Une étagère de bibliothèque, tout ce qu'il y a de plus classique.\n" +
            "Celle-ci contient surtout des classiques de la littérature française.\n\n");

    public Text_scenario room_209_1 = new Text_scenario(2091,"Une étagère de bibliothèque, tout ce qu'il y a de plus classique.\n" +
            "Celle-ci contient surtout des livres sur l'histoire française et la géo-politique.\n\n");
}
