package se.su.dsv.inte;


import static org.junit.Assert.*;

import org.junit.*;


public class MapEntityTest {

	private Tile t;
	private MapEntity m;
	private static final int VALID_HEIGHT = 25, VALID_WIDTH = 20, ZERO = 0, NEGATIVE = -1, VALID_ROW = 0, VALID_COLUMN = 0;

	@Test
	public void validDimensions() {
		m = new MapEntity(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(VALID_HEIGHT,m.getHeight());
		assertEquals(VALID_WIDTH,m.getWidth());
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidHeightZero() {
		m = new MapEntity(ZERO,VALID_WIDTH);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidWidthZero() {
		m = new MapEntity(VALID_HEIGHT,ZERO);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidHeightNegative() {
		m = new MapEntity(NEGATIVE,VALID_WIDTH);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidWidthNegative() {
		m = new MapEntity(VALID_HEIGHT,NEGATIVE);
	}

	// Detta test funkar från början för att förväntat värde är null
	@Test
	public void validGetTilePosition() {
		m = new MapEntity(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(VALID_ROW,VALID_COLUMN));
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGetTileRowNegative() {
		m = new MapEntity(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(NEGATIVE,VALID_COLUMN));
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGetTileColumnNegative() {
		m = new MapEntity(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(VALID_ROW,NEGATIVE));
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGetTileRowMax() {
		m = new MapEntity(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(m.getHeight(),VALID_COLUMN));
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGetTileColumnMax() {
		m = new MapEntity(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(VALID_ROW,m.getWidth()));
	}



	// Detta test går igenom då det inte finns något på någon position och båda är null
	@Test
	public void validSetTilePosition() {
		m = new MapEntity(VALID_HEIGHT,VALID_WIDTH);
		t = new TileEntity(Terrain.Grass);
		m.setTile(t, 2,2);
		assertEquals(t,m.getTile(2,2));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void invalidSetTileRowNegative() {
		m = new MapEntity(VALID_HEIGHT,VALID_WIDTH);
		t = new TileEntity(Terrain.Grass);
		m.setTile(t, NEGATIVE, VALID_COLUMN);

	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidSetTileColumnNegative() {
		m = new MapEntity(VALID_HEIGHT,VALID_WIDTH);
		t = new TileEntity(Terrain.Grass);
		m.setTile(t, VALID_ROW, NEGATIVE);

	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidSetTileRowMax() {
		m = new MapEntity(VALID_HEIGHT,VALID_WIDTH);
		t = new TileEntity(Terrain.Grass);
		m.setTile(t, m.getHeight(), VALID_COLUMN);

	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidSetTileColumnMax() {
		m = new MapEntity(VALID_HEIGHT,VALID_WIDTH);
		t = new TileEntity(Terrain.Grass);
		m.setTile(t, VALID_ROW, m.getWidth());
	}

//	@Test
//	public void getPlayerCharacterNotNull() {
//		m = new MapEntity(VALID_HEIGHT,VALID_WIDTH);
//				PlayerCharacter pChar = new PlayerCharacter("Victor", 200.0, 1,1);
//				m.placeMapObject(pChar, VALID_ROW, VALID_COLUMN);
//		assertNotNull(m.getPlayerCharacter());
//	}
	
	@Test
	public void removeObjectFromMap() {
		m = new MapEntity(VALID_HEIGHT,VALID_WIDTH);
		m.setMapTiles(Terrain.Grass);
		MapObject o = new MapObject("test",10);
		m.placeMapObject(o, 10, 10);
		m.removeMapObject(o);
		assertNull(m.getTile(10, 10).getMapObject());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void removeNullFromMap() {
		m = new MapEntity(VALID_HEIGHT,VALID_WIDTH);
		m.removeMapObject(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void removeNotOnMap() {
		m = new MapEntity(VALID_HEIGHT,VALID_WIDTH);
		m.removeMapObject(null);
	}
}
