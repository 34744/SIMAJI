package controller;

import view.accueil;

public class gestionFenetre {

	public static void eraseContainerPaneMainJFrame(){
		view.mainJFrame.eraseContainerPanel();
		}
	
	public static void application (){
		view.modificationApplication appli = new view.modificationApplication();
		view.mainJFrame.setContainerPanel(appli);
		
	}
	
	public static void accueil (){
		view.accueil acc = new view.accueil();
		view.mainJFrame.setContainerPanel(acc);
		
	}
	
	
}
