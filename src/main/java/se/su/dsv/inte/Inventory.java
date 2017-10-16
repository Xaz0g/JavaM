package se.su.dsv.inte;

public class Inventory{
	
	private Item[] container;
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
	
}
