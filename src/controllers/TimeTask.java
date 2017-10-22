package controllers;

import models.interfaces.Clockable;

public class TimeTask implements Runnable{
	
	private long frame;
	private int delay;
	private boolean run;
	private Clockable clockable;
	
	public TimeTask(int delay, Clockable clockable) {
		this.delay = delay;
		this.clockable = clockable;
	}
	
	@Override
	public void run() {
		try{
			while(run){
				clockable.tick(frame);
				frame++;
				Thread.sleep(delay);
			}	
		}catch (InterruptedException e) {
			
		}
	}
	
	public void resetTime(){
		frame = 0;
	}
	public void start(){
		if(!run){
			run = true;
			Thread t = new Thread(this);
			t.start();
		}	
	}
	public void stop(){
		run = false;
		System.out.println("stop!!");
	}
}
