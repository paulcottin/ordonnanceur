package vues;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import controleurs.OuvrirListener;
import controleurs.QuitterListener;

public class Vue_Menu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenu fichier = new JMenu("Fichier");
		private JMenuItem ouvrir = new JMenuItem("Ouvrir");
		private JMenuItem quitter = new JMenuItem("Quitter");
	
	public Vue_Menu() {
		constructionMenu();
		this.add(fichier);
	}
	
	public void constructionMenu(){
		fichier.add(ouvrir);
		fichier.add(quitter);
		ajoutControleurs();
	}
	
	public void ajoutControleurs(){
		quitter.addActionListener(new QuitterListener());
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		ouvrir.addActionListener(new OuvrirListener());
		ouvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
	}

}
