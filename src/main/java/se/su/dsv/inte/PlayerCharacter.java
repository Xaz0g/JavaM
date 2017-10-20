package se.su.dsv.inte;

public class PlayerCharacter extends EntityObject{

	private Inventory inventory;


	public PlayerCharacter(String name, double startingHealth, int startingMovePoints, double startingAttack, Inventory inventory) {
		super(name,startingHealth,startingMovePoints,startingAttack);
		this.inventory = inventory;
	}


	public Inventory getInventory() {

		return inventory;
	}

	public double increaseAttackBonus(Item i) {

		double attack = getAttack();
		
		attack = attack +i.getAttackBonus();
		
		return attack;
		
//		NyAttack = befintligAttack + itemsAttack; 
//		
//		// Kollar befintlig styrka 
//		double currentAttack = getAttack();
//
//		// Plockar upp item med +3 styrka 
//		inventory.add(i);
//
//		// Kollar ny styrka 
//		double newAttack = getAttack();
//
//		// Kontrollerar om styrkan har ökats från den befintliga till den nya 
//		if (currentAttack < newAttack){ return true; }
//		else {return false;}

	}
	
	public double increaseArmorBonus(Item i) {

		double armor = getArmor();
		
		armor = armor +i.getArmorBonus();
		
		return armor;
	}
	
	public void increaseMovementBonus(Item i) {

		int movementPoints = getMovementPoints();
		
		movementPoints = movementPoints +i.getMovementBonus();
		
		super.setMovementPoints(movementPoints);
	}

	public void addToInventory(Item i) {
		
		inventory.add(i);
		
		increaseAttackBonus(i);
		
		increaseArmorBonus(i);
		
		increaseMovementBonus(i);
		

	}

	public void lookAtItemInInventory() {

	}

	public void removeItemFromInventory() {

	}

	public void checkPlaceInInventory() { // se om det finns platser kvar i inventory

	}


	
}