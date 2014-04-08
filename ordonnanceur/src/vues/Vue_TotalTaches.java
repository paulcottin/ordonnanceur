package vues;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Vue_TotalTaches extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Vue_Tache> taches = new ArrayList<Vue_Tache>();
	
	public Vue_TotalTaches(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Vue_Tache tache = new Vue_Tache(1, "Coucou", 2, 5, 2);
		taches.add(tache);
		
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

}
