package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			this.ord.incrementeTemps();
		}
		else{
			this.ord.decrementeTemps();
		}
		ord.getListe().miseAJour();
	}

}
