package models;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JComponent;

import models.drawings.AbstractDrawing;
import models.drawings.Earth;
import models.drawings.Island;
import models.interfaces.Clockable;
import models.interfaces.Drawable;
import models.interfaces.Moveable;
import models.interfaces.Scaleable;
import models.interfaces.TweenObserver;
import models.tweens.MoveTween;
import models.tweens.RotateTween;

public class MainComponent extends JComponent implements Clockable, Moveable, Scaleable{
	private final int WIDTH = 500;
	private final int HEIGHT = 500;
	private DrawingCollector collector;
	private int x;
	private int y;
	private double pw = 1;
	private double ph = 1;
	
	public MainComponent(DrawingCollector collector) {
		this.collector = collector;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform at = new AffineTransform();
		at.translate(x, y);
		at.scale(pw, ph);
		g2.setTransform(at);
		for(Drawable d : collector)
			d.draw(g2);
	}
	
	@Override
	public void tick(long frame) {
		for(Clockable c : collector)
			c.tick(frame);
		repaint();
	}
	@Override
	public void locale(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void move(int dx, int dy){
		this.x += dx;
		this.y += dy;
	}
	@Override
	public void scale(double pw, double ph) {
		if(pw==0 && ph==0){
			this.pw = 1;
			this.ph = 1;
		}
		this.pw += pw;
		this.ph += ph;
	}
	@Override
	public void scale(int w, int h) {
		
	}
}
