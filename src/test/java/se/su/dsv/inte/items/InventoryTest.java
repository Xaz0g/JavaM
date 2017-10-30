package se.su.dsv.inte.items;

import static org.junit.Assert.*;

import org.junit.Test;

import se.su.dsv.inte.items.Armor;
import se.su.dsv.inte.items.Inventory;
import se.su.dsv.inte.items.Item;

public class InventoryTest {
	private final static int VALID_SIZE = 10;
	private final Inventory validContainer = new Inventory(VALID_SIZE);
	private final Item testItem = new Armor("TestItem", 1, 1, 1, 1);
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateIllegalContainerObject() {
		new Inventory(0);
	}
	
	@Test
	public void testCreateValidContainerObject() {
		Inventory validContainer = new Inventory(10);
		assertNotNull(validContainer);
	}
	
	@Test
	public void testLegalWeight(){
		assertEquals(10, validContainer.getWeight());
	}
	
	@Test
	public void testAddItem() {
		assertEquals(true, validContainer.add(testItem));
		assertEquals(1, validContainer.getIndex());
	}
	
	@Test
	public void testCheckItem(){
		validContainer.add(testItem);
		assertEquals(testItem,validContainer.checkItem(0));
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testCheckIndexLessThanZero() {
		assertEquals
		(false, validContainer.checkItem(-1));
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testCheckIndexOutOfBounds() {
		assertEquals
		(false, validContainer.checkItem(11));
	}
	
	@Test
	public void testRemoveItem() {
		validContainer.add(testItem);
		assertEquals(true, validContainer.removeItem(0));
		assertEquals(0, validContainer.getIndex());
		assertEquals(null, validContainer.checkItem(0));
	}
	
	@Test (expected = NullPointerException.class)
	public void testRemoveNullItem() {
		assertEquals(false, validContainer.remove(null));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveFromEmptySpace() {
		assertEquals(true, validContainer.removeItem(0));
	}
	
	@Test	//Allt som ligger på högre index ska flyttas efter remove()
	public void testCheckMiddleAfterRemove() {
		for(int i = 0; i < VALID_SIZE; i++) {
			validContainer.add(new Armor("TestItem", 1, 1, 1, 1));
		}
		int middle = 5;
		Item nextItem = validContainer.checkItem(middle +1);
		
		validContainer.removeItem(middle);
		assertEquals(nextItem, validContainer.checkItem(middle));
	}
	
	@Test
	public void testCheckLastItemAfterRemove() {
		for(int i = 0; i < VALID_SIZE; i++) {
			validContainer.add(new Armor("TestItem", 1, 1, 1, 1));
		}
		int middle = 5;
		
		validContainer.removeItem(middle);

		assertEquals(null, validContainer.checkItem(VALID_SIZE -1));
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testRemoveIndexLessThanZero() {
		assertEquals
		(false, validContainer.checkItem(11));
	}
	
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void testRemoveItemOutOfBounds() {
		assertEquals
			(false, validContainer.removeItem(11));
	}
	
	@Test
	public void setWeight() {
		validContainer.add(testItem);
		validContainer.setWeight();
		
		assertEquals(21, validContainer.getWeight());
	}
	
	@Test(expected = NullPointerException.class)
	public void addNullItem() {
		validContainer.add(null);
	}
	
	@Test
	public void addToFullInventory() {
		
		for(int i = 0; i <10; i ++) {
			validContainer.add(testItem);
		}
		
		assertEquals(false, validContainer.add(testItem));
	}
	
	@Test(expected = NullPointerException.class)
	public void setItemToNull() {
		validContainer.setItem(0,null);
	}
	
	@Test
	public void setItem() {
		validContainer.add(new Armor("temp", 1, 1, 1, 1));
		assertEquals("temp", validContainer.checkItem(0).getName());
		
		validContainer.setItem(0, testItem);
		assertEquals("TestItem", validContainer.checkItem(0).getName());
		
		assertEquals(testItem, validContainer.checkItem(0));
	}
	
	@Test
	public void getLength() {
		assertEquals(10, validContainer.getLength());
	}
	
	@Test
	public void getSize() {
		assertEquals(10, validContainer.getSize());
	}
	
//	@Test
//	public void testAddToFullInventory(){
//		Inventory inv = new Inventory(10);
//		
//		for(int i = 0; i < 10; i++){
//			Item testItem = new Item();
//			inv.add(testItem);
//		}
//		
//		Item testItem2 = new Item();
//		assertEquals(false, inv.add(testItem2));
//		
//	}

	//hur kontrollera att ett Item inte kan va i flera containers?
}
