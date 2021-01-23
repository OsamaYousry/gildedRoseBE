package com.gildedrose.strategies;

public class ConjuredStrategy extends ItemStrategy {
    public static final String NAME = "Conjured";

    @Override
    int updateQuality(int quality, int sellIn) {
        quality -= sellIn >= 0 ? 2 : 4;
        quality = this.qualityMinimum(quality);
        return quality;
    }

    @Override
    int updateSellIn(int sellIn) {
        sellIn -= 1;
        return sellIn;
    }

}
