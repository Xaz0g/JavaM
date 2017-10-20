package se.su.dsv.inte.map;

import se.su.dsv.inte.MapObject;
import se.su.dsv.inte.PlayerCharacter;
import se.su.dsv.inte.Tile;

public interface Map {
	
	public int getHeight();
	
	public int getWidth();
	
	public Tile getTile(int row, int column);
	
	public void setTile(Tile tile, int row, int column);
	
	public PlayerCharacter getPlayerCharacter();
	
	public void placeMapObject(MapObject mObject, int row, int column);
	
	public void moveMapObject(int fromRow, int fromColumn, int toRow, int toColumn);

}
