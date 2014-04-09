package vues;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Ordonnanceur;

public class Vue_TotalTaches extends JPanel implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Ordonnanceur ord;
	
	private ArrayList<Vue_Tache> taches = new ArrayList<Vue_Tache>();
	
	public Vue_TotalTaches(Ordonnanceur ord){
		this.ord = ord;
		this.ord.addObserver(this);
		
		this.setLayout(new GridLayout(20,1,0,2));//Problème car on ne a un chiffre fixe max pour l'affichage des tâches
		setTitres();
		Vue_Tache tache = new Vue_Tache(ord,1, "Coucou", 2, 5, 2);
		taches.add(tache);
		Vue_Tache tache2 = new Vue_Tache(ord,2, "Coucou2", 3, 10, 1);
		taches.add(tache2);
		
		for (Vue_Tache t : taches) {
			this.add(t);
		}
	}

	public void setTitres(){
		JPanel titres = new JPanel();
		titres.setLayout(new GridLayout(1, 5));
		JLabel numeroLabel = new JLabel("Numéro"), 
				intituleLabel = new JLabel("Intitulé"), 
				arriveLabel = new JLabel("Arrivé"), 
				dureeLabel = new JLabel("Durée"), 
				prioriteLabel = new JLabel("Priorité");
		
		titres.add(numeroLabel);
		titres.add(intituleLabel);
		titres.add(arriveLabel);
		titres.add(dureeLabel);
		titres.add(prioriteLabel);
		titres.setBackground(Color.GRAY);
		
		this.add(titres);
	}
	
	public ArrayList<Vue_Tache> getTaches() {
		return taches;
	}

	public void setTaches(ArrayList<Vue_Tache> taches) {
		this.taches = taches;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
