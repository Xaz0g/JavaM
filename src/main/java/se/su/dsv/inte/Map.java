package se.su.dsv.inte;

public interface Map {
	
	public int getHeight();
	
	public int getWidth();
	
	public Tile getTile(int row, int column);
	
	public void setTile(Tile tile, int row, int column);
	
	public PlayerCharacter getPlayerCharacter();
	
	public void placeMapObject(PlayerCharacter mObject, int row, int column);
	
	public void moveMapObject(int fromRow, int fromColumn, int toRow, int toColumn);

}
