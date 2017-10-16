package se.su.dsv.inte;

public class ContainerObject extends MapObject {
	
	private Item[] container;
	private int currentWeight;
	
	public ContainerObject(int i) {
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
	
}
