package se.su.dsv.inte;

import java.util.ArrayList;

public class ContainerObject {

	ArrayList<Item> storedItems = new ArrayList<Item>();

	public ContainerObject(Item... items) {
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

	public void getOneItem() {

	}

	public void lookInContainer() {

	}

	public void takeItemFromContainer() {

	}

	//	toArray
	//	
	//	emptyList
	//	
	//	return array to Object

}
