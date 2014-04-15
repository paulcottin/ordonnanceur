package modele;

public class Tache {
	public static int compteur_numero = 1;
	private int numero;
	private String intitule;
	private int duree;
	private int priorite;
	private int arrivee;
	public static int compteur_arrivee = 0;
	
	public Tache(String intitule, int duree, int priorite){
		this.numero = compteur_numero;
		this.intitule = intitule;
		this.duree = duree;
		this.arrivee = compteur_arrivee;
		this.priorite = priorite;
		compteur_numero++;
		compteur_arrivee++;
	}
	
	public Tache(int numero, String intitule, int arrivee, int duree, int priorite){
		this.numero = numero;
		this.intitule = intitule;
		this.duree = duree;
		this.arrivee = arrivee;
		this.priorite = priorite;
		compteur_numero++;
		compteur_arrivee++;
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
	
}