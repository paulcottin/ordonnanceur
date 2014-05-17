package modele;

import java.util.ArrayList;
import java.util.HashMap;

public class Statistiques {

	private double tempsMoyenSejour;
	private double tempsMoyenAttente;
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
		HashMap<Integer, Integer> contexte = new HashMap<Integer, Integer>();
		double sommeSejour = 0.0000;
		double sommeAttente = 0.000;
		double tpsSejour = 0.000;
		double tpsAttente = 0.000;
		int tempsTotal = 0;
		for (Tache t : ord.getListe().getListe()) {
			tpsSejour = 0;
			tpsAttente = 0;
			for (int i = 0; i < ord.liste.getListe().indexOf(t)+1; i++) {
				tpsSejour = tpsSejour + ord.getListe().getListe().get(i).getDuree();
			}
			tpsSejour = tpsSejour - t.getArrivee();
			tpsAttente = tpsSejour - t.getDuree();
			tempsTotal = tempsTotal + t.getDuree();
			
			sommeAttente = sommeAttente + tpsAttente;
			sommeSejour = sommeSejour + tpsSejour;
		}
		
		for (int i = 0; i < tempsTotal; i++) {
			actualisationContexte(contexte);
			ord.incrementeTemps();
			ord.getListe().miseAJour();
			if (changementContexte(contexte, ord.getListe().getListe())) {
				nbChangementContexte++;
			}
		}
		ord.initialisation();
		ord.getBarreOutils().getTypeDeTri().setEnabled(true);
		ord.getBarreOutils().getTimerMoins().setEnabled(false);
		ord.getBarreOutils().getTimerPlus().setEnabled(false);
		ord.getBarreOutils().getNouvelleTache().setEnabled(true);
		
		tempsMoyenSejour = (sommeSejour / ord.getListe().getListe().size());
		tempsMoyenAttente = sommeAttente / ord.getListe().getListe().size();
	}
	
	boolean changementContexte(HashMap<Integer, Integer> contexte, ArrayList<Tache> liste){
		boolean rep = false;
		for (Tache t : liste) {
			if (contexte.get(t.getNumero()) != t.getEtat()) {
				return true;
			}
		}
		return rep;
	}
	
	void actualisationContexte(HashMap<Integer, Integer> contexte){
		for (Tache t : ord.getListe().getListe()) {
			contexte.put(t.getNumero(), t.getEtat());
		}
	}


	/**
	 * Moyenne des durées
	 * @return : Le temps moyen de séjour (int)
	 */
	public double getTempsMoyenSejour() {
		return tempsMoyenSejour;
	}

	public double getTempsMoyenAttente() {
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
