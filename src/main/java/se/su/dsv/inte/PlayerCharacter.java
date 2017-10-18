package se.su.dsv.inte;

public class PlayerCharacter extends EntityObject{
	
	private Inventory inventory;
	
	
	public PlayerCharacter(String name, double startingHealth, int startingMovePoints, double startingDamage, Inventory inventory) {
		super(name,startingHealth,startingMovePoints,startingDamage);
		this.inventory = inventory;
	}
	
	
	public Inventory getInventory() {
		
		return inventory;
	}
	
	public void addToInventory() {
		
	}
	
	public void lookAtItemInInventory() {
		
	}
	
	public void removeItemFromInventory() {
		
	}
	
	public void checkPlaceInInventory() { // se om det finns platser kvar i inventory
		
	}
}