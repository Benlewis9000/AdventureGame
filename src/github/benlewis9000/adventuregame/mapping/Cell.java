package github.benlewis9000.adventuregame.mapping;

import github.benlewis9000.adventuregame.entity.Entity;
import github.benlewis9000.adventuregame.entity.Item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Cell {

    /**
        A cell represents a coordinate point of the map. It is used to hold data such
        as the Terrain type or Unit's (items etc) at that location. Cells are assembled
        in a 2D array to create the foundations of a map.
     */

    Terrain terrain;
    HashSet<Entity> entities;
    boolean visible = false;

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public HashSet<Entity> getEntities() {
        return entities;
    }

    public void setEntities(HashSet<Entity> entities) {
        this.entities = entities;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
