package se.su.dsv.inte;

public class JavaM {
	
	public static void main(String[] args) {
		MapEntity m = new MapEntity(10,10);
		
		for(int r = 0; r < 10; r++) {
			for(int c = 0; c < 10; c++) {
				m.setTile(new TileEntity(Terrain.Grass), r, c);
			}
		}
		
		m.placeMapObject(new MapObject("TestObject",5), 5, 5);
		
		m.printMap();
	}
}
