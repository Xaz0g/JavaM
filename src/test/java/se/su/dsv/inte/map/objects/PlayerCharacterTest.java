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
	private int health = 100, movePoints = 1, attack = 10;
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
	public void validLookAtInventory() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		item1 = new Weapon("Weapon", 2, 3, 4, 5);
		item2 = new Weapon("Armor", 2, 3, 4, 5);
		p.addToInventory(item1);
		p.addToInventory(item2);
		
		
	}
}
