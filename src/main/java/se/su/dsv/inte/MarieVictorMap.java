package se.su.dsv.inte;

public class MarieVictorMap implements Map{
	
	int height; // x
	int width;  // y
	
	public MarieVictorMap(int x,  int y) {
		this.height = x;
		this.width = y;
		
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public Tile getTile(int row, int column) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setTile(Tile tile, int row, int column) {
		// TODO Auto-generated method stub
		
	}
	
	public PlayerCharacter getPlayerCharacter() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void placeMapObject(PlayerCharacter mObject, int row, int column) {
		// TODO Auto-generated method stub
		
	}
	
	public void moveMapObject(int fromRow, int fromColumn, int toRow, int toColumn) {
		// TODO Auto-generated method stub
		
	}
	
	

}
