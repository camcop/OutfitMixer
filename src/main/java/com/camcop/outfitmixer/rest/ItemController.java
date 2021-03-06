package com.camcop.outfitmixer.rest;

import com.camcop.outfitmixer.domain.Item;
import com.camcop.outfitmixer.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return new ResponseEntity<Item>(item, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List> getAll() {
        return new ResponseEntity<List>(this.service.getAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<Item>(this.service.getById(id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateById(@PathVariable("id") Long id, @RequestBody Item item) {
        return new ResponseEntity<Item>(this.service.updateById(id, item), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> deleteById(@PathVariable("id") Long id) {
        return new ResponseEntity<Item>(this.service.deleteById(id), HttpStatus.ACCEPTED);
    }

}
