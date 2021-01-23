package com.gildedrose.strategies;

public class BackStagePassesStrategy extends ItemStrategy {
    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    @Override
    int updateQuality(int quality, int sellIn) {
        if (sellIn > 10)
            quality += 1;
        else if (sellIn <= 10 && sellIn > 5)
            quality += 2;
        else if (sellIn <= 5 && sellIn >= 0)
            quality += 3;
        else
            quality = 0;
        quality = this.qualityMaximum(quality);
        return quality;
    }

    @Override
    int updateSellIn(int sellIn) {
        return sellIn -= 1;
    }

}
