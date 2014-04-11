package modele;

import java.util.Observable;

public class Ordonnanceur extends Observable{
	Liste liste;
	
	public Ordonnanceur() {
		liste = new Liste();
		liste.lire();
		Fenetre fen = new Fenetre(this);
	}
	
	public void nouvelleTache(String intitule, int duree, int priorite) {
		liste.getListe().add(new Tache(intitule, duree, priorite));
		
		// a supprimer
		for (Tache t : liste.getListe()) {
			System.out.println(t.getIntitule());
		}
		
		setChanged();
		notifyObservers();
	}

	public Liste getListe() {
		return liste;
	}

	public void setListe(Liste liste) {
		this.liste = liste;
	}

}
