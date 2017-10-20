package se.su.dsv.inte.map.objects;

import static org.junit.Assert.*;

import org.junit.Test;

import se.su.dsv.inte.map.objects.EntityObject;

public class EntityObjectTest {
	
	EntityObject o = new EntityObject("testEntity", 100, 1, 10);
	
	@Test
	public void testAttack() {
		EntityObject enemy = new EntityObject("testEnemy",100,1,10);
		o.attack(enemy);
		assertEquals(90,enemy.getCurrentHealth(),0.0001);
		assertEquals(90,o.getCurrentHealth(),0.0001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAttackNull() {
		o.attack(null);
	}
	
	@Test
	public void testTakeDamage() {
		o.takeDamage(10);
		assertEquals(90,o.getCurrentHealth(),0.0001);
	}
	
	@Test
	public void testTakeDamageWithArmor() {
		o.setArmor(10);
		o.takeDamage(10);
		assertEquals(91,o.getCurrentHealth(),0.0001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTakeNegativeDamage() {
		o.takeDamage(-10);
	}
}
