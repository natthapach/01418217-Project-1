package controllers;

import javax.swing.JComponent;

import controllers.ModelController.DrawingModifier;
import controllers.ModelController.DrawingModifierGenerator;
import models.ColorLib;
import views.HowToView;
import views.MainView;
import views.PopUpView;

public class ViewController {
	private MainController mainController;
	private MainView mainView;
	private HowToView howToView;
	private PopUpView popUp;
	public ViewController(MainController mainController) {
		this.mainController = mainController;
		mainView = new MainView(this);
		howToView = new HowToView();
		popUp = new PopUpView();
	}
	public void initView(){
		mainView.initFrame();
		howToView.initFrame();
	}
	public void onClickPlayBtn(){
		mainController.startTime();
	}
	public void onClickPauseBtn(){
		mainController.stopTime();
	}
	public void onClickResetBtn(){
		mainController.resetComponent();
		mainController.stopTime();
	}
	public void onClickMoveUpBtn(){
		mainController.moveComponentUp();
	}
	public void onClickMoveLeftBtn(){
		mainController.moveComponentLeft();
	}
	public void onClickMoveDownBtn(){
		mainController.moveComponentDown();
	}
	public void onClickMoveRightBtn(){
		mainController.moveComponentRight();
	}
	public void onClickMoveResetBtn(){
		mainController.moveComponentReset();
	}
	public void onClickZoomInBtn(){
		mainController.zoomInComponent();
	}
	public void onClickZoomOutBtn(){
		mainController.zoomOutComponent();
	}
	public void onClickZoomResetBtn(){
		mainController.zoomResetComponent();
	}
	public void onClickUndoBtn(){
		mainController.deleteLastDrawing();
	}
	public void onClickHowToMenu(){
		howToView.show();
	}
	public void onClickProducerMenu(){
		popUp.showProducerName();
	}
	/**
	 * 
	 * @param generator for generate modifier
	 * @param caller for call create method form main controller
	 */
	public void onClickNewBtn(DrawingModifierGenerator generator, DrawingGenerateCaller caller){
		// use interface call back for code reuse
		try{
			caller.call(generator.pack());
		}catch (NumberFormatException e) {
			popUp.showInvalidInput();
		}
	}
	public JComponent getComponent(){
		return mainController.getComponent();
	}
	public ColorLib[] getMountainColors(){
		return mainController.getMountainColors();
	}
	public ColorLib[] getIslandColors(){
		return mainController.getIslandColors();
	}
	public ColorLib[] getCloudColors(){
		return mainController.getCloudColors();
	}
	
	public interface DrawingGenerateCaller{
		void call(DrawingModifier modifier);
	}
	
	public class IslandCaller implements DrawingGenerateCaller{
		@Override
		public void call(DrawingModifier modifier) {
			mainController.newIsland(modifier);			
		}
	}
	public class CloudCaller implements DrawingGenerateCaller{

		@Override
		public void call(DrawingModifier modifier) {
			mainController.newCloud(modifier);
		}
	}
	public class MountainCaller implements DrawingGenerateCaller{
		@Override
		public void call(DrawingModifier modifier) {
			mainController.newMountain(modifier);
		}
	}
}
