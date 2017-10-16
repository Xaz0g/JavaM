package se.su.dsv.inte;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContainerObjectTest {
	
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

}
