package se.su.dsv.inte;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerCharacterTest {
	
	PlayerCharacter p;
	
	@Test
	public void testValidConstructor() {
		p = new PlayerCharacter("Axel",100,1);
		
		assertEquals("Axel",p.getName());
		assertEquals(100,p.getMaxHealth(),0.001);
		assertEquals(p.getMaxHealth(),p.getCurrentHealth(),0.001);
		assertEquals(1,p.getSpeed());
	}
}
