package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.factories.ItemStrategyFactory;

class GildedRoseTest {

    @Test
    void testSulfurasNeverDegradesOrDecresesSellIn() {
        int quality = generateRandomNumber(50, false);
        int sellIn = generateRandomNumber(100, true);
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sellIn, quality) };
        ItemStrategyFactory factory = new ItemStrategyFactory(items[0]);
        factory.execute();
        assertEquals("Sulfuras, Hand of Ragnaros", items[0].name);
        assertEquals(sellIn, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    @Test
    void testBackStagePassesIncreaseByTwoWhenTenDaysOrLess() {
        int quality = generateRandomNumber(48, false);
        int sellIn = generateRandomNumber(6, 10);
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        ItemStrategyFactory factory = new ItemStrategyFactory(items[0]);
        factory.execute();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", items[0].name);
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(quality + 2, items[0].quality);
    }

    @Test
    void testBackStagePassesNeverNeverIncreaseOverFiftyWhenTenDaysOrLess() {
        int quality = generateRandomNumber(49, 50);
        int sellIn = generateRandomNumber(6, 10);
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        ItemStrategyFactory factory = new ItemStrategyFactory(items[0]);
        factory.execute();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", items[0].name);
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void testBackStagePassesIncreaseByThreeWhenFiveDaysOrLess() {
        int quality = generateRandomNumber(47, false);
        int sellIn = generateRandomNumber(1, 5);
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        ItemStrategyFactory factory = new ItemStrategyFactory(items[0]);
        factory.execute();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", items[0].name);
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(quality + 3, items[0].quality);
    }

    @Test
    void testBackStagePassesNeverNeverIncreaseOverFiftyWhenFiveDaysOrLess() {
        int quality = generateRandomNumber(48, 50);
        int sellIn = generateRandomNumber(1, 5);
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        ItemStrategyFactory factory = new ItemStrategyFactory(items[0]);
        factory.execute();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", items[0].name);
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void testBackStagePassesDropToZeroAfterConcert() {
        int quality = generateRandomNumber(50, false);
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, quality) };
        ItemStrategyFactory factory = new ItemStrategyFactory(items[0]);
        factory.execute();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", items[0].name);
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void testAgedBrieIncreasesQualityOnceBeforeSellIn() {
        int quality = generateRandomNumber(49, false);
        int sellIn = generateRandomNumber(50, false);
        Item[] items = new Item[] { new Item("Aged Brie", sellIn, quality) };
        ItemStrategyFactory factory = new ItemStrategyFactory(items[0]);
        factory.execute();
        assertEquals("Aged Brie", items[0].name);
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(quality + 1, items[0].quality);
    }

    @Test
    void testAgedBrieIncreasesQualityTwiceAfterSellIn() {
        int quality = generateRandomNumber(48, false);
        int sellIn = generateRandomNumber(50, false);
        sellIn = -sellIn;
        Item[] items = new Item[] { new Item("Aged Brie", sellIn, quality) };
        ItemStrategyFactory factory = new ItemStrategyFactory(items[0]);
        factory.execute();
        assertEquals("Aged Brie", items[0].name);
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(quality + 2, items[0].quality);
    }

    @Test
    void testAgedBrieDoesntIncreaseOverFifty() {
        int sellIn = generateRandomNumber(50, true);
        Item[] items = new Item[] { new Item("Aged Brie", sellIn, 50) };
        ItemStrategyFactory factory = new ItemStrategyFactory(items[0]);
        factory.execute();
        assertEquals("Aged Brie", items[0].name);
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void testNormalItemDecreasesByOneBeforeSellIn() {
        int quality = generateRandomNumber(50, false);
        int sellIn = generateRandomNumber(50, false);
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", sellIn, quality) };
        ItemStrategyFactory factory = new ItemStrategyFactory(items[0]);
        factory.execute();
        assertEquals("Elixir of the Mongoose", items[0].name);
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(quality - 1, items[0].quality);
    }

    @Test
    void testNormalItemNeverDecreasesBelowZeroBeforeSellIn() {
        int quality = generateRandomNumber(0, 1);
        int sellIn = generateRandomNumber(50, false);
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", sellIn, quality) };
        ItemStrategyFactory factory = new ItemStrategyFactory(items[0]);
        factory.execute();
        assertEquals("Elixir of the Mongoose", items[0].name);
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void testNormalItemDecreasesByTwoAfterSellIn() {
        int quality = generateRandomNumber(2, 50);
        int sellIn = generateRandomNumber(1, 50);
        sellIn = -sellIn;
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", sellIn, quality) };
        ItemStrategyFactory factory = new ItemStrategyFactory(items[0]);
        factory.execute();
        assertEquals("Elixir of the Mongoose", items[0].name);
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(quality - 2, items[0].quality);
    }

    @Test
    void testNormalItemNeverDecreasesBelowZeroAfterSellIn() {
        int quality = generateRandomNumber(0, 2);
        int sellIn = generateRandomNumber(50, false);
        sellIn = -sellIn;
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", sellIn, quality) };
        ItemStrategyFactory factory = new ItemStrategyFactory(items[0]);
        factory.execute();
        assertEquals("Elixir of the Mongoose", items[0].name);
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void testConjuredDegradeTwiceBeforeSellIn() {
        int quality = generateRandomNumber(2, 50);
        int sellIn = generateRandomNumber(50, false);
        Item[] items = new Item[] { new Item("Conjured", sellIn, quality) };
        ItemStrategyFactory factory = new ItemStrategyFactory(items[0]);
        factory.execute();
        assertEquals("Conjured", items[0].name);
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(quality - 2, items[0].quality);
    }

    @Test
    void testConjuredNeverDegradesBelowZeroBeforeSellIn() {
        int quality = generateRandomNumber(0, 2);
        int sellIn = generateRandomNumber(50, false);
        Item[] items = new Item[] { new Item("Conjured", sellIn, quality) };
        ItemStrategyFactory factory = new ItemStrategyFactory(items[0]);
        factory.execute();
        assertEquals("Conjured", items[0].name);
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void testConjuredDegradeFourTimesAfterSellIn() {
        int quality = generateRandomNumber(4, 50);
        int sellIn = generateRandomNumber(50, false);
        sellIn = -sellIn;
        Item[] items = new Item[] { new Item("Conjured", sellIn, quality) };
        ItemStrategyFactory factory = new ItemStrategyFactory(items[0]);
        factory.execute();
        assertEquals("Conjured", items[0].name);
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(quality - 4, items[0].quality);
    }

    @Test
    void testConjuredNeverDegradeBelowZeroAfterSellIn() {
        int quality = generateRandomNumber(0, 4);
        int sellIn = generateRandomNumber(50, false);
        sellIn = -sellIn;
        Item[] items = new Item[] { new Item("Conjured", sellIn, quality) };
        ItemStrategyFactory factory = new ItemStrategyFactory(items[0]);
        factory.execute();
        assertEquals("Conjured", items[0].name);
        assertEquals(sellIn - 1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    private int generateRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private int generateRandomNumber(int max, boolean positiveOrNegative) {
        int number = (int) (Math.random() * max);
        return positiveOrNegative ? Math.random() > 0.5 ? number : -number : number;
    }

}
