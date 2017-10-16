package se.su.dsv.inte;

public class MapObject {
	
	private String name;
	private double maxHealth, currentHealth;
	
	public MapObject(String name, double startingHealth) {
		String cleanedName = name.trim();
		if(cleanedName.equals("")) {
			throw new IllegalArgumentException("MapObject name cannot be empty!");
		}
		this.name = name;
		
		if(startingHealth < 1) {
			throw new IllegalArgumentException("MapObject starting helath must be greater than zero!");
		}
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
