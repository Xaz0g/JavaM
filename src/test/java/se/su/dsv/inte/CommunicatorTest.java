package se.su.dsv.inte;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommunicatorTest {

    // Positions

    private int startRow = 2, startColumn = 1, validRow = 3, validColumn = 4, invalidRow = 10, invalidColumn = 12;

    // Object-attributes

    private double  entObjDamage = 10,
                    entObjArmor = 10,
                    enemyObjDamage = 10,
                    enemyArmor = 10;

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
                    damageDealt = entObjName + " did " + entObjDamage + " damage to " + enemyName + "!";


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
        Weapon crossbow = new Weapon("crossbow", 5,5,5,5);
        assertEquals(receivedItem, com.receivedItem(crossbow));
    }
    @Test
    public void deletedItem(){
        Communicator com = new Communicator();

    }
    @Test
    public void damageDealt(){
        Communicator com = new Communicator();

    }
    @Test
    public void damageAbsorbed(){

    }
    @Test
    public void youveDied(){

    }
    @Test
    public void youveBeenKilledBy(){

    }
    @Test
    public void youveKilledEnemy(){

    }



    public String damageDealt(EntityObject entObj, EntityObject enemy){
        return(entObj.getName() + " did " + entObj.getDamage() + " damage to " + enemy.getName() + "!");
    }

    public String damageAbsorbed(EntityObject entObj, EntityObject enemy){
        double reducedBase = 1.0 * enemy.getArmor();
        double actualDamage = entObj.getDamage() * reducedBase;
        double absorbedDamage = entObj.getDamage() - actualDamage;

        return(enemy.getName() + " just absorbed " + absorbedDamage + " (" + enemy.getArmor() + ").");
    }

    public String youveDied(){
        return("You've died.");
    }

    public String youveBeenKilledBy(EntityObject enemy){
        return(enemy.getName() + " killed you.");
    }

    public String youveKilledEnemy(EntityObject enemy){
        return("You've killed " + enemy.getName());
    }



}
