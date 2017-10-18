package se.su.dsv.inte;

import static org.junit.Assert.*;

import org.junit.Test;

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
}
