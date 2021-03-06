package com.camcop.outfitmixer.rest;

import com.camcop.outfitmixer.domain.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:item-schema.sql", "classpath:item-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class ItemControllerTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper map;

    private Item schemaItem;
    private Item addItem;
    private Item retrieveItem;
    private Item updateItem;

    @BeforeEach
    public void setUp() {
        schemaItem = new Item(1L,"Plain white t-shirt","Top", "Uniqlo", "White");
        addItem = new Item("Plain white t-shirt","Top", "Uniqlo", "White");
        retrieveItem = new Item(2L,"Plain white t-shirt","Top", "Uniqlo", "White");
        updateItem = new Item(1L,"Grey joggers","Bottom", "Lands End", "Grey");
    }

    @Test
    void testCreateCont() throws Exception {
        String newItemJSON = this.map.writeValueAsString(addItem);
        RequestBuilder mockRequest = post("/").contentType(MediaType.APPLICATION_JSON).content(newItemJSON);
        String savedItemJSON = this.map.writeValueAsString(retrieveItem);

        ResultMatcher matchStatus = status().isAccepted();
        ResultMatcher matchBody = content().json(savedItemJSON);

        this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
    }

    @Test
    void testReadAll() throws Exception {
        List<Item> allItems = List.of(schemaItem);
        String allItemsJSON = this.map.writeValueAsString(allItems);
        RequestBuilder readReq = get("/");

        ResultMatcher matchStatus = status().isAccepted();
        ResultMatcher matchBody = content().json(allItemsJSON);

        this.mock.perform(readReq).andExpect(matchStatus).andExpect(matchBody);
    }

    @Test
    void testReadOne() throws Exception {
        String schemaItemJSON = this.map.writeValueAsString(schemaItem);
        RequestBuilder readReq = get("/" + schemaItem.getId());

        ResultMatcher matchStatus = status().isAccepted();
        ResultMatcher matchBody = content().json(schemaItemJSON);

        this.mock.perform(readReq).andExpect(matchStatus).andExpect(matchBody);
    }

    @Test
    void testUpdate() throws Exception {
        String updateItemJSON = this.map.writeValueAsString(updateItem);
        RequestBuilder updateReq = put("/" + schemaItem.getId()).contentType(MediaType.APPLICATION_JSON).content(updateItemJSON);

        ResultMatcher matchStatus = status().isAccepted();
        ResultMatcher matchBody = content().json(updateItemJSON);

        this.mock.perform(updateReq).andExpect(matchStatus).andExpect(matchBody);
    }

    @Test
    void testDelete() throws Exception {
        String schemaItemJSON = this.map.writeValueAsString(schemaItem);
        RequestBuilder updateReq = delete("/" + schemaItem.getId());

        ResultMatcher matchStatus = status().isAccepted();
        ResultMatcher matchBody = content().json(schemaItemJSON);

        this.mock.perform(updateReq).andExpect(matchStatus).andExpect(matchBody);
    }

}
