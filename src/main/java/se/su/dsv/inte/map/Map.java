package se.su.dsv.inte.map;

import java.util.HashMap;

import se.su.dsv.inte.map.objects.*;
import se.su.dsv.inte.controllers.*;

public class Map{
	
	private final int height; // x = row
	private final int width;  // y = column

	private final Tile [][] tiles;
	private final HashMap<MapObject,Tile> objectsOnMap;
	
	public Map(int height, int width) {
		if(height > 0 && width > 0){
			this.height = height;
			this.width = width;

			tiles = new Tile[this.height][this.width];
			
			objectsOnMap = new HashMap<MapObject,Tile>();

		}else {
			throw new IllegalArgumentException("Not a valid entry!");
		}
	}
	
	public void setMapTiles(Terrain t) {


		for(int row = 0; row < height; row++) {
			for(int column = 0; column < width; column++) {
				tiles[row][column] = new Tile(t);
			}
		}
	}
	
	protected void randomizeWaterSpots(double probability) {


		// Går igenom hela matrisen av Tiles samt med en 50%
		// chans byter underlaget från gräs till vatten i en ny Tile

		// probability är sannolikheten att det blir en vatten-Tile
		for(int row = 0; row < height; row++){
			for(int column = 0; column < width; column++) {
				if(Math.random()< probability)
					tiles[row][column] = new Tile(Terrain.WATER);
			}
		}
	}
	
	public void randomizedLakes(double probability, int size) {

		// Som ovanstående metod genereras Tiles av vatten fast med
		// en fördefinierad storlek så man får sammanhängande sjöar

		for(int row = 0; row < height - 5; row += 5) { 
			for(int column = 0; column < width - 5; column += 5) { 
				if(Math.random() < probability) {
					makeLake(row, column);
				}
			}
		}
	}
	
	private void makeLake(int row, int column) {
		for(int x = row; x < row + 4; x++) { 
			for(int y = column; y < column + 4; y++) {
				tiles[x][y] = new Tile(Terrain.WATER);
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
		return tiles[row][column];
	}

	public void setTile(Tile tile, int row, int column) {
		checkMapPos(row,column);
		tiles[row][column] = tile;
	}

	
	public void placeMapObject(MapObject mObject, int row, int column) {

		// Först tilldelas matrisens position med det medpassade MapObjectet.
		// sen läggs objektet samt positionen i matrisen in i en hash-map
		// där nyckeln är MapObjectet med positionen som värde

		checkMapPos(row,column);
		tiles[row][column].setMapObject(mObject);
		objectsOnMap.put(mObject, tiles[row][column]);
		
		if(mObject instanceof EntityObject) {
			((EntityController) mObject.getController()).setPosition(row,column);
		}
	}
	
	public void moveMapObject(int fromRow, int fromColumn, int toRow, int toColumn) {
		checkMapPos(fromRow,fromColumn);
		checkMapPos(toRow,toColumn);
		
		if(tiles[fromRow][fromColumn].isOccupied()) {
			MapObject o = tiles[fromRow][fromColumn].getMapObject();
			tiles[toRow][toColumn].setMapObject(o);
			objectsOnMap.replace(o, tiles[toRow][toColumn]);
			tiles[fromRow][fromColumn].setMapObject(null);
			
			if(o instanceof EntityObject) {
				((EntityController)o.getController()).setPosition(toRow,toColumn);
			}
		} else {
			throw new IllegalArgumentException("No MapObject to move!");
		}
	}
	
	public void removeMapObject(MapObject o) {
		if(o == null) {
			throw new IllegalArgumentException("Cannot remove null from tiles!");
		} if(objectsOnMap.containsKey(o)) {
			objectsOnMap.get(o).setMapObject(null);
			objectsOnMap.remove(o);
		}
	}
	
	private void checkMapPos(int row, int column) {

		// En metod som används i flera andra metoder som ser om den
		// medskickade positionen till matrisen finns eller inte.

		if(row < 0 || row >= height) {
			throw new IndexOutOfBoundsException("Invalid row!");
		}
		if(column < 0 || column >= width) {
			throw new IndexOutOfBoundsException("Invalid column!");
		}
	}
	
	public boolean onMap(MapObject o) {
		return objectsOnMap.containsKey(o);
	}
	
	public void printMap() {
		for(Tile[] row : tiles) {
			for(Tile tile : row) {
				System.out.print(tile.isOccupied() ? "X " :
						tile.getTerrain() == Terrain.GRASS ? "G " : "B ");
			}
			System.out.println();
		}
	}

}
