package se.su.dsv.inte;

import static org.junit.Assert.*;
import org.junit.*;
import se.su.dsv.inte.controllers.*;
import se.su.dsv.inte.map.Map;
import se.su.dsv.inte.map.Terrain;
import se.su.dsv.inte.map.objects.MapObject;

public class MapObjectControllerTest {
	
	private Map testMap = new Map(10,10);
	private MapObject o = new MapObject(testMap,"testObject",10);
	private MapObjectController c = o.getController();
	
	{
		testMap.setMapTiles(Terrain.Grass);
		testMap.placeMapObject(o, 5, 5);
	}
	
	@Test
	public void testControllMOController() {
		assertEquals(testMap,c.getMap());
		assertEquals(o,c.getObject());
		assertEquals(c,o.getController());
	}
	
	@Test
	public void testDestroyObject() {
		o.modifyCurrentHealth(-10);
		assertFalse(testMap.getTile(5, 5).isOccupied());
	}
	
	@Test
	public void testNotDestroyObject() {
		o.modifyCurrentHealth(-5);
		assertTrue(testMap.getTile(5, 5).isOccupied());
	}
}
