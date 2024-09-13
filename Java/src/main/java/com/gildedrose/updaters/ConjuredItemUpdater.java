/*
 *  Copyright (c) 2023 T-Systems International GmbH
 *  All Rights Reserved
 *
 *  This software is the confidential and proprietary information of
 *  T-Systems International GmbH ("Confidential Information").
 *  You shall not disclose such Confidential Information and shall
 *  use it only in accordance with the terms of the license agreement
 *  you entered into with T-Systems International GmbH.
 */
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
