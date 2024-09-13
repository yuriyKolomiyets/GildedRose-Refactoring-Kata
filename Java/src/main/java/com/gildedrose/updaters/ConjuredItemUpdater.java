package com.gildedrose.updaters;

import com.gildedrose.Item;
import com.gildedrose.utils.ItemUtils;

/**
 * Class responsible for updating the properties of Conjured items. "Conjured"
 * items degrade in Quality twice as fast as normal items
 */
public class ConjuredItemUpdater implements ItemUpdater {

    @Override
    public void update(Item item) {

        ItemUtils.decrementSellIn(item);

        if (item.sellIn > 0) {
            ItemUtils.decreaseQuality(item, 2); // Degrade twice as fast after sellIn date
        } else {
            ItemUtils.decreaseQuality(item, 4); // Degrade twice as fast after sellIn date
        }
    }

}
