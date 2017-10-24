package se.su.dsv.inte.controllers;

import se.su.dsv.inte.map.MapEntity;
import se.su.dsv.inte.map.objects.MapObject;

public class MapObjectController {
	private final MapEntity map;
	private final MapObject object;
	private int row,column;
	
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
	
	public void setMapPosition(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
}
