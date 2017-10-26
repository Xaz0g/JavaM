package se.su.dsv.inte.map.objects;

import se.su.dsv.inte.controllers.EntityController;
import se.su.dsv.inte.map.Map;

public class EntityObject extends MapObject{
	
	private int movementPoints;
	private double attack;
	private double armor;
	
	
	public EntityObject(Map map, String name, double startingHealth, int startingMovementPoints, double startingAttack) {
		super(name,startingHealth);
		setController(new EntityController(map,this));
		this.movementPoints = startingMovementPoints;
		this.attack = startingAttack;
	}
	
	public void attack(MapObject o) {
		if(o == null) {
			throw new IllegalArgumentException("Cannot attack null!");
		}
		
		if(o instanceof EntityObject) {
			((EntityObject) o).takeDamage(attack);
			takeDamage(((EntityObject) o).getAttack());
		} else {
			o.modifyCurrentHealth(-attack);
		}
	}
	
	public void takeDamage(double damage) {
		if(damage < 0) {
			throw new IllegalArgumentException("Cannot take negative damage!");
		}
		double damageModifier = 1 - (armor / 100);
		double damageTaken = damageModifier * damage;
		modifyCurrentHealth(-damageTaken);
	}

	public int getMovementPoints() {
		return movementPoints;
	}

	public void setMovementPoints(int movementPoints) {
		this.movementPoints = movementPoints;
	}

	public double getAttack() {
		return attack;
	}

	public void setAttack(double damage) {
		this.attack = damage;
	}

	public double getArmor() {
		return armor;
	}

	public void setArmor(double armor) {
		this.armor = armor;
	}
}
