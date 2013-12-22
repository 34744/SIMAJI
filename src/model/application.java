package model;

public class application {

	private int idApplication;
	private String nomApplication;
	
	public application (int idApplication, String nomApplication){
		super();
		this.idApplication=idApplication;
		this.nomApplication=nomApplication;
	}

	public application() {
		// TODO Auto-generated constructor stub
	super();
	}

	public int getIdApplication() {
		return idApplication;
	}

	public void setIdApplication(int idApplication) {
		this.idApplication = idApplication;
	}

	public String getNomApplication() {
		return nomApplication;
	}

	public void setNomApplication(String nomApplication) {
		this.nomApplication = nomApplication;
	}
	
	
}
