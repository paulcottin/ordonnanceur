package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modele.Ordonnanceur;
import modele.Tache;

public class SupprimerTacheListener implements ActionListener{

	Ordonnanceur ord;
	
	public SupprimerTacheListener(Ordonnanceur ord){
		this.ord = ord;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String[] options = { "OK", "Annuler" };
		int reponse = JOptionPane.showOptionDialog(null, "Êtes-vous sûr de vouloir supprimer ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		switch (reponse) {
		case 0:
			int i = 0;
			while (e.getSource() != ord.getVues().getTaches().get(i).getSupprimer()) {
				i++;
			}
			ord.supprimerTache(i);
			//simule(Tache.temps);
			System.out.println("suppression de "+i);
			break;
		default:
			//Ne rien faire
			break;
		}
		ord.getVues().revalidate();
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
