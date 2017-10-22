package views.panels.editors;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.MainController;
import controllers.ViewController;
import controllers.ModelController.DrawingModifier;
import models.ColorLib;
import views.ViewValues;

public class IslandEditorPanel extends DrawingEditorPanel{
	private ArrayList<JComboBox<ColorLib>> colorBoxs;
	private ArrayList<JTextField> colorFields;
	public IslandEditorPanel(ViewController controller) {
		super(controller);
		colorBoxs = new ArrayList<>();
		colorFields = new ArrayList<>();
		for(int i=0; i<8; i++){
			colorBoxs.add(new JComboBox<>(controller.getIslandColors()));
			colorFields.add(new JTextField(5));
			colorBoxs.get(i).setSelectedIndex(i);
		}
	}

	@Override
	protected void initListener(ViewController controller) {
		newBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.onClickNewBtn(IslandEditorPanel.this, controller.new IslandCaller());
			}
		});		
	}

	@Override
	protected JPanel createColorPane() {
		JPanel panel = new JPanel(new GridLayout(8, 1));
		for(int i=0; i<8; i++){
			JPanel pane = new JPanel();
			pane.add(new JLabel("color "+(i+1)));
			pane.add(colorBoxs.get(i));
			pane.add(new JLabel(ViewValues.EDITOR_COLOR_CODE_LABEL));
			pane.add(colorFields.get(i));
			panel.add(pane);
		}
		panel.setBorder(ViewValues.getInnerBorder(ViewValues.EDITOR_COLOR));
		return panel;
	}
	@Override
	public DrawingModifier pack(){
		DrawingModifier modifier = super.pack();
		DrawingModifier.colorKey[] colorKeys = new DrawingModifier.colorKey[]{
				DrawingModifier.colorKey.ISLAND_DARK_LAND,
				DrawingModifier.colorKey.ISLAND_MID_LAND,
				DrawingModifier.colorKey.ISLAND_LIGHT_LAND,
				DrawingModifier.colorKey.ISLAND_DARK_LEAF,
				DrawingModifier.colorKey.ISLAND_LIGHT_LEAF,
				DrawingModifier.colorKey.ISLAND_DARK_TREE,
				DrawingModifier.colorKey.ISLAND_MID_TREE,
				DrawingModifier.colorKey.ISLAND_LIGHT_OCEAN
		};
		for(int i=0; i<8; i++){
			if("".equals(colorFields.get(i).getText()))
				modifier.addColor(colorKeys[i], ((ColorLib)colorBoxs.get(i).getSelectedItem()).color);
			else
				modifier.addColor(colorKeys[i], Color.decode("#"+colorFields.get(i).getText()));
		}
		return modifier;
	}
}
