package views;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PopUpView {
	public void showInvalidInput(){
		JOptionPane.showMessageDialog(null, ViewValues.POP_UP_INVALID_IN);
	}
	public void showProducerName(){
		JOptionPane.showMessageDialog(null, ViewValues.PRODUCER_NAME);
	}
}
