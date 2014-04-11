package vues;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modele.Ordonnanceur;
import modele.Tache;
import controleurs.BoutonOKNouvelleTache;

public class Vue_NouvelleTache extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	
	private Ordonnanceur ord;
//	Elements graphiques
	private JLabel numeroLabel, arriveLabel, intituleLabel, dureeLabel, prioriteLabel;
	private JTextField intituleField = new JTextField(), dureeField = new JTextField();
	private JComboBox<String> prioriteComboBox = new JComboBox<String>(new String[]{"Basse", "Moyenne", "Haute"});
	private JButton okButton = new JButton("OK");
	
	public Vue_NouvelleTache(Ordonnanceur ord){
		super("Nouvelle Tâche");
		this.ord = ord;
		this.ord.addObserver(this);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.addMouseListener(new okButtonMouseListener());
		
		initialisation();
		
		this.setVisible(true);
	}
	
	private void initialisation() {
		numeroLabel = new JLabel("Numéro : " + Tache.compteur_numero);
		arriveLabel = new JLabel("Arrivée : " + Tache.compteur_arrivee);
		intituleLabel = new JLabel("Intitulé :");
		dureeLabel = new JLabel("Durée :");
		prioriteLabel = new JLabel("Priorité :");
		
		okButton.addActionListener(new BoutonOKNouvelleTache(this, ord));
		okButton.setEnabled(false);
		
		agencement();
	}

	public void agencement(){
		JPanel intitule = new JPanel();
			intitule.setLayout(new BorderLayout());
			intitule.add(intituleLabel, BorderLayout.NORTH);
			intitule.add(intituleField, BorderLayout.CENTER);
			
		JPanel duree = new JPanel();
			duree.setLayout(new BorderLayout());
			duree.add(dureeLabel, BorderLayout.NORTH);
			duree.add(dureeField, BorderLayout.CENTER);
			
		JPanel priorite = new JPanel();
			priorite.add(this.prioriteLabel);
			priorite.add(this.prioriteComboBox);
			
		JPanel grid = new JPanel();
			grid.setLayout(new GridLayout(2,2,10,0));
			grid.add(numeroLabel);
			grid.add(arriveLabel);
			grid.add(intitule);
			grid.add(duree);
			
		JPanel south = new JPanel();
			south.setLayout(new BorderLayout());
			south.add(priorite, BorderLayout.CENTER);
			JPanel okButtonPanel = new JPanel();
				okButtonPanel.add(okButton);
			south.add(okButtonPanel, BorderLayout.SOUTH);
			
		this.add(grid, BorderLayout.CENTER);
		this.add(south, BorderLayout.SOUTH);
	}

	boolean saisieValide(){
		if (intituleField.getText().equals("Intitulé") || dureeField.getText().equals("Durée")) {//Si rien n'a changé
			return false;
		}
		else if (intituleField.getText().equals("") || dureeField.getText().equals("")) {//Si les textes sont vides
			return false;
		}
		else if (!dureeField.getText().matches("[0-9]*")) {//Si ce n'est pas un chiffre
			return false;
		}
		return true;
	}
	
	public JButton getOkButton() {
		return okButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public JLabel getDureeLabel() {
		return dureeLabel;
	}

	public void setDureeLabel(JLabel dureeLabel) {
		this.dureeLabel = dureeLabel;
	}

	public JTextField getIntituleField() {
		return intituleField;
	}

	public void setIntituleField(JTextField intituleField) {
		this.intituleField = intituleField;
	}
	
	public int getDuree() {
		return Integer.valueOf(dureeField.getText());
	}

	public int getPriorite() {
		int prio = 1;
		switch (String.valueOf(prioriteComboBox.getSelectedItem())) {
		case "Basse":
			prio = 1;
			break;
		case "Normale":
			prio = 2;
			break;
		case "Haute":
			prio = 3;
			break;
		}
		return prio;
	}
	
	public String getIntitule() {
		return intituleField.getText();
	}

	class okButtonMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if (saisieValide()) {
				okButton.setEnabled(true);
			}
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

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
