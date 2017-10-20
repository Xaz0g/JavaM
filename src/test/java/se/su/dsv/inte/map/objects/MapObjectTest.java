package se.su.dsv.inte.map.objects;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import se.su.dsv.inte.map.objects.MapObject;

public class MapObjectTest {
	
	MapObject o = new MapObject(null,"Axel",100);
	
	@Test
	public void testValidNameAndHealth() {
		assertEquals("Axel",o.getName());
		assertEquals(100,o.getMaxHealth(),0.0001);
		assertEquals(o.getMaxHealth(),o.getCurrentHealth(),0.0001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyName() {
		o = new MapObject(null,"",100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBlankspaceName() {
		o = new MapObject(null,"      ",100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testZeroStartingHealth() {
		o = new MapObject(null,"Axel",0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeStartingHealth() {
		o = new MapObject(null,"Axel",-1);
	}
	
	@Test
	public void testSetValidName() {
		o.setName("Andersson");
		assertEquals("Andersson",o.getName());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetEmptyName() {
		o.setName("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetBlankspaceName() {
		o.setName("   ");
	}
	
	@Test
	public void testSetValidMaxHealth() {
		o.setMaxHealth(50);
		assertEquals(50,o.getMaxHealth(),0.0001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMaxHealth() {
		o.setMaxHealth(0);
	}
	
	@Test
	public void testSetValidCurrentHealth() {
		o.setCurrentHealth(50);
		assertEquals(50,o.getCurrentHealth(),0.0001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTooHighCurrentHealth() {
		o.setCurrentHealth(o.getMaxHealth() + 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTooLowCurrentHealth() {
		o.setCurrentHealth(-1);
	}
	
	@Test
	public void testModifyCurrentHealthInRange() {
		o.modifyCurrentHealth(-50);
		assertEquals(50,o.getCurrentHealth(),0.0001);
	}
	
	@Test
	public void testModifyCurrentHealthBelowZero() {
		o.modifyCurrentHealth(-110);
		assertEquals(0,o.getCurrentHealth(),0.0001);
	}
	
	@Test
	public void testModifyCurrentHealthAboveMax() {
		o.modifyCurrentHealth(1);
		assertEquals(o.getMaxHealth(),o.getCurrentHealth(),0.0001);
	}
	
	@Test
	public void checkDestroyedHealthAboveZero() {
		assertEquals(false, o.isDestroyed());
	}
	
	@Test
	public void checkDestroyedHealthIsZero() {
		o.setCurrentHealth(0);
		assertEquals(true, o.isDestroyed());
	}
	
}
