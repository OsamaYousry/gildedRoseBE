package com.gildedrose.factories;

import com.gildedrose.Item;
import com.gildedrose.strategies.*;

public class ItemStrategyFactory {
    private ItemStrategy currentStrategy;

    public void setCurrentStrategy(Item item) {
        ItemStrategy strategy;
        switch (item.name) {
            case SulfurasStrategy.NAME:
                strategy = new SulfurasStrategy();
                break;
            case AgedBrieStrategy.NAME:
                strategy = new AgedBrieStrategy();
                break;
            case BackStagePassesStrategy.NAME:
                strategy = new BackStagePassesStrategy();
                break;
            case ConjuredStrategy.NAME:
                strategy = new ConjuredStrategy();
                break;
            default:
                strategy = new DefaultStrategy();
                break;
        }
        this.currentStrategy = strategy;
    }

    public void execute(Item item) {
        this.currentStrategy.passDay(item);
    }
}
