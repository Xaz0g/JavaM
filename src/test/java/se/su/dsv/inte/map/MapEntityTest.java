package se.su.dsv.inte.map;


import static org.junit.Assert.*;

import org.junit.*;

import se.su.dsv.inte.map.Map;
import se.su.dsv.inte.map.objects.MapObject;


public class MapEntityTest {

	private Tile t;
	private Map m = new Map(10,10);
	private static final int VALID_HEIGHT = 25, VALID_WIDTH = 20, ZERO = 0, NEGATIVE = -1, VALID_ROW = 0, VALID_COLUMN = 0;

	@Test
	public void validDimensions() {
		m = new Map(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(VALID_HEIGHT,m.getHeight());
		assertEquals(VALID_WIDTH,m.getWidth());
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidHeightZero() {
		m = new Map(ZERO,VALID_WIDTH);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidWidthZero() {
		m = new Map(VALID_HEIGHT,ZERO);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidHeightNegative() {
		m = new Map(NEGATIVE,VALID_WIDTH);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidWidthNegative() {
		m = new Map(VALID_HEIGHT,NEGATIVE);
	}

	// Detta test funkar från början för att förväntat värde är null
	@Test
	public void validGetTilePosition() {
		m = new Map(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(VALID_ROW,VALID_COLUMN));
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGetTileRowNegative() {
		m = new Map(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(NEGATIVE,VALID_COLUMN));
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGetTileColumnNegative() {
		m = new Map(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(VALID_ROW,NEGATIVE));
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGetTileRowMax() {
		m = new Map(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(m.getHeight(),VALID_COLUMN));
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidGetTileColumnMax() {
		m = new Map(VALID_HEIGHT,VALID_WIDTH);
		assertEquals(null,m.getTile(VALID_ROW,m.getWidth()));
	}



	// Detta test går igenom då det inte finns något på någon position och båda är null
	@Test
	public void validSetTilePosition() {
		m = new Map(VALID_HEIGHT,VALID_WIDTH);
		t = new Tile(Terrain.GRASS);
		m.setTile(t, 2,2);
		assertEquals(t,m.getTile(2,2));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void invalidSetTileRowNegative() {
		m = new Map(VALID_HEIGHT,VALID_WIDTH);
		t = new Tile(Terrain.GRASS);
		m.setTile(t, NEGATIVE, VALID_COLUMN);

	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidSetTileColumnNegative() {
		m = new Map(VALID_HEIGHT,VALID_WIDTH);
		t = new Tile(Terrain.GRASS);
		m.setTile(t, VALID_ROW, NEGATIVE);

	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidSetTileRowMax() {
		m = new Map(VALID_HEIGHT,VALID_WIDTH);
		t = new Tile(Terrain.GRASS);
		m.setTile(t, m.getHeight(), VALID_COLUMN);

	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void invalidSetTileColumnMax() {
		m = new Map(VALID_HEIGHT,VALID_WIDTH);
		t = new Tile(Terrain.GRASS);
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
		m = new Map(VALID_HEIGHT,VALID_WIDTH);
		m.setMapTiles(Terrain.GRASS);
		MapObject o = new MapObject(m,"test",10);
		m.placeMapObject(o, 10, 10);
		m.removeMapObject(o);
		assertNull(m.getTile(10, 10).getMapObject());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void removeNullFromMap() {
		m = new Map(VALID_HEIGHT,VALID_WIDTH);
		m.removeMapObject(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void moveNonExistantMapObject() {
		m = new Map(VALID_HEIGHT,VALID_WIDTH);
		m.setMapTiles(Terrain.GRASS);
		
		m.moveMapObject(0, 0, 1, 0);
	}
	
	@Test
	public void testRandomizedLakes() {
		m = new Map(VALID_HEIGHT,VALID_WIDTH);
		m.setMapTiles(Terrain.GRASS);
		m.randomizedLakes(1, 0);
		
		assertEquals(Terrain.WATER,m.getTile(0, 0).getTerrain());
		assertEquals(Terrain.WATER,m.getTile(5, 5).getTerrain());
		assertEquals(Terrain.WATER,m.getTile(10, 10).getTerrain());
		
	}
	
	@Test
	public void testRandomizedWaterSpots() {
		m = new Map(VALID_HEIGHT,VALID_WIDTH);
		m.setMapTiles(Terrain.GRASS);
		m.randomizeWaterSpots(1);
		
		assertEquals(Terrain.WATER,m.getTile(0, 0).getTerrain());
		assertEquals(Terrain.WATER,m.getTile(5, 5).getTerrain());
		assertEquals(Terrain.WATER,m.getTile(10, 10).getTerrain());
		
	}
	
	@Test
	public void printMap() {
		m.setMapTiles(Terrain.GRASS);
		m.printMap();
	}
	
	@Test(expected = NullPointerException.class)
	public void testPrintNullTerrainMap() {
		m.printMap();
	}
	
//	@Test(expected = IllegalArgumentException.class)
//	public void removeNotOnMap() {
//		m = new Map(VALID_HEIGHT,VALID_WIDTH);
//		m.setMapTiles(Terrain.GRASS);
//		MapObject o = new MapObject(m,"test",10);
//		m.removeMapObject(o);
//	}
}
