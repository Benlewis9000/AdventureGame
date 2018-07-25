package github.benlewis9000.adventuregame.game;

import github.benlewis9000.adventuregame.entity.Item;

import java.util.HashMap;

public class Inventory {

    HashMap<Item, Integer> items = new HashMap<>();

    public HashMap<Item, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<Item, Integer> items) {
        this.items = items;
    }

    public Inventory (){

    }

    public boolean containsItem(Item item){

        if (items.containsKey(item)) return true;

        return false;

    }

    public void addItem(Item item){

        if (this.containsItem(item)){
            int quantity = items.get(item);
            items.put(item, quantity + 1);
        }

        else items.put(item, 1);

    }

}
