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

import controller.ControllerDB;
import model.application;
import model.applicationArbre;
import model.modelTableauApplication;

import javax.swing.border.LineBorder;

import java.awt.SystemColor;

import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.sun.org.apache.xpath.internal.operations.Bool;

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

	private JButton btnHome = new JButton("Accueil");
	private JButton btnRapports = new JButton("Rapports");
	private JButton btnSoftware = new JButton("Application");
	private JButton btnConfig = new JButton("Configuration");
	private JButton btnUpdate = new JButton("Mise \u00E0 jour");
	private JButton btnNewAppli = new JButton("Ajouter");
	private JButton btnAjouterAppli = new JButton("Valider");
	private JLabel lbIdModifAppli = new JLabel("lbModifAppli");
	private JTable tableAppli;
	private Vector<model.applicationArbre> vectAppli = new Vector<model.applicationArbre>();
	private modelTableauApplication modelAppli;
	public application appli = new application();
	private final JButton btnModifier = new JButton("Valider");
	private JTextField textFieldModifAppli;
	private JTextField textFieldAjoutAppli;
	public JPanel panelAjouter = new JPanel();
	private final JButton btnAffModifierAppli = new JButton("Modifier");
	private int idAppliSelec;
	//private applicationArbre applicationArbre = new applicationArbre();
	/**
	 * Create the panel.
	 */
	public Parametres(boolean ajout) {
		System.out.print(ajout);
		setBackground(new Color(176, 196, 222));
		setLayout(null);
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.setForeground(Color.WHITE);
		toolBar.setBackground(new Color(211, 211, 211));
		toolBar.setBounds(22, 0, 778, 49);
		/*frame.getContentPane().*/add(toolBar);
		

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
		JTabbedPane pane = new JTabbedPane(JTabbedPane.LEFT);
		pane.setBounds(22, 102, 719, 366);
		add(pane);
		
		JPanel ongletAppli = new JPanel();
		ongletAppli.setLayout(null);
		
		vectAppli = controller.ControllerDB.getApplicationArbre();
		modelAppli = new modelTableauApplication(vectAppli);
		tableAppli = new JTable(modelAppli);
		tableAppli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object source = arg0.getSource();
				if(tableAppli.getSelectedRow()!=-1){
					remplirApplication(tableAppli.getValueAt(tableAppli.getSelectedRow(),0).toString());
					System.out.println(tableAppli.getValueAt(tableAppli.getSelectedRow(),0).toString());
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
		
		ongletAppli.setPreferredSize(new Dimension(300, 80));
		ongletAppli.add(tableAppli);
		pane.addTab("Applications", ongletAppli);
		
		JPanel panelModifier = new JPanel();
		panelModifier.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelModifier.setBounds(152, 40, 138, 94);
		ongletAppli.add(panelModifier);
		panelModifier.setLayout(null);
		
		JLabel lblModifier = new JLabel("Modifier");
		lblModifier.setBounds(41, 6, 55, 17);
		lblModifier.setForeground(SystemColor.inactiveCaption);
		lblModifier.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panelModifier.add(lblModifier);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.text);
		separator.setForeground(SystemColor.menu);
		separator.setBounds(10, 22, 118, 8);
		panelModifier.add(separator);
		
		textFieldModifAppli = new JTextField();
		textFieldModifAppli.setBounds(9, 34, 118, 20);
		panelModifier.add(textFieldModifAppli);
		textFieldModifAppli.setColumns(10);
		btnModifier.setBounds(24, 60, 89, 23);
		panelModifier.add(btnModifier);
		

		lbIdModifAppli.setBounds(10, 69, 9, 14);
		lbIdModifAppli.setVisible(false);
		panelModifier.add(lbIdModifAppli);
		
		
		panelAjouter.setLayout(null);
		panelAjouter.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelAjouter.setBounds(152, 40, 138, 94);
		ongletAppli.add(panelAjouter);
		
		JLabel lblAjouter = new JLabel("Ajouter");
		lblAjouter.setForeground(SystemColor.inactiveCaption);
		lblAjouter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAjouter.setBounds(41, 6, 55, 17);
		panelAjouter.add(lblAjouter);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(10, 23, 118, 8);
		panelAjouter.add(separator_1);
		
		textFieldAjoutAppli = new JTextField();
		textFieldAjoutAppli.setBounds(9, 33, 118, 20);
		
		panelAjouter.add(textFieldAjoutAppli);
		textFieldAjoutAppli.setColumns(10);
		
		
		btnAjouterAppli.setBounds(24, 60, 89, 23);
		panelAjouter.add(btnAjouterAppli);
		
		
		btnNewAppli.setBounds(10, 185, 89, 23);
		ongletAppli.add(btnNewAppli);
		btnAffModifierAppli.setBounds(10, 185, 89, 23);
		
		ongletAppli.add(btnAffModifierAppli);
		
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
				
				appli.setNomApplication(textFieldModifAppli.getText());
				appli.setIdApplication(idAppliSelec);
				controller.ControllerDB.ModifApplication(appli);
				controller.gestionFenetre.eraseContainerPaneMainJFrame();
				controller.gestionFenetre.configurationModif(false);
				
				
			}
		}
	}
private void remplirApplication(String application){
		
		applicationArbre applicationArbre = ControllerDB.getApplicationArbre(application);
		textFieldModifAppli.setText(applicationArbre.getNomApplication());
		idAppliSelec=applicationArbre.getIdApplication();
		
	}
}


