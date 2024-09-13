package com.gildedrose.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gildedrose.Item;

class ItemUtilsTest {

    private Item item;

    @BeforeEach
    public void setUp() {
        item = new Item("Test Item", 10, 20);
    }

    @Test
    void decrementSellIn() {
        ItemUtils.decrementSellIn(item);
        assertEquals(9, item.sellIn, "SellIn should be decremented by 1");
    }

    @Test
    void increaseQuality() {
        item.quality = 20;
        ItemUtils.increaseQuality(item);
        assertEquals(21, item.quality, "Quality should be increased by 1");

        // Test the upper bound
        item.quality = 50;
        ItemUtils.increaseQuality(item);
        assertEquals(50, item.quality, "Quality should not exceed 50");
    }

    @Test
    void decreaseQuality() {
        ItemUtils.decreaseQuality(item, 5);
        assertEquals(15, item.quality, "Quality should be decreased by 5");

        // Test the lower bound
        ItemUtils.decreaseQuality(item, 20);
        assertEquals(0, item.quality, "Quality should be capped at 0");

        // Test logging when quality becomes zero
        item.quality = 10;
        ItemUtils.decreaseQuality(item, 15);
        assertEquals(0, item.quality, "Quality should be capped at 0");
        // You should also verify the logging output if necessary
    }
}
