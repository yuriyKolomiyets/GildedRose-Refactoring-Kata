package com.gildedrose.updaters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gildedrose.Item;

class ConjuredItemUpdaterTest {

    private ConjuredItemUpdater updater;
    private Item item;

    @BeforeEach
    void setUp() {
        updater = new ConjuredItemUpdater();
        item = new Item("Conjured Mana Cake", 3, 6);
    }

    @Test
    public void testUpdateConjuredItem() {
        updater.update(item);
        assertEquals(2, item.sellIn, "SellIn should decrease by 1");
        assertEquals(4, item.quality, "Quality should decrease by 2");
    }

    @Test
    public void testUpdateConjuredItemWithQualityBelow2() {
        item.quality = 1;
        updater.update(item);
        assertEquals(0, item.quality, "Quality should be 0 if it's less than 2");
    }

    @Test
    public void testUpdateConjuredItemPastSellByDate() {
        item.sellIn = -1;
        item.quality = 4;
        updater.update(item);
        assertEquals(-2, item.sellIn, "SellIn should decrease by 1");
        assertEquals(0, item.quality, "Quality should decrease by 4 but not below 0");
    }
}
