package modele;

import java.util.Observable;

import vues.Vue_BarreOutils;
import vues.Vue_DiagrammeFenetre;
import vues.Vue_TotalTaches;

public class Ordonnanceur extends Observable{
	Liste liste;
	Vue_TotalTaches vues;
	Vue_BarreOutils barreOutils;
	Fenetre fen;
	Statistiques stats;
	Vue_DiagrammeFenetre diagrammeFenetre;
	
	/**
	 * Constructeur Ordonnanceur
	 * Crée une nouvelle liste et initialisation de celle-ci avec les données contenues dans le fichier /data/donnees.txt
	 * Initialisation des statistiques et interface graphique
	 */
	public Ordonnanceur() {
		liste = new Liste();
		liste.lire();
		liste.getListe().get(0).setAvancement(Tache.TRAITEMENT);
		vues = new Vue_TotalTaches(this);
		barreOutils = new Vue_BarreOutils(this);
		stats = new Statistiques(this);
		fen = new Fenetre(this, vues, barreOutils);
		
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Remise à zéro du temps, de l'état des tâches, du choix du tri
	 */
	public void reInitialisation(){
		Tache.setCompteurArrivee(0);
		Tache.temps = 0;
		barreOutils.getTypeDeTri().setEnabled(true);
		barreOutils.getTypeDeTri().setSelectedIndex(0);
		
		for (Tache t : liste.getListe()) {
			t.setEtat(Tache.ATTENTE);
			t.setAvancement(0);
		}
		stats.setNbChangementContexte(0);
		stats.setTempsMoyenAttente(0);
		stats.setTempsMoyenSejour(0);
		
		setChanged();
		notifyObservers();
	}
	
	public void initialisation(){
		Tache.setCompteurArrivee(0);
		Tache.temps = 0;
		
		for (Tache t : liste.getListe()) {
			t.setEtat(Tache.ATTENTE);
			t.setAvancement(0);
		}
		//liste.getListe().get(0).setEtat(Tache.TRAITEMENT);
		
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Calcul des statistiques
	 */
	public void calculStatistiques(){
		this.stats.calcul();
		
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Création d'une nouvelle tâche
	 * @param intitule : intitulé de la tâche
	 * @param duree : durée de la tâche
	 * @param priorite : priorité de la tâche (BASSE, MOYENNE, HAUTE)
	 */
	public void nouvelleTache(String intitule, int duree, int priorite) {
		Tache t = new Tache(intitule, duree, priorite);
		liste.getListe().add(t);
		vues.ajouteTache(t);
		setChanged();
		notifyObservers();
	}
	
	public void supprimerTache(int i){
		liste.getListe().remove(i);
		vues.getTaches().remove(vues.getTaches().size()-1);
		for (int j = 0; j < liste.getListe().size(); j++) {
			System.out.println(liste.getListe().get(j).getNumero());
		}
		System.out.println("----------");
		int cpt = 0;
		for (int j = 0; j < vues.getTaches().size(); j++) {
			cpt++;
		}
		System.out.println(cpt);
		vues.revalider();
		setChanged();
		notifyObservers();
	}
	/**
	 * politique de tri fifo
	 */
	public void fifo(){
		liste.fifo();
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Politique de tri SJF
	 */
	public void sjf(){
		liste.sjf();
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Politique de tri RR(q)
	 */
	public void rr(){
		liste.rr();
		setChanged();
		notifyObservers();
	}
	
	/**
	 *Politique de tri PR
	 */
	public void pr(){
		liste.pr();
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Politique de tri P_FIFO
	 */
	public void pfifo(){
		liste.pfifo();
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Politique de tri SRT
	 */
	public void srt(){
		liste.srt();
		setChanged();
		notifyObservers();
	}
	
	public void triParNumero(){
		liste.triParNumero();
		setChanged();
		notifyObservers();
	}
	
	@SuppressWarnings("unused")
	public void dessineDiagramme(){
		 diagrammeFenetre = new Vue_DiagrammeFenetre(this);
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

	/**
	 * Incrémente le temps
	 */
	public void incrementeTemps() {
		Tache.temps = Tache.temps +1;
		setChanged(); notifyObservers();
	}
	
	/**
	 * Décrémente le temps
	 */
	public void decrementeTemps(){
		if (Tache.temps > 0) {
			Tache.temps = Tache.temps -1;
			setChanged(); notifyObservers();
		}
	}

	public Statistiques getStats() {
		return stats;
	}

	public void setStats(Statistiques stats) {
		this.stats = stats;
	}

	public Vue_TotalTaches getVues() {
		return vues;
	}

	public Fenetre getFen() {
		return fen;
	}

	public Vue_DiagrammeFenetre getDiagrammeFenetre() {
		return diagrammeFenetre;
	}

}
