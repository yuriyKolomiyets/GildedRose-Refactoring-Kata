package com.gildedrose.factory;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.gildedrose.Item;
import com.gildedrose.updaters.AgedItemUpdater;
import com.gildedrose.updaters.BackstagePassesUpdater;
import com.gildedrose.updaters.ConjuredItemUpdater;
import com.gildedrose.updaters.ItemUpdater;
import com.gildedrose.updaters.LegendaryItemUpdater;
import com.gildedrose.updaters.NormalItemUpdater;

class ItemUpdaterFactoryTest {

    @Test
    public void testGetItemUpdaterForKnownTypes() {
        Item item = new Item("Aged Brie", 10, 20);
        ItemUpdater updater = ItemUpdaterFactory.getItemUpdater(item);
        assertTrue(updater instanceof AgedItemUpdater, "Should return AgedItemUpdater for Aged Brie");

        item = new Item("Sulfuras, Hand of Ragnaros", 10, 80);
        updater = ItemUpdaterFactory.getItemUpdater(item);
        assertTrue(updater instanceof LegendaryItemUpdater, "Should return LegendaryItemUpdater for Sulfuras");

        item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        updater = ItemUpdaterFactory.getItemUpdater(item);
        assertTrue(updater instanceof BackstagePassesUpdater,
                "Should return BackstagePassesUpdater for Backstage passes");

        item = new Item("Conjured Mana Cake", 10, 20);
        updater = ItemUpdaterFactory.getItemUpdater(item);
        assertTrue(updater instanceof ConjuredItemUpdater, "Should return ConjuredItemUpdater for Conjured Mana Cake");

        item = new Item("Unknown Item", 10, 20);
        updater = ItemUpdaterFactory.getItemUpdater(item);
        assertTrue(updater instanceof NormalItemUpdater, "Should return NormalItemUpdater for unknown items");
    }
}
