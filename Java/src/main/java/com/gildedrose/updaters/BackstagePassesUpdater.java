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

import java.util.logging.Level;
import java.util.logging.Logger;

import com.gildedrose.Item;
import com.gildedrose.utils.ItemUtils;

/**
 * Class responsible for updating the properties of Backstage Pass items. Like
 * aged brie, increases in Quality as its SellIn value approaches; Quality
 * increases by 2 when there are 10 days or less and by 3 when there are 5 days
 * or less but Quality drops to 0 after the concert.
 */
public class BackstagePassesUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {

        Logger logger = Logger.getLogger(BackstagePassesUpdater.class.getName());

        ItemUtils.decrementSellIn(item);

        if (item.sellIn <= 0) {
            item.quality = 0; // Quality drops to zero after the event
            logger.log(Level.INFO, "item.quality = 0, Item should be utilized or sold immediately: " + item.name);

        } else if (item.sellIn < 5) {
            item.quality = Math.min(item.quality + 3, 50); // Increase quality by 3 when 5 days or less
        } else if (item.sellIn < 10) {
            item.quality = Math.min(item.quality + 2, 50); // Increase quality by 2 when 10 days or less
        } else {
            item.quality = Math.min(item.quality + 1, 50); // Increase quality by 1 otherwise
        }

    }
}
