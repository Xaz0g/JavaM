package se.su.dsv.inte;

import static org.junit.Assert.*;
import org.junit.*;
import se.su.dsv.inte.map.Map;
import se.su.dsv.inte.map.objects.MapObject;

public class MapObjectControllerTest {
	
	private Map testMap = new Map(10,10);
	private MapObject o = new MapObject(testMap,"testObject",10);
	
	@Test
	public void testDestroyObject() {
		
	}
}
