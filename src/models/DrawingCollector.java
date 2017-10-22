package models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import models.drawings.AbstractDrawing;
import models.drawings.Earth;

public class DrawingCollector implements Iterable<AbstractDrawing>{
	private LinkedList<AbstractDrawing> drawings = new LinkedList<>();
	
	public void addDrawing(AbstractDrawing drawing){
		drawings.add(drawing);
	}
	public boolean removeDrawing(AbstractDrawing drawing){
		return drawings.remove(drawing);
	}
	public AbstractDrawing pop(){
		return drawings.removeLast();
	}
	public void clear(){
		drawings.clear();
	}
	@Override
	public Iterator<AbstractDrawing> iterator() {
		return drawings.iterator();
	}
	
//	public AbstractDrawing getDrawingByPosition(int x, int y){
//		
//	}
}
