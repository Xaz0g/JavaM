package se.su.dsv.inte.map;

import java.util.HashMap;

import se.su.dsv.inte.map.objects.MapObject;
import se.su.dsv.inte.map.objects.PlayerCharacter;

public class MapEntity implements Map{
	
	private final int height; // x = row
	private final int width;  // y = column

	private final Tile [][] map;
	private final HashMap<MapObject,Tile> objectsOnMap;
	
	public MapEntity(int x, int y) {
		if(x > 0 && y > 0){
			this.height = x;
			this.width = y;

			map = new Tile[height][width];
			
			objectsOnMap = new HashMap<MapObject,Tile>();

		}else {
			throw new IllegalArgumentException(); 
		}
	}
	
	public void setMapTiles(Terrain t) {
		for(int row = 0; row < height; row++) {
			for(int column = 0; column < width; column++) {
				map[row][column] = new TileEntity(t);
			}
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
		objectsOnMap.put(mObject, map[row][column]);
	}
	
	public void moveMapObject(int fromRow, int fromColumn, int toRow, int toColumn) {
		checkMapPos(fromRow,fromColumn);
		checkMapPos(toRow,toColumn);
		
		if(map[fromRow][fromColumn].isOccupied()) {
			map[toRow][toColumn].setMapObject(map[fromRow][fromColumn].getMapObject());
			objectsOnMap.replace(map[fromRow][fromColumn].getMapObject(), map[toRow][toColumn]);
			map[fromRow][fromColumn].setMapObject(null);
		} else {
			throw new IllegalArgumentException("No MapObject to move!");
		}
	}
	
	public void removeMapObject(MapObject o) {
		if(o == null) {
			throw new IllegalArgumentException("Cannot remove null from map!");
		}
		
		objectsOnMap.get(o).setMapObject(null);
		objectsOnMap.remove(o);
	}
	
	private void checkMapPos(int row, int column) {
		if(row < 0 || row >= height) {
			throw new IndexOutOfBoundsException("Invalid row!");
		}
		if(column < 0 || column >= width) {
			throw new IndexOutOfBoundsException("Invalid column!!");
		}
	}
	
	public void printMap() {
		for(Tile[] row : map) {
			for(Tile tile : row) {
				System.out.print(tile.isOccupied() ? "X " : "0 ");
			}
			System.out.println();
		}
	}

}
