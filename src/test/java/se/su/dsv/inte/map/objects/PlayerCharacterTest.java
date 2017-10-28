package se.su.dsv.inte.map.objects;

import static org.junit.Assert.*;

import org.junit.Test;

import se.su.dsv.inte.items.Armor;
import se.su.dsv.inte.items.Inventory;
import se.su.dsv.inte.items.Item;
import se.su.dsv.inte.items.Weapon;
import se.su.dsv.inte.map.objects.PlayerCharacter;

public class PlayerCharacterTest {
	
	PlayerCharacter p;
	private Inventory i = new Inventory(3);
	private String name = "Marie";
	private int health = 100, movePoints = 2, attack = 10;
	private Item item, item1, item2;
	
	private Weapon w0= new Weapon("weapon0", 1,1,1,1), 
			w1 =new Weapon("weapon1", 1,1,1,1),
			w2 = new Weapon("weapon2", 1,1,1,1),
			w3 = new Weapon("weapon3", 1,1,1,1),
			w4 = new Weapon("weapon4", 1,1,1,1),
			w5 = new Weapon("weapon5", 1,1,1,1),
			w6 = new Weapon("weapon6", 1,1,1,1),
			w7 = new Weapon("weapon7", 1,1,1,1),
			w8 = new Weapon("weapon8", 1,1,1,1),
			w9 = new Weapon("weapon9", 1,1,1,1),
			w10 = new Weapon("weapon10", 1,1,1,1),
			w11 = new Weapon("weapon11", 1,1,1,1),
			w12 = new Weapon("weapon12", 1,1,1,1),
			w13 = new Weapon("weapon13", 1,1,1,1),
			w14 = new Weapon("weapon14", 1,1,1,1),
			w15 = new Weapon("weapon15", 1,1,1,1);
			
	private Item[] weapons = {w0, w1, w2, w3, w4,
			w5, w6, w7, w8, w9, w10, w11, w12,
			w13, w14, w15};
	
	@Test
	public void testValidConstructor() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		
		assertEquals(name,p.getName());
		assertEquals(health,p.getMaxHealth(),0.001);
		assertEquals(p.getMaxHealth(),p.getCurrentHealth(),0.001);
		assertEquals(movePoints,p.getMovementPoints());
		assertEquals(attack, p.getAttack(),0.001);
		
	}
	
	
	@Test
	public void validIncreaseAttackBonus() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		item = new Weapon("Weapon", 2, 3, 4, 5);
		p.increaseAttackBonus(item);
		assertEquals((item.getAttackBonus() + attack) , p.getAttack(), 0.001);
	}
	
	@Test
	public void validIncreaseArmorBonus() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		item = new Weapon("Weapon", 2, 3, 4, 5);
		double armor = p.getArmor();
		p.increaseArmorBonus(item);
		assertEquals((item.getArmorBonus() + armor) , p.getArmor(), 0.001);
	}
	
	@Test
	public void validIncreaseMovementBonus() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		item = new Weapon("Weapon", 2, 3, 4, 5);
		p.increaseMovementBonus(item);
		assertEquals((item.getMovementBonus() + movePoints) , p.getMovementPoints() );
	}
	
	@Test
	public void validDecreaseAttackBonus() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		item = new Weapon("Weapon", 2, 3, 4, 5);
		p.decreaseAttackBonus(item);
		assertEquals((attack - item.getAttackBonus()), p.getAttack(), 0.001);
	}
	
	@Test
	public void validDecreaseAttackBelowZeroResultsInZero() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		int greaterThanAttack = 11;
		item = new Weapon("Weapon", 2, greaterThanAttack, 4, 5);
		p.decreaseAttackBonus(item);
		assertEquals(0, p.getAttack(), 0.001);
	}
	
	@Test
	public void validDecreaseArmorBonus() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		double armorBig = 6.0;
		double armorSmall = 5.0;
		item = new Weapon("Weapon", 2, 3, 4, armorSmall);
		p.setArmor(armorBig);
		p.decreaseArmorBonus(item);
		assertEquals((armorBig - armorSmall) , p.getArmor(), 0.001);
	}
	
	@Test
	public void validDecreaseArmorBelowZeroResultsInZero() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		item = new Weapon("Weapon", 2, 3, 4, 5);
		p.decreaseArmorBonus(item);
		assertEquals(0, p.getArmor(), 0.001);
	}
	
	@Test
	public void validDecreaseMovementBonus() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		int smallMove = 1;
		item = new Weapon("Weapon", 2, 3, smallMove, 5);
		p.decreaseMovementBonus(item);
		assertEquals(movePoints - smallMove , p.getMovementPoints());
	}
	
	@Test
	public void validDecreaseMovementBelowZeroResultsInZero() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		item = new Weapon("Weapon", 2, 3, 4, 5);
		p.decreaseMovementBonus(item);
		assertEquals(0, p.getMovementPoints(), 0.001);
	}
	
	@Test
	public void validLookAtInventory() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		item1 = new Weapon("Weapon", 2, 3, 4, 5);
		item2 = new Weapon("Armor", 2, 3, 4, 5);
		p.addToInventory(item1);
		p.addToInventory(item2);
		
		
	}
	
	@Test
	public void checkItemTest() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		item = new Weapon("Weapon", 2, 3, 4, 5);
		item1 = new Weapon("Weapon", 2, 3, 4, 5);
		item2 = new Weapon("Armor", 2, 3, 4, 5);
		
		p.addToInventory(item);
		p.addToInventory(item1);
		p.addToInventory(item2);
		
		assertEquals(item, p.checkItem(0));
		assertEquals(item1, p.checkItem(1));
		assertEquals(item2, p.checkItem(2));
		
	}
	
	@Test
	public void validRemoveItemFromInventory() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		
		double weight = 1;
		double attackBonus = 1;
		int movementBonus = 1;
		double armorBonus = 1;
		
		item = new Weapon("Weapon", weight, attackBonus, movementBonus, armorBonus);
		p.addToInventory(item);
		
		p.removeItemFromInventory(item);
		/*h =100;
		m= 2;
		att= 10;
		arm= 0;
		*/
		assertEquals(2, p.getMovementPoints(), 0.001);
		assertEquals(10, p.getAttack(), 0.001);
		assertEquals(0, p.getArmor(), 0.001);
		assertNull(p.checkItem(0));
	} 
	
	@Test
	public void validLootWhenSpaceAvailable() {
		p = new PlayerCharacter(null,name, health, movePoints, attack);
		
		ContainerObject con = new ContainerObject(null, "Chest", 100, weapons);
		
		p.loot(con);
		assertEquals(w0 , p.checkItem(0));
		assertEquals(w15 , p.checkItem(15));
	}
	
	@Test(expected = NullPointerException.class)
	public void lootNullContainer() {
		p.loot(null);
	}
	
//	@Test
//	public void lootMoreItemsThanInventoryFreeSpace() {
//		p = new PlayerCharacter(null,name, health, movePoints, attack);
//		ContainerObject con = new ContainerObject(null, "Chest", 100, weapons);
//		item = new Armor("arm0", 1,1,1,1);
//		item1 = new Armor("arm1", 1,1,1,1);
//		item2 = new Armor("arm2", 1,1,1,1);
//		
//		p.addToInventory(item);
//		p.addToInventory(item1);
//		p.addToInventory(item2);
//		
//		p.loot(con);
//		assertEquals(w0 , p.checkItem(0));
//		assertEquals(w15 , p.checkItem(15));
//		//assertEquals();	item - item2 finns i con
//	}
	
//	@Test
//	public void validLoot() {
//		int greaterThanStandardInventory = 17;	//ställer till problem när större än inv
//		Item[] items = new Item[greaterThanStandardInventory];
//		
//		for(int i = 0; i < greaterThanStandardInventory; i++) {
//			//String name, double weight, double attackBonus, int movementBonus, double armorBonus
//			items[i] = new Weapon("weapon: "+ i, 1, 1, 1, 1);
//		}
//		
//		ContainerObject con = new ContainerObject(null, "Chest", 100, items);
//		/*h =100;
//		m= 2;
//		att= 10;
//		arm= 0;
//		*/
//		p = new PlayerCharacter(null,name, health, movePoints, attack);
//		
//		for(int j = 0; j < 16; j++) {
//			//String name, double weight, double attackBonus, int movementBonus, double armorBonus
//			p.addToInventory(new Armor("armor: "+ j, 1, 1, 1, 1));
//		}
//			
//		
//		p.loot(con);
//		assertEquals("weapon: 0", p.checkItem(0).getName());
//	}	// inv.checkItem(2).getName()
}
