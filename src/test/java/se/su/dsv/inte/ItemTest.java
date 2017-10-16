package se.su.dsv.inte;

import org.junit.*;
import static org.junit.Assert.*;

public class ItemTest {

	private Item i;

	private String validName = "name", longName = "namenamename", shortName = "na", nullName = null;
	private int validWeight = 10, maxWeight = 1000, negativeWeight = -1;
	private double validVelocity = 1, negativeVelocity = -1, maxVelocity = 5.01; // 5.00 är maxspeed, 5.01 testar så man inte kan vara mer än fem gånger snabbare än default
	private double validArmor, negativeArmor, maxArmor;
	private double validAttack;

	// Weapon-tests

	@Test
	public void validInput() {
		i = new Weapon(validName, validWeight, validAttack, validVelocity, validArmor);
		assertEquals(validWeight, i.getWeight());
		assertEquals(validArmor, i.getArmorValue(),0.001);
		assertEquals(validVelocity, i.getVelocity(), 0.001);
		assertEquals(validName, i.getName());

	}

	// 2 weight tests

//	@Test(expected = IndexOutOfBoundsException.class)
//	public void invalidWeightZero() {
//		i = new Weapon(validName, zeroWeight, validAttack, validSpeed, validArmor);
//	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void invalidWeightMax() {
		i = new Weapon(validName, maxWeight, validAttack, validVelocity, validArmor);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void invalidWeightNegative() {
		i = new Weapon(validName, negativeWeight, validAttack, validVelocity, validArmor);
	}

	// 2 speed tests

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidVelocityNegative() {
		i = new Weapon(validName, validWeight, validAttack, negativeVelocity, validArmor);
	}

	@Test
	public void invalidSpeedMax() {
		i = new Weapon(validName, validWeight, validAttack, maxVelocity, validArmor);
	}

	// 2 armor tests
	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidArmorNegative() {
		i = new Weapon(validName, validWeight, validAttack, validVelocity, negativeArmor);
	}

	@Test
	public void invalidArmorMax() {
		i = new Weapon(validName, validWeight, validAttack, validVelocity, maxArmor);
	}

	// 3 name tests
	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidNullName() {
		i = new Weapon(nullName, validWeight, validAttack, validVelocity, validArmor);
	}

	@Test
	public void invalidShortName() {
		i = new Weapon(shortName, validWeight, validAttack, validVelocity, validArmor);
	}

	@Test
	public void invalidLongName() {
		i = new Weapon(longName, validWeight, validAttack, validVelocity, validArmor);
	}

	// 2 attack tests

//	@Test
//	public void validAttackZero(){
//		i = new Weapon(validName, validWeight, validAttack, validVelocity, validArmor);
//	}

	@Test
	public void invalidAttackMax(){
		i = new Weapon(validName, validWeight, validAttack, validVelocity, validArmor);
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidAttackNegative(){
		i = new Weapon(validName, validWeight, validAttack, validVelocity, validArmor);
	}
}
