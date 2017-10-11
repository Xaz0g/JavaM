package se.su.dsv.inte;

public class JohanTile implements Tile{
	private Terrain t;
	private PlayerCharacter player = null;
	
	public JohanTile(Terrain t){
		setTerrain(t);
	}
	
	public Terrain getTerrain() {
		return t;
	}
	
	public void setTerrain(Terrain t) {
		if(t != null) {
			this.t= t;
		}else {
			throw new NullPointerException();
		}
	}

	public boolean isOccupied() {
		return player == null ? false : true; 
	}
	
	//HÄMTA SPELARE osv?
}
