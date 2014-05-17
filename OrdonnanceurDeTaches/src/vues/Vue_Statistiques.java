package vues;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Ordonnanceur;

public class Vue_Statistiques extends JPanel implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Ordonnanceur ord;
	JLabel tempsMoyenSejour;
	JLabel tempsMoyenAttente;
	JLabel nbChangementContexte;
	Color couleurFond = Color.gray;
	
	public Vue_Statistiques(Ordonnanceur ord){
		this.ord = ord;
		this.ord.addObserver(this);
		
		tempsMoyenSejour = new JLabel("Temps moyen de s\u00E9jour : "+String.valueOf(this.ord.getStats().getTempsMoyenSejour()).substring(0, 3));
		tempsMoyenAttente = new JLabel("Temps moyen d'attente : "+String.valueOf(this.ord.getStats().getTempsMoyenAttente()).substring(0, 3));
		nbChangementContexte = new JLabel("Nombre de changements de contexte : "+this.ord.getStats().getNbChangementContexte());
		JLabel espace1 = new JLabel(" ;  ");
		JLabel espace2 = new JLabel(" ;  ");
		
		this.add(tempsMoyenAttente);
		this.add(espace1);
		this.add(tempsMoyenSejour);
		this.add(espace2);
		this.add(nbChangementContexte);
		
		this.setBackground(couleurFond);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		tempsMoyenSejour.setText("Temps moyen de s\u00E9jour : "+String.valueOf(this.ord.getStats().getTempsMoyenSejour()).substring(0, 3));
		tempsMoyenAttente.setText("Temps moyen d'attente : "+String.valueOf(this.ord.getStats().getTempsMoyenAttente()).substring(0, 3));
		nbChangementContexte.setText("Nombre de changement de contexte : "+this.ord.getStats().getNbChangementContexte());
		
		this.revalidate();
	}

}
