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
		if(cO.getStoredItems().size() > inventory.getSize()) { // Antalet platser totalt i ContainerObject är fler än antalet platser totalt i inventory
			ArrayList<Item> temp = new ArrayList<Item>();
					temp.addAll(cO.getStoredItems().subList(0, inventory.getSize()));
					
					for(int i = 0; i < inventory.getSize(); i++) {
						cO.getStoredItems().set(i, checkItem(i)); 	// kopiera över items i Inventory, lägg på motsvarande plats i ContainerObject
					}
					
					//infört nedanstående istället för --> inventory = new Inventory(temp);	//ändrar inga stats
					
					for(int i = 0; i< inventory.getIndex(); i++) {
						removeItemFromInventory(inventory.checkItem(i));
					}
					
					for(Item item : temp) {
						addToInventory(item);
					}
					
		}else {													// Antalet platser totalt i ContainerObject är färre än antalet platser totalt i inventory
			
			if(cO.getStoredItems().size() > inventory.getSpaceLeft()) { //Om antalet lediga platser i inventory är färre än sakerna i loot
				int max = inventory.getSpaceLeft();
				
				for(int i = 0; i < max; i ++) {
					addToInventory(cO.getStoredItems().remove(0));
					//inventory.add(cO.getStoredItems().remove(0));	//ändrar inga stats
				}
				
			}else {	//Om antalet lediga platser i inventory är fler än sakerna i loot
				
				for(Item item : cO.getStoredItems()) {
					addToInventory(item);
					//inventory.add(item);	//ändrar inga stats
				}
				
			}
		}
	}


//	public Inventory getInventory() {
//
//		return inventory;
//	}
	
	protected Item checkItem(int i) {
		return inventory.checkItem(i);
	}

	protected void increaseAttackBonus(Item i) {

		double attack = getAttack();
		
		attack = attack + i.getAttackBonus();
		
		super.setAttack(attack);
	}
	
	protected void increaseArmorBonus(Item i) {

		double armor = getArmor();
		
		armor = armor + i.getArmorBonus();
		
		super.setArmor(armor);
		
	}
	
	protected void increaseMovementBonus(Item i) {

		int movementPoints = getMovementPoints();
		
		movementPoints = movementPoints + i.getMovementBonus();
		
		super.setMovementPoints(movementPoints);
	}

	protected void decreaseAttackBonus(Item i) {
		double attack = getAttack();
		
		if(attack - i.getAttackBonus() < 0) {
			attack = 0;
		}else {
			attack = attack - i.getAttackBonus();
		}
		
		super.setAttack(attack);
	}
	
	protected void decreaseArmorBonus(Item i) {
		
		double armor = getArmor();
		
		if(armor - i.getArmorBonus() < 0) {
			armor = 0;
		}else {
			armor = armor - i.getArmorBonus();
		}
		
		super.setArmor(armor);
	}
	
	protected void decreaseMovementBonus(Item i) {
		
		int movementPoints = getMovementPoints();
		
		if(movementPoints - i.getMovementBonus() < 0) {
			movementPoints = 0;
		}else {
			movementPoints = movementPoints - i.getMovementBonus();
		}
		
		super.setMovementPoints(movementPoints);
	}

	protected void addToInventory(Item i) {
		
		inventory.add(i);
		
		increaseAttackBonus(i);
		
		increaseArmorBonus(i);
		
		increaseMovementBonus(i);
		

	}

//	public void lookAtItemInInventory() {
//
//	}

	protected void removeItemFromInventory(Item i) {
		
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