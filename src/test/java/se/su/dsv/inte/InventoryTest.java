package se.su.dsv.inte;

import static org.junit.Assert.*;

import org.junit.Test;

public class InventoryTest {
	
	private Inventory validContainer = new Inventory(10);

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
	
	//addItem --> akta Integer.max osv.
	@Test
	public void testAddItem() {
		Inventory inv = new Inventory(10);
		Item testItem = new Item();
		
		assertEquals(true, inv.add(testItem));
	}
	
	@Test
	public void testIncrementItemIndex() {
		Inventory inv = new Inventory(10);
		Item testItem = new Item();
		inv.add(testItem);
		
		assertEquals(1, inv.getIndex());
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
