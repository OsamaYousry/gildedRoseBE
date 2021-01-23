package com.gildedrose.strategies;

public class DefaultStrategy extends ItemStrategy {

    @Override
    int updateQuality(int quality, int sellIn) {
        quality -= sellIn > 0 ? 1 : 2;
        quality = qualityMinimum(quality);
        return quality;
    }

    @Override
    int updateSellIn(int sellIn) {
        sellIn -= 1;
        return sellIn;
    }

}
