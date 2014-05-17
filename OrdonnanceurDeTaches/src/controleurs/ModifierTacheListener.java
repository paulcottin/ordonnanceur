package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modele.Ordonnanceur;
import modele.Tache;

import vues.Vue_NouvelleTache;

public class ModifierTacheListener implements ActionListener{

	Ordonnanceur ord;
	int index;
	
	public ModifierTacheListener(Ordonnanceur ord, int i){
		this.ord = ord;
		this.index = i;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Vue_NouvelleTache nouvelle = new Vue_NouvelleTache(ord);
		nouvelle.setDureeField(String.valueOf(ord.getListe().getListe().get(index).getDuree()));
		nouvelle.setIntituleField(ord.getListe().getListe().get(index).getIntitule());
		nouvelle.setNumeroLabel("Num\u00E9ro : " + ord.getListe().getListe().get(index).getNumero());
		nouvelle.setArriveLabel("Arriv\u00E9e : " + ord.getListe().getListe().get(index).getArrivee());
		nouvelle.setPrioriteComboBox(ord.getListe().getListe().get(index).getPriorite());
	}

}
