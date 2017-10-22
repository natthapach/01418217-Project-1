package models.tweens;

import models.interfaces.Rotateable;
import models.interfaces.TweenObservable;
import models.interfaces.TweenObserver;

public class RotateTween implements TweenObserver{
	private double dTheta;
	private Integer anchorX;
	private Integer anchorY;

	public RotateTween(double dTheta) {
		this(dTheta, null, null);
	}
	public RotateTween(double dTheta, Integer anchorX, Integer anchorY) {
		this.dTheta = dTheta;
		this.anchorX = anchorX;
		this.anchorY = anchorY;
	}
	@Override
	public void update(TweenObservable obs) {
//		System.out.println(dTheta + " " + anchorX + " " + anchorY);
		if(obs instanceof Rotateable){
			Rotateable rotateable = (Rotateable) obs;
			if(anchorX == null || anchorY == null)
				rotateable.rotate(dTheta);
			else 
				rotateable.rotate(dTheta, anchorX, anchorY);
		}
	}

}
