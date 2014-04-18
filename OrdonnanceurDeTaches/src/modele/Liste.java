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

	public Liste(){
		liste = new ArrayList<Tache>();
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
				ligne = String.valueOf(t.getNumero()) + "#" + t.getIntitule() + "#" + t.getArrivee() + "#" + t.getDuree() + "#" + t.getPriorite();
				buff.write(ligne);
			}
			buff.close();
		} catch (Exception e) {
			System.out.println("Erreur --" + e.toString());
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

	public void srt(){
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
				/* Quel crit�re suivant de tri ? */
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
	
	public void miseAJour(){
		int i = 0;
		int indiceTacheEnTraitement = 0;
		for (Tache t : liste) {
			if (t.getEtat() == Tache.TRAITEMENT) {
				indiceTacheEnTraitement = i;
				System.out.println("indice traitement : "+indiceTacheEnTraitement);
			}
			if (t.tempsRestant() > 0) {
				t.setEtat(Tache.ATTENTE);
			}else {
				t.setEtat(Tache.TRAITE);
			}
			i++;
		}
		i = 0;
		boolean fini = true;
		while (i+1 < liste.size() && liste.get(i).getEtat() != Tache.TRAITE && liste.get(i).getEtat() != Tache.TRAITEMENT) {
			if (liste.get(i).tempsRestant() > 0) {
				fini = false;
			}
			i++;
		}
		if (!fini) {
			liste.get(i).setEtat(Tache.TRAITEMENT);
			liste.get(indiceTacheEnTraitement).setEtat(Tache.TRAITE);
		}
	}
	

	public ArrayList<Tache> getListe() {
		return liste;
	}

	public void setListe(ArrayList<Tache> liste) {
		this.liste = liste;
	}
}
