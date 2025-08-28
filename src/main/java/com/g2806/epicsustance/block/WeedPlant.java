package com.g2806.epicsustance.block;

import net.minecraft.item.ItemConvertible;
import com.g2806.epicsustance.init.ItemRegistry;

public class WeedPlant extends DrugPlant {
    public WeedPlant() {
        super(null, null); // Will be set later to avoid circular dependency
    }
    
    @Override
    protected ItemConvertible getSeedsItem() {
        return ItemRegistry.SEED_WEED;
    }
    
    @Override
    protected ItemConvertible getCropItem() {
        return ItemRegistry.ITEM_WEED;
    }
}