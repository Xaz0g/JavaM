package se.su.dsv.inte.controllers;

import se.su.dsv.inte.map.Direction;
import se.su.dsv.inte.map.Map;
import se.su.dsv.inte.map.objects.EntityObject;

public class EntityController extends MapObjectController{
	
	private int currentRow, currentColumn, movesMade;
	
	public EntityController(Map m, EntityObject e) {
		super(m,e);
	}
	
	private void setPosition(int row, int column) {
		currentRow = row;
		currentColumn = column;
	}
	
	public boolean moveOnMap(Direction d) {
		if(canMove()) {
			int moveRow = 0, moveColumn = 0;
			switch(d) {
			case NORTH : 
				moveRow = -1;
				break;
			case NORTHEAST : 
				moveRow = -1; 
				moveColumn = 1;
				break;
			case EAST : 
				moveColumn = 1;
				break;
			case SOUTHEAST : 
				moveRow = 1; 
				moveColumn = 1;
				break;
			case SOUTH : 
				moveRow = 1;
				break;
			case SOUTHWEST : 
				moveRow = 1; 
				moveColumn = -1;
				break;
			case WEST : 
				moveColumn = -1;
				break;
			case NORTHWEST : 
				moveRow = -1; 
				moveColumn = -1;
			}
			
		}
		
		return false;
	}
	
	private boolean canMove() {
		return movesMade < ((EntityObject)getObject()).getMovementPoints();
	}
	
	public int getRow() {
		return currentRow;
	}
	
	public int getColumn() {
		return currentColumn;
	}
	
	public void resetMovesMade() {
		movesMade = 0;
	}
}
