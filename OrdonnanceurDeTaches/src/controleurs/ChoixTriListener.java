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
		else if (ord.getBarreOutils().getTypeDeTri().getSelectedItem().equals("SFJ (Shortest Job First)")) {
			System.out.println("coucou");
			ord.sjf();
		}
		else if (ord.getBarreOutils().getTypeDeTri().getSelectedItem().equals("RR(q) (Round Robin(q))")) {
			ord.rr();
		}
		else if (ord.getBarreOutils().getTypeDeTri().getSelectedItem().equals("PR (Priority)")) {
			ord.pr();
		}
	}

}
