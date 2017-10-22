package views.panels.editors;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.MainController;
import controllers.ViewController;
import controllers.ModelController.DrawingModifier;
import models.ColorLib;
import models.drawings.Mountain;
import views.ViewValues;

public class MountainEditorPanel extends DrawingEditorPanel{
	private JComboBox<ColorLib> color1Box;
	private JComboBox<ColorLib> color2Box;
	private JTextField color1Field;
	private JTextField color2Field;
	public MountainEditorPanel(ViewController controller) {
		super(controller);
		color1Box = new JComboBox<>(controller.getMountainColors());
		color2Box = new JComboBox<>(controller.getMountainColors());
		color1Field = new JTextField(5);
		color2Field = new JTextField(5);
		color1Box.setSelectedIndex(2);
		color2Box.setSelectedIndex(0);
	}

	@Override
	protected void initListener(ViewController controller) {
		newBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onClickNewBtn(MountainEditorPanel.this, controller.new MountainCaller());
			}
		});
	}
	@Override
	protected JPanel createColorPane() {
		JPanel pane = new JPanel(new GridLayout(2, 1));
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		pane1.add(new JLabel("Color 1"));
		pane1.add(color1Box);
		pane1.add(new JLabel(ViewValues.EDITOR_COLOR_CODE_LABEL));
		pane1.add(color1Field);
		pane2.add(new JLabel("Color 2"));
		pane2.add(color2Box);
		pane2.add(new JLabel(ViewValues.EDITOR_COLOR_CODE_LABEL));
		pane2.add(color2Field);
		pane.add(pane1);
		pane.add(pane2);
		pane.setBorder(ViewValues.getInnerBorder(ViewValues.EDITOR_COLOR));
		
		return pane;
	}
	public DrawingModifier pack(){
		DrawingModifier modifier = super.pack();
		if("".equals(color1Field.getText()))
			modifier.addColor(DrawingModifier.colorKey.MOUNTAIN_LIGHT, ((ColorLib)color1Box.getSelectedItem()).color);
		else
			modifier.addColor(DrawingModifier.colorKey.MOUNTAIN_LIGHT, Color.decode("#"+color1Field.getText()));
		if("".equals(color2Field.getText()))
			modifier.addColor(DrawingModifier.colorKey.MOUNTAIN_DARK, ((ColorLib)color2Box.getSelectedItem()).color);
		else
			modifier.addColor(DrawingModifier.colorKey.MOUNTAIN_DARK, Color.decode("#"+color2Field.getText()));
		return modifier;
	}
}
