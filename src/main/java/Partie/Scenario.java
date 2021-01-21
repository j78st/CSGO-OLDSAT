package Partie;

public class Scenario {

    /*-----------------------------------------Prologue-------------------------------------------*/

    // Hall

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
            "L'action que vous avez effectué a déverouillé une nouvelle action, celle de lire le panneau.\n\n");

    public Text_scenario room_101_3 = new Text_scenario(1013,"Vous lisez le panneau face à vous indiquant : \"Amphi 137C\" " +
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

    //Texte amphi après conférence

    public Text_scenario room_103_1 = new Text_scenario(1031,"La conférence touche à sa fin. " +
            "Rien d'extravagant, des consignes de sécurité, des présentations de locaux et " +
            "une introduction aux différentes formations proposées par l'école, exactement ce à quoi vous vous attendiez.\n" +
            "L'amphithéâtre commence à se vider, vous jetez un coup d'oeil rapide dans la salle et vous apercevez une trousse abandonnée sur une table, " +
            "c'est étrange car vous êtes convaincu que personne n'était assis à cette place pendant la conférence.\n" +
            "Pour satisfaire votre curiosité, vous vous approchez de cette trousse avant de partir.\n\n");

    public Text_scenario room_103_2 = new Text_scenario(1032,"Après avoir récupéré ");

    public Text_scenario room_103_3 = new Text_scenario(1033,"un compas ");

    public Text_scenario room_103_4 = new Text_scenario(1034,"une loupe ");

    public Text_scenario room_103_5 = new Text_scenario(1035,"un petit opinel ");

    public Text_scenario room_103_6 = new Text_scenario(1036,"vous vous rendez à la sortie de l'amphithéâtre.\n");

    //Texte trousse

    public Text_scenario room_201_1 = new Text_scenario(2011,"Vous regardez à l'intérieur de la trousse.\n" +
            "Vous y trouvez des objets habituels : quelques stylos, un surligneur, une gomme, un compas ... " +
            "Mais il y a aussi des choses plus étonnantes : une loupe et un opinel. Le propriétaire de cette trousse doit être bizarre. " +
            "Qui garde une loupe et un opinel dans sa trousse ?\n\n" +
            "[Tutoriel]\n" +
            "Vous pouvez prendre un objet dans cette trousse. Attention ce choix est définitif et aura un impact sur la suite de votre aventure.\n" +
            "Vous pouvez aussi revenir en arrière en appuyant sur la flèche de déplacement.");

    //Texte extérieur

    public Text_scenario room_104_1 = new Text_scenario(1041,"Vous sortez du bâtiment.\n" +
            "À l'extérieur, les étudiants se regroupent en petit comité pour débriefer cette conférence.\n" +
            "Votre journée de cours est finie.\n" +
            "Vous pouvez vous joindre à l'un des groupes pour discuter ou bien rentrer chez vous directement.\n\n");

    public Text_scenario room_104_2 = new Text_scenario(1042,"Vous rejoignez un groupe d'étudiant et " +
            "parler de tout et de rien pendant une dizaine de minutes.\n\n" +
            "[Tutoriel]\n" +
            "Certaines actions comme celle-ci ne dévérouillent rien et n'ont aucune incidence sur le déroulement de l'histoire.");

    /*-----------------------------------------Acte 1-------------------------------------------*/

    //Biblio pré lumière

    public Text_scenario room_107_1 = new Text_scenario(1071,"La porte s'est violemment refermée derrière vous. " +
            "Il fait très sombre, vous ne voyez presque rien. Vous avez peur.\n" +
            "Votre premier réflexe est de réouvrir la porte, elle a dû claquée à cause d'un courant d'air.\n\n");

    public Text_scenario room_107_2 = new Text_scenario(1072,"La porte est bloquée : impossible de l'ouvrir.\n" +
            "Vous paniquez, vous ne savez plus quoi faire.\n" +
            "Dans le noir, vous parvenez à distinguer un interrupteur proche de la porte.");

    //Biblio post lumière

    public Text_scenario room_108_1 = new Text_scenario(1081,"La lumière s'allume.\n" +
            "Vous êtes soulagé et reprenez vos esprits. Vous prenez le temps de regarder autour de vous.\n\n" +
            "La bibliothèque est plus grande que vous ne l'imaginiez.\n" +
            "Malgrè l'espace, vous vous sentez encore opréssé. L'atmosphère est assez lourde.\n" +
            "Vous resentez clairement que l'endroit est imprégné d'un fort passé, à cause des vieux murs décorés de vitraux " +
            "et une odeur désagréable de bouquins usés.\n\n" +
            "Cependant l'endroit est assez bien éclairé, ce qui vous permez d'inspecter la salle plus en détail.\n\n" +
            "Au centre du rez-de-chaussée, il y 3 étagères pleines à craquer d'ouvrages en tout genre.\n" +
            "À côté de ces étagères se trouve un bureau et une chaise, appartenant surement au gestionnaire de la bibliothèque.\n" +
            "Pas loin de la porte par laquelle vous êtes entrez, vous remarquez un escalier en colimaçon menant à un étage.\n\n");

    //Porte

    public Text_scenario room_211_1 = new Text_scenario(2111,"La porte est vérouillée mais elle ne semble pas très robuste, " +
            "peut-être ne résistera t-elle pas à votre épaule ?\n\n");

    public Text_scenario room_211_2 = new Text_scenario(2112,"La porte n'a pas bougé et vous vous êtes fait mal.\n" +
            "Ça ne semble pas être une bonne idée. Il va vous falloir trouver un autre moyen de sortir d'ici, mais vous ne voyez aucune autre porte ...\n\n");

    public Text_scenario room_211_3 = new Text_scenario(2113,"Vous essayez d'insérer la clef dans la serrure mais vous n'y parvenez pas.\n" +
            "Cette clef ne semble pas ouvrir cette porte.\n\n");

    //Etagere1

    public Text_scenario room_207_1 = new Text_scenario(2071,"Une étagère de bibliothèque, tout ce qu'il y a de plus classique.\n" +
            "Celle-ci contient surtout des livres sur les sciences et les mathématiques.\n\n" +
            "3 ouvrages en particulier attirent votre attention car contrairement aux autres ils ne sont pas recouverts d'un amas de poussière.\n\n" +
            "Le premier est un livre de physique.\n" +
            "Le second est un ouvrage de vulgarisation mathématique.\n" +
            "Le troisième traite de cryptologie.");

    //Livre 1-1

    public Text_scenario room_212_1 = new Text_scenario(2121,"Vous lisez la quatrième de couverture :\n\n" +
            "Voici le premier livre que Stephen Hawking ait écrit pour le grand public.\n" +
            "Il y expose, dans un langage accessible à tous, les plus récentes découvertes des astrophysiciens.\n" +
            "Retraçant les grandes théories du cosmos depuis Galilée jusqu'à Einstein, racontant les ultimes découvertes en cosmologie, " +
            "expliquant la nature des trous noirs,\n" +
            "il propose ensuite de relever le plus grand défi de la science moderne : " +
            "la recherche d'une théorie permettant de concilier la relativité générale et la mécanique quantique.\n" +
            "Stephen Hawking lutte depuis plus de vingt ans contre une maladie neurologique très grave. " +
            "Malgré ce handicap, il a consacré sa vie à tenter de percer les secrets de l'univers et à nous faire partager ses découvertes. Un livre fascinant.");

    //Livre 1-2

    public Text_scenario room_213_1 = new Text_scenario(2131,"Vous lisez la quatrième de couverture :\n\n" +
            "Dans les temps préhistoriques, les maths sont nées pour être utiles.\n" +
            "Les nombres servaient à compter les moutons d'un troupeau.\n" +
            "La géométrie permettait de mesurer les champs et de tracer des routes.\n" +
            "L'histoire aurait pu en rester là, mais au fil des siècles, les Homo sapiens furent bien étonnés de découvrir les chemins sinueux de cette science parfois abstraite.\n" +
            "Bien sûr, l'histoire des mathématiques a été écrite par des hommes et des femmes au génie époustouflant, mais ne vous y trompez pas : " +
            "les véritables héroïnes de ce «grand roman», ce sont les idées. Ces petites idées qui germent un jour au fond d'un cerveau, " +
            "se propagent de siècle en siècle, de continent en continent, s'amplifient, s'épanouissent et nous dévoilent, presque malgré nous, " +
            "un monde d'une richesse à couper le souffle.\n" +
            "Vous découvrirez que les mathématiques sont belles, poétiques, surprenantes, jubilatoires et captivantes.\n" +
            "Le nombre n est fascinant. La suite de Fibonacci et le nombre d'or nous entraînent sur des pistes inattendues. " +
            "Les équations nous mettent au défi et l'infiniment petit vient délicieusement gratter notre esprit de ses paradoxes.\n" +
            "Si vous n'avez jamais rien compris aux maths, s'il vous est même arrivé de les détester, que diriez-vous de leur donner une seconde chance? Vous risquez bien d'être surpris...");

    //Livre 1-3

    public Text_scenario room_214_1 = new Text_scenario(2141,"Vous lisez la quatrième de couverture :\n\n" +
            "Vous vous demandez peut être comment sécuriser vos messages ? Et bien sachez que vous n'êtes pas le seul. " +
            "Beaucoup de personnes au fil des siècles ont cherché à protéger leurs communications.\n" +
            "Pour se faire, beaucoup ont opté pour la cryptologie, et pas que les mathématiciens.\n" +
            "Des grands hommes militaires comme Jules César ont utilisé un décalage dans l'alphabet.\n" +
            "Des soldats nazis ont encrypté leurs messages avec la machine Enigma pendant la seconde guerre mondiale.\n" +
            "Ce livre a pour but de faire découvrir les bases de la cryptologie à un public non averti.");

    //Etagere2

    public Text_scenario room_208_1 = new Text_scenario(2081,"Une étagère de bibliothèque, tout ce qu'il y a de plus classique.\n" +
            "Celle-ci contient surtout des classiques de la littérature française.");

    public Text_scenario room_301_1 = new Text_scenario(3011,"La clef vous a permi de débloquer quelque chose, \n" +
            "mais rien ne semble s'être ouvert. Avec votre connaissance des films d'espionnage, vous connaissez ce mécanisme : " +
            "il faut surement tirer sur un livre pour ouvrir une sorte de passage secret, mais lequel ?");

    public Text_scenario room_301_2 = new Text_scenario(3012,"Vous avez réussi ! L'étagère s'ouvre et vous découvrez une salle " +
            "qui était cachée derrière.");

    //Etegere3

    public Text_scenario room_209_1 = new Text_scenario(2091,"Une étagère de bibliothèque, tout ce qu'il y a de plus classique.\n" +
            "Celle-ci contient surtout des livres sur l'histoire française et la géo-politique.\n\n");


    public Text_scenario room_220_1 = new Text_scenario(2201,"Une étagère de bibliothèque, tout ce qu'il y a de plus classique.\n" +
            "Celle-ci contient surtout des livres sur l'histoire française et la géo-politique.\n\n");

    //Bureau

    public Text_scenario room_202_1 = new Text_scenario(2021,"Le bureau semble normal.\n" +
            "Un ordinateur est posé dessus. Il y a un tiroir sur la gauche du meuble.\n" +
            "Vous voyez aussi un morceau de papier déchiré mis en évidence sous une lampe.\n\n");

    //Note

    public Text_scenario room_205_1 = new Text_scenario(2051,"Le morceau de papier est en fait une ordonnance médicale arrachée.\n" +
            "Le texte est lisible mais une partie semble écrit en tout petit, vous ne parvenez pas à la lire.");

    //Note illisible

    public Text_scenario room_205_2 = new Text_scenario(2052,"Gràce à votre loupe, vous parvenez à déchiffrer l'inscription, " +
            "elle dit : \"À vaincre sans péril on triomphe sans gloire.\"\n Qu'est-ce cela peut bien signifier ?\n\n");

    //Tiroir

    public Text_scenario room_302_1 = new Text_scenario(3021,"Un cadena protège le tiroir. " +
            "Il faut un code à 3 chiffres pour pouvoir l'ouvrir.\n" +
            "Quel code le gestionnaire a t-il bien pu utiliser ?");

    //Tiroir ouvert

    public Text_scenario room_203_1 = new Text_scenario(2031,"Le cadena est ouvert. Vous ouvrez le tiroir.\n" +
            "Vous trouvez une clef, elle vous servira bien à quelque chose.\n\n");

    //Tiroir ouvert 2

    public Text_scenario room_204_1 = new Text_scenario(2041,"Le cadena est ouvert. Vous ouvrez le tiroir.\n" +
            "Vous trouvez une clef, elle vous servira bien à quelque chose.\n\n" +
            "Vous revenez pour inspecter plus en profondeur le tiroir.");

    public Text_scenario room_204_2 = new Text_scenario(2042,"Vous remarquez un double fond.\n" +
            "En utilisant votre compas, vous parvenez à l'enlevez.\n" +
            "Il cachait un morceau de papier brulé, vous pouvez y lire l'inscription suivante :\n" +
            "\"À vaincre sans péril on triomphe sans gloire.\" Qu'est-ce cela peut bien signifier ?");

    public Text_scenario room_204_3 = new Text_scenario(2043, "Vous remarquez un double fond.\n" +
            "En utilisant votre petit opinel, vous parvenez à l'enlevez.\n" +
            "Il cachait un morceau de papier brulé, vous pouvez y lire l'inscription suivante :\n" +
            "\"À vaincre sans péril on triomphe sans gloire.\"\n" +
            "Qu'est-ce cela peut bien signifier ?");

    //PC

    public Text_scenario room_303_1 = new Text_scenario(3031,"Vous allumez l'ordinateur, peut-être y trouverez vous quelque chose d'utile.\n" +
            "Il faut un mot de passe pour pouvoir se connecter à la session du gestionnaire, vous vous y attendiez mais vous êtes quand même décu.");

    public Text_scenario room_206_1 = new Text_scenario(2061,"Le mot de passe est correct, vous avez maintenant accès à la session du gestionnaire.");

    /*public Text_scenario room_206_2 = new Text_scenario(2062,"Vous lisez le document :\n\n" +
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
            "12345 - Le Cid - Pierre Corneille\n\n");*/

    //Indices

    public Text_scenario room_400_1 = new Text_scenario(4001,"Peut-être devriez vous inspecter plus en détail le bureau du gestionnaire,\n" +
            "vous y trouverez peut-être quelque chose d'intéressant.\n\n");

    public Text_scenario room_400_2 = new Text_scenario(4002,"Vous savez que le gestionnaire utilise des éléments viseuls pour soulager sa mémoire.\n" +
            "Peut-être utilise t-il des éléments de la bibliothèques pour retenir ses codes secrets.\n\n");

    public Text_scenario room_400_3 = new Text_scenario(4003,"Cette clef doit bien servir à quelque chose.\n" +
            "Au vu de la configuration de la salle, si cette clef ouvre quelque chose, c'est forcément au rez-de-chaussée.\n\n");

    public Text_scenario room_400_4 = new Text_scenario(4004,"Vous savez qu'il faut trouver un livre pour ouvrir l'étagère.\n" +
            "Oui mais lequel ? Vous trouverez peut-être un début de réponse à l'étage.\n\n");

    public Text_scenario room_400_5 = new Text_scenario(4005,"À quoi peut bien servir ce code ?\n" +
            "Vous n'avez pas besoin d'un code mais d'un livre, il vous faudrez une correspondance.\n\n");

    //Etage

    public Text_scenario room_109_1 = new Text_scenario(1091,"Après avoir emprunté l'escalier, vous vous retrouvez à l'étage de la bibliothèque.\n" +
            "Il est assez similaire au rez-de-chausée.\n" +
            "Au centre une étagère se distingue des autres.\n" +
            "De l'étage, vous parvenez à mieux observer le plafond, il parait très bien décoré.\n" +
            "Sur le mur en face de vous, vous pouvez contempler une magnifique peinture.");

    //Plafond

    public Text_scenario room_210_1 = new Text_scenario(2101,"En levant les yeux vers le plafond, vous découvrez la qualité de ses décorations.");

    //Etagere centrale

    public Text_scenario room_304_1 = new Text_scenario(3041,"Dans cette étagère, 4 livres sortent du lot de part le fait qu'ils ait une illustration " +
            "sur leurs rainures. Mais çela vous parait étrange car ils ne semblent pas dans le bon ordre, peut-être pouvez vous remedier au problème ?\n\n");

    public Text_scenario room_304_2 = new Text_scenario(3042,"Vous avez replacer les livres dans le bon ordre.");

}
