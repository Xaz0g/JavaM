package se.su.dsv.inte;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MapObjectTest {
	
	MapObject o;
	
	@Test
	public void testValidConstructor() {
		o = new MapObject("Axel",100);
		
		assertEquals("Axel",o.getName());
		assertEquals(100,o.getMaxHealth(),0.001);
		assertEquals(o.getMaxHealth(),o.getCurrentHealth(),0.001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyName() {
		o = new MapObject("",100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBlankspaceName() {
		o = new MapObject("      ",100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testZeroStartingHealth() {
		o = new MapObject("Axel",0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeStartingHealth() {
		o = new MapObject("Axel",-1);
	}
}
