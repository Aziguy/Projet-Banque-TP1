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
 * Cette Class contient toutes les méthodes dont fera appel l'utilisateur
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
	 * Constructeur par défaut de la classe Service
	 */
	public Service() {

	}

	public Service(IDao dao) {
		super();
		this.dao = dao;
	}

	/**
	 * Cette méthode permet de se connecter à la base de données via la couche dao
	 * 
	 * @param login
	 * @param pwd
	 * @return 1 si la connexion est ok et 0 sinon
	 */
	public int connexionService(String login, String pwd) {
		return dao.connexionInterfaceDao(login, pwd);
	}

	/**
	 * Cette méthode permet d'afficher le nom de l'utilisateur connecté via la
	 * couche dao
	 * 
	 * @param login
	 * @param pwd
	 * @return le nom et le prénom de l'utilisateur
	 */
	public String afficherMessageService(String recLogin) {
		return dao.afficheMessageDao(recLogin);
	}

	/**
	 * Cette méthode permet d'afficher la liste des clients de la base de données
	 * 
	 * @return une liste de clients
	 */
	public List<Clients> getAllClientsService() {
		return dao.getAllDaoClients();
	}

	/**
	 * Cette méthode permet d'enregistrer un client dans la BD
	 * 
	 * @param client
	 * @return 1 si l'enregistrement est ok et 0 si echec lors de l'enregistrement
	 */
	public int enregistrerClientsService(Clients client) {
		return dao.enregistrerDaoClients(client);
	}

	/**
	 * Cette méthode permet de modifier un client sélectionné en BD
	 * 
	 * @param client
	 */
	public int modifierClientsService(Clients client) {
		return dao.modifierDaoClients(client);
	}

	/**
	 * Cette méthode permet de rechercher un client en BD
	 * 
	 * @param search
	 * @return une liste de client
	 */
	public List<Clients> rechercherClientsService(String search) {
		return dao.rechercherDaoClients(search);
	}

	/**
	 * Cette méthode permet de supprimer un client sélectionné en BD
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
	 * Cette méthode permet de récupérer la liste des Gestionnaires en BD
	 */
	public List<Gestionnaires> getAllGestionnairesService() {
		return dao.getAllGestionnairesDao();
	}

	/**
	 * ICI LES METHODES LIEES AUX COMPTES
	 */

	/**
	 * Méthode qui permet de générer un ensemble de 05 chiffres pour le numéro de
	 * compte d'un client
	 * 
	 * @return numero les chiffres générés
	 */
	public int genererNumeroCompte() {
		int valeurGeneree = 0;
		String CARACTERES = "1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 5) { // taille de la valeur à retourner
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
	 * Méthode qui permet de générer un ensemble de 05 chiffres pour le numéro de
	 * compte d'un client
	 * 
	 * @return numero les chiffres générés
	 */
	public int genererIdentCompte() {
		int valeurIdent = 0;
		String CARACTERES = "1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 5) { // taille de la valeur à retourner
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
	 * Cette méthode permet d'afficher la liste des type de comptes en BD
	 * 
	 * @return une liste de type de compte
	 */
	public List<TypeComptes> getAllTypeComptesService() {
		return dao.getAllDaoTypeComptes();
	}

	/**
	 * Cette méthode permet d'afficher la liste des comptes en BD
	 * 
	 * @return une liste de compte
	 */
	public List<Comptes> getAllComptesService() {
		return dao.getAllDaoComptes();
	}

	/**
	 * Cette méthode permet d'enregistrer un compte en BD
	 * 
	 * @param compte
	 * @return 1 si l'enregistre est un succès 0 si échec
	 */
	public int enregistrerComptesService(Comptes compte) {
		return dao.enregistrerDaoComptes(compte);
	}

	/**
	 * Cette méthode permet de modifier un compte en BD
	 * 
	 * @param compte
	 * @return 1 si modification succès 0 si échec
	 */
	public int modifierComptesServices(Comptes compte) {
		return dao.modifierDaoCompte(compte);
	}

	/**
	 * Cette méthode permet de supprimer le compte d'un client
	 * 
	 * @param compte
	 * @return 0 si échec lors de la suppression 1 si succès
	 */
	public int supprimerComptesService(Comptes compte) {
		return dao.supprimerDaoCompte(compte);
	}

	/**
	 * Cette méthode permet de rechercher un compte en BD
	 * 
	 * @param search
	 * @return une liste de compte
	 */
	public List<Comptes> rechercherComptesService(String search) {
		return dao.rechercherDaoComptes(search);
	}
	
	/**
	 * Cette méthode permet de calculer et mettre à jour le solde de tous les comptes enn BD
	 * @see vn.edu.vnu.ifi.promo22bank.service.IService#calculInteretComptesService(int, float)
	 */
	public int calculInteretComptesService(int numCompte, float interet) {
		return dao.calculInteretDaoComptes(numCompte, interet);
	}

	/**
	 * ICI LES METHODES LIEES AUX TRANSACTIONS
	 */

	/**
	 * Cette méthode permet d'afficher la liste des comptes en seuil en BD
	 * 
	 * @return une liste de compte seuil
	 */
	public List<Comptes> getAllComptesSeuilService() {
		return dao.getAllDaoComptesSeuil();
	}

	/**
	 * Cette méthode permet de récupérer le solde d'un compte en BD
	 * 
	 * @return le solde du compte donné en paramètre.
	 */
	public float getSoldeComptesService(int compte) {
		return dao.afficherSoldeDao(compte);
	}

	/**
	 * Cette méthode permet d'afficher la liste des transactions
	 * 
	 * @return une liste de transactions
	 */
	public List<Transactions> getAllTransactionsService() {
		return dao.getAllDaoTransactions();
	}

	/**
	 * Cette méthode permet d'enregistrer une transaction en BD
	 * 
	 * @param transaction
	 * @return 1 si l'enregistre est un succès 0 si échec
	 */
	public int enregistrerTransactionsService(Transactions transaction) {
		return dao.enregistrerDaoTransactions(transaction);
	}

	/**
	 * Cette méthode permet de faire le débit du solde d'un compte dans la BD
	 * 
	 * @param transaction
	 * @return 1 si la mise à jour est un succès 0 si échec
	 */
	public int faireCreditTransactionsService(float montantCredit, int numCompte) {
		return dao.faireCreditDaoTransactions(montantCredit, numCompte);
	}

	/**
	 * Cette méthode permet de faire le débit du solde d'un compte dans la BD
	 * 
	 * @param transaction
	 * @return 1 si la mise à jour est un succès 0 si échec
	 */
	public int faireDebitTransactionsService(float montantCredit, int numCompte) {
		return dao.faireDebitDaoTransactions(montantCredit, numCompte);
	}

	/**
	 * Cette méthode permet de rechercher un compte seuil en BD
	 * 
	 * @param search
	 * @return une liste de compte seuil
	 */
	public List<Transactions> rechercherTransactionsService(String search) {
		return dao.rechercherDaoTransactions(search);
	}

}