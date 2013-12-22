package controller;

import view.accueil;

public class gestionFenetre {

	public static void eraseContainerPaneMainJFrame(){
		view.mainJFrame.eraseContainerPanel();
		}
	
	public static void application (){
		view.Application appli = new view.Application();
		view.mainJFrame.setContainerPanel(appli);
		
	}
	
	public static void configuration (){
		view.Parametres config = new view.Parametres();
		view.mainJFrame.setContainerPanel(config);
		
	}
	
	public static void accueil (){
		view.accueil acc = new view.accueil();
		view.mainJFrame.setContainerPanel(acc);
		
	}
	
	
}
