package github.benlewis9000.adventuregame.mapping;

public class Cell {

    /**
        A cell represents a coordinate point of the map. It is used to hold data such
        as the Terrain type or Unit's (items etc) at that location. Cells are assembled
        in a 2D array to create the foundations of a map.
     */

    Terrain terrain;
    Unit unit;          // todo arraylist of Unit's(?) - to handle player

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    // Todo: 'spawnable' boolean instead of checking terrain when finding spawn? Assigned with terrain generator
}
