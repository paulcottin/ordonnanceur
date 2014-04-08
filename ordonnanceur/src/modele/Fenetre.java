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
	private Vue_TotalTaches vueTotalTaches = new Vue_TotalTaches();
	
	public Fenetre() {
		super("Projet SD - Ordonnanceur de tâches");
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);
		
		container.setLayout(new BorderLayout());
		
		menu.setLayout(new BorderLayout());
		menu.add(new Vue_Menu(), BorderLayout.NORTH);
		menu.add(new Vue_BarreOutils(), BorderLayout.CENTER);
		
		container.add(menu, BorderLayout.NORTH);
		container.add(vueTotalTaches, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(container);
		this.setVisible(true);
	}
}
