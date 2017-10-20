package se.su.dsv.inte.map.objects;

import se.su.dsv.inte.map.MapEntity;

public class Enemy extends EntityObject{
	
	public Enemy(MapEntity map, String name, double startingHealth, int startingMovePoints, double damage) {
		super(map,name,startingHealth,startingMovePoints,damage);
	}
}
