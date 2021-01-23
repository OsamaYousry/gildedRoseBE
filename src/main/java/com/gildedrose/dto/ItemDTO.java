package com.gildedrose.dto;

import com.gildedrose.Item;

public class ItemDTO {
    private String name;
    private int sellIn;
    private int quality;

    public ItemDTO() {

    }

    public ItemDTO(Item item) {
        this.name = item.name;
        this.sellIn = item.sellIn;
        this.quality = item.quality;
    }

    public String getName() {
        return name;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public void setName(String name) {
        this.name = name;
    }

}
