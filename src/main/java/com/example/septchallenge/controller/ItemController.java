package com.example.septchallenge.controller;

import com.example.septchallenge.dao.ItemDAO;
import com.example.septchallenge.model.Item;
import com.example.septchallenge.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired
    private ItemDAO itemDAO;

    @GetMapping(path="/", produces = "application/json")
    public Items getItems() {
        return itemDAO.getAllItems();
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addItem(@RequestBody Item item){
        Integer id = itemDAO.getAllItems().getItemList().size() + 1;
        item.setId(id.toString());

        itemDAO.addItem(item);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
