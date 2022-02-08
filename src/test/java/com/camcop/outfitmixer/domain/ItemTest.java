package com.camcop.outfitmixer.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class ItemTest {

    private Item newItem;

    @BeforeEach
    public void setUp() {
        newItem = new Item(1L,"Plain white t-shirt","Top", "Uniqlo", "White");
    }

    @Test
    public void testConstructorId() {
        assertEquals(1L, newItem.getId());
    }

    @Test
    public void testConstructorName() {
        assertEquals("Plain white t-shirt", newItem.getName());
    }


}
