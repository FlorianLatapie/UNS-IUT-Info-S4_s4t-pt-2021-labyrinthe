# S4T-G2
Projet Tutoré 2021 en S4T Groupe 2 

**Membres de l'équipe :** 
- Latapie Florian **Chef d'équipe** (@lf9034541)
- Blondin Remy (@br9045461)
- Maxime Lecerf (@lm9026181)
- Jehan Berthé (@bj9064481)
- Pierre Bihannic (@bp9004181 )
- Zinedine Chelgam (@cz9021901) 

Instructions de mise en œuvre
Aujourd’hui le projet n’est pas complet, mais voici les instructions de
mise en œuvre de notre solution actuelle :
Récupérez le dossier compressé, dézippez-le, stockez-le sur la machine
Windows, et copiez le dossier « Raspberry Pi » dans ladite machine.
1. Sur l’ordinateur de contrôle (Windows)
Prérequis :
- Logiciel : Windows, Java
- Matériel : carte réseau Wi-Fi, écran d’une définition de 1920x1080
pixels
Mise en œuvre :
1. Connectez vous sur le même réseau local que le Raspberry Pi et la
brique LEGO
2. Entrez dans le dossier « Windows » et double cliquez sur le fichier
IHM.jar
 Résultat : Cela affiche l’IHM (qui n’est pas encore dynamique)
Projet Labyrinthe 12 Mars 2021
Université Côte d’Azur 7/10
2. Sur la brique LEGO
Prérequis :
- Logiciel : Windows, java, installeur LeJOS, lecteur de carte micro
SD, carte micro-SD
- Matériel : Ordinateur Windows (avec Wi-Fi), notre robot LEGO
(contenant « 2 Grand servomoteur EV3 » et « Brique EV3
intelligente »), module Wi-Fi USB « Wi-Pi »

Préparation à la mise en œuvre (inspiré de la vidéo officielle :
LeJOS EV3 Installer) :
1. Installez le logiciel LeJOS sur votre ordinateur
1.1. Téléchargez-le sur le site suivant : leJOS EV3
1.2. Téléchargez le logiciel « leJOS_EV3_0.9.1-
beta_win32_setup.exe »
1.3. Lancez-le et choisissez une installation complète
2. Une fois l’installation du logiciel terminé un outil de création de
carte SD s’ouvre
2.1. Entrez une carte SD, cliquez sur « Reload », puis installez
LeJOS sur la carte SD
3. Insérez la carte SD dans le robot puis lancez le (maintenez 3
secondes le bouton central), au bout de 10 minutes LeJOS sera
installé
Mise en œuvre :
1. Connectez la brique EV3 au réseau Wi-Fi
1.1. Éteignez la brique (appuyez sur le bouton retour en haut a
gauche), insérez le module Wi-Fi USB
1.2. Allumez la brique (attendez environ 2 minutes)
1.3. Une fois la brique démarrée allez dans la partie « Wifi »
1.4. Choisissez de vous connecter à votre réseau
1.5. Une fois connecté, la brique revient sur l’écran principal et
affiche son adresse IP en dessous de « 10.0.1.1 »
➔ Si l’adresse IP est bien affichée, vous êtes prêt à transvaser le Jar
exécutable du projet, sinon recommencez l’étape 1 
Projet Labyrinthe 12 Mars 2021
Université Côte d’Azur 8/10
2. Sur votre ordinateur Windows lancez le programme EV3
Control Center
2.1. Connectez l’ordinateur et la brique EV3 au même réseau WiFi
2.2. Menu démarrer > Toutes les applications > leJOS EV3 >
« EV3 Control »
2.3. Dans EV3 Control lancez une recherche de brique avec
« Search »
2.4. Une fois la brique affichez cliquez sur « Connect »
➔ Les fichiers de la brique doivent etre affichés
3. Transvasez les Jars sur la brique EV3
3.1. Dans l’onglet « Programs », cliquez sur « Upload file »
3.2. Choisissez les jars « LegoMain.jar » et « Server.jar »
➔ Sur la brique « Programs » contient les jars que vous venez d’installer
4. Lancez le programme sur la brique EV3
4.1. Sur la brique allez dans « Programs » sélectionnez
« LegoMain.java »
➔ « Labyrinthe » et « Server lance » doivent être affichés
 Résultat : une fois le serveur lancé, vous pouvez lancer le
programme sur le Raspberry Pi afin de contrôler le robot
manuellement (le contrôle automatique du robot sera disponible à
la prochaine étape).

3. Sur le Raspberry Pi
Prérequis :
- Logiciel : Java installé
- Matériel : écran, clavier, module GrovePi
Projet Labyrinthe 12 Mars 2021
Université Côte d’Azur 9/10
Mise en œuvre :
1. Connectez-vous sur le même réseau local que l’ordinateur sous
Windows et la brique LEGO
2. Entrez dans le dossier « Raspberry Pi » et lancez le fichier
« RaspberryPi.sh »
À l’aide d’un terminal :
$ chmod u+x RaspberryPi.sh Client.java
$ ./RaspberryPi.sh
 Résultat : Cela affiche « client lancé sur IP X.X.X.X » puis, une fois
connecté au serveur de la brique « client connecté », vous pouvez à
présent donner des ordres à la brique LEGO, qui exécutera les
ordres 
