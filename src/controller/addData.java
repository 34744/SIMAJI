package controller;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.application;
import model.utilisateur;

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
                                "L'enregistrement a bien �t� effectu�", "Enregistrement",
                                JOptionPane.INFORMATION_MESSAGE);*/

        } catch (SQLException aDO) {
                JOptionPane.showMessageDialog(null, aDO, "Erreur Type",
                                JOptionPane.ERROR_MESSAGE);
        }
        
}
	public static void addUtilisateur(utilisateur utilisateur) {
        try {
                Statement stat = controller.ControllerDB.connectionDB()
                                .createStatement();
                String instructionSQL = "INSERT INTO utilisateur (idUtilisateur, nomUtilisateur, prenomUtilisateur, numUlis, mailUtilisateur, utilisateurActif, directionUtilisateur)"
                                + " VALUES (NULL, '" 
                                + utilisateur.getNomUtilisateur()
                                + "','"
                                + utilisateur.getPrenomUtilisateur() 
                                + "','"
                                + utilisateur.getNumUlis()
                                + "','"
                                + utilisateur.getMailUtilisateur() 
                                + "','"
                                + utilisateur.getActifUtilisateur()
                                + "','"
                                + utilisateur.getUtilisateurDirection()
                                + "')";
                int nbIns = stat.executeUpdate(instructionSQL);
               /* JOptionPane.showMessageDialog(null,
                                "L'enregistrement a bien �t� effectu�", "Enregistrement",
                                JOptionPane.INFORMATION_MESSAGE);*/

        } catch (SQLException aDO) {
                JOptionPane.showMessageDialog(null, aDO, "Erreur Type",
                                JOptionPane.ERROR_MESSAGE);
        }
        
}
}
