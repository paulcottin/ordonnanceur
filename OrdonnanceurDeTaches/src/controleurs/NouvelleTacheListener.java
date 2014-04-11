package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vues.Vue_NouvelleTache;
import modele.Ordonnanceur;

public class NouvelleTacheListener implements ActionListener{

	private Ordonnanceur ord;
	
	public NouvelleTacheListener(Ordonnanceur ord){
		this.ord = ord;
	}
	
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		Vue_NouvelleTache vue = new Vue_NouvelleTache(ord);
	}

}
