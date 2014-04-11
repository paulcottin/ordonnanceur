package vues;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Ordonnanceur;

public class Vue_Tache extends JPanel implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Ordonnanceur ord; 
	private Color jade = new Color(135, 233, 144);
	private JLabel numeroLabel, intituleLabel, arriveLabel, dureeLabel, prioriteLabel;
	
	public Vue_Tache(Ordonnanceur ord,int numero, String intitule, int arrive, int duree, int priorite){
		this.ord = ord;
		this.ord.addObserver(this);
		this.numeroLabel = new JLabel(String.valueOf(numero));
		this.intituleLabel = new JLabel(intitule);
		this.arriveLabel = new JLabel(String.valueOf(arrive));
		this.dureeLabel = new JLabel(String.valueOf(duree));
		switch (priorite) {
		case 1:
			prioriteLabel = new JLabel("Basse");
			break;
		case 2:
			prioriteLabel = new JLabel("Moyenne");
			break;
		case 3:
			prioriteLabel = new JLabel("Haute");
			break;
		}
		
		this.setLayout(new GridLayout(1, 5));
		this.add(numeroLabel);
		this.add(intituleLabel);
		this.add(arriveLabel);
		this.add(dureeLabel);
		this.add(prioriteLabel);
		
		this.setBackground(jade);
		this.setPreferredSize(new Dimension(getWidth(), 20));
	}

	public Color getCouleur() {
		return jade;
	}

	public void setCouleur(Color couleur) {
		this.jade = couleur;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
