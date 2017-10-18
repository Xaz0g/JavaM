package se.su.dsv.inte;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerCharacterTest {
	
	PlayerCharacter p;
	private Inventory i = new Inventory(3);
	private String name = "Marie";
	private int health = 100, movePoints = 1, damage = 10;
	
	@Test
	public void testValidConstructor() {
		p = new PlayerCharacter(name, health, movePoints, damage, i);
		
		assertEquals(name,p.getName());
		assertEquals(health,p.getMaxHealth(),0.001);
		assertEquals(p.getMaxHealth(),p.getCurrentHealth(),0.001);
		assertEquals(movePoints,p.getMovementPoints());
		assertEquals(damage, p.getAttack(),0.001);
		assertEquals(i, p.getInventory());
		
	}
	
	@Test
	public void invalidGetInventory() {
		
	}
}
