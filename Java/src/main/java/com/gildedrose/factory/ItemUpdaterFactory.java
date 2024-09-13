package com.gildedrose.factory;

import java.util.HashMap;
import java.util.Map;

import com.gildedrose.Item;
import com.gildedrose.updaters.AgedItemUpdater;
import com.gildedrose.updaters.BackstagePassesUpdater;
import com.gildedrose.updaters.ConjuredItemUpdater;
import com.gildedrose.updaters.ItemUpdater;
import com.gildedrose.updaters.LegendaryItemUpdater;
import com.gildedrose.updaters.NormalItemUpdater;

/**
 * Factory class to provide the appropriate updater for each type of item. Using
 * static field and methods here we ensure that there is a single, shared *
 * instance. We also avoid creating a new instance of the factory every time we
 * * need an updater and ensures that all calls to getItemUpdater use the same *
 * ItemUpdater instances.
 */
public class ItemUpdaterFactory {

    private static final Map<String, ItemUpdater> updaterMap = new HashMap<>();

    static {

        // Default updater for items not explicitly handled
        updaterMap.put("default", new NormalItemUpdater());

        updaterMap.put("Aged Brie", new AgedItemUpdater());
        updaterMap.put("Sulfuras, Hand of Ragnaros", new LegendaryItemUpdater());
        updaterMap.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassesUpdater());
        updaterMap.put("Conjured Mana Cake", new ConjuredItemUpdater());
    }

    /**
     * Returns the appropriate updater for the given item based on its name.
     *
     * @param item
     *            The item for which to get the updater.
     * @return The updater for the given item.
     */
    public static ItemUpdater getItemUpdater(Item item) {
        return updaterMap.getOrDefault(item.name, updaterMap.get("default"));
    }
}
