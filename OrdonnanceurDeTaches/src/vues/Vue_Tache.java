package vues;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleurs.ModifierTacheListener;
import controleurs.SupprimerTacheListener;

import modele.Ordonnanceur;
import modele.Tache;

public class Vue_Tache extends JPanel implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Ordonnanceur ord; 
	private Color couleurTacheAttente = new Color(135, 233, 144); //jade
	private Color couleurTacheTraitee = Color.gray;
	private Color couleurTacheTraitement = Color.white;
	private JLabel numeroLabel, intituleLabel, arriveLabel, dureeLabel, prioriteLabel, etatLabel;
	private JButton modifier, supprimer;
	private int index;
	
	public Vue_Tache(Ordonnanceur ord,int numero, String intitule, int arrive, int duree, int priorite, int etat, int index){
		this.ord = ord;
		this.ord.addObserver(this);
		this.index = index;
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
		
		switch (etat) {
		case 0:
			etatLabel = new JLabel("En attente");
			this.setBackground(couleurTacheAttente);
			break;
		case 1:
			etatLabel = new JLabel("Traitement...");
			this.setBackground(couleurTacheTraitement);
			break;
		case 2:
			etatLabel = new JLabel("Trait\u00E9e");
			this.setBackground(couleurTacheTraitee);
			break;
		default:
			break;
		}
		
		modifier = new JButton();
		try {
		    Image img = ImageIO.read(new File("data/modifier.gif"));
		    modifier.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
			  ex.printStackTrace();
		  }
		modifier.setContentAreaFilled(false);
		modifier.setBorderPainted(false);
		
		supprimer = new JButton();
		try {
		    Image img = ImageIO.read(new File("data/supprimer.png"));
		    supprimer.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
			  ex.printStackTrace();
		  }
		supprimer.setContentAreaFilled(false);
		supprimer.setBorderPainted(false);
		
		System.out.println("index à modifier : "+this.index);
		modifier.addActionListener(new ModifierTacheListener(ord, this.index));
		supprimer.addActionListener(new SupprimerTacheListener(ord));
		
		this.setLayout(new GridLayout(1, 8));
		this.add(numeroLabel);
		this.add(intituleLabel);
		this.add(arriveLabel);
		this.add(dureeLabel);
		this.add(prioriteLabel);
		this.add(etatLabel);
		this.add(modifier);
		this.add(supprimer);
		
		this.setPreferredSize(new Dimension(getWidth(), 20));
	}

	public Color getCouleurTacheAttente() {
		return couleurTacheAttente;
	}

	public void setCouleurTacheAttente(Color couleur) {
		this.couleurTacheAttente = couleur;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public Color getCouleurTacheTraitee() {
		return couleurTacheTraitee;
	}

	public void setCouleurTacheTraitee(Color couleurTacheTraitee) {
		this.couleurTacheTraitee = couleurTacheTraitee;
	}

	public Color getCouleurTacheTraitement() {
		return couleurTacheTraitement;
	}

	public void setCouleurTacheTraitement(Color couleurTacheTraitement) {
		this.couleurTacheTraitement = couleurTacheTraitement;
	}

	public JButton getModifier() {
		return modifier;
	}

	public JButton getSupprimer() {
		return supprimer;
	}

	public JLabel getNumeroLabel() {
		return numeroLabel;
	}

	public void setNumeroLabel(JLabel numeroLabel) {
		this.numeroLabel = numeroLabel;
	}

	public JLabel getArriveLabel() {
		return arriveLabel;
	}

	public void setArriveLabel(JLabel arriveLabel) {
		this.arriveLabel = arriveLabel;
	}

}
