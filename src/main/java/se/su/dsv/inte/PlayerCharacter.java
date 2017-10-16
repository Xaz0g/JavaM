package se.su.dsv.inte;

public class PlayerCharacter extends MapObject{
	
	private String name;
	private double maxHealth, currentHealth;
	private int speed;
	
	public PlayerCharacter(String name, double startingHealth, int startingSpeed) {
		this.name = name;
		this.maxHealth = startingHealth;
		this.currentHealth = this.maxHealth;
		this.speed = startingSpeed;
	}

	public String getName() {
		return name;
	}

	public double getMaxHealth() {
		return maxHealth;
	}

	public double getCurrentHealth() {
		return currentHealth;
	}

	public int getSpeed() {
		return speed;
	}
	
	
}