package modele;

public class Tache {
	public static int ATTENTE = 0, TRAITEMENT = 1, TRAITE = 2;
	public static int compteur_numero = 1;
	private int numero;
	private String intitule;
	private int duree;
	private int priorite;
	private int arrivee;
	private int etat;
	private int avancement;
	public static int compteur_arrivee = 0;
	public static int temps = 0;
	
	public Tache(String intitule, int duree, int priorite){
		this.numero = compteur_numero;
		this.intitule = intitule;
		this.duree = duree;
		this.arrivee = compteur_arrivee;
		this.priorite = priorite;
		this.etat = ATTENTE; // Par défault une tâche crée est en attente.
		this.avancement = 0; //Au départ, la tâche n'a pas commencée à être exectutée
		compteur_numero++;
	}
	
	public Tache(int numero, String intitule, int arrivee, int duree, int priorite){
		this.numero = numero;
		this.intitule = intitule;
		this.duree = duree;
		this.arrivee = arrivee;
		this.priorite = priorite;
		this.etat = ATTENTE; // Par défault une tâche crée est en attente.
		this.avancement = 0;
		compteur_numero++;
	}
	
	public int tempsRestant(){
		
		return duree - avancement;
	}

	public static int getTemps(){
		return temps;
	}
	
	public int getCompteurNumero() {
		return compteur_numero;
	}

	public void setCompteurNumero(int compteur_numero) {
		Tache.compteur_numero = compteur_numero;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getPriorite() {
		return priorite;
	}

	public void setPriorite(int priorite) {
		this.priorite = priorite;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getArrivee() {
		return arrivee;
	}

	public void setArrivee(int arrivee) {
		this.arrivee = arrivee;
	}

	public static int getCompteurArrivee() {
		return compteur_arrivee;
	}

	public static void setCompteurArrivee(int compteur_arrivee) {
		Tache.compteur_arrivee = compteur_arrivee;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	public int getAvancement() {
		return avancement;
	}

	public void setAvancement(int avancement) {
		this.avancement = avancement;
	}
	
}