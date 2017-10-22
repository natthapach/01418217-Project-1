package controllers;

import controllers.ModelController.DrawingModifier;
import models.ColorLib;
import models.MainComponent;
import models.drawings.AbstractDrawing;
import models.drawings.Mountain;
import views.MainView;

public class MainController {
	private final int DELAY = 40;	// 25 FPS
	private TimeTask timer;
	private ModelController modelController;
	private ViewController viewController;
	
	public MainController() {
		modelController = new ModelController();
		viewController = new ViewController(this);
		timer = new TimeTask(DELAY, modelController.getComponent());
	}
	/**
	 * Start controller
	 */
	public void start(){
		viewController.initView();
		timer.start();
	}
	/**
	 * Generate animation component
	 * @return animation component
	 */
	public MainComponent getComponent(){
		return modelController.getComponent();
	}	
	/**
	 * Start timer
	 */
	public void startTime(){
		timer.start();
	}
	/**
	 * Stop timer
	 */
	public void stopTime(){
		timer.stop();
	}
	/**
	 * Reset animation component to initial
	 */
	public void resetComponent(){
		modelController.reset();
	}
	/**
	 * 
	 * @return array of mountain color
	 */
	public ColorLib[] getMountainColors(){
		return modelController.getMountainColors();
	}
	/**
	 * 
	 * @return array of cloud color
	 */
	public ColorLib[] getCloudColors(){
		return modelController.getCloudColors();
	}
	/**
	 * 
	 * @return array of island color
	 */
	public ColorLib[] getIslandColors(){
		return modelController.getIslandColors();
	}
	/**
	 * create new mountain to animation
	 * @param modifier modifier of new mountain
	 */
	public void newMountain(DrawingModifier modifier){
		modelController.newMountain(modifier);
	}
	/**
	 * create new island to animation
	 * @param modifier modifier of new island
	 */
	public void newIsland(DrawingModifier modifier){
		modelController.newIsland(modifier);
	}
	/**
	 * create new cloud to animation
	 * @param modifier modifier of new cloud
	 */
	public void newCloud(DrawingModifier modifier){
		modelController.newCloud(modifier);
	}
	public void moveComponentUp(){
		modelController.moveComponent(ModelController.Direction.UP);
	}
	public void moveComponentLeft(){
		modelController.moveComponent(ModelController.Direction.LEFT);
	}
	public void moveComponentDown(){
		modelController.moveComponent(ModelController.Direction.DOWN);
	}
	public void moveComponentRight(){
		modelController.moveComponent(ModelController.Direction.RIGHT);
	}
	public void moveComponentReset(){
		modelController.moveComponent(ModelController.Direction.RESET);
	}
	public void zoomInComponent(){
		modelController.zoomComponent(ModelController.Zoom.IN);
	}
	public void zoomOutComponent(){
		modelController.zoomComponent(ModelController.Zoom.OUT);
	}
	public void zoomResetComponent(){
		modelController.zoomComponent(ModelController.Zoom.RESET);
	}
	/**
	 * delete lastest drawing that create
	 */
	public void deleteLastDrawing(){
		modelController.deleteLastDrawing();
	}
}
