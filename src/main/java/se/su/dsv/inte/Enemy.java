package se.su.dsv.inte;

public class Enemy extends MapObject{
	String name;
	private double maxHealth, currentHealth;
	private int speed;
	
	public Enemy(String name){
		this.name = name;
	}
}
