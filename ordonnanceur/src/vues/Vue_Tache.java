package vues;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Vue_Tache extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel numeroLabel, intituleLabel, arriveLabel, dureeLabel, prioriteLabel;
	
	public Vue_Tache(int numero, String intitule, int arrive, int duree, int priorite){
		this.numeroLabel = new JLabel(String.valueOf(numero));
		this.intituleLabel = new JLabel(intitule);
		this.arriveLabel = new JLabel(String.valueOf(arrive));
		this.dureeLabel = new JLabel(String.valueOf(duree));
		switch (priorite) {
		case 1:
			prioriteLabel = new JLabel("Basse");
			break;
		case 2:
			prioriteLabel = new JLabel("Moyenne");
		case 3:
			prioriteLabel = new JLabel("Haute");
		default:
			prioriteLabel = new JLabel("--");
			break;
		}
	}

}
