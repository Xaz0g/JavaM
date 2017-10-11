package se.su.dsv.inte;

import static org.junit.Assert.*;

import org.junit.*;


public class MapTest {
	
	private Tile t;
	private Map m;
	private static final int VALID_HEIGHT = 25, VALID_WIDTH = 20, ZERO = 0, NEGATIVE = -1, VALID_ROW = 0, VALID_COLUMN = 0;
	
	@Test
	public void validDimensions() {
		m = new MarieVictorMap(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(VALID_HEIGHT,m.getHeight());
		assertEquals(VALID_WIDTH,m.getWidth());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalidHeightZero() {
		m = new MarieVictorMap(ZERO,VALID_WIDTH);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalidWidthZero() {
		m = new MarieVictorMap(VALID_HEIGHT,ZERO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalidHeightNegative() {
		m = new MarieVictorMap(NEGATIVE,VALID_WIDTH);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalidWidthNegative() {
		m = new MarieVictorMap(VALID_HEIGHT,NEGATIVE);
	}
	
	// Detta test funkar från början för att förväntat värde är null
	@Test
	public void validGetTilePosition() {
		m = new MarieVictorMap(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(VALID_ROW,VALID_COLUMN));
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGetTileRowNegative() {
		m = new MarieVictorMap(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(NEGATIVE,VALID_COLUMN));
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGetTileColumnNegative() {
		m = new MarieVictorMap(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(VALID_ROW,NEGATIVE));
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGetTileRowMax() {
		m = new MarieVictorMap(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(m.getHeight(),VALID_COLUMN));
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGetTileColumnMax() {
		m = new MarieVictorMap(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(VALID_ROW,m.getWidth()));
	}
	
	// Detta test går igenom då det inte finns något på någon position och båda är null
	@Test
	public void validSetTilePosition() {
		m = new MarieVictorMap(VALID_HEIGHT,VALID_WIDTH);
// t = new AxelTile()
		m.setTile(t, VALID_ROW, VALID_COLUMN);
		assertEquals(t,m.getTile(VALID_ROW,VALID_COLUMN));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void invalidSetTileRowNegative() {
		m = new MarieVictorMap(VALID_HEIGHT,VALID_WIDTH);
// t = new AxelTile()
		m.setTile(t, NEGATIVE, VALID_COLUMN);
		
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidSetTileColumnNegative() {
		m = new MarieVictorMap(VALID_HEIGHT,VALID_WIDTH);
// t = new AxelTile()
		m.setTile(t, VALID_ROW, NEGATIVE);
		
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidSetTileRowMax() {
		m = new MarieVictorMap(VALID_HEIGHT,VALID_WIDTH);
// t = new AxelTile()
		m.setTile(t, m.getHeight(), VALID_COLUMN);
		
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidSetTileColumnMax() {
		m = new MarieVictorMap(VALID_HEIGHT,VALID_WIDTH);
// t = new AxelTile()
		m.setTile(t, VALID_ROW, m.getWidth());
		
	}
	
	@Test 
	public void getPlayerCharacterNotNull() {
		m = new MarieVictorMap(VALID_HEIGHT,VALID_WIDTH); 
//		PlayerCharacter pChar = new AxelPlayerCharacter(); 
//		m.placeMapObject(pChar, VALID_ROW, VALID_COLUMN);
		assertNotNull(m.getPlayerCharacter());
	}
	
	
	
	
	
	
}
