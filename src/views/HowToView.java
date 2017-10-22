package views;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import views.panels.HowToControllerPane;
import views.panels.HowToCreatorPane;

public class HowToView {
	private JFrame frame = new JFrame(ViewValues.MENU_HOW_TO);
	
	public void initFrame(){
		JTabbedPane tabPane = new JTabbedPane();
		tabPane.add(ViewValues.CONTROL_PANE_TITLE, new HowToControllerPane());
		tabPane.add(ViewValues.EDITOR_PANE_TITLE, new HowToCreatorPane());
		frame.add(tabPane);
		frame.pack();
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int) (d.width-frame.getSize().width)/2, (int) (d.height-frame.getSize().getHeight())/2);
	}
	
	public void show(){
		frame.setVisible(true);
	}
}
