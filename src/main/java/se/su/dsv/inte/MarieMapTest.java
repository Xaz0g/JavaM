package se.su.dsv.inte;


import static org.junit.Assert.*;

import org.junit.*;


public class MarieMapTest {

	private Tile t;
	private Map m;
	private static final int VALID_HEIGHT = 25, VALID_WIDTH = 20, ZERO = 0, NEGATIVE = -1, VALID_ROW = 0, VALID_COLUMN = 0;

	@Test
	public void validDimensions() {
		m = new MarieMap(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(VALID_HEIGHT,m.getHeight());
		assertEquals(VALID_WIDTH,m.getWidth());
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidHeightZero() {
		m = new MarieMap(ZERO,VALID_WIDTH);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidWidthZero() {
		m = new MarieMap(VALID_HEIGHT,ZERO);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidHeightNegative() {
		m = new MarieMap(NEGATIVE,VALID_WIDTH);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidWidthNegative() {
		m = new MarieMap(VALID_HEIGHT,NEGATIVE);
	}

	// Detta test funkar från början för att förväntat värde är null
	@Test
	public void validGetTilePosition() {
		m = new MarieMap(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(VALID_ROW,VALID_COLUMN));
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGetTileRowNegative() {
		m = new MarieMap(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(NEGATIVE,VALID_COLUMN));
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGetTileColumnNegative() {
		m = new MarieMap(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(VALID_ROW,NEGATIVE));
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGetTileRowMax() {
		m = new MarieMap(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(m.getHeight(),VALID_COLUMN));
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGetTileColumnMax() {
		m = new MarieMap(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(VALID_ROW,m.getWidth()));
	}

	// Detta test går igenom då det inte finns något på någon position och båda är null
	@Test
	public void validSetTilePosition() {
		m = new MarieMap(VALID_HEIGHT,VALID_WIDTH);
		t = new MarieTile();
		m.setTile(t, VALID_ROW, VALID_COLUMN);
		assertEquals(t,m.getTile(VALID_ROW,VALID_COLUMN));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void invalidSetTileRowNegative() {
		m = new MarieMap(VALID_HEIGHT,VALID_WIDTH);
		t = new MarieTile();
		m.setTile(t, NEGATIVE, VALID_COLUMN);

	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidSetTileColumnNegative() {
		m = new MarieMap(VALID_HEIGHT,VALID_WIDTH);
		t = new MarieTile();
		m.setTile(t, VALID_ROW, NEGATIVE);

	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidSetTileRowMax() {
		m = new MarieMap(VALID_HEIGHT,VALID_WIDTH);
		t = new MarieTile();
		m.setTile(t, m.getHeight(), VALID_COLUMN);

	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidSetTileColumnMax() {
		m = new MarieMap(VALID_HEIGHT,VALID_WIDTH);
		t = new MarieTile();
		m.setTile(t, VALID_ROW, m.getWidth());

	}

	@Test 
	public void getPlayerCharacterNotNull() {
		m = new MarieMap(VALID_HEIGHT,VALID_WIDTH); 
		//		PlayerCharacter pChar = new AxelPlayerCharacter(); 
		//		m.placeMapObject(pChar, VALID_ROW, VALID_COLUMN);
		assertNotNull(m.getPlayerCharacter());
	}


}
