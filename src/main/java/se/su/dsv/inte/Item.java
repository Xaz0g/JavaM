package se.su.dsv.inte;

public abstract class Item {

	private double weight;
	private String name;
	private double attack; 
	private double velocity;
	private double armorValue;


	public Item(String name, double weight, double attack, double velocity, double armorValue) {

		if(name == null){
			throw new NullPointerException();
		}
		if(name.length() > 3 && name.length() < 11) {this.name = name;}
			else {throw new IllegalArgumentException(); }
		
		if(weight > 0 && weight <= 200){this.weight = weight;}
			else {throw new IllegalArgumentException();	}

		if(attack >= 0 && attack <= 100){this.attack = attack;}
			else {throw new IllegalArgumentException(); }

		if(velocity >= 0 && velocity <= 5.0){this.velocity = velocity;}
			else {throw new IllegalArgumentException(); }

		if(armorValue >= 0 && armorValue <= 100){this.armorValue = armorValue;}
			else {throw new IllegalArgumentException(); }
	}

	

	public double getWeight(){
		return weight;
	};

	public String getName(){
		return name;
	};

	public double getVelocity(){
		return velocity;
	};

	public double getAttack(){
		return attack;
	};

	public double getArmorValue(){
		return armorValue;
	};
	
	// massa setMetoder();
	// skapa ett containerObject, en för ett corpse och en för en chest (?)

}