package se.su.dsv.inte.map;

import static org.junit.Assert.*;

import org.junit.Test;

import se.su.dsv.inte.items.Inventory;
import se.su.dsv.inte.map.Terrain;
import se.su.dsv.inte.map.Tile;
import se.su.dsv.inte.map.Tile;
import se.su.dsv.inte.map.objects.PlayerCharacter;

public class TileTest {
	
	private Terrain grass = Terrain.GRASS;
	private Inventory i = new Inventory(3);
	private PlayerCharacter legalPlayer = new PlayerCharacter(null,"Victor", 3.0, 1,10.0);
	
	@Test
	public void testIsNotOccupied() {
		Tile t = new Tile(grass);
		assertEquals(false, t.isOccupied());
	}
	
	@Test
	public void testGetLegalTerrain() {
		Tile t = new Tile(grass);
		assertNotNull(t.getTerrain());
	}
	
	@Test
	public void testSetLegalTerrain() {
		Tile t = new Tile(grass);
		t.setTerrain(Terrain.WATER);
		assertEquals(Terrain.WATER, t.getTerrain());
	}
	
	@Test(expected = NullPointerException.class)
	public void testSetNullTerrain(){
		Tile t = new Tile(null);
	}
	
	@Test
	public void testSetNullPlayer() {
		Tile t = new Tile(grass);
		t.setMapObject(null);
		assertEquals(null,t.getMapObject());
	}
	
	@Test
	public void testSetValidPlayer() {		// hmm onödigt att testa för både null och validPlayer?
		Tile t = new Tile(grass);
		t.setMapObject(legalPlayer);
		assertEquals(legalPlayer,t.getMapObject());
	}
	
	@Test 
	public void testContainsValidPlayer() {
		Tile t = new Tile(grass);
		t.setMapObject(legalPlayer);
		assertTrue(t.containsPlayer());
	}
}
