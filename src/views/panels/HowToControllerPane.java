package views.panels;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.View;

import views.ViewValues;

public class HowToControllerPane extends JPanel{
	
	public HowToControllerPane() {
		render();
	}
	public void render(){
		JTextArea area = new JTextArea();
		area.setEditable(false);
		area.append("== Move animation ==\n");
		area.append("You can move your animation with followed button.\n");
		area.append(ViewValues.CONTROLLER_UP + " to move animation up.\n");
		area.append(ViewValues.CONTROLLER_LEFT + " to move animation left.\n");
		area.append(ViewValues.CONTROLLER_DOWN + " to move animation down.\n");
		area.append(ViewValues.CONTROLLER_RIGHT + " to move animation right.\n");
		area.append(ViewValues.CONTROLLER_CLEAR + " to reset animation to initial move.\n\n");
		area.append("== Zoom aniamtion ==\n");
		area.append("You can zoom your animation with followed button.\n");
		area.append(ViewValues.CONTROLLER_ZOOM_IN + " to zoom in animation.\n");
		area.append(ViewValues.CONTROLLER_ZOOM_OUT + " to zoom out animation.\n");
		area.append(ViewValues.CONTROLLER_CLEAR + " to reset animation to initial zoom.\n\n");
		area.append("== Control Time & Animation ==\n");
		area.append("You can control time and manage animation with followed button.\n");
		area.append(ViewValues.CONTROLLER_PLAY + " to play your animation.\n");
		area.append(ViewValues.CONTROLLER_PAUSE + " to stop your animation.\n");
		area.append(ViewValues.CONTROLLER_RESET + " to clear all drawing in your animation and stop it.\n");
		area.append(ViewValues.CONTROLLER_UNDO + " to delete lastest drawing that you created.");
		add(area);
	}
}
