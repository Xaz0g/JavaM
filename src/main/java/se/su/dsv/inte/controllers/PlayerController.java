package se.su.dsv.inte.controllers;

import se.su.dsv.inte.map.Map;
import se.su.dsv.inte.map.objects.ContainerObject;
import se.su.dsv.inte.map.objects.MapObject;
import se.su.dsv.inte.map.objects.PlayerCharacter;

public class PlayerController extends EntityController{
	
	public PlayerController(Map map, PlayerCharacter player) {
		super(map,player);
	}
	
	@Override
	protected void interactWithObject(MapObject o) {
		if(o instanceof ContainerObject) {
			((PlayerCharacter)getObject()).loot((ContainerObject) o);
		} else {
			((PlayerCharacter)getObject()).attack(o);
		}
	}
}
