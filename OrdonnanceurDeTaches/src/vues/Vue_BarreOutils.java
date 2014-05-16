package vues;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import modele.Ordonnanceur;
import modele.Tache;
import controleurs.ChoixTriListener;
import controleurs.InitialisationListener;
import controleurs.NouvelleTacheListener;
import controleurs.TimerListener;

public class Vue_BarreOutils extends JToolBar implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton nouvelleTache = new JButton("Nouvelle t\u00e2che");
	private JButton timerPlus, timerMoins, initialisation;
	private JLabel timerLabel;
	
	String[] choixTriItems = {"Choix du tri", "FIFO (First In First Out)", "SFJ (Shortest Job First)", "RR(q) (Round Robin(q))", "PR (Priority)", "PFIFO (Preemptive First In First Out)", "SRT (Shortest Remaining Time)"};
	private JComboBox<String> typeDeTri = new JComboBox<String>(choixTriItems);
	
	
	private Ordonnanceur ord;
	
	public Vue_BarreOutils(Ordonnanceur ord){
		this.ord = ord;
		ord.addObserver(this);
		
		initialisation = new JButton("Réinitialiser");
		
		timerPlus = new JButton("Avance");
		timerLabel= new JLabel(String.valueOf(Tache.getTemps()));
		timerMoins = new JButton("-");
		timerMoins.setEnabled(false);
		timerPlus.setEnabled(false);
		
		nouvelleTache.addActionListener(new NouvelleTacheListener(this.ord));
		typeDeTri.addActionListener(new ChoixTriListener(this.ord));
		timerPlus.addActionListener(new TimerListener(this.ord));
		timerMoins.addActionListener(new TimerListener(this.ord));
		initialisation.addActionListener(new InitialisationListener(this.ord));
		
		setFloatable(false);
		
		this.add(nouvelleTache);
		this.addSeparator();
		this.add(typeDeTri);
		//this.addSeparator();
		//this.add(timerMoins);
		this.addSeparator();
		this.add(timerLabel);
		this.addSeparator();
		this.add(timerPlus);
		this.addSeparator();
		this.add(initialisation);
		
		
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		timerLabel.setText(String.valueOf(Tache.getTemps()));
	}
	

	public JComboBox<String> getTypeDeTri() {
		return typeDeTri;
	}

	public void setTypeDeTri(JComboBox<String> typeDeTri) {
		this.typeDeTri = typeDeTri;
	}

	public JButton getTimerPlus() {
		return timerPlus;
	}

	public void setTimerPlus(JButton timerPlus) {
		this.timerPlus = timerPlus;
	}

	public JButton getTimerMoins() {
		return timerMoins;
	}

	public void setTimerMoins(JButton timerMoins) {
		this.timerMoins = timerMoins;
	}

	public String[] getChoixTriItems() {
		return choixTriItems;
	}

	public void setChoixTriItems(String[] choixTriItems) {
		this.choixTriItems = choixTriItems;
	}

	public JButton getNouvelleTache() {
		return nouvelleTache;
	}

	public void setNouvelleTache(JButton nouvelleTache) {
		this.nouvelleTache = nouvelleTache;
	}

}
