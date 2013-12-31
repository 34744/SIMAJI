package controller;

import java.sql.Connection;
import java.util.StringTokenizer;
import java.util.Vector;

import view.Application;
import model.application;
import model.applicationArbre;
import model.getData;
import model.majData;
import model.utilisateur;
import model.utilisateurArbre;

	public class ControllerDB {
		public static Connection connectionDB() {
			return model.AccesDB.GetInstance();
			}
		
		public static void fermetureDB(){
			model.AccesDB.closeDB();
			}
		
		public static utilisateur getUser(String nom) {
			return getData.getUser(nom);        }
		
		public static Vector<application> getApplication(){
			return model.getData.getApplication();
		}
		
		public static Vector<applicationArbre> getApplicationArbre(){
			return model.getData.getApplicationArbre();
		}
		
		public static applicationArbre getApplicationArbre(String application){
			return model.getData.getApplicationArbre(application);
		}
		
		public static void ModifApplication(application application){
			majData.MajApplication(application);
		}
		
		public static Vector<utilisateur> getUtilisateur(){
			return model.getData.getUtilisateur();
		}
		
		public static Vector<utilisateurArbre> getUtilisateurArbre(){
			return model.getData.getUtilisateurArbre();
		}
		
		public static utilisateurArbre getUtilisateurArbre(String numUlis){

			return model.getData.getUtilisateurArbre(numUlis);
			
		}
	}
	

