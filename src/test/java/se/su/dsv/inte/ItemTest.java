package se.su.dsv.inte;

import org.junit.*;
import static org.junit.Assert.*;

public class ItemTest {

	private Item i;

	private String validName = "item1", emptyName = "", nullName = null;
	private int zeroWeight = 0, validWeight = 10, maxWeight = 1000;
	private int validSpeed = 1, negativeSpeed = -1, maxSpeed = 100;
	private int validArmor, negativeArmor, maxArmor;
	

	@Test
	public void validWeight() {
		i = new Item(validName, validWeight, validSpeed, validArmor);
		assertEquals(validWeight, i.getWeight());
		assertEquals(validArmor, i.getArmor());
		assertEquals(validSpeed, i.getSpeed());
		assertEquals(validName, i.getName());

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void invalidWeightZero() {
		i = new Item(validName, zeroWeight, validSpeed, validArmor);

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void invalidWeightMax() {
		i = new Item(validName, maxWeight, validSpeed, validArmor);
	}

	@Test
	public void invalidSpeedNegative() {
		i = new Item(validName, validWeight, negativeSpeed, validArmor);
	}

	@Test
	public void invalidSpeedMax() {
		i = new Item(validName, validWeight, maxSpeed, validArmor);
	}

	@Test
	public void invalidArmorNegative() {
		i = new Item(validName, validWeight, validSpeed, negativeArmor);
	}

	@Test
	public void invalidArmorMax() {
		i = new Item(validName, validWeight, validSpeed, maxArmor);
	}
	
	@Test
	public void invalidNameNull() {
		i = new Item(nullName, validWeight, validSpeed, validArmor);
	}
	
	@Test
	public void invalidNameEmpty() {
		i = new Item(emptyName, validWeight, validSpeed, validArmor);
	}
}
