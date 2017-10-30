package se.su.dsv.inte;

import static org.junit.Assert.*;

import org.junit.Test;

import se.su.dsv.inte.controllers.PlayerController;
import se.su.dsv.inte.map.Direction;
import se.su.dsv.inte.map.Map;
import se.su.dsv.inte.map.Terrain;
import se.su.dsv.inte.map.objects.ContainerObject;
import se.su.dsv.inte.map.objects.Enemy;
import se.su.dsv.inte.map.objects.PlayerCharacter;

public class PlayerControllerTest {
	Map map = new Map(10,10);
	PlayerCharacter player = new PlayerCharacter(map,
			"player", 100, 2, 51);
	PlayerController con = new PlayerController(map, player);
	
	@Test
	public void test() {
		assertEquals(true, con instanceof PlayerController );
	}
	
	@Test
	public void interactWithEnemy() {
		Enemy e = new Enemy(map, "enemy", 50, 1, 5);
		map.setMapTiles(Terrain.GRASS);
		map.placeMapObject(e, 0, 0);
		map.placeMapObject(player, 0, 1);
		PlayerController pC = new PlayerController(map, player);
		player.setController(pC);
		((PlayerController)player.getController()).moveOnMap(Direction.WEST);
		
		pC.interactWithObject(e);
		
		assertTrue(e.isDestroyed());
	}
	
	@Test
	public void interactWithContainer() {
		ContainerObject cO = new ContainerObject(map, "chest", 50);
//		map.setMapTiles(Terrain.GRASS);
//		map.placeMapObject(e, 0, 0);
//		map.placeMapObject(player, 0, 1);
		PlayerController pC = new PlayerController(map, player);
		player.setController(pC);
		((PlayerController)player.getController()).moveOnMap(Direction.WEST);
		
		pC.interactWithObject(cO);
		
	}
	
}
