package com.camcop.outfitmixer.service;

import com.camcop.outfitmixer.domain.Item;
import com.camcop.outfitmixer.repo.ItemRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class ItemServiceTest {

    private Item newItem;
    private Item savedItem;

    @InjectMocks
    private ItemService service;

    @Mock
    private ItemRepo repo;

    @BeforeEach
    public void setUp() {
        newItem = new Item("Plain white t-shirt","Top", "Uniqlo", "White");
        savedItem = new Item(1L,"Plain white t-shirt","Top", "Uniqlo", "White");
    }

    @Test
    public void testAdd() {
        Mockito.when(this.repo.save(newItem)).thenReturn(savedItem);
        assertEquals(savedItem, this.service.add(newItem));
        Mockito.verify(this.repo, Mockito.times(1)).save(newItem);
    }

    @Test
    public void testGetAll() {
        Mockito.when(this.repo.findAll()).thenReturn(List.of(savedItem));
        assertEquals(List.of(savedItem), this.service.getAll());
        Mockito.verify(this.repo, Mockito.times(1)).findAll();
    }

    @Test
    public void testGetById() {
        Mockito.when(this.repo.findById(savedItem.getId())).thenReturn(Optional.ofNullable(savedItem));
        assertEquals(savedItem, this.service.getById(savedItem.getId()));
        Mockito.verify(this.repo, Mockito.times(1)).findById(savedItem.getId());
    }

    @Test
    public void updateById() {
        Mockito.when(this.repo.findById(savedItem.getId())).thenReturn(Optional.ofNullable(savedItem));
        Mockito.when(this.repo.save(newItem)).thenReturn(savedItem);
        assertEquals(savedItem, this.service.updateById(savedItem.getId(), newItem));
        Mockito.verify(this.repo, Mockito.times(1)).findById(savedItem.getId());
        Mockito.verify(this.repo, Mockito.times(1)).save(newItem);
    }

    @Test
    public void deleteById() {
        Mockito.when(this.repo.findById(savedItem.getId())).thenReturn(Optional.ofNullable(savedItem));
        assertEquals(savedItem, this.service.deleteById(savedItem.getId()));
        Mockito.verify(this.repo, Mockito.times(1)).findById(savedItem.getId());
    }

}
