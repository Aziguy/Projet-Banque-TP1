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
								*****  	     Pr�-requis avant execution		*****
									************************************

Pour ex�cuter l'application, nous aurons besoin que la machine de l'ex�cutant ait au moins la JRE ou la JDK (Java Runtime Edition) installer. Pour savoir si votre machine contient la JVM (Java Virtual Machine), ouvrir "l'invite de commande windows (CMD)" et saisir: java -version puis entrer... Si une erreur s'affiche, bien vouloir suivre les �tapes suivantes pour t�l�charger et installer la JDK.

	- Rendez-vous sur le site d�Oracle : http://www.oracle.com/technetwork/java
	- Dans la zone de droite �software downloads�, cliquez sur le lien �Java SE� (pour Java Standard Edition)
	- Cliquez sur l�ic�ne �Java� pour t�l�charger le JDK
	- Accepter la licence
	- De pr�f�rence choisir la version la plus r�cente (derni�re sur la liste)
		-si votre machine est une 64 bit, choisir le jdk dont le nom a 'windows-X64' avant le '.exe'
		-si votre machine est une 32 bit, choisir le jdk dont le nom a 'windows-i586' avant le '.exe'
	- Cliquez sur le bouton �Enregistrer le fichier�. Le t�l�chargement commence
	- Le fichier t�l�charg� doit se trouver dans le r�pertoire "t�l�chargements" de votre ordinateur
	- Double cliquez sur le fichier t�l�charg�. L�assistant d�installation du JDK se lance
	- Cliquez sur le bouton 'Next' des fen�tre qui vont s'afficher
	- Au moment d�installer un environnement d�ex�cution ind�pendant du JDK, l�assistant vous consulte. Acceptez les options par d�faut et cliquez sur 'Next'
	- Ainsi m�me si vous supprimez par la suite le r�pertoire d�installation du JDK (qui contient aussi une JRE), vous pourrez tout de m�me ex�cuter des programmes Java sur votre ordinateur
	- Vous arrivez � l��cran de fin d�installation, qui vous pr�cise que l�installation s�est bien d�roul�e 
	-Cliquez sur Close: L�installation du JDK est termin�e. 

T�l�charger et installer une base de donn�es Mysql
D�marre les services de mysql et lancer phpMyAdmin.
Pour lancer phpMyAdmin vous pouvez aussi saisir directe sur votre navigateur l'url suivant: http://127.0.0.1/phpmyadmin/
	Dans Mysql, cr�er la base donn�es "promo22bank" et importer le fichier "promo22bank.sql" en suivant les inctructions suivantes:
	-sur l'onglet "Base de Donn�es" dans le champ "Cr�er une base de donn�es" saisir "promo22bank" 
	 puis cliquer sur cr�er (Bravo! vous avez cr�er la base donn�es "promo22bank")
	-sur l'onglet "importer", cliquer "choisir un fichier" puis placer vous dans le dossier 'projet banque'
	 et choisir le fichier 'promo22bank.sql' puis cliquer sur le bouton "Ex�cuter" en bas de page.

Dans le dossier 'projet banque' copier les jar "mysql-connector-java-5.1.28-bin" et "jcalendar-1.4"
puis collez les dans le dossier lib/ext pr�sent dans le dossier d'installation du JRE.

										************************************
									*****  		Version du jdk utili�		  	*****
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
	
1) 	A l'aide l'invite de commandes (cmd.exe) de Windows, placer vous dans le dossier o� vous avez t�l�charg� le fichier compress� "Promo22Bank.jar"

2)  Cliquez sur 'Fichier' puis s�lectionner 'Ouvrir l'invite de commande' puis cliquez sur 'Ouvrir l'invite de commande'

3)	Entrer la commande "java -jar Promo22Bank.jar".