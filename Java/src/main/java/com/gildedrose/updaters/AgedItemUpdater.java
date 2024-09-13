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
