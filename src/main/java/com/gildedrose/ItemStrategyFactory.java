package com.gildedrose;

import com.gildedrose.strategies.*;

public class ItemStrategyFactory {
    private ItemStrategy currentStrategy;
    private Item item;

    ItemStrategyFactory(Item item) {
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
        this.item = item;
    }

    public void execute() {
        this.currentStrategy.passDay(item);
    }
}
