package se.su.dsv.inte.map.objects;

import org.junit.*;

import se.su.dsv.inte.items.Armor;
import se.su.dsv.inte.items.Cosmetic;
import se.su.dsv.inte.items.Item;
import se.su.dsv.inte.items.Weapon;
import se.su.dsv.inte.map.objects.ContainerObject;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class ContainerObjectTest {

	private ContainerObject co;
	private String name = "Chest";
	private int health = 2;
	private Item item1 = new Weapon("Weapon", 2, 3, 4, 5), item2 = new Armor("Armor", 2, 3, 4, 5), item3 = new Cosmetic("Cosmetic", 1, 1, 1, 1);

	@Test
	public void validGetStoredItems() {
		co = new ContainerObject(null,name, health, item1, item2, item3);
		ArrayList<Item> list = co.getStoredItems();
		assertEquals(item1,list.get(0));
		assertEquals(item2,list.get(1));
		assertEquals(item3,list.get(2));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void invalidStoredItemsNull() {
		co = new ContainerObject(null,name, health, null,null);
	}
	
	@Test (expected = NullPointerException.class)
	public void invalidStoredItemsArrayListNull() {
		co = new ContainerObject(null,name, health, null);
	}
	
	@Test
	public void validCreateEmptyArrayList() {
		co = new ContainerObject(null,name, health);
		assertTrue(co.getStoredItems().isEmpty());
	}
	
	@Test
	public void validEmptyList() {
		co = new ContainerObject(null,name, health, item1, item2, item3);
		co.emptyListOfStoredItems();
		assertTrue(co.getStoredItems().isEmpty());
		
	}
	
}
