package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testSulfurasNeverDegradesOrDecresesSellIn() {
        int quality = generateRandomNumber(50, false);
        int sellIn = generateRandomNumber(100, true);
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(sellIn, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void testBackStagePassesIncreaseByTwoWhenTenDaysOrLess() {
        int quality = generateRandomNumber(48, false);
        int sellIn = generateRandomNumber(6, 10);
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(quality + 2, app.items[0].quality);
    }

    @Test
    void testBackStagePassesNeverNeverIncreaseOverFiftyWhenTenDaysOrLess() {
        int quality = generateRandomNumber(49, 50);
        int sellIn = generateRandomNumber(6, 10);
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testBackStagePassesIncreaseByThreeWhenFiveDaysOrLess() {
        int quality = generateRandomNumber(47, false);
        int sellIn = generateRandomNumber(1, 5);
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(quality + 3, app.items[0].quality);
    }

    @Test
    void testBackStagePassesNeverNeverIncreaseOverFiftyWhenFiveDaysOrLess() {
        int quality = generateRandomNumber(48, 50);
        int sellIn = generateRandomNumber(1, 5);
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testBackStagePassesDropToZeroAfterConcert() {
        int quality = generateRandomNumber(50, false);
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testAgedBrieIncreasesQualityOnceBeforeSellIn() {
        int quality = generateRandomNumber(49, false);
        int sellIn = generateRandomNumber(50, false);
        Item[] items = new Item[] { new Item("Aged Brie", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(quality + 1, app.items[0].quality);
    }

    @Test
    void testAgedBrieIncreasesQualityTwiceAfterSellIn() {
        int quality = generateRandomNumber(48, false);
        int sellIn = generateRandomNumber(50, false);
        sellIn = -sellIn;
        Item[] items = new Item[] { new Item("Aged Brie", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(quality + 2, app.items[0].quality);
    }

    @Test
    void testAgedBrieDoesntIncreaseOverFifty() {
        int sellIn = generateRandomNumber(50, true);
        Item[] items = new Item[] { new Item("Aged Brie", sellIn, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testNormalItemDecreasesByOneBeforeSellIn() {
        int quality = generateRandomNumber(50, false);
        int sellIn = generateRandomNumber(50, false);
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Elixir of the Mongoose", app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(quality - 1, app.items[0].quality);
    }

    @Test
    void testNormalItemNeverDecreasesBelowZeroBeforeSellIn() {
        int quality = generateRandomNumber(0, 1);
        int sellIn = generateRandomNumber(50, false);
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Elixir of the Mongoose", app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testNormalItemDecreasesByTwoAfterSellIn() {
        int quality = generateRandomNumber(2, 50);
        int sellIn = generateRandomNumber(1, 50);
        sellIn = -sellIn;
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Elixir of the Mongoose", app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(quality - 2, app.items[0].quality);
    }

    @Test
    void testNormalItemNeverDecreasesBelowZeroAfterSellIn() {
        int quality = generateRandomNumber(0, 2);
        int sellIn = generateRandomNumber(50, false);
        sellIn = -sellIn;
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Elixir of the Mongoose", app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testConjuredDegradeTwiceBeforeSellIn() {
        int quality = generateRandomNumber(2, 50);
        int sellIn = generateRandomNumber(50, false);
        Item[] items = new Item[] { new Item("Conjured", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(quality - 2, app.items[0].quality);
    }

    @Test
    void testConjuredNeverDegradesBelowZeroBeforeSellIn() {
        int quality = generateRandomNumber(0, 2);
        int sellIn = generateRandomNumber(50, false);
        Item[] items = new Item[] { new Item("Conjured", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testConjuredDegradeFourTimesAfterSellIn() {
        int quality = generateRandomNumber(4, 50);
        int sellIn = generateRandomNumber(50, false);
        sellIn = -sellIn;
        Item[] items = new Item[] { new Item("Conjured", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(quality - 4, app.items[0].quality);
    }

    @Test
    void testConjuredNeverDegradeBelowZeroAfterSellIn() {
        int quality = generateRandomNumber(0, 4);
        int sellIn = generateRandomNumber(50, false);
        sellIn = -sellIn;
        Item[] items = new Item[] { new Item("Conjured", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(sellIn - 1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    private int generateRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private int generateRandomNumber(int max, boolean positiveOrNegative) {
        int number = (int) (Math.random() * max);
        return positiveOrNegative ? Math.random() > 0.5 ? number : -number : number;
    }

}
