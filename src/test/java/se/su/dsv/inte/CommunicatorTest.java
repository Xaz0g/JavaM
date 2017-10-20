package se.su.dsv.inte;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommunicatorTest {

    // Positions

    private int startRow = 2, startColumn = 1, validRow = 3, validColumn = 4, invalidRow = 10, invalidColumn = 12;

    // Object-attributes

    private double  entObjDamage = 10,
                    entObjArmor = 0.1,
                    enemyObjDamage = 10,
                    enemyArmor = 0.1,
                    armorProtection= 1.0 - enemyArmor,
                    absorbedDamage = entObjDamage * armorProtection;

    private String  statusString,
                    itemName = "Crossbow",
                    entObjName = "Victor",
                    enemyName = "Marie"
    ;

    // String-outputs (?)
    // Frågan är om attributen ska vara hårdkodade eller ha samma entry som metod-kallet
    private String  successfulMovement = "You have successfully moved character from [" + startRow + "," + startColumn + "] to [" + validRow + "," + validColumn + "].",
                    unsuccessfulMovement = "It is not possible to move character from [" + startRow + "," + startColumn + "] to [" + invalidRow + "," + invalidColumn + "].",
                    movementCheck = "It is " + statusString + "possible to move to this position!",
                    receivedItem = itemName + " has been added to inventory!",
                    deletedItem = itemName + " has been deleted from inventory!",
                    damageDealt = entObjName + " did " + entObjDamage + " damage to " + enemyName + "!",
                    damageAbsorbed = enemyName + " just absorbed " + absorbedDamage + " (" + enemyArmor + ").",
                    youveDied = "You've died.",
                    youveBeenKilledBy = enemyName + " killed you.",
                    youveKilledEnemy = "You've killed " + enemyName;

    public EntityObject newCharacter(){
        return new PlayerCharacter("Victor", 100,10, 5);
    }

    public EntityObject newEnemy(){
        return new PlayerCharacter("Marie", 100, 10, 5);
    }

    public Weapon newWeapon(){
        return new Weapon("crossbow", 5,5,5,5);
    }

    @Test
    public void successfulMovement(){
        Communicator com = new Communicator();
        assertEquals(successfulMovement, com.successfulMovement(startRow, startColumn, validRow, validColumn));
    }

    @Test
    public void unsuccessfulMovement(){
        Communicator com = new Communicator();
        assertEquals(unsuccessfulMovement, com.unsuccessfulMovement(startRow, startColumn, invalidRow, invalidColumn));
    }

    @Test
    public void movementCheckTrue(){
        Communicator com = new Communicator();
        statusString = "";
        assertEquals(movementCheck, com.movementCheck(true));
    }

    @Test
    public void movementCheckFalse(){
        Communicator com = new Communicator();
        statusString = "not ";
        assertEquals(movementCheck, com.movementCheck(false));
    }

    @Test
    public void receivedItem(){
        Communicator com = new Communicator();
        Weapon weapon = newWeapon();
        assertEquals(receivedItem, com.receivedItem(weapon));
    }
    @Test
    public void deletedItem(){
        Communicator com = new Communicator();
        Weapon weapon = newWeapon();
        assertEquals(deletedItem, com.receivedItem(weapon));
    }
    @Test
    public void damageDealt(){
        Communicator com = new Communicator();
        EntityObject character = newCharacter(),
                     enemy = newEnemy();
        assertEquals(damageDealt, com.damageDealt(character, enemy));
    }
    @Test
    public void damageAbsorbed(){
        Communicator com = new Communicator();
        EntityObject character = newCharacter(),
                     enemy = newEnemy();
        assertEquals(damageAbsorbed, com.damageAbsorbed(character, enemy));

    }
    @Test
    public void youveDied(){
        Communicator com = new Communicator();
        assertEquals(youveDied, com.youveDied());
    }
    @Test
    public void youveBeenKilledBy(){
        Communicator com = new Communicator();
        EntityObject enemy = newEnemy();
        assertEquals(youveBeenKilledBy, com.youveBeenKilledBy(enemy));
    }

    @Test
    public void youveKilledEnemy(){
        Communicator com = new Communicator();
        EntityObject enemy = newEnemy();
        assertEquals(youveKilledEnemy, com.youveKilledEnemy(enemy));
    }


}
