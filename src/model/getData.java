package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class getData {

	public static utilisateur getUser(String nom) {
		utilisateur user = new utilisateur();
		try {
			Statement stat = controller.ControllerDB.connectionDB().createStatement();
			String requeteSQL = "SELECT * FROM Utilisateur WHERE codeUser = '"+ nom + "'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			while (donnees.next()) {
				user.setNumUlis(donnees.getString("numUlis"));
				user.setNomUtilisateur(donnees.getString("nomUser"));
				user.setPrenomUtilisateur(donnees.getString("prenomUser"));
				user.setIdUtilisateur(donnees.getInt("idUser"));
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e, "ERREUR",JOptionPane.ERROR_MESSAGE);
				}
		return user;
		}
	
	public static Vector<marche> getMarche(){
		Vector<model.marche> v = new Vector<model.marche>();
		
		try{
			Statement stat=controller.ControllerDB.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM marche ORDER BY nomMarche";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while (donnees.next()){
				System.out.print(donnees.getString("nomMarche"));
				v.addElement(new marche(donnees.getInt("idMarche"),
						donnees.getString("nomMarche")));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e, "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<application> getApplication(){
		Vector<model.application> v = new Vector<model.application>();
		
		try{
			Statement stat=controller.ControllerDB.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM application ORDER BY visibiliteApplication, nomApplication";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while (donnees.next()){
				System.out.print(donnees.getString("nomApplication"));
				v.addElement(new application(donnees.getInt("idApplication"),
						donnees.getString("nomApplication"),
						donnees.getString("visibiliteApplication")));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e, "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<applicationArbre> getApplicationArbre(){
		Vector<model.applicationArbre> v = new Vector<model.applicationArbre>();
		
		try{
			Statement stat = controller.ControllerDB.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM application ORDER BY visibiliteApplication, nomApplication";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.addElement(new applicationArbre(donnees.getInt("IdApplication"),
												  donnees.getString("nomApplication"),
												  donnees.getString("visibiliteApplication")));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static applicationArbre getApplicationArbre(String application){
		model.applicationArbre v = new model.applicationArbre();
		
		try{
			Statement stat = controller.ControllerDB.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM application WHERE nomApplication = '" + application +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.setIdApplication(donnees.getInt("IdApplication"));
				v.setNomApplication(donnees.getString("nomApplication"));
				v.setVisibiliteApplication(donnees.getString("visibiliteApplication"));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<utilisateur> getUtilisateur(){
		Vector<model.utilisateur> v = new Vector<model.utilisateur>();
		
		try{
			Statement stat = controller.ControllerDB.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM utilisateur ORDER BY nomUtilisateur";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.addElement(new utilisateur(donnees.getInt("IdUtilisateur"),
												  donnees.getString("nomUtilisateur"),
												  donnees.getString("prenomUtilisateur"),
												  donnees.getString("numUlis"),
												  donnees.getString("mailUtilisateur")
												  ));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<utilisateurArbre> getUtilisateurArbre(){
		Vector<model.utilisateurArbre> v = new Vector<model.utilisateurArbre>();
		
		try{
			Statement stat = controller.ControllerDB.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM utilisateur ORDER BY nomUtilisateur";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.addElement(new utilisateurArbre(donnees.getInt("idUtilisateur"),
												  donnees.getString("nomUtilisateur"),
												  donnees.getString("prenomUtilisateur"),
												  donnees.getString("numUlis"),
												  donnees.getString("mailUtilisateur")
												  ));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static utilisateurArbre getUtilisateurArbre(String numUlis){
		model.utilisateurArbre v = new model.utilisateurArbre();

		try{
			Statement stat = controller.ControllerDB.connectionDB().createStatement();

			String requeteSQL = "SELECT * FROM utilisateur WHERE numUlis = '" + numUlis +"'";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				v.setIdUtilisateur(donnees.getInt("idUtilisateur"));
				v.setNomUtilisateur(donnees.getString("nomUtilisateur"));
				v.setPrenomUtilisateur(donnees.getString("prenomUtilisateur"));
				v.setNumUlis(donnees.getString("numUlis"));
				v.setMailUtilisateur(donnees.getString("mailUtilisateur"));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e,"ERREUR",JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
	
	public static Vector<cellule> getCellule(){
		Vector<model.cellule> v = new Vector<model.cellule>();
		
		try{
			Statement stat=controller.ControllerDB.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM cellule ORDER BY nomCellule";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while (donnees.next()){
				System.out.print(donnees.getString("nomCellule"));
				v.addElement(new cellule(donnees.getInt("idCellule"),
						donnees.getString("nomCellule")));
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e, "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}

	public static Vector<compoCellule> getCompoCellule(){
		Vector<model.compoCellule> v = new Vector<model.compoCellule>();
		
		try{
			Statement stat = controller.ControllerDB.connectionDB().createStatement();
			
			String requeteSQL = "SELECT * FROM `compocellule`, cellule, utilisateur where compocellule.idUtilisateur = utilisateur.idUtilisateur and compocellule.idCellule = cellule.idCellule";
			ResultSet donnees = stat.executeQuery(requeteSQL);
			ResultSetMetaData metadata = donnees.getMetaData();
			
			while(donnees.next()){
				
				v.addElement(new compoCellule(donnees.getInt("idCellule"),
						donnees.getInt("idUtilisateur"),
						donnees.getDate("dateDebutCellule"),
						donnees.getDate("dateFinCellule")));
			}
			
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, e,"Erreur", JOptionPane.ERROR_MESSAGE);
		}
		return v;
	}
}
