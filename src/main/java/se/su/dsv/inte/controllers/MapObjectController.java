package se.su.dsv.inte.controllers;

import se.su.dsv.inte.map.Map;
import se.su.dsv.inte.map.objects.MapObject;

public class MapObjectController {
	private final Map map;
	private final MapObject object;
	
	public MapObjectController(Map map, MapObject object) {
		this.map = map;
		this.object = object;
	}
	
	public void removeIfDestroyed() {
		if(object.isDestroyed()) {
			map.removeMapObject(object);
		}
	}

	public Map getMap() {
		return map;
	}

	public MapObject getObject() {
		return object;
	}
}
