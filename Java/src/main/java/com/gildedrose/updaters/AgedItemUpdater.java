package com.gildedrose.updaters;

import com.gildedrose.Item;
import com.gildedrose.utils.ItemUtils;

/**
 * Class responsible for updating the properties of Aged items. Actually
 * increases in Quality the older it gets
 */
public class AgedItemUpdater implements ItemUpdater {

    @Override
    public void update(Item item) {

        ItemUtils.decrementSellIn(item);
        ItemUtils.increaseQuality(item);
    }
}
