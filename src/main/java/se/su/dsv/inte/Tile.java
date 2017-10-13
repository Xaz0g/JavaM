package se.su.dsv.inte;

public interface Tile {
	void setTerrain(Terrain t);
	Terrain getTerrain();
	boolean isOccupied();
	MapObject getMapObject(); 
	void setPlayerCharacter(PlayerCharacter p);	// should be MapObject
	
}
