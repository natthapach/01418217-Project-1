package models.drawings;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.lang.reflect.Array;
import java.util.ArrayList;

import models.ColorLib;

public class Earth extends AbstractDrawing{
	public static final int STROKE_WIDTH = 6;
	public static final Color LAND_GREEN = ColorLib.EARTH_LAND_GREEAN.color;
	public static final Color LAND_BROWN = ColorLib.EARTH_LAND_BROWN.color;
	public static final Color OCEAN_BLUE = ColorLib.EARTH_OCEAN_BLUE.color;
	public static final Color OCEAN_LIGHT_BLUE = ColorLib.EARTH_OCEAN_LIGHT_BLUE.color;
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;

	private Color landColor;
	private Color oceanColor;
	
	public Earth(int x, int y){
		this(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	public Earth(int x, int y, int width, int height) {
		super(x, y, width, height, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		landColor = LAND_GREEN;
		oceanColor = OCEAN_BLUE;	
	}

	@Override
	protected void drawImage(Graphics2D g2) {
		
		// create shape
		Ellipse2D.Float earth = new Ellipse2D.Float(STROKE_WIDTH/2, STROKE_WIDTH/2, width-STROKE_WIDTH, height-STROKE_WIDTH);
		
		ArrayList<GeneralPath> lands = new ArrayList<>();
		lands.add(createWestLand());
		lands.add(createEastLand());
		lands.add(createNorthLand());
		lands.add(createSouthLand());
		lands.add(createSouthIsland());
		
		// draw
		g2.setColor(oceanColor);
		g2.fill(earth);
		g2.setColor(landColor);
		for(GeneralPath l : lands)
			g2.fill(l);
		
		Stroke stroke = new BasicStroke(STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		g2.setStroke(stroke);
		
		g2.setColor(Color.BLACK);
		g2.draw(earth);
		for(GeneralPath l : lands)
			g2.draw(l);
	}
	private GeneralPath createWestLand(){
		GeneralPath land = new GeneralPath();
		land.moveTo(4, 222);
		land.quadTo(4, 222, 25, 265);
		land.quadTo(25, 265, 35, 278);
		land.quadTo(35, 278, 41, 271);
		land.quadTo(41, 271, 42, 256);
		land.quadTo(42, 256, 41, 250);
		land.quadTo(41, 250, 46, 246);
		land.quadTo(46, 246, 47, 238);
		land.quadTo(47, 238, 45, 228);
		land.quadTo(45, 228, 55, 224);
		land.quadTo(55, 224, 59, 228);
		land.quadTo(59, 228, 74, 259);
		land.quadTo(74, 259, 80, 258);
		land.quadTo(80, 258, 79, 250);
		land.quadTo(79, 250, 71, 234);
		land.quadTo(71, 234, 69, 223);
		land.quadTo(69, 223, 76, 217);
		land.quadTo(76, 217, 68, 207);
		land.quadTo(68, 207, 69, 197);
		land.quadTo(69, 197, 69, 182);
		land.quadTo(69, 182, 76, 164);
		land.quadTo(76, 164, 78, 146);
		land.quadTo(78, 146, 86, 136);
		land.quadTo(86, 136, 93, 138);
		land.quadTo(93, 138, 99, 149);
		land.quadTo(99, 149, 100, 155);
		land.quadTo(100, 155, 106, 154);
		land.quadTo(106, 154, 105, 140);
		land.curveTo(105, 140, 101, 151, 105, 116);
		land.quadTo(105, 116, 111, 104);
		land.quadTo(111, 104, 107, 84);
		land.quadTo(107, 84, 116, 75);
		land.quadTo(116, 75, 122, 79);
		land.quadTo(122, 79, 118, 86);
		land.quadTo(118, 86, 125, 95);
		land.quadTo(125, 95, 131, 88);
		land.quadTo(131, 88, 133, 73);
		land.quadTo(133, 73, 152, 56);
		land.curveTo(152, 56, 152, 43, 143, 42);
		land.quadTo(143, 42, 123, 46);
		land.quadTo(123, 46, 92, 46);
		land.quadTo(92, 46, 84, 39);
		land.curveTo(84, 39, 0, 80, 4, 222);
		return land;
	}
	private GeneralPath createEastLand(){
		GeneralPath land = new GeneralPath();
		land.moveTo(285, 23);
		land.lineTo(271, 34);
		land.lineTo(259, 37);
		land.lineTo(249, 37);
		land.lineTo(237, 33);
		land.lineTo(226, 31);
		land.lineTo(210, 37);
		land.lineTo(198, 38);
		land.lineTo(193, 37);
		land.lineTo(185, 45);
		land.lineTo(189, 57);
		land.lineTo(188, 69);
		land.lineTo(185, 79);
		land.lineTo(189, 85);
		land.lineTo(195, 85);
		land.lineTo(204, 76);
		land.lineTo(215, 74);
		land.lineTo(228, 84);
		land.lineTo(232, 96);
		land.lineTo(232, 107);
		land.lineTo(243, 122);
		land.lineTo(247, 134);
		land.lineTo(247, 153);
		land.lineTo(245, 160);
		land.lineTo(247, 166);
		land.lineTo(252, 167);
		land.lineTo(253, 147);
		land.lineTo(258, 149);
		land.curveTo(258, 149, 260, 180, 281, 176);
		land.curveTo(281, 176, 300, 180, 274, 226);
		land.curveTo(274, 226, 270, 240, 287, 259);
		land.curveTo(287, 259, 275, 268, 292, 277);
		land.curveTo(292, 277, 285, 275, 289, 295);
		land.lineTo(277, 314);
		land.lineTo(260, 335);
		land.curveTo(260, 335, 270, 345, 266, 355);
		land.curveTo(266, 355, 275, 360, 274, 346);
		land.curveTo(274, 346, 280, 335, 287, 338);
		land.curveTo(287, 338, 305, 340, 328, 291);
		land.curveTo(328, 291, 345, 300, 361, 288);
		land.curveTo(361, 288, 370, 275, 371, 261);
		land.curveTo(371, 250, 370, 245, 382, 232);
		land.curveTo(382, 232, 390, 195, 352, 193);
		land.curveTo(352, 193, 345, 190, 336, 200);
		land.curveTo(336, 200, 325, 190, 317, 203);
		land.curveTo(317, 203, 305, 210, 301, 192);
		land.curveTo(301, 192, 290, 182, 300, 172);
		land.curveTo(300, 172, 305, 160, 293, 159);
		land.curveTo(293, 159, 280, 170, 282, 155);
		land.curveTo(282, 155, 300, 130, 319, 143);
		land.lineTo(319, 150);
		land.lineTo(325, 158);
		land.lineTo(326, 132);
		land.lineTo(338, 121);
		land.lineTo(342, 96);
		land.lineTo(355, 78);
		land.curveTo(355, 78, 340, 45, 285, 23);
		return land;
	}
	private GeneralPath createNorthLand(){
		GeneralPath land = new GeneralPath();
		
		land.moveTo(95, 32);
		land.lineTo(100, 37);
		land.lineTo(111, 38);
		land.lineTo(117, 34);
		land.lineTo(129, 30);
		land.lineTo(140, 29);
		land.lineTo(151, 35);
		land.lineTo(160, 38);
		land.lineTo(183, 35);
		land.lineTo(190, 34);
		land.lineTo(199, 26);
		land.lineTo(209, 20);
		land.lineTo(225, 18);
		land.lineTo(246, 22);
		land.lineTo(259, 24);
		land.lineTo(270, 23);
		land.lineTo(276, 18);
		land.curveTo(276, 18, 200, -25, 95, 32);
		
		return land;
	}
	private GeneralPath createSouthIsland(){
		GeneralPath land = new GeneralPath();
		
		land.moveTo(115, 313);
		land.lineTo(115, 304);
		land.lineTo(112, 300);
		land.lineTo(108, 301);
		land.lineTo(104, 308);
		land.lineTo(100, 309);
		land.lineTo(96, 304);
		land.lineTo(92, 304);
		land.lineTo(88, 307);
		land.lineTo(84, 307);
		land.lineTo(80, 304);
		land.lineTo(72, 304);
		land.lineTo(68, 308);
		land.lineTo(69, 316);
		land.lineTo(70, 321);
		land.lineTo(70, 336);
		land.lineTo(73, 340);
		land.lineTo(88, 341);
		land.lineTo(95, 348);
		land.lineTo(97, 355);
		land.lineTo(103, 361);
		land.lineTo(112, 362);
		land.lineTo(117, 366);
		land.lineTo(121, 365);
		land.lineTo(124, 359);
		land.lineTo(126, 342);
		land.lineTo(131, 335);
		land.lineTo(132, 329);
		land.lineTo(130, 324);
		land.lineTo(121, 320);
		land.lineTo(115, 313);
		
		return land;
	}
	private GeneralPath createSouthLand(){
		GeneralPath land = new GeneralPath();
		
		land.moveTo(139, 387);
		land.lineTo(149, 386);
		land.lineTo(159, 381);
		land.lineTo(167, 373);
		land.lineTo(183, 370);
		land.lineTo(191, 364);
		land.lineTo(193, 357);
		land.lineTo(206, 348);
		land.lineTo(235, 360);
		land.lineTo(253, 371);
		land.lineTo(261, 373);
		land.lineTo(273, 370);
		land.lineTo(283, 364);
		land.lineTo(292, 360);
		land.lineTo(297, 365);
		land.lineTo(299, 371);
		land.curveTo(299, 371, 200, 420, 139, 387);
		
		return land;
	}

	public Color getLandColor() {
		return landColor;
	}

	public Color getOceanColor() {
		return oceanColor;
	}

	public void setLandColor(Color landColor) {
		this.landColor = landColor;
	}

	public void setOceanColor(Color oceanColor) {
		this.oceanColor = oceanColor;
	}
	
}
