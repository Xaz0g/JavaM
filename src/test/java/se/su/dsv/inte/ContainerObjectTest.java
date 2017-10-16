package se.su.dsv.inte;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContainerObjectTest {
	
	private ContainerObject validContainer = new ContainerObject(10);

	@Test(expected = IllegalArgumentException.class)
	public void testCreateIllegalContainerObject() {
		ContainerObject cO = new ContainerObject(0);
	}
	
	@Test
	public void testCreateValidContainerObject() {
		ContainerObject validContainer = new ContainerObject(10);
		assertNotNull(validContainer);
	}
	
	@Test
	public void testLegalWeight(){
		assertEquals(10, validContainer.getWeight());
	}
	
	//addItem --> akta Integer.max osv.

}
