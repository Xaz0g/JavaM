package se.su.dsv.inte;

public class Communicator {

    // Movement

    public void successfulMovement(int fromRow, int fromColumn, int toRow, int toColumn){
        System.out.println("You have successfully moved character from [" + fromRow + "," + fromColumn + "] to [" + toRow + "," + toColumn + "].");
    }

    public void unsuccessfulMovement(int fromRow, int fromColumn, int toRow, int toColumn) {
        System.out.println("It is not possible to move character from [" + fromRow + "," + fromColumn + "] to [" + toRow + "," + toColumn + "].");
    }

    public void movementCheck(boolean status){
        String statusString;
        if(status) {
            statusString = "";
        }
        else{
            statusString = "not ";
        }

        System.out.println("It is " + statusString + "possible to move to this position!");
    }



    // Item & inventory

    public void receivedItem(Item item){
        String itemName = item.getName();
        System.out.println(itemName + " has been added to inventory!");
    }

    public void deletedItem(Item item){
        String itemName = item.getName();
        System.out.println(itemName + " has been deleted from inventory!");
    }

    // Battle

    public void damageDealt(EntityObject entObj, EntityObject enemy){
        double entObjAttack = entObj.getDamage();
        String entObjName = entObj.getName();
        String enemyName = entObj.getName();

    }


    //




}
