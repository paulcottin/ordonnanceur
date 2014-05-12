package modele;

public class Statistiques {

	private int tempsMoyenSejour;
	private int tempsMoyenAttente;
	private int nbChangementContexte;
	private int aSupprimerApres;
	
	public Statistiques(){
		this.tempsMoyenSejour = 0;
		this.tempsMoyenAttente = 0;
		this.nbChangementContexte = 0;
	}
	
	/**
	 * A MODIFIER
	 */
	public void calcul() {
		// voir http://fr.wikipedia.org/wiki/Th%C3%A9orie_des_files_d'attente
		int mu = 1;				//temps moyen de service
		int lambda = 1;			//fréquence moyenne d'arrivee 
		int A = lambda / mu;	//traffic offert

		this.tempsMoyenSejour = 1/mu * 1/(1-A);
		this.tempsMoyenAttente = 1/(mu * (1-A));
		this.nbChangementContexte++;//A modifier
	}

	public int getTempsMoyenSejour() {
		return tempsMoyenSejour;
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
