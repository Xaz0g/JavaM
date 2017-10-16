package se.su.dsv.inte;

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
		return container[i] == null ? true : false;
	}

	public Item checkItem(int i) {
		return container[i];
	}
	
}
