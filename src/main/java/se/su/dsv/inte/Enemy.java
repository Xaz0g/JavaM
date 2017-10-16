package se.su.dsv.inte;

public class Enemy extends MapObject{
	private int speed;
	
	public Enemy(String name, double startingHealth, int startingSpeed) {
		super(name,startingHealth);
		this.speed = startingSpeed;
	}
	
	public int getSpeed() {
		return speed;
	}
}
