package com.gildedrose.updaters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gildedrose.Item;

class LegendaryItemUpdaterTest {

    private LegendaryItemUpdater updater;
    private Item item;

    @BeforeEach
    void setUp() {
        updater = new LegendaryItemUpdater();
        item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
    }

    @Test
    public void testUpdateLegendaryItem() {
        updater.update(item);
        assertEquals(0, item.sellIn, "SellIn should not change");
        assertEquals(80, item.quality, "Quality should not change");
    }
}
