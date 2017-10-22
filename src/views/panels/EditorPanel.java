package views.panels;

import java.awt.Dimension;
import javax.swing.JTabbedPane;
import controllers.ViewController;
import views.ViewValues;
import views.panels.editors.CloudEditorPanel;
import views.panels.editors.DrawingEditorPanel;
import views.panels.editors.IslandEditorPanel;
import views.panels.editors.MountainEditorPanel;

public class EditorPanel extends JTabbedPane{
	private DrawingEditorPanel cloudPane;
	private DrawingEditorPanel mountainPane;
	private DrawingEditorPanel islandPane;
	public EditorPanel(ViewController controller) {
		cloudPane = new CloudEditorPanel(controller);
		mountainPane = new MountainEditorPanel(controller);
		islandPane = new IslandEditorPanel(controller);
	}
	
	public void render(){
		cloudPane.render();
		mountainPane.render();
		islandPane.render();
		addTab(ViewValues.TAB_CLOUD, cloudPane);
		addTab(ViewValues.TAB_MOUNTAIN, mountainPane);
		addTab(ViewValues.TAB_ISLAND, islandPane);
		setSize(ViewValues.EDITOR_PANE_WIDTH, ViewValues.EDITOR_PANE_HEIGHT);
		setBorder(ViewValues.getEditorBorder());
	}
	
	public void selectTab(String item){
		switch (item) {
		case ViewValues.TAB_CLOUD:
			setSelectedIndex(0);
			break;
		case ViewValues.TAB_MOUNTAIN:
			setSelectedIndex(1);
			break;
		case ViewValues.TAB_ISLAND:
			setSelectedIndex(2);
			break;
		default:
			break;
		}
	}
}
