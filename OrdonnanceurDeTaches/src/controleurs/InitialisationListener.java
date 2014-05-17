package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import modele.Ordonnanceur;

public class InitialisationListener implements ActionListener {

	private Ordonnanceur ord;
	
	public InitialisationListener(Ordonnanceur ord){
		this.ord = ord;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		ord.reInitialisation();
		ord.getBarreOutils().getTypeDeTri().setEnabled(true);
		ord.getBarreOutils().getTimerMoins().setEnabled(false);
		ord.getBarreOutils().getTimerPlus().setEnabled(false);
		ord.getBarreOutils().getNouvelleTache().setEnabled(true);
		ord.getBarreOutils().getDiagramme().setEnabled(false);
	}
}
