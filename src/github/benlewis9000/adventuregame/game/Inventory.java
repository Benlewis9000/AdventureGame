package github.benlewis9000.adventuregame.game;

import github.benlewis9000.adventuregame.entity.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Inventory {

    private HashMap<Item, Integer> items = new HashMap<>();

    public HashMap<Item, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<Item, Integer> items) {
        this.items = items;
    }

    public Inventory (){

    }

    public boolean containsItem(Item item){

        return (items.containsKey(item));

    }

    public void addItem(Item item){

        // Add item, or increase quantity of item in inventory
        if (this.containsItem(item)){
            int quantity = getItems().get(item);
            getItems().put(item, quantity + 1);
        }

        else getItems().put(item, 1);

    }

    // Returns 2D array of each items // Todo: add quantity
    // Item(Q):
    // desc...
    public String[][] viewInventory(){

        String[][] contents = new String[getItems().size()][3];

        Set<Item> itemSet = this.getItems().keySet();
        Item[] itemArray = itemSet.toArray(new Item[itemSet.size()]);

        for (int i = 0; i < itemArray.length; i++){
            contents[i][0] = itemArray[i].getInfo()[0];
            contents[i][1] = itemArray[i].getInfo()[1];
            contents[i][2] = Integer.toString(this.getItems().get(itemArray[i]));
        }

        if (contents.length == 0) return new String[0][0];
        else return contents;

    }

}
