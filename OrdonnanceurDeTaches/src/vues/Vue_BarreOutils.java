package vues;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import modele.Liste;
import modele.Ordonnanceur;
import modele.Tache;
import controleurs.ChoixTriListener;
import controleurs.NouvelleTacheListener;
import controleurs.RechercheListener;
import controleurs.TimerListener;

public class Vue_BarreOutils extends JToolBar implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton nouvelleTache = new JButton("Nouvelle t\u00e2che");
	private JButton timer;
	private JLabel timerLabel;
	
	String[] choixTriItems = {"FIFO (First In First Out)", "SFJ (Shortest Job First)", "RR(q) (Round Robin(q))", "PR (Priority)"};
	private JComboBox<String> typeDeTri = new JComboBox<String>(choixTriItems);
	
	private JTextField recherche = new JTextField("Recherche");
	
	private Ordonnanceur ord;
	
	public Vue_BarreOutils(Ordonnanceur ord){
		this.ord = ord;
		ord.addObserver(this);
		
		timer = new JButton("+");
		timerLabel = new JLabel(String.valueOf(Tache.getCompteurArrivee()));
		
		nouvelleTache.addActionListener(new NouvelleTacheListener(this.ord));
		typeDeTri.addActionListener(new ChoixTriListener(this.ord));
		timer.addActionListener(new TimerListener(this.ord));
		recherche.addActionListener(new RechercheListener());
		recherche.addMouseListener(new rechercheMouseListener());
		
		setFloatable(false);
		
		this.add(nouvelleTache);
		this.addSeparator();
		this.add(typeDeTri);
		this.addSeparator();
		this.add(timer);
		this.add(timerLabel);
		this.addSeparator(new Dimension(75, getHeight()));
		this.add(recherche);
		
		
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		timerLabel.setText(String.valueOf(Tache.getCompteurArrivee()));
	}
	
	class rechercheMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			recherche.setText("");
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	public JComboBox<String> getTypeDeTri() {
		return typeDeTri;
	}

	public void setTypeDeTri(JComboBox<String> typeDeTri) {
		this.typeDeTri = typeDeTri;
	}

}
