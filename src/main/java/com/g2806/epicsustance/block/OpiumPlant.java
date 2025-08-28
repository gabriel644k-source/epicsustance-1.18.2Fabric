package com.g2806.epicsustance.block;

import net.minecraft.item.ItemConvertible;
import com.g2806.epicsustance.init.ItemRegistry;

public class OpiumPlant extends DrugPlant {
    public OpiumPlant() {
        super(null, null); // Will be set later to avoid circular dependency
    }
    
    @Override
    protected ItemConvertible getSeedsItem() {
        return ItemRegistry.SEED_OPIUM;
    }
    
    @Override
    protected ItemConvertible getCropItem() {
        return ItemRegistry.ITEM_OPIUM;
    }
}