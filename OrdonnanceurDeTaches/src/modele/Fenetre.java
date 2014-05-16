package modele;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import vues.Vue_Menu;
import vues.Vue_BarreOutils;
import vues.Vue_Statistiques;
import vues.Vue_TotalTaches;

public class Fenetre extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel container = new JPanel();
	private JPanel menu = new JPanel();
	private Vue_TotalTaches vueTotalTaches;
	private Vue_BarreOutils barreOutils;
	private Vue_Statistiques statistiques;
	private Ordonnanceur ord;
	
	public Fenetre(Ordonnanceur ordonnanceur, Vue_TotalTaches vues, Vue_BarreOutils barreOutils) {
		super("Projet SD - Ordonnanceur de t\u00e2ches");
		this.ord = ordonnanceur;
		this.vueTotalTaches = vues;
		this.barreOutils = barreOutils;
		this.statistiques = new Vue_Statistiques(ord);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		
		container.setLayout(new BorderLayout());
		
		menu.setLayout(new BorderLayout());
		//menu.add(new Vue_Menu(ord), BorderLayout.NORTH);
		menu.add(this.barreOutils, BorderLayout.CENTER);
		
		container.add(menu, BorderLayout.NORTH);
		container.add(vueTotalTaches, BorderLayout.CENTER);
		container.add(statistiques, BorderLayout.SOUTH);
		
		this.addWindowListener(new FermetureListener());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(container);
		this.setVisible(true);
	}

	public Vue_TotalTaches getVueTotalTaches() {
		return vueTotalTaches;
	}

	public void setVueTotalTaches(Vue_TotalTaches vueTotalTaches) {
		this.vueTotalTaches = vueTotalTaches;
	}

	public JPanel getMenu() {
		return menu;
	}

	public void setMenu(JPanel menu) {
		this.menu = menu;
	}

	public Ordonnanceur getOrd() {
		return ord;
	}

	public void setOrd(Ordonnanceur ord) {
		this.ord = ord;
	}

	public Vue_BarreOutils getBarreOutils() {
		return barreOutils;
	}

	public void setBarreOutils(Vue_BarreOutils barreOutils) {
		this.barreOutils = barreOutils;
	}
	
	class FermetureListener implements WindowListener{

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			ord.getListe().ecrire();
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
