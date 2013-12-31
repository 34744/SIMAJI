package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import controller.ControllerDB;
import model.application;
import model.applicationArbre;
import model.applicationModelTableau;
import model.utilisateur;
import model.utilisateurArbre;
import model.utilisateurModelTableau;

import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;

import java.awt.SystemColor;

import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.JCheckBox;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JScrollPane;

import sun.swing.MenuItemLayoutHelper.ColumnAlignment;

class ComposantOnglet extends JPanel implements ActionListener {
	  private JTabbedPane pane;
	 
	  public ComposantOnglet(String titre, JTabbedPane pane) {
	    this.pane = pane;
	    setOpaque(false);
	    JLabel label = new JLabel(titre);
	    add(label);
	    JButton button = new JButton("Fermer");
	    button.setPreferredSize(new Dimension(50,30));
	    button.addActionListener(this);
	   // add(button);
	  }
	 
	  public void actionPerformed(ActionEvent e) {
	    int i = pane.indexOfTabComponent(this);
	    if (i != -1)
	      pane.remove(i);
	  }
	}


public class Parametres extends JPanel {

	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES FENETRE
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	
	
	
	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES NAVIGATION
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	private JButton btnHome = new JButton("Accueil");
	private JButton btnRapports = new JButton("Rapports");
	private JButton btnSoftware = new JButton("Application");
	private JButton btnConfig = new JButton("Configuration");
	private JButton btnUpdate = new JButton("Mise \u00E0 jour");
	
	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES APPLICATION
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	
	JLabel lblErreur = new JLabel("Veuillez compl\u00E9ter le champ manquant");
	private JButton btnNewAppli = new JButton("Ajouter");
	private JButton btnAjouterAppli = new JButton("Valider");
	private JTable tableAppli;
	private Vector<model.applicationArbre> vectAppli = new Vector<model.applicationArbre>();
	private applicationModelTableau modelAppli;
	public application appli = new application();
	private final JButton btnModifier = new JButton("Valider");
	private JTextField textFieldModifAppli;
	private JTextField textFieldAjoutAppli;
	private JCheckBox chckbxArchiverModif = new JCheckBox("");
	private JCheckBox chckbxArchiverAjt = new JCheckBox("");
	public JPanel panelAjouter = new JPanel();
	private final JButton btnAffModifierAppli = new JButton("Modifier");
	private int idAppliSelec;
	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES UTILISATEUR
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	
	private JTable tableUtilisateur;
	private Vector<model.utilisateurArbre> vectUtilisateur = new Vector<model.utilisateurArbre>();
	private utilisateurModelTableau modelUtilisateur;
	public utilisateur user = new utilisateur();
	public String utilisateurSelectionne;
	private final JLabel lblActifModif = new JLabel("Archiv\u00E9e");
	private final JLabel lblActifAjt = new JLabel("Archiv\u00E9e");
	private JTextField textFieldNomUtilisateur;
	private JTextField textFieldPrenomUtilisateur;
	private JTextField textFieldUlisUtilisateur;
	private JTextField textFieldAdresseMail;

	/* 
	 * ---------------------------------------------------------------------------------------------------
	 * 									VARIABLES CELLULE
	 * ---------------------------------------------------------------------------------------------------
	 * 
	 */
	/*
	private JTable tableCellule;
	private Vector<model.applicationArbre> vectAppli = new Vector<model.applicationArbre>();
	private modelTableauApplication modelAppli;
	public application appli = new application();
	private applicationArbre applicationArbre = new applicationArbre();*/
	/**
	 * Create the panel.
	 */
	public Parametres(boolean ajout) {
		
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT INITIALISATION FENETRE
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */
		
		setBackground(new Color(176, 196, 222));
		setLayout(null);
		
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT INITIALISATION BARRE NAVIGATION
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.setForeground(Color.WHITE);
		toolBar.setBackground(new Color(211, 211, 211));
		toolBar.setBounds(22, 0, 778, 49);
		add(toolBar);
		

		btnHome.setIcon(new ImageIcon(Application.class.getResource("/icones/home41.png")));
		btnHome.setSelectedIcon(new ImageIcon(Application.class.getResource("/icones/home41.png")));
		toolBar.add(btnHome);
		btnSoftware.setSelectedIcon(new ImageIcon(Application.class.getResource("/icones/Application41.png")));
		

		btnSoftware.setIcon(new ImageIcon(Application.class.getResource("/icones/Application41.png")));
		toolBar.add(btnSoftware);
		btnUpdate.setSelectedIcon(new ImageIcon(Application.class.getResource("/icones/update41.png")));
		

		btnUpdate.setIcon(new ImageIcon(Application.class.getResource("/icones/update41.png")));
		toolBar.add(btnUpdate);
		btnRapports.setSelectedIcon(new ImageIcon(Application.class.getResource("/icones/rapports41.png")));
		

		btnRapports.setIcon(new ImageIcon(Application.class.getResource("/icones/rapports41.png")));
		toolBar.add(btnRapports);
		btnConfig.setSelectedIcon(new ImageIcon(Application.class.getResource("/icones/configuration41.png")));
		

		btnConfig.setIcon(new ImageIcon(Application.class.getResource("/icones/configuration41.png")));
		toolBar.add(btnConfig);
		
		JToggleButton tglbtnModifier = new JToggleButton("Modifier");
		tglbtnModifier.setIcon(new ImageIcon(Application.class.getResource("/icones/modifiable41.png")));
		
		tglbtnModifier.setToolTipText("Modifier");
		
		if(tglbtnModifier.isSelected()==false)
		{
		tglbtnModifier.setIcon(new ImageIcon(Application.class.getResource("/icones/modifiable41.png")));
		System.out.println("test");
		}
		
		else
		{
			tglbtnModifier.setIcon(new ImageIcon(Application.class.getResource("/icones/modifiableG41.png")));
			
		}
		toolBar.add(tglbtnModifier);

		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT INITIALISATION PANEL
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */		
		JTabbedPane pane = new JTabbedPane(JTabbedPane.LEFT);
		pane.setBounds(22, 102, 746, 380);
		add(pane);
		
		
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT PANEL APPLICATION
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */
		

		
		JPanel ongletAppli = new JPanel();
		ongletAppli.setLayout(null);
		
		vectAppli = controller.ControllerDB.getApplicationArbre();
		modelAppli = new applicationModelTableau(vectAppli);
		tableAppli = new JTable(modelAppli);
		tableAppli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(tableAppli.getSelectedRow()!=-1){
					remplirApplication(tableAppli.getValueAt(tableAppli.getSelectedRow(),0).toString());
					
				}
			}
		});
		tableAppli.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAppli.setColumnSelectionAllowed(true);
		tableAppli.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
		tableAppli.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		tableAppli.setForeground(Color.WHITE);
		tableAppli.setFont(new Font("Tahoma", Font.BOLD, 14));
		tableAppli.setBackground(new Color(211, 211, 211));
		tableAppli.setBounds(10, 40, 130, 200);
		tableAppli.setAutoCreateRowSorter(true);
		tableAppli.getRowSorter().toggleSortOrder(0);
		tableAppli.setAutoCreateRowSorter(false);
		
		ongletAppli.setPreferredSize(new Dimension(300, 80));
		JScrollPane scrollPaneAppli = new JScrollPane(tableAppli);
		scrollPaneAppli.setVisible(true);
		scrollPaneAppli.setBounds(10, 40, 156, 219);
		ongletAppli.add(scrollPaneAppli);
		
		pane.addTab("Applications", ongletAppli);
		lblErreur.setVisible(false);
		JPanel panelModifier = new JPanel();
		panelModifier.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelModifier.setBounds(302, 83, 200, 128);
		ongletAppli.add(panelModifier);
		panelModifier.setLayout(null);
		
		JLabel lblModifier = new JLabel("Modifier");
		lblModifier.setBounds(72, 11, 55, 17);
		lblModifier.setForeground(SystemColor.inactiveCaption);
		lblModifier.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panelModifier.add(lblModifier);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.text);
		separator.setForeground(SystemColor.menu);
		separator.setBounds(40, 25, 118, 8);
		panelModifier.add(separator);
		
		textFieldModifAppli = new JTextField();
		textFieldModifAppli.setBounds(10, 63, 118, 20);
		panelModifier.add(textFieldModifAppli);
		textFieldModifAppli.setColumns(10);
		btnModifier.setBounds(56, 94, 89, 23);
		panelModifier.add(btnModifier);
		
		JLabel lblNomApplicationModif = new JLabel("Nom de l'application");
		lblNomApplicationModif.setForeground(SystemColor.inactiveCaption);
		lblNomApplicationModif.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNomApplicationModif.setBounds(10, 44, 118, 14);
		panelModifier.add(lblNomApplicationModif);
		
		chckbxArchiverModif.setBounds(152, 60, 23, 23);
		panelModifier.add(chckbxArchiverModif);
		lblActifModif.setForeground(SystemColor.inactiveCaption);
		lblActifModif.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblActifModif.setBounds(137, 44, 53, 14);
		
		panelModifier.add(lblActifModif);
		
		
		panelAjouter.setLayout(null);
		panelAjouter.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelAjouter.setBounds(302, 83, 200, 128);
		ongletAppli.add(panelAjouter);
		
		JLabel lblAjouter = new JLabel("Ajouter");
		lblAjouter.setForeground(SystemColor.inactiveCaption);
		lblAjouter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAjouter.setBounds(75, 11, 55, 17);
		panelAjouter.add(lblAjouter);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(43, 28, 118, 8);
		panelAjouter.add(separator_1);
		
		textFieldAjoutAppli = new JTextField();
		textFieldAjoutAppli.setBounds(10, 63, 118, 20);
		
		panelAjouter.add(textFieldAjoutAppli);
		textFieldAjoutAppli.setColumns(10);
		
		
		btnAjouterAppli.setBounds(58, 94, 89, 23);
		panelAjouter.add(btnAjouterAppli);
		
		chckbxArchiverAjt.setBounds(156, 63, 23, 23);
		panelAjouter.add(chckbxArchiverAjt);
		
		JLabel lblNomApplicationAjt = new JLabel("Nom de l'application");
		lblNomApplicationAjt.setForeground(SystemColor.inactiveCaption);
		lblNomApplicationAjt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNomApplicationAjt.setBounds(10, 47, 118, 14);
		panelAjouter.add(lblNomApplicationAjt);
		lblActifAjt.setForeground(SystemColor.inactiveCaption);
		lblActifAjt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblActifAjt.setBounds(138, 47, 53, 14);
		
		panelAjouter.add(lblActifAjt);
		
		
		btnNewAppli.setBounds(31, 274, 89, 23);
		ongletAppli.add(btnNewAppli);
		btnAffModifierAppli.setBounds(31, 274, 89, 23);
		
		ongletAppli.add(btnAffModifierAppli);
		

		lblErreur.setForeground(Color.RED);
		lblErreur.setBounds(31, 336, 271, 14);
		ongletAppli.add(lblErreur);
		
		if(ajout == false){
			panelAjouter.setVisible(false);
			panelModifier.setVisible(true);
			btnAffModifierAppli.setVisible(false);
			btnNewAppli.setVisible(true);
		}
		else
		{
			panelAjouter.setVisible(true);
			panelModifier.setVisible(false);
			btnAffModifierAppli.setVisible(true);
			btnNewAppli.setVisible(false);
		}
		
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT PANEL UTILISATEUR
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */
		JPanel ongletUtilisateur = new JPanel();
		ongletUtilisateur.setLayout(null);
		
		vectUtilisateur = controller.ControllerDB.getUtilisateurArbre();
		modelUtilisateur = new utilisateurModelTableau(vectUtilisateur);
		tableUtilisateur = new JTable(modelUtilisateur);
		tableUtilisateur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(tableUtilisateur.getSelectedRow()!=-1){
					utilisateurSelectionne=tableUtilisateur.getValueAt(tableUtilisateur.getSelectedRow(), 2).toString();
					remplirUtilisateur(tableUtilisateur.getValueAt(tableUtilisateur.getSelectedRow(),0).toString());
				}
			}
		});
		tableUtilisateur.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableUtilisateur.setColumnSelectionAllowed(true);
		tableUtilisateur.setToolTipText("S\u00E9lectionnez l'utilisateur d\u00E9sir\u00E9");
		tableUtilisateur.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		tableUtilisateur.setForeground(Color.WHITE);
		tableUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 13));
		tableUtilisateur.setBackground(new Color(211, 211, 211));
		tableUtilisateur.setBounds(7, 40, 95, 128);
		tableUtilisateur.getColumnModel().getColumn(0).setPreferredWidth(75);
		tableUtilisateur.getColumnModel().getColumn(1).setPreferredWidth(60);
		tableUtilisateur.getColumnModel().getColumn(2).setPreferredWidth(15);
		tableUtilisateur.getColumnModel().getColumn(3).setPreferredWidth(190);
		JScrollPane scrollPaneUtilisateur = new JScrollPane(tableUtilisateur);
		scrollPaneUtilisateur.setVisible(true);
		scrollPaneUtilisateur.setBounds(10, 11, 600, 105);
		
		ongletUtilisateur.setPreferredSize(new Dimension(300, 80));
		ongletUtilisateur.add(scrollPaneUtilisateur);
		pane.addTab("Utilisateurs", ongletUtilisateur);
		
		JPanel panelModifierUtilisateur = new JPanel();
		panelModifierUtilisateur.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panelModifierUtilisateur.setBounds(10, 139, 242, 182);
		ongletUtilisateur.add(panelModifierUtilisateur);
		panelModifierUtilisateur.setLayout(null);
		
		textFieldPrenomUtilisateur = new JTextField();
		textFieldPrenomUtilisateur.setText("Pr\u00E9nom");
		textFieldPrenomUtilisateur.setBounds(10, 51, 126, 20);
		textFieldPrenomUtilisateur.setColumns(10);
		panelModifierUtilisateur.add(textFieldPrenomUtilisateur);
		
		textFieldNomUtilisateur = new JTextField();
		textFieldNomUtilisateur.setText("Nom");
		textFieldNomUtilisateur.setBounds(10, 20, 126, 20);
		panelModifierUtilisateur.add(textFieldNomUtilisateur);
		textFieldNomUtilisateur.setColumns(10);
		
		textFieldUlisUtilisateur = new JTextField();
		textFieldUlisUtilisateur.setText("n\u00B0Ulis");
		textFieldUlisUtilisateur.setColumns(10);
		textFieldUlisUtilisateur.setBounds(10, 82, 70, 20);
		panelModifierUtilisateur.add(textFieldUlisUtilisateur);
		
		textFieldAdresseMail = new JTextField();
		textFieldAdresseMail.setText("Adresse Mail");
		textFieldAdresseMail.setBounds(10, 113, 222, 20);
		panelModifierUtilisateur.add(textFieldAdresseMail);
		textFieldAdresseMail.setColumns(10);
		
		JCheckBox chckbxActifUtilisateur = new JCheckBox("Actif");
		chckbxActifUtilisateur.setBounds(10, 140, 97, 23);
		panelModifierUtilisateur.add(chckbxActifUtilisateur);
		
		JPanel panelUtilisateurCellule = new JPanel();
		panelUtilisateurCellule.setBorder(new LineBorder(SystemColor.inactiveCaption));
		panelUtilisateurCellule.setBounds(289, 139, 198, 182);
		ongletUtilisateur.add(panelUtilisateurCellule);
		panelUtilisateurCellule.setLayout(null);
		
		JButton btnCelluleAjouter = new JButton("Ajouter");
		btnCelluleAjouter.setBounds(497, 160, 89, 23);
		ongletUtilisateur.add(btnCelluleAjouter);
		
		JButton btnCelluleModifier = new JButton("Modifier");
		btnCelluleModifier.setBounds(497, 195, 89, 23);
		ongletUtilisateur.add(btnCelluleModifier);
		
		JCheckBox chckbxActiveOnly = new JCheckBox("Cellules Actives Uniquement");
		chckbxActiveOnly.setBounds(289, 332, 218, 23);
		ongletUtilisateur.add(chckbxActiveOnly);
		
		JButton btnModifierUtilisateur = new JButton("Modifier");
		btnModifierUtilisateur.setBounds(10, 332, 89, 23);
		ongletUtilisateur.add(btnModifierUtilisateur);
		
		JCheckBox chckbxUtilisateurActif = new JCheckBox("Actif uniquement");
		chckbxUtilisateurActif.setBounds(493, 117, 142, 23);
		ongletUtilisateur.add(chckbxUtilisateurActif);
		
		JButton btnAjouterUtilisateur = new JButton("");
		btnAjouterUtilisateur.setBounds(615, 57, 20, 23);
		ongletUtilisateur.add(btnAjouterUtilisateur);
		btnAjouterUtilisateur.setIcon(new ImageIcon(Parametres.class.getResource("/icones/ins\u00E9rer40.png")));
		
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT PANEL CELLULE
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */
		/*
		vectAppli = controller.ControllerDB.getApplicationArbre();
		modelAppli = new applicationModelTableau(vectAppli);
		tableAppli = new JTable(modelAppli);
		tableAppli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(tableAppli.getSelectedRow()!=-1){
					remplirApplication(tableAppli.getValueAt(tableAppli.getSelectedRow(),0).toString());
					
				}
			}
		});
		tableAppli.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAppli.setColumnSelectionAllowed(true);
		tableAppli.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
		tableAppli.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		tableAppli.setForeground(Color.WHITE);
		tableAppli.setFont(new Font("Tahoma", Font.BOLD, 14));
		tableAppli.setBackground(new Color(211, 211, 211));
		tableAppli.setBounds(7, 40, 95, 128);
		
		
		JPanel ongletCellule = new JPanel();
		ongletCellule.setLayout(null);
		ongletCellule.setPreferredSize(new Dimension(300, 80));
		//ongletCellule.add(tableCellule);
		pane.addTab("Cellule", ongletCellule);
		*/
		/* 
		 * ---------------------------------------------------------------------------------------------------
		 * 									DEBUT LISTENER BOUTON
		 * ---------------------------------------------------------------------------------------------------
		 * 
		 */
		
		MyButtonListener list= new MyButtonListener();
		btnConfig.addActionListener(list);
		btnSoftware.addActionListener(list);
		btnUpdate.addActionListener(list);
		btnRapports.addActionListener(list);
		btnHome.addActionListener(list);
		btnNewAppli.addActionListener(list);
		btnAjouterAppli.addActionListener(list);
		btnAffModifierAppli.addActionListener(list);
		btnModifier.addActionListener(list);
		tglbtnModifier.addActionListener(list);
		

	}
	
	private class MyButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			Object source = e.getSource();
			
			if(source == btnHome){
				controller.gestionFenetre.eraseContainerPaneMainJFrame();
				controller.gestionFenetre.accueil();
			}
			
			if(source == btnSoftware){
				controller.gestionFenetre.eraseContainerPaneMainJFrame();
				controller.gestionFenetre.application();
			}
			
			if(source == btnNewAppli){
				
				controller.gestionFenetre.eraseContainerPaneMainJFrame();
				controller.gestionFenetre.configurationAjout(true);
				
			}
			
			if(source == btnAffModifierAppli){
				
				controller.gestionFenetre.eraseContainerPaneMainJFrame();
				controller.gestionFenetre.configurationModif(false);
				
			}
			
			if(source == btnModifier){
				
				if(textFieldModifAppli.getText()!= null && textFieldModifAppli.getText().length()>0 ){
					appli.setNomApplication(textFieldModifAppli.getText());
					appli.setIdApplication(idAppliSelec);
					
					if(chckbxArchiverModif.isSelected()){
						appli.setVisibiliteApplication("Archivée");
					}
					else
					{
						appli.setVisibiliteApplication("");
					}					
					controller.ControllerDB.ModifApplication(appli);
					controller.gestionFenetre.eraseContainerPaneMainJFrame();
					controller.gestionFenetre.configurationModif(false);	
				}
				else
				{
	
					lblErreur.setVisible(true);
					textFieldModifAppli.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					textFieldModifAppli.requestFocus();
				}
			}
			
			if(source == btnAjouterAppli){
				if(textFieldAjoutAppli.getText()!= null && textFieldAjoutAppli.getText().length()>0 ){
					appli.setNomApplication(textFieldAjoutAppli.getText());
					appli.setIdApplication(idAppliSelec);
					
					if(chckbxArchiverAjt.isSelected()){
						appli.setVisibiliteApplication("Archivée");
					}
					else
					{
						appli.setVisibiliteApplication("");
					}					
					controller.addData.addApplication(appli);
					controller.gestionFenetre.eraseContainerPaneMainJFrame();
					controller.gestionFenetre.configurationModif(true);	
				}
				else
				{
	
					lblErreur.setVisible(true);
					textFieldAjoutAppli.setBorder(BorderFactory.createLineBorder(new Color(255,0,0)));
					textFieldAjoutAppli.requestFocus();
			
				}
				/*appli.setNomApplication(textFieldAjoutAppli.getText());
				appli.setVisibiliteApplication("");
				controller.addData.addApplication(appli);
				controller.gestionFenetre.eraseContainerPaneMainJFrame();
				controller.gestionFenetre.configurationModif(true);*/
			}
		}
	}
private void remplirApplication(String application){
		
		applicationArbre applicationArbre = ControllerDB.getApplicationArbre(application);
		textFieldModifAppli.setText(applicationArbre.getNomApplication());
		
		if(applicationArbre.getVisibiliteApplication().equals("Archivée")){
			chckbxArchiverModif.setSelected(true);
			
		}
		else
		{

			chckbxArchiverModif.setSelected(false);
			
		}
		
		idAppliSelec=applicationArbre.getIdApplication();
		
	}

private void remplirUtilisateur(String numUtilisateur){
	numUtilisateur=utilisateurSelectionne;
	utilisateurArbre utilisateurArbre = ControllerDB.getUtilisateurArbre(numUtilisateur);
	
	textFieldNomUtilisateur.setText(utilisateurArbre.getNomUtilisateur());
	textFieldPrenomUtilisateur.setText(utilisateurArbre.getPrenomUtilisateur());
	textFieldUlisUtilisateur.setText(utilisateurArbre.getNumUlis());
	textFieldAdresseMail.setText(utilisateurArbre.getMailUtilisateur());
	//idAppliSelec=applicationArbre.getIdApplication();
	
}
}


