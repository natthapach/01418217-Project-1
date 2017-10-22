package models.interfaces;

public interface TweenObservable {
	void addObserver(TweenObserver observer);
	void removeObserver(TweenObserver observer);
	void notifyObservers();
}
