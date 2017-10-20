package se.su.dsv.inte.controllers;

import se.su.dsv.inte.map.MapEntity;
import se.su.dsv.inte.map.objects.MapObject;

public class MapObjectController {
	private final MapEntity map;
	private final MapObject object;
	
	public MapObjectController(MapEntity map, MapObject object) {
		this.map = map;
		this.object = object;
	}
	
	public void removeIfDestroyed() {
		if(object.isDestroyed()) {
			map.removeMapObject(object);
		}
	}

	public MapEntity getMap() {
		return map;
	}

	public MapObject getObject() {
		return object;
	}
	
	
}
