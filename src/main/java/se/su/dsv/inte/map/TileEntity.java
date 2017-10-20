package se.su.dsv.inte.map;

import se.su.dsv.inte.map.objects.MapObject;
import se.su.dsv.inte.map.objects.PlayerCharacter;

public class TileEntity implements Tile{
	private Terrain t;
	private MapObject mO = null;
	
	public TileEntity(Terrain t){
		setTerrain(t);
	}
	
	public Terrain getTerrain() {
		return t;
	}
	
	public void setTerrain(Terrain t) {
		if(t != null) {
			this.t= t;
		}else {
			throw new NullPointerException();
		}
	}

	public boolean isOccupied() {
		return mO == null ? false : true; 
	}

	public MapObject getMapObject() {
		
		return mO;
	}

	public void setMapObject(MapObject o) {
		mO = o;
	}

	public boolean containsPlayer() {
		if(isOccupied() && mO instanceof PlayerCharacter)
		return true;
		
		return false;
	}
}
