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

    public void deleteItem(String id){
        for (int i = 0; i < itemList.size(); i++){
            if(itemList.get(i).getId().equals(id)){
                itemList.remove(i);
            }
        }
    }

    public Item listHasItem(String id){
        Item existingItem = null;

        for (int i = 0; i < itemList.size(); i++){
            System.out.print(itemList.get(i));
            if(itemList.get(i).getId().equals(id)){
                existingItem = itemList.get(i);
            }
        }

        return existingItem;
    }


    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
