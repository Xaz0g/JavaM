package se.su.dsv.inte.controllers;

import se.su.dsv.inte.map.Direction;
import se.su.dsv.inte.map.Map;
import se.su.dsv.inte.map.Tile;
import se.su.dsv.inte.map.objects.EntityObject;
import se.su.dsv.inte.map.objects.MapObject;
import se.su.dsv.inte.map.objects.PlayerCharacter;

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
					interactWithObject(newTile.getMapObject());
					if(!getObject().isDestroyed() && !newTile.isOccupied()) {
						getMap().moveMapObject(currentRow, currentColumn, moveRow, moveColumn);
						setPosition(moveRow,moveColumn);
						return true;
					}
				} else {
					getMap().moveMapObject(currentRow, currentColumn, moveRow, moveColumn);
					setPosition(moveRow,moveColumn);
					return true;
				}
			}
		}

		return false;
	}

	private boolean checkIfValidMove(int row, int column) {
		return row >= 0 && row < getMap().getHeight() 
				&& column >= 0 && column < getMap().getWidth();
	}
	
	protected void interactWithObject(MapObject o) {
		if(o instanceof PlayerCharacter) {
			((EntityObject)getObject()).attack(o);
		}
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
