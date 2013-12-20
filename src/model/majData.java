package model;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class majData {
 
	public static void MajApplication (application application){
		try{
			Statement stat = controller.ControllerDB.connectionDB().createStatement();
			
			String instructionSQL = "UPDATE application SET idApplication ='" 
			+ application.getIdApplication() +"', nomApplication ='"
			+ application.getNomApplication() +"'";
		}catch (SQLException aDO){
			JOptionPane.showMessageDialog(null, aDO, "Erreur Type", JOptionPane.ERROR_MESSAGE);
		}
	}
}
