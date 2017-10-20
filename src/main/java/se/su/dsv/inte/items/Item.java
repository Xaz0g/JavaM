package se.su.dsv.inte.items;

public abstract class Item {

	private double weight;
	private String name;
	private double attackBonus; 
	private int movementBonus;
	private double armorBonus;


	public Item(String name, double weight, double attackBonus, int movementBonus, double armorBonus) {

		if(name == null){
			throw new NullPointerException();
		}
		if(name.length() > 3 && name.length() < 11) {this.name = name;}
			else {throw new IllegalArgumentException(); }
		
		if(weight > 0 && weight <= 200){this.weight = weight;}
			else {throw new IllegalArgumentException();	}

		if(attackBonus >= 0 && attackBonus <= 100){this.attackBonus = attackBonus;}
			else {throw new IllegalArgumentException(); }

		if(movementBonus >= 0 && movementBonus <= 5.0){this.movementBonus = movementBonus;}
			else {throw new IllegalArgumentException(); }

		if(armorBonus >= 0 && armorBonus <= 100){this.armorBonus = armorBonus;}
			else {throw new IllegalArgumentException(); }
	}

	

	public double getWeight(){
		return weight;
	};

	public String getName(){
		return name;
	};

	public int getMovementBonus(){
		return movementBonus;
	};

	public double getAttackBonus(){
		return attackBonus;
	};

	public double getArmorBonus(){
		return armorBonus;
	};
	
	// massa setMetoder();
	// skapa ett containerObject, en för ett corpse och en för en chest (?)

}