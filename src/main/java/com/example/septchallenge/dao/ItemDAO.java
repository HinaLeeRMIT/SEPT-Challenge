package com.example.septchallenge.dao;

import com.example.septchallenge.model.Item;
import com.example.septchallenge.model.Items;
import org.springframework.stereotype.Service;

@Service
public class ItemDAO {

    private static Items list = new Items();

    static {
        list.getItemList().add(new Item("1", "item1", "test item 1", 1.1));
        list.getItemList().add(new Item("2", "item2", "test item 2", 2.2));
        list.getItemList().add(new Item("3", "item3", "test item 3", 3.3));
    }

    public Items getAllItems(){
        return list;
    }

    public void addItem(Item item){
        list.getItemList().add(item);
    }

    public Item getItemByID(int id){
        return list.getItemList().get(id-1);
    }
}
