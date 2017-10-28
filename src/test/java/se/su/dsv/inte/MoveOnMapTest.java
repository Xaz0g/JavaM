package se.su.dsv.inte;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import se.su.dsv.inte.controllers.EntityController;
import se.su.dsv.inte.map.Direction;
import se.su.dsv.inte.map.Map;
import se.su.dsv.inte.map.Terrain;
import se.su.dsv.inte.map.objects.EntityObject;
import se.su.dsv.inte.map.objects.MapObject;
import se.su.dsv.inte.map.objects.PlayerCharacter;

public class MoveOnMapTest {
	private Map map = new Map(100,100);
	private EntityObject mover = new EntityObject(map,"movingEntity", 10, 1, 5);
	private MapObject obstacle = new MapObject(map,"obstacle",10);
	private PlayerCharacter player = new PlayerCharacter(map,"player", 10, 1, 5);
	
	@Before
	public void setup() {
		map.setMapTiles(Terrain.GRASS);
		map.placeMapObject(mover, 5, 5);
	}
	
	@Test
	public void testMoveNotOnMap() {
		map.removeMapObject(mover);
		boolean moved = ((EntityController)mover.getController()).moveOnMap(Direction.NORTH);
		assertFalse(moved);
	}
	
	@Test
	public void testTooManyMoves() {
		((EntityController)mover.getController()).moveOnMap(Direction.NORTH);
		boolean moved = ((EntityController)mover.getController()).moveOnMap(Direction.NORTH);
		assertFalse(moved);
	}
	
	@Test
	public void testNullDirection() {
		boolean moved = ((EntityController)mover.getController()).moveOnMap(null);
		assertFalse(moved);
	}
	
	@Test
	public void testMoveNorth() {
		boolean moved = ((EntityController)mover.getController()).moveOnMap(Direction.NORTH);
		assertTrue(moved);
		assertEquals(map.getTile(5, 5).getMapObject(),null);
		assertEquals(map.getTile(4, 5).getMapObject(),mover);
		assertEquals(4,((EntityController)mover.getController()).getRow());
		assertEquals(5,((EntityController)mover.getController()).getColumn());
	}
	
	@Test
	public void testMoveEast() {
		boolean moved = ((EntityController)mover.getController()).moveOnMap(Direction.EAST);
		assertTrue(moved);
		assertEquals(map.getTile(5, 5).getMapObject(),null);
		assertEquals(map.getTile(5, 6).getMapObject(),mover);
		assertEquals(5,((EntityController)mover.getController()).getRow());
		assertEquals(6,((EntityController)mover.getController()).getColumn());
	}
	
	@Test
	public void testMoveSouth() {
		boolean moved = ((EntityController)mover.getController()).moveOnMap(Direction.SOUTH);
		assertTrue(moved);
		assertEquals(map.getTile(5, 5).getMapObject(),null);
		assertEquals(map.getTile(6, 5).getMapObject(),mover);
		assertEquals(6,((EntityController)mover.getController()).getRow());
		assertEquals(5,((EntityController)mover.getController()).getColumn());
	}
	
	@Test
	public void testMoveWest() {
		boolean moved = ((EntityController)mover.getController()).moveOnMap(Direction.WEST);
		assertTrue(moved);
		assertEquals(map.getTile(5, 5).getMapObject(),null);
		assertEquals(map.getTile(5, 4).getMapObject(),mover);
		assertEquals(5,((EntityController)mover.getController()).getRow());
		assertEquals(4,((EntityController)mover.getController()).getColumn());
	}
	
	@Test
	public void testMoveOutsideBounds() {
		map.moveMapObject(5, 5, 0, 0);
		boolean moved = ((EntityController)mover.getController()).moveOnMap(Direction.NORTH);
		assertFalse(moved);
	}
	
	@Test
	public void testMoveMapObject() {
		map.placeMapObject(obstacle, 4, 5);
		boolean moved = ((EntityController)mover.getController()).moveOnMap(Direction.NORTH);
		assertFalse(moved);
	}
	
	@Test
	public void testMovePlayer() {
		map.placeMapObject(player, 4, 5);
		boolean moved = ((EntityController)mover.getController()).moveOnMap(Direction.NORTH);
		assertFalse(moved);
		assertEquals(5,mover.getCurrentHealth(),0.0001);
		assertEquals(5,player.getCurrentHealth(),0.0001);
	}
	
	@Test
	public void testMoveKillsPlayer() {
		map.placeMapObject(player, 4, 5);
		player.modifyCurrentHealth(-5);
		boolean moved = ((EntityController)mover.getController()).moveOnMap(Direction.NORTH);
		assertTrue(moved);
		assertTrue(player.isDestroyed());
	}
	
	@Test
	public void testMoveKilledByPlayer() {
		map.placeMapObject(player, 4, 5);
		mover.modifyCurrentHealth(-5);
		boolean moved = ((EntityController)mover.getController()).moveOnMap(Direction.NORTH);
		assertFalse(moved);
		assertTrue(mover.isDestroyed());
	}
}
