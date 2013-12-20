package view;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;

import model.modelTableauApplication;
public class modificationApplication extends JPanel{

	private JFrame frame;
	private JTable table;
	private Vector<model.applicationArbre> vectAppli = new Vector<model.applicationArbre>();
	private modelTableauApplication modelAppli;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modificationApplication window = new modificationApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 */
	public modificationApplication () {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		//frame = new JFrame();
		//frame.setType(Type.UTILITY);
		/*frame.getContentPane().*/setBackground(new Color(176, 196, 222));
		
		vectAppli = controller.ControllerDB.getApplicationArbre();
		
		modelAppli = new modelTableauApplication(vectAppli);
		/*frame.getContentPane().*/setLayout(null);
		table = new JTable(modelAppli);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(true);
		table.setToolTipText("S\u00E9lectionnez l'application d\u00E9sir\u00E9e");
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
		table.setForeground(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setBackground(new Color(211, 211, 211));
		table.setBounds(10, 53, 153, 476);
		/*frame.getContentPane().*/add(table);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.setForeground(Color.WHITE);
		toolBar.setBackground(new Color(211, 211, 211));
		toolBar.setBounds(10, 1, 794, 41);
		/*frame.getContentPane().*/add(toolBar);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(modificationApplication.class.getResource("/icones/home41.jpg")));
		btnNewButton.setSelectedIcon(new ImageIcon(modificationApplication.class.getResource("/icones/home.jpg")));
		toolBar.add(btnNewButton);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(modificationApplication.class.getResource("/icones/software41.jpg")));
		toolBar.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(modificationApplication.class.getResource("/icones/update41.jpg")));
		toolBar.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(modificationApplication.class.getResource("/icones/rapports41.jpg")));
		toolBar.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(modificationApplication.class.getResource("/icones/configuration41.jpg")));
		toolBar.add(button_3);
		//frame.setBounds(100, 100, 822, 574);
		
		//frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
