package se.su.dsv.inte;

import se.su.dsv.inte.map.Map;
import se.su.dsv.inte.map.objects.EntityObject;
import se.su.dsv.inte.map.objects.MapObject;

public class MoveOnMapTest {
	private Map map = new Map(10,10);
	private EntityObject mover = new EntityObject(map,"movingEntity", 10, 1, 5);
	private MapObject obstacle = new MapObject(map,"obstacle",10);
}
