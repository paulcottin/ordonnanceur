package modele;

import java.util.Observable;

import vues.Vue_NouvelleTache;

public class Ordonnanceur extends Observable{
	
	public Ordonnanceur() {
		Fenetre fen = new Fenetre(this);
	}
	
	public void nouvelleTache(String intitule, int duree, int priorite) {
		
	}

}
