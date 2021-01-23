package com.gildedrose.controller;

import java.util.ArrayList;

import com.gildedrose.Item;
import com.gildedrose.dto.ItemDTO;
import com.gildedrose.factories.ItemStrategyFactory;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsController {
    @PutMapping("/")
    public ArrayList<ItemDTO> updateQuality(@RequestBody ItemDTO[] items) {
        ArrayList<ItemDTO> itemsList = new ArrayList<ItemDTO>();
        for (int i = 0; i < items.length; i++) {
            Item item = new Item(items[i].getName(), items[i].getSellIn(), items[i].getQuality());
            ItemStrategyFactory factory = new ItemStrategyFactory();
            factory.setCurrentStrategy(item);
            factory.execute(item);
            itemsList.add(new ItemDTO(item));
        }
        return itemsList;
    }
}
