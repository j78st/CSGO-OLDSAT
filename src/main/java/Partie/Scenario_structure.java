package Partie;

import Interface.Settings.Engine;
import Music.Systems.Son;
import Music.Systems.WorldBoxDisc;
import Timer.TimerController;

import java.util.ArrayList;

public class Scenario_structure {

    public Scenario_structure() {
        Scenario scenar = new Scenario();
        Sounds_list sounds_list = new Sounds_list();

        /*-----------------------------------------Prologue-------------------------------------------*/

        //Salles
        Room room1 = new Room(101,102,-1,-1,-1,true,1011,"pictures/Hall.png", "Prologue - Hall d'entrée"); //Hall
        Room room2 = new Room(102,-1,-1,-1,-1, false,1021,"pictures/Amphi.png", "Prologue - Amphithéâtre"); //Amphi
        Room room3 = new Room(103,-1,-1,-1,-1, true,1031,"pictures/Amphi2.png"); //Amphi post-conférence
        Room room3_1 = new Room(201,103,2011,"pictures/Trousse.png"); //trousse
        Room room4 = new Room(104,-1,-1,-1,-1,true,1041,"pictures/Exterieur.png", "Prologue - Extérieur"); //Exterieur

        //Objets
        Item compas = new Item(1,"Compas","Compas - Peut être bien pratique",-1, "objects/Compas.png");
        Item loupe = new Item(2,"Loupe","Petite loupe - Peut être bien pratique",-1, "objects/Loupe.png");
        Item opinel = new Item(3,"Petit opinel","Petit couteau - Peut être bien pratique",-1, "objects/Opinel.png");
        Item couteau_suisse = new Item(42, "Couteau Suisse de l'Admin", "Couteau Suisse de l'Admin - Tout est possible avec ça", -1, "objects/couteau_suisse.png");

        //Actions

        //Hall
        ArrayList<int[]> consequences_action101_1 = new ArrayList<>();
        consequences_action101_1.add(new int[]{7,1012}); //Texte
        consequences_action101_1.add(new int[]{3,1011}); //Faisable qu'une fois
        consequences_action101_1.add(new int[]{2,1012}); //Déblocage action
        Action action101_1 = new Action(1011,true,"Demander son chemin", consequences_action101_1, 101);

        ArrayList<int[]> consequences_action101_2 = new ArrayList<>();
        consequences_action101_2.add(new int[]{7,1013}); //Texte
        consequences_action101_2.add(new int[]{3,1012}); //Faisable qu'une fois
        consequences_action101_2.add(new int[]{9,102}); //Débloque salle suivante
        Action action101_2 = new Action(1012,false,"Lire le panneau", consequences_action101_2, 101);

        /*ArrayList<int[]> consequences_action101_67 = new ArrayList<>();
        consequences_action101_67.add(new int[]{17,44,47});
        Action action101_67 = new Action(10167,true,"Test son", consequences_action101_67, 101);

        ArrayList<int[]> consequences_action101_68 = new ArrayList<>();
        consequences_action101_68.add(new int[]{12,206});
        Action action101_68 = new Action(10168,true,"Saut admin PC", consequences_action101_68, 101);

        ArrayList<int[]> consequences_action101_69 = new ArrayList<>();
        consequences_action101_69.add(new int[]{12,107});
        Action action101_69 = new Action(10169,true,"Saut admin début d'aventure", consequences_action101_69, 101);

        ArrayList<int[]> consequences_action101_70 = new ArrayList<>();
        consequences_action101_70.add(new int[]{1,305});
        Action action101_70 = new Action(10170,true,"Saut admin enigme 305", consequences_action101_70, 101);

        ArrayList<int[]> consequences_action101_71 = new ArrayList<>();
        consequences_action101_71.add(new int[]{22});
        consequences_action101_71.add(new int[]{4,5});
        Action action101_71 = new Action(10171,true,"Map", consequences_action101_71, 101);

        ArrayList<int[]> consequences_action101_72 = new ArrayList<>();
        consequences_action101_72.add(new int[]{1,111});
        Engine.chrono = new TimerController(60 * 25);
        Engine.chrono.start();
        Action action101_72 = new Action(10172,true,"Saut test score", consequences_action101_72, 101);*/

        //Amphi pré-conférence
        ArrayList<int[]> consequences_action102_1 = new ArrayList<>();
        consequences_action102_1.add(new int[]{1,103}); //Bouge le joueur dans la salle suivante
        //consequences_action102_1.add(new int[]{20,55}); //Arrête le bruit de classe
        Action action102_1 = new Action(1021,true,"Écouter la conférence (Vous n'avez pas vraiment le choix...)", consequences_action102_1, 102);

        //Amphi post-conférence
        ArrayList<int[]> consequences_action103_1 = new ArrayList<>();
        consequences_action103_1.add(new int[]{1,201}); //Bouge le joueur dans la salle suivante
        consequences_action103_1.add(new int[]{17,53}); //Bruit de zip
        Action action103_1 = new Action(1031,true,"Fouiller dans la trousse", consequences_action103_1, 103);

        ArrayList<int[]> consequences_action103_2 = new ArrayList<>();
        consequences_action103_2.add(new int[]{1,104}); //Bouge le joueur dans la salle suivante
        consequences_action103_2.add(new int[]{17,43}); //Bruit de pas
        consequences_action103_2.add(new int[]{20,55}); //Arrête le bruit de classe
        consequences_action103_2.add(new int[]{19,56}); //Démarre son ambiant extérieur
        Action action103_2 = new Action(1032,false,"Quitter la salle", consequences_action103_2, 103);

        //Trousse
        ArrayList<int[]> consequences_action201_1 = new ArrayList<>();
        consequences_action201_1.add(new int[]{4,1}); //Ajoute l'objet à l'inventaire
        consequences_action201_1.add(new int[]{1,103}); //Bouge le joueur dans la salle précédente
        consequences_action201_1.add(new int[]{3,1031}); //Rend l'inspection de la trousse impossible
        consequences_action201_1.add(new int[]{2,1032}); //Débloque action pour la suite
        consequences_action201_1.add(new int[]{7,1032}); //Affiche du texte supplémentaire
        consequences_action201_1.add(new int[]{7,1033}); //Affiche du texte supplémentaire
        consequences_action201_1.add(new int[]{7,1036}); //Affiche du texte supplémentaire
        consequences_action201_1.add(new int[]{17,28}); //Bruit de prise d'objet
        Action action201_1 = new Action(2011,true,"Prendre le compas", consequences_action201_1, 201);

        ArrayList<int[]> consequences_action201_2 = new ArrayList<>();
        consequences_action201_2.add(new int[]{4,2}); //Ajoute l'objet à l'inventaire
        consequences_action201_2.add(new int[]{1,103}); //Bouge le joueur dans la salle précédente
        consequences_action201_2.add(new int[]{3,1031}); //Rend l'inspection de la trousse impossible
        consequences_action201_2.add(new int[]{2,1032}); //Débloque action pour la suite
        consequences_action201_2.add(new int[]{7,1032}); //Affiche du texte supplémentaire
        consequences_action201_2.add(new int[]{7,1034}); //Affiche du texte supplémentaire
        consequences_action201_2.add(new int[]{7,1036}); //Affiche du texte supplémentaire
        consequences_action201_2.add(new int[]{17,28}); //Bruit de prise d'objet
        Action action201_2 = new Action(2012,true,"Prendre la loupe", consequences_action201_2, 201);

        ArrayList<int[]> consequences_action201_3 = new ArrayList<>();
        consequences_action201_3.add(new int[]{4,3}); //Ajoute l'objet à l'inventaire
        consequences_action201_3.add(new int[]{1,103}); //Bouge le joueur dans la salle précédente
        consequences_action201_3.add(new int[]{3,1031}); //Rend l'inspection de la trousse impossible
        consequences_action201_3.add(new int[]{2,1032}); //Débloque action pour la suite
        consequences_action201_3.add(new int[]{7,1032}); //Affiche du texte supplémentaire
        consequences_action201_3.add(new int[]{7,1035}); //Affiche du texte supplémentaire
        consequences_action201_3.add(new int[]{7,1036}); //Affiche du texte supplémentaire
        consequences_action201_3.add(new int[]{17,28}); //Bruit de prise d'objet
        Action action201_3 = new Action(2013,true,"Prendre le petit opinel", consequences_action201_3, 201);

        //Exterieur
        ArrayList<int[]> consequences_action104_1 = new ArrayList<>();
        consequences_action104_1.add(new int[]{7,1042}); //Texte
        consequences_action104_1.add(new int[]{3,1041}); //Faisable qu'une fois
        Action action104_1 = new Action(1041,true,"Parler à un groupe", consequences_action104_1, 104);

        ArrayList<int[]> consequences_action104_2 = new ArrayList<>();
        consequences_action104_2.add(new int[]{15,1}); //Lance la cinématique
        consequences_action104_2.add(new int[]{3,1042}); //Bloque l'action pour qu'on ne puisse pas la spam clic
        consequences_action104_2.add(new int[]{3,1041}); //Bloque l'action de "Parler à un groupe" pour qu'on ne puisse pas faire évoluer le texte de la salle pendant que la cinématique se lance
        consequences_action104_2.add(new int[]{20,56}); //Arrête le son d'ambiance extérieur
        consequences_action104_2.add(new int[]{18,43,2,15}); //Joue son bruit de pas puis hibou 2 secondes après
        Action action104_2 = new Action(1042,true,"Rentrer chez vous [FIN DU PROLOGUE]", consequences_action104_2, 104);

        ArrayList<int[]> consequences_action104_3 = new ArrayList<>();
        consequences_action104_3.add(new int[]{1,107}); //Bouge le joueur dans la salle suivante
        Action action104_3 = new Action(1043,false,"", consequences_action104_3, 104); //Utilisé en fin de cinématique



        /*-----------------------------------------Acte 1-------------------------------------------*/

        //Salles
        Room room7 = new Room(107,-1,-1,-1,-1,false,1071,"pictures/biblio_nuit.png", "Acte 1 - Bibliothèque");
        Room room8 = new Room(108,110,-1,-1,-1, true,1081,"pictures/108/1.png"); // RDC bibliothèque
        Room room8_1 = new Room(202,108,2021,"pictures/202/1.png"); // Bureau
        Room room8_1_1 = new Room(203,202,2031,"pictures/tiroir_ouvert_clé.png"); // Tiroir post-énigme
        Room room8_1_2 = new Room(204,202,2041,"pictures/tiroir_ouvert_clé.png"); // Tiroir
        Room room8_1_3 = new Room(205,202,2051,"pictures/ordonnance.png"); // Note sur le bureau
        Room room8_2 = new Room(207,108,2071,"pictures/Trousse.png"); // Étagère 1
        Room room8_3 = new Room(208,108,2081,"pictures/Trousse.png"); // Étagère 2 pré-utilisation de la clef
        Room room8_4 = new Room(209,108,2091,"pictures/Trousse.png"); // Étagère 3
        Room room8_5 = new Room(211,108,2111,"pictures/Trousse.png"); // Porte
        Room room9 = new Room(109,-1,-1,-1,-1, true,1091,"pictures/Bibliotheque.png"); // Étage bibliothèque
        Room room9_1 = new Room(210,109,2101,"pictures/Trousse.png"); // Plafond
        Room room8_2_1 = new Room(212,207,2121,"pictures/Trousse.png"); // Livre 1-1
        Room room8_2_2 = new Room(213,207,2131,"pictures/Trousse.png"); // Livre 1-2
        Room room8_2_3 = new Room(214,207,2141,"pictures/Trousse.png"); // Livre 1-3
        Room room10 = new Room(110,-1,-1,108,-1, false,1101,"pictures/Bibliotheque.png", "Acte 1 - Salle derrière étagère"); // Fin scène 1


        Item clef = new Item(4,"Clef","Ancienne clef - Elle va sûrement vous permettre de sortir d'ici",-1, "objects/key.png");
        Item carnet = new Item(5,"Carnet vieilli","Vieux carnet - Peut être trouverez-vous un indice à l'intérieur",-1, "objects/key2.png");



        ArrayList<int[]> consequences_enigme1 = new ArrayList<>();
        consequences_enigme1.add(new int[]{9,110}); // Débloque salle suivante
        consequences_enigme1.add(new int[]{7,3012,108}); // Rajoute texte de fin d'énigme à la salle d'origine
        consequences_enigme1.add(new int[]{13,35}); //Bruit de porte qui craque
        consequences_enigme1.add(new int[]{12,108,2});
        Enigma enigme1 = new Enigma(301,108,3011,"pictures/Trousse.png","le cid",consequences_enigme1); // Étagère 2 - Énigme

        ArrayList<int[]> consequences_enigme2 = new ArrayList<>();
        consequences_enigme2.add(new int[]{2,2024}); // Débloque l'action accès tiroir depuis le bureau
        consequences_enigme2.add(new int[]{1,203}); // Déplace le joueur vers le tiroir
        consequences_enigme2.add(new int[]{2,1085}); // Débloque la demande d'indice si elle a été utilisée avant
        consequences_enigme2.add(new int[]{11,1085,4003}); // Fais évoluer le texte de l'indice
        consequences_enigme2.add(new int[]{13,41}); //Bruit du tiroir qui s'ouvre
        consequences_enigme2.add(new int[]{12,202,2}); //Change image de la bibliothèque
        Enigma enigme2 = new Enigma(302,202,3021,"pictures/tiroir_fermé.png","974",consequences_enigme2); // Tiroir vérouillé

        ArrayList<int[]> consequences_enigme3 = new ArrayList<>();
        consequences_enigme3.add(new int[]{2,2025}); // Débloque l'action accès PC dévérouillé depuis le bureau
        consequences_enigme3.add(new int[]{1,206}); // Déplace le joueur vers le PC dévérouillé
        Enigma enigme3 = new Enigma(303,202,3031,"pictures/pc_verrouille.png","motdepasse",consequences_enigme3); // PC vérouillé

        ArrayList<int[]> consequences_enigme4 = new ArrayList<>();
        consequences_enigme4.add(new int[]{7,3042,304}); // Rajoute texte de fin d'énigme à la salle de l'énigme
        consequences_enigme4.add(new int[]{2,1085}); // Débloque la demande d'indice si elle a été utilisée avant
        consequences_enigme4.add(new int[]{11,1085,4005}); // Fais évoluer le texte de l'indice
        ArrayList<double[]> zone_click_304 = new ArrayList<>();
        zone_click_304.add(new double[]{3,0.55,0.65,0.135,0.68});
        zone_click_304.add(new double[]{4,0.658,0.74,0.135,0.68});
        zone_click_304.add(new double[]{2,0.758,0.84,0.135,0.68});
        zone_click_304.add(new double[]{1,0.857,0.94,0.135,0.68});
        Enigma enigme4 = new Enigma(304,109,3041,"pictures/304/3421.png","1234",consequences_enigme4,zone_click_304,1); // Étagère centrale étage

        ArrayList<int[]> consequences_enigme5 = new ArrayList<>();
        consequences_enigme5.add(new int[]{7,1103,110});
        consequences_enigme5.add(new int[]{2,1102});
        ArrayList<double[]> zone_click_305 = new ArrayList<>();
        zone_click_305.add(new double[]{1,0.60,0.67,0.64,0.74});
        zone_click_305.add(new double[]{2,0.75,0.81,0.50,0.61});
        zone_click_305.add(new double[]{3,0.85,0.91,0.14,0.25});
        zone_click_305.add(new double[]{4,0.63,0.70,0.22,0.33});
        zone_click_305.add(new double[]{5,0.875,0.93,0.65,0.76});
        Enigma enigme5 = new Enigma(305,110,3051,"pictures/305.png","12345",consequences_enigme5,zone_click_305,2); // Énigme suite de clics test


        //PC cliquable

        ArrayList<double[]> zone_click_206 = new ArrayList<>();
        zone_click_206.add(new double[]{1,0.56,0.61,0.20,0.28});
        zone_click_206.add(new double[]{2,0.56,0.61,0.30,0.38});
        zone_click_206.add(new double[]{3,0.56,0.61,0.40,0.49});
        Enigma pc_ecran1 = new Enigma(206,202,2061,"pictures/206/206.png","",new ArrayList<>(),zone_click_206,3); // PC cliquable bureau

        ArrayList<double[]> zone_click_2062 = new ArrayList<>();
        zone_click_2062.add(new double[]{6,0.9,0.94,0.17,0.21});
        Enigma pc_ecran2 = new Enigma(2062,202,2061,"pictures/206/2062.png","",new ArrayList<>(),zone_click_2062,3); // PC cliquable écran commandes

        ArrayList<double[]> zone_click_2063 = new ArrayList<>();
        zone_click_2063.add(new double[]{5,0.755,0.79,0.51,0.54});
        zone_click_2063.add(new double[]{6,0.9,0.94,0.17,0.21});
        Enigma pc_ecran3 = new Enigma(2063,202,2061,"pictures/206/2063.png","",new ArrayList<>(),zone_click_2063,3); // PC cliquable écran emprunt 1

        ArrayList<double[]> zone_click_2064 = new ArrayList<>();
        zone_click_2064.add(new double[]{4,0.70,0.74,0.51,0.54});
        zone_click_2064.add(new double[]{6,0.9,0.94,0.17,0.21});
        Enigma pc_ecran4 = new Enigma(2064,202,2061,"pictures/206/2064.png","",new ArrayList<>(),zone_click_2064,3); // PC cliquable écran emprunt 2

        ArrayList<double[]> zone_click_2065 = new ArrayList<>();
        zone_click_2065.add(new double[]{5,0.755,0.79,0.51,0.54});
        zone_click_2065.add(new double[]{6,0.9,0.94,0.17,0.21});
        Enigma pc_ecran5 = new Enigma(2065,202,2061,"pictures/206/2065.png","",new ArrayList<>(),zone_click_2065,3); // PC cliquable écran catalogue 1

        ArrayList<double[]> zone_click_2066 = new ArrayList<>();
        zone_click_2066.add(new double[]{4,0.70,0.74,0.51,0.54});
        zone_click_2066.add(new double[]{5,0.755,0.79,0.51,0.54});
        zone_click_2066.add(new double[]{6,0.9,0.94,0.17,0.21});
        Enigma pc_ecran6 = new Enigma(2066,202,2061,"pictures/206/2066.png","",new ArrayList<>(),zone_click_2066,3); // PC cliquable écran emprunt 2

        ArrayList<double[]> zone_click_2067 = new ArrayList<>();
        zone_click_2067.add(new double[]{4,0.70,0.74,0.51,0.54});
        zone_click_2067.add(new double[]{6,0.9,0.94,0.17,0.21});
        Enigma pc_ecran7 = new Enigma(2067,202,2061,"pictures/206/2067.png","",new ArrayList<>(),zone_click_2067,3); // PC cliquable écran emprunt 2


        //Actions de la salle 206 - PC dévérouillé

        Action action206_3 = new Action(2063,false,"", new ArrayList<>(), 206); // Action servant à la gestion du pc interactif


        //Actions de la salle 107 - Début de l'aventure

        ArrayList<int[]> consequences_action107_1 = new ArrayList<>();
        consequences_action107_1.add(new int[]{7,1072}); //text
        consequences_action107_1.add(new int[]{2,1072}); //debloque
        consequences_action107_1.add(new int[]{3,1071}); //faisable qu'une fois
        consequences_action107_1.add(new int[]{17,7}); //Bruit de porte qu'on essaye d'ouvrir
        Action action107_1 = new Action(1071,true,"Ouvrir la porte", consequences_action107_1, 107);

        ArrayList<int[]> consequences_action107_2 = new ArrayList<>();
        consequences_action107_2.add(new int[]{1,108}); //Bouge joueur vers salle 108
        consequences_action107_2.add(new int[]{17,54}); //Bruit interrupteur
        Action action107_2 = new Action(1072,false,"Appuyer sur l'interrupteur", consequences_action107_2, 107);


        //Actions de la salle 108 - RDC bibliothèque

        ArrayList<int[]> consequences_action108_8 = new ArrayList<>();
        consequences_action108_8.add(new int[]{1,211}); //Bouge joueur vers la porte
        Action action108_8 = new Action(1088,true,"Examiner la porte", consequences_action108_8, 108);

        ArrayList<int[]> consequences_action108_2 = new ArrayList<>();
        consequences_action108_2.add(new int[]{1,207}); //Bouge joueur vers l'étagère 1
        Action action108_2 = new Action(1082,true,"S'approcher de l'étagère de gauche face à vous", consequences_action108_2, 108);

        ArrayList<int[]> consequences_action108_3 = new ArrayList<>();
        consequences_action108_3.add(new int[]{1,208}); //Bouge joueur vers l'étagère 2
        Action action108_3 = new Action(1083,true,"S'approcher de l'étagère au centre face à vous", consequences_action108_3, 108);

        ArrayList<int[]> consequences_action108_7 = new ArrayList<>();
        consequences_action108_7.add(new int[]{1,301}); //Bouge joueur vers l'étagère 2
        consequences_action108_7.add(new int[]{10}); //Affiche boîte de dialogue
        Action action108_7 = new Action(1087,false,"S'approcher de l'étagère au centre face à vous", consequences_action108_7, 108);

        ArrayList<int[]> consequences_action108_4 = new ArrayList<>();
        consequences_action108_4.add(new int[]{1,209}); //Bouge joueur vers l'étagère 3
        Action action108_4 = new Action(1084,true,"S'approcher de l'étagère de droite face à vous", consequences_action108_4, 108);

        ArrayList<int[]> consequences_action108_1 = new ArrayList<>();
        consequences_action108_1.add(new int[]{1,202}); //Bouge joueur vers le bureau
        Action action108_1 = new Action(1081,true,"Inspecter le bureau", consequences_action108_1, 108);

        ArrayList<int[]> consequences_action108_5 = new ArrayList<>();
        consequences_action108_5.add(new int[]{7,4001}); //Texte indice
        consequences_action108_5.add(new int[]{3,1085}); //Rend la demande d'indice indisponible
        consequences_action108_5.add(new int[]{14,30});
        consequences_action108_5.add(new int[]{17,6});
        Action action108_5 = new Action(1085,true,"S'assoir sur la chaise [Obtention d'un indice, diminution du temps]", consequences_action108_5, 108);

        ArrayList<int[]> consequences_action108_6 = new ArrayList<>();
        consequences_action108_6.add(new int[]{1,109}); //Bouge joueur vers l'étagère 1
        consequences_action108_6.add(new int[]{17,43}); //Bruit de pas
        Action action108_6 = new Action(1086,true,"Aller à l'étage", consequences_action108_6, 108);


        //Actions de la salle 202 - Bureau

        ArrayList<int[]> consequences_action202_1 = new ArrayList<>();
        consequences_action202_1.add(new int[]{1,205}); //Bouge joueur vers la note
        consequences_action202_1.add(new int[]{2,1085}); //Débloque la demande d'indice si elle a déjà été utilisée
        consequences_action202_1.add(new int[]{13,1085,4002}); //Change le texte de l'indice
        consequences_action202_1.add(new int[]{17,50}); //Bruit de page tournée
        Action action202_1 = new Action(2021,true,"Inspecter la note", consequences_action202_1, 202);

        ArrayList<int[]> consequences_action202_2 = new ArrayList<>();
        consequences_action202_2.add(new int[]{1,302}); //Bouge joueur vers le tiroir (énigme)
        consequences_action202_2.add(new int[]{10}); //Affiche boîte de dialogue
        Action action202_2 = new Action(2022,true,"Examiner le tiroir", consequences_action202_2, 202);

        ArrayList<int[]> consequences_action202_4 = new ArrayList<>();
        consequences_action202_4.add(new int[]{1,204}); //Bouge joueur vers le tiroir dévérouillé
        consequences_action202_4.add(new int[]{17,41}); //Bruit de tiroir qui s'ouvre
        Action action202_4 = new Action(2024,false,"Fouiller dans le tiroir", consequences_action202_4, 202);

        ArrayList<int[]> consequences_action202_3 = new ArrayList<>();
        consequences_action202_3.add(new int[]{1,303}); //Bouge joueur vers le PC vérouillé (énigme)
        consequences_action202_3.add(new int[]{10}); //Affiche boîte de dialogue
        Action action202_3 = new Action(2023,true,"Examiner le PC", consequences_action202_3, 202);

        ArrayList<int[]> consequences_action202_5 = new ArrayList<>();
        consequences_action202_5.add(new int[]{1,206}); //Bouge joueur vers le PC dévérouillé
        Action action202_5 = new Action(2025,false,"Examiner le contenu du PC", consequences_action202_5, 202);


        //Actions de la salle 203 - Tiroir post-énigme

        ArrayList<int[]> consequences_action203_1 = new ArrayList<>();
        consequences_action203_1.add(new int[]{4,4}); //Ajoute objet clef
        consequences_action203_1.add(new int[]{3,2041}); //Bloque action (récupérable qu'une fois)
        consequences_action203_1.add(new int[]{17,28}); //Bruit de prise d'objet
        consequences_action203_1.add(new int[]{16,203,2}); //Change image de cette salle
        consequences_action203_1.add(new int[]{16,204,2}); //Change image du tiroir accessible plus tard
        Action action203_1 = new Action(2031,true,"Récupérer la clef", consequences_action203_1, 203);


        //Actions de la salle 204 - Tiroir

        ArrayList<int[]> consequences_action204_1 = new ArrayList<>();
        consequences_action204_1.add(new int[]{4,4}); //Ajoute objet clef
        consequences_action204_1.add(new int[]{3,2041}); //Bloque action (récupérable qu'une fois)
        consequences_action204_1.add(new int[]{17,28}); //Bruit de prise d'objet
        consequences_action204_1.add(new int[]{16,204,2}); //Change image de cette salle
        Action action204_1 = new Action(2041,true,"Récupérer la clef", consequences_action204_1, 204);

        ArrayList<int[]> consequences_action204_2 = new ArrayList<>();
        consequences_action204_2.add(new int[]{7,2042}); //Rajoute du texte
        consequences_action204_2.add(new int[]{3,2042}); //Bloque action (faisable qu'une fois)
        consequences_action204_2.add(new int[]{17,37}); //Bruit de bois qui craque
        consequences_action204_2.add(new int[]{16,204,3}); //Change image de cette salle
        Action action204_2 = new Action(2042, "Casser le double fond [Compas]", consequences_action204_2, 204, 1);

        ArrayList<int[]> consequences_action204_3 = new ArrayList<>();
        consequences_action204_3.add(new int[]{7,2043}); //Rajoute du texte
        consequences_action204_3.add(new int[]{3,2043}); //Bloque action (faisable qu'une fois)
        consequences_action204_3.add(new int[]{17,3}); //Bruit opinel
        consequences_action204_3.add(new int[]{16,204,3}); //Change image de cette salle
        Action action204_3 = new Action(2043, "Enlever le double fond [Opinel]", consequences_action204_3, 204, 3);


        //Actions de la salle 205 - Note

        ArrayList<int[]> consequences_action205_1 = new ArrayList<>();
        consequences_action205_1.add(new int[]{7,2052}); //Ajoute du texte
        consequences_action205_1.add(new int[]{3,2051}); //Bloque l'action (faisable qu'une fois)
        Action action205_1 = new Action(2051,true,"Examiner ce qui est illisible [Loupe]", consequences_action205_1, 205);


        //Actions de la salle 207 - Étagère 1

        ArrayList<int[]> consequences_action207_1 = new ArrayList<>();
        consequences_action207_1.add(new int[]{1,212}); //Rajoute texte
        consequences_action207_1.add(new int[]{17,49}); //Bruit d'ouverture de livre
        Action action207_1 = new Action(2071,true,"Regarder le premier livre", consequences_action207_1, 207);

        ArrayList<int[]> consequences_action207_2 = new ArrayList<>();
        consequences_action207_2.add(new int[]{1,213}); //Rajoute texte
        consequences_action207_2.add(new int[]{17,50}); //Bruit de page tournée
        Action action207_2 = new Action(2072,true,"Regarder le second livre", consequences_action207_2, 207);

        ArrayList<int[]> consequences_action207_3 = new ArrayList<>();
        consequences_action207_3.add(new int[]{1,214}); //Rajoute texte
        consequences_action207_3.add(new int[]{17,49}); //Bruit d'ouverture de livre
        Action action207_3 = new Action(2073,true,"Regarder le troisième livre", consequences_action207_3, 207);

        //Actions de la salle 208 - Étagère 2 pré-utilisation clef

        ArrayList<int[]> consequences_action208_1 = new ArrayList<>();
        consequences_action208_1.add(new int[]{1,301}); //Rajoute texte
        consequences_action208_1.add(new int[]{2,1087}); //Dévérouille l'action l'accès à l'énigme de l'étagère
        consequences_action208_1.add(new int[]{3,1083}); //Vérouille l'accès à l'étagère pré-utilisation clef
        consequences_action208_1.add(new int[]{5,4}); // Supprimer la clef de l'inventaire après l'utilisation
        consequences_action208_1.add(new int[]{2,1085});
        consequences_action208_1.add(new int[]{13,1085,4004});
        consequences_action208_1.add(new int[]{10}); //Affiche boîte de dialogue
        consequences_action208_1.add(new int[]{17,45,47}); //Bruit de clef tournée dans une serrure suivi d'un bruit de méchanisme qui s'active
        Action action208_1 = new Action(2081, "Essayer la clef dans la serrure [Clef]", consequences_action208_1, 208, 4);


        //Actions de la salle 211 - Porte

        ArrayList<int[]> consequences_action211_1 = new ArrayList<>();
        consequences_action211_1.add(new int[]{7,2112}); //Rajoute texte
        consequences_action211_1.add(new int[]{3,2111}); //Bloque cette action (faisable qu'une fois)
        consequences_action211_1.add(new int[]{17,58}); //Bruit de fermeture de livre (jusqu'à ce qu'on trouve mieux)
        Action action211_1 = new Action(2111,true,"Essayer d'enfoncer la porte", consequences_action211_1, 211);

        ArrayList<int[]> consequences_action211_2 = new ArrayList<>();
        consequences_action211_2.add(new int[]{7,2113}); //Rajoute texte
        consequences_action211_2.add(new int[]{3,2112}); //Bloque cette action (faisable qu'une fois)
        consequences_action211_2.add(new int[]{17,45}); //Bruit d'une clef tournée dans une serrure
        Action action211_2 = new Action(2112, "Essayer la clef dans la serrure [Clef]", consequences_action211_2, 211, 4);


        //Actions de la salle 109 - Étage

        ArrayList<int[]> consequences_action109_1 = new ArrayList<>();
        consequences_action109_1.add(new int[]{1,210}); //Bouge le joueur vers RDC
        Action action109_1 = new Action(1091,true,"Regarder le plafond", consequences_action109_1, 109);

        ArrayList<int[]> consequences_action109_2 = new ArrayList<>();
        consequences_action109_2.add(new int[]{1,304}); //Bouge le joueur vers RDC
        Action action109_2 = new Action(1092,true,"S'approcher de l'étagère centrale", consequences_action109_2, 109);

        ArrayList<int[]> consequences_action109_3 = new ArrayList<>();
        consequences_action109_3.add(new int[]{1,108}); //Bouge le joueur vers RDC
        consequences_action109_3.add(new int[]{17,43}); //Bruit de pas
        Action action109_3 = new Action(1093,true,"Descendre au rez-de-chaussée", consequences_action109_3, 109);


        //Actions salle 110 - Salle derrière l'étagère

        ArrayList<int[]> consequences_action110_3 = new ArrayList<>();
        consequences_action110_3.add(new int[]{4,5}); //Rajoute le carnet à l'inventaire
        consequences_action110_3.add(new int[]{7,1102}); //Rajoute texte (tuto objet cliquable)
        consequences_action110_3.add(new int[]{3,1103}); //Bloque cette action (faisable qu'une fois)
        Action action110_3 = new Action(1103,true,"Récupérer le carnet à vos pieds", consequences_action110_3, 110);

        ArrayList<int[]> consequences_action110_1 = new ArrayList<>();
        consequences_action110_1.add(new int[]{1,305}); //Bouge le joueur vers RDC
        Action action110_1 = new Action(1101,true,"Analyser le mur face à vous", consequences_action110_1, 110);

        ArrayList<int[]> consequences_action110_2 = new ArrayList<>();
        consequences_action110_2.add(new int[]{15,2}); //Lance cinématique 2
        consequences_action110_2.add(new int[]{3,1101}); //Bloque action mur pour ne pas que le joueur puisse bouger pendant le lancement de la cinématique
        consequences_action110_2.add(new int[]{3,1102}); //Bloque cette action (faisable qu'une fois)
        consequences_action110_2.add(new int[]{3,1103}); //Bloque action récurérer le carnet au cas où le joueur réussi l'énigme sans le carnet (normalement impossible)
        consequences_action104_2.add(new int[]{18,43}); //Joue son bruit de pas
        Action action110_2 = new Action(1102,false,"Passer à travers l'ouverture [Fin de l'escape game, mode exploration]", consequences_action110_2, 110);


        ArrayList<int[]> consequences_action110_4 = new ArrayList<>();
        consequences_action110_4.add(new int[]{1,111}); //Bouge le joueur en salle 111 (début exploration)
        Action action110_4 = new Action(1104,false,"", consequences_action110_4, 110); //Sert pour cinématique 2

        /*-------------------------------------------Mode exploration-------------------------------------------*/

        Room room11 = new Room(111,113,-1,-1,112,true,1111,"pictures/exploration/enssat.png", "Exploration - Enssat");
        Room room12 = new Room(112,115,111,-1,-1,true,1121,"pictures/exploration/bord_eau.png", "Exploration - Bord de l'eau");
        Room room13 = new Room(113,-1,114,111,115,true,1131,"pictures/exploration/rue_enssat.png", "Exploration - Rue de l'ENSSAT");
        Room room14 = new Room(114,-1,-1,-1,113,true,1141,"pictures/exploration/gare.png", "Exploration - Gare");
        Room room15 = new Room(115,117,113,112,116,true,1151,"pictures/exploration/quai_aiguillon.png", "Exploration - Quai de l'aiguillon");
        Room room16 = new Room(116,118,115,-1,-1,true,1161,"pictures/exploration/marché.png", "Exploration - Marché");
        Room room17 = new Room(117,-1,-1,115,118,true,1171,"pictures/exploration/rue_capucins.png", "Exploration - Rue des Capucins");
        Room room18 = new Room(118,-1,117,116,-1,true,1181,"pictures/exploration/place_centre.png", "Exploration - Place Hôtel de Ville");


        //Toutes ces salles n'ont qu'une action qui est celle de quitter le mode exploration et d'afficher l'écran des scores

        ArrayList<int[]> consequences_exploration = new ArrayList<>();
        consequences_exploration.add(new int[]{20,56}); //Arrête le son d'ambiance extérieur
        consequences_exploration.add(new int[]{11}); //Affiche l'écran de fin de jeu

        Action action111_1 = new Action(1111,true,"Quitter le mode exploration [Écran de fin de jeu]", consequences_exploration, 111);
        Action action112_1 = new Action(1121,true,"Quitter le mode exploration [Écran de fin de jeu]", consequences_exploration, 112);
        Action action113_1 = new Action(1131,true,"Quitter le mode exploration [Écran de fin de jeu]", consequences_exploration, 113);
        Action action114_1 = new Action(1141,true,"Quitter le mode exploration [Écran de fin de jeu]", consequences_exploration, 114);
        Action action115_1 = new Action(1151,true,"Quitter le mode exploration [Écran de fin de jeu]", consequences_exploration, 115);
        Action action116_1 = new Action(1161,true,"Quitter le mode exploration [Écran de fin de jeu]", consequences_exploration, 116);
        Action action117_1 = new Action(1171,true,"Quitter le mode exploration [Écran de fin de jeu]", consequences_exploration, 117);
        Action action118_1 = new Action(1181,true,"Quitter le mode exploration [Écran de fin de jeu]", consequences_exploration, 118);




    }
}
