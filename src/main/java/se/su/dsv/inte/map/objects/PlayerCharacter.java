package se.su.dsv.inte.map.objects;

import se.su.dsv.inte.items.Inventory;
import se.su.dsv.inte.items.Item;
import se.su.dsv.inte.map.Map;

public class PlayerCharacter extends EntityObject{

	private Inventory inventory;


	public PlayerCharacter(Map map, String name, double startingHealth, int startingMovePoints, double startingAttack) {
		super(map,name,startingHealth,startingMovePoints,startingAttack);
		this.inventory = new Inventory(16);
	}


	public Inventory getInventory() {

		return inventory;
	}

	public void increaseAttackBonus(Item i) {

		double attack = getAttack();
		
		attack = attack +i.getAttackBonus();
		
		super.setAttack(attack);
		
		
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
	
	public void increaseArmorBonus(Item i) {

		double armor = getArmor();
		
		armor = armor +i.getArmorBonus();
		
		super.setArmor(armor);
		
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