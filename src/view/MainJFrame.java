package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class mainJFrame extends JFrame {

	private static JPanel contentPane;
	private Container cont;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainJFrame window = new mainJFrame();
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
	public mainJFrame() {
		/*frame = new JFrame();*/
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		cont=this.getContentPane();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder (5,5,5,5));
		contentPane.setLayout(new BorderLayout(0,0));
		cont.add(contentPane);
		
		//this.add(cont);
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void setContainerPanel (Component arg0){
		contentPane.add(arg0);
	}
	
	

}
