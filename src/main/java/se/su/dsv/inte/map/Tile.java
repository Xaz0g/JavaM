package se.su.dsv.inte.map;

import se.su.dsv.inte.map.objects.MapObject;

public interface Tile {
	void setTerrain(Terrain t);
	Terrain getTerrain();
	boolean isOccupied();
	boolean containsPlayer();
	MapObject getMapObject(); 
	void setMapObject(MapObject o);
	
}
