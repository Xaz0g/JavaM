package se.su.dsv.inte;

public class Enemy extends MapObject{
	String name;
	private double maxHealth, currentHealth;
	private int speed;
	private final int standardHealth = 100; 
	
	public Enemy(String name){
		this.name = name;
		maxHealth = currentHealth = standardHealth;
	}
}
