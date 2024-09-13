package com.gildedrose.updaters;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.gildedrose.Item;

/**
 * Class responsible for updating the properties of Legendary items. Legendary
 * items never change.
 */
public class LegendaryItemUpdater implements ItemUpdater {

    Logger logger = Logger.getLogger(ConjuredItemUpdater.class.getName());

    @Override
    public void update(Item item) {
        // Legendary items never change
        if (item.quality != 80) {
            logger.log(Level.WARNING,
                    "Quality of the " + item.name + " is not 80 should never happened for legendary item");
        }
    }
}
