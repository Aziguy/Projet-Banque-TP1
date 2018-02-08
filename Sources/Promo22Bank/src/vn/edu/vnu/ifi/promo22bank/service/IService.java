package vn.edu.vnu.ifi.promo22bank.service;

import java.util.List;

import vn.edu.vnu.ifi.promo22bank.domaine.Comptes;
import vn.edu.vnu.ifi.promo22bank.domaine.TypeComptes;
import vn.edu.vnu.ifi.promo22bank.domaine.Clients;
import vn.edu.vnu.ifi.promo22bank.domaine.Gestionnaires;
import vn.edu.vnu.ifi.promo22bank.domaine.Transactions;

/**
 * Interface: contient uniquement des déclarations de methode à  implémenter
 * dans la classe Services
 * 
 * @author KENGNI Hippolyte
 * @version 0.1 Promo22Bank
 */
public interface IService {

	public int connexionService(String login, String pwd);

	public String afficherMessageService(String recLogin);

	/**
	 * Signature des différentes méthodes manipulées par la class Clients
	 */

	public List<Clients> getAllClientsService();

	public int enregistrerClientsService(Clients client);

	public int modifierClientsService(Clients client);

	public int supprimerClientsService(Clients client);

	public List<Clients> rechercherClientsService(String search);

	/**
	 * Signature des différentes méthodes manipulées par la class Gestionnaires
	 */

	public List<Gestionnaires> getAllGestionnairesService();

	/**
	 * Signature des différentes méthodes manipulées par la classe Transactions
	 */

	public List<TypeComptes> getAllTypeComptesService();

	public List<Transactions> getAllTransactionsService();

	public int enregistrerTransactionsService(Transactions transaction);

	public int faireDebitTransactionsService(float montantCredit, int numCompte);

	public int faireCreditTransactionsService(float montantCredit, int numCompte);

	public List<Comptes> getAllComptesSeuilService();

	public List<Transactions> rechercherTransactionsService(String search);

	/**
	 * Signature des différentes méthodes manipulées par la classe Comptes
	 */

	public int genererNumeroCompte();

	public int genererIdentCompte();

	public List<Comptes> getAllComptesService();

	public float getSoldeComptesService(int compte);

	public int enregistrerComptesService(Comptes compte);

	public int modifierComptesServices(Comptes compte);

	public int supprimerComptesService(Comptes compte);

	public List<Comptes> rechercherComptesService(String search);
	
	public int calculInteretComptesService(int numCompte, float interet);

}
