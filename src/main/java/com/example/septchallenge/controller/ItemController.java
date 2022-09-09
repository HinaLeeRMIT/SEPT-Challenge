package com.example.septchallenge.controller;

import com.example.septchallenge.dao.ItemDAO;
import com.example.septchallenge.model.Item;
import com.example.septchallenge.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired
    private ItemDAO itemDAO;

    //Get all items
    @GetMapping(path="/item", produces = "application/json")
    public Items getItems() {
        return itemDAO.getAllItems();
    }

    //Get
    @GetMapping(path="/item{id}", produces = "application/json")
    public Item getItem(@PathVariable("id") String id) {

        return itemDAO.getItemByID(id);
    }

    //Post Item
    @PostMapping(path= "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addItem(@RequestBody Item item){
        //We can use this code if we want to automatically increment the ID
        //
        //Integer id = itemDAO.getAllItems().getItemList().size() + 1;
        //item.setId(id.toString());

        itemDAO.addItem(item);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = "/item{id}",consumes = "application/json", produces = "application/json")
    public ResponseEntity<Item> updateItem(@PathVariable("id") String id, @RequestBody Item item){
        return new ResponseEntity<>(itemDAO.updateItem(item, id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/item{id}", produces = "application/json")
    public void deleteItem(@PathVariable("id") String id){
        itemDAO.deleteItem(id);
    }
}
