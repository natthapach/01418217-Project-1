package models.tweens;

import models.interfaces.Moveable;
import models.interfaces.TweenObservable;
import models.interfaces.TweenObserver;

public class MoveTween implements TweenObserver{
	private int dx;
	private int dy;
	public MoveTween(int initX, int endX, int initY, int endY, int duration){
		this((endX-initX)/duration, (endY-initY)/duration);
	}
	public MoveTween(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
	@Override
	public void update(TweenObservable obs) {
		if(obs instanceof Moveable){
			Moveable moveable = (Moveable) obs;
			moveable.move(dx, dy);
		}
	}
}
