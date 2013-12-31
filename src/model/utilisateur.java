package model;

public class utilisateur {
	private String nomUtilisateur, prenomUtilisateur, mailUtilisateur, numUlis;
	private int idUtilisateur;
	public utilisateur(int idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String numUlis, String mailUtilisateur) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.numUlis=numUlis;
		this.mailUtilisateur = mailUtilisateur;
		}
	
	public String getNumUlis() {
		return numUlis;
	}

	public void setNumUlis(String numUlis) {
		this.numUlis = numUlis;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getMailUtilisateur() {
		return mailUtilisateur;
	}

	public void setMailUtilisateur(String mailUtilisateur) {
		this.mailUtilisateur = mailUtilisateur;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public utilisateur() {
		super();
		}
	
	
	} 
