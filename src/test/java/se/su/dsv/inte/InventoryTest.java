package se.su.dsv.inte;

import static org.junit.Assert.*;

import org.junit.Test;

public class InventoryTest {
	
	private final Inventory validContainer = new Inventory(10);
	private final Item testItem = new Item();
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateIllegalContainerObject() {
		Inventory cO = new Inventory(0);
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
	
	//hur kontrollera att ett Item inte kan va i flera containers?
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

}
