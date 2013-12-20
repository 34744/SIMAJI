package model;

import java.sql.Date;

public class compoCellule {

	private int idCellule, idUtilisateur;
	private Date dateDebutCellule, dateFinCellule;
	
	public compoCellule (){
		super();
		
	}
	
	public compoCellule (int idCellule, int idUtilisateur, Date dateDebutCellule, Date dateFinCellule){
		super();
		
		this.idCellule=idCellule;
		this.idUtilisateur=idUtilisateur;
		this.dateDebutCellule=dateDebutCellule;
		this.dateFinCellule=dateFinCellule;
				
	}

	public int getFkCellule() {
		return idCellule;
	}

	public void setFkCellule(int fkCellule) {
		this.idCellule = fkCellule;
	}

	public int getFkUtilisateur() {
		return idUtilisateur;
	}

	public void setFkUtilisateur(int fkUtilisateur) {
		this.idUtilisateur = fkUtilisateur;
	}

	public Date getDateDebutCellule() {
		return dateDebutCellule;
	}

	public void setDateDebutCellule(Date dateDebutCellule) {
		this.dateDebutCellule = dateDebutCellule;
	}

	public Date getDateFinCellule() {
		return dateFinCellule;
	}

	public void setDateFinCellule(Date dateFinCellule) {
		this.dateFinCellule = dateFinCellule;
	}
	
	
}
