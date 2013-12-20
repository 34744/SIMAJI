package model;

public class applicationArbre {

		private int IdApplication;
		private String NomApplication;
		
		public applicationArbre(){
			super();
		}
		
		public applicationArbre (int idApplication, String nomApplication){
			super();
			IdApplication=idApplication;
			NomApplication=nomApplication;
		}

		public int getIdApplication() {
			return IdApplication;
		}

		public void setIdApplication(int idApplication) {
			IdApplication = idApplication;
		}

		public String getNomApplication() {
			return NomApplication;
		}

		public void setNomApplication(String nomApplication) {
			NomApplication = nomApplication;
		}
		
		
}
