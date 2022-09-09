package com.example.septchallenge.model;

import java.util.ArrayList;
import java.util.List;

public class Items {

    private List<Item> itemList;

    public List<Item> getItemList() {
        if(itemList == null) {
            itemList = new ArrayList<>();
        }
        return itemList;
    }

    public List<Item> deleteItem(int id){
        itemList.remove(id-1);

        return itemList;
    }
    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
