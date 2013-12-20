package view;
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Window.Type;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;


public class accueil extends JPanel {

	private JFrame frame;
	private JTable table;
	private JButton btnHome = new JButton("home");
	private JButton btnRapports = new JButton("rapports");
	private JButton btnSoftware = new JButton("software");
	private JButton btnConfig = new JButton("configuration");
	JButton btnUpdate = new JButton("update");

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					accueil window = new accueil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public accueil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/*frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.getContentPane().setBackground(new Color(176, 196, 222));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().*/setLayout(null);
		//frame.setVisible(true);
		

		btnHome.setToolTipText("Accueil");
		btnHome.setIcon(new ImageIcon(accueil.class.getResource("/icones/home.jpg")));
		btnHome.setBounds(41, 92, 109, 109);
		/*frame.getContentPane().*/add(btnHome);
		

		btnSoftware.setSelectedIcon(new ImageIcon(accueil.class.getResource("/icones/software.ico")));
		btnSoftware.setToolTipText("Applications");
		btnSoftware.setBackground(new Color(230, 230, 250));
		
		btnSoftware.setIcon(new ImageIcon(accueil.class.getResource("/icones/software.jpg")));
		btnSoftware.setBounds(191, 92, 109, 109);
		/*frame.getContentPane().*/add(btnSoftware);
		
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setToolTipText("Gestion des mises \u00E0 jour");
		btnUpdate.setSelectedIcon(new ImageIcon(accueil.class.getResource("/icones/update.jpg")));
		
		btnUpdate.setIcon(new ImageIcon(accueil.class.getResource("/icones/update.jpg")));
		btnUpdate.setBounds(343, 92, 109, 109);
		/*frame.getContentPane().*/add(btnUpdate);
		

		btnRapports.setToolTipText("Rapports");
		btnRapports.setIcon(new ImageIcon(accueil.class.getResource("/icones/rapports.jpg")));
		btnRapports.setBounds(491, 92, 109, 109);
		/*frame.getContentPane().*/add(btnRapports);
		
		btnConfig.setToolTipText("Param\u00E8tres");
		btnConfig.setIcon(new ImageIcon(accueil.class.getResource("/icones/configuration.png")));
		btnConfig.setBounds(641, 92, 109, 109);
		/*frame.getContentPane().*/add(btnConfig);
		
		table = new JTable();
		table.setBounds(41, 306, 709, 211);
		/*frame.getContentPane().*/add(table);
		
		JLabel lblMiseJour = new JLabel("Mise \u00E0 jour en attentes");
		lblMiseJour.setForeground(Color.WHITE);
		lblMiseJour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblMiseJour.setBounds(41, 260, 206, 46);
		/*frame.getContentPane().*/add(lblMiseJour);
		
		MyButtonListener list= new MyButtonListener();
		btnConfig.addActionListener(list);
		btnHome.addActionListener(list);
		btnSoftware.addActionListener(list);
		btnUpdate.addActionListener(list);
		btnRapports.addActionListener(list);
		
	}
	
	private class MyButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object source = e.getSource();
			
			if (source == btnSoftware){
				controller.gestionFenetre.application();
			//	frame.hide();
			}
		}
		
	}
	
	public void mainFrameHide(){
		frame.hide();
	}
}
