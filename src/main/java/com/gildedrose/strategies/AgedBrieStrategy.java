package com.gildedrose.strategies;

public class AgedBrieStrategy extends ItemStrategy {
    public static final String NAME = "Aged Brie";

    @Override
    int updateQuality(int quality, int sellIn) {
        quality += sellIn > 0 ? 1 : 2;
        quality = this.qualityMaximum(quality);
        return quality;
    }

    @Override
    int updateSellIn(int sellIn) {
        return sellIn -= 1;
    }
}
