package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controllers.MainController;
import controllers.ViewController;
import models.MainComponent;
import views.panels.AnimationPanel;
import views.panels.ControlPanel;
import views.panels.EditorPanel;

public class MainView {
	private JFrame frame;
	private ViewController controller;
	private AnimationPanel animationPane;
	private ControlPanel controlPane;
	private EditorPanel editorPane;
	private JMenuItem producerMenu;
	private JMenuItem howToMenu;
	
	
	public MainView(ViewController controller) {
		frame = new JFrame();
		this.controller = controller;
		animationPane = new AnimationPanel(controller.getComponent());
		controlPane = new ControlPanel(controller);
		editorPane = new EditorPanel(controller);
		howToMenu = new JMenuItem(ViewValues.MENU_HOW_TO);
		producerMenu = new JMenuItem(ViewValues.MENU_PRODUCER);
		initListener(controller);
	}
	
	public void initFrame(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		createMenu();
		animationPane.render();
		controlPane.render();
		editorPane.render();
		
		frame.add(animationPane, BorderLayout.CENTER);
		frame.add(controlPane, BorderLayout.SOUTH);
		frame.add(editorPane, BorderLayout.EAST);
		frame.pack();
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int) (d.width-frame.getSize().width)/2, (int) (d.height-frame.getSize().getHeight())/2);
	}
	private void createMenu(){
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		menu.add(howToMenu);
		menu.add(producerMenu);
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
	}
	private void initListener(ViewController controller){
		howToMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onClickHowToMenu();
			}
		});
		producerMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onClickProducerMenu();
			}
		});
	}
	
}
