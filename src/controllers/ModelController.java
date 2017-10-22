package controllers;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import models.*;
import models.drawings.*;
import models.interfaces.*;
import models.tweens.*;



public class ModelController {	
	public static enum Direction{
		UP, LEFT, DOWN, RIGHT, RESET
	}
	public static enum Zoom{
		IN, OUT, RESET
	}
	private final double DEFAULT_DTHETA = 0.01; 
	private DrawingCollector collector;
	private MainComponent component;
	private TweenObserver rTween;
	private int centerX;
	
	public ModelController() {
		collector = new DrawingCollector();
		component = new MainComponent(collector);
		initEarth();
	}
	private void initEarth(){
		AbstractDrawing earth = new Earth(50, 50);
		Integer anchorX = (int) earth.getCenter().getWidth();
		Integer anchorY = (int) earth.getCenter().getHeight();
		centerX = anchorX;
		rTween = new RotateTween(DEFAULT_DTHETA, anchorX, anchorY);
		earth.addObserver(rTween);
		collector.addDrawing(earth);
	}
	/**
	 * 
	 * @return animation component
	 */
	public MainComponent getComponent() {
		return component;
	}
	/**
	 * reset animation to initial
	 */
	public void reset(){
		collector.clear();
		initEarth();
		component.tick(0);
	}
	/**
	 * create new mountain to animation
	 * @param modifier modifier of new mountain
	 */
	public void newMountain(DrawingModifier modifier){
		Mountain mountain = new Mountain(0, 20); 
		modifyDrawing(modifier, mountain);
		mountain.setLightTone(modifier.colors.get(DrawingModifier.colorKey.MOUNTAIN_LIGHT));
		mountain.setDarkTone(modifier.colors.get(DrawingModifier.colorKey.MOUNTAIN_DARK));
		collector.addDrawing(mountain);
		component.repaint();
	}
	/**
	 * crate new island to animation
	 * @param modifier modifier of new Island
	 */
	public void newIsland(DrawingModifier modifier){
		Island island = new Island(0, -40);
		modifyDrawing(modifier, island);
		island.setDarkToneLand(modifier.colors.get(DrawingModifier.colorKey.ISLAND_DARK_LAND));
		island.setDarkToneLeaf(modifier.colors.get(DrawingModifier.colorKey.ISLAND_DARK_LEAF));
		island.setDarkToneTree(modifier.colors.get(DrawingModifier.colorKey.ISLAND_DARK_TREE));
		island.setLightToneLand(modifier.colors.get(DrawingModifier.colorKey.ISLAND_LIGHT_LAND));
		island.setLightToneLeaf(modifier.colors.get(DrawingModifier.colorKey.ISLAND_LIGHT_LEAF));
		island.setLightToneOcean(modifier.colors.get(DrawingModifier.colorKey.ISLAND_LIGHT_OCEAN));
		island.setMidToneLand(modifier.colors.get(DrawingModifier.colorKey.ISLAND_MID_LAND));
		island.setMidToneTree(modifier.colors.get(DrawingModifier.colorKey.ISLAND_MID_TREE));
		collector.addDrawing(island);
		component.repaint();
	}
	/**
	 * create new cloud to animation
	 * @param modifier modifier of new cloud
	 */
	public void newCloud(DrawingModifier modifier){
		Cloud cloud = new Cloud(0, -30);
		modifyDrawing(modifier, cloud);
		cloud.setDarkTone(modifier.colors.get(DrawingModifier.colorKey.CLOUD_DARK));
		cloud.setLightTone(modifier.colors.get(DrawingModifier.colorKey.CLOUD_LIGHT));
		collector.addDrawing(cloud);
		component.repaint();
	}
	/**
	 * modify drawing with modifier
	 * @param modifier
	 * @param drawing
	 */
	private void modifyDrawing(DrawingModifier modifier, AbstractDrawing drawing){
		drawing.setTheta(modifier.position);
		drawing.scale(modifier.width, modifier.height);
		drawing.move(centerX-drawing.getWidth()/2, -(int)modifier.level);
		drawing.addObserver(rTween);
		rTween.update(drawing);
		drawing.setVisible(true);
	}
	public ColorLib[] getMountainColors(){
		return ColorLib.getMountainColors();
	}
	public ColorLib[] getIslandColors(){
		return ColorLib.getIslandColors();
	}
	public ColorLib[] getCloudColors(){
		return ColorLib.getCloundColors();
	}
	/**
	 * 
	 * @param d direction to move
	 */
	public void moveComponent(Direction d){
		switch (d) {
		case UP:
			component.move(0, -10);
			break;
		case LEFT:
			component.move(-10, 0);
			break;
		case DOWN:
			component.move(0, 10);
			break;
		case RIGHT:
			component.move(10, 0);
			break;
		case RESET:
			component.locale(0, 0);
			break;
		default:
			break;
		}
		component.repaint();
	}
	/**
	 * 
	 * @param z way to zoom
	 */
	public void zoomComponent(Zoom z){
		switch (z) {
		case IN:
			component.scale(0.1, 0.1);
			break;
		case OUT:
			component.scale(-0.1, -0.1);
			break;
		case RESET:
			component.scale(0.0, 0.0);
			break;
		default:
			break;
		}
		component.repaint();
	}
	public void deleteLastDrawing(){
		AbstractDrawing drawing = collector.pop();
		if(drawing instanceof Earth)
			collector.addDrawing(drawing);
		component.repaint();
	}
	
	public static class DrawingModifier{
		public static enum colorKey{
			MOUNTAIN_LIGHT, MOUNTAIN_DARK,
			ISLAND_MID_LAND, ISLAND_DARK_LAND, ISLAND_LIGHT_LAND,
			ISLAND_MID_TREE, ISLAND_DARK_TREE,
			ISLAND_LIGHT_LEAF, ISLAND_DARK_LEAF, ISLAND_LIGHT_OCEAN,
			CLOUD_LIGHT, CLOUD_DARK
		};
		protected Map<colorKey, Color> colors = new HashMap<>();
		protected double position;
		protected double level;
		protected double width;
		protected double height;
		public void setPosition(double position) {
			this.position = position;
		}
		public void setLevel(double level) {
			this.level = level;
		}
		public void setWidth(double width) {
			this.width = width;
		}
		public void setHeight(double height) {
			this.height = height;
		}
		public void addColor(colorKey key, Color color){
			colors.put(key, color);
		}
	}
	public interface DrawingModifierGenerator{
		DrawingModifier pack();
	}
}
