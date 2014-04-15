package modele;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import vues.Vue_Menu;
import vues.Vue_BarreOutils;
import vues.Vue_TotalTaches;

public class Fenetre extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel container = new JPanel();
	private JPanel menu = new JPanel();
	private Vue_TotalTaches vueTotalTaches;
	private Ordonnanceur ord;
	
	public Fenetre(Ordonnanceur ordonnanceur, Vue_TotalTaches vues, Vue_BarreOutils barreOutils) {
		super("Projet SD - Ordonnanceur de t\u00e2ches");
		this.ord = ordonnanceur;
		vueTotalTaches = vues;
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		
		container.setLayout(new BorderLayout());
		
		menu.setLayout(new BorderLayout());
		menu.add(new Vue_Menu(ord), BorderLayout.NORTH);
		menu.add(barreOutils , BorderLayout.CENTER);
		
		container.add(menu, BorderLayout.NORTH);
		container.add(vueTotalTaches, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(container);
		this.setVisible(true);
	}
}
