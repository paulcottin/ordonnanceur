package modele;

import java.util.Observable;

import vues.Vue_BarreOutils;
import vues.Vue_TotalTaches;

public class Ordonnanceur extends Observable{
	Liste liste;
	Vue_TotalTaches vues;
	Vue_BarreOutils barreOutils;
	Fenetre fen;
	Statistiques stats;
	
	@SuppressWarnings("unused")
	public Ordonnanceur() {
		liste = new Liste();
		liste.lire();
		vues = new Vue_TotalTaches(this);
		barreOutils = new Vue_BarreOutils(this);
		stats = new Statistiques();
		fen = new Fenetre(this, vues, barreOutils);
	}
	
	public void initialisation(){
		Tache.setCompteurArrivee(0);
		Tache.temps = 0;
		barreOutils.getTypeDeTri().setEnabled(true);
		barreOutils.getTypeDeTri().setSelectedIndex(0);
		
		for (Tache t : liste.getListe()) {
			t.setEtat(Tache.ATTENTE);
		}
		liste.getListe().get(0).setEtat(Tache.TRAITEMENT);
		
		stats.setNbChangementContexte(0);
		stats.setTempsMoyenAttente(0);
		stats.setTempsMoyenSejour(0);
		
		setChanged();
		notifyObservers();
	}
	
	public void calculStatistiques(){
		this.stats.calcul();
		
		setChanged();
		notifyObservers();
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
			setChanged(); notifyObservers(barreOutils);
		}
	}

	public Statistiques getStats() {
		return stats;
	}

	public void setStats(Statistiques stats) {
		this.stats = stats;
	}

}
