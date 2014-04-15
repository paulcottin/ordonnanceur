package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.Ordonnanceur;

public class TimerListener implements ActionListener{

	Ordonnanceur ord;
	
	public TimerListener(Ordonnanceur ord){
		this.ord = ord;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.ord.incrementeTemps();
	}

}
