package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.Ordonnanceur;

public class DiagrammeBoutonListener implements ActionListener{

	Ordonnanceur ord;
	
	public DiagrammeBoutonListener(Ordonnanceur ord){
		this.ord = ord;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ord.dessineDiagramme();
	}

}
