package se.su.dsv.inte;

public abstract class Item {

	private int weight;
	private String name;
	private double attack; 
	private double velocity;
	private double armorValue;


	public Item(String name, int weight, double attack, double velocity, double armorValue) {
		this.name = name;
		
		if(weight > 0 && weight < 200){
			this.weight = weight;

		}else {
			throw new IndexOutOfBoundsException(); 
		}
		
		this.attack = attack;
		this.velocity = velocity;
		this.armorValue = armorValue;
	}

	

	public abstract int getWeight();

	public abstract String getName();

	public abstract double getVelocity();

	public abstract double getAttack();

	public abstract double getArmorValue();

}