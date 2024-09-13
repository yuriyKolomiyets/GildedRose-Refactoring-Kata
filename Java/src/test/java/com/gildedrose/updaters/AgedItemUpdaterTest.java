package com.gildedrose.updaters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gildedrose.Item;

class AgedItemUpdaterTest {

    private AgedItemUpdater updater;
    private Item item;

    @BeforeEach
    void setUp() {
        updater = new AgedItemUpdater();
        item = new Item("Aged Brie", 2, 0);
    }

    @Test
    public void testUpdateAgedItem() {
        updater.update(item);
        assertEquals(1, item.sellIn, "SellIn should decrease by 1");
        assertEquals(1, item.quality, "Quality should increase by 1");
    }

    @Test
    public void testUpdateAgedItemWithQualityMax() {
        item.quality = 50;
        updater.update(item);
        assertEquals(50, item.quality, "Quality should not exceed 50");
    }
}
