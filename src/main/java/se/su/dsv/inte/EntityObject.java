package se.su.dsv.inte;

public class EntityObject extends MapObject{
	
	private int movementPoints;
	private int movesMade;
	private double damage;
	private double armor;
	
	
	public EntityObject(String name, double startingHealth, int startingMovementPoints, double startingDamage) {
		super(name,startingHealth);
		this.movementPoints = startingMovementPoints;
		this.damage = startingDamage;
		movesMade = 0;
	}
	
	public void attack(MapObject o) {
		if(o == null) {
			throw new IllegalArgumentException("Cannot attack null!");
		}
		o.modifyCurrentHealth(-damage);
		if(o instanceof EntityObject) {
			modifyCurrentHealth(-(((EntityObject) o).getDamage()));
		}
	}
	
	public void resetMovesMade() {
		movesMade = 0;
	}

	public int getMovesMade() {
		return movesMade;
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

	public double getArmor() {
		return armor;
	}

	public void setArmor(double armor) {
		this.armor = armor;
	}
	
}
