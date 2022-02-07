package com.camcop.outfitmixer.rest;

import com.camcop.outfitmixer.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        super();
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Item> add(@RequestBody Item item) {
        this.service.add(item);
        return new ResponseEntity<Item>(item, HttpStatus.ACCEPTED)
    }

}
