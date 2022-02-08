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

}
