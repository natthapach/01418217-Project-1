package models.tweens;

import models.interfaces.Scaleable;
import models.interfaces.TweenObservable;
import models.interfaces.TweenObserver;

public class ScaleTween implements TweenObserver{
	private Double pw = null;
	private Double ph = null;
	private Integer w = null;
	private Integer h = null;
	
	public ScaleTween(Double pw, Double ph) {
		this.pw = pw;
		this.ph = ph;
	}
	public ScaleTween(Integer w, Integer h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public void update(TweenObservable obs) {
		if(obs instanceof Scaleable){
			Scaleable scaleable = (Scaleable) obs;
			if(pw!=null && ph!=null)
				scaleable.scale(pw, ph);
			else if(w!=null && h!=null)
				scaleable.scale(w, h);
		}
	}
}
