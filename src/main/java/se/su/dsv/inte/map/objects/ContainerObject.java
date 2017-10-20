package se.su.dsv.inte.map.objects;

import java.util.ArrayList;

import se.su.dsv.inte.items.Item;
import se.su.dsv.inte.map.MapEntity;

public class ContainerObject extends MapObject {

	ArrayList<Item> storedItems = new ArrayList<Item>();

	public ContainerObject(MapEntity map, String name, double startingHealth, Item... items) {
		super(map,name, startingHealth);
		
		if(storedItems == null) {
			throw new NullPointerException();
		}else {

			for(Item i: items) {
				if(i == null) {
					throw new IllegalArgumentException();
				}else {

					storedItems.add(i);
				}
			}

		}
	}

	public ArrayList<Item> getStoredItems(){

		return storedItems;
	}

	public void takeItemFromContainer() {
		
	}
	
	public void emptyListStoredItems() {
		storedItems.clear();
	}

	public void getOneItem() {

	}

	public void lookInContainer() {

	}

	//	toArray
	//	emptyList
	//	return array to Object

}
