package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import modele.Ordonnanceur;
import modele.Tache;

public class TimerListener implements ActionListener{

	Ordonnanceur ord;
	
	public TimerListener(Ordonnanceur ord){
		this.ord = ord;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(ord.getBarreOutils().getTimerPlus())) {
			this.ord.getBarreOutils().getTypeDeTri().setEnabled(false);	//A partir du moment où on touche au temps on ne touche plus aux tris
			this.ord.incrementeTemps();
		}
		else{
			this.ord.getBarreOutils().getTypeDeTri().setEnabled(false);
			this.ord.decrementeTemps();
		}
		ord.getListe().miseAJour();
	}
}
