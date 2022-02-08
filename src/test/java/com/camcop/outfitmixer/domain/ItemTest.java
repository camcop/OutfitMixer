package com.camcop.outfitmixer.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
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

    @Test
    public void testToString() {
        assertEquals("Item{id=1, name='Plain white t-shirt', type='Top', brand='Uniqlo', colour='White'}", newItem.toString());
    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Item.class).usingGetClass().withPrefabValues(Item.class, newItem, new Item()).withNonnullFields("id").verify();

    }

}
