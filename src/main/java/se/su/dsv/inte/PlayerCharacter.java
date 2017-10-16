package se.su.dsv.inte;

public class PlayerCharacter extends MapObject{
	
	private int speed;
	
	public PlayerCharacter(String name, double startingHealth, int startingSpeed) {
		super(name,startingHealth);
		this.speed = startingSpeed;
	}

	public int getSpeed() {
		return speed;
	}
	
	
}