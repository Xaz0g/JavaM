package se.su.dsv.inte;

import static org.junit.Assert.*;

import org.junit.*;


public class MapTest {
	
	private Tile t;
	private Map m;
	private static final int VALID_HEIGHT = 20, VALID_WIDTH = 20, ZERO = 0, NEGATIVE = -1, VALID_ROW = 0, VALID_COLUMN = 0;
	
	@Test
	public void validDimensions() {
		m = new AxelMap(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(VALID_HEIGHT,m.getHeight());
		assertEquals(VALID_WIDTH,m.getWidth());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalidHeightZero() {
		m = new AxelMap(ZERO,VALID_WIDTH);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalidWidthZero() {
		m = new AxelMap(VALID_HEIGHT,ZERO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalidHeightNegative() {
		m = new AxelMap(NEGATIVE,VALID_WIDTH);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalidWidthNegative() {
		m = new AxelMap(VALID_HEIGHT,NEGATIVE);
	}
	
	@Test
	public void validGetTilePosition() {
		m = new AxelMap(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(VALID_ROW,VALID_COLUMN));
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGetTileRowNegative() {
		m = new AxelMap(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(NEGATIVE,VALID_COLUMN));
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGetTileColumnNegative() {
		m = new AxelMap(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(VALID_ROW,NEGATIVE));
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGetTileRowMax() {
		m = new AxelMap(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(m.getHeight(),VALID_COLUMN));
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGetTileColumnMax() {
		m = new AxelMap(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(VALID_ROW,m.getWidth()));
	}
	
	@Test
	public void validSetTilePosition() {
		m = new AxelMap(VALID_HEIGHT,VALID_WIDTH);
		t = new AxelTile();
		m.setTile(t, VALID_ROW, VALID_COLUMN);
		assertEquals(t,m.getTile(VALID_ROW,VALID_COLUMN));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void invalidSetTileRowNegative() {
		m = new AxelMap(VALID_HEIGHT,VALID_WIDTH);
		t = new AxelTile();
		m.setTile(t, NEGATIVE, VALID_COLUMN);
		
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidSetTileColumnNegative() {
		m = new AxelMap(VALID_HEIGHT,VALID_WIDTH);
		t = new AxelTile();
		m.setTile(t, VALID_ROW, NEGATIVE);
		
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidSetTileRowMax() {
		m = new AxelMap(VALID_HEIGHT,VALID_WIDTH);
		t = new AxelTile();
		m.setTile(t, m.getHeight(), VALID_COLUMN);
		
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidSetTileColumnMax() {
		m = new AxelMap(VALID_HEIGHT,VALID_WIDTH);
		t = new AxelTile();
		m.setTile(t, VALID_ROW, m.getWidth());
		
	}
	
	@Test 
	public void getPlayerCharacterNotNull() {
		m = new AxelMap(VALID_HEIGHT,VALID_WIDTH); 
		PlayerCharacter pChar = new AxelPlayerCharacter(); 
		m.placeMapObject(pChar, VALID_ROW, VALID_COLUMN);
		assertNotNull(m.getPlayerCharacter());
	}
	
	
	
	
	
	
}
