package views.panels.editors;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.MainController;
import controllers.ModelController.DrawingModifier;
import controllers.ViewController;
import models.ColorLib;
import views.ViewValues;

public class CloudEditorPanel extends DrawingEditorPanel{
	private JComboBox<ColorLib> color1Box;
	private JComboBox<ColorLib> color2Box;
	private JTextField color1Field;
	private JTextField color2Field;
	public CloudEditorPanel(ViewController controller) {
		super(controller);
		color1Box = new JComboBox<>(controller.getCloudColors());
		color2Box = new JComboBox<>(controller.getCloudColors());
		color1Field = new JTextField(5);
		color2Field = new JTextField(5);
		color2Box.setSelectedIndex(1);
		widthField.setText("0.5");
		heightField.setText("0.5");
	}

	@Override
	protected void initListener(ViewController controller) {
		newBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onClickNewBtn(CloudEditorPanel.this, controller.new CloudCaller());
			}
		});
	}

	@Override
	protected JPanel createColorPane() {
		JPanel panel = new JPanel(new GridLayout(2, 1));
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel();
		pane1.add(new JLabel("color 1"));
		pane1.add(color1Box);
		pane1.add(new JLabel(ViewValues.EDITOR_COLOR_CODE_LABEL));
		pane1.add(color1Field);
		pane2.add(new JLabel("color 2"));
		pane2.add(color2Box);
		pane2.add(new JLabel(ViewValues.EDITOR_COLOR_CODE_LABEL));
		pane2.add(color2Field);
		panel.add(pane1);
		panel.add(pane2);
		panel.setBorder(ViewValues.getInnerBorder(ViewValues.EDITOR_COLOR));
		return panel;
	}
	@Override
	public DrawingModifier pack(){
		DrawingModifier modifier = super.pack();
		if("".equals(color1Field.getText()))
			modifier.addColor(DrawingModifier.colorKey.CLOUD_DARK, ((ColorLib)color1Box.getSelectedItem()).color);
		else
			modifier.addColor(DrawingModifier.colorKey.CLOUD_DARK, Color.decode("#"+color1Field.getText()));
		if("".equals(color2Field.getText()))
			modifier.addColor(DrawingModifier.colorKey.CLOUD_LIGHT, ((ColorLib)color2Box.getSelectedItem()).color);
		else
			modifier.addColor(DrawingModifier.colorKey.CLOUD_LIGHT, Color.decode("#"+color2Field.getText()));
		return modifier;
	}
}
