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
		
		tempsMoyenSejour = new JLabel("Temps moyen s\u00E9jour : "+this.ord.getStats().getTempsMoyenSejour());
		tempsMoyenAttente = new JLabel("Temps moyen attente : "+this.ord.getStats().getTempsMoyenAttente());
		nbChangementContexte = new JLabel("Nombre de changements de contexte : "+this.ord.getStats().getNbChangementContexte());
		JLabel espace1 = new JLabel(";  ");
		JLabel espace2 = new JLabel(";  ");
		
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
		tempsMoyenSejour.setText("tps moyen séjour : "+this.ord.getStats().getTempsMoyenSejour());
		tempsMoyenAttente.setText("tps moyen attente : "+this.ord.getStats().getTempsMoyenAttente());
		nbChangementContexte.setText("nb de changement de contexte : "+this.ord.getStats().getNbChangementContexte());
		
		this.revalidate();
	}

}
