package se.su.dsv.inte;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArmorTest {
	
	private Item i;

	private String validName = "name", longName = "namenamename", shortName = "na", nullName = null;
	private double validWeight = 10.0, exceededWeight = 1000, negativeWeight = -1;
	private int validVelocity = 1, negativeVelocity = -1, exceededVelocity = 6; // 5.00 är exceededspeed, 5.01 testar så man inte kan vara mer än fem gånger snabbare än default
	private double validArmor = 5, negativeArmor = -1, exceededArmor = 101;
	private double validAttack = 3, negativeAttack = -1, exceededAttack = 101;
	
	@Test
	public void validInput() {
		i = new Cosmetic(validName, validWeight, validAttack, validVelocity, validArmor);
		assertEquals(validWeight, i.getWeight(),0.001);
		assertEquals(validArmor, i.getArmorBonus(),0.001);
		assertEquals(validVelocity, i.getMovementBonus(), 0.001);
		assertEquals(validName, i.getName());
		assertEquals(validAttack, i.getAttackBonus(), 0.001);

	}

	// 2 weight tests

	@Test(expected = IllegalArgumentException.class)
	public void WeightExceeded() {
		i = new Cosmetic(validName, exceededWeight, validAttack, validVelocity, validArmor);
	}

	@Test(expected = IllegalArgumentException.class)
	public void WeightNegative() {
		i = new Cosmetic(validName, negativeWeight, validAttack, validVelocity, validArmor);
	}

	// 2 speed tests

	@Test (expected = IllegalArgumentException.class)
	public void velocityNegative() {
		i = new Cosmetic(validName, validWeight, validAttack, negativeVelocity, validArmor);
	}

	@Test(expected = IllegalArgumentException.class)
	public void speedExceeded() {
		i = new Cosmetic(validName, validWeight, validAttack, exceededVelocity, validArmor);
	}

	// 2 armor tests

	@Test (expected = IllegalArgumentException.class)
	public void armorNegative() {
		i = new Cosmetic(validName, validWeight, validAttack, validVelocity, negativeArmor);
	}

	@Test(expected = IllegalArgumentException.class)
	public void armorExceeded() {
		i = new Cosmetic(validName, validWeight, validAttack, validVelocity, exceededArmor);
	}

	// 3 name tests

	@Test (expected = NullPointerException.class)
	public void nullName() {
		i = new Cosmetic(nullName, validWeight, validAttack, validVelocity, validArmor);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shortName() {
		i = new Cosmetic(shortName, validWeight, validAttack, validVelocity, validArmor);
	}

	@Test(expected = IllegalArgumentException.class)
	public void longName() {
		i = new Cosmetic(longName, validWeight, validAttack, validVelocity, validArmor);
	}

	// 2 attack tests

	@Test(expected = IllegalArgumentException.class)
	public void attackExceeded(){
		i = new Cosmetic(validName, validWeight, exceededAttack, validVelocity, validArmor);
	}

	@Test (expected = IllegalArgumentException.class)
	public void attackNegative(){
		i = new Cosmetic(validName, validWeight, negativeAttack, validVelocity, validArmor);
	}

}
