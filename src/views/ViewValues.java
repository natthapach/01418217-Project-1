package views;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class ViewValues {
	public static final int ANIMATION_PANE_MARGIN_TOP = 10;
	public static final int ANIMATION_PANE_MARGIN_LEFT = 10;
	public static final int ANIMATION_PANE_MARGIN_BOTTOM = 10;
	public static final int ANIMATION_PANE_MARGIN_RIGHT = 10;
	public static final int ANIMATION_PANE_PADDING_TOP = 5;
	public static final int ANIMATION_PANE_PADDING_LEFT = 5;
	public static final int ANIMATION_PANE_PADDING_BOTTOM = 5;
	public static final int ANIMATION_PANE_PADDING_RIGHT = 5;
	public static final String ANIMATION_PANE_TITLE = "Animation";
	
	public static final int CONTROL_PANE_MARGIN_TOP = 10;
	public static final int CONTROL_PANE_MARGIN_LEFT = 10;
	public static final int CONTROL_PANE_MARGIN_BOTTOM = 10;
	public static final int CONTROL_PANE_MARGIN_RIGHT = 10;
	public static final int CONTROL_PANE_PADDING_TOP = 5;
	public static final int CONTROL_PANE_PADDING_LEFT = 5;
	public static final int CONTROL_PANE_PADDING_BOTTOM = 5;
	public static final int CONTROL_PANE_PADDING_RIGHT = 5;
	public static final String CONTROL_PANE_TITLE = "Controller";
	
	public static final int EDITOR_PANE_WIDTH = 400;
	public static final int EDITOR_PANE_HEIGHT = 500;
	public static final int EDITOR_PANE_MARGIN_TOP = 10;
	public static final int EDITOR_PANE_MARGIN_LEFT = 10;
	public static final int EDITOR_PANE_MARGIN_BOTTOM = 10;
	public static final int EDITOR_PANE_MARGIN_RIGHT = 10;
	public static final int EDITOR_PANE_PADDING_TOP = 5;
	public static final int EDITOR_PANE_PADDING_LEFT = 5;
	public static final int EDITOR_PANE_PADDING_BOTTOM = 5;
	public static final int EDITOR_PANE_PADDING_RIGHT = 5;
	public static final String EDITOR_PANE_TITLE = "Creator";
	
	public static final int INNER_PANE_MARGIN_TOP = 5;
	public static final int INNER_PANE_MARGIN_LEFT = 5;
	public static final int INNER_PANE_MARGIN_BOTTOM = 5;
	public static final int INNER_PANE_MARGIN_RIGHT = 5;
	public static final int INNER_PANE_PADDING_TOP = 5;
	public static final int INNER_PANE_PADDING_LEFT = 5;
	public static final int INNER_PANE_PADDING_BOTTOM = 5;
	public static final int INNER_PANE_PADDING_RIGHT = 5;
	
	public static final String TAB_CLOUD = "Cloud";
	public static final String TAB_MOUNTAIN = "Mountain";
	public static final String TAB_ISLAND = "Island";
	
	public static final String EDITOR_LOCATION = "Location";
	public static final String EDITOR_SIZE = "Size";
	public static final String EDITOR_POSTITION = "Position";
	public static final String EDITOR_LEVEL = "Level";
	public static final String EDITOR_WIDTH = "Width";
	public static final String EDITOR_HEIGHT = "Height";
	public static final String EDITOR_COLOR = "Color";
	public static final String EDITOR_NEW = "New";
	public static final String EDITOR_COLOR_CODE_LABEL = "or #";
	
	public static final String MENU_HOW_TO = "How to";
	public static final String MENU_PRODUCER = "Producer";
	
	public static final String CONTROLLER_PLAY = "Play";
	public static final String CONTROLLER_PAUSE = "Pause";
	public static final String CONTROLLER_RESET = "Reset";
	public static final String CONTROLLER_UNDO = "Undo";
	public static final String CONTROLLER_UP = "^";
	public static final String CONTROLLER_LEFT = "<";
	public static final String CONTROLLER_DOWN = "v";
	public static final String CONTROLLER_RIGHT = ">";
	public static final String CONTROLLER_ZOOM_IN = "+";
	public static final String CONTROLLER_ZOOM_OUT = "-";
	public static final String CONTROLLER_CLEAR = "O";
	
	public static final String POP_UP_INVALID_IN = "Error Invalid input!";
	public static final String PRODUCER_NAME = "5810400981 Natthapach Anuwattananon";
	/**
	 * Disable constructor
	 */
	private ViewValues() {	}
	
	/**
	 * 
	 * @param mt top margin
	 * @param ml left margin
	 * @param mb bottom margin
	 * @param mr right margin
	 * @param pt top padding
	 * @param pl left padding
	 * @param pb bottom padding
	 * @param pr right padding
	 * @param title title text
	 * @return Border
	 */
	private static Border createBorder(int mt, int ml, int mb, int mr,
								int pt, int pl, int pb, int pr, String title){
		Border margin = new EmptyBorder(mt, ml, mb, mr);
		Border pading = new EmptyBorder(pt, pl, pb, pr);
		Border titleB = BorderFactory.createTitledBorder(title);
		Border border = BorderFactory.createCompoundBorder(margin,
						BorderFactory.createCompoundBorder(titleB, pading));
		return border;
	}
	
	public static Border getAmimationBorder(){
		return createBorder(ANIMATION_PANE_MARGIN_TOP, ANIMATION_PANE_MARGIN_LEFT, ANIMATION_PANE_MARGIN_BOTTOM, ANIMATION_PANE_MARGIN_RIGHT, ANIMATION_PANE_PADDING_TOP, ANIMATION_PANE_MARGIN_LEFT, ANIMATION_PANE_PADDING_BOTTOM, ANIMATION_PANE_PADDING_RIGHT, ANIMATION_PANE_TITLE);
	}
	public static Border getControlBorder(){
		return createBorder(CONTROL_PANE_MARGIN_TOP, CONTROL_PANE_MARGIN_LEFT, CONTROL_PANE_MARGIN_BOTTOM, CONTROL_PANE_MARGIN_RIGHT, CONTROL_PANE_PADDING_TOP, CONTROL_PANE_MARGIN_LEFT, CONTROL_PANE_PADDING_BOTTOM, CONTROL_PANE_PADDING_RIGHT, CONTROL_PANE_TITLE);
	}
	public static Border getEditorBorder(){
		return createBorder(EDITOR_PANE_MARGIN_TOP, EDITOR_PANE_MARGIN_LEFT, EDITOR_PANE_MARGIN_BOTTOM, EDITOR_PANE_MARGIN_RIGHT, EDITOR_PANE_PADDING_TOP, EDITOR_PANE_MARGIN_LEFT, EDITOR_PANE_PADDING_BOTTOM, EDITOR_PANE_PADDING_RIGHT, EDITOR_PANE_TITLE);
	}
	public static Border getInnerBorder(String title){
		return createBorder(INNER_PANE_MARGIN_TOP, INNER_PANE_MARGIN_LEFT, INNER_PANE_MARGIN_BOTTOM, INNER_PANE_MARGIN_RIGHT, INNER_PANE_PADDING_TOP, INNER_PANE_MARGIN_LEFT, INNER_PANE_PADDING_BOTTOM, INNER_PANE_PADDING_RIGHT, title);
	}
}
