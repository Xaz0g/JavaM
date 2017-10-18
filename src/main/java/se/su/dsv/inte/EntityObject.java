package se.su.dsv.inte;

public class EntityObject extends MapObject{
	
	private int movementPoints;
	private int movesMade;
	private double attack;
	private double armor;
	
	
	public EntityObject(String name, double startingHealth, int startingMovementPoints, double startingDamage) {
		super(name,startingHealth);
		this.movementPoints = startingMovementPoints;
		this.attack = startingDamage;
		movesMade = 0;
	}
	
	public void attack(MapObject o) {
		if(o == null) {
			throw new IllegalArgumentException("Cannot attack null!");
		}
		o.modifyCurrentHealth(-attack);
		if(o instanceof EntityObject) {
			modifyCurrentHealth(-(((EntityObject) o).getAttack()));
		}
	}
	
	public void takeDamage(double damage) {
		double damageModifier = 1 - armor;
		//modifyHealth(-(damageModifier * damage));
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
