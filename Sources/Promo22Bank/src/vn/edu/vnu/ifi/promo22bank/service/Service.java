package vn.edu.vnu.ifi.promo22bank.service;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import vn.edu.vnu.ifi.promo22bank.domaine.Comptes;
import vn.edu.vnu.ifi.promo22bank.domaine.Transactions;
import vn.edu.vnu.ifi.promo22bank.domaine.TypeComptes;
import vn.edu.vnu.ifi.promo22bank.domaine.Clients;
import vn.edu.vnu.ifi.promo22bank.domaine.Gestionnaires;
import vn.edu.vnu.ifi.promo22bank.dao.IDao;

/**
 * Cette Class contient toutes les m�thodes dont fera appel l'utilisateur
 * 
 * @author KENGNI Hippolyte
 * @version 0.1 Promo22Bank
 */
/**
 * @author KENGNI Hippolyte
 *
 */
public class Service implements IService {

	private IDao dao;

	/**
	 * Constructeur par d�faut de la classe Service
	 */
	public Service() {

	}

	public Service(IDao dao) {
		super();
		this.dao = dao;
	}

	/**
	 * Cette m�thode permet de se connecter � la base de donn�es via la couche dao
	 * 
	 * @param login
	 * @param pwd
	 * @return 1 si la connexion est ok et 0 sinon
	 */
	public int connexionService(String login, String pwd) {
		return dao.connexionInterfaceDao(login, pwd);
	}

	/**
	 * Cette m�thode permet d'afficher le nom de l'utilisateur connect� via la
	 * couche dao
	 * 
	 * @param login
	 * @param pwd
	 * @return le nom et le pr�nom de l'utilisateur
	 */
	public String afficherMessageService(String recLogin) {
		return dao.afficheMessageDao(recLogin);
	}

	/**
	 * Cette m�thode permet d'afficher la liste des clients de la base de donn�es
	 * 
	 * @return une liste de clients
	 */
	public List<Clients> getAllClientsService() {
		return dao.getAllDaoClients();
	}

	/**
	 * Cette m�thode permet d'enregistrer un client dans la BD
	 * 
	 * @param client
	 * @return 1 si l'enregistrement est ok et 0 si echec lors de l'enregistrement
	 */
	public int enregistrerClientsService(Clients client) {
		return dao.enregistrerDaoClients(client);
	}

	/**
	 * Cette m�thode permet de modifier un client s�lectionn� en BD
	 * 
	 * @param client
	 */
	public int modifierClientsService(Clients client) {
		return dao.modifierDaoClients(client);
	}

	/**
	 * Cette m�thode permet de rechercher un client en BD
	 * 
	 * @param search
	 * @return une liste de client
	 */
	public List<Clients> rechercherClientsService(String search) {
		return dao.rechercherDaoClients(search);
	}

	/**
	 * Cette m�thode permet de supprimer un client s�lectionn� en BD
	 * 
	 * @param client
	 */
	public int supprimerClientsService(Clients client) {
		return dao.supprimerDaoClients(client);
	}

	/**
	 * METHODES LIEES AUX GESTIONAIRES
	 */

	/**
	 * Cette m�thode permet de r�cup�rer la liste des Gestionnaires en BD
	 */
	public List<Gestionnaires> getAllGestionnairesService() {
		return dao.getAllGestionnairesDao();
	}

	/**
	 * ICI LES METHODES LIEES AUX COMPTES
	 */

	/**
	 * M�thode qui permet de g�n�rer un ensemble de 05 chiffres pour le num�ro de
	 * compte d'un client
	 * 
	 * @return numero les chiffres g�n�r�s
	 */
	public int genererNumeroCompte() {
		int valeurGeneree = 0;
		String CARACTERES = "1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 5) { // taille de la valeur � retourner
			int index = (int) (rnd.nextFloat() * CARACTERES.length());
			salt.append(CARACTERES.charAt(index));
		}
		String saltStr = salt.toString();
		try {
			valeurGeneree = Integer.parseInt(saltStr);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, saltStr + " n'est pas un int", "Attention!",
					JOptionPane.WARNING_MESSAGE);
		}
		return valeurGeneree;

	}

	/**
	 * M�thode qui permet de g�n�rer un ensemble de 05 chiffres pour le num�ro de
	 * compte d'un client
	 * 
	 * @return numero les chiffres g�n�r�s
	 */
	public int genererIdentCompte() {
		int valeurIdent = 0;
		String CARACTERES = "1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 5) { // taille de la valeur � retourner
			int index = (int) (rnd.nextFloat() * CARACTERES.length());
			salt.append(CARACTERES.charAt(index));
		}
		String saltStr = salt.toString();

		try {
			valeurIdent = Integer.parseInt(saltStr);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, saltStr + " n'est pas un int", "Attention!",
					JOptionPane.WARNING_MESSAGE);
		}

		return valeurIdent;

	}

	/**
	 * Cette m�thode permet d'afficher la liste des type de comptes en BD
	 * 
	 * @return une liste de type de compte
	 */
	public List<TypeComptes> getAllTypeComptesService() {
		return dao.getAllDaoTypeComptes();
	}

	/**
	 * Cette m�thode permet d'afficher la liste des comptes en BD
	 * 
	 * @return une liste de compte
	 */
	public List<Comptes> getAllComptesService() {
		return dao.getAllDaoComptes();
	}

	/**
	 * Cette m�thode permet d'enregistrer un compte en BD
	 * 
	 * @param compte
	 * @return 1 si l'enregistre est un succ�s 0 si �chec
	 */
	public int enregistrerComptesService(Comptes compte) {
		return dao.enregistrerDaoComptes(compte);
	}

	/**
	 * Cette m�thode permet de modifier un compte en BD
	 * 
	 * @param compte
	 * @return 1 si modification succ�s 0 si �chec
	 */
	public int modifierComptesServices(Comptes compte) {
		return dao.modifierDaoCompte(compte);
	}

	/**
	 * Cette m�thode permet de supprimer le compte d'un client
	 * 
	 * @param compte
	 * @return 0 si �chec lors de la suppression 1 si succ�s
	 */
	public int supprimerComptesService(Comptes compte) {
		return dao.supprimerDaoCompte(compte);
	}

	/**
	 * Cette m�thode permet de rechercher un compte en BD
	 * 
	 * @param search
	 * @return une liste de compte
	 */
	public List<Comptes> rechercherComptesService(String search) {
		return dao.rechercherDaoComptes(search);
	}
	
	/**
	 * Cette m�thode permet de calculer et mettre � jour le solde de tous les comptes enn BD
	 * @see vn.edu.vnu.ifi.promo22bank.service.IService#calculInteretComptesService(int, float)
	 */
	public int calculInteretComptesService(int numCompte, float interet) {
		return dao.calculInteretDaoComptes(numCompte, interet);
	}

	/**
	 * ICI LES METHODES LIEES AUX TRANSACTIONS
	 */

	/**
	 * Cette m�thode permet d'afficher la liste des comptes en seuil en BD
	 * 
	 * @return une liste de compte seuil
	 */
	public List<Comptes> getAllComptesSeuilService() {
		return dao.getAllDaoComptesSeuil();
	}

	/**
	 * Cette m�thode permet de r�cup�rer le solde d'un compte en BD
	 * 
	 * @return le solde du compte donn� en param�tre.
	 */
	public float getSoldeComptesService(int compte) {
		return dao.afficherSoldeDao(compte);
	}

	/**
	 * Cette m�thode permet d'afficher la liste des transactions
	 * 
	 * @return une liste de transactions
	 */
	public List<Transactions> getAllTransactionsService() {
		return dao.getAllDaoTransactions();
	}

	/**
	 * Cette m�thode permet d'enregistrer une transaction en BD
	 * 
	 * @param transaction
	 * @return 1 si l'enregistre est un succ�s 0 si �chec
	 */
	public int enregistrerTransactionsService(Transactions transaction) {
		return dao.enregistrerDaoTransactions(transaction);
	}

	/**
	 * Cette m�thode permet de faire le d�bit du solde d'un compte dans la BD
	 * 
	 * @param transaction
	 * @return 1 si la mise � jour est un succ�s 0 si �chec
	 */
	public int faireCreditTransactionsService(float montantCredit, int numCompte) {
		return dao.faireCreditDaoTransactions(montantCredit, numCompte);
	}

	/**
	 * Cette m�thode permet de faire le d�bit du solde d'un compte dans la BD
	 * 
	 * @param transaction
	 * @return 1 si la mise � jour est un succ�s 0 si �chec
	 */
	public int faireDebitTransactionsService(float montantCredit, int numCompte) {
		return dao.faireDebitDaoTransactions(montantCredit, numCompte);
	}

	/**
	 * Cette m�thode permet de rechercher un compte seuil en BD
	 * 
	 * @param search
	 * @return une liste de compte seuil
	 */
	public List<Transactions> rechercherTransactionsService(String search) {
		return dao.rechercherDaoTransactions(search);
	}

}