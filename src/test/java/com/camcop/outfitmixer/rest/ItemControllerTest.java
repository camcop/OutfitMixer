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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ItemControllerTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper map;

    private Item newItem;
    private Item savedItem;

    @BeforeEach
    public void setUp() {
        newItem = new Item("Plain white t-shirt","Top", "Uniqlo", "White");
        savedItem = new Item(1L,"Plain white t-shirt","Top", "Uniqlo", "White");
    }

    @Test
    void testCreateCont() throws Exception {
        String newItemJSON = this.map.writeValueAsString(newItem);
        RequestBuilder mockRequest = post("/").contentType(MediaType.APPLICATION_JSON).content(newItemJSON);
        String savedItemJSON = this.map.writeValueAsString(savedItem);

        ResultMatcher matchStatus = status().isAccepted();
        ResultMatcher matchBody = content().json(savedItemJSON);

        this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

    }


}
