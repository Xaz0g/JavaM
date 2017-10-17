package se.su.dsv.inte;

public class EntityObject extends MapObject{
	
	private int movementPoints;
	private double damage;
	
	
	public EntityObject(String name, double startingHealth, int startingMovementPoints, double startingDamage) {
		super(name,startingHealth);
		this.movementPoints = startingMovementPoints;
		this.damage = startingDamage;
	}

	public int getMovementPoints() {
		return movementPoints;
	}

	public void setMovementPoints(int movementPoints) {
		this.movementPoints = movementPoints;
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}
	
}
