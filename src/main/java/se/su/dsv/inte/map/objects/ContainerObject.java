package se.su.dsv.inte.map.objects;

import java.lang.reflect.Array;
import java.util.ArrayList;

import se.su.dsv.inte.items.Item;
import se.su.dsv.inte.map.Map;

public class ContainerObject extends MapObject {

	private ArrayList<Item> storedItems = new ArrayList<Item>();

	public ContainerObject(Map map, String name, double startingHealth, Item... items) {
		super(map,name, startingHealth);
		
//		if(storedItems == null) {
//			throw new NullPointerException();
//		}else {

			for(Item i: items){
				if(i == null) {
					throw new IllegalArgumentException();
				}else {
					storedItems.add(i);
				}
			}

//		}
	}
	
	public int size() {
		return storedItems.size();
	}

	public ArrayList<Item> getStoredItems(){

		return storedItems;
	}

	public Item takeItemFromContainer(int index) {
		Item i = storedItems.get(index);

		return i;
	}
	
	public void emptyListOfStoredItems() {
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
