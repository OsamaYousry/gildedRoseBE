package com.gildedrose.dto;

import com.gildedrose.Item;

public class ItemDTO {
    private String name;
    private int sellIn;
    private int quality;
    private int id;

    public ItemDTO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ItemDTO(Item item, int id) {
        this.name = item.name;
        this.sellIn = item.sellIn;
        this.quality = item.quality;
        this.id = id;
    }

    public ItemDTO(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
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

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

}
