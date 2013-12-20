package controller;

import java.sql.Connection;
import java.util.StringTokenizer;
import java.util.Vector;

import model.application;
import model.applicationArbre;
import model.getData;
import model.utilisateur;

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
			return model.getData.getApplicationTableau();
		}
	}
	

