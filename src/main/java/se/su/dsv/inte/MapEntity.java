package se.su.dsv.inte;

public class MapEntity implements Map{
	
	int height; // x = row
	int width;  // y = column

	Tile [][] map;
	
	public MapEntity(int x, int y) {
		if(x > 0 && y > 0){
			this.height = x;
			this.width = y;

			map = new Tile[height][width];

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
		checkMapPos(row,column);
		return map[row][column];
	}
	
	public void setTile(Tile tile, int row, int column) {
		checkMapPos(row,column);
		map[row][column] = tile;
	}
	
	public PlayerCharacter getPlayerCharacter() {
		PlayerCharacter pChar = null;
		return pChar;
	}
	
	public void placeMapObject(MapObject mObject, int row, int column) {
		checkMapPos(row,column);
		map[row][column].setMapObject(mObject);
	}
	
	public void moveMapObject(int fromRow, int fromColumn, int toRow, int toColumn) {
		checkMapPos(fromRow,fromColumn);
		checkMapPos(toRow,toColumn);
		
		if(map[fromRow][fromColumn].isOccupied()) {
			map[toRow][toColumn].setMapObject(map[fromRow][fromColumn].getMapObject());
			map[fromRow][fromColumn].setMapObject(null);
		} else {
			throw new IllegalArgumentException("No MapObject to move!");
		}
	}
	
	private void checkMapPos(int row, int column) {
		if(row < 0 || row >= height) {
			throw new IllegalArgumentException("Invalid row!");
		}
		if(column < 0 || column >= width) {
			throw new IllegalArgumentException("Invalid column!!");
		}
	}

}
