package se.su.dsv.inte;

public class MapObject {
	
	private String name;
	private double maxHealth, currentHealth;
	
	public MapObject(String name, double startingHealth) {
		this.name = name;
		this.maxHealth = startingHealth;
		this.currentHealth = this.maxHealth;
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
}
