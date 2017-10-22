package models.drawings;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

import models.ColorLib;

public class Island extends AbstractDrawing{
	public final Color MID_TONE_LAND = ColorLib.ISLAND_MID_TONE_LAND.color;
	public final Color DARK_TONE_LAND = ColorLib.ISLAND_DARK_TONE_LAND.color;
	public final Color LIGHT_TONE_LAND = ColorLib.ISLAND_LIGHT_TONE_LAND.color;
	public final Color MID_TONE_TREE = ColorLib.ISLAND_MID_TONE_TREE.color;
	public final Color DARK_TONE_TREE = ColorLib.ISLAND_DARK_TONE_TREE.color;
	public final Color LIGHT_TONE_LEAF = ColorLib.ISLAND_DARK_TONE_LEAF.color;
	public final Color DARK_TONE_LEAF = ColorLib.ISLAND_DARK_TONE_LEAF.color;
	public final Color LIGHT_TONE_OCEAN = ColorLib.ISLAND_LIGHT_TONE_OCEAN.color;
	private static final int DEFAULT_WIDTH = 190;
	private static final int DEFAULT_HEIGHT = 130;
	
	private Color midToneLand;
	private Color darkToneLand;
	private Color lightToneLand;
	private Color midToneTree;
	private Color darkToneTree;
	private Color lightToneLeaf;
	private Color darkToneLeaf;
	private Color lightToneOcean;
	
	public Island(int x, int y){
		this(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	public Island(int x, int y, int w, int h){
		super(x, y, w, h, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		midToneLand = MID_TONE_LAND;
		darkToneLand = DARK_TONE_LAND;
		lightToneLand = LIGHT_TONE_LAND;
		midToneTree = MID_TONE_TREE;
		darkToneTree = DARK_TONE_TREE;
		lightToneLeaf = LIGHT_TONE_LEAF;
		darkToneLeaf = DARK_TONE_LEAF;
		lightToneOcean = LIGHT_TONE_OCEAN;
	}
	
	protected void drawImage(Graphics2D g2){
		ArrayList<Ellipse2D.Float> darkCoconuts = new ArrayList<>();
		darkCoconuts.add(new Ellipse2D.Float(50, 30, 10, 10));
		darkCoconuts.add(new Ellipse2D.Float(45, 35, 10, 10));
		darkCoconuts.add(new Ellipse2D.Float(52, 37, 10, 10));
		ArrayList<Ellipse2D.Float> lightCoconuts = new ArrayList<>();
		lightCoconuts.add(new Ellipse2D.Float(52, 30, 8, 9));
		lightCoconuts.add(new Ellipse2D.Float(47, 35, 8, 9));
		lightCoconuts.add(new Ellipse2D.Float(54, 37, 8, 9));
		g2.setColor(lightToneOcean);
		g2.fill(createLightToneOcean());
		g2.setColor(midToneLand);
		g2.fill(createMidToneLand());
		g2.setColor(darkToneLand);
		g2.fill(createDarkToneLand());
		g2.setColor(lightToneLand);
		g2.fill(createLightToneLand());
		g2.setColor(midToneTree);
		g2.fill(createMidToneTree());
		g2.setColor(darkToneTree);
		g2.fill(createDarkToneTree());
		g2.draw(createLineTree());
		g2.setColor(lightToneLeaf);
		g2.fill(createLighTonetLeaf());
		g2.setColor(darkToneLeaf);
		g2.fill(createDarkToneLeaf());	
		
		for(int i=0; i<darkCoconuts.size(); i++){
			g2.setColor(darkToneTree);
			g2.fill(darkCoconuts.get(i));
			g2.setColor(midToneTree);
			g2.fill(lightCoconuts.get(i));
		}
	}
	private GeneralPath createMidToneLand(){
		GeneralPath land = new GeneralPath();
		land.moveTo(43, 99);
		land.curveTo(43, 99, 30, 100, 42, 109);
		land.curveTo(42, 109, 50, 112, 58, 110);
		land.curveTo(58, 110, 50, 114, 68, 117);
		land.curveTo(68, 117, 100, 118, 134, 119);
		land.curveTo(134, 119, 160, 115, 147, 113);
		land.curveTo(147, 113, 155, 115, 165, 107);
		land.curveTo(165, 107, 175, 105, 159, 100);
		land.curveTo(159, 100, 70, 80, 43, 99);
		return land;
	}
	private GeneralPath createDarkToneLand(){
		GeneralPath land = new GeneralPath();
		land.moveTo(43, 99);
		land.curveTo(43, 99, 30, 100, 42, 109);
		land.curveTo(42, 109, 50, 112, 58, 110);
		land.curveTo(58, 110, 50, 114, 68, 117);
		land.curveTo(68, 117, 100, 118, 134, 119);
		land.curveTo(134, 119, 160, 115, 147, 113);
		land.curveTo(147, 113, 155, 115, 165, 107);
		land.curveTo(165, 107, 175, 105, 159, 100);
		
		land.curveTo(159, 100, 170, 105, 154, 104);
		land.curveTo(154, 104, 175, 107, 140, 111);
		land.curveTo(140, 111, 150, 113, 135, 115);
		land.curveTo(135, 115, 100, 115, 74, 113);
		land.curveTo(74, 113, 60, 110, 71, 107);
		land.curveTo(71, 107, 35, 110, 43, 99);
		return land;
	}
	private GeneralPath createLightToneLand(){
		GeneralPath land = new GeneralPath();
		Ellipse2D.Float light1 = new Ellipse2D.Float(75, 106, 60, 5);
		Ellipse2D.Float light2 = new Ellipse2D.Float(138, 103, 20, 5);
		land.append(light1, false);
		land.append(light2, false);
		
		return land;
	}
	private GeneralPath createMidToneTree(){
		GeneralPath tree = new GeneralPath();
		tree.moveTo(57, 102);
		tree.curveTo(57, 102, 75, 90, 53, 40);	
		tree.curveTo(53, 40, 85, 80, 74, 101);
		tree.closePath();
		return tree;
	}
	private GeneralPath createDarkToneTree(){
		GeneralPath tree = new GeneralPath();
		tree.moveTo(57, 102);
		tree.curveTo(57, 102, 75, 90, 53, 40);	
		tree.curveTo(53, 40, 77, 85, 65, 101);
		tree.closePath();
		return tree;
	}	
	private GeneralPath createLineTree(){
		GeneralPath line = new GeneralPath();
		line.moveTo(63, 94);
		line.curveTo(63, 94, 70, 90, 74, 92);
		line.moveTo(65, 80);
		line.curveTo(65, 80, 64, 78, 72, 78);
		line.moveTo(63, 65);
		line.curveTo(63, 65, 63, 63, 67, 63);
		
		return line;
	}
	private GeneralPath createLighTonetLeaf(){
		GeneralPath leaf = new GeneralPath();
		leaf.moveTo(53, 40);
		leaf.curveTo(53, 40, 60, 25, 77, 29);
		leaf.lineTo(76, 31);
		leaf.curveTo(76, 31, 78, 28, 87, 35);
		leaf.curveTo(87, 35, 90, 35, 97, 44);
		leaf.lineTo(95, 44);
		leaf.curveTo(95, 44, 100, 50, 96, 56);
		leaf.curveTo(96, 56, 91, 48, 86, 49);
		leaf.curveTo(86, 49, 78, 46, 79, 45);
		leaf.lineTo(78, 48);
		leaf.curveTo(78, 48, 70, 46, 69, 43);
		leaf.lineTo(68, 45);
		leaf.curveTo(68, 45, 57, 40, 53, 40);
		
		leaf.moveTo(53, 40);
		leaf.curveTo(53, 40, 20, 55, 42, 82);
		leaf.curveTo(42, 82, 40, 77, 44, 74);
		leaf.curveTo(44, 74, 40, 65, 45, 71);
		leaf.curveTo(45, 71, 45, 65, 47, 67);
		leaf.curveTo(47, 67, 42, 60, 48, 63);
		leaf.curveTo(48, 63, 46, 60, 48, 58);
		leaf.curveTo(48, 58, 45, 56, 49, 54);
		leaf.curveTo(49, 54, 47, 47, 53, 40);
		
		leaf.moveTo(53, 40);
		leaf.curveTo(53, 40, 48, 20, 32, 18);
		leaf.lineTo(32, 20);
		leaf.curveTo(32, 20, 25, 15, 18, 18);
		leaf.lineTo(19, 20);
		leaf.curveTo(19, 20, 10, 20, 1, 38); //
		leaf.curveTo(1, 38, 5, 33, 8, 36);
		leaf.curveTo(8, 36, 15, 37, 12, 37);
		leaf.curveTo(12, 37, 18, 30, 20, 34);
		leaf.curveTo(20, 34, 33, 27, 33, 33);
		leaf.curveTo(33, 33, 43, 32, 53, 40);
		
		
		return leaf;
	}
	private GeneralPath createDarkToneLeaf(){
		GeneralPath leaf = new GeneralPath();
		leaf.moveTo(53, 40);
		leaf.curveTo(53, 40, 15, 35, 17, 70);
		leaf.curveTo(17, 70, 22, 60, 25, 63);
		leaf.curveTo(25, 63, 25, 58, 27, 58);
		leaf.curveTo(27, 58, 28, 50, 30, 53);
		leaf.curveTo(30, 53, 40, 40, 53, 40);
		
		leaf.moveTo(53, 40);
		leaf.curveTo(53, 40, 45, 30, 53, 21);
		leaf.curveTo(53, 21, 53, 13, 61, 9);
		leaf.curveTo(61, 9, 65, 3, 74, 3);
		leaf.curveTo(74, 3, 75, 0, 84, 1);
		leaf.lineTo(84, 10);
		leaf.curveTo(84, 10, 65, 15, 53, 40);
		return leaf;
	}
	private GeneralPath createLightToneOcean(){
		GeneralPath ocean = new GeneralPath();
		ocean.moveTo(54, 97);
		ocean.curveTo(54, 97, 0, 105, 25, 111);
		ocean.curveTo(25, 111, 13, 115, 32, 115);
		ocean.curveTo(32, 115, 15, 120, 44, 124);
		ocean.curveTo(44, 124, 55, 125, 68, 125);
		ocean.curveTo(68, 125, 90, 130, 124, 125);
		ocean.curveTo(124, 125, 118, 130, 141, 128);
		ocean.curveTo(141, 128, 158, 128, 157, 123);
		ocean.curveTo(157, 123, 165, 125, 173, 119);
		ocean.curveTo(173, 119, 200, 115, 186, 108);
		ocean.curveTo(186, 108, 150, 95, 135, 96);
		ocean.closePath();
		
		return ocean;
	}
	public Color getMidToneLand() {
		return midToneLand;
	}
	public Color getDarkToneLand() {
		return darkToneLand;
	}
	public Color getLightToneLand() {
		return lightToneLand;
	}
	public Color getMidToneTree() {
		return midToneTree;
	}
	public Color getDarkToneTree() {
		return darkToneTree;
	}
	public Color getLightToneLeaf() {
		return lightToneLeaf;
	}
	public Color getDarkToneLeaf() {
		return darkToneLeaf;
	}
	public Color getLightToneOcean() {
		return lightToneOcean;
	}
	public void setMidToneLand(Color midToneLand) {
		this.midToneLand = midToneLand;
	}
	public void setDarkToneLand(Color darkToneLand) {
		this.darkToneLand = darkToneLand;
	}
	public void setLightToneLand(Color lightToneLand) {
		this.lightToneLand = lightToneLand;
	}
	public void setMidToneTree(Color midToneTree) {
		this.midToneTree = midToneTree;
	}
	public void setDarkToneTree(Color darkToneTree) {
		this.darkToneTree = darkToneTree;
	}
	public void setLightToneLeaf(Color lightToneLeaf) {
		this.lightToneLeaf = lightToneLeaf;
	}
	public void setDarkToneLeaf(Color darkToneLeaf) {
		this.darkToneLeaf = darkToneLeaf;
	}
	public void setLightToneOcean(Color lightToneOcean) {
		this.lightToneOcean = lightToneOcean;
	}
}
