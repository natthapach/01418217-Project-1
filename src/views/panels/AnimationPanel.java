package views.panels;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import views.ViewValues;

public class AnimationPanel extends JPanel{
	private JComponent animation;	
	
	public AnimationPanel(JComponent animation) {
		this.animation = animation;		
	}
	
	public void render(){
		setLayout(new BorderLayout());
		setBorder(ViewValues.getAmimationBorder());	
		add(animation);		
	}
}
