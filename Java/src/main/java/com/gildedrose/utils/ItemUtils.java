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
package com.gildedrose.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.gildedrose.Item;

/**
 * Utility class for common item operations.
 */
public class ItemUtils {

    private static final Logger logger = Logger.getLogger(ItemUtils.class.getName());

    /**
     * Decrement the sellIn value of an item
     */
    //
    public static void decrementSellIn(Item item) {
        item.sellIn--;
    }

    /**
     * Increments the quality of an item, ensuring it doesn't exceed 50
     */

    public static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        } else {
            logger.log(Level.WARNING, "Quality exceeds maximum for item: " + item.name);
        }
    }

    /**
     Decrements the quality of an item, ensuring it doesn't go below 0
     */
    public static void decreaseQuality(Item item, int amount) {

        if (item.quality > 0) {
            item.quality = Math.max(0, item.quality - amount);
        } else {
            logger.log(Level.INFO, "Quality is zero or less, should be utilized immediately: " + item.name);
        }
    }
}
