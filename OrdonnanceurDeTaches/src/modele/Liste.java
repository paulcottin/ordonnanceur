package modele;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.omg.CORBA.portable.IndirectionException;

public class Liste {
	ArrayList<Tache> liste;
	ArrayList<Integer> fin;
	ArrayList<Integer> restant;
	int nbTachesFinies;

	public Liste(){
		liste = new ArrayList<Tache>();
		nbTachesFinies = 0;
	}

	//	Lit un fichier.
	public void lire(){
		try{
			BufferedReader buff = new BufferedReader(new FileReader(new File("data/donnees.txt")));
			try {
				String line;
				while ((line = buff.readLine()) != null) {
					String[] parts = line.split("#");
					int numero = Integer.parseInt(parts[0]);
					String intitule = (parts[1]);
					int arrivee = (Integer.parseInt(parts[2]));
					int duree = (Integer.parseInt(parts[3]));
					int priorite = (Integer.parseInt(parts[4]));
					liste.add(new Tache(numero, intitule, arrivee, duree, priorite));
				}
			} finally {
				buff.close();
			} 
		} catch (Exception e) {
			System.out.println("Erreur --" + e.toString());
		}
	}

	public void ecrire(){
		try{
			BufferedWriter buff = new BufferedWriter(new FileWriter(new File("data/donnees.txt")));
			String ligne;
			for (Tache t : liste) {
				ligne = String.valueOf(t.getNumero()) + "#" + t.getIntitule() + "#" + t.getArrivee() + "#" + t.getDuree() + "#" + t.getPriorite()+"\n";
				buff.write(ligne);
			}
			buff.close();
		} catch (Exception e) {
			System.out.println("Erreur d'écriture dans le fichier" + e.toString());
		}
	}

	/**
	 * On trie la liste par la m�thode fifo (premier arriv� - premier tri�)
	 */
	public void fifo(){
		boolean changement = true;
		while (changement) {
			changement = false;
			for (int i = 0; i < liste.size() -1; i++) {
				if (liste.get(i).getArrivee() > liste.get(i+1).getArrivee()) {
					Tache temp = liste.get(i+1);
					liste.set(i+1, liste.get(i));
					liste.set(i, temp);
					changement = true;
				}
				else if (liste.get(i).getArrivee() == liste.get(i+1).getArrivee()) {
					if (liste.get(i).getNumero() > liste.get(i+1).getNumero()) {
						Tache temp = liste.get(i+1);
						liste.set(i+1, liste.get(i));
						liste.set(i, temp);
						changement = true;
					}
				}
			}
		}
	}

	/**
	 * On trie la liste par la m�thode SJF
	 */
	public void sjf(){
		boolean changement = true;
		while (changement) {
			changement = false;
			for (int i = 0; i < liste.size() -1; i++) {
				if (liste.get(i).getDuree() > liste.get(i+1).getDuree()) {
					Tache temp = liste.get(i+1);
					liste.set(i+1, liste.get(i));
					liste.set(i, temp);
					changement = true;
				}
				else if (liste.get(i).getDuree() == liste.get(i+1).getDuree()) {
					if (liste.get(i).getNumero() > liste.get(i+1).getNumero()) {
						Tache temp = liste.get(i+1);
						liste.set(i+1, liste.get(i));
						liste.set(i, temp);
						changement = true;
					}
				}
			}
		}
	}

	/**
	 * On trie la liste par la m�thode rr
	 */
	public void rr(){

	}

	/**
	 * On trie la liste par la m�thode pr (on trie les taches par leur priorit�)
	 */
	public void pr(){
		boolean changement = true;
		while (changement) {
			changement = false;
			for (int i = 0; i < liste.size() -1; i++) {
				if (liste.get(i).getPriorite() < liste.get(i+1).getPriorite()) {
					Tache temp = liste.get(i+1);
					liste.set(i+1, liste.get(i));
					liste.set(i, temp);
					changement = true;
				}
				else if (liste.get(i).getPriorite() == liste.get(i+1).getPriorite()) {
					if (liste.get(i).getNumero() > liste.get(i+1).getNumero()) {
						Tache temp = liste.get(i+1);
						liste.set(i+1, liste.get(i));
						liste.set(i, temp);
						changement = true;
					}
				}
			}
		}
	}
	
	/**
	 * On trie la liste par la m�thode pfifo
	 */
	public void pfifo(){
		boolean changement = true;
		while (changement) {
			changement = false;
			for (int i = 0; i < liste.size() -1; i++) {
				if (liste.get(i).getArrivee() > liste.get(i+1).getArrivee()) {
					Tache temp = liste.get(i+1);
					liste.set(i+1, liste.get(i));
					liste.set(i, temp);
					changement = true;
				}
				else if (liste.get(i).getArrivee() == liste.get(i+1).getArrivee()) {
					if (liste.get(i).getPriorite() < liste.get(i+1).getPriorite()) {
						Tache temp = liste.get(i+1);
						liste.set(i+1, liste.get(i));
						liste.set(i, temp);
						changement = true;
					}
				}
			}
		}
	}
	
	/**
	 * On trie la liste par la m�thode sjf (les taches les plus courtes sont trait�es en priorit�)
	 */
	/*public void srt(){
		boolean changement = true;
		fin = new ArrayList<Integer>();
		restant = new ArrayList<Integer>();
		while (changement) {
			changement = false;
			for (int i = 0; i < liste.size() -1; i++) {
				fin.add(liste.get(i).getArrivee() + liste.get(i).getDuree());
				restant.add(fin.get(i) - liste.get(i).getArrivee());
				if (restant.get(i) > restant.get(i+1)) {
					Tache temp = liste.get(i+1);
					liste.set(i+1, liste.get(i));
					liste.set(i, temp);
					changement = true;
				}
				else if (restant.get(i) == restant.get(i+1)) {
					if (liste.get(i).getNumero() > liste.get(i+1).getNumero()) {
						Tache temp = liste.get(i+1);
						liste.set(i+1, liste.get(i));
						liste.set(i, temp);
						changement = true;
					}
				}
			}
		}
	}*/

	public void srt(){/* Boucle infinie !!!
		boolean changement = true;
		while (changement) {
			changement = false;
			for (int i = 0; i < liste.size() -1; i++) {
				if (liste.get(i).tempsRestant() > liste.get(i+1).tempsRestant()) {
					Tache temp = liste.get(i+1);
					liste.set(i+1, liste.get(i));
					liste.set(i, temp);
					changement = true;
				}
				
				else if (liste.get(i).getArrivee() == liste.get(i+1).getArrivee()) {
					if (liste.get(i).getNumero() > liste.get(i+1).getNumero()) {
						Tache temp = liste.get(i+1);
						liste.set(i+1, liste.get(i));
						liste.set(i, temp);
						changement = true;
					}
				}
			}
		}*/
	}
	
	public void miseAJour(){
		boolean traitement = true;
		int nbTachesFinies = 0;
		
		for (Tache t : liste) {
			//Le premier et qu'il n'a pas fini de la traitée on continue de la traiter
			if (liste.indexOf(t) == nbTachesFinies && t.tempsRestant() > 0) {
				t.setEtat(Tache.TRAITEMENT);
				t.setAvancement(t.getAvancement()+1);	//Incrémente le temps restant de la tâche
				traitement = true;
			}
			//Si le premier est fini de traité => mettre traitement à false
			else if (liste.indexOf(t) == nbTachesFinies && t.tempsRestant() == 0) {
				t.setEtat(Tache.TRAITE);
				traitement = false;
				nbTachesFinies++;
			}
			//Si il n'y a aucune tâche en traitement la mettre
			else if (!traitement) {
				t.setEtat(Tache.TRAITEMENT);
				traitement = true;
			}
			//System.out.println("Tâche n°"+liste.indexOf(t)+" temps restant : "+t.tempsRestant());
		}
	}
	
	public ArrayList<Tache> getListe() {
		return liste;
	}

	public void setListe(ArrayList<Tache> liste) {
		this.liste = liste;
	}
}
