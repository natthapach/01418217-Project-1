package views.panels.editors;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controllers.MainController;
import controllers.ModelController.DrawingModifier;
import controllers.ModelController.DrawingModifierGenerator;
import controllers.ViewController;
import models.ColorLib;
import models.drawings.AbstractDrawing;
import views.ViewValues;

public abstract class DrawingEditorPanel extends JPanel implements DrawingModifierGenerator{
	protected JTextField heightField;
	protected JTextField widthField;
	protected JTextField levelField;
	protected JTextField positionField;
	protected JButton newBtn;

	public DrawingEditorPanel(ViewController controller) {
		newBtn = new JButton(ViewValues.EDITOR_NEW);
		positionField = new JTextField(5);
		levelField = new JTextField(5);
		widthField = new JTextField(5);
		heightField = new JTextField(5);
		positionField.setText("0");
		levelField.setText("0");
		widthField.setText("1");
		heightField.setText("1");
		initListener(controller);
	}
	protected abstract void initListener(ViewController controller);
	protected abstract JPanel createColorPane();
	
	public void render(){
		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		
		JPanel btnPane = createBtnPane();
		JPanel locationPane = createLocationPane();
		JPanel sizePane = createSizePane();
		JPanel colorPane = createColorPane();
		
		pane.add(locationPane);
		pane.add(sizePane);
		pane.add(colorPane);
		pane.add(btnPane);
		add(pane);
	}
	private JPanel createBtnPane(){
		JPanel pane = new JPanel();
		pane.add(newBtn);
		return pane;
	}
	private JPanel createLocationPane(){
		JPanel pane = new JPanel(new GridLayout(2, 2));
		pane.add(new JLabel(ViewValues.EDITOR_POSTITION));
		pane.add(positionField);
		pane.add(new JLabel(ViewValues.EDITOR_LEVEL));
		pane.add(levelField);
		pane.setBorder(ViewValues.getInnerBorder(ViewValues.EDITOR_LOCATION));
		return pane;
	}
	private JPanel createSizePane(){
		JPanel pane = new JPanel(new GridLayout(2, 2));
		pane.add(new JLabel(ViewValues.EDITOR_WIDTH));
		pane.add(widthField);
		pane.add(new JLabel(ViewValues.EDITOR_HEIGHT));
		pane.add(heightField);
		pane.setBorder(ViewValues.getInnerBorder(ViewValues.EDITOR_SIZE));
		return pane;
	}	
	@Override
	public DrawingModifier pack(){
		DrawingModifier modifier = new DrawingModifier();
		modifier.setPosition(Double.parseDouble(positionField.getText()));
		modifier.setLevel(Double.parseDouble(levelField.getText()));
		modifier.setWidth(Double.parseDouble(widthField.getText()));
		modifier.setHeight(Double.parseDouble(heightField.getText()));
		return modifier;
	}
}
