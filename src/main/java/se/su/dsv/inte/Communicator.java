package se.su.dsv.inte;

public class Communicator {

    // Strings

    public String successfulMovement(int fromRow, int fromColumn, int toRow, int toColumn){
        return ("You have successfully moved character from [" + fromRow + "," + fromColumn + "] to [" + toRow + "," + toColumn + "].");
    }

    public String unsuccessfulMovement(int fromRow, int fromColumn, int toRow, int toColumn) {
        return ("It is not possible to move character from [" + fromRow + "," + fromColumn + "] to [" + toRow + "," + toColumn + "].");
    }

    public String  movementCheck(boolean status){
        String statusString;
        if(status) {
            statusString = "";
        }
        else{
            statusString = "not ";
        }

        return ("It is " + statusString + "possible to move to this position!");
    }

    public String receivedItem(Item item){
        String itemName = item.getName();
        return (itemName + " has been added to inventory!");
    }

    public String deletedItem(Item item){
        String itemName = item.getName();
        return (itemName + " has been deleted from inventory!");
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
