package Partie;

import java.util.ArrayList;

public class Scenario_structure {

    public Scenario_structure() {
        Scenario scenar = new Scenario();

        // Prologue
        Room room1 = new Room(101,102,-1,-1,-1,true,1011,"pictures/Entree.png"); //Entrée enssat
        Room room2 = new Room(102,-1,-1,-1,-1, false,1021,"pictures/Amphi.png"); //Amphi
        Room room3 = new Room(103,-1,-1,-1,-1, true,1031,"pictures/Amphi.png"); //Amphi post-conférence
        Room room3_1 = new Room(201,103,2011,"pictures/Trousse.png"); //trousse
        Room room4 = new Room(104,-1,-1,-1,-1, true,1041,"pictures/Cafeteria.png"); //Cafétaria
        Room room5 = new Room(105,-1,-1,-1,-1, true,1051,"pictures/Exterieur.png"); //Extérieur
        Room room6 = new Room(106,-1,-1,-1,-1, true,1061,"pictures/PC.png"); //PC
        Room room7 = new Room(107,108,-1,-1,-1, true,1071,"pictures/Bibliotheque.png"); //Début aventure
        // Room room8 = new Room(108,-1,-1,107,-1, true,1071,"pictures/Bibliotheque.png"); //Test bac à sable


        //Création des objets
        Item opinel = new Item(1,"Petit opinel","Petit couteau pouvant être bien pratique",-1, "objects/Opinel.png");
        Item loupe = new Item(2,"Loupe","Petite loupe pouvant être bien pratique",-1, "objects/Loupe.png");
        Item compas = new Item(3,"Compas","Compas pouvant être bien pratique",-1, "objects/Compas.png");
        Item couteau_suisse = new Item(42, "Couteau Suisse de l'Admin", "Couteau Suisse de l'Admin - Tout est possible avec ça", -1, "objects/Compas.png");

        //Actions de la salle 101 - Entrée de l'enssat

        ArrayList<int[]> consequences_action101_1 = new ArrayList<>();
        consequences_action101_1.add(new int[]{7,1012}); //Affichage nouveau texte
        consequences_action101_1.add(new int[]{3,1011}); //Rend l'action innaccessible (faisable qu'une fois)
        Action action101_1 = new Action(1011,true,"Regarder autour de vous", consequences_action101_1, 101);

        ArrayList<int[]> consequences_action101_2 = new ArrayList<>();
        consequences_action101_2.add(new int[]{7,1013}); //Affichage nouveau texte
        consequences_action101_2.add(new int[]{3,1012}); //Rend l'action innaccessible (faisable qu'une fois)
        consequences_action101_2.add(new int[]{2,1013}); //Déblocage action
        Action action101_2 = new Action(1012,true,"Demander son chemin", consequences_action101_2, 101);

        ArrayList<int[]> consequences_action101_3 = new ArrayList<>();
        consequences_action101_3.add(new int[]{7,1014}); //Affichage nouveau texte
        consequences_action101_3.add(new int[]{3,1013}); //Rend l'action innaccessible (faisable qu'une fois)
        consequences_action101_3.add(new int[]{9,102}); //Débloque salle suivante
        Action action101_3 = new Action(1013,false,"Lire le panneau", consequences_action101_3, 101);

        /*ArrayList<int[]> consequences_action101_4 = new ArrayList<>();
        consequences_action101_4.add(new int[]{4,3}); //Ajoute l'objet à l'inventaire
        Action action101_4 = new Action(1014,true,"Test objet", consequences_action101_4, 101);*/


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
        Action action103_2 = new Action(1032,false,"Se rendre à la cafétaria", consequences_action103_2, 103);

        ArrayList<int[]> consequences_action103_3 = new ArrayList<>();
        consequences_action103_3.add(new int[]{1,105}); //Bouge le joueur dans la salle suivante
        Action action103_3 = new Action(1033,false,"Sortir de l'ENSSAT", consequences_action103_3, 103);

        ArrayList<int[]> consequences_action103_4 = new ArrayList<>();
        consequences_action103_4.add(new int[]{1,106}); //Bouge le joueur dans la salle suivante
        Action action103_4 = new Action(1034,false,"Trouver une salle avec un PC", consequences_action103_4, 103);


        /*------------------------Action test mode bac à sable-------------------------------------------
        ArrayList<int[]> consequences_action103_5 = new ArrayList<>();
        consequences_action103_5.add(new int[]{12,107}); //Bouge le joueur dans la salle suivante
        Action action103_5 = new Action(1035,true,"Test bac à sable", consequences_action103_5, 103);
        -----------------------------------------------------------------------------------------------*/

        //Actions de la salle 201 - Trousse

        ArrayList<int[]> consequences_action201_1 = new ArrayList<>();
        consequences_action201_1.add(new int[]{4,3}); //Ajoute l'objet à l'inventaire
        consequences_action201_1.add(new int[]{1,103}); //Bouge le joueur dans la salle précédente
        consequences_action201_1.add(new int[]{3,1031}); //Rend l'inspection de la trousse impossible
        consequences_action201_1.add(new int[]{2,1032}); //Débloque action pour la suite
        consequences_action201_1.add(new int[]{2,1033}); //Débloque action pour la suite
        consequences_action201_1.add(new int[]{2,1034}); //Débloque action pour la suite
        consequences_action201_1.add(new int[]{7,1032}); //Affiche du texte supplémentaire
        Action action201_1 = new Action(2011,true,"Prendre le compas", consequences_action201_1, 201);

        ArrayList<int[]> consequences_action201_2 = new ArrayList<>();
        consequences_action201_2.add(new int[]{4,1}); //Ajoute l'objet à l'inventaire
        consequences_action201_2.add(new int[]{1,103}); //Bouge le joueur dans la salle précédente
        consequences_action201_2.add(new int[]{3,1031}); //Rend l'inspection de la trousse impossible
        consequences_action201_2.add(new int[]{2,1032}); //Débloque action pour la suite
        consequences_action201_2.add(new int[]{2,1033}); //Débloque action pour la suite
        consequences_action201_2.add(new int[]{2,1034}); //Débloque action pour la suite
        consequences_action201_2.add(new int[]{7,1032}); //Affiche du texte supplémentaire
        Action action201_2 = new Action(2012,true,"Prendre le petit opinel", consequences_action201_2, 201);

        ArrayList<int[]> consequences_action201_3 = new ArrayList<>();
        consequences_action201_3.add(new int[]{4,2}); //Ajoute l'objet à l'inventaire
        consequences_action201_3.add(new int[]{1,103}); //Bouge le joueur dans la salle précédente
        consequences_action201_3.add(new int[]{3,1031}); //Rend l'inspection de la trousse impossible
        consequences_action201_3.add(new int[]{2,1032}); //Débloque action pour la suite
        consequences_action201_3.add(new int[]{2,1033}); //Débloque action pour la suite
        consequences_action201_3.add(new int[]{2,1034}); //Débloque action pour la suite
        consequences_action201_3.add(new int[]{7,1032}); //Affiche du texte supplémentaire
        Action action201_3 = new Action(2013,true,"Prendre la petite loupe", consequences_action201_3, 201);


        //Actions de la salle 104 - Cafétaria

        ArrayList<int[]> consequences_action104_1 = new ArrayList<>();
        consequences_action104_1.add(new int[]{1,107});
        Action action104_1 = new Action(1041,true,"Commencer l'aventure dans l'ENSSAT", consequences_action104_1, 104);

        ArrayList<int[]> consequences_action104_2 = new ArrayList<>();
        consequences_action104_2.add(new int[]{11});
        Action action104_2 = new Action(1042,true,"J'ai pas envie, je préfère rester chez moi...", consequences_action104_2, 104);

        //Actions de la salle 105 - Extérieur

        ArrayList<int[]> consequences_action105_1 = new ArrayList<>();
        consequences_action105_1.add(new int[]{1,107});
        Action action105_1 = new Action(1051,true,"Commencer l'aventure dans l'ENSSAT", consequences_action105_1, 105);

        ArrayList<int[]> consequences_action105_2 = new ArrayList<>();
        consequences_action105_2.add(new int[]{11});
        Action action105_2 = new Action(1052,true,"J'ai pas envie, je préfère rester chez moi...", consequences_action105_2, 105);

        //Actions de la salle 106 - PC

        ArrayList<int[]> consequences_action106_1 = new ArrayList<>();
        consequences_action106_1.add(new int[]{1,107});
        Action action106_1 = new Action(1061,true,"Commencer l'aventure dans l'ENSSAT", consequences_action106_1, 106);

        ArrayList<int[]> consequences_action106_2 = new ArrayList<>();
        consequences_action106_2.add(new int[]{11});
        Action action106_2 = new Action(1062,true,"J'ai pas envie, je préfère rester chez moi...", consequences_action106_2, 106);


        /*------------------------------------Test mode bac à sable-------------------------------------------
        ArrayList<int[]> consequences_action107_1 = new ArrayList<>();
        consequences_action107_1.add(new int[]{7,1071});
        Action action107_1 = new Action(1071,"Action[opinel]",consequences_action107_1,107,1);

        ArrayList<int[]> consequences_action107_2 = new ArrayList<>();
        consequences_action107_2.add(new int[]{7,1071});
        Action action107_2 = new Action(1072,"Action[loupe]",consequences_action107_2,107,2);

        ArrayList<int[]> consequences_action107_3 = new ArrayList<>();
        consequences_action107_3.add(new int[]{7,1071});
        Action action107_3 = new Action(1073,"Action[compas]",consequences_action107_3,107,3);

        ArrayList<int[]> consequences_action107_4 = new ArrayList<>();
        consequences_action107_4.add(new int[]{1,108});
        Action action107_4 = new Action(1074,true,"108", consequences_action107_4, 107);

        ArrayList<int[]> consequences_action108_1 = new ArrayList<>();
        consequences_action108_1.add(new int[]{9,108});
        Action action108_1 = new Action(1081,"Action[compas]",consequences_action108_1,108,3);*/

       /* // Niveau Test
        Room room1 = new Room(1001,1002,-1,-1,-1,true,10011,"pictures/Salle1.png"); //première salle
        Room room2 = new Room(1002,-1,-1,1001,-1, false,10021,"pictures/Salle2.png"); //deuxième salle
        Room room1_1 = new Room(2001,1001,20011,"pictures/Table.png"); //table dans salle 1
        Room room1_2 = new Room(2002,1001,20021,"pictures/Porte.png"); //porte dans salle 1
        Room room1_1_1 = new Room(2003,2001,20031,"pictures/Vase.png"); //vase sur table dans salle 1


        //Enigme de la salle 102
        ArrayList<int[]> consequences_enigme1 = new ArrayList<>();
        consequences_enigme1.add(new int[]{10}); // fin de partie
        Enigma enigme1 = new Enigma(3001,1002,30011,"pictures/Tableau.png",2022,consequences_enigme1);


        //Création des objets
        Item objet1 = new Item(1,"clef","Clef ancienne, sert probablement pour déverouiller une serrure",1, "objects/key.png");


        //Actions de la salle 1001
        ArrayList<int[]> consequences_action1001_1 = new ArrayList<>();
        consequences_action1001_1.add(new int[]{1,2001});
        Action action1001_1 = new Action(10011,true,"Examiner la table", consequences_action1001_1, 1001); //déplacement vers table, 1001 à 2001

        ArrayList<int[]> consequences_action1001_2 = new ArrayList<>();
        consequences_action1001_2.add(new int[]{1,2002});
        Action action1001_2 = new Action(10012,true,"Examiner la porte", consequences_action1001_2, 1001); //déplacement vers la porte, 1001 à 2002


        //Actions de la salle 2001 (table)
        ArrayList<int[]> consequences_action2001_1 = new ArrayList<>();
        consequences_action2001_1.add(new int[]{1,2003});
        Action action2001_1 = new Action(20011,true,"Examiner le vase", consequences_action2001_1, 2001); //déplacement vers le vase, 2001 à 2003


        //Actions de la salle 2003 (vase)
        ArrayList<int[]> consequences_action2003_1 = new ArrayList<>();
        consequences_action2003_1.add(new int[]{4,1});
        consequences_action2003_1.add(new int[]{3,20011});
        consequences_action2003_1.add(new int[]{1,2001});
        consequences_action2003_1.add(new int[]{7,20012});
        Action action2003_1 = new Action(20031,true,"Récupérer la clef", consequences_action2003_1, 2003); // ajout de la clef à l'inventaire, déplacement vers salle précédente (201) puis mise à jour du texte de cette salle  et verrouillage de l'action permettant d'examiner le vase


        //Actions de la salle 2002 (porte)
        ArrayList<int[]> consequences_action2002_1 = new ArrayList<>();
        consequences_action2002_1.add(new int[]{7,20022});
        consequences_action2002_1.add(new int[]{3,20021});
        Action action2002_1 = new Action(20021,true,"Essayer d'enfoncer la porte", consequences_action2002_1, 2002); //mise à jour du texte

        ArrayList<int[]> consequences_action2002_2 = new ArrayList<>();
        consequences_action2002_2.add(new int[]{6,1});
        consequences_action2002_2.add(new int[]{9,1002});
        consequences_action2002_2.add(new int[]{3,10012});
        consequences_action2002_2.add(new int[]{1,1001});
        consequences_action2002_2.add(new int[]{7,10012});
        Action action2002_2 = new Action(20022,"Utiliser la clef", consequences_action2002_2, 2002, 1); //ajoute une utilisation à la clef, dévérouille l'action permetant d'accéder à 102 depuis 101, bloque action d'examiner la porte depuis 101, ajoute texte à salle 101, retour dans 101


        //Actions de la salle 1002
        ArrayList<int[]> consequences_action1002_1 = new ArrayList<>();
        consequences_action1002_1.add(new int[]{1,3001});
        consequences_action1002_1.add(new int[]{10});
        Action action1002_1 = new Action(10021,true,"Examiner le tableau", consequences_action1002_1, 1002); //déplacement vers table, 102 à 301

        //Actions de l'énigme 3001
        ArrayList<int[]> consequences_action3001_1 = new ArrayList<>();
        consequences_action3001_1.add(new int[]{7,30012});
        consequences_action3001_1.add(new int[]{3,30011});
        Action action3001_1 = new Action(30011,true,"Demander un indice", consequences_action3001_1, 3001); //mise à jour du texte */
    }
}
