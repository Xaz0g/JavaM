package se.su.dsv.inte.items;

public class Inventory{
	
	private Item[] container;
	private int nextItemIndex = 0;
	private int currentWeight;
	
	public Inventory(int i) {
		if(i < 1)
			throw new IllegalArgumentException();
		
		container = new Item[i];
		setWeight();
	}
	
	private void setWeight(){
		for(Item i: container){
			if(i != null)
			currentWeight += i.getWeight();
		}
		
		currentWeight = currentWeight + container.length;
	}
	
	public int getWeight() {
		return currentWeight;
	}
	
	public int getIndex() {
		return nextItemIndex;
	}

	public boolean add(Item testItem) {
		container[nextItemIndex] = testItem;
		
		if(container[nextItemIndex].equals(testItem)) {
			nextItemIndex++;
			return true;
		}
			
		
		return false;
	}

	public boolean removeItem(int i) {
		container[i] = null;
		nextItemIndex = --nextItemIndex;
		
		adaptArray(i);
		
		return container[i] == null ? true : false;
	}

	private void adaptArray(int i) {
		Item[] temp = new Item[container.length - (i +1)];
		
		int tempCounter = 0;
		
		for(int big = i +1; big < container.length; big++) {
			temp[tempCounter] = container[big];
			tempCounter++;
		}
		
		tempCounter = 0;
		for(int small = i; small < (container.length -1); small++) {
			container[small] = temp [tempCounter];
			tempCounter++;
		}
		
		container[nextItemIndex] = null;		
	}

	public Item checkItem(int i) {
		return container[i];
	}
	
}