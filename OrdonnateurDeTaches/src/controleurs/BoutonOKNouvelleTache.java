package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.Ordonnanceur;
import vues.Vue_NouvelleTache;

public class BoutonOKNouvelleTache implements ActionListener{

	Ordonnanceur ord;
	Vue_NouvelleTache nvleTache;
	JButton okButton;
	
	public BoutonOKNouvelleTache(Vue_NouvelleTache nvleTache, Ordonnanceur ord){
		this.ord = ord;
		this.nvleTache = nvleTache;
		this.okButton = this.nvleTache.getOkButton();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ord.nouvelleTache(nvleTache.getIntitule(), nvleTache.getDuree(), nvleTache.getPriorite());
		this.nvleTache.dispose();//Pour fermer la fenêtre
	}

}
