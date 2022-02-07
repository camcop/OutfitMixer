package com.camcop.outfitmixer.service;

import com.camcop.outfitmixer.domain.Item;
import com.camcop.outfitmixer.repo.ItemRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements ServiceInterface<Item> {

    private final ItemRepo repo;

    public ItemService(ItemRepo repo) {
        super();
        this.repo = repo;
    }

    @Override
    public Item add(Item item) {
        return this.repo.save(item);
    }

    @Override
    public List<Item> getAll() {
        return this.repo.findAll();
    }

    @Override
    public Item getById(Long id) {
        return this.repo.findById(id).orElseThrow();
    }

    @Override
    public Item updateById(Long id, Item item) {
        Item oldItem = this.repo.findById(id).orElseThrow();
        oldItem.setName(item.getName());
        oldItem.setType(item.getType());
        oldItem.setBrand(item.getBrand());
        oldItem.setColour(item.getColour());
        return this.repo.save(oldItem);
    }

    @Override
    public Item deleteById(Long id) {
        Item deletedItem = this.repo.findById(id).orElseThrow();
        this.repo.deleteById(id);
        return deletedItem;
    }
}
