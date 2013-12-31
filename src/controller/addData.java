package controller;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.application;

public class addData {
	public static void addApplication(application application) {
        try {
                Statement stat = controller.ControllerDB.connectionDB()
                                .createStatement();
                String instructionSQL = "INSERT INTO application (idApplication, nomApplication, visibiliteApplication)"
                                + " VALUES (NULL, '" 
                                + application.getNomApplication() 
                                + "','"
                                + application.getVisibiliteApplication()
                                + "')";
                int nbIns = stat.executeUpdate(instructionSQL);
               /* JOptionPane.showMessageDialog(null,
                                "L'enregistrement a bien été effectué", "Enregistrement",
                                JOptionPane.INFORMATION_MESSAGE);*/

        } catch (SQLException aDO) {
                JOptionPane.showMessageDialog(null, aDO, "Erreur Type",
                                JOptionPane.ERROR_MESSAGE);
        }
        
}

}
