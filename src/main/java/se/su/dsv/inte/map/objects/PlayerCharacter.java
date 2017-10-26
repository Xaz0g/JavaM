package se.su.dsv.inte.map.objects;

import java.util.ArrayList;

import se.su.dsv.inte.items.Inventory;
import se.su.dsv.inte.items.Item;
import se.su.dsv.inte.map.Map;

public class PlayerCharacter extends EntityObject{

	private Inventory inventory;


	public PlayerCharacter(Map map, String name, double startingHealth, int startingMovePoints, double startingAttack) {
		super(map,name,startingHealth,startingMovePoints,startingAttack);
		this.inventory = new Inventory(16);
	}

	
	public void loot(ContainerObject cO) {
		if(cO.getStoredItems().size() > inventory.getSize()) {
			ArrayList<Item> temp = new ArrayList<Item>();
					temp.addAll(cO.getStoredItems().subList(0, inventory.getSize()));
					
					for(int i = 0; i < inventory.getSize(); i++) {
						cO.storedItems.set(i, checkItem(i)); 	// kopiera över items i Inventory till motsvarande plats i ContainerObject
					}
					inventory = new Inventory(temp);
		}else {
			if(cO.storedItems.size() > inventory.getSpaceLeft()) { //Om antalet lediga platser i inventory är färre än sakerna i loot
				int max = inventory.getSpaceLeft();
				
				for(int i = 0; i < max; i ++) {
					inventory.add(cO.storedItems.remove(0));
				}
				
			}else {	//Om antalet lediga platser i inventory är fler än sakerna i loot
				
				for(Item item : cO.storedItems) {
					inventory.add(item);
				}
				
			}
		}
	}
	
	
//	public Inventory getInventory() {
//
//		return inventory;
//	}
	
	public Item checkItem(int i) {
		return inventory.checkItem(i);
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

	private void decreaseAttackBonus(Item i) {
		double attack = getAttack();
		
		attack = attack -i.getAttackBonus();
		
		super.setAttack(attack);
	}
	
	private void decreaseArmorBonus(Item i) {
		
		double armor = getArmor();
		
		armor = armor -i.getArmorBonus();
		
		super.setArmor(armor);
	}
	
	private void decreaseMovementBonus(Item i) {
		
		int movementPoints = getMovementPoints();
		
		movementPoints = movementPoints -i.getMovementBonus();
		
		super.setMovementPoints(movementPoints);
	}

	public void addToInventory(Item i) {
		
		inventory.add(i);
		
		increaseAttackBonus(i);
		
		increaseArmorBonus(i);
		
		increaseMovementBonus(i);
		

	}

//	public void lookAtItemInInventory() {
//
//	}

	public void removeItemFromInventory(Item i) {
		
		if(inventory.remove(i)){
			decreaseAttackBonus(i);
			
			decreaseArmorBonus(i);
			
			decreaseMovementBonus(i);
		}
	}

//	public void checkPlaceInInventory() {
//
//	}


	
}