package com.gildedrose.controller;

import com.gildedrose.Item;
import com.gildedrose.factories.ItemStrategyFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    public void updateQuality(Item[] items) {
        for (int i = 0; i < items.length; i++) {
            ItemStrategyFactory factory = new ItemStrategyFactory(items[i]);
            factory.execute();
        }
    }
}
