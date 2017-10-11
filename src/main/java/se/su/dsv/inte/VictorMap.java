package se.su.dsv.inte;

public class VictorMap implements Map{

    int height; // x
    int width;  // y

    public VictorMap(int x,  int y) {
        if(x > 0 && y > 0){
            this.height = x;
            this.width = y;

        }else {
            throw new IllegalArgumentException();
        }



    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Tile getTile(int row, int column) {
        // TODO Auto-generated method stub
        return null;
    }

    public void setTile(Tile tile, int row, int column) {
        // TODO Auto-generated method stub

    }

    public PlayerCharacter getPlayerCharacter() {
        PlayerCharacter pChar = null;
        return pChar;
    }

    public void placeMapObject(PlayerCharacter mObject, int row, int column) {
        // TODO Auto-generated method stub

    }

    public void moveMapObject(int fromRow, int fromColumn, int toRow, int toColumn) {
        // TODO Auto-generated method stub

    }



}
