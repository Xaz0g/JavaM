package se.su.dsv.inte.map.objects;

import se.su.dsv.inte.controllers.MapObjectController;
import se.su.dsv.inte.map.Map;

public class MapObject {
	
	private final MapObjectController controller;
	private String name;
	private double maxHealth, currentHealth;
	
	public MapObject(Map map, String name, double startingHealth) {
		this.controller = new MapObjectController(map,this);
		setName(name);
		setMaxHealth(startingHealth);
		this.currentHealth = this.maxHealth;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		String cleanedName = name.trim();
		if(cleanedName.equals("")) {
			throw new IllegalArgumentException("MapObject name cannot be empty!");
		}
		this.name = name;
	}
	
	public double getMaxHealth() {
		return maxHealth;
	}
	
	public void setMaxHealth(double newMaxHealth) {
		if(newMaxHealth < 1) {
			throw new IllegalArgumentException("MapObject max health must be greater than zero!");
		}
		this.maxHealth = newMaxHealth;
	}

	public double getCurrentHealth() {
		return currentHealth;
	}
	
	public void setCurrentHealth(double newCurrentHealth) {
		if(newCurrentHealth < 0 || newCurrentHealth > maxHealth) {
			throw new IllegalArgumentException("MapObject current health cannot be greater than max health or less than zero!");
		}
		this.currentHealth = newCurrentHealth;
	}
	
	public void modifyCurrentHealth(double changeBy) {
		currentHealth += changeBy;
		
		if(currentHealth < 0) {
			currentHealth = 0;
		} else if(currentHealth > maxHealth) {
			currentHealth = maxHealth;
		}
		
		if(controller.getMap() != null) {
			controller.removeIfDestroyed();
		}
	}
	
	public boolean isDestroyed() {
		return currentHealth == 0 ? true : false;
	}

	public MapObjectController getController() {
		return controller;
	}
}
