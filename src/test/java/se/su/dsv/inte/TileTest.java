package se.su.dsv.inte;

import static org.junit.Assert.*;

import org.junit.Test;

public class TileTest {
	
	private Terrain grass = Terrain.Grass;
	private Inventory i = new Inventory(3);
	private PlayerCharacter legalPlayer = new PlayerCharacter("Victor", 3.0, 1,10.0);
	
	@Test
	public void testIsNotOccupied() {
		Tile t = new TileEntity(grass);
		assertEquals(false, t.isOccupied());
	}
	
	@Test
	public void testGetLegalTerrain() {
		Tile t = new TileEntity(grass);
		assertNotNull(t.getTerrain());
	}
	
	@Test
	public void testSetLegalTerrain() {
		Tile t = new TileEntity(grass);
		t.setTerrain(Terrain.Water);
		assertEquals(Terrain.Water, t.getTerrain());
	}
	
	@Test(expected = NullPointerException.class)
	public void testSetNullTerrain(){
		Tile t = new TileEntity(null);
	}
	
	@Test
	public void testSetNullPlayer() {
		Tile t = new TileEntity(grass);
		t.setMapObject(null);
		assertEquals(null,t.getMapObject());
	}
	
	@Test
	public void testSetValidPlayer() {		// hmm onödigt att testa för både null och validPlayer?
		Tile t = new TileEntity(grass);
		t.setMapObject(legalPlayer);
		assertEquals(legalPlayer,t.getMapObject());
	}
	
	@Test 
	public void testContainsValidPlayer() {
		Tile t = new TileEntity(grass);
		t.setMapObject(legalPlayer);
		assertTrue(t.containsPlayer());
	}
}
