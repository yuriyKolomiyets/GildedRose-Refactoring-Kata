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
    public static void decrementSellIn(Item item) {
        item.sellIn--;
    }

    /**
     * Increments the quality of an item, ensuring it doesn't exceed 50
     */
    public static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        } else if (item.quality == 50) {
            logger.log(Level.INFO, "Quality reached maximum for item: " + item.name);
        } else {
            logger.log(Level.WARNING, "Quality exceeds maximum for item: " + item.name);
        }
    }

    /**
     * Decrements the quality of an item, ensuring it doesn't go below 0
     */
    public static void decreaseQuality(Item item, int amount) {

        if (item.quality > 0) {
            item.quality = Math.max(0, item.quality - amount);
        } else {
            logger.log(Level.INFO, "Quality is zero or less, should be utilized immediately: " + item.name);
        }
    }
}
