package models.drawings;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.HashSet;
import java.util.Observer;

import models.interfaces.Clockable;
import models.interfaces.Drawable;
import models.interfaces.Moveable;
import models.interfaces.Rotateable;
import models.interfaces.Scaleable;
import models.interfaces.TweenObservable;
import models.interfaces.TweenObserver;

public abstract class AbstractDrawing implements Drawable, Scaleable, Moveable, Rotateable, TweenObservable, Clockable{
	protected HashSet<TweenObserver> observers;
	protected boolean visible;
	protected long initFrame;
	protected long endFrame;
	private int defaultWidth;
	private int defaultHeight;
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	protected double theta;
	protected double anchorX;
	protected double anchorY;
	
	public AbstractDrawing(int x, int y, int width, int height, int defaultWidth, int defaultHeight){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.defaultWidth = defaultWidth;
		this.defaultHeight = defaultHeight;
		this.initFrame = Long.MIN_VALUE;
		this.endFrame = Long.MAX_VALUE;
		theta = 0;
		anchorX = this.getCenter().getWidth();
		anchorY = this.getCenter().getHeight();
		observers = new HashSet<>();
	}
	
	protected abstract void drawImage(Graphics2D g2);
	
	public Dimension getCenter(){
		int cx = x+width/2;
		int cy = y+height/2;
		return new Dimension(cx, cy);
	}
	public long getDuration(){
		return endFrame - initFrame;
	}
	public long getInitFrame() {
		return initFrame;
	}
	public long getEndFrame() {
		return endFrame;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setInitFrame(long initFrame) {
		this.initFrame = initFrame;
	}
	public void setEndFrame(long endFrame) {
		this.endFrame = endFrame;
	}
	public void setTheta(double theta){
		this.theta = theta;
	}
	public void setAnchor(int anchorX, int anchorY){
		this.anchorX = anchorX;
		this.anchorY = anchorY;
	}
	@Override
	public void addObserver(TweenObserver observer) {
		observers.add(observer);
	}
	@Override
	public void removeObserver(TweenObserver observer) {
		observers.remove(observer);
	}
	@Override
	public void notifyObservers() {
		for(TweenObserver obs : observers)
			obs.update(this);
		
	}
	@Override
	public void rotate(double theta) {
		rotate(theta, getCenter().getWidth(), getCenter().getHeight());
	}
	@Override
	public void rotate(double theta, double anchorX, double anchorY) {
		this.theta += theta;
		this.anchorX = anchorX;
		this.anchorY = anchorY;
	}
	@Override
	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	}
	@Override
	public void locale(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public void scale(double pw, double ph) {
		width = (int) (pw * defaultWidth);
		height = (int) (ph * defaultHeight);
	}
	@Override
	public void scale(int w, int h) {
		width = w;
		height = h;
	}
	@Override
	public void draw(Graphics2D g2) {
		if(visible){
			// backup g2
			AffineTransform atBackup = g2.getTransform();
			Stroke strokeBackup = g2.getStroke();
			Color colorBackup = g2.getColor();
			
			// modify g2
			AffineTransform at = (AffineTransform) atBackup.clone();
			at.rotate(theta, anchorX, anchorY);
			at.translate(x, y);
			at.scale(this.width*1.0/this.defaultWidth, this.height*1.0/this.defaultHeight);
			
			g2.setTransform(at);
			
			// let draw
			this.drawImage(g2);
			
			// restore g2
			g2.setTransform(atBackup);
			g2.setStroke(strokeBackup);
			g2.setColor(colorBackup);
		}
	}
	@Override
	public void setVisible(boolean t) {
		this.visible = t;
	}
	@Override
	public void tick(long frame) {
		if(initFrame <= frame && frame <= endFrame){
			visible = true;
			notifyObservers();
		}else{
			visible = false;
		}
	}
}
