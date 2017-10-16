package se.su.dsv.inte;

import org.junit.*;
import static org.junit.Assert.*;

public class ItemTest {

	private Item i;

	private String validName = "name", longName = "namenamename", shortName = "na", nullName = null;
	private double validWeight = 10.0, exceededWeight = 1000, negativeWeight = -1;
	private double validVelocity = 1, negativeVelocity = -1, exceededVelocity = 5.01; // 5.00 är exceededspeed, 5.01 testar så man inte kan vara mer än fem gånger snabbare än default
	private double validArmor = 5, negativeArmor = -1, exceededArmor = 101;
	private double validAttack = 3, negativeAttack = -1, exceededAttack = 101;

	// Weapon-tests

	@Test
	public void validInput() {
		i = new Weapon(validName, validWeight, validAttack, validVelocity, validArmor);
		assertEquals(validWeight, i.getWeight(),0.001);
		assertEquals(validArmor, i.getArmorValue(),0.001);
		assertEquals(validVelocity, i.getVelocity(), 0.001);
		assertEquals(validName, i.getName());
		assertEquals(validAttack, i.getAttack(), 0.001);

	}

	// 2 weight tests

	@Test(expected = IllegalArgumentException.class)
	public void WeightExceeded() {
		i = new Weapon(validName, exceededWeight, validAttack, validVelocity, validArmor);
	}

	@Test(expected = IllegalArgumentException.class)
	public void WeightNegative() {
		i = new Weapon(validName, negativeWeight, validAttack, validVelocity, validArmor);
	}

	// 2 speed tests

	@Test (expected = IllegalArgumentException.class)
	public void velocityNegative() {
		i = new Weapon(validName, validWeight, validAttack, negativeVelocity, validArmor);
	}

	@Test(expected = IllegalArgumentException.class)
	public void speedExceeded() {
		i = new Weapon(validName, validWeight, validAttack, exceededVelocity, validArmor);
	}

	// 2 armor tests

	@Test (expected = IllegalArgumentException.class)
	public void armorNegative() {
		i = new Weapon(validName, validWeight, validAttack, validVelocity, negativeArmor);
	}

	@Test(expected = IllegalArgumentException.class)
	public void armorExceeded() {
		i = new Weapon(validName, validWeight, validAttack, validVelocity, exceededArmor);
	}

	// 3 name tests

	@Test (expected = NullPointerException.class)
	public void nullName() {
		i = new Weapon(nullName, validWeight, validAttack, validVelocity, validArmor);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shortName() {
		i = new Weapon(shortName, validWeight, validAttack, validVelocity, validArmor);
	}

	@Test(expected = IllegalArgumentException.class)
	public void longName() {
		i = new Weapon(longName, validWeight, validAttack, validVelocity, validArmor);
	}

	// 2 attack tests

	@Test(expected = IllegalArgumentException.class)
	public void attackExceeded(){
		i = new Weapon(validName, validWeight, exceededAttack, validVelocity, validArmor);
	}

	@Test (expected = IllegalArgumentException.class)
	public void attackNegative(){
		i = new Weapon(validName, validWeight, negativeAttack, validVelocity, validArmor);
	}
}
