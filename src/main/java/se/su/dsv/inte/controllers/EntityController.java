package se.su.dsv.inte.controllers;

import se.su.dsv.inte.map.Map;
import se.su.dsv.inte.map.objects.EntityObject;

public class EntityController extends MapObjectController{
	
	private int row, column;
	
	public EntityController(Map m, EntityObject e) {
		super(m,e);
	}
		
	public void setPosition(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	
}
