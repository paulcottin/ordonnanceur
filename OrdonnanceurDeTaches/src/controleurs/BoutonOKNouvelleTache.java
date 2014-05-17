package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modele.Ordonnanceur;
import modele.Tache;
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
		simule(Tache.temps);
		this.nvleTache.dispose();//Pour fermer la fen�tre
	}
	
	void simule(int temps){
		int choixTri = ord.getBarreOutils().getTypeDeTri().getSelectedIndex();
		ord.reInitialisation();
		for (int i = 0; i < temps; i++) {
			ord.incrementeTemps();
			ord.getListe().miseAJour();
		}
		ord.getBarreOutils().getTypeDeTri().setSelectedIndex(choixTri);
	}

}
