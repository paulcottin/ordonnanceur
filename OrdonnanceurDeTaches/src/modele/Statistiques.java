package modele;

public class Statistiques {

	private int tempsMoyenSejour;
	private int tempsMoyenAttente;
	private int nbChangementContexte;
	private Ordonnanceur ord;
	
	public Statistiques(Ordonnanceur ord){
		this.tempsMoyenSejour = 0;
		this.tempsMoyenAttente = 0;
		this.nbChangementContexte = 0;
		this.ord = ord;
	}
	
	/**
	 * Calcul des statistiques
	 */
	public void calcul() {
		// voir http://fr.wikipedia.org/wiki/Th%C3%A9orie_des_files_d'attente
		int mu = 1;				//temps moyen de service
		int lambda = 2;			//fréquence moyenne d'arrivee 
		int A = lambda / mu;	//trafic offert

		this.tempsMoyenSejour = 1/mu * 1/(1-A);
		this.tempsMoyenAttente = 1/(mu * (1-A));
		this.nbChangementContexte++;//A modifier
	}

	/**
	 * Moyenne des durées
	 * @return : Le temps moyen de séjour (int)
	 */
	public int getTempsMoyenSejour() {
		int somme = 0;
		for (Tache t : ord.getListe().getListe()) {
			somme = somme + t.getDuree();
		}
		return (somme / ord.getListe().getListe().size());
	}

	public int getTempsMoyenAttente() {
		return tempsMoyenAttente;
	}

	public int getNbChangementContexte() {
		return nbChangementContexte;
	}

	public void setTempsMoyenSejour(int tempsMoyenSejour) {
		this.tempsMoyenSejour = tempsMoyenSejour;
	}

	public void setTempsMoyenAttente(int tempsMoyenAttente) {
		this.tempsMoyenAttente = tempsMoyenAttente;
	}

	public void setNbChangementContexte(int nbChangementContexte) {
		this.nbChangementContexte = nbChangementContexte;
	}
}
