package com.gildedrose.updaters;

import com.gildedrose.Item;
import com.gildedrose.utils.ItemUtils;

/**
 * Class responsible for updating the properties of normal items. Once the sell
 * by date has passed, Quality degrades twice as fast The Quality of an item is
 * never negative
 */
public class NormalItemUpdater implements ItemUpdater {

    @Override
    public void update(Item item) {

        ItemUtils.decrementSellIn(item);

        if (item.sellIn > 0) {
            ItemUtils.decreaseQuality(item, 1);
        } else {
            ItemUtils.decreaseQuality(item, 2); // Degrade twice as fast after sellIn date
        }
    }
}
