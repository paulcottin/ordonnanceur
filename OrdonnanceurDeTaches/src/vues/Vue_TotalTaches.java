package vues;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Scrollable;

import modele.Ordonnanceur;
import modele.Tache;

/**
 * 
 * @author paul
 *	Regarder la classe Jlist pour modifier celle ci
 */
public class Vue_TotalTaches extends JPanel implements Observer, Scrollable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Ordonnanceur ord;
	private Color backgroundColor = new Color(76, 166, 107);
	
	private ArrayList<Vue_Tache> taches = new ArrayList<Vue_Tache>();
	//private JList<Vue_Tache> taches = new JList<Vue_Tache>();
	public Vue_TotalTaches(Ordonnanceur ord){
		this.ord = ord;
		this.ord.addObserver(this);
		
		this.setLayout(new GridLayout(20,1,0,2));//Probl�me car on ne a un chiffre fixe max pour l'affichage des t�ches
		//this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)); // Grosses lignes qui diminuent en fonction du nb
		
		setTitres();
		
		rempliTache();
		afficheTache();
	}

	public void setTitres(){
		
		JPanel titres = new JPanel();
		titres.setLayout(new GridLayout(1, 5));
		JLabel numeroLabel = new JLabel("Num\u00E9ro"), 
				intituleLabel = new JLabel("Intitul\u00E9"), 
				arriveLabel = new JLabel("Arriv\u00E9e"), 
				dureeLabel = new JLabel("Dur\u00E9e"), 
				prioriteLabel = new JLabel("Priorit\u00E9");
		
		titres.add(numeroLabel);
		titres.add(intituleLabel);
		titres.add(arriveLabel);
		titres.add(dureeLabel);
		titres.add(prioriteLabel);
		titres.setBackground(backgroundColor);
		
		this.add(titres);
	}
	
	public void rempliTache(){
		for (Tache t : ord.getListe().getListe()) {
			this.taches.add(new Vue_Tache(ord, t.getNumero(), t.getIntitule(), t.getArrivee(), t.getDuree(), t.getPriorite()));
		}
	}
	
	public void afficheTache(){
		for (Vue_Tache t : taches) {
			this.add(t);
		}	
		/*for (int i = 0; i < taches.getSize().height; i++) {
			this.add(taches);
		}*/
	}
	
	public void ajouteTache(Tache t){
		taches.add(new Vue_Tache(ord, t.getNumero(), t.getIntitule(), t.getArrivee(), t.getDuree(), t.getPriorite()));
	}
	
	public ArrayList<Vue_Tache> getTaches() {
		return taches;
	}

	public void setTaches(ArrayList<Vue_Tache> taches) {
		this.taches = taches;
	}
	

	public void update(Observable o, Object arg) {
		
		if (this.getComponentCount() > taches.size()) {
			this.remove(taches.size());
		}
		for (int i = taches.size()-1; i >0; i--) {
			taches.remove(i);
			this.remove(i);
		}
		/*for (int i = taches.getSize().height-1; i > 0; i--) {
			taches.remove(i);
			this.remove(i);
		} essai avec JList*/
		taches.remove(0);
		
		this.revalidate();
		rempliTache();
		afficheTache();
		this.revalidate();
	}

	@Override
	public Dimension getPreferredScrollableViewportSize() {
		// TODO Auto-generated method stub
		return new Dimension(600, 600);
	}

	@Override
	public int getScrollableBlockIncrement(Rectangle visibleRect,
			int orientation, int direction) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getScrollableTracksViewportHeight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getScrollableTracksViewportWidth() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getScrollableUnitIncrement(Rectangle visibleRect,
			int orientation, int direction) {
		// TODO Auto-generated method stub
		return 0;
	}
}
