package com.gildedrose.strategies;

public class SulfurasStrategy extends ItemStrategy {
    public static final String NAME = "Sulfuras, Hand of Ragnaros";

    @Override
    int updateQuality(int quality, int sellIn) {
        return 80;
    }

    @Override
    int updateSellIn(int sellIn) {
        return sellIn;
    }
}
