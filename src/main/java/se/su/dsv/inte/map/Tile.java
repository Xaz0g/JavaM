package se.su.dsv.inte.map;

import se.su.dsv.inte.map.objects.MapObject;
import se.su.dsv.inte.map.objects.PlayerCharacter;

public class Tile {
	private Terrain terrain;
	private MapObject mapObject = null;
	
	public Tile(Terrain t){
		setTerrain(t);
	}
	
	public Terrain getTerrain() {
		return terrain;
	}
	
	public void setTerrain(Terrain t) {
		if(t != null) {
			this.terrain = t;
		}else {
			throw new NullPointerException("The terrain can'terrain be null");
		}
	}

	public boolean isOccupied() {
		return mapObject != null;
	}

	public MapObject getMapObject() {
		
		return mapObject;
	}

	public void setMapObject(MapObject o) {
		mapObject = o;
	}

	public boolean containsPlayer() {
		if(isOccupied() && (mapObject instanceof PlayerCharacter))
			return true;
		
		return false;
	}
}
