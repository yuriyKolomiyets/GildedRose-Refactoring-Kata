package com.gildedrose.updaters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gildedrose.Item;

class NormalItemUpdaterTest {

    private NormalItemUpdater updater;
    private Item item;

    @BeforeEach
    void setUp() {
        updater = new NormalItemUpdater();
        item = new Item("+5 Dexterity Vest", 10, 20);
    }

    @Test
    public void testUpdateNormalItem() {
        updater.update(item);
        assertEquals(9, item.sellIn, "SellIn should decrease by 1");
        assertEquals(19, item.quality, "Quality should decrease by 1");
    }

    @Test
    public void testUpdateNormalItemWithQualityZero() {
        item.quality = 0;
        updater.update(item);
        assertEquals(9, item.sellIn, "SellIn should decrease by 1");
        assertEquals(0, item.quality, "Quality should remain at 0");
    }

    @Test
    public void testUpdateNormalItemPastSellByDate() {
        item.sellIn = -1;
        item.quality = 2;
        updater.update(item);
        assertEquals(-2, item.sellIn, "SellIn should decrease by 1");
        assertEquals(0, item.quality, "Quality should decrease by 2 but not below 0");
    }
}
