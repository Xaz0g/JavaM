package se.su.dsv.inte.map.objects;

import static org.junit.Assert.*;

import org.junit.Test;

import se.su.dsv.inte.map.Map;

public class EnemyTest {

	@Test
	public void test() {
		assertEquals(true, (new Enemy(null, "Enemy", 100, 2, 10
				)instanceof Enemy));
	}

}
