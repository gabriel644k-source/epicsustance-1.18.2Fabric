package com.g2806.epicsustance.block;

import net.minecraft.item.ItemConvertible;
import com.g2806.epicsustance.init.ItemRegistry;

public class CocainePlant extends DrugPlant {
    public CocainePlant() {
        super(null, null); // Will be set later to avoid circular dependency
    }
    
    @Override
    protected ItemConvertible getSeedsItem() {
        return ItemRegistry.SEED_COCAINE;
    }
    
    @Override
    protected ItemConvertible getCropItem() {
        return ItemRegistry.ITEM_COCAINE;
    }
}