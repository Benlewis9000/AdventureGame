package github.benlewis9000.adventuregame.entity;

public interface Item extends Entity {

    /*
        'Flag interface', used to increase flexibility of methods/variables that can take any Item e.g. Inventory.addItem(Item item)
    */

    public String[] getInfo();

}
