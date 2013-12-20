package controller;

import view.accueil;

public class gestionFenetre {

	public static void application (){
		view.modificationApplication appli = new view.modificationApplication();
		view.mainJFrame.setContainerPanel(appli);
		
	}
	
	
}
