package com.camcop.outfitmixer.rest;

import com.camcop.outfitmixer.service.ItemService;

public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        super();
        this.service = service;
    }


}
