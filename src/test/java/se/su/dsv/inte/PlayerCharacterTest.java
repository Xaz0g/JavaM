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
		p = new PlayerCharacter("Axel",100,1,10, i);
		
		assertEquals("Axel",p.getName());
		assertEquals(100,p.getMaxHealth(),0.001);
		assertEquals(p.getMaxHealth(),p.getCurrentHealth(),0.001);
		assertEquals(1,p.getMovementPoints());
	}
	
	@Test
	public void validGetInventory() {
		p = new PlayerCharacter(name, health, movePoints, damage, i);
		assertEquals(i, p.getInventory());
	}
	
	@Test
	public void invalidGetInventory() {
		
	}
}
