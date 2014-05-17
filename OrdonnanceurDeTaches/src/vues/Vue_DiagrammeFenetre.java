package vues;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import modele.Ordonnanceur;
import modele.Tache;

public class Vue_DiagrammeFenetre extends JFrame implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Ordonnanceur ord;
	private ArrayList<Tache> liste;
	private JButton ok; 
	private JTextArea bloc;
	private JPanel container = new JPanel();
	
	public Vue_DiagrammeFenetre(Ordonnanceur ord){
		super("Diagramme d'ordonnancement");
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		container.setLayout(new BorderLayout());
		
		this.ord = ord;
		this.liste = ord.getListe().getListe();
		this.bloc = new JTextArea();
		this.ok = new JButton("OK");
		
		ok.addActionListener(new okButtonListener());
		
		dessine();
		
		this.setContentPane(container);
		container.add(bloc, BorderLayout.CENTER);
		container.add(ok, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	void dessine(){
		String ligne = "";
		String tab = "";
		int temps = 0;
		for (int i = 0; i < liste.size(); i++) {
			if (i != 0) {
				tab = tab+ "     ";
			}
			ligne = ligne +tab + liste.get(i).getNumero()+" - "+ liste.get(i).getIntitule() + " (" + (temps) + " -> " + (temps+liste.get(i).getDuree()) + ")\n";
			temps = temps + liste.get(i).getDuree();
		}
		bloc.setText(ligne);
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		dessine();
	}
	
	class okButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
		
	}

}
