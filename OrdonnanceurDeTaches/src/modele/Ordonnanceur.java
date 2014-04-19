package modele;

import java.util.Observable;

import vues.Vue_BarreOutils;
import vues.Vue_TotalTaches;

public class Ordonnanceur extends Observable{
	Liste liste;
	Vue_TotalTaches vues;
	Vue_BarreOutils barreOutils;
	
	@SuppressWarnings("unused")
	public Ordonnanceur() {
		liste = new Liste();
		liste.lire();
		vues = new Vue_TotalTaches(this);
		barreOutils = new Vue_BarreOutils(this);
		Fenetre fen = new Fenetre(this, vues, barreOutils);
	}
	
	public void nouvelleTache(String intitule, int duree, int priorite) {
		Tache t = new Tache(intitule, duree, priorite);
		liste.getListe().add(t);
		vues.ajouteTache(t);
		
		setChanged();
		notifyObservers();
	}
	
	public void fifo(){
		liste.fifo();
		setChanged();
		notifyObservers();
	}
	
	public void sjf(){
		liste.sjf();
		setChanged();
		notifyObservers();
	}
	
	public void rr(){
		liste.rr();
		setChanged();
		notifyObservers();
	}
	
	public void pr(){
		liste.pr();
		setChanged();
		notifyObservers();
	}
	
	public void pfifo(){
		liste.pfifo();
		setChanged();
		notifyObservers();
	}
	
	public void srt(){
		liste.srt();
		setChanged();
		notifyObservers();
	}

	public Liste getListe() {
		return liste;
	}

	public void setListe(Liste liste) {
		this.liste = liste;
	}

	public Vue_BarreOutils getBarreOutils() {
		return barreOutils;
	}

	public void setBarreOutils(Vue_BarreOutils barreOutils) {
		this.barreOutils = barreOutils;
	}

	public void incrementeTemps() {
		Tache.temps = Tache.temps +1;
		setChanged(); notifyObservers(barreOutils);
	}
	
	public void decrementeTemps(){
		if (Tache.temps > 0) {
			Tache.temps = Tache.temps -1;
		}
		setChanged(); notifyObservers();
	}

}
