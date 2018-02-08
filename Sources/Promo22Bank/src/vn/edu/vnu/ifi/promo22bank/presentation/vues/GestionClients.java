package vn.edu.vnu.ifi.promo22bank.presentation.vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import vn.edu.vnu.ifi.promo22bank.dao.Dao;
import vn.edu.vnu.ifi.promo22bank.dao.IDao;
import vn.edu.vnu.ifi.promo22bank.domaine.Clients;
import vn.edu.vnu.ifi.promo22bank.domaine.ClientsModel;
import vn.edu.vnu.ifi.promo22bank.domaine.Gestionnaires;
import vn.edu.vnu.ifi.promo22bank.service.IService;
import vn.edu.vnu.ifi.promo22bank.service.Service;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GestionClients extends JInternalFrame {

	private IService service;
	private IDao dao;
	private JTable jTableClients;
	private JPanel panel;
	private int row;
	private Clients clientSelect = null;
	private String recher;
	private JComboBox selectGest;
	private JTextField textRechercher;
	private JTextField textFieldNoms;
	private JTextField textFieldPrenoms;
	private JTextField textFieldDate;
	private JTextField textFieldAdresse;
	private JTextField textFieldCodePos;
	private JTextField textFieldVille;
	private JTextField textFieldTel;
	private JTextField textFieldProf;
	private JLabel labelNoms;
	private JLabel labelPrenoms;
	private JLabel labelDateNaissance;
	private JLabel labelTelephone;
	private JLabel labelAdresse;
	private JLabel labelGestionnaire;
	private JLabel labelVille;
	private JLabel labelCodePostal;
	private JLabel labelProfession;
	private JLabel labelIdClient;
	private List<Gestionnaires> maListeGestionnaires;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionClients frame = new GestionClients();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GestionClients() {

		// Initialisation des variables serviceClients et daoClients
		dao = new Dao();
		service = new Service(dao);

		setBounds(100, 100, 931, 505);
		setBorder(null);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setFont(new Font("Roboto Medium", Font.BOLD, 12));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Liste des clients Promo22Bank",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 452, 292);
		getContentPane().add(panel);

		labelNoms = new JLabel("");
		labelNoms.setForeground(Color.WHITE);
		labelNoms.setFont(new Font("Roboto Medium", Font.BOLD | Font.ITALIC, 12));
		labelNoms.setBounds(596, 26, 263, 21);
		getContentPane().add(labelNoms);

		JLabel lblNoms = new JLabel("Noms : ");
		lblNoms.setForeground(Color.WHITE);
		lblNoms.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNoms.setBounds(481, 26, 105, 21);
		getContentPane().add(lblNoms);

		JLabel lblPrnoms = new JLabel("Pr\u00E9noms : ");
		lblPrnoms.setForeground(Color.WHITE);
		lblPrnoms.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblPrnoms.setBounds(481, 58, 105, 21);
		getContentPane().add(lblPrnoms);

		labelPrenoms = new JLabel("");
		labelPrenoms.setForeground(Color.WHITE);
		labelPrenoms.setFont(new Font("Roboto Medium", Font.BOLD | Font.ITALIC, 12));
		labelPrenoms.setBounds(596, 58, 263, 21);
		getContentPane().add(labelPrenoms);

		JLabel lblDateNaissance = new JLabel("Date Naissance : ");
		lblDateNaissance.setForeground(Color.WHITE);
		lblDateNaissance.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblDateNaissance.setBounds(481, 90, 115, 21);
		getContentPane().add(lblDateNaissance);

		labelDateNaissance = new JLabel("");
		labelDateNaissance.setForeground(Color.WHITE);
		labelDateNaissance.setFont(new Font("Roboto Medium", Font.BOLD | Font.ITALIC, 12));
		labelDateNaissance.setBounds(596, 90, 263, 21);
		getContentPane().add(labelDateNaissance);

		JLabel lblTelephone = new JLabel("T\u00E9l\u00E9phone : ");
		lblTelephone.setForeground(Color.WHITE);
		lblTelephone.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblTelephone.setBounds(481, 122, 105, 21);
		getContentPane().add(lblTelephone);

		JLabel lblAdresse = new JLabel("Adresse : ");
		lblAdresse.setForeground(Color.WHITE);
		lblAdresse.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblAdresse.setBounds(481, 154, 105, 21);
		getContentPane().add(lblAdresse);

		labelAdresse = new JLabel("");
		labelAdresse.setForeground(Color.WHITE);
		labelAdresse.setFont(new Font("Roboto Medium", Font.BOLD | Font.ITALIC, 12));
		labelAdresse.setBounds(596, 154, 263, 21);
		getContentPane().add(labelAdresse);

		JLabel lblGestionnaire = new JLabel("Gestionnaire : ");
		lblGestionnaire.setForeground(Color.WHITE);
		lblGestionnaire.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblGestionnaire.setBounds(481, 186, 105, 21);
		getContentPane().add(lblGestionnaire);

		labelGestionnaire = new JLabel("");
		labelGestionnaire.setForeground(Color.WHITE);
		labelGestionnaire.setFont(new Font("Roboto Medium", Font.BOLD | Font.ITALIC, 12));
		labelGestionnaire.setBounds(596, 186, 263, 21);
		getContentPane().add(labelGestionnaire);

		labelTelephone = new JLabel("");
		labelTelephone.setForeground(Color.WHITE);
		labelTelephone.setFont(new Font("Roboto Medium", Font.BOLD | Font.ITALIC, 12));
		labelTelephone.setBounds(596, 122, 263, 21);
		getContentPane().add(labelTelephone);

		JLabel lblVille_2 = new JLabel("Ville : ");
		lblVille_2.setForeground(Color.WHITE);
		lblVille_2.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblVille_2.setBounds(481, 218, 105, 21);
		getContentPane().add(lblVille_2);

		labelVille = new JLabel("");
		labelVille.setForeground(Color.WHITE);
		labelVille.setFont(new Font("Roboto Medium", Font.BOLD | Font.ITALIC, 12));
		labelVille.setBounds(596, 218, 263, 21);
		getContentPane().add(labelVille);

		JLabel lblCodePost = new JLabel("Code Postal : ");
		lblCodePost.setForeground(Color.WHITE);
		lblCodePost.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblCodePost.setBounds(481, 250, 105, 21);
		getContentPane().add(lblCodePost);

		labelCodePostal = new JLabel("");
		labelCodePostal.setForeground(Color.WHITE);
		labelCodePostal.setFont(new Font("Roboto Medium", Font.BOLD | Font.ITALIC, 12));
		labelCodePostal.setBounds(596, 250, 263, 21);
		getContentPane().add(labelCodePostal);

		JLabel lblProfession = new JLabel("Profession :  ");
		lblProfession.setForeground(Color.WHITE);
		lblProfession.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblProfession.setBounds(481, 282, 105, 21);
		getContentPane().add(lblProfession);

		labelProfession = new JLabel("");
		labelProfession.setForeground(Color.WHITE);
		labelProfession.setFont(new Font("Roboto Medium", Font.BOLD | Font.ITALIC, 12));
		labelProfession.setBounds(596, 282, 263, 21);
		getContentPane().add(labelProfession);

		JLabel lblInformationsDtaillesDu = new JLabel("Informations d\u00E9taill\u00E9es du client");
		lblInformationsDtaillesDu.setForeground(Color.WHITE);
		lblInformationsDtaillesDu.setFont(new Font("Roboto Black", Font.BOLD | Font.ITALIC, 12));
		lblInformationsDtaillesDu.setBounds(590, 7, 242, 15);
		getContentPane().add(lblInformationsDtaillesDu);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(596, 45, 263, 2);
		getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(596, 76, 263, 2);
		getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(596, 109, 263, 2);
		getContentPane().add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(596, 141, 263, 2);
		getContentPane().add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(596, 173, 263, 2);
		getContentPane().add(separator_4);

		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(Color.BLACK);
		separator_5.setBackground(Color.BLACK);
		separator_5.setBounds(596, 205, 263, 2);
		getContentPane().add(separator_5);

		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(Color.BLACK);
		separator_6.setBackground(Color.BLACK);
		separator_6.setBounds(596, 237, 263, 2);
		getContentPane().add(separator_6);

		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(Color.BLACK);
		separator_7.setBackground(Color.BLACK);
		separator_7.setBounds(596, 269, 263, 2);
		getContentPane().add(separator_7);

		JSeparator separator_8 = new JSeparator();
		separator_8.setForeground(Color.BLACK);
		separator_8.setBackground(Color.BLACK);
		separator_8.setBounds(596, 301, 263, 2);
		getContentPane().add(separator_8);

		JButton btnAddClient = new JButton("Ajouter");
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// code executé après le clic sur "Ajouter"

				String verifierNoms = textFieldNoms.getText();
				String verifierPrenoms = textFieldPrenoms.getText();
				String verifierDate = textFieldDate.getText();
				String verifierTel = textFieldTel.getText();
				String verifierAdresse = textFieldAdresse.getText();

				if (verifierNoms.isEmpty() || verifierPrenoms.isEmpty() || verifierDate.isEmpty()
						|| verifierTel.isEmpty() || verifierAdresse.isEmpty() || selectGest.getSelectedIndex() == 0) {

					JOptionPane.showMessageDialog(null, "Tous les champs doivent être remplis", "Attention!",
							JOptionPane.WARNING_MESSAGE);
				} else {

					// 3. Création de services et utilisation du contructeur générique. Elle prend
					// en paramètre un IDaoClients
					dao = new Dao();
					service = new Service(dao);

					// 1. Récupération des valeur saisies par l'utilisateur

					String noms = textFieldNoms.getText();
					String prenoms = textFieldPrenoms.getText();
					String dateNaissance = textFieldDate.getText();
					String telephone = textFieldTel.getText();
					String adresse = textFieldAdresse.getText();
					Gestionnaires gestionnaireSelect = ((Gestionnaires) selectGest.getSelectedItem());
					String idGestionnaireSelect = gestionnaireSelect.getIdGestionnaires();

					// 2. Création d'un objet Clients puis, maj des attributs de l'objet client

					Clients client = new Clients();
					client.setNoms(noms);
					client.setPrenoms(prenoms);
					client.setDateNaissance(dateNaissance);
					client.setTelephone(telephone);
					client.setAdresse(adresse);
					client.setGestionnaires_idGestionnaires(idGestionnaireSelect);

					// 4. On donne notre objet client à la méthode enregistrerClientsService de la
					// couche serviceClients

					// La variable verifier permet de contenir le résultat de l'instruction
					// d'enregistrement

					int verifier = service.enregistrerClientsService(client);
					if (verifier == 1) {
						JOptionPane.showMessageDialog(null,
								"le " + client.getNoms() + " " + client.getPrenoms()
										+ " a bien été enregistré dans la Base de données",
								"Information!", JOptionPane.INFORMATION_MESSAGE);

						viderChamps();

					} else {
						JOptionPane.showMessageDialog(null,
								"Erreur lors de l'enregistrement du client " + client.getNoms() + " "
										+ client.getPrenoms() + " dans la Base de données",
								"Alerte!", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnAddClient.setIcon(new ImageIcon(GestionClients.class.getResource("/img/Add_User_Group_Woman_Man_32px.png")));
		btnAddClient.setFont(new Font("Roboto Medium", Font.BOLD, 11));
		btnAddClient.setBounds(10, 442, 122, 37);
		getContentPane().add(btnAddClient);

		JButton btnEditClient = new JButton("Modifier");
		btnEditClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (clientSelect != null) {
					// code executé après le clic sur "Modifier"

					// 3. Création de services et utilisation du contructeur générique. Elle prend
					// en paramètre un IDao
					dao = new Dao();
					service = new Service(dao);

					// 1. Récupération des valeur saisies par l'utilisateur

					String idClient = labelIdClient.getText();
					String noms = textFieldNoms.getText();
					String prenoms = textFieldPrenoms.getText();
					String dateNaissance = textFieldDate.getText();
					String telephone = textFieldTel.getText();
					String adresse = textFieldAdresse.getText();
					// int telephone = Integer.parseInt(textFieldTel.getText());
					Gestionnaires gestionnaireSelect = ((Gestionnaires) selectGest.getSelectedItem());
					String idGestionnaireSelect = gestionnaireSelect.getIdGestionnaires();

					// 2. Création d'un objet client puis, maj des attributs de l'objet client

					Clients client = new Clients();

					client.setIdClients(idClient);
					client.setNoms(noms);
					client.setPrenoms(prenoms);
					client.setDateNaissance(dateNaissance);
					client.setTelephone(telephone);
					client.setAdresse(adresse);
					client.setGestionnaires_idGestionnaires(idGestionnaireSelect);

					// 3. On donne notre objet client à la méthode modifierClientsService de la
					// couche
					// service

					int verifier = service.modifierClientsService(client);

					if (verifier == 1) {
						JOptionPane.showMessageDialog(null,
								"Le client " + client.getNoms() + " " + client.getPrenoms()
										+ " a bien été modifié dans la Base de données",
								"Information!", JOptionPane.INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null,
								"Erreur lors de la modification du client" + client.getNoms() + " "
										+ client.getPrenoms() + " dans la Base de donnees",
								"Alerte!", JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "bien vouloir sélectionner un client de la liste", "Attention!",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnEditClient.setIcon(new ImageIcon(GestionClients.class.getResource("/img/icons8_Edit_Property_32px.png")));
		btnEditClient.setFont(new Font("Roboto Medium", Font.BOLD, 11));
		btnEditClient.setBounds(142, 442, 122, 37);
		getContentPane().add(btnEditClient);

		JButton btnDelClient = new JButton("Supprimer");
		btnDelClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code executé après le clic sur "Supprimer"

				if (JOptionPane.showConfirmDialog(null, "Souhaitez-vous vraiment supprimer ce client?",
						"Supprimer client", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
					if (labelIdClient.getText().length() != 0) {

						// 3. Création de services et utilisation du contructeur générique. Elle prend
						// en paramètre un IDao
						dao = new Dao();
						service = new Service(dao);

						// 1. Récupération de la valeur sélectionner par l'utilisateur

						String idClient = labelIdClient.getText();
						String noms = textFieldNoms.getText();
						String prenoms = textFieldPrenoms.getText();
						String dateNaissance = textFieldDate.getText();
						String telephone = textFieldAdresse.getText();
						String adresse = textFieldCodePos.getText();
						// int telephone = Integer.parseInt(textFieldTel.getText());
						Gestionnaires gestionnaireSelect = ((Gestionnaires) selectGest.getSelectedItem());
						String idGestionnaireSelect = gestionnaireSelect.getIdGestionnaires();

						// 2. Création d'un objet client puis, maj des attributs de l'objet client

						Clients client = new Clients();

						client.setIdClients(idClient);
						client.setNoms(noms);
						client.setPrenoms(prenoms);
						client.setDateNaissance(dateNaissance);
						client.setTelephone(telephone);
						client.setAdresse(adresse);
						client.setGestionnaires_idGestionnaires(idGestionnaireSelect);

						// 4. On donne notre objet client à la méthode supprimerServiceClient() de la
						// couche service

						int verifier = service.supprimerClientsService(client);

						if (verifier == 1) {
							JOptionPane.showMessageDialog(null,
									"Le client " + client.getNoms() + " " + client.getPrenoms()
											+ " a bien été supprimé dans la Base de données",
									"Information!", JOptionPane.INFORMATION_MESSAGE);

							viderChamps();

						} else {
							JOptionPane.showMessageDialog(null,
									"Erreur lors de la suppression du client " + client.getNoms() + " "
											+ client.getPrenoms() + " dans la Base de donnees",
									"Alerte!", JOptionPane.ERROR_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(null, "veuillez choisir  un client!", "Attention!",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		btnDelClient.setIcon(new ImageIcon(GestionClients.class.getResource("/img/icons8_Trash_Can_32px.png")));
		btnDelClient.setFont(new Font("Roboto Medium", Font.BOLD, 11));
		btnDelClient.setBounds(274, 442, 134, 37);
		getContentPane().add(btnDelClient);

		JButton btnPrintClient = new JButton("Imprimer");
		btnPrintClient.setIcon(new ImageIcon(GestionClients.class.getResource("/img/icons8_Print_32px.png")));
		btnPrintClient.setFont(new Font("Roboto Medium", Font.BOLD, 11));
		btnPrintClient.setBounds(418, 442, 129, 37);
		getContentPane().add(btnPrintClient);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recher = textRechercher.getText();
				if (recher.isEmpty()) {
					JOptionPane.showMessageDialog(null, "veuillez entrer un nom!!!", "Attention!",
							JOptionPane.WARNING_MESSAGE);
				} else {
					affichageClientsTrouver();
				}
			}
		});
		btnSearch.setIcon(new ImageIcon(GestionClients.class.getResource("/img/icons8_Search_32px.png")));
		btnSearch.setFont(new Font("Roboto Medium", Font.BOLD, 11));
		btnSearch.setBounds(689, 442, 129, 37);
		getContentPane().add(btnSearch);

		textRechercher = new JTextField();
		textRechercher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textRechercher.setText("");
			}
		});
		textRechercher.setToolTipText("Recherchez un client");
		textRechercher.setText("Saisir un nom");
		textRechercher.setFont(new Font("Roboto", Font.PLAIN, 13));
		textRechercher.setColumns(10);
		textRechercher.setBounds(557, 442, 122, 37);
		getContentPane().add(textRechercher);

		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Roboto Medium", Font.BOLD, 12));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Formulaire d'enregistrement et modification d'un client", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.setBounds(10, 309, 808, 130);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNoms_1 = new JLabel("Noms :");
		lblNoms_1.setBounds(10, 21, 70, 24);
		panel_1.add(lblNoms_1);
		lblNoms_1.setForeground(Color.BLACK);
		lblNoms_1.setFont(new Font("Roboto Light", Font.BOLD, 13));

		JLabel lblPrnoms_1 = new JLabel("Pr\u00E9noms :");
		lblPrnoms_1.setBounds(10, 56, 70, 28);
		panel_1.add(lblPrnoms_1);
		lblPrnoms_1.setForeground(Color.BLACK);
		lblPrnoms_1.setFont(new Font("Roboto Light", Font.BOLD, 13));

		JLabel lblEmail_1 = new JLabel("Date N. :");
		lblEmail_1.setForeground(Color.BLACK);
		lblEmail_1.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblEmail_1.setBounds(10, 95, 70, 28);
		panel_1.add(lblEmail_1);

		textFieldNoms = new JTextField();
		textFieldNoms.setFont(new Font("Roboto Condensed Light", Font.BOLD, 13));
		textFieldNoms.setBounds(90, 24, 160, 20);
		panel_1.add(textFieldNoms);
		textFieldNoms.setColumns(10);

		textFieldPrenoms = new JTextField();
		textFieldPrenoms.setFont(new Font("Roboto Condensed Light", Font.BOLD, 13));
		textFieldPrenoms.setColumns(10);
		textFieldPrenoms.setBounds(90, 61, 160, 20);
		panel_1.add(textFieldPrenoms);

		textFieldDate = new JTextField();
		textFieldDate.setFont(new Font("Roboto Condensed Light", Font.BOLD, 13));
		textFieldDate.setColumns(10);
		textFieldDate.setBounds(90, 100, 160, 20);
		panel_1.add(textFieldDate);

		JLabel lblAdresse_1 = new JLabel("Adresse :");
		lblAdresse_1.setForeground(Color.BLACK);
		lblAdresse_1.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblAdresse_1.setBounds(536, 21, 96, 24);
		panel_1.add(lblAdresse_1);

		textFieldAdresse = new JTextField();
		textFieldAdresse.setFont(new Font("Roboto Condensed Light", Font.BOLD, 13));
		textFieldAdresse.setColumns(10);
		textFieldAdresse.setBounds(642, 23, 160, 20);
		panel_1.add(textFieldAdresse);

		JLabel lblCodePostal_1 = new JLabel("Code postal :");
		lblCodePostal_1.setForeground(Color.BLACK);
		lblCodePostal_1.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblCodePostal_1.setBounds(536, 95, 96, 28);
		panel_1.add(lblCodePostal_1);

		textFieldCodePos = new JTextField();
		textFieldCodePos.setEditable(false);
		textFieldCodePos.setEnabled(false);
		textFieldCodePos.setFont(new Font("Roboto Condensed Light", Font.BOLD, 13));
		textFieldCodePos.setColumns(10);
		textFieldCodePos.setBounds(642, 97, 160, 20);
		panel_1.add(textFieldCodePos);

		JLabel lblVille_1 = new JLabel("Ville :");
		lblVille_1.setForeground(Color.BLACK);
		lblVille_1.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblVille_1.setBounds(260, 95, 96, 28);
		panel_1.add(lblVille_1);

		textFieldVille = new JTextField();
		textFieldVille.setEditable(false);
		textFieldVille.setEnabled(false);
		textFieldVille.setFont(new Font("Roboto Condensed Light", Font.BOLD, 13));
		textFieldVille.setColumns(10);
		textFieldVille.setBounds(366, 97, 160, 20);
		panel_1.add(textFieldVille);

		JLabel lblTlphone = new JLabel("T\u00E9l\u00E9phone :");
		lblTlphone.setForeground(Color.BLACK);
		lblTlphone.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblTlphone.setBounds(264, 21, 96, 24);
		panel_1.add(lblTlphone);

		textFieldTel = new JTextField();
		textFieldTel.addKeyListener(new KeyAdapter() {

			/**
			 * Contraint l'utilisateur à saisir uniquement des chiffres
			 * 
			 * @see java.awt.event.KeyAdapter#keyTyped(java.awt.event.KeyEvent)
			 */
			public void keyTyped(KeyEvent arg0) {
				char vChar = arg0.getKeyChar();
				if (!(Character.isDigit(vChar)) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE)) {

					arg0.consume();
				}
			}
		});
		textFieldTel.setFont(new Font("Roboto Condensed Light", Font.BOLD, 13));
		textFieldTel.setColumns(10);
		textFieldTel.setBounds(366, 23, 160, 20);
		panel_1.add(textFieldTel);

		textFieldProf = new JTextField();
		textFieldProf.setEditable(false);
		textFieldProf.setEnabled(false);
		textFieldProf.setFont(new Font("Roboto Condensed Light", Font.BOLD, 13));
		textFieldProf.setColumns(10);
		textFieldProf.setBounds(642, 58, 160, 20);
		panel_1.add(textFieldProf);

		JLabel lblProfession_1 = new JLabel("Profession :");
		lblProfession_1.setForeground(Color.BLACK);
		lblProfession_1.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblProfession_1.setBounds(536, 56, 96, 28);
		panel_1.add(lblProfession_1);

		JLabel lblConseiller_1 = new JLabel("Gestionnaire :");
		lblConseiller_1.setForeground(Color.BLACK);
		lblConseiller_1.setFont(new Font("Roboto Light", Font.BOLD, 13));
		lblConseiller_1.setBounds(260, 56, 96, 28);
		panel_1.add(lblConseiller_1);

		selectGest = new JComboBox();
		selectGest.setFont(new Font("Roboto Condensed Light", Font.BOLD, 13));
		selectGest.setBounds(366, 61, 160, 20);
		panel_1.add(selectGest);
		List<Gestionnaires> maListeGestionnaires = new ArrayList<Gestionnaires>();
		maListeGestionnaires = service.getAllGestionnairesService();
		for (Gestionnaires gestionnaire : maListeGestionnaires) {
			selectGest.addItem(gestionnaire);
		}

		labelIdClient = new JLabel("");
		labelIdClient.setFont(new Font("Roboto Condensed Light", Font.BOLD, 13));
		labelIdClient.setBounds(852, 336, 30, 20);
		getContentPane().add(labelIdClient);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GestionClients.class.getResource("/img/Contrat.png")));
		lblNewLabel.setBounds(823, 308, 108, 171);
		getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("");
		label.setFont(new Font("Roboto Medium", Font.BOLD | Font.ITALIC, 12));
		label.setIcon(new ImageIcon(GestionClients.class.getResource("/img/fondInternalFrame.jpg")));
		label.setBounds(0, 0, 931, 505);
		getContentPane().add(label);
		setBounds(100, 100, 931, 505);

		// Appelle de la méthode pour afficher la liste des clients
		affichage();

		// Appelle de la méthode pour supprimer la barre de titre
		remove_title_bar();

		// Appelle de la méthode pour vider les champs du formulaire
		viderChamps();

	}

	/**
	 * Cette méthode permet d'afficher la liste des clients
	 */
	public void affichage() {
		// Appel de la méthode getAllClientsService() que je place dans mon model
		ClientsModel clientsModel = new ClientsModel(service.getAllClientsService());
		jTableClients = new JTable(clientsModel);
		jTableClients.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				getContenuTab();
				remplirFormulaire(clientSelect);
			}
		});
		JScrollPane scrollPane = new JScrollPane(jTableClients);
		scrollPane.setFont(new Font("Roboto Medium", Font.PLAIN, 12));
		panel.add(scrollPane, BorderLayout.CENTER);
		jTableClients.setFont(new Font("Roboto", Font.PLAIN, 12));
		jTableClients.setBorder(null);
	}

	/**
	 * Cette méthode permet d'afficher dans le jTable la liste des clients trouvés
	 * en base de données
	 */
	public void affichageClientsTrouver() {
		ClientsModel clientsModel1 = new ClientsModel(service.rechercherClientsService(recher));
		jTableClients.setModel(clientsModel1);
		panel.add(new JScrollPane(jTableClients), BorderLayout.CENTER);
		jTableClients.setFont(new Font("Roboto", Font.PLAIN, 12));
		jTableClients.setBorder(null);
	}

	/**
	 * Cette méthode permet d'effacer les champs du formulaire d'enregistrement du
	 * client
	 */
	public void viderChamps() {
		textFieldNoms.setText("");
		textFieldPrenoms.setText("");
		textFieldDate.setText("");
		textFieldAdresse.setText("");
		textFieldCodePos.setText("");
		textFieldVille.setText("");
		textFieldTel.setText("");
		textFieldProf.setText("");
		// selectCons.removeAllItems();
	}

	/**
	 * Cette méthode permet de supprimer la barre de titre sur mon InternalFrame
	 * 
	 */
	public void remove_title_bar() {
		putClientProperty("GestionClients.isPalette", Boolean.TRUE);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		this.setBorder(null);
	}

	/**
	 * Cette méthode permet de récupérer les données d'un champ de tableau
	 * sélectionné
	 */
	public void getContenuTab() {

		row = jTableClients.getSelectedRow();
		labelNoms.setText(jTableClients.getModel().getValueAt(row, 1).toString());
		labelPrenoms.setText(jTableClients.getModel().getValueAt(row, 2).toString());
		labelDateNaissance.setText(jTableClients.getModel().getValueAt(row, 3).toString());
		labelTelephone.setText(jTableClients.getModel().getValueAt(row, 4).toString());
		labelAdresse.setText(jTableClients.getModel().getValueAt(row, 5).toString());
		labelGestionnaire.setText(jTableClients.getModel().getValueAt(row, 6).toString());
//		labelVille.setText(jTableClients.getModel().getValueAt(row, 7).toString());
//		labelCodePostal.setText(jTableClients.getModel().getValueAt(row, 8).toString());
//		labelProfession.setText(jTableClients.getModel().getValueAt(row, 9).toString());

		clientSelect = new Clients();
		clientSelect.setIdClients(jTableClients.getModel().getValueAt(row, 0).toString());
		clientSelect.setNoms(jTableClients.getModel().getValueAt(row, 1).toString());
		clientSelect.setPrenoms(jTableClients.getModel().getValueAt(row, 2).toString());
		clientSelect.setDateNaissance(jTableClients.getModel().getValueAt(row, 3).toString());
		clientSelect.setTelephone(jTableClients.getModel().getValueAt(row, 4).toString());
		clientSelect.setAdresse(jTableClients.getModel().getValueAt(row, 5).toString());
		clientSelect.setGestionnaires_idGestionnaires(jTableClients.getModel().getValueAt(row, 6).toString());
		// clientSelect.setTelephoneCli(Integer.parseInt(jTableClients.getModel().getValueAt(row,
		// 7).toString()));

	}

	/**
	 * Cette méthode permet de remplir les champs du formulaire par les information
	 * du client sélectionné
	 */
	public void remplirFormulaire(Clients clientSelect) {

		labelIdClient.setText(clientSelect.getIdClients());
		textFieldNoms.setText(clientSelect.getNoms());
		textFieldPrenoms.setText(clientSelect.getPrenoms());
		textFieldDate.setText(clientSelect.getDateNaissance());
		textFieldTel.setText(String.valueOf(clientSelect.getTelephone()));
		textFieldAdresse.setText(clientSelect.getAdresse());
		selectGest.setSelectedItem(clientSelect.getGestionnaires_idGestionnaires());

	}
}
