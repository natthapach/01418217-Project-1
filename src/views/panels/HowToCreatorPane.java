package views.panels;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import views.ViewValues;

public class HowToCreatorPane extends JPanel{
	public HowToCreatorPane() {
		render();
	}
	public void render(){
		JTextArea area = new JTextArea();
		area.setEditable(false);
		area.append("This program provides 3 drawings to create.\n");
		area.append("There are Cloud, Mountain and Island.\n");
		area.append("You can modify your drawing before draw.\n");
		area.append(ViewValues.EDITOR_POSTITION + " : the position that drawing appear on the earth (by radius degree).\n");
		area.append(ViewValues.EDITOR_LEVEL + " : the height between drawing the earth and drawing (by pixel degree).\n");
		area.append(ViewValues.EDITOR_WIDTH + " : the width of drawing by percentage unit (1 is 100%).\n");
		area.append(ViewValues.EDITOR_HEIGHT + " : the height of drawing by percentage unit (1 is 100%).\n");
		area.append(ViewValues.EDITOR_COLOR + " : color of each part in drawing. And that is 2 way to modify.\n");
		area.append("1. Select color in combo box and must not type anything in text field.\n");
		area.append("2. Type color code in text field with RGB code.");
		add(area);
	}
}
