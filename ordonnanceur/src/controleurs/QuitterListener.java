package controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitterListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}

}
