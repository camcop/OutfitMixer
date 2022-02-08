package com.camcop.outfitmixer.service;

import com.camcop.outfitmixer.domain.Item;
import com.camcop.outfitmixer.repo.ItemRepo;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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


}
