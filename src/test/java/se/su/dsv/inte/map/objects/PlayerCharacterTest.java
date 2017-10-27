package se.su.dsv.inte.map.objects;

import static org.junit.Assert.*;

import org.junit.Test;

import se.su.dsv.inte.items.Inventory;
import se.su.dsv.inte.items.Item;
import se.su.dsv.inte.items.Weapon;
import se.su.dsv.inte.map.objects.PlayerCharacter;

public class PlayerCharacterTest {
	
	PlayerCharacter p;
	private Inventory i = new Inventory(3);
	private String name = "Marie";
	private int health = 100, movePoints = 2, attack = 10;
	private Item item, item1, item2;
	
	@Test
	public void testValidConstructor() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		
		assertEquals(name,p.getName());
		assertEquals(health,p.getMaxHealth(),0.001);
		assertEquals(p.getMaxHealth(),p.getCurrentHealth(),0.001);
		assertEquals(movePoints,p.getMovementPoints());
		assertEquals(attack, p.getAttack(),0.001);
		
	}
	
	
	@Test
	public void validIncreaseAttackBonus() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		item = new Weapon("Weapon", 2, 3, 4, 5);
		p.increaseAttackBonus(item);
		assertEquals((item.getAttackBonus() + attack) , p.getAttack(), 0.001);
	}
	
	@Test
	public void validIncreaseArmorBonus() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		item = new Weapon("Weapon", 2, 3, 4, 5);
		double armor = p.getArmor();
		p.increaseArmorBonus(item);
		assertEquals((item.getArmorBonus() + armor) , p.getArmor(), 0.001);
	}
	
	@Test
	public void validIncreaseMovementBonus() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		item = new Weapon("Weapon", 2, 3, 4, 5);
		p.increaseMovementBonus(item);
		assertEquals((item.getMovementBonus() + movePoints) , p.getMovementPoints() );
	}
	
	@Test
	public void validDecreaseAttackBonus() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		item = new Weapon("Weapon", 2, 3, 4, 5);
		p.decreaseAttackBonus(item);
		assertEquals((attack - item.getAttackBonus()), p.getAttack(), 0.001);
	}
	
	@Test
	public void validDecreaseAttackBelowZeroResultsInZero() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		int greaterThanAttack = 11;
		item = new Weapon("Weapon", 2, greaterThanAttack, 4, 5);
		p.decreaseAttackBonus(item);
		assertEquals(0, p.getAttack(), 0.001);
	}
	
	@Test
	public void validDecreaseArmorBonus() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		double armorBig = 6.0;
		double armorSmall = 5.0;
		item = new Weapon("Weapon", 2, 3, 4, armorSmall);
		p.setArmor(armorBig);
		p.decreaseArmorBonus(item);
		assertEquals((armorBig - armorSmall) , p.getArmor(), 0.001);
	}
	
	@Test
	public void validDecreaseArmorBelowZeroResultsInZero() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		item = new Weapon("Weapon", 2, 3, 4, 5);
		p.decreaseArmorBonus(item);
		assertEquals(0, p.getArmor(), 0.001);
	}
	
	@Test
	public void validDecreaseMovementBonus() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		int smallMove = 1;
		item = new Weapon("Weapon", 2, 3, smallMove, 5);
		p.decreaseMovementBonus(item);
		assertEquals(movePoints - smallMove , p.getMovementPoints());
	}
	
	@Test
	public void validDecreaseMovementBelowZeroResultsInZero() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		item = new Weapon("Weapon", 2, 3, 4, 5);
		p.decreaseMovementBonus(item);
		assertEquals(0, p.getMovementPoints(), 0.001);
	}
	
	@Test
	public void validLookAtInventory() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		item1 = new Weapon("Weapon", 2, 3, 4, 5);
		item2 = new Weapon("Armor", 2, 3, 4, 5);
		p.addToInventory(item1);
		p.addToInventory(item2);
		
		
	}
	
	@Test
	public void checkItemTest() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		item = new Weapon("Weapon", 2, 3, 4, 5);
		item1 = new Weapon("Weapon", 2, 3, 4, 5);
		item2 = new Weapon("Armor", 2, 3, 4, 5);
		
		p.addToInventory(item);
		p.addToInventory(item1);
		p.addToInventory(item2);
		
		assertEquals(item, p.checkItem(0));
		assertEquals(item1, p.checkItem(1));
		assertEquals(item2, p.checkItem(2));
		
	}
	
	@Test
	public void validRemoveItemFromInventory() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		
		double weight = 1;
		double attackBonus = 1;
		int movementBonus = 1;
		double armorBonus = 1;
		
		item = new Weapon("Weapon", weight, attackBonus, movementBonus, armorBonus);
		p.addToInventory(item);
		
		p.removeItemFromInventory(item);
		/*h =100;
		m= 2;
		att= 10;
		arm= 0;
		*/
		assertEquals(2, p.getMovementPoints(), 0.001);
		assertEquals(10, p.getAttack(), 0.001);
		assertEquals(0, p.getArmor(), 0.001);
		assertNull(p.checkItem(0));
	} 
}
