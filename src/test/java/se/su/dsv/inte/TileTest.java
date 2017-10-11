package se.su.dsv.inte;

import static org.junit.Assert.*;

import org.junit.Test;

public class TileTest {
	
	private Terrain grass = Terrain.Grass;
	
	@Test
	public void testIsNotOccupied() {
		Tile t = new JohanTile(grass);
		assertEquals(false, t.isOccupied());
	}
	
	@Test
	public void testSetLegalTerrain() {
		Tile t = new JohanTile(grass);
		assertNotNull(t.getTerrain());
	}
	
	@Test(expected = NullPointerException.class)
	public void testSetNullTerrain(){
		Tile t = new JohanTile(null);
	}
	
	@Test
	public void testGetNullPlayer() {
		Tile t = new JohanTile(grass);
		
	}
}
