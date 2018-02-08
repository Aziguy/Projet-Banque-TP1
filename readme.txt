										////////////////////////////////////
									\\\\\  	Description de l'application:   \\\\\
										////////////////////////////////////

   ***** NB: Bien vouloir consulter le fichier TP1.pdf pour avoir une vue globale de l'application *****
---------------------------------------------------------------------------------------------------------------------------------

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	NB: Au lance de l'application, le programme vous demande de saisir votre login et un mot de passe 
	    Le login est "admin" Le mot de passe est "admin"
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
									************************************
								*****  	     Pré-requis avant execution		*****
									************************************

Pour exécuter l'application, nous aurons besoin que la machine de l'exécutant ait au moins la JRE ou la JDK (Java Runtime Edition) installer. Pour savoir si votre machine contient la JVM (Java Virtual Machine), ouvrir "l'invite de commande windows (CMD)" et saisir: java -version puis entrer... Si une erreur s'affiche, bien vouloir suivre les étapes suivantes pour télécharger et installer la JDK.

	- Rendez-vous sur le site d’Oracle : http://www.oracle.com/technetwork/java
	- Dans la zone de droite ’software downloads’, cliquez sur le lien ’Java SE’ (pour Java Standard Edition)
	- Cliquez sur l’icône ’Java’ pour télécharger le JDK
	- Accepter la licence
	- De préférence choisir la version la plus récente (dernière sur la liste)
		-si votre machine est une 64 bit, choisir le jdk dont le nom a 'windows-X64' avant le '.exe'
		-si votre machine est une 32 bit, choisir le jdk dont le nom a 'windows-i586' avant le '.exe'
	- Cliquez sur le bouton ’Enregistrer le fichier’. Le téléchargement commence
	- Le fichier téléchargé doit se trouver dans le répertoire "téléchargements" de votre ordinateur
	- Double cliquez sur le fichier téléchargé. L’assistant d’installation du JDK se lance
	- Cliquez sur le bouton 'Next' des fenêtre qui vont s'afficher
	- Au moment d’installer un environnement d’exécution indépendant du JDK, l’assistant vous consulte. Acceptez les options par défaut et cliquez sur 'Next'
	- Ainsi même si vous supprimez par la suite le répertoire d’installation du JDK (qui contient aussi une JRE), vous pourrez tout de même exécuter des programmes Java sur votre ordinateur
	- Vous arrivez à l’écran de fin d’installation, qui vous précise que l’installation s’est bien déroulée 
	-Cliquez sur Close: L’installation du JDK est terminée. 

Télécharger et installer une base de données Mysql
Démarre les services de mysql et lancer phpMyAdmin.
Pour lancer phpMyAdmin vous pouvez aussi saisir directe sur votre navigateur l'url suivant: http://127.0.0.1/phpmyadmin/
	Dans Mysql, créer la base données "promo22bank" et importer le fichier "promo22bank.sql" en suivant les inctructions suivantes:
	-sur l'onglet "Base de Données" dans le champ "Créer une base de données" saisir "promo22bank" 
	 puis cliquer sur créer (Bravo! vous avez créer la base données "promo22bank")
	-sur l'onglet "importer", cliquer "choisir un fichier" puis placer vous dans le dossier 'projet banque'
	 et choisir le fichier 'promo22bank.sql' puis cliquer sur le bouton "Exécuter" en bas de page.

Dans le dossier 'projet banque' copier les jar "mysql-connector-java-5.1.28-bin" et "jcalendar-1.4"
puis collez les dans le dossier lib/ext présent dans le dossier d'installation du JRE.

										************************************
									*****  		Version du jdk utilié		  	*****
										************************************

java version "1.8.0_131"
Java(TM) SE Runtime Environment (build 1.8.0_131-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.131-b11, mixed mode)

Pour avoir ces informations, dans "l'invite de commandes" saisir: 'java -version' puis appuyez sur la touche "Enter" du clavier.



										************************************
									*****  	Documentation de l'application	  *****
										************************************

Pour consulter la documentation de l'application, veuillez suivre les indications suivantes:

1) Rendez vous dans le dossier 'projet banque\JavaDoc'.

2) Double cliquez sur 'index.html'.

	
										************************************
									***** 	Execution de l'application      *****
										************************************

Veuillez suivre les indications suivantes:
	
1) 	A l'aide l'invite de commandes (cmd.exe) de Windows, placer vous dans le dossier où vous avez téléchargé le fichier compressé "Promo22Bank.jar"

2)  Cliquez sur 'Fichier' puis sélectionner 'Ouvrir l'invite de commande' puis cliquez sur 'Ouvrir l'invite de commande'

3)	Entrer la commande "java -jar Promo22Bank.jar".