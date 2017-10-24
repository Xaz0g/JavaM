package se.su.dsv.inte.map.objects;

import se.su.dsv.inte.map.Map;

public class Enemy extends EntityObject{
	
	public Enemy(Map map, String name, double startingHealth, int startingMovePoints, double damage) {
		super(map,name,startingHealth,startingMovePoints,damage);
	}
}
