package se.su.dsv.inte;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerCharacterTest {
	
	PlayerCharacter p;
	private Inventory i = new Inventory(3);
	private String name = "Marie";
	private int health = 100, movePoints = 1, attack = 10;
	private Item item;
	
	@Test
	public void testValidConstructor() {
		p = new PlayerCharacter(name, health, movePoints, attack, i);
		
		assertEquals(name,p.getName());
		assertEquals(health,p.getMaxHealth(),0.001);
		assertEquals(p.getMaxHealth(),p.getCurrentHealth(),0.001);
		assertEquals(movePoints,p.getMovementPoints());
		assertEquals(attack, p.getAttack(),0.001);
		assertEquals(i, p.getInventory());
		
	}
	
	
	@Test
	public void validIncreaseAttackBonus() {
		p = new PlayerCharacter(name, health, movePoints, attack, i);
		item = new Weapon("Weapon", 2, 3, 4, 5);
		assertEquals(item.getAttackBonus() + attack , p.increaseAttackBonus(item), 0.001);
	}
	
	@Test
	public void validIncreaseArmorBonus() {
		p = new PlayerCharacter(name, health, movePoints, attack, i);
		item = new Weapon("Weapon", 2, 3, 4, 5);
		assertEquals(item.getArmorBonus() + p.getArmor() , p.increaseArmorBonus(item), 0.001);
	}
	
	@Test
	public void validIncreaseMovementBonus() {
		p = new PlayerCharacter(name, health, movePoints, attack, i);
		item = new Weapon("Weapon", 2, 3, 4, 5);
		assertEquals(item.getMovementBonus() + movePoints , p.getMovementPoints());
	}
	
}
