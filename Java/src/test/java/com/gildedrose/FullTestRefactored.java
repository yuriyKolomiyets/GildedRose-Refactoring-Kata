package com.gildedrose;

import org.junit.jupiter.api.Test;

public class FullTestRefactored {

    @Test
    void foo() {

        // Initialize items
        Item[] items = new Item[]{
            //default
            new Item("+5 Dexterity Vest", 10, 20),
            // aged
            new Item("Aged Brie", 2, 0),
            //default
            new Item("Elixir of the Mongoose", 5, 7),
            // legendary
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            // concert
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            //conjured
            new Item("Conjured Mana Cake", 3, 6)
        };

        // Initialize GildedRose
        GildedRose app = new GildedRose(items);


        // Expected results after 1 day of update
        Item[] expectedDay1 = {
            new Item("+5 Dexterity Vest", 9, 19),
            new Item("Aged Brie", 1, 1),
            new Item("Elixir of the Mongoose", 4, 6),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21),
            new Item("Backstage passes to a TAFKAL80ETC concert", 9, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
            new Item("Conjured Mana Cake", 2, 4)
        };

        // Expected results after 2 days of update
        Item[] expectedDay2 = {
            new Item("+5 Dexterity Vest", 8, 18),
            new Item("Aged Brie", 0, 2),
            new Item("Elixir of the Mongoose", 3, 5),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 13, 22),
            new Item("Backstage passes to a TAFKAL80ETC concert", 8, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50),
            new Item("Conjured Mana Cake", 1, 2)
        };


        for (int i = 0; i < 2; i++) {

            app.updateQuality();

            // Validate results for each day
            if (i == 0) {
                assertItemsEqual(items, expectedDay1, "Day 1");
            } else {
                assertItemsEqual(items, expectedDay2, "Day 2");
            }

        }
    }

    /**
     * Asserts that two arrays of Items are equal in terms of their name, sellIn, and quality.
     *
     * @param actual   The actual items array.
     * @param expected The expected items array.
     * @param day      The day identifier for logging purposes.
     */
    private static void assertItemsEqual(Item[] actual, Item[] expected, String day) {
        for (int i = 0; i < actual.length; i++) {
            assert actual[i].name.equals(expected[i].name) : "Failed on " + day + ": name mismatch for item " + i;
            assert actual[i].sellIn == expected[i].sellIn : "Failed on " + day + ": sellIn mismatch for item " + i;
            assert actual[i].quality == expected[i].quality : "Failed on " + day + ": quality mismatch for item " + i;
        }
    }
}
