package se.su.dsv.inte;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class ContainerObjectTest {

	private ContainerObject co;
	private Item item1 = new Weapon("Weapon", 2, 3, 4, 5), item2 = new Armor("Armor", 2, 3, 4, 5), item3 = new Cosmetic("Cosmetic", 1, 1, 1, 1);

	@Test
	public void validGetStoredItems() {
		co = new ContainerObject(item1, item2, item3);
		ArrayList<Item> list = co.getStoredItems();
		assertEquals(item1,list.get(0));
		assertEquals(item2,list.get(1));
		assertEquals(item3,list.get(2));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void invalidStoredItemsNull() {
		co = new ContainerObject(null,null);
	}
	
	@Test (expected = NullPointerException.class)
	public void invalidStoredItemsArrayListNull() {
		co = new ContainerObject(null);
	}
}
