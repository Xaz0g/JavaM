package se.su.dsv.inte.controllers;

import se.su.dsv.inte.map.Direction;
import se.su.dsv.inte.map.Map;
import se.su.dsv.inte.map.Tile;
import se.su.dsv.inte.map.objects.EntityObject;
import se.su.dsv.inte.map.objects.MapObject;

public class EntityController extends MapObjectController {

	private int currentRow, currentColumn, movesMade;

	public EntityController(Map m, EntityObject e) {
		super(m, e);
	}

	public void setPosition(int row, int column) {
		currentRow = row;
		currentColumn = column;
	}

	public boolean moveOnMap(Direction d) {
		if (canMove()) {
			int moveRow = currentRow + (d == Direction.NORTH ? -1 : d == Direction.SOUTH ? 1 : 0);
			int moveColumn = currentColumn + (d == Direction.EAST ? 1 : d == Direction.WEST ? -1 : 0);

			if (checkIfValidMove(moveRow,moveColumn)) {
				Tile newTile = getMap().getTile(moveRow, moveColumn);
				if (newTile.isOccupied()) {
					
				} else {
					getMap().moveMapObject(currentRow, currentColumn, moveRow, moveColumn);
					setPosition(moveRow,moveColumn);
				}
			}
		}

		return false;
	}

	private boolean checkIfValidMove(int row, int column) {
		return row >= 0 && row < getMap().getHeight() 
				&& column >= 0 && column < getMap().getWidth();
	}
	
	private void interactWithObject(MapObject o) {
		
	}

	private boolean canMove() {
		return movesMade < ((EntityObject) getObject()).getMovementPoints();
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
