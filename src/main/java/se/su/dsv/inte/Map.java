package se.su.dsv.inte;

public interface Map {
	
	public int getHeight();
	
	public int getWidth();
	
	public Tile getTile();
	
	public void setTile(Tile tile, int row, int column);
	
	public MapObject getPlayerCharacter();
	
	public void placeMapObject(MapObject mObject, int row, int column);
	
	public void moveMapObject(int fromRow, int fromColumn, int toRow, int toColumn);

}
