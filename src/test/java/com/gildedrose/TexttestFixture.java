package com.gildedrose;

import java.util.ArrayList;

import com.gildedrose.controller.ItemsController;
import com.gildedrose.dto.ItemDTO;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        ItemDTO[] items = new ItemDTO[] { new ItemDTO("+5 Dexterity Vest", 10, 20), //
                new ItemDTO("Aged Brie", 2, 0), //
                new ItemDTO("Elixir of the Mongoose", 5, 7), //
                new ItemDTO("Sulfuras, Hand of Ragnaros", 0, 80), //
                new ItemDTO("Sulfuras, Hand of Ragnaros", -1, 80),
                new ItemDTO("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new ItemDTO("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new ItemDTO("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new ItemDTO("Conjured Mana Cake", 3, 6) };

        ItemsController app = new ItemsController();

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (ItemDTO item : items) {
                System.out.println(item);
            }
            System.out.println();
            ArrayList<ItemDTO> itemsArray = app.updateQuality(items);
            items = itemsArray.toArray(new ItemDTO[itemsArray.size()]);
        }
    }

}
