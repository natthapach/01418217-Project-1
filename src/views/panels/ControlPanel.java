package views.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controllers.MainController;
import controllers.ViewController;
import views.ViewValues;

public class ControlPanel extends JPanel{	
	private JButton playBtn;
	private JButton pauseBtn;
	private JButton resetBtn;
	private JButton undoBtn;
	private JButton upBtn;
	private JButton leftBtn;
	private JButton downBtn;
	private JButton rightBtn;
	private JButton clearMoveBtn;
	private JButton zoomInBtn;
	private JButton zoomOutBtn;
	private JButton clearZoomBtn;
	
	public ControlPanel(ViewController controller) {
		playBtn = new JButton(ViewValues.CONTROLLER_PLAY);
		pauseBtn = new JButton(ViewValues.CONTROLLER_PAUSE);
		resetBtn = new JButton(ViewValues.CONTROLLER_RESET);
		undoBtn = new JButton(ViewValues.CONTROLLER_UNDO);
		upBtn = new JButton(ViewValues.CONTROLLER_UP);
		leftBtn = new JButton(ViewValues.CONTROLLER_LEFT);
		downBtn = new JButton(ViewValues.CONTROLLER_DOWN);
		rightBtn = new JButton(ViewValues.CONTROLLER_RIGHT);
		clearMoveBtn = new JButton(ViewValues.CONTROLLER_CLEAR);
		zoomInBtn = new JButton(ViewValues.CONTROLLER_ZOOM_IN);
		zoomOutBtn = new JButton(ViewValues.CONTROLLER_ZOOM_OUT);
		clearZoomBtn = new JButton(ViewValues.CONTROLLER_CLEAR);
		initListener(controller);
	}
	
	public void render(){
		setLayout(new GridLayout(1, 3, 5, 0));
		setBorder(ViewValues.getControlBorder());
		add(createMoveControlPane());
		add(createTimeControlPane());
		add(createZoomControlPane());
	}
	private JPanel createTimeControlPane(){
		JPanel panel = new JPanel();
		JPanel pane = new JPanel(new GridLayout(2, 2, 5, 5));
		pane.add(playBtn);
		pane.add(pauseBtn);
		pane.add(undoBtn);
		pane.add(resetBtn);		
		panel.add(pane);
		return panel;
	}
	private JPanel createMoveControlPane(){
		JPanel panel = new JPanel();
		JPanel pane = new JPanel(new GridLayout(3, 3, 5, 5));
		pane.add(new JLabel());
		pane.add(upBtn);
		pane.add(new JLabel());
		pane.add(leftBtn);
		pane.add(clearMoveBtn);
		pane.add(rightBtn);
		pane.add(new JLabel());
		pane.add(downBtn);
		pane.add(new JLabel());
		panel.add(pane);
		return panel;
	}
	private JPanel createZoomControlPane(){
		JPanel panel = new JPanel();
		JPanel pane = new JPanel(new GridLayout(1, 3));
		pane.add(zoomInBtn);
		pane.add(clearZoomBtn);
		pane.add(zoomOutBtn);
		panel.add(pane);
		return panel;
	}
	private void initListener(ViewController controller){
		playBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onClickPlayBtn();
				
			}
		});
		pauseBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onClickPauseBtn();
			}
		});
		resetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onClickResetBtn();				
			}
		});
		
		upBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onClickMoveUpBtn();
			}
		});
		leftBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onClickMoveLeftBtn();
			}
		});
		downBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onClickMoveDownBtn();
			}
		});
		rightBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onClickMoveRightBtn();
			}
		});
		clearMoveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onClickMoveResetBtn();
			}
		});
		zoomInBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onClickZoomInBtn();
			}
		});
		zoomOutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onClickZoomOutBtn();
			}
		});
		clearZoomBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onClickZoomResetBtn();
			}
		});
		undoBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onClickUndoBtn();
			}
		});
	}
}
