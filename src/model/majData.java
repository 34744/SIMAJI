package model;

import java.sql.SQLException;
import java.sql.Statement;
import controller.ControllerDB;
import javax.swing.JOptionPane;

public class majData {
 
	public static void MajApplication (application application){
		try{
			Statement stat = controller.ControllerDB.connectionDB().createStatement();
									 
			String instructionSQL="UPDATE application SET nomApplication='"
			+application.getNomApplication()+"', visibiliteApplication='"
			+application.getVisibiliteApplication()+ "' WHERE idApplication='" 
			+ application.getIdApplication()+"' ";
			int nbIns = stat.executeUpdate(instructionSQL);
			System.out.println("model");
			System.out.println(application.getIdApplication());
			System.out.println(application.getNomApplication());
		}catch (SQLException aDO){
			JOptionPane.showMessageDialog(null, aDO, "Erreur Type", JOptionPane.ERROR_MESSAGE);
		}
	}
}
