package modele;

public class Statistiques {

	private int tempsMoyenSejour;
	private int tempsMoyenAttente;
	private int nbChangementContexte;
	
	public Statistiques(){
		this.tempsMoyenSejour = 0;
		this.tempsMoyenAttente = 0;
		this.nbChangementContexte = 0;
	}
	
	/**
	 * A MODIFIER
	 */
	public void calcul() {
		this.tempsMoyenSejour++;
		this.tempsMoyenAttente++;
		this.nbChangementContexte++;
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
