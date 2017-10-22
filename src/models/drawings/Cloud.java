package models.drawings;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import models.ColorLib;

public class Cloud extends AbstractDrawing{
	public static final Color LIGHT_TONE = ColorLib.CLOUD_LIGHT_TONE.color;
	public static final Color DARK_TONE = ColorLib.CLOUD_DARK_TONE.color;
	
	private static int DEFAULT_WIDTH = 260;
	private static int DEFAULT_HEIGHT = 150;
	private Color lightTone;
	private Color darkTone;
	
	public Cloud(int x, int y){
		this(x, y, DEFAULT_WIDTH, DEFAULT_WIDTH);
	}
	
	public Cloud(int x, int y, int width, int height) {
		super(x, y, width, height, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		this.lightTone = LIGHT_TONE;
		this.darkTone = DARK_TONE;
	}
	@Override
	protected void drawImage(Graphics2D g2) {
		ArrayList<Ellipse2D.Float> darkCircles = new ArrayList<>();
		ArrayList<Ellipse2D.Float> lightCircles = new ArrayList<>();
		
		darkCircles.add(new Ellipse2D.Float(0, 50, 100, 100));
		darkCircles.add(new Ellipse2D.Float(80, 0, 100, 100));
		darkCircles.add(new Ellipse2D.Float(50, 35, 50, 50));
		darkCircles.add(new Ellipse2D.Float(150, 30, 80, 80));
		darkCircles.add(new Ellipse2D.Float(200, 70, 60, 60));
		darkCircles.add(new Ellipse2D.Float(55, 65, 80, 80));
		darkCircles.add(new Ellipse2D.Float(110, 70, 70, 70));
		darkCircles.add(new Ellipse2D.Float(165, 85, 50, 50));
		
		lightCircles.add(new Ellipse2D.Float(5, 52, 90, 90));
		lightCircles.add(new Ellipse2D.Float(82, 3, 90, 90));
		lightCircles.add(new Ellipse2D.Float(53, 38, 40, 40));
		lightCircles.add(new Ellipse2D.Float(145, 35, 80, 80));
		lightCircles.add(new Ellipse2D.Float(198, 70, 55, 55));
		lightCircles.add(new Ellipse2D.Float(55, 65, 75, 75));
		lightCircles.add(new Ellipse2D.Float(110, 70, 65, 65));
		lightCircles.add(new Ellipse2D.Float(165, 85, 45, 45));
		
		
		g2.setColor(darkTone);
		for(Ellipse2D.Float c : darkCircles)
			g2.fill(c);
		
		g2.setColor(lightTone);
		for(Ellipse2D.Float c : lightCircles)
			g2.fill(c);

	}
	public Color getLightTone() {
		return lightTone;
	}
	public Color getDarkTone() {
		return darkTone;
	}
	public void setLightTone(Color lightTone) {
		this.lightTone = lightTone;
	}
	public void setDarkTone(Color darkTone) {
		this.darkTone = darkTone;
	}
}