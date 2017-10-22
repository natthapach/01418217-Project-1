package models.drawings;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;

public class Mountain extends AbstractDrawing{
	public static final Color DARK_BROWN = Color.decode("#974700");
	public static final Color DARK_WHITE = Color.decode("#79e1ff");
	public static final Color LIGHT_BROWN = Color.decode("#da6e0f");
	public static final Color LIGHT_WHITE = Color.decode("#d9f7ff");
	
	private Color darkTone;
	private Color lightTone;
	public Mountain(int x, int y){
		this(x, y, 150, 60);
	}
	public Mountain(int x, int y, int w, int h){
		super(x, y, w, h, 150, 60);
		
		darkTone = DARK_WHITE;
		lightTone = LIGHT_WHITE;
	}
	
	@Override
	protected void drawImage(Graphics2D g2) {
		
		GeneralPath back = createBackPart();
		GeneralPath front = createFrontPart();
		
		g2.setColor(darkTone);
		g2.fill(back);
		g2.setColor(lightTone);
		g2.fill(front);
	}
	private GeneralPath createBackPart(){
		GeneralPath back = new GeneralPath();
		back.moveTo(0, 60);
		back.lineTo(30, 21);
		back.lineTo(41, 28);
		back.lineTo(57, 10);
		back.lineTo(63, 15);
		back.lineTo(78, 2);
		back.lineTo(82, 4);
		back.lineTo(89, 1);
		back.lineTo(116, 32);
		back.lineTo(124, 27);
		back.lineTo(150, 60);
		back.closePath();
		
		return back;
	}
	
	private GeneralPath createFrontPart(){
		GeneralPath front = new GeneralPath();
		front.moveTo(11, 53);
		front.lineTo(31, 29);
		front.lineTo(37, 33);
		front.lineTo(34, 41);
		front.lineTo(58, 17);
		front.lineTo(64, 26);
		front.lineTo(78, 7);
		front.lineTo(82, 8);
		front.lineTo(88, 6);
		front.lineTo(116, 38);
		front.lineTo(122, 35);
		front.lineTo(132, 44);
		front.lineTo(117, 52);
		front.lineTo(115, 47);
		front.lineTo(103, 50);
		front.lineTo(91, 36);
		front.lineTo(72, 49);
		front.lineTo(60, 37);
		front.lineTo(31, 55);
		front.lineTo(33, 48);
		front.closePath();
		
		return front;
	}
	public Color getDarkTone() {
		return darkTone;
	}
	public Color getLightTone() {
		return lightTone;
	}
	public void setDarkTone(Color darkTone) {
		this.darkTone = darkTone;
	}
	public void setLightTone(Color lightTone) {
		this.lightTone = lightTone;
	}
}
