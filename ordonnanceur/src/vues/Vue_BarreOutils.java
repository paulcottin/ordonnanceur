package vues;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import modele.Ordonnanceur;
import controleurs.ChoixTriListener;
import controleurs.NouvelleTacheListener;
import controleurs.RechercheListener;

public class Vue_BarreOutils extends JToolBar implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton nouvelleTache = new JButton("Nouvelle tâche");
	
	String[] choixTriItems = {"FIFO", "SFJ", "RR(q)", "PR"};
	private JComboBox<String> typeDeTri = new JComboBox<String>(choixTriItems);
	
	private JTextField recherche = new JTextField("Recherche");
	
	private Ordonnanceur ord;
	
	public Vue_BarreOutils(Ordonnanceur ord){
		this.ord = ord;
		ord.addObserver(this);
		nouvelleTache.addActionListener(new NouvelleTacheListener(this.ord));
		typeDeTri.addActionListener(new ChoixTriListener());
		recherche.addActionListener(new RechercheListener());
		recherche.addMouseListener(new rechercheMouseListener());
		
		this.add(nouvelleTache);
		this.addSeparator();
		this.add(typeDeTri);
		this.addSeparator(new Dimension(100, getHeight()));
		this.add(recherche);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
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

}
