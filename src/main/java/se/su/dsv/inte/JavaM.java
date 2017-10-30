package se.su.dsv.inte;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import se.su.dsv.inte.controllers.EntityController;
import se.su.dsv.inte.map.Direction;
import se.su.dsv.inte.map.Map;
import se.su.dsv.inte.map.Terrain;
import se.su.dsv.inte.map.objects.EntityObject;
import se.su.dsv.inte.map.objects.PlayerCharacter;

public class JavaM {
    
    private static Random r = new Random(123456789);
    private static Map map;

    public static void main(String[] args) {
        map = new Map(100, 100);
        map.setMapTiles(Terrain.GRASS);
        map.randomizedLakes(0.3, 0);
        
        List<EntityObject> entites = new ArrayList<EntityObject>();

        int turns = 10000; 
        for (int i = 0; i < turns; i++) {
            
            List<EntityObject> toRemove = new ArrayList<EntityObject>();
            for(EntityObject e : entites) {
                if(e.isDestroyed()) {
                    toRemove.add(e);
                    //System.out.println(e.getName() + " died in glorious combat!");
                } else {
                    moveEntity(e);
                }
            }
            
            entites.removeAll(toRemove);
            
            int addRow = r.nextInt(map.getHeight());
            int addColumn = r.nextInt(map.getWidth());
            
            if(!map.getTile(addRow, addColumn).isOccupied()) {
                EntityObject e = generateEntity();
                map.placeMapObject(e, addRow, addColumn);
                entites.add(e);
            }
        }
        
        //map.printMap();
        System.out.println(entites.size());
    }

    private static EntityObject generateEntity() {
        if(r.nextInt(2) == 1) {
            return new PlayerCharacter(map, "aPlayer", 20, 1, 5);
        } else {
            return new EntityObject(map, "anEnemy", 10, 1, 5);
        }
    }
    
    private static void moveEntity(EntityObject e) {
        switch(r.nextInt(4)) {
            case 0 : ((EntityController) e.getController()).moveOnMap(Direction.NORTH);
                break;
            case 1 : ((EntityController) e.getController()).moveOnMap(Direction.EAST);
                break;
            case 2 : ((EntityController) e.getController()).moveOnMap(Direction.SOUTH);
                break;
            case 3 : ((EntityController) e.getController()).moveOnMap(Direction.WEST);
                break;
            default : throw new RuntimeException("Axel don't know how random works");
        }
    }
}
