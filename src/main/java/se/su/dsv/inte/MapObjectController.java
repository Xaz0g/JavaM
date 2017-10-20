package se.su.dsv.inte;

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
}
//package se.su.dsv.inte;
//
//public class MapObjectController {
//	private final MapEntity map;
//	private final MapObject object;
//
//	public MapObjectController(MapEntity map, MapObject object) {
//		this.map
//	}
//}
