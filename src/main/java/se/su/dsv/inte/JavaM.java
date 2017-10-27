package se.su.dsv.inte;

import se.su.dsv.inte.map.Map;
import se.su.dsv.inte.map.Terrain;

public class JavaM {
	
	public static void main(String[] args) {
		Map m = new Map(25,25);
		
		m.setMapTiles(Terrain.Grass);
		m.printMap();
	}
}
