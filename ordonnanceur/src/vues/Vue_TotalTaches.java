package vues;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Ordonnanceur;
import modele.Tache;

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
		
		rempliTache();
		afficheTache();
	}

	public void setTitres(){
		JPanel titres = new JPanel();
		titres.setLayout(new GridLayout(1, 5));
		JLabel numeroLabel = new JLabel("Numéro"), 
				intituleLabel = new JLabel("Intitulé"), 
				arriveLabel = new JLabel("Arrivée"), 
				dureeLabel = new JLabel("Durée"), 
				prioriteLabel = new JLabel("Priorité");
		
		titres.add(numeroLabel);
		titres.add(intituleLabel);
		titres.add(arriveLabel);
		titres.add(dureeLabel);
		titres.add(prioriteLabel);
		titres.setBackground(Color.LIGHT_GRAY);
		
		this.add(titres);
	}
	
	public void rempliTache(){
		for (Tache t : ord.getListe().getListe()) {
			this.taches.add(new Vue_Tache(ord, t.getNumero(), t.getIntitule(), t.getArrivee(), t.getDuree(), t.getPriorite()));
			
		}
	}
	
	public void afficheTache(){
	
		for (Vue_Tache t : taches) {
			this.add(t);
		}
		
	}
	
	public ArrayList<Vue_Tache> getTaches() {
		return taches;
	}

	public void setTaches(ArrayList<Vue_Tache> taches) {
		this.taches = taches;
	}

	public void update(Observable o, Object arg) {
		afficheTache();
	}
}
