package com.gildedrose.strategies;

import com.gildedrose.Item;

public abstract class ItemStrategy {
    public void passDay(Item item) {
        item.quality = this.updateQuality(item.quality, item.sellIn);
        item.sellIn = this.updateSellIn(item.sellIn);
    }

    int qualityMaximum(int quality) {
        return quality > 50 ? 50 : quality;
    }

    int qualityMinimum(int quality) {
        return quality < 0 ? 0 : quality;
    }

    abstract int updateQuality(int quality, int sellIn);

    abstract int updateSellIn(int sellIn);
}
