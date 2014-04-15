package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.Ordonnanceur;

public class ChoixTriListener implements ActionListener{

	Ordonnanceur ord;
	
	public ChoixTriListener(Ordonnanceur ord){
		this.ord = ord;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (ord.getBarreOutils().getTypeDeTri().getSelectedItem().equals("FIFO (First In First Out)")) {
			ord.fifo();
		}
	}

}
