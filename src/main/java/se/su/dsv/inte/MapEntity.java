package se.su.dsv.inte;

public class MapEntity implements Map{
	
	int [][] map = new int[][] {}; 
	
	int height; // x = row
	int width;  // y = column
	
	public MapEntity(int x, int y) {
		if(x > 0 && y > 0){
			this.height = x;
			this.width = y;
			
		}else {
			throw new IllegalArgumentException(); 
		}
		
		
		
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public Tile getTile(int row, int column) {
		if(row > -1 && column > -1 && row < height && column < width) {
			return null; 
		} else if(row >= height && column >= width){
			throw new IndexOutOfBoundsException();
		
		} else{
			throw new IndexOutOfBoundsException();
			
		}
	
	}
	
	public void setTile(Tile tile, int row, int column) {
		// TODO Auto-generated method stub
		
	}
	
	public PlayerCharacter getPlayerCharacter() {
		PlayerCharacter pChar = null;
		return pChar;
	}
	
	public void placeMapObject(PlayerCharacter mObject, int row, int column) {
		// TODO Auto-generated method stub
		
	}
	
	public void moveMapObject(int fromRow, int fromColumn, int toRow, int toColumn) {
		// TODO Auto-generated method stub
		
	}
	
	

}
