package com.gildedrose.updaters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gildedrose.Item;

class BackstagePassesUpdaterTest {

    private BackstagePassesUpdater updater;
    private Item item;

    @BeforeEach
    void setUp() {
        updater = new BackstagePassesUpdater();
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
    }

    @Test
    public void testUpdateBackstagePassesMoreThan10Days() {
        updater.update(item);
        assertEquals(14, item.sellIn, "SellIn should decrease by 1");
        assertEquals(21, item.quality, "Quality should increase by 1");
    }

    @Test
    public void testUpdateBackstagePasses10DaysOrLess() {
        item.sellIn = 10;
        item.quality = 48;
        updater.update(item);
        assertEquals(9, item.sellIn, "SellIn should decrease by 1");
        assertEquals(50, item.quality, "Quality should increase by 2 but not exceed 50");
    }

    @Test
    public void testUpdateBackstagePasses5DaysOrLess() {
        item.sellIn = 5;
        item.quality = 47;
        updater.update(item);
        assertEquals(4, item.sellIn, "SellIn should decrease by 1");
        assertEquals(50, item.quality, "Quality should increase by 3 but not exceed 50");
    }

    @Test
    public void testUpdateBackstagePassesAfterEvent() {
        item.sellIn = 0;
        updater.update(item);
        assertEquals(-1, item.sellIn, "SellIn should decrease by 1");
        assertEquals(0, item.quality, "Quality should drop to 0 after the event");
    }
}
