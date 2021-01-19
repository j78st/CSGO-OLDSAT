package Partie;

import java.util.ArrayList;

public class Scenario_structure {

    public Scenario_structure() {
        Scenario scenar = new Scenario();

        /*-----------------------------------------Prologue-------------------------------------------*/

        //Salles
        Room room1 = new Room(101,102,-1,-1,-1,true,1011,"pictures/Hall.png", "Prologue - Hall d'entrée"); //Hall enssat
        Room room2 = new Room(102,-1,-1,-1,-1, false,1021,"pictures/Amphi.png", "Prologue - Amphithéâtre"); //Amphi
        Room room3 = new Room(103,-1,-1,-1,-1, true,1031,"pictures/Amphi2.png"); //Amphi post-conférence
        Room room3_1 = new Room(201,103,2011,"pictures/Trousse.png"); //trousse
        Room room4 = new Room(104,-1,-1,-1,-1,true,1041,"pictures/Exterieur.png");

        //Objets
        Item compas = new Item(1,"Compas","Compas pouvant être bien pratique",-1, "objects/Compas.png");
        Item loupe = new Item(2,"Loupe","Petite loupe pouvant être bien pratique",-1, "objects/Loupe.png");
        Item opinel = new Item(3,"Petit opinel","Petit couteau pouvant être bien pratique",-1, "objects/Opinel.png");
        Item couteau_suisse = new Item(42, "Couteau Suisse de l'Admin", "Couteau Suisse de l'Admin - Tout est possible avec ça", -1, "objects/Compas.png");

        //Actions salle 101 - Hall de l'enssat

        ArrayList<int[]> consequences_action101_1 = new ArrayList<>();
        consequences_action101_1.add(new int[]{7,1012}); //Affichage nouveau texte
        consequences_action101_1.add(new int[]{3,1011}); //Rend l'action innaccessible (faisable qu'une fois)
        consequences_action101_1.add(new int[]{2,1012}); //Déblocage action
        Action action101_1 = new Action(1011,true,"Demander son chemin", consequences_action101_1, 101);

        ArrayList<int[]> consequences_action101_2 = new ArrayList<>();
        consequences_action101_2.add(new int[]{7,1013}); //Affichage nouveau texte
        consequences_action101_2.add(new int[]{3,1012}); //Rend l'action innaccessible (faisable qu'une fois)
        consequences_action101_2.add(new int[]{9,102}); //Débloque salle suivante
        Action action101_2 = new Action(1012,false,"Lire le panneau", consequences_action101_2, 101);

        ArrayList<int[]> consequences_action101_69 = new ArrayList<>();
        consequences_action101_69.add(new int[]{12,107}); //Affichage nouveau texte
        Action action101_69 = new Action(10169,true,"Saut admin début d'aventure", consequences_action101_69, 101);

        //Actions de la salle 102 - Amphi pré-conférence

        ArrayList<int[]> consequences_action102_1 = new ArrayList<>();
        consequences_action102_1.add(new int[]{1,103}); //Bouge le joueur dans la salle suivante
        Action action102_1 = new Action(1021,true,"Écouter la conférence (Vous n'avez pas vraiment le choix...)", consequences_action102_1, 102);

        //Actions de la salle 103 - Amphi post-conférence

        ArrayList<int[]> consequences_action103_1 = new ArrayList<>();
        consequences_action103_1.add(new int[]{1,201}); //Bouge le joueur dans la salle suivante
        Action action103_1 = new Action(1031,true,"Fouiller dans la trousse", consequences_action103_1, 103);

        ArrayList<int[]> consequences_action103_2 = new ArrayList<>();
        consequences_action103_2.add(new int[]{1,104}); //Bouge le joueur dans la salle suivante
        Action action103_2 = new Action(1032,false,"Quitter la salle", consequences_action103_2, 103);

        //Actions de la salle 201 - Trousse

        ArrayList<int[]> consequences_action201_1 = new ArrayList<>();
        consequences_action201_1.add(new int[]{4,1}); //Ajoute l'objet à l'inventaire
        consequences_action201_1.add(new int[]{1,103}); //Bouge le joueur dans la salle précédente
        consequences_action201_1.add(new int[]{3,1031}); //Rend l'inspection de la trousse impossible
        consequences_action201_1.add(new int[]{2,1032}); //Débloque action pour la suite
        consequences_action201_1.add(new int[]{7,1032}); //Affiche du texte supplémentaire
        consequences_action201_1.add(new int[]{7,1033}); //Affiche du texte supplémentaire
        consequences_action201_1.add(new int[]{7,1036}); //Affiche du texte supplémentaire
        Action action201_1 = new Action(2011,true,"Prendre le compas", consequences_action201_1, 201);

        ArrayList<int[]> consequences_action201_2 = new ArrayList<>();
        consequences_action201_2.add(new int[]{4,2}); //Ajoute l'objet à l'inventaire
        consequences_action201_2.add(new int[]{1,103}); //Bouge le joueur dans la salle précédente
        consequences_action201_2.add(new int[]{3,1031}); //Rend l'inspection de la trousse impossible
        consequences_action201_2.add(new int[]{2,1032}); //Débloque action pour la suite
        consequences_action201_2.add(new int[]{7,1032}); //Affiche du texte supplémentaire
        consequences_action201_2.add(new int[]{7,1034}); //Affiche du texte supplémentaire
        consequences_action201_2.add(new int[]{7,1036}); //Affiche du texte supplémentaire
        Action action201_2 = new Action(2012,true,"Prendre la loupe", consequences_action201_2, 201);

        ArrayList<int[]> consequences_action201_3 = new ArrayList<>();
        consequences_action201_3.add(new int[]{4,3}); //Ajoute l'objet à l'inventaire
        consequences_action201_3.add(new int[]{1,103}); //Bouge le joueur dans la salle précédente
        consequences_action201_3.add(new int[]{3,1031}); //Rend l'inspection de la trousse impossible
        consequences_action201_3.add(new int[]{2,1032}); //Débloque action pour la suite
        consequences_action201_3.add(new int[]{7,1032}); //Affiche du texte supplémentaire
        consequences_action201_3.add(new int[]{7,1035}); //Affiche du texte supplémentaire
        consequences_action201_3.add(new int[]{7,1036}); //Affiche du texte supplémentaire
        Action action201_3 = new Action(2013,true,"Prendre le petit opinel", consequences_action201_3, 201);

        //Actions de la salle 104 - Exterieur

        ArrayList<int[]> consequences_action104_1 = new ArrayList<>();
        consequences_action104_1.add(new int[]{7,1042}); //Texte
        consequences_action104_1.add(new int[]{3,1041}); //faisable qu'une fois
        Action action104_1 = new Action(1041,true,"Parler à un groupe", consequences_action104_1, 104);

        ArrayList<int[]> consequences_action104_2 = new ArrayList<>();
        consequences_action104_2.add(new int[]{15}); //Lance la cinématique
        Action action104_2 = new Action(1042,true,"Rentrer chez vous [FIN DU PROLOGUE]", consequences_action104_2, 104);

        ArrayList<int[]> consequences_action104_3 = new ArrayList<>();
        consequences_action104_3.add(new int[]{1,107}); //Bouge le joueur dans la salle suivante
        Action action104_3 = new Action(1043,false,"Rentrer chez vous [FIN DU PROLOGUE]", consequences_action104_3, 104);




        /*-----------------------------------------Scène 1-------------------------------------------*/

        Room room7 = new Room(107,-1,-1,-1,-1,false,1071,"pictures/Bibliotheque.png", "Acte 1 - Bibliothèque");
        Room room8 = new Room(108,110,-1,-1,-1, true,1081,"pictures/Bibliotheque.png"); // RDC bibliothèque
        Room room8_1 = new Room(202,108,2021,"pictures/Trousse.png"); // Bureau
        Room room8_1_1 = new Room(203,202,2031,"pictures/Trousse.png"); // Tiroir post-énigme
        Room room8_1_2 = new Room(204,202,2041,"pictures/Trousse.png"); // Tiroir
        Room room8_1_3 = new Room(205,202,2051,"pictures/Trousse.png"); // Note sur le bureau
        Room room8_1_4 = new Room(206,202,2061,"pictures/Trousse.png"); // PC dévérouillé
        Room room8_2 = new Room(207,108,2071,"pictures/Trousse.png"); // Étagère 1
        Room room8_3 = new Room(208,108,2081,"pictures/Trousse.png"); // Étagère 2 pré-utilisation de la clef
        Room room8_4 = new Room(209,108,2091,"pictures/Trousse.png"); // Étagère 3
        Room room9 = new Room(109,-1,-1,-1,-1, true,1091,"pictures/Bibliotheque.png"); // Étage bibliothèque
        Room room9_1 = new Room(210,109,2101,"pictures/Trousse.png"); // Plafond
        Room room8_5 = new Room(211,108,2111,"pictures/Trousse.png"); // Porte
        Room room10 = new Room(110,-1,-1,-1,-1, false,1101,"pictures/Bibliotheque.png", "Acte 2 - Début"); // Début scène 2

        ArrayList<int[]> consequences_enigme1 = new ArrayList<>();
        consequences_enigme1.add(new int[]{9,110}); // Débloque salle suivante
        consequences_enigme1.add(new int[]{7,3012,108}); // Rajoute texte de fin d'énigme à la salle d'origine
        Enigma enigme1 = new Enigma(301,108,3011,"pictures/Tableau.png","Le Cid",consequences_enigme1);

        ArrayList<int[]> consequences_enigme2 = new ArrayList<>();
        consequences_enigme2.add(new int[]{2,2024}); // Débloque l'action accès tiroir depuis le bureau
        consequences_enigme2.add(new int[]{1,203}); // Déplace le joueur vers le tiroir
        Enigma enigme2 = new Enigma(302,202,3021,"pictures/Tableau.png","974",consequences_enigme2);

        ArrayList<int[]> consequences_enigme3 = new ArrayList<>();
        consequences_enigme3.add(new int[]{2,2025}); // Débloque l'action accès PC dévérouillé depuis le bureau
        consequences_enigme3.add(new int[]{1,206}); // Déplace le joueur vers le PC dévérouillé
        Enigma enigme3 = new Enigma(303,202,3031,"pictures/Tableau.png","motdepasse",consequences_enigme3);


        Item clef = new Item(4,"Clef","Ancienne clef - Elle va sûrement vous permettre de sortir d'ici",-1, "objects/key.png");


        //Actions de la salle 107 - Début de l'aventure

        ArrayList<int[]> consequences_action107_1 = new ArrayList<>();
        consequences_action107_1.add(new int[]{7,1072}); //text
        consequences_action107_1.add(new int[]{2,1072}); //debloque
        consequences_action107_1.add(new int[]{3,1071}); //faisable qu'une fois
        Action action107_1 = new Action(1071,true,"Ouvrir la porte", consequences_action107_1, 107);

        ArrayList<int[]> consequences_action107_2 = new ArrayList<>();
        consequences_action107_2.add(new int[]{1,108}); //Bouge joueur vers salle 108
        Action action107_2 = new Action(1072,false,"Inspecter la salle", consequences_action107_2, 107);


        //Actions de la salle 108 - RDC bibliothèque

        ArrayList<int[]> consequences_action108_8 = new ArrayList<>();
        consequences_action108_8.add(new int[]{1,211}); //Bouge joueur vers la porte
        Action action108_8 = new Action(1088,true,"Examiner la porte", consequences_action108_8, 108);

        ArrayList<int[]> consequences_action108_2 = new ArrayList<>();
        consequences_action108_2.add(new int[]{1,207}); //Bouge joueur vers l'étagère 1
        Action action108_2 = new Action(1082,true,"S'approcher de l'étagère de gauche", consequences_action108_2, 108);

        ArrayList<int[]> consequences_action108_3 = new ArrayList<>();
        consequences_action108_3.add(new int[]{1,208}); //Bouge joueur vers l'étagère 2
        Action action108_3 = new Action(1083,true,"S'approcher de l'étagère face à vous", consequences_action108_3, 108);

        ArrayList<int[]> consequences_action108_7 = new ArrayList<>();
        consequences_action108_7.add(new int[]{1,301}); //Bouge joueur vers l'étagère 2
        consequences_action108_7.add(new int[]{10}); //Affiche boîte de dialogue
        Action action108_7 = new Action(1087,false,"S'approcher de l'étagère face à vous", consequences_action108_7, 108);

        ArrayList<int[]> consequences_action108_4 = new ArrayList<>();
        consequences_action108_4.add(new int[]{1,209}); //Bouge joueur vers l'étagère 3
        Action action108_4 = new Action(1084,true,"S'approcher de l'étagère de droite", consequences_action108_4, 108);

        ArrayList<int[]> consequences_action108_1 = new ArrayList<>();
        consequences_action108_1.add(new int[]{1,202}); //Bouge joueur vers le bureau
        Action action108_1 = new Action(1081,true,"Inspecter le bureau", consequences_action108_1, 108);

        ArrayList<int[]> consequences_action108_5 = new ArrayList<>();
        consequences_action108_5.add(new int[]{7,4006}); //Texte indice
        consequences_action108_5.add(new int[]{3,1085});
        consequences_action108_5.add(new int[]{14,30});
        Action action108_5 = new Action(1085,true,"S'assoir sur la chaise [Obtention d'un indice, diminution du temps]", consequences_action108_5, 108);

        ArrayList<int[]> consequences_action108_6 = new ArrayList<>();
        consequences_action108_6.add(new int[]{1,109}); //Bouge joueur vers l'étagère 1
        Action action108_6 = new Action(1086,true,"Aller à l'étage", consequences_action108_6, 108);


        //Actions de la salle 202 - Bureau

        ArrayList<int[]> consequences_action202_1 = new ArrayList<>();
        consequences_action202_1.add(new int[]{1,205}); //Bouge joueur vers la note
        Action action202_1 = new Action(2021,true,"Inspecter la note", consequences_action202_1, 202);

        ArrayList<int[]> consequences_action202_2 = new ArrayList<>();
        consequences_action202_2.add(new int[]{1,302}); //Bouge joueur vers le tiroir (énigme)
        consequences_action202_2.add(new int[]{10}); //Affiche boîte de dialogue
        Action action202_2 = new Action(2022,true,"Examiner le tiroir", consequences_action202_2, 202);

        ArrayList<int[]> consequences_action202_3 = new ArrayList<>();
        consequences_action202_3.add(new int[]{1,303}); //Bouge joueur vers le PC vérouillé (énigme)
        consequences_action202_3.add(new int[]{10}); //Affiche boîte de dialogue
        Action action202_3 = new Action(2023,true,"Examiner le PC", consequences_action202_3, 202);

        ArrayList<int[]> consequences_action202_4 = new ArrayList<>();
        consequences_action202_4.add(new int[]{1,204}); //Bouge joueur vers le tiroir dévérouillé
        Action action202_4 = new Action(2024,false,"Fouiller dans le tiroir", consequences_action202_4, 202);

        ArrayList<int[]> consequences_action202_5 = new ArrayList<>();
        consequences_action202_5.add(new int[]{1,206}); //Bouge joueur vers le PC dévérouillé
        Action action202_5 = new Action(2025,false,"Examiner le contenu du PC", consequences_action202_5, 202);


        //Actions de la salle 203 - Tiroir post-énigme

        ArrayList<int[]> consequences_action203_1 = new ArrayList<>();
        consequences_action203_1.add(new int[]{4,4}); //Ajoute objet clef
        consequences_action203_1.add(new int[]{3,2041}); //Bloque action (récupérable qu'une fois)
        Action action203_1 = new Action(2031,true,"Récupérer la clef", consequences_action203_1, 203);


        //Actions de la salle 204 - Tiroir

        ArrayList<int[]> consequences_action204_1 = new ArrayList<>();
        consequences_action204_1.add(new int[]{4,4}); //Ajoute objet clef
        consequences_action204_1.add(new int[]{3,2041}); //Bloque action (récupérable qu'une fois)
        Action action204_1 = new Action(2041,true,"Récupérer la clef", consequences_action204_1, 204);

        ArrayList<int[]> consequences_action204_2 = new ArrayList<>();
        consequences_action204_2.add(new int[]{7,2042}); //Rajoute du texte
        consequences_action204_2.add(new int[]{3,2042}); //Bloque action (faisable qu'une fois)
        Action action204_2 = new Action(2042, "Casser le double fond [Compas]", consequences_action204_2, 204, 3);

        ArrayList<int[]> consequences_action204_3 = new ArrayList<>();
        consequences_action204_3.add(new int[]{7,2043}); //Rajoute du texte
        consequences_action204_3.add(new int[]{3,2043}); //Bloque action (faisable qu'une fois)
        Action action204_3 = new Action(2043, "Enlever le double fond [Opinel]", consequences_action204_3, 204, 1);


        //Actions de la salle 205 - Note

        ArrayList<int[]> consequences_action205_1 = new ArrayList<>();
        consequences_action205_1.add(new int[]{7,2052}); //Ajoute du texte
        consequences_action205_1.add(new int[]{3,2051}); //Bloque l'action (faisable qu'une fois)
        Action action205_1 = new Action(2051,true,"Examiner ce qui est illisible [Loupe]", consequences_action205_1, 205);


        //Actions de la salle 206 - PC dévérouillé

        ArrayList<int[]> consequences_action206_1 = new ArrayList<>();
        //consequences_action206_1.add(new int[]{?}); //Fait évoluer l'image
        consequences_action206_1.add(new int[]{2,2062}); //Dévérouille l'action "Retour page précédente"
        consequences_action206_1.add(new int[]{3,2061}); //Vérouille cette action
        Action action206_1 = new Action(2061,true,"Passer à la page suivante", consequences_action206_1, 206);

        ArrayList<int[]> consequences_action206_2 = new ArrayList<>();
        //consequences_action206_2.add(new int[]{?}); //Fait évoluer l'image
        consequences_action206_2.add(new int[]{2,2061}); //Dévérouille l'action "Passer à la page suivante"
        consequences_action206_2.add(new int[]{3,2062}); //Vérouille cette action
        Action action206_2 = new Action(2062,false,"Retour à la page précédente", consequences_action206_2, 206);


        //Actions de la salle 207 - Étagère 1

        ArrayList<int[]> consequences_action207_1 = new ArrayList<>();
        consequences_action207_1.add(new int[]{7,2072}); //Rajoute texte
        consequences_action207_1.add(new int[]{3,2071}); //Bloque cette action (faisable qu'une fois)
        Action action207_1 = new Action(2071,true,"Lire le livre sur la cryptographie", consequences_action207_1, 207);


        //Actions de la salle 208 - Étagère 2 pré-utilisation clef

        ArrayList<int[]> consequences_action208_1 = new ArrayList<>();
        consequences_action208_1.add(new int[]{1,301}); //Rajoute texte
        consequences_action208_1.add(new int[]{2,1087}); //Dévérouille l'action l'accès à l'énigme de l'étagère
        consequences_action208_1.add(new int[]{3,1083}); //Vérouille l'accès à l'étagère pré-utilisation clef
        consequences_action208_1.add(new int[]{5,4}); // Supprimer la clef de l'inventaire après l'utilisation
        consequences_action208_1.add(new int[]{10}); //Affiche boîte de dialogue
        Action action208_1 = new Action(2081, "Essayer la clef dans la serrure [Clef]", consequences_action208_1, 208, 4);


        //Actions de la salle 210 - Porte

        ArrayList<int[]> consequences_action211_1 = new ArrayList<>();
        consequences_action211_1.add(new int[]{7,2112}); //Rajoute texte
        consequences_action211_1.add(new int[]{3,2111}); //Bloque cette action (faisable qu'une fois)
        Action action211_1 = new Action(2111,true,"Essayer d'enfoncer la porte", consequences_action211_1, 211);

        ArrayList<int[]> consequences_action211_2 = new ArrayList<>();
        consequences_action211_2.add(new int[]{7,2113}); //Rajoute texte
        consequences_action211_2.add(new int[]{3,2112}); //Bloque cette action (faisable qu'une fois)
        Action action211_2 = new Action(2112, "Essayer la clef dans la serrure [Clef]", consequences_action211_2, 211, 4);


        //Actions de la salle 109 - Étage

        ArrayList<int[]> consequences_action109_1 = new ArrayList<>();
        consequences_action109_1.add(new int[]{1,108}); //Bouge le joueur vers RDC
        Action action109_1 = new Action(1091,true,"Descendre au rez-de-chaussée", consequences_action109_1, 109);

        ArrayList<int[]> consequences_action109_2 = new ArrayList<>();
        consequences_action109_2.add(new int[]{1,210}); //Bouge le joueur vers RDC
        Action action109_2 = new Action(1092,true,"Regarder le plafond", consequences_action109_2, 109);

    }
}
