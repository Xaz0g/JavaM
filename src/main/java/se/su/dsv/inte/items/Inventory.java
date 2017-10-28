package se.su.dsv.inte.items;

import java.util.ArrayList;

public class Inventory{
	
	private Item[] container;
	private int nextItemIndex = 0;
	private int currentWeight;
	private int size;
	
	public Inventory(int i) {
		if(i < 1)
			throw new IllegalArgumentException();
		
		container = new Item[i];
		setWeight();
		size = i;
	}
	
//	public Inventory(ArrayList<Item> list) {		//borttagen p.g.a. missar att ändra stats.
//		if(list.size() < 1)
//				throw new IllegalArgumentException();
//		
//		container = list.toArray(new Item[0]);
//		setWeight();
//		size = list.size();
//	}
	
	private void setWeight(){
		for(Item i: container){
			if(i != null)
			currentWeight += i.getWeight();
		}
		
		currentWeight = currentWeight + container.length;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getLength() {
		return container.length;
	}
	
	public int getSpaceLeft() {
		return size - nextItemIndex;
	}
	
	public int getWeight() {
		return currentWeight;
	}
	
	public int getIndex() {
		return nextItemIndex;
	}

	public boolean add(Item testItem) {
		if(testItem == null)
			throw new NullPointerException();
		
		if(nextItemIndex < container.length) {
			container[nextItemIndex] = testItem;
			nextItemIndex++;
			return true;
		}
		return false;
		
	}
	
	public void setItem(int index, Item item) {
		if(item == null)
			throw new NullPointerException();
		
		if(index < nextItemIndex)
			container[index] = item;
	}


	public boolean removeItem(int i) {
		if(i <0 || i >= container.length)
			throw new ArrayIndexOutOfBoundsException();
		if(i >= nextItemIndex)
			throw new IllegalArgumentException();
		
		
		int lastItemIndex = nextItemIndex -1;
		
		if(i == lastItemIndex){
			container[i] = null;
			nextItemIndex--;
			
		}else{
				container[i] = null;
				
				adaptArray(i);
				
				nextItemIndex--;
		}
		
		return container[i] == null;
	}
	
	public boolean remove(Item item) {
		if(item == null)
			throw new NullPointerException();
		
		for(int i = nextItemIndex -1; i >= 0; i--) {
			if(container[i] != null && container[i].equals(item)) {
				return removeItem(i);
			}
		}
		return false;
	}

	private void adaptArray(int i) {
		Item[] temp = new Item[container.length - (i +1)];
		int tempCount = 0;
		int lastItemIndex = nextItemIndex -1;
		
		for(int j = i; j < lastItemIndex; j++) {	//kopiera Items efter index i till temp.
			temp[tempCount] = container[j+1];
			tempCount++;
		}
		
		tempCount = i;
		
		for(Item item : temp) {			// kopiera in items från temp ett steg längre bak i container
			container[tempCount] = item;
			tempCount++;
		}
		
		container[lastItemIndex] = null;	// gör sista itemet till null så att det inte finns två ggr.
	}

	public Item checkItem(int i) {
		return container[i];
	}
	
}
