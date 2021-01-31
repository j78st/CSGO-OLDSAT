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

    public Text_scenario room_101_2 = new Text_scenario(1012,"Vous demandez votre chemin à l'accueil qui est sur votre droite.\n" +
            "À travers la vitre une jeune femme vous répond gentillement : " + "\"Suivez simplement les panneaux, ils sont là pour vous guider\".\n" +
            "Effectivement, il y avait un panneau au milieu du hall que vous n'aviez pas vu, il était caché par la foule.\n\n" +
            "[Tutoriel]\n" +
            "L'action que vous avez effectuée en a déverrouillé une autre, celle de lire le panneau.\n\n");

    public Text_scenario room_101_3 = new Text_scenario(1013,"Vous lisez le panneau face à vous indiquant : \"Amphi 137C\" " +
            "suivi d'une flèche pointant un couloir en face de vous.\n\n" +
            "[Tutoriel]\n" +
            "Vous pouvez noter que cette action a débloqué la flèche de déplacement vers le haut vous permettant d'accéder à la salle suivante.\n" +
            "Les actions peuvent avoir une multitude de conséquences comme vous donner accès à de nouveaux lieux " +
            "ou encore débloquer d'autres actions. Ainsi, pensez à parfois revenir sur vos pas, " +
            "certaines choses auraient pu se débloquer depuis votre dernier passage.");

    //Texte amphi avant conférence

    public Text_scenario room_102_1 = new Text_scenario(1021,"Vous suivez les flèches qui vous mènent dans un couloir " +
            "duquel vous pouvez apercevoir sur votre gauche une cour intérieure à travers des baies vitrées, " +
            "puis vous tournez à droite avant d'emprunter un escalier. " +
            "Arrivé au premier étage vous prenez à gauche pour enfin découvrir l'amphithéâtre 137C.\n" +
            "Cette école a l'air d'être un vrai labyrinthe. Cela pourrait être intéressant de revenir plus tard pour l'explorer.\n\n" +
            "Vous vous installez dans les gradins, ni trop bas ni trop haut. Après votre arrivée la salle se remplit progressivement.\n" +
            "Au bout d'un moment, les intervenants demandent le silence avant de commencer leur présentation.");

    //Texte amphi après conférence

    public Text_scenario room_103_1 = new Text_scenario(1031,"La conférence touche à sa fin. " +
            "Rien d'extravagant, des consignes de sécurité, des présentations de locaux et " +
            "une introduction aux différentes formations proposées par l'école, exactement ce à quoi vous vous attendiez.\n" +
            "L'amphithéâtre commence à se vider, vous jetez un coup d'oeil rapide dans la salle et vous apercevez une trousse abandonnée sur une table, " +
            "c'est étrange car vous êtes convaincu que personne n'était assis à cette place pendant la conférence.\n" +
            "Pour satisfaire votre curiosité, vous vous approchez de cette trousse avant de partir.\n\n");

    public Text_scenario room_103_2 = new Text_scenario(1032,"Après avoir récupéré ");

    public Text_scenario room_103_3 = new Text_scenario(1033,"un compas, ");

    public Text_scenario room_103_4 = new Text_scenario(1034,"une loupe, ");

    public Text_scenario room_103_5 = new Text_scenario(1035,"un petit opinel, ");

    public Text_scenario room_103_6 = new Text_scenario(1036,"vous vous rendez à la sortie de l'amphithéâtre.\n\n" +
            "[Tutoriel]\n" +
            "Vous pouvez récupérer des objets. Ceux-ci vous permettent de débloquer des actions jusque-là inaccessibles. " +
            "Ainsi, pensez à explorer pour trouver où l'objet fraichement récupéré peut être utile. " +
            "Vous pouvez à tout moment voir quels objets vous possédez grâce à votre inventaire. " +
            "Vous ne pouvez avoir que trois objets en même temps. Certains sont à usage unique.\n\n");

    //Texte trousse

    public Text_scenario room_201_1 = new Text_scenario(2011,"Vous regardez à l'intérieur de la trousse.\n" +
            "Vous y trouvez des objets habituels : quelques stylos, un surligneur, une gomme, un compas... " +
            "Mais il y a aussi des choses plus étonnantes : une loupe et un opinel. Le propriétaire de cette trousse doit être bizarre. " +
            "Qui garde une loupe et un opinel dans sa trousse ?\n\n" +
            "[Tutoriel]\n" +
            "Vous pouvez prendre un objet dans cette trousse. Attention ce choix est définitif et aura un impact sur la suite de votre aventure.\n" +
            "Vous pouvez aussi revenir en arrière en appuyant sur la flèche de déplacement.");

    //Texte extérieur

    public Text_scenario room_104_1 = new Text_scenario(1041,"Vous sortez du bâtiment.\n" +
            "À l'extérieur, les étudiants se regroupent en petits comités pour débriefer cette conférence.\n" +
            "Votre journée de cours est terminée.\n" +
            "Vous pouvez vous joindre à l'un des groupes pour discuter ou bien rentrer chez vous directement.\n\n");

    public Text_scenario room_104_2 = new Text_scenario(1042,"Vous rejoignez un groupe d'étudiants et " +
            "parlez de tout et de rien pendant une dizaine de minutes.\n\n" +
            "[Tutoriel]\n" +
            "Certaines actions comme celle-ci ne déverrouillent rien et n'ont aucune incidence sur le déroulement de l'histoire.");

    /*-----------------------------------------Acte 1-------------------------------------------*/

    //Biblio pré lumière

    public Text_scenario room_107_1 = new Text_scenario(1071,"La porte s'est violemment refermée derrière vous. " +
            "Il fait très sombre, vous ne voyez presque rien. Vous avez peur.\n" +
            "Votre premier réflexe est de rouvrir la porte, elle a dû claquer à cause d'un courant d'air.\n\n");

    public Text_scenario room_107_2 = new Text_scenario(1072,"La porte est bloquée : impossible de l'ouvrir.\n" +
            "Vous paniquez, vous ne savez plus quoi faire.\n" +
            "Dans le noir, vous parvenez à distinguer un interrupteur proche de la porte.");

    //Biblio post lumière

    public Text_scenario room_108_1 = new Text_scenario(1081,"La lumière s'allume.\n" +
            "Vous êtes soulagé et reprenez vos esprits. Vous prenez le temps de regarder autour de vous.\n\n" +
            "La bibliothèque est plus grande que vous ne l'imaginiez.\n" +
            "Malgré tout cet espace, vous vous sentez encore oppressé. L'atmosphère est lourde.\n" +
            "Vous ressentez clairement que l'endroit est imprégné d'un fort passé, à cause des vieux murs décorés de vitraux " +
            "et une odeur désagréable de bouquins usés.\n\n" +
            "Cependant l'endroit est assez bien éclairé, ce qui vous permet d'inspecter la salle plus en détail.\n\n" +
            "Au centre du rez-de-chaussée, face à vous, il y a 3 étagères pleines à craquer d'ouvrages en tout genre. " +
            "Elles sont surplombées de gargouilles représentant des têtes de différents animaux.\n" +
            "À côté de ces étagères se trouve un bureau et une chaise, appartenant sûrement au gestionnaire de la bibliothèque.\n" +
            "Non loin de la porte par laquelle vous êtes entré, vous remarquez un escalier en colimaçon menant à un étage.\n\n");

    //Porte

    public Text_scenario room_211_1 = new Text_scenario(2111,"La porte est verrouillée mais peut-être ne résistera-t-elle pas à votre épaule ?\n\n");

    public Text_scenario room_211_2 = new Text_scenario(2112,"La porte n'a pas bougé et vous vous êtes fait mal.\n" +
            "Ça ne semble pas être une bonne idée. Il va vous falloir trouver un autre moyen de sortir d'ici, mais vous ne voyez aucune autre porte...\n\n");

    public Text_scenario room_211_3 = new Text_scenario(2113,"Vous essayez d'insérer la clef dans la serrure mais vous n'y parvenez pas.\n" +
            "Cette clef ne semble pas ouvrir cette porte.\n\n");

    //Etagere1

    public Text_scenario room_207_1 = new Text_scenario(2071,"Une étagère de bibliothèque, tout ce qu'il y a de plus classique.\n" +
            "Celle-ci contient surtout des livres sur les sciences et les mathématiques.\n\n" +
            "3 ouvrages en particulier attirent votre attention car, contrairement aux autres, ils ne sont pas recouverts d'un amas de poussière.\n\n" +
            "Le premier est un livre de physique.\n" +
            "Le second est un ouvrage de vulgarisation mathématique.\n" +
            "Le troisième traite de cryptologie.");

    //Livre 1-1

    public Text_scenario room_212_1 = new Text_scenario(2121,"Vous lisez la quatrième de couverture :\n\n" +
            "\"Voici le premier livre que Stephen Hawking a écrit pour le grand public.\n" +
            "Il y expose, dans un langage accessible à tous, les plus récentes découvertes des astrophysiciens.\n" +
            "Retraçant les grandes théories du cosmos depuis Galilée jusqu'à Einstein, racontant les ultimes découvertes en cosmologie, " +
            "expliquant la nature des trous noirs, il propose de relever le plus grand défi de la science moderne : " +
            "la recherche d'une théorie permettant de concilier la relativité générale et la mécanique quantique.\n" +
            "Stephen Hawking lutte depuis plus de vingt ans contre une maladie neurologique très grave. " +
            "Malgré ce handicap, il a consacré sa vie à tenter de percer les secrets de l'univers et à nous faire partager ses découvertes. Un livre fascinant.\"");

    //Livre 1-2

    public Text_scenario room_213_1 = new Text_scenario(2131,"Vous lisez la quatrième de couverture :\n\n" +
            "\"Dans les temps préhistoriques, les mathématiques sont nées pour être utiles.\n" +
            "Les nombres servaient à compter les moutons d'un troupeau.\n" +
            "La géométrie permettait de mesurer les champs et de tracer des routes.\n" +
            "L'histoire aurait pu en rester là, mais au fil des siècles, les Homo sapiens furent bien étonnés de découvrir les chemins sinueux de cette science parfois abstraite.\n" +
            "Bien sûr, l'histoire des mathématiques a été écrite par des hommes et des femmes au génie époustouflant, mais ne vous y trompez pas : " +
            "les véritables héroïnes de ce «grand roman», ce sont les idées. Ces petites idées qui germent un jour au fond d'un cerveau, " +
            "se propagent de siècle en siècle, de continent en continent, s'amplifient, s'épanouissent et nous dévoilent, presque malgré nous, " +
            "un monde d'une richesse à couper le souffle.\n" +
            "Vous découvrirez que les mathématiques sont belles, poétiques, surprenantes, jubilatoires et captivantes.\n" +
            "La suite de Fibonacci et le nombre d'or nous entraînent sur des pistes inattendues. " +
            "Les équations nous mettent au défi et l'infiniment petit vient délicieusement gratter notre esprit de ses paradoxes.\n" +
            "Si vous n'avez jamais rien compris aux maths, s'il vous est même arrivé de les détester, que diriez-vous de leur donner une seconde chance ? Vous risquez bien d'être surpris...\"");

    //Livre 1-3

    public Text_scenario room_214_1 = new Text_scenario(2141,"Vous lisez la quatrième de couverture :\n\n" +
            "\"Vous vous demandez peut être comment sécuriser vos messages ? Et bien sachez que vous n'êtes pas le seul. " +
            "Beaucoup de personnes au fil des siècles ont cherché à protéger leurs communications.\n" +
            "Pour se faire, beaucoup ont opté pour la cryptologie, et pas que les mathématiciens.\n" +
            "Des grands hommes comme Jules César ont utilisé un décalage dans l'alphabet.\n" +
            "Les nazis ont encrypté leurs messages avec la machine Enigma pendant la seconde guerre mondiale.\n" +
            "Ce livre a pour but de faire découvrir de manière ludique les bases de la cryptologie à un public non averti.\"");

    //Etagere2

    public Text_scenario room_208_1 = new Text_scenario(2081,"Une étagère de bibliothèque, tout ce qu'il y a de plus normal.\n" +
            "Celle-ci contient surtout des classiques de la littérature française.\n\n" +
            "3 ouvrages en particulier attirent votre attention car, contrairement aux autres, ils ne sont pas recouverts d'un amas de poussière.\n\n" +
            "Le premier est le roman \"La Chartreuse de Parme\" de Stendhal.\n" +
            "Le second est la pièce de théâtre \"L'Avare\" de Molière.\n" +
            "Le troisième le recueil de poèmes \"Alcools\" de Guillaume Apollinaire.\n\n");


    public Text_scenario room_301_1 = new Text_scenario(3011,"La clef vous a permis de débloquer quelque chose, " +
            "mais rien ne semble s'être ouvert.\n" +
            "Grâce à votre intérêt pour les films d'espionnage, vous connaissez ce mécanisme :\n" +
            "il faut sûrement tirer sur un livre pour ouvrir une sorte de passage secret.\n\n" +
            "[Indication]\n" +
            "Ecrivez dans la boîte de dialogue le titre du livre que vous souhaitez tirer.");

    public Text_scenario room_301_2 = new Text_scenario(3012,"Vous avez réussi !\n" +
            "L'étagère s'ouvre et vous découvrez une salle qui était cachée derrière.\n\n");

    //Livre 2-1

    public Text_scenario room_215_1 = new Text_scenario(2151,"Vous lisez la quatrième de couverture :\n\n" +
            "\"De Waterloo à la cour de Parme, le jeune Fabrice del Dongo, rêvant de gloire, amoureux de l'amour, " +
            "se laisse entraîner dans d'aventureuses passions, qui le mèneront à la captivité au sommet de la tour Farnèse.\n" +
            "C'est là, auprès de Clélia, la fille du gouverneur de la forteresse, qu'il ira chercher le bonheur, loin du pouvoir et de la cour...\n\n" +
            "Ainsi que l'écrit le romancier Vincent Delecroix : «Je crois que tant qu'on lit La Chartreuse de Parme, on ne renonce pas tout à fait à sa propre jeunesse, " +
            "à son exaltation, à son innocence, à ce que l'on exigeait de soi.\n" +
            "Je ne voulais pas être Fabrice, mais aimer la vie qu'il aimait.\n" +
            "J'y ai vu le plus souverain antidote à la mesquinerie de la vie bourgeoise et la plus joyeuse introduction à l'amour de l'art et de la beauté.»\"");

    //Livre 2-2

    public Text_scenario room_216_1 = new Text_scenario(2161,"Vous lisez la quatrième de couverture :\n\n" +
            "\"Dans cette grande comédie, Molière a affirmé son indépendance et son étrangeté.\n" +
            "Ambiguïté, ironie, conventions bravées, plaisir de la fiction, féerie, et derrière tout cela, une réalité sordide.\n" +
            "Harpagon est prisonnier d'une obsession qui nourrit les chimères d'un esprit déréglé.\n" +
            "C'est aussi une figure moderne, malgré ce qu'il emprunte à la tradition comique.\n" +
            "Cette édition fera date.\n" +
            "Elle propose une nouvelle interprétation de la pièce, par-delà une longue tradition critique : L'Avare n'a pas livré tous ses secrets, " +
            "sa part d'innovation, de risque et d'aventure, sa dramaturgie audacieuse, sa satire grinçante, voici tous les moyens de la science au service d'une pièce nouvelle.\"");

    //Livre 2-3

    public Text_scenario room_217_1 = new Text_scenario(2171,"Vous lisez la quatrième de couverture :\n\n" +
            "\"En 1913, Apollinaire publie Alcools, son premier recueil, qui rassemble quinze ans de poésie.\n" +
            "S'il est alors influencé par un symbolisme sur le déclin, il s'en démarque par d'audacieuses innovations : la ponctuation disparaît et des inventions récentes, " +
            "comme l'avion ou l'automobile, font leur entrée en poésie.\n" +
            "Mais Alcools est aussi une oeuvre contrastée, où la tour Eiffel et le pont Mirabeau côtoient des champs de colchiques et des forêts légendaires, " +
            "où l'agitation du progrès se mêle aux motifs consacrés de l'amour perdu et du temps qui passe.\n" +
            "Tantôt clairs comme le son des cloches rhénanes, tantôt sombres comme les geôles de la prison de la Santé, ces poèmes ouvrent la voie à un nouveau lyrisme.\n" +
            "Partagés entre tradition et modernité, ils reflètent la créativité bouillonnante d'une époque sur le point de basculer dans le chaos de la Grande Guerre.\"");

    //Etegere3

    public Text_scenario room_209_1 = new Text_scenario(2091,"Une étagère de bibliothèque, tout ce qu'il y a de plus classique.\n" +
            "Celle-ci contient surtout des livres sur l'Histoire de France et la philosophie.\n\n" +
            "Le premier est un livre vulgarisant l'Histoire de France.\n" +
            "Le second retrace l'histoire de la langue française.\n" +
            "Le troisième est un classique de la philosophie française.");

    //Livre 3-1

    public Text_scenario room_218_1 = new Text_scenario(2181,"Vous lisez la quatrième de couverture :\n\n" +
            "\"Un champ de ruines ! Voilà ce que risquent de devenir vos connaissances en Histoire de France si vous n’y prenez pas garde !\n" +
            "Mais, rassurez-vous, nous allons tout reconstruire : depuis les fondations, il y a deux millions d’années, lorsque le premier homme met le pied sur le futur territoire français, jusqu’à nos jours.\n" +
            "Au cours de votre voyage, vous allez croiser Cro-Magnon, Clovis, Louis XIV, Napoléon, de Gaulle, tomber sous le charme d’Aliénor d’Aquitaine…\n" +
            "De plus, cette troisième édition inclut les derniers événements historiques incontournables, comme l’élection d’Emmanuel Macron.\n" +
            "Découvrez comment la Gaule est devenue la France, la Révolution a mis fin aux privilèges, la nuit du 4 août a fait naître un rêve, Napoléon Ier a conquis l’Europe, les deux guerres mondiales ont profondément marqué le XXe siècle, " +
            "la Ve République a vu se succéder des hommes de pouvoir de De Gaulle à Macron en passant par Mitterrand.\"");

    //Livre 3-2

    public Text_scenario room_219_1 = new Text_scenario(2191,"Vous lisez la quatrième de couverture :\n\n" +
            "\"Première surprise : l'ancêtre du français, ce n'est pas le gaulois mais le \"roman\", la langue romaine issue du latin de Jules César, le vainqueur de la Gaule !\n" +
            "En effet, au fil des invasions et de nos propres conquêtes, ce latin s'est transformé et enrichi de multiples apports : germaniques avec les Francs, nordiques avec les Vikings, arabes au moment des croisades, italiens à la Renaissance... avant de devenir un français triomphant dans toutes les cours d'Europe au XVIIIe siècle, grâce à nos philosophes.\n" +
            "Entre-temps les troubadours ont inventé l'amour et les femmes écrivains réclamé leur émancipation, les grammairiens se sont occupés de la syntaxe et la réforme de l'orthographe a déjà rendu quelques linguistes fous !\n" +
            "Enfin, l'école obligatoire acheva de permettre à tous les citoyens français de communiquer.\n" +
            "Aujourd'hui, l'abus des termes anglais, les mots issus de la culture urbaine et les raccourcis de nos Smartphones inquiètent les puristes...\n" +
            "Ils ont tort : le temps fera le tri. Et de ce bouillonnement créatif continuera d'émerger une langue vivante, ouverte à tous : la langue française est une langue d'accueil.\"");

    //Livre 3-3

    public Text_scenario room_220_1 = new Text_scenario(2201,"Vous lisez la quatrième de couverture :\n\n" +
            "\"Manifeste de la philosophie cartésienne, le Discours de la méthode (1637) est tout à la fois le récit d'un cheminement intellectuel et l'illustration magistrale d'un projet : fonder l'unité des sciences et constituer une science universelle.\n" +
            "Foyer d'une oeuvre foisonnante, le Discours revendique les droits de la raison contre toute tradition et toute autorité.\n" +
            "C'est pourquoi il assigne à la philosophie une tâche : s'élever à la certitude.\n" +
            "La présente édition, augmentée d'un dossier, entend mettre en évidence le jeu de résonances qui relie le Discours aux autres textes de Descartes.\"");

    //Bureau

    public Text_scenario room_202_1 = new Text_scenario(2021,"Le bureau semble normal.\n" +
            "Un ordinateur est posé dessus. Il y a un tiroir sur la droite du meuble.\n" +
            "Vous voyez aussi un morceau de papier froissé mis en évidence sous une lampe.\n\n");

    //Note

    public Text_scenario room_205_1 = new Text_scenario(2051,"Le morceau de papier est en fait une ordonnance médicale.\n" +
            "Le texte est lisible mais une partie semble écrite en tout petit, vous ne parvenez pas à la lire.\n\n");

    //Note illisible

    public Text_scenario room_205_2 = new Text_scenario(2052,"Grâce à votre loupe, vous parvenez à déchiffrer l'inscription, " +
            "qui dit : \"À vaincre sans péril on triomphe sans gloire\".\n" +
            "Qu'est-ce cela peut bien signifier ?\n\n");

    //Tiroir

    public Text_scenario room_302_1 = new Text_scenario(3021,"Un cadenas protège le tiroir. " +
            "Un code à 3 chiffres est nécessaire pour pouvoir l'ouvrir.\n" +
            "Quel code le gestionnaire a-t-il bien pu utiliser ?");

    //Tiroir ouvert

    public Text_scenario room_203_1 = new Text_scenario(2031,"Le cadenas est ouvert. Vous ouvrez le tiroir.\n" +
            "Vous trouvez une clef, elle doit bien servir à quelque chose.\n\n");

    //Tiroir ouvert 2

    public Text_scenario room_204_1 = new Text_scenario(2041,"Le cadenas est ouvert. Vous ouvrez le tiroir.\n" +
            "Vous trouvez une clef, elle vous servira bien à quelque chose.\n\n" +
            "Vous revenez pour inspecter plus en profondeur le tiroir.\n\n");

    public Text_scenario room_204_2 = new Text_scenario(2042,"Vous remarquez un double fond.\n" +
            "En utilisant votre compas, vous parvenez à l'enlever.\n" +
            "Il cachait un morceau de papier abîmé, vous pouvez y lire l'inscription suivante :\n" +
            "\"À vaincre sans péril on triomphe sans gloire\".\n" +
            "Qu'est-ce cela peut bien signifier ?");

    public Text_scenario room_204_3 = new Text_scenario(2043, "Vous remarquez un double fond.\n" +
            "En utilisant votre petit opinel, vous parvenez à l'enlever.\n" +
            "Il cachait un morceau de papier abîmé, vous pouvez y lire l'inscription suivante :\n" +
            "\"À vaincre sans péril on triomphe sans gloire\".\n" +
            "Qu'est-ce cela peut bien signifier ?");

    //PC

    public Text_scenario room_303_1 = new Text_scenario(3031,"Vous allumez l'ordinateur, peut-être y trouverez vous quelque chose d'utile.\n" +
            "Il faut un mot de passe pour pouvoir se connecter à la session du gestionnaire, vous vous y attendiez mais vous êtes quand même déçu.");

    public Text_scenario room_206_1 = new Text_scenario(2061,"Le mot de passe est correct, vous avez maintenant accès à la session du gestionnaire.\n\n" +
            "[Tutoriel]\n" +
            "Cette image est cliquable. Naviguez dans l'ordinateur du gestionnaire en cliquant sur l'écran de celui-ci.");

    //Indices

    public Text_scenario room_400_1 = new Text_scenario(4001,"Peut-être devriez-vous inspecter plus en détail le bureau du gestionnaire,\n" +
            "vous y trouverez peut-être quelque chose d'intéressant.\n\n");

    public Text_scenario room_400_2 = new Text_scenario(4002,"Vous savez que le gestionnaire utilise des éléments visuels pour soulager sa mémoire.\n" +
            "Peut-être utilise t-il des éléments de la bibliothèque pour retenir ses codes secrets.\n\n");

    public Text_scenario room_400_3 = new Text_scenario(4003,"Cette clef doit bien servir à quelque chose.\n" +
            "Au vu de la configuration de la salle, si cette clef ouvre quelque chose, c'est forcément au rez-de-chaussée.\n\n");

    public Text_scenario room_400_4 = new Text_scenario(4004,"Vous savez qu'il faut trouver un livre pour ouvrir l'étagère.\n" +
            "Oui, mais lequel ? Vous trouverez peut-être un début de réponse à l'étage.\n\n");

    public Text_scenario room_400_5 = new Text_scenario(4005,"À quoi peut bien servir ce code ?\n" +
            "Vous n'avez pas besoin d'un code mais d'un livre, il faudrait une correspondance.\n\n");

    public Text_scenario room_400_6 = new Text_scenario(4006,"Vous avez ouvert un passage.\n" +
            "Vous devriez aller voir ce qu'il y a dedans. \n\n");

    public Text_scenario room_400_7 = new Text_scenario(4007,"Vous avez récupéré un carnet dans cette salle secrète.\n" +
            "Il y a peut être un indice dedans pour vous sortir d'ici. \n\n");

    //Etage

    public Text_scenario room_109_1 = new Text_scenario(1091,"Après avoir emprunté l'escalier, vous vous retrouvez à l'étage de la bibliothèque.\n" +
            "Il est assez similaire au rez-de-chaussée.\n" +
            "Au centre une étagère se distingue des autres.\n" +
            "De l'étage, vous parvenez à mieux observer le plafond, il paraît très bien décoré.\n" +
            "Sur le mur en face de vous, vous pouvez contempler une magnifique peinture.\n\n");

    //Plafond

    public Text_scenario room_210_1 = new Text_scenario(2101,"En levant les yeux vers le plafond, vous découvrez la qualité de ses décorations.");

    //Etagere centrale

    public Text_scenario room_304_1 = new Text_scenario(3041,"Dans cette étagère, 4 livres sortent du lot de part les illustrations " +
            "sur leurs rainures.\n" +
            "Mais cela vous paraît étrange car ils ne semblent pas dans le bon ordre, peut-être pouvez-vous remédier au problème ?\n\n" +
            "[Tutoriel]\n" +
            "Cette image est cliquable.\n\n");

    public Text_scenario room_304_2 = new Text_scenario(3042,"Vous avez replacé les livres dans le bon ordre.");

    //Salle secrète

    public Text_scenario room_110_1 = new Text_scenario(1101,"Vous entrez dans la petite salle derrière l'étagère.\n" +
            "Il n'y a pas d'éclairage, seule la lumière venant de la bibliothèque derrière vous vous éclaire.\n" +
            "L'atmosphère est encore plus pesante ici.\n\n" +
            "Face à vous se trouve un mur avec une rose des vents en son centre.\n" +
            "Vous voyez un vieux carnet au sol.\n\n");

    public Text_scenario room_110_2 = new Text_scenario(1102,"Vous avez ramassé le vieux carnet.\n\n" +
            "[Tutoriel]\n" +
            "Ce carnet est un objet cliquable.\n" +
            "Cliquez dessus dans votre inventaire afin de le regarder de plus près.\n\n");

    public Text_scenario room_110_3 = new Text_scenario(1103, "Vous avez réussi !\n" +
            "Les briques se sont mises à bouger devant vos yeux jusqu'à laisser un trou dans le mur.\n" +
            "Une lumière aveuglante émane de l'ouverture de sorte que vous nous pouvez pas voir ce qu'il y a de l'autre côté.");

    //Énigme salle secrète

    public Text_scenario room_305_1 = new Text_scenario(3051, "Vous vous approchez du mur. Comme vous l'aviez " +
            "remarqué en entrant dans la salle, il y a une rose des vents au centre de celui-ci. Il y a aussi certaines " +
            "briques qui ressortent par rapport aux autres\n\n" +
            "[Tutoriel]\n" +
            "Cette image est cliquable.\n" +
            "Si votre clic a été pris en compte, vous entendrez un effet sonore.\n" +
            "À la fin de votre séquence de clic, il y aura un autre effet qui dépendra de votre réussite ou non.\n" +
            "Si vous faites une erreur dans votre séquence de clics, continuez jusqu'au son d'erreur afin de pouvoir " +
            "recommencer.");

    /*-----------------------------------------Exploration-------------------------------------------*/

    //ENSSAT

    public Text_scenario room_111_1 = new Text_scenario(1111, "Vous voici donc des années en arrière! \n" +
            "Vous vous retrouvez devant une vieille chapelle, qui est l'ancien bâtiment de l'ENSSAT.\n" +
            "Entre-temps, elle a aussi servi d'hôpital lors de la Seconde Guerre mondiale.\n" +
            "Que de péripéties pour cette vieille école !\n\n" +
            "Dans la suite de l'exploration, vous pourrez découvrir les lieux emblématiques de Lannion du début du 20ème siècle.");

    //Bord de l'eau

    public Text_scenario room_112_1 = new Text_scenario(1121, "Ici vous reconnaissez sans trop de difficultés les quais de Lannion.\n" +
            "Ils n'ont pas tant changé que cela, cependant le cours d'eau est bien plus imposant qu'aujourd'hui, " +
            "l'évolution de la ville a mené à ce rétrécissement.");

    //Rue de l'ENSSAT

    public Text_scenario room_113_1 = new Text_scenario(1131, "La rue vous semble si familière et pourtant si différente.\n" +
            "La chaussée est en terre et les maisons sont en pierre. Les passants portent des vieux habits traditionnels.");

    //Gare

    public Text_scenario room_114_1 = new Text_scenario(1141, "Vous êtes ici à la gare de Lannion.\n" +
            "Les calèches et les chevaux ont remplacé les trains et les taxis.\n" +
            "Les gares sont toujours reconnaissables de part leur architecture, et celle-ci ne déroge pas à la règle.");

    //Quai de l'aiguillon

    public Text_scenario room_115_1 = new Text_scenario(1151, "Vous voilà sur le quai de l'Aiguillon, " +
            "vous y retrouvez le bâtiment servant actuellement de bureau de poste.\n" +
            "À l'époque, les quais étaient bien moins aménagés, le Léguer prenait beaucoup plus de place dans la ville.");

    //Marché

    public Text_scenario room_116_1 = new Text_scenario(1161, "Vous avez de la chance, c'est un jour agité dans le vieux Lannion aujourd'hui !\n" +
            "Vous arrivez dans l'un des lieux les plus emblématiques de Lannion : le marché sur les quais de l'Aiguillon.\n" +
            "La rue n'a pas changé, et les stands de vente non plus.");

    //Rue des capucins

    public Text_scenario room_117_1 = new Text_scenario(1171, "Si quelque chose n'a pas changé à Lannion, ce sont bien ses rues vallonnées.\n" +
            "Ces rues qui donnent un charme si particulier à ce décor déjà très singulier.");

    //Place de l'hôtel de ville

    public Text_scenario room_118_1 = new Text_scenario(1181, "Que serait une ville sans son hôtel de ville et sa place principale ?\n" +
            "C'est dans ce genre d'endroit, que l'on pourrait assimiler au coeur historique de Lannion, que l'on constate l'héritage culturel de cette ville.");

}
